import service from "@/axios/service"

export function login(username, password) {
    return service({
        url: "/login.html",
        method: "post",
        data: {username, password}
    });
}

export function fetchManagerDetail(clientToken) {
    return service({
        url: "/getManagerDetail.html",
        method: "post",
        data: {clientToken}
    });
}
