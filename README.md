# spring-cloud-boot-docker构建微服务
```text
本项目采用spring-cloud-boot-docker为基础架构,目的在于搭建一个微服务快速开发脚手架.
```
[网关接口汇总测试地址](http://111.231.189.44:8768/swagger-ui.html)

* 环境搭建
```text
准备一台centos7 内存4G+, 安装如下插件
1. jdk8
2. maven
3. git
4 .mysql
5. docker 
6. docker-compose
7. 使用docker安装rancher
```
* 技术选型
```text
1. Hibernate-Validator 参数校验框架
2. Mybatis 数据库框架
3. hutool工具类
4. lombok插件
5. docker 编译插件,实现快速将jar打包成镜像(mvn package docker:build)
6. docker-compose 服务编排
7. zuul 服务网关
8. feign 服务调用
9. hystrix 熔断超时设置
10. Log4j2 日志框架
11.容器管理 Rancher       
```
* 未来愿景
```text
1. docker 将镜像上传私有库
2. docker 跨主机部署
3. docker 数据库多容器共享数据库
4. 集成rabbitMQ消息系统
5. 集成redis缓存插件
6. 实现mysql主从复制
7. 集成elk日志分析系统
8. 集成oss对象存储系统
9. 集成分库分表插件
10. zuul集成oauth2权限验证框架
```
* 部署运行
```text
1. git clone <url> 
2. 进入项目的当前目录,依次执行如下构建命令
   2.1 编译打包,排除测试类
   mvn clean package -Dmaven.test.skip=true
   2.2 构建镜像
   mvn package  docker:build
   mvn package -Dmaven.test.skip=true docker:build(推荐:排除测试类)
3. 构建成功,运行docker images出现如下页面 
4. 运行docker-compose up 启动服务  
```

![输入图片说明](https://github.com/qccr-twl2123/spring-cloud-test/blob/master/resources/images/spring-cloud-test-images.jpg "在这里输入图片标题")


### 业务系统介绍
* 系统架构图

![输入图片说明](https://images.gitbook.cn/11af6780-d79f-11e8-a10b-5f454c3ff2d1 "在这里输入图片标题")

* Demo 业务流程图

![输入图片说明](https://github.com/qccr-twl2123/spring-cloud-test/blob/master/resources/images/order-pay.png "在这里输入图片标题")

### 主要页面展示
* 服务注册中心

![输入图片说明](https://github.com/qccr-twl2123/spring-cloud-test/blob/master/resources/images/regsiter-page.jpg "在这里输入图片标题")

* 网关接口汇总页面

![输入图片说明](https://github.com/qccr-twl2123/spring-cloud-test/blob/master/resources/images/gateway-api-summary.jpg "在这里输入图片标题")

### 容器管理Rancher
```text
支持环境级别的基于角色的访问控制，方便用户通过角色配置控制用户或用户组对开发环境或者生产环境的访问权限
提供了可视化的运维界面
提供了主机资源管理、容器编排、扩容、缩容、资源监控、负载均衡、配置管理以及 API 调用等重要功能
```
* 应用界面
![输入图片说明](https://github.com/qccr-twl2123/spring-cloud-test/blob/master/resources/images/rancher-app.jpg "在这里输入图片标题")

* 应用拥有的服务

![输入图片说明](https://github.com/qccr-twl2123/spring-cloud-test/blob/master/resources/images/rancher-service.jpg "在这里输入图片标题")

* 应用创建的容器

![输入图片说明](https://github.com/qccr-twl2123/spring-cloud-test/blob/master/resources/images/rancher-container.jpg "在这里输入图片标题")

* 容器的详细信息

![输入图片说明](https://github.com/qccr-twl2123/spring-cloud-test/blob/master/resources/images/rancher-container-details.jpg "在这里输入图片标题")

### 网关鉴权方案
```text
本方案采用zuul集成oauth2协议
部署要点:
网关模块对外暴露端口
其他微服务模块不对外暴露端口
通过内网IP实现接口调用
```
* 获取授权(token有效期30d)
```text
http://111.231.189.44:8768/oauth/token?grant_type=client_credentials&scope=app&client_id=acme&client_secret=acmesecret

result:
{
  "access_token": "294d68ef-5d1c-4d07-9bc7-4e1132c2cef8",
  "token_type": "bearer",
  "expires_in": 2584089,
  "scope": "app"
}
```
* 拿到access_token请求接口,否则报权限错误
```text
http://111.231.189.44:8768/api/order/rest/order/getOrderInfoById?orderId=2&access_token=294d68ef-5d1c-4d07-9bc7-4e1132c2cef8
```
```text
不传access_token:
{
  "error": "unauthorized",
  "error_description": "Full authentication is required to access this resource"
}

传access_token:
{
  "code": 0,
  "success": true,
  "message": "success",
  "data": {
    "id": 2,
    "userId": 1,
    "commodityId": 1,
    "purchaesCount": 1,
    "payStatus": 1
  }
}
```


### 参考资料
[微服务一站式架构](https://gitbook.cn/gitchat/column/5b4fd439bf8ece6c81e44cfb?utm_source=zd180801)

[springcloud各组件超时时间设置](http://www.itmuch.com/spring-cloud-sum/spring-cloud-timeout/)

[rancher文档](https://rancher.com/docs/rancher/latest/zh/)

[微服务开发基础框架](https://github.com/babylikebird/Micro-Service-Skeleton.git)

[springcloud 实现github CAS 单点登录](https://segmentfault.com/a/1190000011098539#articleHeader4)

[springcloud和springboot版本兼容问题](http://www.yayihouse.com/yayishuwu/chapter/1557)