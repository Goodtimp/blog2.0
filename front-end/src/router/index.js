import Vue from 'vue'
import Router from 'vue-router'
import {
  Loading
} from 'element-ui'

Vue.use(Router)
Vue.use(Router)
let spinRoute = {
  show() { //加载中显示loading组件
    return Loading.service({
      fullscreen: true
    }); //开启loading组件，这里我用的mint-ui
  },
  resolve(resolve, loadingInstance) { //加载完成隐藏loading组件
    return component => {
      setTimeout(() => {
        loadingInstance.close() //关闭loading组件
        resolve(component)
      }, 10)
    }
  }
}
export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [{
      path: '/tools/Exif',
      name: 'Exif',
      component: e => require(['@/views/tools/Exif.vue'], e)
    },
    {
      path: '/tools/speech',
      name: 'Speech',
      component: e => require(['@/views/tools/Speech.vue'], e)
    },
    {
      path: '/',
      name: 'Index',
      props: {
        leftShow: 1
      },
      component: e => {
        let temp = spinRoute.show()
        require(['@/views/Index.vue'], spinRoute.resolve(e, temp))
      },
      redirect: '/subindex/0',
      children: [{
          path: '/subindex/:id',
          name: 'subindex',
          component: e => {
            let temp = spinRoute.show()
            require(['@/views/subcatalog/ElMainSub.vue'], spinRoute.resolve(e, temp))
          }
          // component: e => require(['@/views/subcatalog/ElMainSub.vue'], e)
        },
        {
          path: '/article/:id',
          name: 'article',
          component: e => {
            let temp = spinRoute.show()
            require(['@/views/article/ElMain.vue'], spinRoute.resolve(e, temp))
          }
        },
      ]
      // redirect: '/subindex/0'
    }
  ]
})
