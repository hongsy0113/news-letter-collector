// import VueRouter from "vue-router";
// import app from "@/App.vue";
// import Home from "./views/Home.vue";
// import About from "./views/About.vue";
//
//
// const router = new VueRouter({
//     mode: "history",
//     routes: [
//         {path: "/", component: Home},
//         {path: "/about", component: About}
//     ]
// })
import {createWebHistory, createRouter} from 'vue-router'

//component 추가
import Home from "./views/Home.vue";
import About from './views/About.vue'

const routes = [
    {path:'/', component: Home},
    {path:'/about', component: About}
];

const router = createRouter({
    history:createWebHistory(),
    routes
});

export default router;