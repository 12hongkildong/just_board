<template lang="">
    <section class="grid grid-cols-[minmax(26.75rem,_1fr)_66.5rem_minmax(26.75rem,_1fr)] mt-[5.625rem]"> <!-- 가장 겉 그리드 -->
        <section class="col-start-2">
            <input type="text" class="text-2xl h-[4.375rem] bg-[#D9D9D9] justify-items-center content-center w-[66.5rem] pl-7 pr-7 text-2xl" placeholder="제목을 입력하세요." v-model="subject">
            <!-- <section>
                <h1 class=hidden>게시글</h1> -->
            <textarea name="" id="" cols="30" rows="24" class="text-xl w-[66.5rem] border-solid border-2 border-[#35469C] p-9 resize-none whitespace-pre-line" placeholder="내용을 입력하세요." v-model="content"></textarea>
            <!-- </section> -->
            <div class="grid justify-items-end grid-flow-col">
                <button class="h-[4rem] w-[5rem] bg-[#35469C] text-white text-3xl rounded-xl mt-5 cursor-pointer ml-[50rem]" @click="createArticle">등록</button>
                <button class="h-[4rem] w-[5rem] bg-[#9c3535] text-white text-3xl rounded-xl mt-5 cursor-pointer" @click="backToBoard">취소</button>
            </div>
        </section>
    </section>

</template>
<script setup>
import { ref, onUpdated, onMounted, defineProps } from 'vue'
import { useMemberIdStore } from '../../stores/useMemberIdStore';

let subject = ref("");
let content = ref("");
let defaultMemberId = ref(useMemberIdStore().memberId);

onMounted(() => {
    console.log(defaultMemberId)
})

function createArticle(){
    if(subject.value==""||content.value=="")
        alert("제목 or 내용을 입력하세요")
    else{
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "memberId": {
            "id": defaultMemberId.value
        },
        "subject": subject.value,
        "content": content.value
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/board/createArticle", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));

        backToBoard()
    }
}

function backToBoard(){
    window.location.href ='http://localhost:5173/board'
}
// onUpdated(() => {
//     console.log(subject.value);
//     console.log(content.value)
// })

</script>
<style scoped></style>