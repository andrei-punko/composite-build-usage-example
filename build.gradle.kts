import by.andd3dfx.build.*

service(version = "0.0.1") {
    dependencies {
        springBoot {
            web()
            test()
            dataJpa()
            validation()
        }

        lombok()
        apacheCommonsLang()
        mapstruct()
        springFox()
        postgres()
        flywayCore()
        testContainers()
        postgresTestContainers()
    }
}
