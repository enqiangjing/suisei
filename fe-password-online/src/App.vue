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
    this.loadKeyFromLocal();
  },
  methods: {
    // 本地加载密钥
    loadKeyFromLocal() {
      // 获取本地用户信息
      let user = localData("poUserInfo", false); // 从本地读取用户信息
      // 登录判断
      if (
        user === undefined ||
        user === null ||
        user === "" ||
        user === "null"
      ) {
        // 未登录
        console.log("用户未登录！");
      } else {
        // 登录保持状态
        this.$store.commit("upUserInfo", JSON.parse(user)); // 用户信息写入内存
        this.$store.commit("upLogStatus", true); // 用户登录状态写入内存
        this.$store.commit("upPrivateKey", localData("poPrivateKey", false)); // 私钥写入内存
        // this.$router.push("/home/" + this.$store.state.userName + "/main");
      }
    },
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
