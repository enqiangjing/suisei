<template>
  <div id="app">
    <transition>
      <router-view />
    </transition>
  </div>
</template>

<script>
import { localData } from "@/http/store.js";

export default {
  created() {
    // 获取本地用户信息
    let user = localData("poUserInfo", false);
    // 登录判断
    if (user === undefined || user === null || user === "" || user === "null") {
      // 未登录
      console.log("用户未登录！");
    } else {
      // 登录保持状态
      this.$store.commit("upUserInfo", JSON.parse(user));
      this.$store.commit("upLogStatus", true);
      // this.$router.push("/home/" + this.$store.state.userName + "/main");
    }
  },
};
</script>

<style lang="less">
#app {
  font-family: webfont Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  height: 100%;
  width: 100%;
}
</style>
