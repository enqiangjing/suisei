import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'

Vue.use(VueRouter)

// 路由模式
const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login,
  },
  {
    path: '/home/:content',
    name: 'Home',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "home" */ '../views/Home.vue'),
    children: [
      {
        path: 'main',
        name: 'HomeMain',
        component: () => import(/* webpackChunkName: "homeMain" */ '../components/Pages/Home/Main.vue'),
      },
      {
        path: 'content',
        name: 'HomeContent',
        component: () => import(/* webpackChunkName: "homeContent" */ '../components/Pages/Home/Content.vue'),
      },
      {
        path: 'edit',
        name: 'HomeContentEdit',
        component: () => import(/* webpackChunkName: "homeContentEdit" */ '../components/Pages/Home/Content.vue'),
      },
      {
        path: 'cipher',
        name: 'HomeCipher',
        component: () => import(/* webpackChunkName: "homeCipher" */ '../components/Pages/Home/Cipher.vue'),
      },
    ]
  },
]

// 初始化路由对象
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 路由守卫
// router.beforeEach((to, from, next) => {
//   // ...
//   console.log(to);
//   // console.log(from);
//   // next();
// })

export default router
