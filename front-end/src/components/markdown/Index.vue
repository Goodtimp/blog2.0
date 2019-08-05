<template>
  <mavon-editor
    style='line-height: 2em;'
    class='md my-content'
    :value='contents'
    :ishljs='true'
    :subfield='prop.subfield'
    :defaultOpen='prop.defaultOpen'
    :toolbarsFlag='prop.toolbarsFlag'
    :editable='prop.editable'
    :scrollStyle='prop.scrollStyle'
  ></mavon-editor>
</template>
<script>
export default {
  props: ['contents'],
  data () {
    return {
      prop: {
        bold: true, // 粗体
        italic: true, // 斜体
        header: true, // 标题
        underline: true, // 下划线
        strikethrough: true, // 中划线
        mark: true, // 标记
        superscript: true, // 上角标
        subscript: true, // 下角标
        subfield: false, // 单双栏模式
        defaultOpen: 'preview', // edit： 默认展示编辑区域 ， preview: 默认展示预览区域
        editable: false,
        toolbarsFlag: false,
        scrollStyle: true,
        table: true, // 表格
        readmodel: true, // 沉浸式阅读
        // boxShadow:true // 开启边框阴影
        ishljs: true
      }
    }
  }
}
</script>

<style lang="less" scope>
.my-content {
  width: 100%;
  margin: 0 auto;
  margin-bottom: 4rem;
  animation: myfirst 1s;
  -moz-animation: myfirst 1s; /* Firefox */
  -webkit-animation: myfirst 1s; /* Safari 和 Chrome */
  -o-animation: myfirst 1s; /* Opera */

  img {
    margin: 10px 0 !important;
    max-height: 600px !important;
  }

  .hljs {
    background: #f6f8fa !important;
  }
  .v-show-content {
    background-color: white !important;
    padding-bottom: 2em;
  }
  a[target="_blank"] {
    margin: 0 3px !important;
    border-bottom: 1px dotted #0366d6 !important;
    word-break: break-all !important;
  }
  strong {
    margin: 0 2px !important;
    // color: #424242 !important;
    // font-weight: 500 !important;
    font-weight: bold !important;
    color: #b71c1c;
  }
  a:hover {
    text-decoration: none !important;
    border-bottom: 1px solid #0366d6 !important;
    color: #0074f8 !important;
  }
  h1,
  h2 {
    margin-top: 2em !important;
    border-bottom: 1px solid #eaecef !important;
  }
  h1 {
    font-size: 1.7em !important;
  }
  h1::before {
    content: "#";
    margin-right: 0.8rem;
    color: #429fff;
  }
  h2::before {
    content: " ##";
    font-size: 0.95em;
    margin-right: 0.8rem;
    color: #429fff;
  }
  h3 {
    margin-top: 1.5em !important;
  }
  hr {
    height: 0.1em !important;
  }
  .v-note-panel.shadow {
    box-shadow: none !important;
    font-size: 0.95rem;
  }
  h1,
  h2,
  h3,
  h4,
  h5,
  h6 {
    font-weight: 500 !important;
    color: #444 !important;
  }
}
.v-note-wrapper {
  min-width: 0px !important;
  min-height: 0px !important;
}
pre .hljs {
  font-size: 1.3em;
}

@keyframes myfirst {
  from {
    opacity: 0;
    bottom: -20px;
  }
  to {
    opacity: 1;
    bottom: 0px;
  }
}
@-webkit-keyframes myfirst {
  from {
    opacity: 0;
    bottom: -20px;
  }
  to {
    opacity: 1;
    bottom: 0px;
  }
}

@media screen and (max-width: 750px) {
  .my-content {
    width: 100%;
    padding: 0px;
    font-size: 90% !important;
  }
  .my-content .v-note-panel {
    box-shadow: none !important;
  }
  .my-content .v-show-content {
    padding: 6px !important;
  }
}
</style>
