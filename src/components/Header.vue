<template>
    <el-dropdown style="cursor: pointer;">
        <span style="position: fixed;right: 50px;top: 10px;">
            <el-avatar>
                <img :src="headerurl" />
            </el-avatar>
        </span>
        <el-dropdown-menu slot="dropdown" style="margin-top: 20px;margin-left: -100px;">
            <el-dropdown-item @click.native="exit">退出</el-dropdown-item>
        </el-dropdown-menu>
    </el-dropdown>
</template>

<script>
import request from '@/utils/request';
export default {
    name: 'Header',
    data() {
        return {
            user: localStorage.getItem("data")?JSON.parse(localStorage.getItem("data")):{},
            headerurl:''
        }
        
    },
    methods: {
        exit() {
            this.$router.push("/Mana");
            setTimeout(() => {
                this.$message.success("退出成功!")
            }, 1000)
        }
    },
    created(){
        const username = this.user.username;
        if(!username){
            this.$message.error("当前无法获取管理员信息!");
            return
        }
        request.get("http://localhost/admin/username/" + username).then(res=>{
            this.user = res;
            this.headerurl = res.avatar;
            console.log(this.form);
        })
    }

}
</script>