package com.itld.demos.web.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Pet {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String petname;
    private String sex;
    private String species;
    private String ownername;
    private String password;

    private String phone;
    private String address;

    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Pet(Integer id, String petname, String sex, String species, String ownername, String password, String phone, String address, String avatar) {
        this.id = id;
        this.petname = petname;
        this.sex = sex;
        this.species = species;
        this.ownername = ownername;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.avatar = avatar;
    }

    public Pet() {

    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", petname='" + petname + '\'' +
                ", sex='" + sex + '\'' +
                ", species='" + species + '\'' +
                ", ownername='" + ownername + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
