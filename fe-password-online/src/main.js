import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import "./assets/base.less";
import message from "@/components/common/Message.js";
import { localData } from "@/http/store.js";
import _ from "lodash";

// 误发布
Vue.config.productionTip = false;

// 消息提示框挂载到全局
Vue.prototype.$message = message;

// 用户信息挂载到全局
const fnGetUser = () => {
  let user = localData("user");
  if (user != null) return user;
  return { userName: "" };
};
Vue.prototype.$user = fnGetUser();

// 根目录
Vue.prototype.$baseUrl =
  window.location.protocol + "//" + window.location.host + "/";

// lodash
Vue.prototype._ = _;

// Vue对象
new Vue({
  router,
  render: function (h) {
    return h(App);
  },
}).$mount("#app");
