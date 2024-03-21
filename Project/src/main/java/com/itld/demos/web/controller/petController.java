package com.itld.demos.web.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itld.demos.web.dao.Admin;
import com.itld.demos.web.dao.Pet;
import com.itld.demos.web.mapper.petMapper;
import com.itld.demos.web.service.petService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/pet")
public class petController {
    @Autowired(required = false)
    private petService petService;
    @Autowired(required = false)
    private petMapper petMapper;
    //查询所有
    @GetMapping("/selectAll")
    public List<Pet> selectAll(){
       return petService.list();
    }
    //插入数据和编辑数据
    @PostMapping("/save")
    //@RequestBody 用于将前端传来的json数据改成java的对象类型
    public boolean save(@RequestBody  Pet pet){
        return petService.saveOrUpdate(pet);
    }
    @PostMapping("/saveUser")
    //@RequestBody 用于将前端传来的json数据改成java的对象类型
    public boolean saveUser(@RequestBody  Pet pet){
        return petService.saveUser(pet);
    }
    @PostMapping("/saveSubmit")
    public boolean saveSubmit(@RequestBody Pet pet){ return  petMapper.saveSubmit(pet);}
    @PostMapping("/updateUser")
    //@RequestBody 用于将前端传来的json数据改成java的对象类型
    public boolean updateUser(@RequestBody  Pet pet){
        return petMapper.updated(pet);
    }
    @PostMapping("/AddUser")
    public boolean addUser(@RequestBody Pet pet){ return petService.addUser(pet);}
    //删除单个数据
    @DeleteMapping("/deleteOne/{id}")
    public boolean deleteOne(@PathVariable  Integer id){
        return petService.removeById(id);
    }
    //批量删除多个数据
    @PostMapping("/deleteByIds/")
    public boolean deleteByIds(@RequestBody List<Integer> ids){
        return petService.removeByIds(ids);
    }
    //分页查询
    @GetMapping("/page")
    public IPage<Pet> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                               @RequestParam String ownername){
        QueryWrapper<Pet> queryWrapper =  new QueryWrapper<>();
        IPage res;
        if(!ownername.isEmpty()){
            // 检索
            queryWrapper.like("ownername",ownername);
            res=petService.page(new Page<>(1,pageSize),queryWrapper);
        }
        else res=petService.page(new Page<>(pageNum,pageSize),queryWrapper);
        return res;
    }
    //登录验证
    @PostMapping("/login")
    public boolean login(@RequestBody  Pet pet){
        System.out.println(pet);
        String ownername = pet.getOwnername();
        String password = pet.getPassword();
        if(ownername==""||ownername==null||password==""||password==null){
            return false;
        }
        return (petService.login(pet)!=null);
    }
    //导出功能
    @GetMapping("/export")
    public void export(HttpServletResponse response)  throws Exception{

        // 获取数据集合
        List<Pet> list = petService.list();

        ExcelWriter writer = ExcelUtil.getWriter(true);
        // 生成标题行

        writer.addHeaderAlias("id","宠物编号");
        writer.addHeaderAlias("petname","宠物名称");
        writer.addHeaderAlias("sex","性别");
        writer.addHeaderAlias("species","种类");
        writer.addHeaderAlias("ownername","顾客");
        writer.addHeaderAlias("phone","电话");
        writer.addHeaderAlias("address","地址");


        writer.write(list,true);



        response.setContentType("application/vnd.vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("宠物信息表","UTF-8");
        response.setHeader("Content-Disposition","attachment;fileName=" + fileName+".xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out,true);
        out.close();
        writer.close();
    }
    @GetMapping("/Export")
    public void Export(HttpServletResponse response)  throws Exception{

        // 获取数据集合
        List<Pet> list = petService.list();

        ExcelWriter writer = ExcelUtil.getWriter(true);
        // 生成标题行

        writer.addHeaderAlias("id","订单编号");
        writer.addHeaderAlias("petname","宠物名称");
        writer.addHeaderAlias("sex","性别");
        writer.addHeaderAlias("species","种类");


        writer.write(list,true);



        response.setContentType("application/vnd.vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("宠物信息表","UTF-8");
        response.setHeader("Content-Disposition","attachment;fileName=" + fileName+".xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out,true);
        out.close();
        writer.close();
    }
    //根据用户的用户名来获取数据库中的数据
    @GetMapping("/ownername/{ownername}")
    public Pet selectByName(@PathVariable String ownername){
        QueryWrapper<Pet> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ownername",ownername);
       return petService.getOne(queryWrapper);
    }

}
