<template lang="">
    <section class="grid grid-cols-[minmax(26.75rem,_1fr)_66.5rem_minmax(26.75rem,_1fr)] mt-[5.625rem]">
        <h1 class="hidden">게시글 디테일</h1>  
        <section class="col-start-2">
            <section class="text-[2.5rem] m-3 font-bold">
                <h1 class="hidden">게시글 제목</h1>
                {{data.subject}}
            </section> <!-- 게시글 타이틀 -->
            <section class="text-2xl bg-[#D9D9D9] h-[4.375rem] grid grid-cols-[minmax(10rem,18rem)_1rem_10rem_1rem_14rem] content-center pl-5">
                <h1 class="hidden">게시글 정보</h1>
                <div class=""> {{data.memberId.name}} </div>|
                <div class="text-center">조회수 {{data.hit}}</div>|
                <div class="text-right">{{ formatDate(data.date) }}</div>
            </section>
            <section>
                <h1 class="hidden">본문</h1>
                <div class="m-12 whitespace-pre-line">
                    {{data.content}}
                </div>
            </section>
            <section class="grid">
                <h1 class="hidden">좋아요 버튼</h1>
                <div></div>
                <div class="m-2 justify-self-center h-14 w-14 bg-[#D9D9D9] grid content-center">
                    <div class="bg-heart-logo h-6 w-7 justify-self-center content-center"></div>
                </div>
                <router-link to="/update" class="text-right" v-show="data.memberId.id==1" @click="saveDataToPinia">수정하기</router-link>
            </section>
            <hr class="border-t-8">
            <section class="mt-9">
                <h1 class="hidden">댓글 공간</h1>
                <section class="border-t-2">
                    <h1 class="hidden">댓글 리스트</h1>
                    <div class="grid grid-cols-2 bg-[#D9D9D9]">
                        <div class="m-2">서정권</div>
                        <div class="justify-self-end m-2">2023.07.24.</div>
                    </div>
                    <div class="m-6">신경 쓰지마 너에 앞길은 너무 밝아~ 하늘을 보면 기분이</div>
                    <div class="grid">
                        <div class="mb-3 justify-self-end cursor-pointer" @click="commentOpen">답글</div>
                    </div>
                    <section class="grid justify-items-end" v-show="comment">
                        <h1 class="hidden">댓글 달기</h1>
                        <textarea name="" id="" cols="30" rows="2"  placeholder="댓글을 작성하세요." class="border-solid border-2 w-[60rem] text-2xl p-5 resize-none"></textarea>
                        <div>
                            <button class="h-[3rem] w-[4rem] bg-[#35469C] text-white text-2xl rounded-xl mt-5 mb-5 ">등록</button>
                            <button class="h-[3rem] w-[4rem] bg-white border-2 border-[#35469C] text-2xl rounded-xl mt-5 mb-5 ml-3" @click="commentOpen">취소</button>
                        </div>
                    </section>    
                </section>

                <section class="grid justify-items-end">
                    <h1 class="hidden">댓글 달기</h1>
                    <textarea name="" id="" cols="30" rows="2"  placeholder="댓글을 작성하세요." class="border-solid border-2 w-[66.5rem] text-2xl p-5 resize-none"></textarea>
                    <button class="h-[3rem] w-[4rem] bg-[#35469C] text-white text-2xl rounded-xl mt-5 ">등록</button>
                </section>
            </section>
        </section>
    </section>

</template>
<script setup>
import { ref, defineProps, onUpdated, onMounted, onBeforeMount } from 'vue'
import dayjs from 'dayjs'
import { useUpdateDataStore } from '../../stores/useUpdateDataStore';

// props로 데이터 받아오기
const props = defineProps({
    propp:{
        type:Object,
    },
    count:{
        type:Number,
    }
});

console.log(props)


let data = ref(props.propp)

let comment = ref(false);

function commentOpen(){
    comment.value = !comment.value;   // 나중에 오픈을 for i in xxx 이런 식으로 해서 해당 키일 때만 열리게 해야 할 듯
}

function formatDate(dateString){ //날짜 데이터가 timestamp 형태인 것을 내가 원하는 형태로 바꾸기 위한 함수
    const formattedDate = dayjs(dateString, "YYYY-MM-DD HH:mm:ss").format("YY/MM/DD HH:mm:ss");
    return formattedDate;
}

onUpdated(()=>{
    data = ref(props.propp)
})

function saveDataToPinia(){
    useUpdateDataStore().saveUpdateData(data.value)
}
</script>
<style scoped>
    
</style>