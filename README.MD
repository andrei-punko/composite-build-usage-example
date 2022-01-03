
# Composite Build usage example

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

Based on [this](https://github.com/andrei-punko/spring-boot-template) Spring Boot app template.
Sources was not changed, only build script adjusted
