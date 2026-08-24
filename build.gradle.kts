import by.andd3dfx.build.*
import by.andd3dfx.build.Plugins.Companion.plugins

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

        plugins {
            springBoot()
        }
    }
}
