plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {

    jvmToolchain(21)

    androidTarget()

    sourceSets.commonMain {}
}

android {
    namespace = "ru.trader.core_database"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}