<template>
  <div class="login">
    <Box />
  </div>
</template>

<script>
// @ is an alias to /src
import Box from "@/components/Pages/Login/Box.vue";

export default {
  name: "Login",
  components: {
    Box,
  },
};
</script>

<style lang="less" scoped>
@bg-s: center;

.login {
  height: 100%;
  width: 100%;
  background: url(../assets/logo.png) no-repeat top center;
}
</style>