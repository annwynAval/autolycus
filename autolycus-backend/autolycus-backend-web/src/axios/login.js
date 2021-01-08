import service from "@/axios/service"

/**
 * 登录请求
 * @param username
 * @param password
 */
export function login(username, password) {
    return service({
        url: "/login.html",
        method: "post",
        data: {username, password}
    });
}

/**
 * 根据token获取当前登录用户的权限以及菜单树
 * @param clientToken
 */
export function fetchLoginDetail(clientToken) {
    return service({
        url: "/basic/managerDetail.html",
        method: "post",
        data: {clientToken}
    });
}

/**
 * 获取基本角色数据, 多用于检索时的下拉列表, 这个接口多处都需要用到, 不需要具体的权限设定
 */
export function fetchBasicRoles() {
    return service({
        url: "/basic/roles.html",
        method: "post"
    });
}

/**
 * 获取基本菜单详情树, 这个接口多处都需要用到, 不需要具体的权限设定
 */
export function fetchBasicPermissions() {
    return service({
        url: "/basic/permissions.html"
    })
}
