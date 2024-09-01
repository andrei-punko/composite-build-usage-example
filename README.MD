
# Composite Build usage example

![Java CI with Gradle](https://github.com/andrei-punko/composite-build-usage-example/workflows/Java%20CI%20with%20Gradle/badge.svg)
[![Coverage](.github/badges/jacoco.svg)](https://github.com/andrei-punko/composite-build-usage-example/actions/workflows/gradle.yml)
[![Branches](.github/badges/branches.svg)](https://github.com/andrei-punko/composite-build-usage-example/actions/workflows/gradle.yml)

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
- JDK 21
- Docker

## How to build
```
git submodule init
git submodule update
gradlew clean build
```
