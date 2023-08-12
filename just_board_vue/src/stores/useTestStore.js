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
        findById(id) {
            for (const item of this.fetchedItems) {
                if (item.id == id.value) {
                    return item;
                }
            }
        },
        deleteDate(id) {
            for (const item of this.fetchedItems) {
                this.fetchedItems = this.fetchedItems.filter(item => item.id !== id);
            }
            // alert(`id의 자료형은: ${typeof id}`)
            // alert(`페치아이템 id의 자료형은: ${typeof this.fetchedItems[0].id}`)
        }
    },
    persist: true,
});