/** @type {import('tailwindcss').Config} */
export default {
  // purge: ["./src/**/*.html", "./src/**/*.{js, jsx, ts, tsx}"],
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
    "./src/**/**/*.{svg}",
  ],
  theme: {
    extend: {
      backgroundImage: {
       'create-logo':"url('./src/assets/icon/create.svg')",
       'search-logo':"url('./src/assets/icon/search.svg')",
       'heart-logo':"url('./src/assets/icon/heart.svg')",
       'heart-black-logo':"url('./src/assets/icon/heartBlack.svg')",
       'post-setting-logo':"url('./src/assets/icon/postSetting.svg')",
      }
    },
  },
  plugins: [],
}