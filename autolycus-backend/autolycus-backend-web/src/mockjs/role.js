const Mock = require("mockjs")

/**
 * 获取角色列表信息
 */
export function mockRoles() {
    return Mock.mock({
        status: 0,
        message: "complete",
        model: null,
        'models|1-10': [{
            roleId: "@guid",
            roleName: "@cname",
            managerCount: "@integer(0, 1000)"
        }],
        total: 22
    })
}

export function mockRoleDetail() {
    return Mock.mock({
        status: 0,
        message: "complete",
        model: {

        },
        models: null,
        total: 0
    })
}

export function mockRoleInsert(model) {
    return Mock.mock({
        status: 0,
        message: "complete",
        model: null,
        models: null,
        total: 22
    })
}

export function mockRoleUpdate(model) {
    return Mock.mock({
        status: 0,
        message: "complete",
        model: null,
        models: null,
        total: 22
    })
}

export function mockRoleDelete(model) {
    return Mock.mock({
        status: 0,
        message: "complete",
        model: null,
        models: null,
        total: 22
    })
}

