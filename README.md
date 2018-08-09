# spring-boot-starter-demo

1. install springboot
```
brew tap pivotal/tap
brew install springboot
```
2. create project using spring, replace xxx with dependency
`spring init --build maven --groupId com.example --version 0.0.1-SNAPSHOT --java-version 1.8 --dependencies xxx --name xxx-demo rabbitmq-demo`

3. spring boot starter demos

spring-boot-pom   | description
-------------- | ----------------
spring-boot-starter | 核心 POM，包含自动配置支持、日志库和对 YAML 配置文件的支持。
spring-boot-starter-amqp|通过 spring-rabbit 支持 AMQP
spring-boot-starter-aop| 包含 spring-aop 和 AspectJ 来支持面向切面编程（AOP）。
spring-boot-starter-batch|   支持 Spring Batch，包含 HSQLDB。
spring-boot-starter-data-jpa|    包含 spring-data-jpa、spring-orm 和 Hibernate 来支持 JPA。
spring-boot-starter-data-mongodb|    包含 spring-data-mongodb 来支持 MongoDB。
spring-boot-starter-data-rest|   通过 spring-data-rest-webmvc 支持以 REST 方式暴露 Spring Data 仓库。
spring-boot-starter-jdbc|    支持使用 JDBC 访问数据库。
spring-boot-starter-security|    包含 spring-security。
spring-boot-starter-test|    包含常用的测试所需的依赖，如 JUnit、Hamcrest、Mockito 和 spring-test 等。
spring-boot-starter-velocity|    支持使用 Velocity 作为模板引擎。
spring-boot-starter-web| 支持 Web 应用开发，包含 Tomcat 和 spring-mvc。
spring-boot-starter-websocket|   支持使用 Tomcat 开发 WebSocket 应用。
spring-boot-starter-ws|  支持 Spring Web Services。
spring-boot-starter-actuator|    添加适用于生产环境的功能，如性能指标和监测等功能。
spring-boot-starter-remote-shell|    添加远程 SSH 支持。
spring-boot-starter-jetty|   使用 Jetty 而不是默认的 Tomcat 作为应用服务器。
spring-boot-starter-log4j|   添加 Log4j 的支持。
spring-boot-starter-logging| 使用 Spring Boot 默认的日志框架 Logback。
spring-boot-starter-tomcat|  使用 Spring Boot 默认的 Tomcat 作为应用服务器。

## spring-boot-starter-data-elasticsearch 

es-demo 全文搜索引擎demo

---

1. mac本地安装elasticsearch 

`brew install elasticsearch` 默认是6.2.4

- Index/type/document 对应 mysql database/table/row
- 安装中文分词插件(必须下载对应的es版本) `elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.2.4/elasticsearch-analysis-ik-6.2.4.zip`

2. [安装elasticsearch监控](https://www.cnblogs.com/zklidd/p/6433123.html) 

3. 资源链接

- [中文社区](https://elasticsearch.cn)