<template>

<div v-loading="reloading">

    <el-main class="part2">
      <div style="width: 100%;font-size: 30px;font-family: monospace;">
        <p style="margin-top: 40px;margin-bottom:15px;border-bottom: 2px solid orange;">寄养者申请</p>
      </div>
      <p style="margin-top: 5px;">自己太忙抽不出时间照顾？如何您有意寄养，首先请填写“寄养者”申请表，或者详细了解以下有关寄养职责及资源的更多信息。</p>
      <el-button type="warning"
                 style="height: 60px; width: 20%;border-radius: 15px; font-size: 20px;margin-top: 25px;"
                 @click="addSubmit">提交申请
        <i class="el-icon-caret-right"></i></el-button>
      <el-dialog title="请填写相关信息" :visible.sync="dialogFormVisible1" width="30%">
        <el-form :model="form">
          <el-form-item label="要寄养的宠物">
            <el-input v-model="form.petname" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-input v-model="form.sex" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="种类">
            <el-input v-model="form.species" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="寄养人(与您的用户名一致)" >
            <el-input v-model="form.ownername" autocomplete="off" disabled></el-input>
          </el-form-item>
          <el-form-item label="电话">
            <el-input v-model="form.phone" autocomplete="off" disabled></el-input>
          </el-form-item>
          <el-form-item label="家庭地址">
            <el-input v-model="form.address" autocomplete="off" disabled></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible1 = false">取 消</el-button>
          <el-button type="primary" @click="submit">确 定</el-button>
        </div>
      </el-dialog>
    </el-main>
    <el-main class="part3">
      <el-carousel :interval="5000" arrow="always" style="height: 300px;">
        <el-carousel-item v-for="item in list" :key="item">
          <img class="img" :src="item.img" width="100%" height="400px">
        </el-carousel-item>
      </el-carousel>
    </el-main>
    <el-main class="part4">
      <div style="width: 45%;font-family:'Times New Roman', Times, serif; margin-top:25px" >
        <p>无法抽出时间陪伴它们？ 想照顾它们，但自己无能为力？ 我们为动物提供庇护！</p><br>
        <p style="font-size: 30px; color: gray;">寄养种类</p><br>
        <b style="font-size: 24px;">*瓶婴小猫——</b>我们收到了很多小猫（极少数情况下是小狗），因为太小不能自己吃东西，需要奶瓶喂养。 这是费时但非常有成就感的工作！<br>
        <b style="font-size: 24px;">*小狗/小猫——</b>小狗和小猫因为太小无法做绝育，所以需要寄养到它们长大接受手术，然后它们就可以获得一些基本的训练和社会化技能。<br>
        <b style="font-size: 24px;">*带宝宝的妈妈——</b>正在哺育小猫或小狗的妈妈需要一个安静的寄养家庭，让她能放松身心并抚养她的宝宝。养育哺乳期小猫可以获得全部乐趣，工作量也会少很多！<br>
        <b style="font-size: 24px;">*医疗照护——</b>感冒、伤口正在愈合、骨折、手术康复中的动物等都需要在寄养家庭休养，远离收容所。<br>
        <b style="font-size: 24px;">*社会化——</b>许多动物在收容所环境中都会感到害怕。 寄养家庭缓慢而积极的强化作用有助于他们成功融入领养家庭。<br>
        <b style="font-size: 24px;">*暂缓——</b>在收容所待了很长一段时间的动物有时需要从压力中喘息一段时间，它们能从短短的寄养照顾中获益良多。<br>
        <b style="font-size: 24px;">*临终关怀——</b>有时，来到MCAS的老年猫狗的生活质量仍然相对较好，但 因为医疗问题（肾功能衰竭、猫白血病毒 (Feline Leukemia Virus, FIV/FeLV)）等可能不会活很久。这些动物被安置在特殊的临终关怀寄养家庭并得到医疗照顾，直到它们的生命走到尽头。<br>
        <p style="font-size: 45px; color: gray;">寄养手册和资源</p><br>
        <li><a href="#">小猫小狗寄养手册</a></li>
        <li><a href="#">狗狗寄养手册</a></li>
        <li><a href="#">猫咪寄养手册</a></li>
        <p style="font-size: 45px; color: gray;">分享手册和资源</p><br>
        <p style="font-size: 20px;">下载并打印传单，张贴在您的周边或社区热点地区。</p><i class="el-icon-download" style="cursor: pointer;"><br>
      </i>
        <a href="#">点我下载</a>
      </div>
      <div style="display: flex;margin-top:-1000px;margin-left: 690px;"><img src="../img/poster1.png" width="500px">
      </div>
    </el-main>
    <el-main class="part5">
      <div style="display: flex;flex-direction: column;">
        <h2 style="margin-left: 0px;position: absolute;display: block;width: 100%;">
          <span style="font-size: 25px;color: gray;">Staff Spotlight- Tina H. Celebrates 5 Years</span>
        </h2>
        <h2 style="margin-top: 80px;margin-left: 15px;font-size: 12px;color: gray;">
            七月.7, 2023
        </h2>
        <h2 style="margin-left: 10px;width: 100%; height: 100%;">
          <span style="font-size: 10px; font-family: 'Courier New', Courier, monospace;">
            Meet Tina H., the Foster Coordinator at Multnomah County Animal Services (MCAS), celebrating five years as a staff member. Tina was previously a Client Services Lead before being promoted in April.
          </span>
        </h2>
        <div style="position: absolute; z-index: auto;margin-left: 330px;margin-top: 55px;">
          <img src="../img/Poster2.png" width="180px">
        </div>
        <center>
          <h2 style="font-size: 10px;margin-top: 15px; font-family: 'Courier New'">--------Tag<i
              class="el-icon-paperclip"></i>---------
            <br>
            Foster &nbsp Staff &nbsp Spotlight &nbsp Volunteer
          </h2>
          <el-button type="warning" style="width: 85px;height: 40px;border-radius: 15px;">阅读更多<i
              class="el-icon-arrow-right"></i></el-button>
        </center>
      </div>
      <div style="margin-top: -800px; margin-left: 650px; display: flex;flex-direction: column;">
        <h2 style="margin-left: 15px;width: 100%;display: block;position:absolute;">
          <span style="font-size: 25px;color: gray;">Dog Foster Volunteers Needed</span>
        </h2>
        <h2 style="margin-top: 10px;margin-left: 15px;font-size: 12px;color: gray;margin-top: 80px;"><i
            class="el-icon-date"></i>四月.11, 2023
        </h2>
        <h2 style="margin-left: 15px;width: 95%;">
          <span style="font-size: 12px; font-family: 'Courier New', Courier, monospace;">
            We're looking for dog foster volunteers. Can you help dogs learn skills, come out of their shell, breathe easier, and put their best paw forward for adopters in the comfort and safety of your home?
          </span>
        </h2>
        <div style="position: absolute; margin-left: 330px;margin-top: 50px; ;float: none;clear: both" align="center">
          <img src="../img/Poster3.png" width="180px" >
        </div>
        <center>
          <h2 style="font-size: 10px;margin-top: 15px; font-family: 'Courier New'">--------Tag<i
              class="el-icon-paperclip"></i>---------
            <br>
            Foster &nbsp &nbsp Volunteer
          </h2>
          <el-button type="warning" style="width: 85px;height: 40px;border-radius: 15px;">阅读更多<i
              class="el-icon-arrow-right"></i></el-button>
        </center>
      </div>
    </el-main>
    <el-main class="underPage">
      <div style="background-color:  #E8cB8B;height: 10px;border-bottom: 1px solid white;"></div>
      <div style="background-color: #FF8c55;height: 120px;">
        <h2 style="font-size: 35px; font-family: cursive;color:ghostwhite;margin-left: -900px;padding-top: 0px;">
          Connect
          with Animal Services</h2>
        <h2
            style="font-size: 25px; font-family: cursive;color:ghostwhite;margin-left: -1000px;padding-top: 0px;">
          Follow
          us on Social Media</h2>
        <div>
          <img src="../img/twitter.png"
               style="cursor: pointer;margin-left: 100px;margin-top: 20px; border-radius: 10px;" width="30px"
               height="30p">
          <img src="../img/facebook.png" style="cursor: pointer; margin-left: 20px; border-radius: 10px;"
               width="30px" height="30p">
          <img src="../img/Camera.png" style="cursor: pointer; margin-left: 20px; border-radius: 10px;"
               width="30px" height="30p">
          <img src="../img/Wenjian.png" style="cursor: pointer; margin-left: 20px; border-radius: 10px;"
               width="30px" height="30p">
          <img src="../img/Youtub.png" style="cursor: pointer; margin-left: 20px; border-radius: 10px;"
               width="30px" height="30p">
        </div>
      </div>
      <h2 style="font-size: 35px; font-family: cursive;color:ghostwhite; margin-left: -1000px;padding-top: 0px;">
        Hours and
        Address</h2>
      <div style="margin-top: 10px;margin-left: 50px;">
        <el-popover placement="right" width="350" trigger="click">
          <el-table :data="gridData">
            <el-table-column width="150" property="date" label="星期"></el-table-column>
            <el-table-column width="200" property="name" label="时间"></el-table-column>
          </el-table>
          <el-button slot="reference">点击查看客服时间</el-button>
        </el-popover>
      </div>
      <div style="margin-left: 10px;">
                <span style="font-family: cursive;color:ghostwhite;font-size: 35px;">Address:<span
                    style="font-size: 20px;">1700
                        W Historic Columbia River Hwy, Troutdale, OR 97060</span></span>
      </div>
      <center>
        <h2 style="font-size: 15px;">©2024 Multnomah县动物服务中心 | 免责声明 | 隐私政策</h2>
      </center>
    </el-main>

