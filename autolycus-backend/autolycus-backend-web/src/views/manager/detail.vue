<template>
    <el-dialog width="60%" title="查看管理员详细信息"
               :visible.sync="visible" :before-close="handleClose"
               :close-on-press-escape="false" :close-on-click-modal="false">
        <el-row class="column-control" v-loading="this.loading">
            <el-col :md="24">
                <label class="column-label">管理员名称: </label>
                <div class="column-plain">{{ model.managerName }}</div>
            </el-col>
            <el-col :md="24">
                <label class="column-label">管理员邮箱: </label>
                <div class="column-plain">{{ model.managerMail }}</div>
            </el-col>
            <el-col :md="24">
                <label class="column-label">所属权限: </label>
                <div class="column-plain">{{ model.roleName }}</div>
            </el-col>
            <el-col :md="24">
                <label class="column-label">管理员电话: </label>
                <div class="column-plain">{{ model.managerPhone }}</div>
            </el-col>
            <el-col :md="24">
                <label class="column-label">管理员状态: </label>
                <div class="column-plain">{{ convertStatus(model.status) }}</div>
            </el-col>
            <el-col :md="24">
                <label class="column-label">创建时间: </label>
                <div class="column-plain">{{ model.registerDate }}</div>
            </el-col>
        </el-row>
    </el-dialog>
</template>

<script>
import {fetchManagerDetail} from "@/axios/manager";
import {convertStatus} from "@/mixin/ConstConvertUtils";

export default {
    name: "detail",
    props: {
        visible: {
            type: Boolean,
            default: false
        },
        managerId: {
            type: String,
            required: true
        }
    },
    mixins: [convertStatus],
    data() {
        return {
            loading: false, model: {
                managerId: "", managerName: "", managerMail: "",
                roleId: "", roleName: "", managerPhone: "", status: "", registerDate: ""
            }
        }
    },
    watch: {
        visible(newValue, oldValue) {
            if(!newValue) {
                return;
            }
            this.loading = true;
            fetchManagerDetail(this.managerId).then(response => {
                this.model = response.data.model;
            }).finally(() => {
                this.loading = false;
            });
        }
    },
    methods: {
        handleClose() {
            this.$emit("close");
        }
    }
}
</script>

<style scoped>

</style>
