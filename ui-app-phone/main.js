import Vue from 'vue'
import App from './App'
import store from './store'
import _ from "./utils/lodash.js";
import JSEncrypt from "./utils/jsencrypt.js"
const encrypt = new JSEncrypt()

Vue.config.productionTip = false

// 根目录
Vue.prototype.$baseUrl = "http://212.64.59.206:9602/"
// Vue.prototype.$baseUrl = "http://localhost:8080/"

// 全局挂载
Vue.prototype.$store = store

// RSA
Vue.prototype.$rsa = encrypt;

// lodash
Vue.prototype._ = _;

App.mpType = 'app'

const app = new Vue({
	store,
	...App
})
app.$mount()
