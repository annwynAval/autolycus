import store from "@/store"

const install = function (vue) {
    vue.directive("hasPermission", function (el, binding, vnode) {
        //console.log(arguments);
    });
}

export default install
