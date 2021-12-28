import by.andd3dfx.build.service
import by.andd3dfx.build.springBoot

service(version = "0.0.1") {
    dependencies {
        springBoot {
            web()
            test()
        }
    }
}
