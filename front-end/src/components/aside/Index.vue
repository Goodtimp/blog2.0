<template>
  <div class="my-aside">
    <el-menu
      default-active="1-4-1"
      class="el-menu-vertical-demo"
      :collapse="isCollapse"
      :router="true"
      :mode="asideMode"
    >
      <div
        class="my-left-header"
      >
        <img src="data:image/jpeg;base64,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" />
      </div>
      <el-menu-item
        class="left-aside-item"
        v-for="cate in category"
        :id="cate.Id"
        :key="cate.Id"
        :index="cate.id.toString()"
        :route="'/subindex/' + cate.id"
      >
        <i :class="'sub-icon el-icon-blog-' + cate.CategoryName"></i>
        <span slot="title">{{cate.CategoryName}}</span>
      </el-menu-item>
    </el-menu>
    <v-footer ref="myFooter"></v-footer>
  </div>
</template>

<script>
import api from '@/assets/api.js'
import footer from './Footer'
export default {
  data () {
    return {
      asideMode: '',
      isCollapse: false,
      data: '',
      category: []
    }
  },
  methods: {
    GetAllCategory () {
      api.getAllCategory().then(data => {
        for (var i = 0; i < data.length; i++) {
          this.category.push({ id: data[i].Id, CategoryName: data[i].CategoryName })
        }
        this.category.push({ id: 0, CategoryName: 'All' })
      })
    }
  },
  created () {
    this.GetAllCategory()
  },
  components: {
    'v-footer': footer
  }
}
</script>

<style lang="less" scope>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  // width: 200px;
  min-height: 100vh;
}
.el-menu-vertical-demo {
  li {
    margin-left: 30px;
  }
}
.my-left-header {
  text-align: center;
  cursor: pointer;
  img {
    width: 50%;
    transition: width 0.3s;
    margin-top: 50px;
    margin-bottom: 10px;
    border: 1px solid #b2afaf78;
    border-radius: 50%;
    transition: 0.3s;
  }
  img:hover {
    border: 1px solid black;
  }
}
.left-aside-item {
  i {
    margin-right: 10px;
  }
}
.el-menu--collapse {
  li {
    text-align: center;
    margin-left: 0;
    i {
      margin-right: 0;
    }
  }
  img {
    margin-top: 10px;
    margin-bottom: 0;
    width: 40px;
    border: 0;
  }
}
.my-aside {
  position: relative;
  height:100vh;
  float:left;
  // width:200px;
}
</style>
