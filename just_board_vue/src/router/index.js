import { createRouter, createWebHistory } from 'vue-router'
import Login from '../components/Login/LoginMain.vue'
import Signup from '../components/Signup/MakeAccount.vue'

import Board from '../components/Board/BoardMain.vue'
  import Detail from '../components/Board/Detail.vue'
  import Write from '../components/Board/Write.vue'
  import Update from '../components/Board/Update.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login,
      children:[
        // {
        //   path: 'signup',
        //   name: 'signup',
        //   component: Signup
        // },
      ]
    },
    {
      path: '/board',
      name: 'board',
      component: Board,
      children:[
        {
          path: ':id', 
          component:Detail,
          name:'detail',
          props: true,
        },
      ]
    },
    {
      path: '/write',
      name: 'write',
      component: Write,
      props:true,
    },
    {
      path: '/update',
      name: 'update',
      component: Update,
      props:true,
    },
    {
      path: '/signup',
      name: 'signup',
      component: Signup
    },
    {    // 경로에 없는 url적으면 무조건 게시판으로 넘기기
      path: '/:pathMatch(.*)*',
      name: 'NotFound',
      component: Board
    },
    // {
    //       path: '/:id', 
    //       component:Detail,
    //       name:'detail',
    //       props: true,
    // },
  ]
})

export default router
