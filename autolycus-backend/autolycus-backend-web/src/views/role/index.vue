<template>
    <div class="role-layout">
        <el-form size="mini" label-width="120px" :model="searchCondition">
            <el-form-item label="角色名称">
                <el-input type="text" v-model="searchCondition.roleName" />
            </el-form-item>
            <el-form-item label="角色状态">
                <el-select v-model="searchCondition.status">
                    <el-option :value="0" label="可用" />
                    <el-option :value="1" label="不可用" />
                </el-select>
            </el-form-item>
        </el-form>
        <div class="table-toolbar" v-hasPermission="'mms:role:add'">
            <el-button class="fixed-width" size="mini" type="primary">新增</el-button>
        </div>
        <el-table stripe fit :data="roleDetails.models" v-loading="roleDetails.loading">
            <el-table-column>

            </el-table-column>
        </el-table>
    </div>
</template>

<script>
import {DEFAULT_PAGINATION_SIZE} from "@/utils/utils";

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
    }
}
</script>

<style scoped>

</style>
