<template lang="">
<div class="relative z-10" aria-labelledby="modal-title" role="dialog" aria-modal="true">
  <div class="fixed inset-0 bg-gray-500 bg-opacity-75 transition-opacity"></div>

  <div class="fixed inset-0 z-10 overflow-y-auto">
    <div class="flex min-h-full items-end justify-center p-4 text-center sm:items-center sm:p-0">
      <div class="relative transform overflow-hidden rounded-lg bg-white text-left shadow-xl transition-all sm:my-8 sm:w-full sm:max-w-lg">
        <div class="bg-white px-4 pb-4 pt-5 sm:p-6 sm:pb-4">
          <div class="sm:flex sm:items-start">
            <div class="mt-3 text-center sm:ml-4 sm:mt-0 sm:text-left">
              <h3 class="text-base font-semibold leading-6 text-gray-900" id="modal-title">검색</h3>
              <div class="mt-2">
                <p class="text-sm text-gray-500">
                    <select name="" id="">
                        <option value="">제목+내용</option>
                        <option value="">제목</option>
                        <option value="">내용</option>
                    </select>
                        
                        <input type="text" class="border-solid border-2 border-gray-500 rounded-md" v-model="searchKeyword" placeholder="검색어를 입력하세요.">
        

                </p>
              </div>
            </div>
          </div>
        </div>
        <div class="bg-gray-50 px-4 py-3 sm:flex sm:flex-row-reverse sm:px-6">
          <button type="button" class="inline-flex w-full justify-center rounded-md bg-[#35469C] px-3 py-2 text-sm font-semibold text-white shadow-sm hover:bg-[#94a4f7] sm:ml-3 sm:w-auto" @click="searchList">검색</button>
          <button type="button" class="mt-3 inline-flex w-full justify-center rounded-md bg-white px-3 py-2 text-sm font-semibold text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 hover:bg-gray-50 sm:mt-0 sm:w-auto" @click="closeModal">닫기</button>
        </div>
      </div>
    </div>
  </div>
</div>
</template>
<script setup>
import { defineEmits, onUpdated, ref } from 'vue';

let emit = defineEmits(['closeModal','searching']);

let searchKeyword = ref("");

function closeModal(){
    emit('closeModal')
}

// onUpdated(()=>{
//   console.log(searchKeyword.value);
// })

function searchList(){
    emit('searching', 0, searchKeyword.value)
    emit('closeModal')
}

</script>
<style lang="">
    
</style>