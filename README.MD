# Composite Build usage example

[![Java CI with Gradle](https://github.com/andrei-punko/composite-build-usage-example/actions/workflows/gradle.yml/badge.svg)](https://github.com/andrei-punko/composite-build-usage-example/actions/workflows/gradle.yml)
[![Coverage](.github/badges/jacoco.svg)](https://github.com/andrei-punko/composite-build-usage-example/actions/workflows/gradle.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

Based on [this](https://github.com/andrei-punko/spring-boot-2-template) Spring Boot app template.
Sources was not changed almost, only build script adjusted

## Prerequisites

- JDK 21 (Spring Boot 2 + Gradle 8 are not compatible with Java 25)
- Docker
- Gradle (embedded)

## Conception description

`Composite Build` is externalization of build by put dependencies and plugins into separate Git repository
(which should be added as [Git submodule](.gitmodules) of project)

After that [build script](build.gradle.kts) will looks like this:

```kotlin
import by.andd3dfx.build.*
import by.andd3dfx.build.Plugins.Companion.applyPlugins

service(version = "0.0.1") {
    dependencies {
        springBoot(project) {
            web()
            test()
            dataJpa()
            validation()
            // ...
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
        // ...

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
./gradlew clean build
```

## How to run application:

```
run-app.bat
```

## Run functional tests:

```
cd func-test
./gradlew clean build
```

Check functional test report [here](func-test/build/spock-reports/index.html)
