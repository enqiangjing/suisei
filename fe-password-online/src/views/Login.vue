<template>
  <div class="login">
    <div class="logo sc-display">
      <img src="@/assets/lt.png" />
      <span class="fs-20 fw-6 ls-2">在线密码管理系统</span>
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
  width: 300px;
  height: 80px;
  padding: 0 0 0 20px;

  img {
    width: 32px;
    margin-right: 10px;
  }

  span {
    color: #409eff;
  }
}
</style>
