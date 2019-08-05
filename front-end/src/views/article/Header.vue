<template>
  <div class='my-header'>
    <h1>{{title}}</h1>
    <h4>
      <i class="el-icon-date"></i><span>{{time}}</span>
      <i class='el-icon-view'></i> <span>{{Hits}}</span>
      <i class='el-icon-star-off'></i> <span>{{Like}}</span>
    </h4>
  </div>
</template>
<script>
export default {
  data () {
    return {
      'height': '400'
    }
  },
  props: ['title', 'time', 'urlpath', 'Hits', 'Like']
}
</script>
<style lang="less">
.my-header {
  padding-top: 3rem ;
  h1 {
    font-size:1.7rem;
    font-weight: 500;
    text-align: center;
    margin-bottom: 1rem;
    color: #555;
    cursor: pointer;
  }
  h1:hover {
    color: #333;
  }
  h4 {
    text-align: center;
    color: #999;
    font-size:0.9rem;
    font-weight: 400;
    span {
      margin: 0 0.5rem 0 0.2rem;
    }
  }
}
@media screen and (max-width: 750px) {
}
</style>
