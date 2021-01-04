<template>
    <div class="login">
        <el-form ref="loginForm" class="login-form" :model="loginFormModel.model" :rules="loginFormModel.rules">
            <h2>商城管理系统</h2>
            <el-form-item prop="username">
                <el-input type="text" v-model="loginFormModel.model.username" placeholder="请输入用户名" />
            </el-form-item>
            <el-form-item prop="password">
                <el-input type="password" show-password v-model="loginFormModel.model.password" placeholder="请输入密码" />
            </el-form-item>
            <el-form-item class="login-submit">
                <el-button class="login-submit fixed-width" type="primary" @click="handleLogin" :loading="loginFormModel.loading">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>

import {login} from "@/axios/login"

export default {
    name: "login",
    data() {
        return {
            loginFormModel: {
                loading: false, model: {
                    username: "", password: ""
                }, rules: {
                    username: [{
                        required: true, trigger: "blur", message: "用户名不能为空"
                    }],
                    password: [{
                        required: true, trigger: "blur", message: "密码不能为空"
                    }]
                }
            },
            redirect: undefined
        }
    },
    created() {
        this.redirect = this.$route.query && this.$route.query.redirect;
    },
    methods: {
        handleLogin() {
            this.$refs["loginForm"].validate(valid => {
                console.log(valid)
                if(!valid) {
                    return ;
                }
                this.loginFormModel.loading = true;
                login(this.loginFormModel.model.username, this.loginFormModel.model.password).then(response => {
                    this.$store.dispatch("setClientToken", response.data.model).then(() => {
                        this.$router.push(this.redirect || "/");
                    });
                }).finally(() => {
                    this.loginFormModel.loading = false;
                });
            })
        }
    }
}
</script>

<style scoped lang="sass">
@import "src/style/variables"

.login
    display: flex
    justify-content: center
    align-items: center
    width: 100vw
    height: 100vh
    .el-form
        border-radius: $default-padding / 2
        background-color: $color-gray-100
        min-width: $default-padding * 25
        padding: $default-padding $default-padding * 2 0 $default-padding * 2
        +shadow-8dp
    h2
        margin: 0 auto $default-padding auto
        text-align: center
    .login-submit
        text-align: center

</style>
