
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: [],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    console.log('options -->' + JSON.stringify(options))
    var that = this;
    mydata.sourceId = options.sourceId
    console.log('mydata.sourceId --->' + JSON.stringify(options.sourceId))
    mydata.commentId = "";
    mydata.replyUserName = "";
    //设置scroll的高度
    wx.getSystemInfo({
      success: function(res) {
        that.setData({
          scrollHeight: res.windowHeight,
          userId:app.globalData.haulUserInfo.id
        });
      }
    });
    mydata.page = 1;
    that.getPageInfo(mydata.page);
  }
})
