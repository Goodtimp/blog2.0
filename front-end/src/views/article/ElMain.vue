<template>
  <el-main style='padding:0px;'>
    <v-header
      :title='myheader.title'
      :time='myheader.postedtime'
      :Hits='Hits'
      :Like="likenum"
      :urlpath='myheader.urlpath'
    ></v-header>
    <my-markdown :contents='content'></my-markdown>
    <v-footer
      :likenum='likenum'
      @likeNumberChange="changeLikeNumber"
    ></v-footer>
  </el-main>
</template>
<script>
import head from './Header'
import api from '@/assets/api.js'
import foot from './Footer'
import myMarkdown from '@/components/markdown/Index'
import { Loading } from 'element-ui';

export default {
  data () {
    return {
      Comments: [],
      like: '',
      articleid: '',
      myheader: [],
      content: '',
      likenum: '',
      Hits: ''
    }
  },
  methods: {
    GetArticleId () {
      let id = this.$route.params.id
      this.articleid = id
    },
    GetDetialMessage () {
       let loadingInstance = Loading.service({ fullscreen: false,target:'.my-content' })
     
      api.getArticleContentById(this.articleid).then(data => {
        this.Hits = data.Hits
        this.myheader.title = data.ArticleName
        this.myheader.postedtime = data.PostedTime
        this.myheader.urlpath = data.BackgroundPath
        this.content = data.Content
        this.likenum = data.Likenum
        loadingInstance.close()
      }).catch(re=>{
        loadingInstance.close()
      })
    },
    changeLikeNumber (val) {
      this.likenum = val
    }
  },
  mounted () {
    this.GetArticleId()
    this.GetDetialMessage()
  },
  components: {
    'v-header': head,
    'v-footer': foot,
    myMarkdown
  }
}
</script>
