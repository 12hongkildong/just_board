import { defineStore } from "pinia";

// 과연 값이 교체가 아니라 추가되게 넣을 수 있는지 테스트

export const useTestStore = defineStore("test", {
    state: () => ({
        fetchedItems: []
    }),
    actions: {
        saveItems(fetchedItems) {
            for (const item of fetchedItems) {
                if (!this.fetchedItems.some(existingItem => existingItem.id === item.id)) {
                    this.fetchedItems.push(item);
                }
            }
        },
    }
});