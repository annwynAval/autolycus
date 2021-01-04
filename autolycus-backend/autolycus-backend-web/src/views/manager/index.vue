<template>
    <div class="manager-layout">
        <el-form size="mini" label-width="120px" :model="searchCondition">
            <el-row>
                <el-col :md="12" :lg="8">
                    <el-form-item label="管理员名称">
                        <el-input v-model="searchCondition.managerName" />
                    </el-form-item>
                </el-col>
                <el-col :md="12" :lg="8">
                    <el-form-item label="所属角色">

                    </el-form-item>
                </el-col>
                <el-col :md="12" :lg="8">
                    <el-form-item label="用户状态">

                    </el-form-item>
                </el-col>
                <el-col :md="24" class="text-right">
                    <el-button class="fixed-width" size="mini" type="primary">检索</el-button>
                    <el-button class="fixed-width" size="mini" type="primary" plain>重置</el-button>
                </el-col>
            </el-row>
        </el-form>
        <div class="table-toolbar">
            <el-button class="fixed-width" size="mini" type="primary">新增</el-button>
        </div>
        <el-table stripe :data="managerDetails.models" v-loading="managerDetails.loading">
            <el-table-column label="操作" class-name="operation-box" width="100">

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
            managerDetails: {
                models: [], loading: false, pagination: {
                    index: 1, size: DEFAULT_PAGINATION_SIZE, total: 0
                }
            },
            searchCondition: {
                managerName: ""
            }
        }
    }
}
</script>

<style scoped lang="sass">

</style>
