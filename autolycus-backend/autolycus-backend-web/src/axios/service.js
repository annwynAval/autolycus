import axios from "axios";
import qs from 'qs';
import {getClientToken} from "@/utils/utils";

const service = axios.create({
    baseURL: process.env.VUE_APP_REMOTE_URL,
});

service.interceptors.request.use(config => {
    config.headers["auth"] = getClientToken();
    if(!config.headers["content-type"] && config.data) {
        config.data = qs.stringify(config.data);
        config.headers["content-type"] = "application/x-www-form-urlencoded";
    }
    console.log(config);
    return config;
});

service.interceptors.response.use(response => {
    console.log(response);
    return response;
}, error => {
    console.log(error);
})

export default service;

