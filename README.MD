# Composite Build usage example

![Java CI with Gradle](https://github.com/andrei-punko/composite-build-usage-example/workflows/Java%20CI%20with%20Gradle/badge.svg)
[![Coverage](.github/badges/jacoco.svg)](https://github.com/andrei-punko/composite-build-usage-example/actions/workflows/gradle.yml)
[![Branches](.github/badges/branches.svg)](https://github.com/andrei-punko/composite-build-usage-example/actions/workflows/gradle.yml)

Based on [this](https://github.com/andrei-punko/spring-boot-2-template) Spring Boot app template.
Sources was not changed almost, only build script adjusted

## Prerequisites

- JDK 21
- Docker  
  Gradle isn't required because of embedded Gradle in the project

## Conception description

**Composite Build** is externalization of build by put dependencies and plugins into separate Git repository
(which added to project as [Git submodule](.gitmodules))

After that [build script](build.gradle.kts) looks like this:

```
import by.andd3dfx.build.*
import by.andd3dfx.build.Plugins.Companion.applyPlugins

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
        springDoc()
        swagger()
        postgres()
        h2()
        flywayCore()
        testContainers()
        postgresTestContainers()
        ...

        applyPlugins {
            springBoot()
        }
    }
}
```

## Initialize Git submodule with build configuration:
```
git submodule init
git submodule update
```

## How to build application:
```
gradlew clean build
```

## Run functional tests:

    cd func-test
    ./gradlew clean build

Check functional test report [here](func-test/build/spock-reports/index.html)
