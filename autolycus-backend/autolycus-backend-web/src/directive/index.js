import store from "@/store"



const hasPermission = function(el, binding, vnode) {
    let permission = store.getters && store.getters.permissions;
    

}

const install = function (vue) {
    vue.directive("hasPermission", hasPermission)
}

export default install
