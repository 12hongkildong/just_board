<template lang="">
    <section class="grid  grid-cols-[minmax(26.75rem,_1fr)_66.5rem_minmax(26.75rem,_1fr)] justify-items-center mt-[8.875rem]">
        <section class="bg-[#D9D9D9] h-[42.125rem] w-[57.75rem] col-start-2">
            <h1 class="hidden">회원가입</h1>
            <section class="grid grid-cols-[17.5rem_1fr] mt-16 ml-16">
                <div class="text-4xl">아이디</div>
                <input type="text" class="h-12 w-80 rounded-lg">
            </section>
            <section class="grid grid-cols-[17.5rem_1fr]  mt-16 ml-16">
                <div class="text-4xl">비밀번호</div>
                <input type="password" class="h-12 w-80 rounded-lg">
            </section>
            <section class="grid grid-cols-[17.5rem_1fr]  mt-16 ml-16">
                <div class="text-4xl">비밀번호 확인</div>
                <input type="password" class="h-12 w-80 rounded-lg">
            </section>
            <section class="grid grid-cols-[17.5rem_1fr] mt-16 ml-16">
                <div class="text-4xl">닉네임</div>
                <input type="text" class="h-12 w-80 rounded-lg">
            </section>
            <section class="grid grid-cols-[17.5rem_1fr_13rem] mt-16 ml-16">
                <div class="text-4xl">이메일</div>
                <input type="text" class="h-12 w-80 rounded-lg">
                <button class="rounded-lg bg-white h-[3.125rem] w-[4.375rem] hover:bg-gray-400">
                    전송
                </button>
                    <input type="text" class="h-12 w-80 rounded-lg col-start-2  mt-4" :disabled="isDisabled" v-model="certifyValue">
                    <button class="rounded-lg bg-white h-[3.125rem] w-[4.375rem] hover:bg-gray-400 mt-4" @click="certifyBtn" :disabled="isDisabled" >인증</button>
            </section>
        </section>
        <button class="col-start-2 bg-[#D9D9D9] rounded-lg h-[3.625rem] w-[8.75rem] hover:bg-gray-400 text-3xl mt-[2.5rem]" v-show="isDisabled==true">회원가입</button>
    </section>
</template>
<script setup>
import {ref} from 'vue';
let certifyValue=('하잇');
let isDisabled = ref(false);

console.log(certifyValue);

function certifyBtn(){   // disabled 작동하게 만들고, 한 번인증 누르면  버튼도 안 눌리게 만들자
    if(certifyValue==1234){
        isDisabled.value=!isDisabled.value;
        alert("이메일 인증이 완료 됐습니다.")
    }
    else
        alert(certifyValue);
}

</script>
<style scoped>
    
</style>