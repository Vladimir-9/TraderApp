plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {

    jvmToolchain(21)

    androidTarget()

    sourceSets {
        commonMain.dependencies {

            implementation(libs.kotlinx.coroutines.core)
        }
    }
}

android {
    namespace = "ru.trader.core_network"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}