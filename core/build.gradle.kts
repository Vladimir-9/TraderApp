import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
}

kotlin {

    explicitApi = ExplicitApiMode.Strict

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
            implementation(libs.arkivanov.decompose)
            implementation(libs.koin.core)
            implementation(libs.kermit)
        }
    }
}

android {
    namespace = "ru.trader.core"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}