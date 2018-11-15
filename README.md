# spring-cloud-boot-docker构建微服务
```text
本项目采用spring-cloud-boot-docker为基础架构,目的在于搭建一个微服务快速开发脚手架.
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
```