package com.itld.demos.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itld.demos.web.dao.Admin;
import com.itld.demos.web.dao.Pet;
import com.itld.demos.web.mapper.adminMapper;
import com.itld.demos.web.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class adminController {
    @Autowired(required = false)
    private adminService adminService;
    @Autowired(required = false)
    private adminMapper adminMapper;
//增改
    @PostMapping("/save")
    public boolean save(@RequestBody Admin admin){
//        System.out.println(admin);
        return adminService.saveAdmin(admin);
    }
    @PostMapping("/login")
    public boolean login(@RequestBody  Admin admin){
        String username = admin.getUsername();
        String password = admin.getPassword();
        if(username==""||username==null||password==""||password==null){
            return false;
        }
        return adminService.login(admin);
    }

    @GetMapping("/username/{username}")
    public Admin selectByName(@PathVariable String username){
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        return adminService.getOne(queryWrapper);
    }
    @PostMapping("/updateAdmin")
    //@RequestBody 用于将前端传来的json数据改成java的对象类型
    public boolean updateUser(@RequestBody  Admin admin){
        System.out.println(admin);
        return adminMapper.updated(admin);
    }
}
