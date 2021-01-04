<template>
    <div class="application">
        <router-view/>
    </div>
</template>

<script>

export default {
    name: "Application"
}
</script>
<style scoped lang="sass">
@import "style/variables"

.application
    width: 100vw
    height: 100vh

//.navbar-container
//    position: fixed
//    top: 0
//    left: 0
//    width: 100%
//    height: $navbar-default-height
//
//.container
//    padding: $navbar-default-height 0 $player-default-height 0
//    height: 100%
//    display: flex
//
//    .menu-container
//        width: $menu-default-width
//        height: 100%
//
//    .main-container
//        flex: 1
//        overflow-y: scroll
//        width: 100%
//        height: 100%
//        padding: $default-padding / 2 $default-padding
//
//        & > div
//            margin: 0 auto
//            max-width: $container-default-width - $menu-default-width
//
//    .player-layout
//        position: fixed
//        left: 0
//        bottom: 0
//        width: 100%
//        height: $player-default-height
</style>
