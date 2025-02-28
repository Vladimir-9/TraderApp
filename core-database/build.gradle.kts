plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.sqlDelight)
}

kotlin {
    jvmToolchain(21)

    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    )

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.sqlDelight.runtime)
            implementation(libs.koin.core)
        }

        androidMain.dependencies {
            implementation(libs.sqlDelight.driver.android)
            implementation(libs.koin.core)
        }

        iosMain.dependencies {
            implementation(libs.sqlDelight.driver.native)
            implementation(libs.koin.core)
        }

    }
}

android {
    namespace = "ru.trader.traderApp.coreDatabase"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

sqldelight {
    databases {
        create("TraderDatabase") {
            packageName.set("ru.trader.traderApp.cache")
        }
    }
}