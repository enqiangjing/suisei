module.exports = {
  devServer: {
    proxy: {
      //配置多个跨域
      "/login": {
        target: "http://212.64.59.206:9602/",
        changeOrigin: true,
        // ws: true,//websocket支持
        secure: false,
        pathRewrite: {
          "^/login": "/login"
        }
      },
      "/api": {
        target: "http://212.64.59.206:9602/api",
        changeOrigin: true,
        //ws: true,//websocket支持
        secure: false,
        pathRewrite: {
          "^/api": ""
        }
      }
    }
  }
};
