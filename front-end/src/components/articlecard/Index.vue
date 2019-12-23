<template>
  <el-row
    type="flex"
    class='my-cart'
    justify="center"
  >
    <el-col
      :xs="23"
      :sm="22"
      :md="20"
      :lg="18"
      :xl="16"
    >
      <el-card shadow="hover">
        <div slot="header" class="clearfix">
          <router-link :to="'/article/'+id">
            <span style="font-size:1.7rem;">{{title}}</span>
          </router-link>
        </div>
        <div calss="my-card-content">
          <my-markdown :contents="cardContent"></my-markdown>
          <div class="my-card-tag">
            <i class="el-icon-date"></i><span>{{PostedTime}}</span>
            <i class='el-icon-view'></i> <span>{{Hits}}</span>
            <i class='el-icon-star-off'></i> <span>{{Likenum}}</span>
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>
<script>
import myMarkdown from '@/components/markdown/Index'
export default {
  props: ['title', 'PostedTime', 'id', 'cartImage', 'content', 'Hits', 'Likenum'],
  data() {
    return {
    }
  },
  components: {
    myMarkdown
  },
  computed: {
    cardContent: function () {
      var reg = /[\\\`\*\_\[\]\#\+\-\!\>]/
      var img = /!\[\]\((.*?)\)/g
      // return this.content.replace(img, '').replace(reg, '').replace(/&8195;/g,'').replace(/&8194;/g,'').substr(0,100)
      var temp = this.content.replace(img, '[ 阅读详情可查看图片... ]').replace(/&#8195;/g, '').replace(/&nbsp;/g, '')
      var pos = temp.substr(0, 50).indexOf(reg)
      pos = pos === -1 ? 100 : pos
      return temp.substr(0, (pos > 200 ? 100 : pos) + 50) + "..."
    }
  }
}
</script>
<style lang="less" scope>
.my-cart {
  margin-bottom: 3rem;
  .el-card__header {
    background-color: black;
    color: white;
    padding: 0.7rem 1rem;
  }
  .el-card__body {
    padding: 0 1rem;
  }
  .my-content {
    max-height: 80vh;
    overflow: hidden;
    margin-bottom: 0 !important;
    h1 {
      margin-top: 2rem !important;
    }
  }
  .my-card-tag {
    font-size:0.9rem;
    text-align: right;
    color:#888888eb;
    margin-bottom: 1rem;
    span {
      margin: 0 1rem 0 0.4rem;
    }
  }
}
</style>
