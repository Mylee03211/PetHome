package com.itld.demos.web.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itld.demos.web.dao.Files;
import com.itld.demos.web.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
@Service
public class fileService extends ServiceImpl<FileMapper,Files> {
    @Autowired(required = false)
    private FileMapper fileMapper;
    public boolean saveFile(Files files){
        return save(files);
    }
}
