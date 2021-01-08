import store from "@/store"

export const DEFAULT_PAGINATION_SIZE = 20;

export function getClientToken() {
    let clientToken = store.getters.clientToken;
    if(!clientToken) {
        clientToken = window.localStorage.getItem("client_token");
        if(clientToken) {
            store.dispatch("setClientToken", clientToken);
        }
    }
    return clientToken;
}

export function resolveMenuTree(menus) {
    return menus.filter(item => {
        return item.parentMenuId === 0;
    }).map(parent => {
        parent.children = menus.filter(template => {
            return template.parentMenuId === parent.menuId;
        });
        return parent;
    });
}

export function showDefaultMessage(response, $this) {
    return $this.$alert({
        title: "消息提示",
        message: response.data.message,
        type: response.data.status === 0 ? "success" : "error"
    })
}

