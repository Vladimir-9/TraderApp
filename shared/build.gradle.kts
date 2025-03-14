import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.buildConfig)
    id("convention.publication")
}

kotlin {
    jvmToolchain(21)

    androidTarget { publishLibraryVariants("release") }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "Shared"
            isStatic = true

            export(libs.arkivanov.decompose)
            export(libs.arkivanov.decompose.life)
            export(libs.arkivanov.decompose.keep)
            export(projects.portfolio)
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.coroutines.test)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kermit)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.logging)
            implementation(libs.multiplatformSettings)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            api(libs.arkivanov.decompose)
            api(libs.arkivanov.decompose.life)
            api(libs.arkivanov.decompose.keep)
            implementation(libs.arkivanov.decompose.ext)

            implementation(projects.coreNetwork)
            implementation(projects.coreDatabase)
            api(projects.portfolio)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            implementation(libs.koin.androidx.compose)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.sqlDelight.driver.android)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            implementation(libs.sqlDelight.driver.native)
        }

    }

    //https://kotlinlang.org/docs/native-objc-interop.html#export-of-kdoc-comments-to-generated-objective-c-headers
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        compilations["main"].compileTaskProvider.configure {
            compilerOptions {
                freeCompilerArgs.add("-Xexport-kdoc")
            }
        }
    }

}

android {
    namespace = "ru.trader.shared"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

val keystorePropertiesFile = rootProject.file("local.properties")
val keystoreProperties = Properties()
keystoreProperties.load(FileInputStream(keystorePropertiesFile))

buildConfig {
    // BuildConfig configuration here.
    // https://github.com/gmazzo/gradle-buildconfig-plugin#usage-in-kts

    val apiKey= keystoreProperties["API_KEY"].toString()
    val clientId= keystoreProperties["CLIENT_ID"].toString()

    buildConfigField("API_KEY", apiKey)
    buildConfigField("CLIENT_ID", clientId)
}