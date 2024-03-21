<template>
      <el-menu :default-active="$router.path" class="el-menu-demo" mode="horizontal" background-color="#545c64" v-loading="loading"
               text-color="#fff" active-text-color="#ffd04b"  router>
        <el-menu-item index="/UserView/CenterView" >动物服务中心</el-menu-item>
        <el-submenu index="2"class="menuitem" >
          <template slot="title">我的</template>
          <el-menu-item index="/UserView/OrderInformation" >查看订单</el-menu-item>
        </el-submenu>
        <el-submenu index="3" class="menuitem">

          <template slot="title">领养</template>
          <el-menu-item index="/UserView/Getchongwu" >查看我们可领养的宠物</el-menu-item>
          <el-menu-item index="#">领养方法</el-menu-item>
          <el-menu-item index="#">新宠物资源</el-menu-item>
          <el-menu-item index="#">Cats safe at home</el-menu-item>
          <el-menu-item index="#">快乐领养</el-menu-item>
          <el-menu-item index="#">Kitties for hire计划</el-menu-item>
        </el-submenu>
        <el-submenu index="4" class="menuitem">

          <template slot="title" >走失和寻回</template>
          <el-menu-item index="/UserView/Missandfind">走失宠物的资源</el-menu-item>
          <el-menu-item index="#">搜索发现的宠物</el-menu-item>
          <el-menu-item index="#">搜索走失的宠物</el-menu-item>
          <el-menu-item index="#">已找回宠物的资源</el-menu-item>
          <el-menu-item index="#">Resources for Found Kittens</el-menu-item>
        </el-submenu>
        <el-submenu index="5" class="menuitem">

          <template slot="title">办证</template>
          <el-menu-item index="/UserView/Card" >购买许可证</el-menu-item>
          <el-menu-item index="#">购买更换宠物牌</el-menu-item>
          <el-menu-item index="#">办证信息</el-menu-item>
          <el-menu-item index="#">更改许可证信息</el-menu-item>
          <el-menu-item index="#">办证地点</el-menu-item>
          <el-menu-item index="#">对设施的许可</el-menu-item>
          <el-menu-item index="#">牲畜登记</el-menu-item>
        </el-submenu>
        <el-submenu index="6" class="menuitem">

          <template slot="title">动物保护</template>
          <el-menu-item index="/UserView/Protect" >应急响应和救援</el-menu-item>
          <el-menu-item index="#">Heat protection</el-menu-item>
          <el-menu-item index="#">对动物的控诉和动物滋扰</el-menu-item>
          <el-menu-item index="#">调查和现场服务</el-menu-item>
          <el-menu-item index="#">法规</el-menu-item>
          <el-menu-item index="#">支付罚款</el-menu-item>
          <el-menu-item index="#">Public Appeal Hearings</el-menu-item>
          <el-menu-item index="#">Living with Wildlife</el-menu-item>
        </el-submenu>
        <el-submenu index="7" class="menuitem">

          <template slot="title">志愿者</template>
          <el-menu-item index="/UserView/Volunteer" >志愿者信息</el-menu-item>
          <el-menu-item index="#">寄养信息</el-menu-item>
          <el-menu-item index="#">社会咨询委员会</el-menu-item>
          <el-menu-item index="#">本月优秀志愿者</el-menu-item>
        </el-submenu>
        <el-submenu index="8" class="menuitem">

          <template slot="title" >关于我们</template>
          <el-menu-item index="/UserView/Aboutus" >组织介绍</el-menu-item>
          <el-menu-item index="#">时间和地点</el-menu-item>
          <el-menu-item index="#">联系我们</el-menu-item>
          <el-menu-item index="#">月度报告</el-menu-item>
          <el-menu-item index="#">常见问答</el-menu-item>
          <el-menu-item index="#">关于公开记录要求</el-menu-item>
          <el-menu-item index="#">公共记录要求</el-menu-item>
          <el-menu-item index="#">工作机会</el-menu-item>
        </el-submenu>
        <div class="demo-type" @click="changeInfo">
          <el-avatar >
            <img :src="headerurl"/>
          </el-avatar>
        </div>
        <template slot-scope="{type,size,row,index}" slot="menu"></template>
        <el-dialog title="个人信息" :visible.sync="dialogFormVisible" width="30%">
          <center>
            <el-avatar :size="80">
              <img :src="this.form.avatar"/>
            </el-avatar>
            <el-upload class="upload-demo" action="http://localhost/upload"
                       :data="form"
                       :on-preview="handlePreview" :on-remove="handleRemove" :before-remove="beforeRemove" multiple
                       :limit="1" :on-exceed="handleExceed" >
              <el-button size="small" type="primary">上传头像</el-button>
              <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
            </el-upload>
          </center>
          <el-form :model="form">
            <el-form-item label="用户名">
              <el-input v-model="form.ownername" autocomplete="off" disabled></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input v-model="form.password" autocomplete="off" disabled></el-input>
            </el-form-item>
            <el-form-item label="电话">
              <el-input v-model="form.phone" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="地址">
              <el-input v-model="form.address" autocomplete="off"></el-input>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>

            <el-button type="primary" @click="updateInfo">修 改</el-button>
          </div>
        </el-dialog>
      </el-menu>

