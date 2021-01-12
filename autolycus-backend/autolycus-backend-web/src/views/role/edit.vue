<template>
    <el-dialog title="编辑角色信息" :visible.sync="visible" :before-close="handleClose"
               :close-on-click-modal="false" :close-on-press-escape="false" >
        <el-form ref="roleDetailForm" size="mini" label-width="120px" :model="model" :rules="rules" v-loading="loading">
            <el-form-item label="角色名称">
                <el-input v-model="model.managerName" type="text" maxlength="24" placeholder="请输入角色名称" />
            </el-form-item>
            <el-form-item label="备注">
                <el-input v-model="model.managerMail" type="text" maxlength="24" placeholder="请输入备注" />
            </el-form-item>
            <el-form-item>
                <el-tree :data="permissions" :props="permissionProperties"
                         node-key="roleId" :default-checked-keys="model.selected"
                         lazy show-checkbox/>
            </el-form-item>
        </el-form>
    </el-dialog>
</template>

<script>
import {fetchManagerDetail, insertManagerDetail, updateManagerDetail} from "@/axios/manager";
import {showDefaultMessage} from "@/utils/utils";
import {fetchBasicPermissions, fetchBasicRoles} from "@/axios/login";
import service from "@/axios/service";
import {fetchRoleDetail} from "@/axios/role";

export default {
    name: "edit",
    props: {
        visible: {
            type: Boolean,
            default: false
        },
        roleId: {
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
            loading: false, title: "", permissions: [],
            model: {
                roleId: "", roleName: "", roleRemark: "", selected: []
            },
            permissionProperties: {
                label: "menuName", children: "children"
            },
            rules: {
                roleName: [{
                    required: true, message: "角色名称不能为空", trigger: "blur"
                }, {
                    max: 30, message: "角色名称长度不能超过30个文字", trigger: "blur"
                }],
                roleRemark: [{
                    max: 128, message: "角色备注长度不能超过128个文字", trigger: "blur"
                }]
            }
        }
    },
    created() {
        this.loading = true;
        if(this.type === "edit") {
            this.title = "编辑角色信息";
            service.all([fetchBasicPermissions(), fetchRoleDetail(this.roleId)])
            .then(service.spread((permissionDetail, roleDetail) => {
                this.permissions = permissionDetail.data.model;
                this.model = roleDetail.data.model;
            })).finally(() => {
                this.loading = false;
            });
        } else {
            this.title = "新增角色信息";
            fetchBasicPermissions().then(response => {
                this.permissions = response.data.model;
                this.model = { roleId: "", roleName: "", roleRemark: "", selected: [] };
            });
        }
    },
    methods: {
        handleClose() {
            this.$emit("close");
        },
        handleSubmit() {
            this.$refs["roleDetailForm"].validate(valid => {
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
