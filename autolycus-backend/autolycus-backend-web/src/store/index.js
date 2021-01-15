import Vue from "vue"
import Vuex from "vuex"
import router, {asyncRouters} from "@/router";

Vue.use(Vuex);

const getters = {
    routers: state => state.authentication.routers,
    permissions: state => state.authentication.permissions,
    clientToken: state => state.authentication.clientToken,
    authentication: state => state.authentication.authentication
}

const authentication = {
    namespace: true,
    state: {
        routers: undefined,
        permissions: undefined,
        clientToken: undefined,
        authentication: undefined
    },
    mutations: {
        SET_CLIENT_TOKEN: (state, clientToken) => {
            state.clientToken = clientToken;
        },
        SET_AUTHENTICATION: (state, authentication) => {
            state.authentication = authentication;
        },
        SET_PERMISSIONS: (state, permissions) => {
            state.permissions = permissions;
        },
        SET_ROUTERS: (state, routers) => {
            state.routers = routers;
        }
    },
    actions: {
        setClientToken({commit}, clientToken) {
            commit("SET_CLIENT_TOKEN", clientToken);
            window.localStorage.setItem("client_token", clientToken);
        },
        setAuthenticationDetails({commit}, authenticationDetail) {
            commit("SET_AUTHENTICATION", {
                roleName: authenticationDetail.roleName, managerName: authenticationDetail.managerName
            });
            commit("SET_PERMISSIONS", authenticationDetail.permissions);

            commit("SET_ROUTERS", authenticationDetail);
        }
    }
}

function getRouters(menus) {
    asyncRouters.filter(router)
}

function getMenus(menus) {
    asyncRouters.filter(router => {
        router.children.filter(child => {

        })
    })
}

const vuex = new Vuex.Store({
    modules: {
        authentication
    },
    getters
});

export default vuex;