</div>

</template>

<script>
import request from "@/utils/request";

export default {
  name: "Body",
  data() {
    return {

      dialogFormVisible: false,
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
      },
      fileList: [
        { name: '', url: '' },
      ],
      loading:true,
      reloading:false,
      user: localStorage.getItem("data")?JSON.parse(localStorage.getItem("data")):{}
    }
  },

  created(){
    setTimeout(()=>{
      this.loading = false;
    },1500);
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
      this.dialogFormVisible = true
    },
    addSubmit() {
      this.dialogFormVisible1 = true;
    },
    updateInfo() {
      this.dialogFormVisible = false;
    },
    submit() {
      if (this.form.petname != "" && this.form.petname != null &&
          this.form.sex != "" && this.form.sex != null &&
          this.form.species != "" && this.form.species != null &&
          this.form.ownername != "" && this.form.ownername != null&&
          this.form.phone != "" && this.form.phone != null &&
          this.form.address != "" && this.form.address != null
      ) {
        request.post("http://localhost/pet/saveSubmit", this.form).then(res => {
          if (res) {
            this.dialogFormVisible1 = false;
            this.$message.success("提交成功!请前往寄养处寄养!");
          } else {
            this.$message.error("提交失败!")
          }
        })
      } else {
        this.$message.warning("请填写完整!")
      }
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
    },



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
.part2 {
  width: 100%;
  height: 100%;
  background-color: white;
  margin-top: 10px;
  /* text-align: center; */
  border-top: 5px solid peru;
  border-left: 3px dashed bisque;
  border-right: 3px dashed bisque;
  border-bottom: 3px dashed bisque;
  position: relative;
  line-height: normal;
}

.part3 {
  margin-top: 50px;
  /* background-color: aquamarine; */
  width: 100%;
  height: 100%;
  position: relative;
  z-index: 1;
  line-height: normal;
}

.part4 {
  margin-top: -35px;
  margin-left: 120px;
  /* background-color: aqua; */
  width: 93%;
  height: 80em;
  position: relative;
  z-index: 0;
  line-height: 2;
}

.part5 {
  margin-top: 10px;
  margin-left: 120px;
  width: 85%;
  height: 100%;
  /* background-color: aqua; */
  /*position: relative;*/


}

.part5>div {
  background-color: white;
  width: 45%;
  height: 100%;
  /*position: relative;*/
  position: relative;
}

.underPage {
  background-color: #E8cB8B;
  height: 100%;
   margin-top: 10px;
  margin-bottom: 0px;
  position: relative;
  line-height: 2;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 400px;
  margin: 0;
}
</style>