package com.itld.demos.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itld.demos.web.dao.Admin;
import org.apache.ibatis.annotations.Mapper;

public interface adminMapper extends BaseMapper<Admin> {
    boolean UpdateAvatar(Admin saveFile);

    void update(Admin admin);

    boolean updated(Admin admin);
}
