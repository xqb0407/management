#           SpringBoot   |   Shiro项目实战

## management项目名称

**前端技术栈：ajax  Bootstrap**

**后端技术栈：SpringBoot JDBC Mysql Druid Shiro Maven** 

​					

#### 1、创建工程引入jar包

```properties
<dependencies>
    <!-- jdbc驱动-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
    <!--导入thymeleaf页面模板-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <!--引入 web支持 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!--引入shiro-->
    <dependency>
        <groupId>org.apache.shiro</groupId>
        <artifactId>shiro-all</artifactId>
        <version>1.2.2</version>
    </dependency>
    <!-- 引入Mysql数据库-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.25</version>
    </dependency>
    <!--引入数据库连接池-->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.1.12</version>
    </dependency>
    <!--引入springboot-mybatis启动器-->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.1.3</version>
    </dependency>

    <!--thymeleaf-extras-shiro依赖-->
    <dependency>
        <groupId>com.github.theborakompanioni</groupId>
        <artifactId>thymeleaf-extras-shiro</artifactId>
        <version>2.0.0</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
        <exclusions>
            <exclusion>
                <groupId>org.junit.vintage</groupId>
                <artifactId>junit-vintage-engine</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>
```

#### 2、配置文件application.yml

```properties
#配置端口号
server:
  port: 88


#配置数据库
spring:
  datasource:
    #mysql配置
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/management?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC
    username: root
    password: 123456
    #引入Druid数据源
    type: com.alibaba.druid.pool.DruidDataSource

mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: xyz.herther.pojo
```

#### 3、编写前端文件

