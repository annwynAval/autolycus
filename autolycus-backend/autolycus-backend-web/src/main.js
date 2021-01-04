import Vue from "vue"
import router from "@/router"
import store from "@/store"
import install from "@/directive";
import elementUI from "element-ui"
import Application from "@/Application"
import "@/style/common.sass"
import "element-ui/lib/theme-chalk/index.css"

require("promise.prototype.finally").shim();
if(process.env.NODE_ENV === "development") {
    Vue.config.devtools = true;
    require("@/mockjs")
} else {
    Vue.config.productionTip = false;
    Vue.config.silent = true;
}

import { library } from '@fortawesome/fontawesome-svg-core'
import { faUser, faKey } from "@fortawesome/free-solid-svg-icons"
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome"

library.add(faUser, faKey);
Vue.component('font-awesome-icon', FontAwesomeIcon);

Vue.use(elementUI);
Vue.use(install);

new Vue({
    router,
    store,
    render: handle => handle(Application)
}).$mount("#app");
