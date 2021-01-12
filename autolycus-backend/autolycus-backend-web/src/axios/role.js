import service from "@/axios/service";

/**
 * 获取角色列表信息
 */
export function fetchRoles(condition) {
    return service({
        url: "/role/search.html",
        method: "post",
        data: condition
    });
}

/**
 * 获取角色的详细信息
 */
export function fetchRoleDetail(roleId) {
    return service({
        url: "/role/detail.html",
        method: "post",
        data: { roleId }
    })
}

export function insertRoleDetail(model) {
    return service({
        url: "/role/insert.html",
        method: "post",
        data: model
    })
}

export function updateRoleDetail(model) {
    return service({
        url: "/role/update.html",
        method: "post",
        data: model
    })
}


export function deleteRole(roleId) {
    return service({
        url: "/role/delete.html",
        method: "post",
        data: { roleId }
    })
}
