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
                <!-- <div class=""> {{data.memberId.name}} </div>| -->
                <div class=""> {{memberId.name}} </div>|
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
                <div class='bg-post-setting-logo h-6 w-6 justify-self-end content-end relative cursor-pointer '  v-show="memberId.id==1" @click="settingBtn=!settingBtn">
                    <div class="w-24 h-14 bg-white border-solid border-2 border-[#35469C] absolute  top-6 left-[-4rem] right-0 select-none " v-show="settingBtn">
                        <router-link :to="{name:'update', params:{id:data.id}}" class="text-right hover:text-red-400" @click="saveDataToPinia">수정하기</router-link>
                        <div class="h-4 w-4 cursor-none"></div>
                        <span class="hover:text-red-400" @click="deleteArticle">삭제하기</span>
                    </div>
                </div>
            </section>
            <hr class="border-t-8">
            <Comment :idValue="id" :routerParam="route.params.id"></Comment>
        </section>
    </section>
</template>

<script setup>
import { ref, defineProps, onUpdated, onMounted, onBeforeMount, reactive, onActivated, onBeforeUpdate } from 'vue'
import dayjs from 'dayjs'
import { useRoute, useRouter } from 'vue-router';
import { useUpdateDataStore } from '../../stores/useUpdateDataStore';
import { useTestStore } from '../../stores/useTestStore';
import Comment from './Comment.vue'

let route = useRoute();
let router = useRouter();
let id = ref(route.params.id);

let piniaDate = ref(useTestStore().fetchedItems);
let data = ref("")
let memberId = ref("");
let settingBtn = ref(false);


function updateContent() {
    id = ref(route.params.id);
    data.value = useTestStore().findById(id);
    memberId.value = data.value.memberId
}

onBeforeUpdate(() => {
    if (id.value !== route.params.id) {
        id.value = route.params.id;
        updateContent();
    }
});

// props로 데이터 받아오기
const props = defineProps({
    count: {
        type: Number,
    }
});

onMounted(() => {
    //피니아 id에 있으면 화면 뿌려주고, 없으면 board로 가게 만들기
    settingBtn.value = false
    updateContent();

})

function formatDate(dateString) { //날짜 데이터가 timestamp 형태인 것을 내가 원하는 형태로 바꾸기 위한 함수
    const formattedDate = dayjs(dateString, "YYYY-MM-DD HH:mm:ss").format("YY/MM/DD HH:mm:ss");
    return formattedDate;
}

// onUpdated(() => {
//     // data = ref(props.propp)
//     // console.log("아이디"+id.value)
//     {
//         // updateContent();
//         // getComment();
//     }
// })

function saveDataToPinia() {
    useUpdateDataStore().saveUpdateData(data.value)
}

function deleteArticle() {
    var result = window.confirm("정말로 이 글을 삭제하시겠습니까?");
    if (result) {
        { // db에서 삭제
            var raw = "";

            var requestOptions = {
                method: 'DELETE',
                body: raw,
                redirect: 'follow'
            };

            fetch(`http://localhost:8080/board/deleteArticle?articleId=${id.value}`, requestOptions)
                .then(response => response.text())
                .then(result => console.log(result))
                .catch(error => console.log('error', error));
            router.push({ name: 'board' })
        }
        { // 피니아에서 삭제
            useTestStore().deleteDate(parseInt(id.value))
        }
    }
    else
        console.log("실패")
}

</script>
<style scoped></style>