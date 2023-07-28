<template lang="">
    <section class="grid grid-cols-[minmax(26.75rem,_1fr)_66.5rem_minmax(26.75rem,_1fr)] mt-[5.625rem]"> <!-- 가장 겉 그리드 -->
        <section class="col-start-2">
            <input type="text" class="text-2xl h-[4.375rem] bg-[#D9D9D9] justify-items-center content-center w-[66.5rem] pl-7 pr-7 text-2xl" placeholder="제목을 입력하세요." >
            <section>
                <h1 class=hidden>게시글</h1>
                <textarea name="" id="" cols="30" rows="24" class="text-xl w-[66.5rem] border-solid border-2 border-[#35469C] p-9 resize-none" placeholder="내용을 입력하세요."></textarea>
                <div class="grid justify-items-end">
                    <button class="h-[4rem] w-[5rem] bg-[#35469C] text-white text-3xl rounded-xl mt-5 ">등록</button>
                </div>
            </section>
        </section>
    </section>

</template>
<script setup>


</script>
<style scoped>
    
</style>