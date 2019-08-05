<template>
  <div id='app'>
    <router-view />
  </div>
</template>

<script>
import mycommon from './assets/common'
export default {
  data () {
    return {
    }
  },
  mounted () {
    mycommon.remInit()
    window.addEventListener('resize', function () {
      // 防止resize 覆盖
      mycommon.remInit()
    })
  }
}
</script>

<style lang='less'>
* {
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif !important;
  margin: 0;
  padding: 0;
}
</style>
