<template lang="">
    <nav class="isolate inline-flex -space-x-px rounded-md shadow-sm" aria-label="Pagination">
                    <a href="#" class="relative inline-flex items-center rounded-l-md px-2 py-2 text-gray-400 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                    <span class="sr-only">Previous</span>
                    <svg class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                        <path fill-rule="evenodd" d="M12.79 5.23a.75.75 0 01-.02 1.06L8.832 10l3.938 3.71a.75.75 0 11-1.04 1.08l-4.5-4.25a.75.75 0 010-1.08l4.5-4.25a.75.75 0 011.06.02z" clip-rule="evenodd" />
                    </svg>
                    </a>
                    <!-- <a href="#" aria-current="page" class="relative z-10 inline-flex items-center bg-[#35469C] px-4 py-2 text-sm font-semibold text-white focus:z-20 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">1</a> -->
                    <!-- <div v-for="num in lastPage" :key="num">
                        <li><button class="" :class="currentPage == num ? 'h-10 px-5 text-white transition-colors duration-150 bg-indigo-600 focus:shadow-outline' : 'h-10 px-5 text-indigo-600 transition-colors duration-150 bg-white focus:shadow-outline hover:bg-indigo-100'" @click="changePage(num), getPage(num-1)">{{num}}</button></li>
                    </div> -->
                    <a href="#"  class="relative inline-flex items-center px-4 py-2 text-sm font-semibold text-gray-900 ring-1 ring-inset ring-gray-300  focus:z-20 focus:outline-offset-0" :class="i===currentPage? 'bg-[#35469C] text-white':'hover:bg-gray-400'" v-for="i in checkLastPageAboveTen.value > 1 ? 10 : lastPage" @click="changePage(i)">{{ i }}</a>
                    <a href="#" class="relative inline-flex items-center rounded-r-md px-2 py-2 text-gray-400 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0">
                    <span class="sr-only">Next</span>
                    <svg class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                        <path fill-rule="evenodd" d="M7.21 14.77a.75.75 0 01.02-1.06L11.168 10 7.23 6.29a.75.75 0 111.04-1.08l4.5 4.25a.75.75 0 010 1.08l-4.5 4.25a.75.75 0 01-1.06-.02z" clip-rule="evenodd" />
                    </svg>
                    </a>
                </nav>
</template>
<script setup>
import { ref, onMounted, onUpdated, defineEmits } from 'vue'

let firstPage = 1;
let lastPage = ref(1); // 총 페이지 수
let checkLastPageAboveTen =ref(1);
let currentPage = ref(1);

const emit = defineEmits();

// 게시글 페이지 바꾸기
function changePage(num) {
    if(currentPage.value==num)
        return;
    else{
        currentPage.value=num;
        emit('parentchangePage', num);
    }
}

onMounted(() => {
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch("http://localhost:8080/board/countPage", requestOptions)
        .then(response => response.text())
        .then(result => {
            lastPage.value = result-1;  // 백엔드에서 마지막 페이지가 몇인지 계산해서 보내준다.
            checkLastPageAboveTen.value = ref(Math.ceil(lastPage.value / 10)); // 백엔드에서 보내준 마지막 페이지 수가 10보다 큰지 작은지를 계산한다.
        })
        .catch(error => console.log('error', error));

})

// 몇 번 페이지 넘길 수 있는 지 파악하는 용도의 onUpdate
onUpdated(()=>{

})

</script>
<style scoped lang="">
    
</style>