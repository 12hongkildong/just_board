import { defineStore } from "pinia";

export const useUpdateDataStore = defineStore("updateData", {
    state: () => ({
        updateData: ''
    }),
    actions: {
        saveUpdateData(updateData) {
            this.updateData = updateData;
        },
    }
});