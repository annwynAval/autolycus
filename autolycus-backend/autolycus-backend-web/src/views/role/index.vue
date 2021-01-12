<template>
    <div class="role-layout">
        <el-form size="mini" label-width="120px" :model="searchCondition">
            <el-row>
                <el-col :md="12">
                    <el-form-item label="角色名称">
                        <el-input type="text" v-model="searchCondition.roleName" />
                    </el-form-item>
                </el-col>
                <el-col :md="12">
                    <el-form-item label="角色状态">
                        <el-select v-model="searchCondition.status">
                            <el-option :value="0" label="可用" />
                            <el-option :value="1" label="不可用" />
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :md="24" class="text-right">
                    <el-button class="fixed-width" size="mini" type="primary" @click="handlePageChange(1)">检索</el-button>
                    <el-button class="fixed-width" size="mini" type="primary" plain @click="resetCondition">重置</el-button>
                </el-col>
            </el-row>
        </el-form>
        <div class="table-toolbar" v-has-permission="'mms:role:add'">
            <el-button class="fixed-width" size="mini" type="primary" @click="handleInsertDetail">新增</el-button>
        </div>
        <el-table stripe fit :data="roleDetails.models" v-loading="roleDetails.loading">
            <el-table-column label="操作" class-name="operation-box" width="100">
                <template slot-scope="scope">
                    <font-awesome-icon :icon="['fa']" title="查看详情" v-has-permission="'mms:role:detail'"
                                       @click="handleShowDetail" />
                    <font-awesome-icon :icon="['fa']" title="编辑角色" v-has-permission="'mms:role:edit'"
                                       @click="handleEditDetail" />
                    <font-awesome-icon :icon="['fa']" title="删除角色" v-has-permission="'mms:role:delete'"
                                       @click="handleDeleteDetail" />
                </template>
            </el-table-column>
            <el-table-column label="角色名称" prop="roleName" />
            <el-table-column label="备注" prop="roleRemark" />
            <el-table-column label="管理员总数" prop="managerCount" />
        </el-table>
    </div>
</template>

<script>
import {DEFAULT_PAGINATION_SIZE} from "@/utils/utils";
import {fetchRoles} from "@/axios/role";

export default {
    name: "index",
    data() {
        return {
            roleDetails:{
                models: [], loading: false, pagination: {
                    index: 1, size: DEFAULT_PAGINATION_SIZE, total: 0
                }
            },
            searchCondition: {
                roleName: "", status: ""
            }
        }
    },
    created() {
        this.searchRoleDetails();
    },
    methods: {
        resetCondition() {
            this.searchCondition = {
                roleName: "", status: ""
            }
        },
        searchRoleDetails() {
            this.roleDetails.loading = true;
            fetchRoles(this.searchCondition).then(response => {
                this.roleDetails.models = response.data.models;
                this.roleDetails.pagination.total = response.data.total;
            }).finally(() => {
                this.roleDetails.loading = false;
            })
        },
        handlePageChange(currentPage) {
            this.roleDetails.pagination.index = currentPage;
            this.searchRoleDetails()
        },
        handleShowDetail() {

        },
        handleInsertDetail() {

        },
        handleEditDetail() {

        },
        handleDeleteDetail() {

        }
    }
}
</script>

<style scoped>

</style>
