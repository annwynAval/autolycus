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
            permissions: ["", "", "", "", ""],
            menus: [{
                menuId: 1, menuName: "1", menuHref: "", menuIcon: "", parentMenuId: 0
            }, {
                menuId: 2, menuName: "2", menuHref: "", menuIcon: "", parentMenuId: 0
            }, {
                menuId: 3, menuName: "3", menuHref: "", menuIcon: "", parentMenuId: 0
            }, {
                menuId: 4, menuName: "4", menuHref: "", menuIcon: "", parentMenuId: 1
            }, {
                menuId: 5, menuName: "5", menuHref: "", menuIcon: "", parentMenuId: 1
            }, {
                menuId: 6, menuName: "6", menuHref: "", menuIcon: "", parentMenuId: 2
            }, {
                menuId: 7, menuName: "7", menuHref: "", menuIcon: "", parentMenuId: 2
            }, {
                menuId: 8, menuName: "8", menuHref: "", menuIcon: "", parentMenuId: 3
            }]
        },
        models: {},
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























