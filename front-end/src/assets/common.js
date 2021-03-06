/* jshint esversion: 6 */
export default {
  remInit () {
    let whdef = 16 / 450
    let wW = window.innerWidth // 当前窗口的宽度
    document.documentElement.style.fontSize = '16px'
    if (wW <= 450) {
      let rem = wW * whdef // 以默认比例值乘以当前窗口宽度,得到该宽度下的相应FONT-SIZE值
      rem = rem < 12 ? 12 : rem
      document.documentElement.style.fontSize = 16 + 'px'
      // $('html').css('font-size', rem + 'px')
    }
  },

  IsMobile () {
    var ua = navigator.userAgent
    var ipad = ua.match(/(iPad).*OS\s([\d_]+)/)
    var isIphone = !ipad && ua.match(/(iPhone\sOS)\s([\d_]+)/)
    var isAndroid = ua.match(/(Android)\s+([\d.]+)/)
    var isMobile = isIphone || isAndroid
    // 判断
    return isMobile
  },
  /** 判断是否为网址的正则 */
  IsURL (url) {
    var strRegex = '^((https|http|ftp|rtsp|mms)?://)' +
      "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" + // ftp的user@
      '(([0-9]{1,3}\.){3}[0-9]{1,3}' + // IP形式的URL- 199.194.52.184
      '|' + // 允许IP和DOMAIN（域名）
      "([0-9a-z_!~*'()-]+\.)*" + // 域名- www.
      '([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\.' + // 二级域名
      '[a-z]{2,6})' + // first level domain- .com or .museum
      '(:[0-9]{1,4})?' + // 端口- :80
      '((/?)|' + // a slash isn't required if there is no file name
      "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$"
    var re = new RegExp(strRegex)
    // re.test()
    if (re.test(url)) {
      return (true)
    } else {
      return (false)
    }
  },
  // 修改时间格式
  changeTimeFormat (time) {
    if (time.indexOf('T') > -1) {
      time = time.replace('T', ' ')
    }
    if (time.indexOf('.') > 0) {
      time = time.substr(0, 19)
    }
    return time
  },
  /** 获取给定时间与当前时间的间隔月份 */
  getDifferMonths (time) {
    var myDate = new Date()
    var nowMonths = Number(myDate.getMonth() + 1 + myDate.getFullYear() * 12) // getMonth中为0-11月

    time = this.changeTimeFormat(time)
    var timeMonths = Number(time.substr(0, 4)) * 12 + Number(time.substr(5, 2))

    return nowMonths - timeMonths
  }
}
