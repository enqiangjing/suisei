import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'

Vue.use(VueRouter)

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
        path: '/details/',
        name: 'Details',
        component: function () {
          return import(/* webpackChunkName: "details" */ '../views/Details.vue')
        },
        children: [
          {
            path: 'item',
            name: 'Item',
            component: function () {
              return import(/* webpackChunkName: "detailsItem" */ '../components/Pages/Details/Item.vue')
            },

          }
        ],
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
