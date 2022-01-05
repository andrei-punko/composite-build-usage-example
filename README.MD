
# Composite Build usage example

Based on [this](https://github.com/andrei-punko/spring-boot-template) Spring Boot app template.
Sources was not changed, only build script adjusted

## Approach description

**Composite Build** is externalization of build by put dependencies and plugins into separate Git repository
(which added to project as [Git submodule](.gitmodules))

After that [build script](build.gradle.kts) looks like this:
```
service(version = "0.0.1") {
    dependencies {
        springBoot {
            web()
            test()
            dataJpa()
            validation()
            ...
        }

        lombok()
        apacheCommonsLang()
        mapstruct()
        springFox()
        postgres()
        flywayCore()
        testContainers()
        postgresTestContainers()
        ...
    }
}
```

## Prerequisites
- JDK 11
- Docker

## How to build
```
git submodule init
git submodule update
gradlew clean build
```
