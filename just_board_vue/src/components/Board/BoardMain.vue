<template>
    <router-view></router-view>
    <section class="grid grid-cols-[minmax(26.75rem,_1fr)_66.5rem_minmax(26.75rem,_1fr)] mt-[5.625rem]"> <!-- 가장 겉 그리드 -->
        <section class="col-start-2">
            <section> <!-- 검색하기 모달 -->
                <button class="cursor-pointer text-xl grid grid-cols-[1.5rem_1fr] mb-5" @click="openModal">
                    <div class="bg-svg-magnifyingGlass h-6 w-6" ></div>검색
                </button>
            </section>
            <section class="h-[23.125rem]">
                <section class="grid grid-cols-[38rem_13rem_6.625rem_9rem] text-2xl h-[4.375rem] bg-[#D9D9D9] justify-items-center content-center">  <!-- 릴레이션 스키마 -->
                    <div>제목</div>
                    <div>글쓴이</div>
                    <div>추천수</div>
                    <div>날짜</div>
                </section>

                <!-- v-for하기 위한 목록 리스트 -->
                <section v-for="(list, i) in data" :key="i" class="grid grid-cols-[38rem_13rem_6.625rem_9rem] text-2xl h-[3.75rem] justify-items-center content-center hover:bg-gray-100 ">
                    <h1 class="hidden">리스트</h1>
                    <router-link :to="{name : 'detail', params: {id: data[i].id}}" class="cursor-pointer hover:text-blue-400" @click="scrollToTop()">{{ data[i].subject }}</router-link>
                    <div>{{ data[i].memberId.name }}</div>
                    <div>{{ data[i].like }}</div>
                    <div>{{ formatDate(data[i].date) }}</div>
                </section>
            </section>

            <section class="grid justify-items-end font-bold m-4"> <!-- 글쓰기 버튼 -->
                <router-link to="/write" class="text-2xl grid grid-cols-[1.5rem_1fr]">
                    <div class="bg-svg-Pencil h-6 w-6" @throwFunction="catchz()"></div>글쓰기
                </router-link>
            </section>


            <section class="grid justify-items-center pb-10"> <!-- 페이지네이션 -->
                <pageNation @parentchangePage="getBoardList" :keyword="currentKeyword" ref="pageReset"></pageNation>
            </section>
        </section>
    </section>
    <Modal v-show="modalSwitch" @closeModal="openModal" @searching="getBoardList"></Modal> <!-- 검색기능 모달 -->
</template>

<script setup>
// import Detail from './Detail.vue'
import pageNation from './PageNation.vue'
import {ref, reactive,onMounted, defineProps, onUpdated } from 'vue';
import dayjs from 'dayjs'
import Modal from '../Modal/Modal.vue'
import { useSearchingKeywardStore } from '../../stores/useSearchingKeywordStore';
import { useLoginMemberIdStore } from '../../stores/useLoginMemberIdStore';
import { useTestStore } from '../../stores/useTestStore';

let sendData = ref('');

let ditailPageId= ref(0);

let page = ref(0);
let data = ref("");

let modalSwitch = ref(false);

const pageReset = ref(null) //자식의 메소드 부모에서 사용하기 

let currentKeyword = ref(useSearchingKeywardStore().keyword);
let currentMemberId = ref(useLoginMemberIdStore().memberId);

function saveKeyword(keyword){
    useSearchingKeywardStore().saveKeyword(keyword);
}

function scrollToTop(){  // 스크롤을 맨 위로 올리는 함수, 필요 없는 줄 알았는데 디테일페이지에서 쓸모가 있어서 놔둠
    window.scrollTo(0, 0);
}

onMounted(() => { // 최초 조회시 데이터 값 받아오기
    getBoardList(0,currentKeyword.value)
})

function getBoardList(num, keyword) {
    page.value = num;
    currentKeyword.value=keyword;
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch(`http://localhost:8080/board/search2?page=${page.value}&search=${currentKeyword.value}`, requestOptions)
        .then(response => response.json())
        .then(result => {
            data.value=result;
            pageReset.value.pageReset();
            useTestStore().saveItems(result)
            console.log(useTestStore().fetchedItems)//키워드
        })
        .catch(error => console.log('error', error));
        //         alert("하잇")
}

function formatDate(dateString){ //날짜 데이터가 timestamp 형태인 것을 내가 원하는 형태로 바꾸기 위한 함수
    const formattedDate = dayjs(dateString, "YYYY-MM-DD HH:mm:ss").format("YY/MM/DD");
    return formattedDate;
}

function openModal(){ // 검색창 만들기
    modalSwitch.value=!modalSwitch.value;
}

onUpdated(()=>{{

}})

function catchz(){
    console.log("라우터링크 펑션보내기")
}

</script>
<style scoped>
    .router-link-active{
        color: red;
    }
</style>