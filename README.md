# Service Management System

## `mysql`

- Docker Container

```bash
docker run --detach --network srv-mnt --name srv-mnt -e MYSQL_ROOT_PASSWORD=demo@123 -p 3306:3306 -d mysql --lower_case_table_names=1
```

- Spring DataSource

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/srv-mnt?createDatabaseIfNotExist=true
    username: root
    password: demo@123
    driverClassName: com.mysql.cj.jdbc.Driver
```

- JDBC Library

```groovy
    // https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
implementation group: 'com.mysql', name: 'mysql-connector-j', version: '8.0.33'
```

- MyBatis Mapper Location

```yaml
mybatis:
  mapper-locations: "classpath:app.demo.mybatis.repository/*.xml"
```

```bash
docker run --detach --name auth -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.1.2 start-dev 
```
