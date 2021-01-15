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
                        <el-select v-model="searchCondition.roleId" clearable placeholder="请选择">
                            <el-option v-for="item in roles" :key="item.roleId" :value="item.roleId" :label="item.roleName"/>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :md="12" :lg="8">
                    <el-form-item label="用户状态">
                        <el-select v-model="searchCondition.status" clearable placeholder="请选择" >
                            <el-option :value="0" label="不可用" />
                            <el-option :value="1" label="可用" />
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :md="24" class="text-right">
                    <el-button class="fixed-width" size="mini" type="primary" @click="handlePageChange(1)">检索</el-button>
                    <el-button class="fixed-width" size="mini" type="primary" plain @click="resetCondition">重置</el-button>
                </el-col>
            </el-row>
        </el-form>
        <div class="table-toolbar" v-has-permission="'mms:manager:add'">
            <el-button class="fixed-width" size="mini" type="primary" @click="handleInsertDetail">新增</el-button>
        </div>
        <el-table stripe fit :data="managerDetails.models" v-loading="managerDetails.loading">
            <el-table-column label="操作" class-name="operation-box" width="200">
                <template slot-scope="scope">
                    <font-awesome-icon :icon="['fa', 'eye']" title="查看详情" @click="handleShowDetail(scope.row)" />
                    <font-awesome-icon :icon="['fa', 'edit']" title="编辑" v-has-permission="'mms:manager:edit'"
                                       @click="handleEditDetail(scope.row)" />
                    <font-awesome-icon :icon="['fa', 'edit']" title="重置密码" v-has-permission="'mms:manager:edit'"
                                       @click="handleRestPassword(scope.row)" />
                    <font-awesome-icon :icon="['fa', 'edit']" title="删除管理员" v-has-permission="'mms:manager:delete'"
                                       @click="handleDeleteDetail(scope.row)" />
                    <font-awesome-icon :icon="['fa', 'edit']" title="修改权限" v-has-permission="'mms:role:allocation'"
                                       @click="handleAllocationRole(scope.row)" />
                </template>
            </el-table-column>
            <el-table-column label="用户名称" prop="managerName" />
            <el-table-column label="用户邮箱" prop="managerMail" />
            <el-table-column label="所属角色" prop="roleName" />
            <el-table-column label="电话号码" prop="managerPhone" />
            <el-table-column label="状态" prop="status" width="100">
                <template slot-scope="scope">
                    {{ convertStatus(scope.row.status) }}
                </template>
            </el-table-column>
            <el-table-column label="创建时间" prop="registerDate" />
        </el-table>
        <el-pagination small background layout="prev, pager, next"
                       :total="managerDetails.pagination.total"
                       :page-size="managerDetails.pagination.size"
                       :current-page="managerDetails.pagination.index"
                       @current-change="handlePageChange" />
        <detail-modal :visible="detailModal.visible" :manager-id="this.detailModal.managerId" @close="detailModal.visible = false"/>

        <edit-modal :visible="editModal.visible" :manager-id="this.editModal.managerId" :type="this.editModal.type" @close="editModal.visible = false" />

        <allocation-modal :visible="allocationModal.visible" :manager-id="this.allocationModal.managerId" :role-id="this.allocationModal.roleId"
                          :roles="roles" @close="allocationModal.visible = false" />
    </div>
</template>

<script>
import {DEFAULT_PAGINATION_SIZE, showDefaultMessage} from "@/utils/utils";
import {fetchBasicRoles} from "@/axios/login";
import {deleteManagerDetail, fetchManagers, resetManagerPassword} from "@/axios/manager";
import {convertStatus} from "@/mixin/ConstConvertUtils"
import EditModal from "@/views/manager/edit"
import DetailModal from "@/views/manager/detail";
import AllocationModal from "@/views/manager/allocation";

export default {
    name: "index",
    mixins: [convertStatus],
    components: {EditModal, DetailModal, AllocationModal},
    data() {
        return {
            roles: [],
            managerDetails: {
                models: [], loading: false, pagination: {
                    index: 1, size: DEFAULT_PAGINATION_SIZE, total: 0
                }
            },
            searchCondition: {
                managerName: "", roleId: "", status: ""
            },
            detailModal: {
                visible: false, managerId: ""
            },
            editModal: {
                visible: false, type: "insert", managerId: ""
            },
            allocationModal: {
                visible: false, managerId: "", roleId: ""
            }
        }
    },
    created() {
        this.searchBasicRoles();
        this.searchManagerDetails();
    },
    methods: {
        resetCondition() {
            this.searchCondition = {
                managerName: "", roleId: "", managerStatus: ""
            }
        },
        searchBasicRoles() {
            fetchBasicRoles().then(response => {
                this.roles = response.data.models;
            })
        },
        searchManagerDetails() {
            this.managerDetails.loading = true;
            fetchManagers(this.searchCondition).then(response => {
                this.managerDetails.models = response.data.models;
                this.managerDetails.pagination.total = response.data.total;
            }).finally(() => {
                this.managerDetails.loading = false;
            })
        },
        handlePageChange(currentPage) {
            this.managerDetails.pagination.index = currentPage;
            this.searchManagerDetails();
        },
        handleShowDetail(model) {
            this.detailModal.visible = true;
            this.detailModal.managerId = model.managerId;
        },
        handleEditDetail(model) {
            this.editModal.visible = true;
            this.editModal.type = "edit";
            this.editModal.managerId = model.managerId;
        },
        handleInsertDetail() {
            this.editModal.visible = true;
            this.editModal.type = "insert";
            this.editModal.managerId = "";
        },
        handleRestPassword(model) {
            resetManagerPassword(model.managerId).then(response => {
                showDefaultMessage(response.data.message, this).then(() => {
                    this.searchManagerDetails();
                });
            });
        },
        handleDeleteDetail(model) {
            this.$confirm({
                title: "确认删除? ",
                message: "确认删除当前管理员?"
            }).then(() => {
                deleteManagerDetail(model.managerId).then(response => {
                    showDefaultMessage(response.data.message, this).then(() => {
                        this.searchManagerDetails();
                    });
                });
            });
        },
        handleAllocationRole(model) {
            this.allocationModal.managerId = model.managerId;
            this.allocationModal.roleId = model.roleId;
            this.allocationModal.visible = true;
        }
    }
}
</script>

<style scoped lang="sass">

</style>
