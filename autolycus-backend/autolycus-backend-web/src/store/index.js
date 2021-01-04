import Vue from "vue"
import Vuex from "vuex"

Vue.use(Vuex);

const getters = {
    menus: state => state.authentication.menus,
    permissions: state => state.authentication.permissions,
    clientToken: state => state.authentication.clientToken,
    managerDetail: state => state.authentication.managerDetail
}

const authentication = {
    namespace: true,
    state: {
        menus: [],
        permissions: [],
        clientToken: undefined,
        managerDetail: undefined
    },
    mutations: {
        SET_CLIENT_TOKEN: (state, clientToken) => {
            state.clientToken = clientToken;
        },
        SET_MANAGER_DETAIL: (state, managerDetail) => {
            state.managerDetail = {
                roleName: managerDetail.roleName,
                managerName: managerDetail.managerName
            };
        },
        SET_PERMISSIONS: (state, managerDetail) => {
            state.permissions = managerDetail.permissions;
        },
        SET_MENUS: (state, managerDetail) => {
            state.menus = managerDetail.menus;
        }
    },
    actions: {
        setClientToken({commit}, clientToken) {
            commit("SET_CLIENT_TOKEN", clientToken);
            window.localStorage.setItem("client_token", clientToken);
        },
        setManagerDetails({commit}, managerDetail) {
            commit("SET_MANAGER_DETAIL", managerDetail);
            commit("SET_PERMISSIONS", managerDetail);
            commit("SET_MENUS", managerDetail);
        }
    }
}

const vuex = new Vuex.Store({
    modules: {
        authentication
    },
    getters
});

export default vuex;
