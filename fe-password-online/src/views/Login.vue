<template>
  <div class="login">
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
</style>
