import { createRouter, createWebHistory } from 'vue-router'
import Login from '../components/Login/LoginMain.vue'
import Board from '../components/Board/BoardMain.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/board',
      name: 'board',
      component: Board
    }
  ]
})

export default router
