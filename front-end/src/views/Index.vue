
<template>
  <div
    class='el-carousel index-bg'
    style='height:100%'
  >
    <div class="my-left-aside my-hidden-xs-only">
      <v-aside></v-aside>
    </div>
    <div class="my-header-aside my-header-show-xs-only">
      <my-header-aside></my-header-aside>
    </div>
    <my-backtop :forContent="'.el-main'"></my-backtop>
    <div class="my-main my-show-xs-only">
      <router-view></router-view>
    </div>
  </div>
</template>
<script>
import vAside from '@/components/aside/Index'
import myBacktop from '@/components/backtop/Index'
import myHeaderAside from '@/components/aside/Header'
export default {
  name: 'Index',
  data() {
    return {
    }
  },
  components: {
    vAside,
    myBacktop,
    myHeaderAside
  }
}
</script>
<style>
::-webkit-scrollbar {
  width: 4px;
  background-color: transparent;
}

::-webkit-scrollbar-thumb {
  background-color: #888888eb;
}

body > .el-container {
  margin-bottom: 40px;
}
.my-main {
  float: right;
  left: 210px;
  background-color:white;
  width: calc(100vw - 220px);
}
.my-left-aside {
  width: 200px;
  height: 100vh;
  float: left;
  position: fixed;
  z-index: 1000;
}
.my-header-show-xs-only {
  display: none;
}
@media screen and (max-width: 750px) {
  .my-hidden-xs-only {
    display: none;
  }
  .my-show-xs-only {
    left: 0;
    width: 100vw;
  }
  .my-header-show-xs-only{
    widows: 100vw;
    display: block;
  }
}
@media screen and (min-width: 751px) {
  .my-header-show-xs-only {
    display: none;
  }
}
</style>
