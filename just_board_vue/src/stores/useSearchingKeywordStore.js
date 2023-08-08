import { defineStore } from "pinia";

export const useSearchingKeywardStore = defineStore("boardPage", {
    state: () => ({
        keyword: ''
    }),
    actions: {
        saveKeyword(keyword) {
            this.keyword = keyword;
        },
    }
});