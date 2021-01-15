import Vue from "vue"
import Router from "vue-router"
import store from "@/store"
import {getClientToken} from "@/utils/utils";
import {fetchLoginDetail} from "@/axios/login";

Vue.use(Router);
const router = new Router({
    base: process.env.BASE_URL,
    linkActiveClass: "active",
    routes: [{
        path: "/login", component: () => import("@/views/login.vue")
    }, {
        path: "/404", component: () => import("@/views/404.vue")
    }, {
        path: "/401", component: () => import("@/views/401.vue")
    }, {
        path: "", redirect: "/home", component: () => import("@/views/layout"), children: [{
            path: "home", component: () => import("@/views/home"), meta: {
                title: "home", show: true
            }
        }]
    }, {
        path: "*", redirect: "/404"
    }]
});

router.beforeEach((to, from, next) => {
    if(getClientToken()) { // 已经有token的情况下, 访问登录页时, 直接跳转到默认首页
        if(to.path === "/login") {
            return next("/")
        } else { // 已经有token的情况下, 需要判断是否已经获取了用户详细数据
            return getManagerDetails(to, from, next);
        }
    } else { // 没有获取token的情况下, 访问非登录页时, 强制跳转到登录页面
        if(to.path === "/login") {
            return next();
        } else {
            return next(`/login?redirect=${to.fullPath}`);
        }
    }
})

const getManagerDetails = function (to, from, next) {
    if(store.getters.authentication) { // 已经获取用户详细信息的情况下, 直接返回
        return next();
    }
    fetchLoginDetail(getClientToken()).then(response => {
        store.dispatch("setAuthenticationDetails", response.data.model).then(() => {
            console.log(store.getters.menus, arguments);
            router.addRoutes(store.getters.menus);
            next({...to, replace: true});
        })
    }).catch((error) => {
        console.log(error);
        next("/401");
    })
}

export const asyncRouters = [{
    path: "/mms", component: () => import("@/views/layout"), redirect: "/mms/manager", children: [{
        path: "manager", name: "manager", component: () => import("@/views/manager"), meta: {
            title: "系统用户管理", icon: ""
        }
    }, {
        path: "role", name: "role", component: () => import("@/views/role"), meta: {
            title: "权限管理", icon: ""
        }
    }]
}, {
    path: "/pms", component: () => import("@/views/layout"), redirect: "/pms/product", children: [{
        path: "product", name: "product", component: () => import("@/views/layout"), meta: {
            title: "", icon: "product-list"
        }
    }, {
        path: "category", name: "category", component: () => import("@/views/layout"), meta: {
            title: "", icon: ""
        }
    }]
}, { // 订单相关
    path: "/oms", component: () => import("@/views/layout"), redirect: "/oms/order", children: [{
        path: "order", name: "order", component: () => import("@/views/layout"), meta: {
            title: "", icon: "product-list"
        }
    }, {
        path: "returnOrder", name: "returnOrder", component: () => import("@/views/layout"), meta: {
            title: "", icon: ""
        }
    }, {
        path: "deliverOrder", name: "deliverOrder", component: () => import("@/views/layout"), meta: {
            title: "", icon: ""
        }
    }]
}];

export default router;


