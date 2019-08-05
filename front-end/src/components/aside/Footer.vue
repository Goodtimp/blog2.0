<template>
  <div
    :style="showFooter?'height:auto':'height:0'"
    class='my-ElAsideSign'
  >
    <i class='el-icon-message'> 879636706@qq.com</i><br />
    <i class='el-icon-location'> 浙江·绍兴</i><br />
    <i class='el-icon-blog-github'><a
        href='https://github.com/goodtimep'
        target='view_window'
      > goodtimp</a></i>
    <br />
    <span class="my-friend-link">
      友链:
      <a
        href='http://www.gaogege.live'
        target='view_window'
      > ipso</a>
      <a
        href='http://www.mccyu.com/'
        target='view_window'
      > mccyu</a>
      <a
        href='http://www.yaopeng.top/'
        target='view_window'
      > yao</a>
      <a
        href='http://www.iimt.me/'
        target='view_window'
      > iimt</a>
      <a
        href='http://www.panxiandiao.com/'
        target='view_window'
      > Iron</a>
    </span>

    <!--<i class='el-icon-success'></i>-->
  </div>

</template>

<script>

export default {
  data () {
    return {
      showFooter: true
    }
  },
  methods: {
    changeShowFooter () {
      this.showFooter = !this.showFooter
    }
  }
}
</script>

<style lang="less">
.my-ElAsideSign {
  width: 100%;
  position: absolute;
  bottom: 10px;
  text-align: center;
  overflow: hidden;
  line-height: 1;
  color: #333;
  transition: 0.3s;
  .my-friend-link,
  i {
    font-weight: 300;
    font-size: 12px !important;
  }
}
</style>
