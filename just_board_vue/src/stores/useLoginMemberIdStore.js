import { defineStore } from "pinia";

export const useLoginMemberIdStore = defineStore("memberId", {
    state: () => ({
        memberId: 1
    }),
    actions: {
        saveKeyword(memberId) {
            this.memberId = memberId;
        },
    }
});