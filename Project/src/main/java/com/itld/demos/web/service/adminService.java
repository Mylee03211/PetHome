package com.itld.demos.web.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itld.demos.web.dao.Admin;
import com.itld.demos.web.dao.Pet;
import com.itld.demos.web.mapper.adminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminService extends ServiceImpl<adminMapper,Admin> {
    @Autowired(required = false)
    private adminMapper adminMapper;
    public boolean saveAdmin(Admin admin){
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",admin.getUsername());
        queryWrapper.eq("password",admin.getPassword());
//        System.out.println(saveOrUpdate(admin));
        Integer selectCount = adminMapper.selectCount(queryWrapper);
        if(selectCount>0){
            return false;
        }else {
            System.out.println(saveOrUpdate(admin));
            return  saveOrUpdate(admin);
        }
    }
    public boolean login(Admin admin) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",admin.getUsername());
        queryWrapper.eq("password",admin.getPassword());
        Admin one = getOne(queryWrapper);
        return one !=null;
    }
}
