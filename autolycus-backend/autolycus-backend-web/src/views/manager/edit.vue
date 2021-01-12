<template>
    <el-dialog title="编辑管理员信息" :visible.sync="visible" :before-close="handleClose"
               :close-on-click-modal="false" :close-on-press-escape="false" >
        <el-form ref="managerDetailForm" size="mini" label-width="120px" :model="model" :rules="rules" v-loading="loading">
            <el-form-item label="管理员名称">
                <el-input v-model="model.managerName" type="text" maxlength="24" placeholder="请输入管理员名称" />
            </el-form-item>
            <el-form-item label="管理员邮箱">
                <el-input v-model="model.managerMail" type="text" maxlength="24" placeholder="请输入管理员邮箱" />
            </el-form-item>
            <el-form-item label="所属权限">
                {{ mode.roleName }}
            </el-form-item>
            <el-form-item label="管理员电话">
                <el-input v-model="model.managerPhone" type="text" maxlength="18" placeholder="请输入管理员电话" />
            </el-form-item>
            <el-form-item label="管理员状态">
                {{ convertStatus(model.status) }}
            </el-form-item>
            <el-form-item class="text-right">
                <el-button class="fixed-width" size="mini" type="primary" @click="handleSubmit">确认</el-button>
                <el-button class="fixed-width" size="mini" type="primary" plain @click="handleClose">取消</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>
</template>

<script>
import {fetchManagerDetail, insertManagerDetail, updateManagerDetail} from "@/axios/manager";
import {showDefaultMessage} from "@/utils/utils";
import {convertStatus} from "@/mixin/ConstConvertUtils";

export default {
    name: "edit",
    mixins: [convertStatus],
    props: {
        visible: {
            type: Boolean,
            default: false
        },
        managerId: {
            type: String,
            default: null
        },
        type: { // insert / edit
            type: String,
            required: true
        },
        roles: {
            type: Array,
            required: true
        }
    },
    data() {
        return {
            loading: false, title: "", model: {
                managerId: "", managerName: "", managerMail: "",
                roleId: "", managerPhone: "", status: "", registerDate: ""
            },
            rules: {
                managerName: [{
                    required: true, message: "管理员名称不能为空", trigger: "blur"
                }, {
                    max: 30, message: "管理员名称长度不能超过30个文字", trigger: "blur"
                }],
                managerMail: [{
                    required: true, message: "管理员邮箱不能为空", trigger: "blur"
                }, {
                    type: "email", message: "管理员邮箱不能为空", trigger: "blur"
                }, {
                    max: 30, message: "管理员邮箱长度不能超过30个文字", trigger: "blur"
                }],
                managerPhone: [{
                    required: true, message: "管理员手机不能为空", trigger: "blur"
                }, {
                    max: 18, message: "管理员手机长度不能超过18个文字", trigger: "blur"
                }]
            }
        }
    },
    created() {
        if(this.type === "edit") {
            this.title = "编辑管理员信息";
            this.loading = true;
            fetchManagerDetail(this.managerId).then(response => {
                this.model = response.data.model;
            }).finally(() => {
                this.loading = false;
            });
        } else {
            this.title = "新增管理员信息";
            this.model = {
                managerId: "", managerName: "", managerMail: "",
                roleId: "", managerPhone: "", status: "", registerDate: ""
            }
        }
    },
    methods: {
        handleClose() {
            this.$emit("close");
        },
        handleSubmit() {
            this.$refs["managerDetailForm"].validate(valid => {
                if(!valid) {
                    return;
                }
                if(this.type === "edit") {
                    this.handleSubmit();
                } else {
                    this.handleInsert();
                }
            });
        },
        handleUpdate() {
            this.loading = true;
            updateManagerDetail(this.model).then(response => {
                showDefaultMessage(response, this).then(() => {
                    if(response.data.status === 0) {
                        this.handleClose();
                    }
                })
            }).finally(() => {
                this.loading = false;
            });
        },
        handleInsert() {
            this.loading = false;
            insertManagerDetail(this.model).then(response => {
                showDefaultMessage(response, this).then(() => {
                    if(response.data.status === 0) {
                        this.handleClose();
                    }
                })
            }).finally(() => {
                this.loading = false;
            });
        }
    }
}
</script>

<style scoped>

</style>
