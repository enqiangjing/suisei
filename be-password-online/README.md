# 密码中心

> 操作

```php
# 配置文件
be-password-online/src/main/resources/application-properties
改为:
be-password-online/src/main/resources/application.properties

# 项目导入
IDE中导入maven项目

#配置更新
application.properties：mysql、redis 地址、账号、密码更新为本机配置

# 数据库建立
mysql 导入根目录下 ./z-all-data/password_online.sql

# 发布
 打包运行
```

</br>

## Javadoc

> 说明

| 标签               | 说明                                                                                                              |
| :----------------- | :---------------------------------------------------------------------------------------------------------------- |
| @author            | 作者标识                                                                                                          |
| @version           | 版本号                                                                                                            |
| @return            | 对函数返回值的描述                                                                                                |
| @deprecated        | 标识过期 API（为了保证兼容性，仍可用，但不推荐用）                                                                |
| @throws            | 构造函数或方法会抛出的异常                                                                                        |
| @exception         | 同@throws                                                                                                         |
| @see               | 引用，查看相关的内容，如类，方法，变量等，必须顶头写                                                              |
| {@link 包.类#成员} | 引用，同@see，但可写在任意位置                                                                                    |
| {@value}           | 对常量注释，如果其值包含在文档中，通过改标签引用常量的值                                                          |
| {@code}}           | {@code text}将文本标记为 code，会被解析成 text } ,在 Javadoc 成只要涉及到类名或者方法名，都需要使用@code 进行标记 |
| @param             | 说明方法的参数                                                                                                    |
| @inheritDoc        | 用于继承父类中的 Javadoc，父类的文档注释，被继承到了子类                                                          |

> 注释

```$xslt
// 注释一行
/ *    */ 注释若干行
/**   ……*/  注释若干行，写入Javadoc文档
```

> 格式

```java
// 1. 方法
/**
* 方法的简述.
* 方法的详细说明第一行
* 方法的详细说明第二行
* @param 变量名 变量说明
* @return 没有返回值
*/
public void fn(boolean var) {}

// 2. 类
// 第一段：概要描述，通常用一句话或者一段话简要描述该类的作用，以英文句号结束
// 第二段：详细描述，通常用一段或者多段话来详细描述该类的作用，一般每段话都以英文句号作为结束
// 第三段：文档标注，用于标注作者，创建时间，参阅类等信息

// 3. 变量
// 第一行：变量作用
```
