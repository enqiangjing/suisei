<template>
  <div class="login">
    <div class="logo sc-display">
      <div class="logo-img sc-display br-8" @click="fnToMain">
        <img src="@/assets/lt.png" />
        <span class="fs-20 fw-6 ls-2">在线密码管理系统</span>
      </div>
    </div>
    <Box />
    <Bootom />
  </div>
</template>

<script>
// @ is an alias to /src
import Box from "@/components/Pages/Login/Box.vue";
import Bootom from "@/components/Pages/Details/Bottom.vue";

export default {
  name: "Login",
  components: {
    Box,
    Bootom,
  },
  methods: {
    fnToMain() {
      if (this.$store.state.isLogin)
        return this.$router.push(
          "/home/" + this.$store.state.userName + "/main"
        );
      this.$message.run("请先登录！", "error");
    },
  },
};
</script>

<style lang="less" scoped>
@bg-s: center;

.login {
  position: relative;
  height: 100%;
  width: 100%;
  background: url(../assets/logo.png) no-repeat top center;
}

.logo {
  height: 80px;
  padding: 0 0 0 20px;

  .logo-img {
    padding: 5px;
    cursor: pointer;

    img {
      width: 32px;
      margin-right: 10px;
    }

    span {
      color: #409eff;
    }

    &:hover {
      box-shadow: 0 0 6px #aaa;
    }
  }
}
</style>
