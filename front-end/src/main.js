// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
/* jshint esversion: 6 */
import 'element-ui/lib/theme-chalk/index.css'
import ElementUI from 'element-ui'
import Vue from 'vue'
import App from './App'
import router from './router/index'
import Axios from 'axios'
import api from '@/assets/api.js'
import common from '@/assets/common.js'
import '@/assets/icon/iconfont.css'
import mavonEditor from 'mavon-editor'
// use
Vue.prototype.$axios = Axios
Vue.prototype.api = api// 定义全局
Vue.prototype.common = common// 定义全局
Axios.defaults.headers.post['Content-Type'] = 'application/x-www-fromurlencodeed'
Vue.use(ElementUI, { size: 'small', zIndex: 3000 })
Vue.config.productionTip = false

Vue.use(mavonEditor)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>',
  render: h => h(App)
})
