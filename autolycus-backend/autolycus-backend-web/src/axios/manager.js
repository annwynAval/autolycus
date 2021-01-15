import service from "@/axios/service";

/**
 * 获取管理员列表信息
 */
export function fetchManagers(condition) {
    return service({
        url: "/manager/search.html",
        method: "post",
        data: condition
    });
}

/**
 * 获取管理员详细信息, 不包括密码
 */
export function fetchManagerDetail(managerId) {
    return service({
        url: "/manager/detail.html",
        method: "post",
        data: {managerId}
    });
}

/**
 * 重置管理员密码信息
 */
export function resetManagerPassword(managerId) {
    return service({
        url: "/manager/rest-password.html",
        method: "post",
        data: {managerId}
    });
}

/**
 * 设定管理员权限
 */
export function allocationManagerRole(managerId, roleId) {
    return service({
        url: "/manager/allocation.html",
        method: "post",
        data: {managerId, roleId}
    })
}

/**
 * 删除用户
 */
export function deleteManagerDetail(managerId) {
    return service({
        url: "/manager/delete.html",
        method: "post",
        data: {managerId}
    })
}

/**
 * 保存数据
 */
export function insertManagerDetail(model) {
    return service({
        url: "/manager/insert.html",
        method: "post",
        data: model
    });
}

/**
 * 更新数据
 */
export function updateManagerDetail(model) {
    return service({
        url: "/manager/update.html",
        method: "post",
        data: model
    })
}