</template>

<script>
import request from "@/utils/request";

export default {
  name: "Stone",
  data() {
    return {
      activeIndex: '1',
      activeIndex2: '1',
      dialogFormVisible: false,
      form: {},
      gridData: [{
        date: '星期一',
        name: '11:00 am - 5:30 pm',
      }, {
        date: '星期二',
        name: '11:00 am - 5:30 pm',
      }, {
        date: '星期三',
        name: '1:00 pm - 4:30 pm',
      }, {
        date: '星期四',
        name: '11:00 am - 5:30 pm',
      }, {
        date: '星期五',
        name: '11:00 am - 5:30 pm',
      }, {
        date: '星期六',
        name: '1:00 pm - 4:30 pm',
      }],
      list: [
        { img: 'https://img.zcool.cn/community/0134315949d739a8012193a31be473.png@1280w_1l_2o_100sh.png' },
        { img: 'https://img.zcool.cn/community/01395f55bc7aa16ac7253f36496ae4.jpg@1280w_1l_2o_100sh.jpg' },
        { img: 'https://5b0988e595225.cdn.sohucs.com/images/20190418/1f14e13ab4bf491ba8e0af05ab27ea74.jpg' },
        { img: 'https://x0.ifengimg.com/res/2021/722EF768417624A19E5622581FFF8826F80F2976_size26_w600_h338.jpeg' },
        { img: 'https://tse2-mm.cn.bing.net/th/id/OIP-C.tvPHbhuvJ6YRBBpJvmbVYQHaE7?pid=ImgDet&w=474&h=315&rs=1' },
      ],
      dialogFormVisible1: false,
      form: {
        petname: "",
        sex: "",
        species: "",
        ownername: "",
        password: "",
        phone: "",
        address: "",
        avatar:"",
      },
      fileList: [
        { name: '', url: '' },
      ],
      loading: true,
      reloading:false,
      headerurl:"",
      user: localStorage.getItem("data")?JSON.parse(localStorage.getItem("data")):{}
    }
  },
  created() {
    setTimeout(() => {
      this.loading = false;
    }, 1000);
    // let data = JSON.parse(localStorage.getItem('data'));
    // this.form = data;
    const ownername = this.user.ownername;
    if(!ownername){
      this.$message.error("当前无法获取用户名信息");
      return
    }
    request.get("http://localhost/pet/ownername/" + ownername).then(res=>{
      this.form = res;
      this.headerurl = res.avatar;
      console.log(this.form);
    })
  },
  methods: {
    changeInfo() {
      //
      this.dialogFormVisible = true;
      this.headerurl = this.form.avatar;
      alert("此处信息将会与申请表共用，请您认真填写!");
    },
    addSubmit() {
      this.dialogFormVisible1 = true;
      alert("为了方便与您联系，请你务必填写电话一栏!");
    },
    updateInfo() {
      this.dialogFormVisible = false;
      if (this.form.phone != null && this.form.phone != "") {
        request.post("http://localhost/pet/updateUser", this.form).then(res => {
          if (res) {
            this.dialogFormVisible = false;
            this.$message.success("操作成功!");
            location.reload();
          } else {
            this.$message.error("操作失败!")
          }
        })
      }
    },
    submit() {
      if (this.form.petname != "" && this.form.petname != null &&
          this.form.sex != "" && this.form.sex != null &&
          this.form.species != "" && this.form.species != null &&
          this.form.ownername != "" && this.form.ownername != null &&
          this.form.phone != "" && this.form.phone != null &&
          this.form.address != "" && this.form.address != null
      ) {
        request.post("http://localhost/pet/updateUser", this.form).then(res => {
          if (res) {
            this.dialogFormVisible1 = false;
            this.$message.success("提交成功!请等待回应。");
            this.form.petname = "";
            this.form.sex = "";
            this.form.species = "";
          } else {
            this.$message.error("提交失败!")
          }
        })
      } else {
        this.$message.warning("请填写完整!")
      }
    },
    exit() {
      this.$router.push("/User");
      this.$message.success("退出成功!");
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, fileList) {
      this.$message.warning(`当前限制选择 1 个文件`);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    }
  }
  }

</script>



<style scoped>
.back {
  background-color: #EBEEF5;
}

a {
  text-decoration-color: orangered;
  color: black;
}

a:hover {
  background-color: orangered;
  color: white;
}

.part5>div {
  background-color: white;
  width: 45%;
  height: 400px;
  /*position: relative;*/
}

.el-menu-demo {
  position: fixed;
  width: 100%;
  z-index: 2;
}

.demo-type {
  position: fixed;
  right: 2%;
  margin-top: 10px;
  cursor: pointer;
  z-index: 2;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 400px;
  margin: 0;
}

.menuitem{
  width:10%;
}

</style>