<template>
    <section class="grid items-center justify-items-center grid-cols-[minmax(26.75rem,_1fr)_66.5rem_minmax(26.75rem,_1fr)]">
        <h1 class="hidden">로그인 박스</h1>
        <section class="h-[33.5rem] w-[32.375rem] bg-[#D9D9D9] grid   content-center justify-center grid-rows-[6.25rem_6.25rem_4rem_3rem_5rem] mt-[13.5rem]  col-start-2">
            <section>
                <div class="text-2xl">아이디 or 이메일</div>
                <input type="text" class="h-12 w-80 rounded-lg">
            </section>
            <section>
                <div class="text-2xl">비밀번호</div>
                <input type="password" class="h-12 w-80 rounded-lg">
            </section>
            <button class="bg-[#35469C] text-white rounded-lg h-12 w-80 text-xl">로그인</button>
            <router-link to="signup" class="text-xl text-blue-700 text-center">회원가입</router-link>
            <router-view></router-view>
            <section class="grid grid-cols-[5rem_5rem]">
                <h1 class="hidden">소셜 로그인</h1>
                <div class="w-16 h-16 bg-green-500 rounded-full grid  items-center justify-center">구글</div>
                <div class="w-16 h-16 bg-yellow-300 rounded-full grid  items-center justify-center">카카오</div>
            </section>
        </section>


    </section>
</template>
<script setup>

</script>
<style scoped>
    
</style>