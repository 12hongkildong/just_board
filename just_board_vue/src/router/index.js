import { createRouter, createWebHistory } from 'vue-router'
import Main from '../components/login/Main.vue'
import BoardList from '../components/board/List.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'main',
      component: Main
    },
    {
      path: '/board',
      name: 'board',
      component: BoardList
    }
  ]
})

export default router
