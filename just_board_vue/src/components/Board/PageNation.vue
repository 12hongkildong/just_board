<template lang="">
    <nav class="isolate inline-flex -space-x-px rounded-md shadow-sm" aria-label="Pagination">
                    <div class="cursor-pointer relative inline-flex items-center rounded-l-md px-2 py-2 text-gray-400 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0" @click="changeToPrevTenPage">
                        <span class="sr-only">Previous</span>
                        <svg class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                            <path fill-rule="evenodd" d="M12.79 5.23a.75.75 0 01-.02 1.06L8.832 10l3.938 3.71a.75.75 0 11-1.04 1.08l-4.5-4.25a.75.75 0 010-1.08l4.5-4.25a.75.75 0 011.06.02z" clip-rule="evenodd" />
                        </svg>
                    </div>
                    <!-- <div class="cursor-pointer relative inline-flex items-center px-4 py-2 text-sm font-semibold text-gray-900 ring-1 ring-inset ring-gray-300  focus:z-20 focus:outline-offset-0" :class="i+endPage===currentPage? 'bg-[#35469C] text-white':'hover:bg-gray-400'"
                    v-for="i in checkLastPageAboveTen.value > 1 ? 10+endPage<lastPage?10:lastPage-9 : lastPage.value" @click="changePage(i+endPage)">{{ i+endPage}}</div> -->
                    <div class="cursor-pointer relative inline-flex items-center px-4 py-2 text-sm font-semibold text-gray-900 ring-1 ring-inset ring-gray-300  focus:z-20 focus:outline-offset-0" :class="i+endPage===currentPage? 'bg-[#35469C] text-white':'hover:bg-gray-400'"
                    v-for="i in checkLastPageAboveTen.value > 1 ? 10+endPage<lastPage?10:lastPage-10 : lastPage.value" @click="changePage(i+endPage)">{{ i+endPage}}</div>
                    <div class="cursor-pointer relative inline-flex items-center rounded-r-md px-2 py-2 text-gray-400 ring-1 ring-inset ring-gray-300 hover:bg-gray-50 focus:z-20 focus:outline-offset-0"  @click="changeToNextTenPage">
                        <span class="sr-only">Next</span>
                        <svg class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                            <path fill-rule="evenodd" d="M7.21 14.77a.75.75 0 01.02-1.06L11.168 10 7.23 6.29a.75.75 0 111.04-1.08l4.5 4.25a.75.75 0 010 1.08l-4.5 4.25a.75.75 0 01-1.06-.02z" clip-rule="evenodd" />
                        </svg>
                    </div>
                </nav>
</template>
<script setup>
import { ref, onMounted, onUpdated, defineEmits, callWithErrorHandling, defineProps, defineExpose } from 'vue'

const props = defineProps({
    keyword: {
        type: String,
    }
});

let firstPage = 1;
let lastPage = ref(12); // 총 페이지 수
let checkLastPageAboveTen = ref(1); // 총 페이지가 10개 이상인지 이하인지 측정하는 값
let currentPage = ref(1); // 현재 조회되고 있는 페이지 표시

let endPage = ref(0);

const emit = defineEmits();

// 게시글 페이지 바꾸기
function changePage(num) {
    if (currentPage.value == num)
        return;
    else {
        currentPage.value = num;
        emit('parentchangePage', num - 1, props.keyword);
    }
}

function changeToPrevTenPage() {  // 이전 페이지로 넘기기
    if (endPage.value == 0)
        return
    else {
        endPage.value -= 10;  // 페이지네이션의 숫자 -10하기

        if (currentPage.value % 10 == 0) {  // < 버튼 누르면 매 1, 11, 21, 31... 등 1페이지로 뜨게 하는 식
            currentPage.value = currentPage.value - 10 - 10 + (10 - (currentPage.value % 10) + 1) - 10
        }
        else {
            currentPage.value = currentPage.value - 10 - 10 + (10 - (currentPage.value % 10) + 1)
        }

        emit('parentchangePage', endPage.value, props.keyword);
    }
}

function changeToNextTenPage() { // 다음 페이지로 넘기기
    if ((endPage.value + 10) > lastPage.value)
        return;
    endPage.value += 10; // 페이지네이션의 숫자 +10하기
    if (currentPage.value % 10 == 1) // 페이지 넘기면 11, 21, 31... 등 1페이지로 뜨게 하는 식
        currentPage.value += 10
    else if (currentPage.value % 10 != 1) {
        currentPage.value += (10 * Math.ceil(currentPage.value / 10)) - currentPage.value + 1
    }
    // if((endPage.value+10)>lastPage.value){
    //     emit('parentchangePage', endPage.value);
    //     endPage.value=lastPage.value;
    //     // endPage.value==lastPage.value-10;
    // }
    // else
    // alert("엔드밸류쁠러스일"+parseInt(endPage.value+1))
    emit('parentchangePage', parseInt(endPage.value), props.keyword);
}

onMounted(() => {
    pageReset();
})

function pageReset() {
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    // 페이지네이션 보여 줄 개수 파악하는 식
    fetch(`http://localhost:8080/board/countPage2?search=${props.keyword}`, requestOptions)
        .then(response => response.text())
        .then(result => {
            lastPage.value = parseInt(result, 10);  // 백엔드에서 마지막 페이지가 몇인지 계산해서 보내준다.
            // alert("키워드는 "+props.keyword)
            // alert(lastPage.value)
            checkLastPageAboveTen.value = ref(Math.ceil(lastPage.value / 10)); // 백엔드에서 보내준 마지막 페이지 수가 10보다 큰지 작은지를 계산한다.
            // alert(checkLastPageAboveTen.value.value);
        })
        .catch(error => console.log('error', error));
}

defineExpose({
    pageReset
});


</script>
<style scoped lang="">
    
</style>