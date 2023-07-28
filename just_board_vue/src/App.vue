<script setup>
import { RouterLink, RouterView } from 'vue-router'

</script>

<template>
  <header>
    <section class="h-28 bg-[#35469C] grid grid-cols-[minmax(26.75rem,_1fr)_66.5rem_minmax(26.75rem,_1fr)] items-center">
      <h1 class="hidden">로고</h1>
      <section class="col-start-2 grid grid-cols-2 ">
        <router-link to="/" class="text-white text-7xl  w-[21rem]">Just_Board</router-link>
        <section class="grid justify-items-end self-center">
          <h1 class="hidden">로그아웃 버튼</h1>
          <button class="text-[#35469C] text-2xl mr-[2rem] bg-white h-12 w-32 rounded-xl">로그아웃</button>
        </section>
      </section>
      <!-- <div class="text-white text-7xl col-start-2">Just_Board</div> -->
    </section>
  </header>
  <RouterView />
</template>

<style scoped>

</style>
