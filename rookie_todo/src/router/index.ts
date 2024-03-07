import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '',
      name: 'home',
      component:()=>import("../views/home.vue"),
      children:[{
        path:"/event",
        name:"event",
        component:()=>import("../components/event.vue")
      }]
    },
  ]
})

export default router
