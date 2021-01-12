import store from "@/store"

const hasPermission = {
    inserted(el, binding, node) {
        const hasPermission = store.getters.permissions.some(permission => {
            return permission === binding.value;
        });
        if(!hasPermission) {
            el.parentNode && el.parentNode.removeChild(el);
        }
    }
};
const nonePermission = {
    inserted(el, binding, node) {
        const hasPermission = store.getters.permissions.some(permission => {
            return permission === binding.value;
        });
        if(hasPermission) {
            el.parentNode && el.parentNode.removeChild(el);
        }
    }
}

const install = function (vue) {
    vue.directive("has-permission", hasPermission);
    vue.directive("none-permission", nonePermission);
}

export default install
