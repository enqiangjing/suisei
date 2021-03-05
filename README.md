# 在线密码管理系统(Password Online)

> 版本：V0.0.1

</br>

### 介绍

- 线上密码管理系统
- 通过终端加密，远程服务器存储实现安全、便捷的在线密码管理

### 软件架构

- 前端使用 Vue2.6
- 后端使用 Spring Boot

### 安装教程

- 前端代码目录： ./fe-password-online，详见目录下 readme
- 移动端代码
- 后端代码目录： ./be-password-online，详见目录下 readme

### 使用说明

- 操作相关截图目录： ./z-pictures/\*\*
- 数据目录： ./z-all-data/password_online.sql
- 更新日志： ./CHANGELOG.md
- 密钥说明： 前端使用 RSA(应用 jsencrypt) 进行加密、解密，公钥可选择是否上传服务器；私钥由用户自己保存（无法上传服务器），所以服务端只保存了加密过的信息，不会造成信息泄露
- 密钥文件： 需自行生成，./z-all-data/ 下提供了测试用途的公钥和私钥

</br>

---

</br>

> 主页展示：

![alt 主页面](z-pictures/option/logo.png)  
![alt 主页面](z-pictures/option/mainShow.png)

</br>

**联系方式**

> 微信：Enqiang-Jing  
> 邮箱：enqiangjing@163.com

</br>
