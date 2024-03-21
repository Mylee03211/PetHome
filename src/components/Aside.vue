<template>
    <el-menu :default-openeds="['1', '3']" style="min-height: 100vh; overflow: hidden;" text-color="white"
        background-color="#f1a951" active-text-color="white" :collapse-transition="false"
        router
        >
        <div style="height: 60px;line-height: 60px; text-align: center;">
            <b style="color: white"><i class="el-icon-user"></i>后台管理员系统</b>
        </div>
            <el-menu-item index="/"><i class="el-icon-house"></i>主页</el-menu-item>
        <el-submenu index="2">
          <template slot="title"><i class="el-icon-message"></i>服务管理</template>
          <el-menu-item-group>
            <el-menu-item index="/ManaView">用户管理</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title"><i class="el-icon-menu"></i>宠物管理</template>
          <el-menu-item-group>
            <el-menu-item index="/SetPet">寄养宠物管理</el-menu-item>
            <el-menu-item index="/UserMana">领养宠物管理</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-menu-item index="/Admin"><i class="el-icon-user"></i>个人信息</el-menu-item>
      </el-menu>
</template>
<script>
    export default{
        name:'Aside',
        data(){
            return{
              
            }

        }
    }
</script>