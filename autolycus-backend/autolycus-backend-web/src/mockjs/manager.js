const Mock = require("mockjs")

export function mockManagers() {
    return Mock.mock({
        status: 0,
        message: "complete",
        model: null,
        'models|1-10': [{
            managerId: "@guid",
            managerName: "@cname",
            managerMail: "@email",
            roleId: "@guid",
            roleName: "@cname",
            managerPhone: "@integer(10000000000, 13800000000)",
            status: "@integer(0, 1)",
            registerDate: "@date(yyyy-MM-dd HH:mm:ss)"
        }],
        total: 22
    })
}

export function mockManagerDetail() {
    return Mock.mock({
        status: 0,
        message: "complete",
        model: {
            managerId: "@guid",
            managerName: "@cname",
            managerMail: "@email",
            roleId: "@guid",
            roleName: "@cname",
            managerPhone: "@integer(10000000000, 13800000000)",
            status: "@integer(0, 1)",
            registerDate: "@date(yyyy-MM-dd HH:mm:ss)"
        },
        models: null,
        total: 0
    })
}

export function mockRestPassword() {
    return Mock.mock({
        status: 0,
        message: "管理员密码已经重置, 请登录邮箱查看新密码",
        model: null,
        models: null,
        total: 0
    })
}

export function mockManagerInsert() {

}

export function mockManagerUpdate() {

}

export function mockManagerDelete() {

}
