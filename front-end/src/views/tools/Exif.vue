<template>
  <el-container
    class='el-carousel'
    style='height:100%'
  >
    <v-aside></v-aside>
    <v-main> </v-main>
  </el-container>
</template>
<script>
// import aside from '../share/ElAside'

import vAside from '@/components/aside/Index'
import main from './ExifMain'

export default {
  data () {
    return {
    }
  },
  components: {
    vAside,
    'v-main': main
  }
}
</script>
<style>
</style>
