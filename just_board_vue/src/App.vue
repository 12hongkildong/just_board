<script setup>
import { RouterLink, RouterView } from 'vue-router'

</script>

<template>
  <header>
    <section class="h-28 bg-[#35469C] grid grid-cols-[minmax(26.75rem,_1fr)_66.5rem_minmax(26.75rem,_1fr)] items-center">
      <h1 class="hidden">로고</h1>
      <div class="text-white text-7xl col-start-2">Just_Board</div>
    </section>
  </header>
  <RouterView />
</template>

<style scoped>

</style>
