<template lang="">
        <section class="mt-9">
        <h1 class="hidden">댓글 공간</h1>
        <section class="border-t-2">
            <h1 class="hidden">댓글 리스트</h1>
            <section v-for="(comment, i) in commentText" :key="i">
                <div :class="comment.step!=0?'ml-14':''">
                    <div class="grid grid-cols-2 bg-[#D9D9D9]">
                        <div class="m-2">{{comment.memberName}}</div>
                        <div class="justify-self-end m-2">{{formatDate(comment.date)}}</div>
                    </div>
                    <div class="m-6">{{comment.content}}</div>
                    <div class="grid">
                        <div class="mb-3 justify-self-end cursor-pointer" @click="commentOpen(i)">답글</div>
                    </div>
                    <section class="grid justify-items-end" v-show="commentBox[i].value">
                        <h1 class="hidden">댓글 달기</h1>
                        <textarea name="" id="" cols="30" rows="2"  placeholder="댓글을 작성하세요." class="border-solid border-2 w-[60rem] text-2xl p-5 resize-none"></textarea>
                        <div>
                            <button class="h-[3rem] w-[4rem] bg-[#35469C] text-white text-2xl rounded-xl mt-5 mb-5 " @click="addReply">등록</button>
                            <button class="h-[3rem] w-[4rem] bg-white border-2 border-[#35469C] text-2xl rounded-xl mt-5 mb-5 ml-3" @click="commentOpen(i)">취소</button>
                        </div>
                    </section>
                </div>    
            </section>
        </section>

        <section class="grid justify-items-end">
            <h1 class="hidden">댓글 달기</h1>
            <textarea name="" id="" cols="30" rows="2"  placeholder="댓글을 작성하세요." class="border-solid border-2 w-[66.5rem] text-2xl p-5 resize-none" v-model="commentContent"></textarea>
            <button class="h-[3rem] w-[4rem] bg-[#35469C] text-white text-2xl rounded-xl mt-5" @click="addComment">등록</button>
        </section>
    </section>

    {{refValueExtraction()}}
</template>

<script setup>
import { ref, defineProps, onUpdated, onMounted, onBeforeMount, reactive, onActivated, onBeforeUpdate } from 'vue'
import dayjs from 'dayjs'
import { useRoute, useRouter } from 'vue-router';
import { useUpdateDataStore } from '../../stores/useUpdateDataStore';
import { useTestStore } from '../../stores/useTestStore';
import {useLoginMemberIdStore} from '../../stores/useLoginMemberIdStore'

let id = ref(props.idValue);
let commentText = ref("");
let commentBox = ref([]); // 대댓글 입력박스
let commentContent = ref(""); // 댓글 작성한 글 내용

const props = defineProps({
    idValue: {
        type: Number
    },
    routerParam: {
        type: Number
    }
})

onMounted(() => {
    getComment();
})

onBeforeUpdate(() => {
    if (id.value !== props.routerParam) {
        id.value = props.routerParam;
        getComment();
        refValueExtraction();
    }
});

onUpdated(()=>{
//     console.log(commentContent.value)
//     console.log(Date.now())
//     const currentDate = new Date();
//     console.log(currentDate.toISOString())
    // alert((new Date()).toISOString()+" / "+(new Date()).getTime());
    
})


function getComment() {
    var requestOptions = {
        method: 'GET',
        redirect: 'follow'
    };

    fetch(`http://localhost:8080/comment/getArticleDivisionComment?articleId=${props.idValue}`, requestOptions)
        .then(response => response.json())
        .then(result => {
            commentText.value = result;
            commentBox.value = commentText.value.map(() => ref(false));
        })
        .catch(error => console.log('error', error));
}


let commentRef = ref(0);
function refValueExtraction(){ // 댓글의 순서를 위해 최대 ref계산기
    console.log(commentText.value)
    for(let i in commentText.value){
        console.log(commentText.value[i].ref)
        if(commentRef.value<commentText.value[i].ref)
            commentRef.value=commentText.value[i].ref
    }
    return commentRef.value;
}

function commentOpen(i) {
    commentBox.value[i].value = !commentBox.value[i].value
}

function addComment() { //댓글
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "content": commentContent.value,
        "memberId": {
            "id": useLoginMemberIdStore().memberId
        },
        "articleId": {
            "id": id.value
        },
        "date": (new Date()).toISOString(),
        // "date": (new Date()).getTime(),
        "ref": refValueExtraction()+1
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/comment/regComment3", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
    commentContent.value = ""; // 댓글 입력칸 초기화

}

function addReply() { // 대댓글
    alert("대댓글 등록")
}

function formatDate(dateString) { //날짜 데이터가 timestamp 형태인 것을 내가 원하는 형태로 바꾸기 위한 함수
    const formattedDate = dayjs(dateString, "YYYY-MM-DD HH:mm:ss").format("YY/MM/DD HH:mm:ss");
    return formattedDate;
}

</script>

<style lang="">
    
</style>