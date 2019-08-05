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
import vAside from '@/components/aside/Index'
import main from './SpeechMain'

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
