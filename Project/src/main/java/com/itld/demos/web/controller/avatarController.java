package com.itld.demos.web.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.itld.demos.web.dao.Admin;
import com.itld.demos.web.dao.Files;
import com.itld.demos.web.dao.Pet;
import com.itld.demos.web.mapper.FileMapper;
//import com.itld.demos.web.mapper.petMapper;
import com.itld.demos.web.mapper.adminMapper;
import com.itld.demos.web.mapper.petMapper;
import com.itld.demos.web.service.petService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
public class avatarController {
    @Autowired(required = false)
    private adminMapper adminMapper;
    @Autowired(required = false)
    private petMapper petMapper;
    private String fileUploadPath = "D:\\HuaQing\\pro\\src\\Avatar\\";
    @PostMapping("/upload")
    public int upload(@RequestParam MultipartFile file,@RequestParam String ownername) throws IOException {
        System.out.println(ownername);
        String fileName = file.getOriginalFilename();
        String fileType = FileUtil.extName(fileName);
        //先存储到本地磁盘里
        String uid = IdUtil.fastSimpleUUID();
        String fileUid = uid + StrUtil.DOT + fileType;
        File uploadFile = new File(fileUploadPath + fileUid);
        //把获取到的文件存储到磁盘目录里面
        file.transferTo(uploadFile);
        String url = "http://localhost/" + fileUid;
        //存储数据库
        Pet saveFile = new Pet();
        saveFile.setAvatar(url);
        saveFile.setOwnername(ownername);
        boolean b =  petMapper.UpdateAvatar(saveFile);
        if(b){
            return 1;
        }return 0;
    }
    @PostMapping("/uploadAdmin")
    public int uploadAdmin(@RequestParam MultipartFile file,@RequestParam String username) throws IOException {
        System.out.println(username);
        String fileName = file.getOriginalFilename();
        String fileType = FileUtil.extName(fileName);
        //先存储到本地磁盘里
        String uid = IdUtil.fastSimpleUUID();
        String fileUid = uid + StrUtil.DOT + fileType;
        File uploadFile = new File(fileUploadPath + fileUid);
        //把获取到的文件存储到磁盘目录里面
        file.transferTo(uploadFile);
        String url = "http://localhost/" + fileUid;
        //存储数据库
        Admin saveFile = new Admin();
        saveFile.setAvatar(url);
        saveFile.setUsername(username);
        boolean b =  adminMapper.UpdateAvatar(saveFile);
        if(b){
            return 1;
        }return 0;
    }
    @GetMapping("/{fileUid}")
    public void download(@PathVariable String fileUid, HttpServletResponse response) throws IOException {
        //根据文件的唯一标识码来获取文件
        File downloadFile = new File(fileUploadPath + fileUid);
        ServletOutputStream os = response.getOutputStream();
        //设置输出流的格式
        response.addHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileUid,"UTF-8"));
        response.setContentType("application/octet-stream");

        //读取文件的字节流
        os.write(FileUtil.readBytes(downloadFile));
        os.flush();
        os.close();
    }
}
