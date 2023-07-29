<template>
    <router-view></router-view>
    <section class="grid grid-cols-[minmax(26.75rem,_1fr)_66.5rem_minmax(26.75rem,_1fr)] mt-[5.625rem]"> <!-- 가장 겉 그리드 -->
        <section class="col-start-2">
            <section> <!-- 검색하기 모달 -->
                <button class="cursor-pointer text-xl grid grid-cols-[1.5rem_1fr] mb-5">
                    <div class="bg-search-logo h-6 w-6"></div>검색
                </button>
            </section>
            <section class="grid grid-cols-[38rem_13rem_6.625rem_9rem] text-2xl h-[4.375rem] bg-[#D9D9D9] justify-items-center content-center">  <!-- 릴레이션 스키마 -->
                <div>제목</div>
                <div>글쓴이</div>
                <div>추천수</div>
                <div>날짜</div>
            </section>
            <section v-for="i in 20" class="grid grid-cols-[38rem_13rem_6.625rem_9rem] text-2xl h-[3.75rem] justify-items-center content-center hover:bg-gray-100 ">  <!-- v-for하기 위한 목록 리스트 -->
                <h1 class="hidden">리스트</h1>
                <router-link to="/1" class="cursor-pointer hover:text-blue-400" @click="scrollToTop">{{ title }}</router-link>
                <!-- <div class="cursor-pointer hover:text-blue-400">{{ title }}</div> -->
                <div>{{ name }}</div>
                <div>{{ like }}</div>
                <div>{{ date }}</div>
            </section>

            <section class="grid justify-items-end font-bold m-4"> <!-- 글쓰기 버튼 -->
                <router-link to="/write" class="text-2xl grid grid-cols-[1.5rem_1fr]"><div class="bg-create-logo h-6 w-6"></div>글쓰기</router-link>
            </section>


            <section class="grid justify-items-center pb-10"> <!-- 페이지네이션 -->
                <nav class="isolate inline-flex -space-x-px rounded-md shadow-sm" aria-label="Pagination">
                    <a href="#" class="relative inline-flex items-center rounded-l-md px-2 py-2 text-gray-400 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                    <span class="sr-only">Previous</span>
                    <svg class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                        <path fill-rule="evenodd" d="M12.79 5.23a.75.75 0 01-.02 1.06L8.832 10l3.938 3.71a.75.75 0 11-1.04 1.08l-4.5-4.25a.75.75 0 010-1.08l4.5-4.25a.75.75 0 011.06.02z" clip-rule="evenodd" />
                    </svg>
                    </a>
                    <!-- Current: "z-10 bg-indigo-600 text-white focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600", Default: "text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:outline-offset-0" -->
                    <a href="#" aria-current="page" class="relative z-10 inline-flex items-center bg-[#35469C] px-4 py-2 text-sm font-semibold text-white focus:z-20 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">1</a>
                    <a href="#" class="relative inline-flex items-center px-4 py-2 text-sm font-semibold text-gray-900 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0" v-for="i in 9">{{ igit config --list + 1 }}</a>
                    <a href="#" class="relative inline-flex items-center rounded-r-md px-2 py-2 text-gray-400 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                    <span class="sr-only">Next</span>
                    <svg class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                        <path fill-rule="evenodd" d="M7.21 14.77a.75.75 0 01.02-1.06L11.168 10 7.23 6.29a.75.75 0 111.04-1.08l4.5 4.25a.75.75 0 010 1.08l-4.5 4.25a.75.75 0 01-1.06-.02z" clip-rule="evenodd" />
                    </svg>
                    </a>
                </nav>
            </section>
        </section>
    </section>
</template>
<!-- 잔디 올라가는지 테스트 잔디 올라가기 테스트 2 잔디테스트3 안 되면 그냥 놔둠-->


<script setup>
import {ref} from 'vue';


let title = ref("하나면 하나지 둘이겠느냐? 둘이면 둘이지 셋은...");
let name = ref("술취한호랑이");
let like = ref("9");
let date = ref("2023.07.24.");

function scrollToTop(){  // 스크롤을 맨 위로 올리는 함수
    window.scrollTo(0, 0)
}



</script>
<style scoped>
    
</style>