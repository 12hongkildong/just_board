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
    // {
    //       path: '/:id', 
    //       component:Detail,
    //       name:'detail',
    //       props: true,
    // },
  ]
})

export default router
