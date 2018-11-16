# spring-cloud-boot-docker构建微服务
```text
本项目采用spring-cloud-boot-docker为基础架构,目的在于搭建一个微服务快速开发脚手架.
```
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
```

![输入图片说明](https://github.com/qccr-twl2123/spring-cloud-test/blob/master/resources/images/spring-cloud-test-images.jpg "在这里输入图片标题")


### 业务系统介绍
* 系统架构图

![输入图片说明](https://images.gitbook.cn/11af6780-d79f-11e8-a10b-5f454c3ff2d1 "在这里输入图片标题")

* Demo 业务流程图

![输入图片说明](https://github.com/qccr-twl2123/spring-cloud-test/blob/master/resources/images/order-pay.png "在这里输入图片标题")

