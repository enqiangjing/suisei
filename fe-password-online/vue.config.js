module.exports = {
  devServer: {
    proxy: {
      //配置多个跨域
      "/login": {
        target: "http://localhost:9602/",
        changeOrigin: true,
        // ws: true,//websocket支持
        secure: false,
        pathRewrite: {
          "^/login": "/login"
        }
      },
      "/api": {
        target: "http://localhost:9602/api",
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
