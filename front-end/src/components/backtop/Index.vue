<template>
  <el-backtop
    :target="forContent"
    style="z-index:9999;"
  >
    <div class="my-back-top">
      <i class="el-icon-caret-top"></i>
    </div>
  </el-backtop>
</template>
<script>
export default {
  props: ['forContent']
}
</script>

<style>
.el-backtop {
  box-shadow: 0 0 3px rgba(0, 0, 0, 0.12) !important;
}
.my-back-top {
  height: 100%;
  width: 100%;
  border-radius: 100%;
  background-color: #fff;
  box-shadow: 0 0 3px rgba(0, 0, 0, 0.12) !important;
  text-align: center;
  line-height: 40px;
  color: black;
}
@media screen and (max-width: 750px) {
  .el-backtop {
    width: 2.5rem;
    height: 2.5rem;
    right: 1.5rem!important;
    bottom: 1.5rem!important;
    box-shadow: 0 0 3px rgba(0, 0, 0, 0.12) !important;
  }
  .my-back-top {
    height: 100%;
    width: 100%;
    border-radius: 100%;
    background-color: #fff;
    box-shadow: 0 0 3px rgba(0, 0, 0, 0.12) !important;
    text-align: center;
    line-height: 2.5rem;
    color: black;
  }
}
</style>
