package com.itld.demos.web.dao;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("file")
public class Files {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;

    public Files(Integer id, String name, String type, long size, String url) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.url = url;
    }

    private String type;
    private long size;
    private String url;


    public Files() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
