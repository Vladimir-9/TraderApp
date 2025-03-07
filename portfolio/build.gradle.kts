import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.buildConfig)
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
            implementation(projects.core)
            implementation(projects.coreNetwork)

            implementation(libs.koin.core)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.arkivanov.decompose)
            implementation(libs.arkivanov.decompose.ext)
        }
    }
}

android {
    namespace = "ru.trader.portfolio"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}


val keystorePropertiesFile = rootProject.file("local.properties")
val keystoreProperties = Properties()
keystoreProperties.load(FileInputStream(keystorePropertiesFile))

buildConfig {
    val clientId= keystoreProperties["CLIENT_ID"].toString()

    buildConfigField("CLIENT_ID", clientId)
}