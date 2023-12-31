import "./assets/style.css"
import "../public/reset.css"
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
// import "/reset.css"

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

const app = createApp(App)
const pinia = createPinia()
pinia.use(piniaPluginPersistedstate)
app.use(pinia)
app.use(router)

app.mount('#app')
