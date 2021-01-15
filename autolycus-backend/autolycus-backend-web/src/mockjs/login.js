const Mock = require("mockjs")

export function mockLogin(request, response) {
    return Mock.mock({
        status: 0,
        message: "complete",
        model: "@guid",
        models: {},
        total: 0
    })
}

export function mockLoginDetail(request, response) {
    return Mock.mock({
        status: 0,
        message: "complete",
        model: {
            managerName: "@email",
            roleName: "管理员",
            permissions: [
                "mms:manager:add", "mms:manager:edit", "mms:manager:delete",
                "mms:role:add", "mms:role:edit", "mms:role:delete", "mms:role:allocation"
            ],
            menus: [{
                menuId: "@guid", menuName: "后台管理", menuHref: "", menuIcon: "", parentMenuId: 0
            }, {
                menuId: "@guid", menuName: "系统管理", menuHref: "", menuIcon: "", parentMenuId: 0
            }, {
                menuId: "@guid", menuName: "商城管理", menuHref: "", menuIcon: "", parentMenuId: 0
            }, {
                menuId: "@guid", menuName: "管理员管理", menuHref: "", menuIcon: "", parentMenuId: 1
            }, {
                menuId: "@guid", menuName: "角色管理", menuHref: "", menuIcon: "", parentMenuId: 1
            }]
        },
        models: null,
        total: 0
    })
}

export function mockBasicRoles() {
    return Mock.mock({
        status: 0,
        message: "complete",
        model: null,
        'models|1-10': [{
            roleId: "@guid",
            roleName: "@cname"
        }],
        total: 20
    })
}

export function mockBasicPermissions() {
    return Mock.mock({
        status: 0,
        message: "complete",
        model: {
            menuId: "@guid", menuName: "@cname", menuType: "@integer(0, 1)",
            menuIcon: "@cname", menuPermission: "@cname", "children|1-8": [{
                menuId: "@guid", menuName: "@cname", menuType: "@integer(0, 1)",
                menuIcon: "@cname", menuPermission: "@cname", "children|1-4": [{
                    menuId: "@guid", menuName: "@cname", menuType: "@integer(0, 1)",
                    menuIcon: "@cname", menuPermission: "@cname", "children|1-20": [{
                        menuId: "@guid", menuName: "@cname", menuType: "@integer(0, 1)",
                        menuIcon: "@cname", menuPermission: "@cname",
                    }]
                }]
            }]
        },
        models: null,
        total: 20
    })
}























