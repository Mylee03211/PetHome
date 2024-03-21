package com.itld.demos.web.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itld.demos.web.dao.Admin;
import com.itld.demos.web.dao.Pet;

import com.itld.demos.web.mapper.petMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class petService extends ServiceImpl<petMapper,Pet> {
    @Autowired(required = false)
    private petMapper petMapper;

    public boolean saveUser(Pet pet){
        QueryWrapper<Pet> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ownername",pet.getOwnername());
        queryWrapper.eq("password",pet.getPassword());
        Integer selectCount = petMapper.selectCount(queryWrapper);
        if(selectCount>0){
            return false;
        }
        return saveOrUpdate(pet);
    }
    public boolean saveSubmit(Pet pet){
        QueryWrapper<Pet> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ownername",pet.getOwnername());
        Integer selectCount = petMapper.selectCount(queryWrapper);
        if(selectCount>0){
            return false;
        }
        return saveOrUpdate(pet);
    }
    public boolean addUser(Pet pet) {
        if (petMapper.insert(pet) != 0) {
            return true;
        } else
            return false;

    }


    public Pet login(Pet pet) {
        QueryWrapper<Pet> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ownername",pet.getOwnername());
        queryWrapper.eq("password",pet.getPassword());
        Pet one = getOne(queryWrapper);
        return one ;
    }
}
