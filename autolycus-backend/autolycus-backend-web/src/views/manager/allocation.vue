<template>
    <div>

    </div>
</template>

<script>
export default {
    name: "allocation",
    props: {
        visible: {
            type: Boolean,
            default: false
        },
        managerId: {
            type: String,
            required: true
        },
        roleId: {
            type: String,
            required: true
        },
        roles: {
            type: Array,
            required: true
        }
    },
    watch: {
        visible(newValue, oldValue) {
            if(!newValue) {
                return;
            }


        }
    }
}
</script>

<style scoped>

</style>
