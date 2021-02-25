import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import "./assets/base.less";
import message from "@/components/common/Message.js";
import _ from "lodash";
import clipboard from 'clipboard';
import JSEncrypt from "jsencrypt";
const encrypt = new JSEncrypt();
import store from './store';
// 全局挂载
Vue.prototype.$store = store;

// 误发布
Vue.config.productionTip = false;

// 消息提示框挂载到全局
Vue.prototype.$message = message;

// 用户信息挂载到全局
// const fnGetUser = () => {
//   let user = localData("poUserName", false);
//   if (user != null) return user;
//   return { userName: "" };
// };
// Vue.prototype.$user = fnGetUser();

// 根目录
Vue.prototype.$baseUrl =
  window.location.protocol + "//" + window.location.host + "/";

// lodash
Vue.prototype._ = _;

// RSA
Vue.prototype.$rsa = encrypt;
// Vue.prototype.$privateKey = "";
// Vue.prototype.$publicKey = "";

// 内容复制
Vue.prototype.$clipboard = clipboard;

// 修改的内容
Vue.prototype.$editItem = {};


// Vue对象
new Vue({
  router,
  render: function (h) {
    return h(App);
  },
}).$mount("#app");
