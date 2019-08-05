<template>
  <el-main class='sub-main my-subindex-card'>
    <v-cart-article
      v-for='art in articles'
      :key='art.Id'
      :PostedTime='art.PostedTime'
      :Likenum='art.Likenum'
      :id='art.Id'
      :Hits='art.Hits'
      :cartImage='art.BackgroundPath'
      :title='art.ArticleName'
      :content='art.Content'
    ></v-cart-article>
    <el-row class="my-subindex-loading-bottom">
      <el-button
        class='my-more-btn'
        size='big'
        @click='GetNextPage'
        :disabled="parseInt(page)<=0"
      >{{zhanyong===1?'加载中...':'加载更多'}}</el-button>
    </el-row>
  </el-main>
</template>
<script>
import cart from '@/components/articlecard/Index'
import api from '@/assets/api.js'
import { Loading } from 'element-ui';

export default {
  data() {
    return {
      id: '',
      page: 1,
      zhanyong: 0,
      articles: [],
      categoryHeader: {
        id: '',
        bgImgPath: '',
        headline: '',
        introduction: '',
        imgpath: ''
      }
    }
  },
  methods: {
    GetSubId () {
      this.categoryHeader.id = this.$route.params.id
      this.page = 1
    },
    /* GetHeaderMessage () {
         if (this.categoryHeader.id > 0) {
           api.getCategoryById(this.categoryHeader.id).then(data => {
             this.categoryHeader.bgImgPath = api.changeImagePath(data.BackgroundPath)
             this.categoryHeader.headline = data.CategoryName
             this.categoryHeader.introduction = data.Intor
               this.categoryHeader.imgpath = api.changeImagePath(data.CategoryLog)
          })
         } else if (this.categoryHeader.id === -1) {
           this.categoryHeader.headline = 'Hidden'
         } else {
           this.categoryHeader.headline = 'ALL'
         }
       },
    */
    GetArticle () {
      let loadingInstance = Loading.service({ fullscreen: false, target:'.my-subindex-card', customClass:'my-subindex-loading' })
      this.zhanyong = 1
      api.getSameArticleByCId(this.categoryHeader.id).then(data => {
        this.articles = data
        if (parseInt(data.length) !== 5) this.page = 0
        this.zhanyong = 0
        loadingInstance.close()
      }).catch(re=>{
        loadingInstance.close()
      })
    },
    GetNextPage () {
      if (this.page > 0 && this.zhanyong === 0) {
        let loadingInstance = Loading.service({ fullscreen: false,target:'.my-subindex-loading-bottom' })
        this.zhanyong = 1
        api.getSameArticleByCIdPage(this.categoryHeader.id, this.page).then(data => {
          this.articles = this.articles.concat(data)
          this.page++
          if (data !== undefined && parseInt(data.length) !== 5) this.page = 0
          this.zhanyong = 0
          loadingInstance.close()
        }).catch(re=>{
        loadingInstance.close()
      })
      }
    }
  },
  created () {
    this.GetSubId()
    this.GetArticle()
  },
  watch: {
    $route () {
      this.GetSubId()
      this.GetArticle()
    }
  },
  components: {
    'v-cart-article': cart
    // 'v-header': header
  },
  props: ['html']
}
</script>

<style lang="less" scope>
.sub-main {
  color: black;
  text-align: center;
}
.my-more-btn {
  margin: 70px 0 10px 0;
}
.el-main {
  padding:0!important;
  padding-top: 1rem!important;
}
.my-subindex-loading{
  .el-loading-spinner{
    position: fixed;
    left: calc(50% + 100px);
  }
}
</style>
