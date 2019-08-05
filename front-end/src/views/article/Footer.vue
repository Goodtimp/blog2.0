<template>
  <div class='my-like'>
    <el-row>
      <el-button
        class="like-btn "
        @click='like'
        :type="isLike?'success':''"
        id='like'
        round
      >点赞({{likenum}})</el-button>
    </el-row>
    <v-comments></v-comments>
    <div style='padding-top:100px;'></div>
  </div>
</template>
<script>
import api from '@/assets/api.js'
import comments from './Comments'
export default {
  props: ['likenum'],
  data() {
    return {
      id: this.$route.params.id,
      isLike: false
    }
  },
  methods: {
    like() {
      if (!this.isLike) {
        api.AddLikeNum(this.id).then(res => {
          this.isLike = true
          if (res.data.return === '1') {
            this.$emit("likeNumberChange", this.likenum + 1)
          }
          else {
            this.$message({
              message: '你貌似已经点过赞了。',
              type: 'success'
            });
          }
        })
      }
      else {
        this.$message({
          message: '你只能点一次赞哦，不过你可以多打赏几次。',
          type: 'success'
        });
      }
    },
    startLike() {
      api.GetArticleLike(this.id).then(res => {
        if (res.return === '0') {
          this.isLike = true
        }
      })
    }
  },
  created() {
    this.startLike()
  },
  components: {
    'v-comments': comments
  }
}
</script>
<style>
.my-like {
  width: 90%;
  margin: 0 auto;
  padding-bottom: 1px;
  margin-bottom: 50px;
  text-align: center;
}
#like {
  width: 150px;
  height: 50px;
  font-size: 1em;
  margin-bottom: 2rem;
}

@media screen and (max-width: 750px) {
  #like {
    font-size: 0.8em;
    width: 90px;
    height: 40px;
  }
}
</style>
