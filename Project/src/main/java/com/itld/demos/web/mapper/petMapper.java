package com.itld.demos.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itld.demos.web.dao.Pet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface petMapper extends BaseMapper<Pet> {
    boolean UpdateAvatar(Pet saveFile) ;

    //    @Update("update pet set")
    boolean updated(Pet pet);

    boolean savePet(Pet pet);
    boolean saveSubmit(Pet pet);
}
