# IES Con Connector

[![Java CI with Gradle](https://github.com/kejiyuan306/IES-Con-Connector/actions/workflows/gradle.yaml/badge.svg)](https://github.com/kejiyuan306/IES-Con-Connector/actions/workflows/gradle.yaml)

IES Con Connector 用于与嵌入式设备交互。
调用该后端提供的接口，即可向设备发送查询、修改数据等指令，并获取指令的返回结果。

额外的，该后端会周期性地向设备发送查询指令，将接收到的数据进行处理后持久化。

它提供了一套 REST 风格的 API。
后端运行后，可以访问 URL `http://<your.deployment.domain.name>:8080/swagger-ui/` 查看接口文档。
其中 `<your.deployment.domain.name>` 是部署后端的服务器的域名，通常在本地调试可以使用 `localhost` 来访问。
另外，`8080` 是 Spring MVC 的默认端口，它可以通过修改 `application.yaml` 来配置。

## 特性

- 使用 Liquibase 对数据库进行版本管理
- 使用 SpringFox 自动生成接口文档
- 使用 Spotless 统一代码格式化
- 使用 Sonarlint 进行代码静态检查
- 使用 Commitlint 规范化 `git commit` 提交的信息

## 依赖

- JDK（最低版本 11）
- MySQL（最低版本 8.0 或 MariaDB）

## 快速开始

Clone 本仓库。

```shell
$ git clone https://github.com/kejiyuan306/IES-Con-Connector
```

切到项目目录并启动 Spring Boot 应用。

```shell
$ cd spring-boot-backend-template
$ ./gradlew bootRun
```

在浏览器中键入 `http://localhost:8080/swagger-ui/` 即可访问接口文档。

## Document generation

https://github.com/springfox/springfox

SpringFox will scan the `controller` package, and automatically generate API document.

When the application is running, these URLs are available:

- All Swagger Resources(groups)
   `http://localhost:8080/swagger-resources`
- Swagger UI endpoint
   `http://localhost:8080/swagger-ui/`
- Swagger docs endpoint
   `http://localhost:8080/v3/api-docs`

## Multiple environments

This template configures dev and prod environments via Spring Boot profiles. The default profile is dev.

Configuration for test environment is placed alone.

## Database

H2 Database is used for dev and test. MySQL is used for prod.

Notice that the password of MySQL should not be saved in the repository. You need to set the password of root user in the `MYSQL_ROOT_PASSWORD` environment variable to access to MySQL database.

### Version control

https://github.com/liquibase/liquibase
https://github.com/liquibase/liquibase-gradle-plugin
https://github.com/liquibase/liquibase-hibernate

The changelog file is the `db.changelog-master.yaml` in the `resources/db/changelog` directory.

You can use Liquibase Gradle plugin to maintain the changelog. To modify the database structure, you should follow this workflow:

1. Edit entities in the `entity` package
2. Run the `diffChangeLog` Gradle task
3. Check if the modified `db.changelog-master.yaml` does what you want, edit it if not
4. Run this application, the database will be synced by Liquibase

## Exception handling

Exception classes should be put in the `exception` package. And use the `@ResponseStatus` annotation to specify the HTTP status code.

## Code formatting

https://github.com/diffplug/spotless.

### Check the style

You can check format violations by runing the `spotlessCheck` Gradle task.

```shell
$ ./gradlew spotlessCheck
```

### Apply the style

If there are violations, run the `spotlessApply` Gradle task to perform formatting.

```shell
$ ./gradlew spotlessApply
```

### VS Code integration

You can install the [Spotless Gradle](https://marketplace.visualstudio.com/items?itemName=richardwillis.vscode-spotless-gradle) extension to lint and format your code.

## Code quality checking

https://remal.gitlab.io/gradle-plugins/plugins/name.remal.sonarlint/.

### Check main

Check Java source files in the `main` directory.

```shell
$ ./gradlew sonarlintMain
```

### Check test

Check Java source files in the `test` directory.

```shell
$ ./gradlew sonarlintTest
```

### VS Code integration

Install the [SonarLint](https://marketplace.visualstudio.com/items?itemName=SonarSource.sonarlint-vscode) extension to lint your code.

## Commit message checking

https://github.com/NetrisTV/gradle-commitlint-plugin

Pass a commit message to Commitlint Gradle plugin, the plugin will lint it against [Conventional Commits](https://www.conventionalcommits.org/) rules.

This plugin should be used with Git Hook

## Git hook

https://github.com/STAR-ZERO/gradle-githook

There are some hooks configured in this template:

| Hook         | Gradle task     |
| ------------ | --------------- |
| `pre-commit` | `spotlessCheck` |
| `pre-commit` | `sonarlintMain` |
| `pre-commit` | `sonarlintTest` |
| `commit-msg` | `commitlint`    |
