//app.js
App({
  globalData: {
    jkurl: "http://192.168.1.85:8082"
    // jkurl: "https://jingkai-background.phhyzy.com"
    , nature_category: '' //下面没设置，要从后台动态获取，医疗或者劳务
    , personal_code:"" //当前登录人的code
    , contact_number:"" //登录人手机号
    , openId:""     //当前登录人的微信Id
    , tempVoicePath: null // 语音文件
    , tempVideoPath: null //视频文件
    , tempImagePath: null //图片文件
    , image_url:null
    // , voicePrefix: "src/main/webapp/static/voices/" // 语音文件存放前缀
    // , videoPrefix: "src/main/webapp/static/videos/" // 视频文件存放前缀
    , imagePrefix: "src/main/webapp/static/images/order/" // 图片文件存放前缀
    // , voiceUrl: "/static/voices/" // 视频文件保存的时候  文件名字前缀
    // , videoUrl: "/static/videos/" // 视频文件保存的时候  文件名字前缀
    , imageurl: "/static/images/order/" // 图片文件保存的时候  文件名字前缀
    , completion_status: false // 是否有完成了一条工单。在完成工单后 回退到主页面，check用
    ,medicalTempImagePath:null//医疗工单的第二张图片的图片文件
    ,medicalImage_url:null//医疗工单的第二张图片的图片文件的路径
    ,mobile_phone_models:null//手机型号
    ,isFlag:true//修改密码后是否调整回登录页面后用
    ,oss : "http://yanglaooss.oss-cn-huhehaote.aliyuncs.com/jingkai"

  },

  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  },
  globalData: {
    userInfo: null
  }
})