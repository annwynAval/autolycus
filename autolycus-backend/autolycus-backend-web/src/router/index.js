import Vue from "vue"
import Router from "vue-router"

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
        path: "/", redirect: "/home", component: () => import("@/views/layout.vue"), children: [{
            path: "/home", component: () => import("@/views/home"), meta: {
                title: "home"
            }
        }, {
            path: "/manager", component: () => import("@/views/manager"), meta: {
                title: "manager"
            }
        }]
    }, {
        path: "*", redirect: "/404"
    }]
});

//const existedRouteChildren = {
//    1: {
//        path: "user", component: () => import("@/views/home"), meta: {
//            title: ""
//        }
//    }
//};
//router.beforeEach((to, from, next) => {
//    console.log(store, store.getters);
//    if(getClientToken()) {
//        if(to.path === "/login") {
//            return next("/");
//        } else {
//            return getManagerDetail(to, from, next);
//        }
//    } else {
//        if(to.path === "/login") {
//            return next();
//        } else {
//            return next(`/login?redirect=${to.fullPath}`);
//        }
//    }
//});
//
//function getManagerDetail(to, from, next) {
//    if(store.getters.managerDetail) {
//        return next();
//    }
//    // 获取登录用户信息
//    fetchManagerDetail(getClientToken()).then(response => {
//        console.log(response.data.model);
//        store.dispatch("setManagerDetails", response.data.model).then(() => {
//            router.addRoutes([{
//                path: "", redirect: "home", component: () => import("@/views/layout"), children: getAsyncRoutes()
//            }, {
//                path: "*", redirect: "/404"
//            }]);
//            next();
//        });
//    }).catch(() => {
//        next("/401");
//    });
//}
//
//function getAsyncRoutes() {
//    let asyncRouteChildren = [];
//    store.getters.menus.filter(item => {
//        return item.parentMenuId !== 0
//    }).forEach(item => {
//        if(existedRouteChildren[item.menuId]) {
//            asyncRouteChildren.push(existedRouteChildren[item.menuId]);
//        }
//    });
//    defaultRouteChildren.forEach(item => asyncRouteChildren.push(item));
//    return asyncRouteChildren;
//}

export default router;


