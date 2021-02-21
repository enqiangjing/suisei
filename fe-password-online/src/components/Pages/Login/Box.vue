<template>
  <div class="box ce-display">
    <div class="outside">
      <div class="top cc-display">
        <img src="@/assets/img/login/user.svg" alt="top" />
      </div>
      <div class="item cs-display">
        <LoginInput
          type="email"
          class="input"
          v-model="userName"
          placeholder="请输入用户名"
        />
      </div>
      <div class="item cs-display">
        <LoginInput
          type="password"
          class="input"
          v-model="password"
          placeholder="请输入密码"
        />
      </div>
      <div class="item cc-display">
        <Button @click="fnLogin">登录</Button>
      </div>
    </div>
  </div>
</template>

<script>
import LoginInput from "@/components/common/LoginInput.vue";
import Button from "@/components/common/Button.vue";
import { post_ } from "@/http/api.js";
import { localStore, localData } from "@/http/store.js";

export default {
  name: "Box",
  components: {
    LoginInput,
    Button,
  },
  props: {
    msg: String,
  },
  data() {
    return { userName: "", password: "" };
  },
  methods: {
    // 登录请求发送
    fnLogin() {
      let userName = this.userName;
      if (userName === "") {
        this.$message.run("用户名未输入！", "warning");
        return;
      }
      let password = this.password;
      if (password === "") {
        this.$message.run("密码未输入！", "warning");
        return;
      }
      post_("login", {
        userName: "jing",
        password: "jing",
      }).then((res) => {
        // 用户信息挂载到全局
        localStore("user", res);
        this.$user = res;
        // 路由跳转
        this.$router.push("/home/" + res.userName + "/main");
      });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
.box {
  width: 100%;
  height: 50%;
  background-color: rgab(255, 255, 255, 0.5);

  .outside {
    width: 50%;
    max-width: 600px;
    min-width: 500px;
    height: 70%;
    min-height: 400px;
    background-color: rgba(250, 250, 250, 0.875);
    border-radius: 10px;

    .top {
      height: 50%;
      overflow: hidden;

      img {
        width: 160px;
        height: 160px;
        border-radius: 80px;
        background-color: #eee;
      }
    }

    .item {
      height: 15%;

      .input {
        width: 80%;
        height: 50px;
      }
    }
  }
}
</style>
