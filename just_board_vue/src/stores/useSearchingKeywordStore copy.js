import { defineStore } from "pinia";

export const useSearchingKeywardStore = defineStore("searchingKeyword", {
    state: () => ({
        keyword: ''
    }),
    actions: {
        saveKeyword(keyword) {
            this.keyword = keyword;
        },
    }
});