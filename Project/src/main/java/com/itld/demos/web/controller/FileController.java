package com.itld.demos.web.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itld.demos.web.dao.Files;
import com.itld.demos.web.mapper.FileMapper;
import com.itld.demos.web.service.fileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

//文件上传相关接口\
@RestController
@RequestMapping("/file")
public class FileController {
//    @Value("${files.upload.path}")
    private String fileUploadPath = "D:\\HuaQing\\pro\\src\\PetPhoto\\";
    @Resource
    private FileMapper fileMapper;
    @Autowired(required = false)
    private fileService fileService;
    @PostMapping("/upload")
    public int upload(@RequestParam MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileType = FileUtil.extName(fileName);
        fileName = fileName.substring(0,fileName.lastIndexOf('.'));
        long fileSize = file.getSize();
        //先存储到本地磁盘里
             File uploadParentFile = new File(fileUploadPath);

             if(!uploadParentFile.exists()){
                 uploadParentFile.mkdir();
             }
            String uid = IdUtil.fastSimpleUUID();
             String fileUid = uid + StrUtil.DOT + fileType;
            File uploadFile = new File(fileUploadPath + fileUid);

            //把获取到的文件存储到磁盘目录里面
            file.transferTo(uploadFile);
            String url = "http://localhost/file/" + fileUid;
            //存储数据库
            Files saveFile = new Files();
            saveFile.setName(fileName);
            saveFile.setSize(fileSize);
            saveFile.setType(fileType);
            saveFile.setUrl(url);
            return fileMapper.insert(saveFile);
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

    @GetMapping("/page")
    public IPage<Files> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        QueryWrapper<Files> queryWrapper =  new QueryWrapper<>();
        IPage res =fileService.page(new Page<>(pageNum,pageSize),queryWrapper);;
        return res;
    }
    @DeleteMapping("/deleteOne/{id}")
    public boolean deleteOne(@PathVariable  Integer id){
        return fileService.removeById(id);
    }

    //批量删除多个
    @PostMapping("/deleteByIds/")
    public boolean deleteByIds(@RequestBody List<Integer> ids){
        return fileService.removeByIds(ids);
    }
    @GetMapping("/getAll")
    public List<Files> files(){
        QueryWrapper<Files>queryWrapper = new QueryWrapper<>();
        return fileMapper.selectList(queryWrapper);
    }
}
