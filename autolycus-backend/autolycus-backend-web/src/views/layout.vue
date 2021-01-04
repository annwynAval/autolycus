<template>
    <section class="application">
        <header class="header fixed-top">

        </header>
        <section class="section">
            <aside class="aside">

            </aside>
            <router-view class="main" />
        </section>
    </section>
</template>

<script>
export default {
    name: "layout"
}
</script>

<style scoped lang="sass">
@import "../style/variables"

.application
    width: 100vw
    height: 100vh

    .header
        height: $container-header-height
        background-color: $color-gray-300
        .navbar
            padding: 0 $default-padding

    .section
        display: flex
        height: 100%
        padding-top: $container-header-height

        .aside
            height: 100%
            width: $container-aside-width
            background-color: $color-gray-200

        .main
            width: calc(100% - #{$container-aside-width})
            height: 100%
            padding: $default-padding
            overflow: auto
</style>
