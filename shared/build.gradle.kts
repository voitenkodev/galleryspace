@Suppress("UnstableApiUsage", "DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.serialization)
    alias(libs.plugins.android.library)
    alias(libs.plugins.sqldelight)
}

kotlin {
    jvm()
    android()
    js { browser(); nodejs() }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    watchosX64()
    watchosArm64()
    watchosSimulatorArm64()
    linuxX64()
    macosX64()
    macosArm64()
    mingwX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines)
                implementation(libs.datetime)
                implementation(libs.logger)
                implementation(libs.serialization)
                implementation(libs.sqldelight.extensions)
            }
        }
        val nativeMain by creating {
            dependencies {
                implementation(libs.sqldelight.native)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.sqldelight.android)
                implementation(libs.ktor.android)
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(libs.ktor.js)
                implementation(libs.sqldelight.js)
            }
        }
        val iosMain by creating {
            dependencies {
//                implementation(libs.sqldelight.ios)
            }
        }

        val watchosMain by creating
        val linuxMain by creating
        val macosMain by creating
        val windowsMain by creating
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val watchosX64Main by getting
        val watchosArm64Main by getting
        val watchosSimulatorArm64Main by getting
        val linuxX64Main by getting
        val macosX64Main by getting
        val macosArm64Main by getting
        val mingwX64Main by getting

        nativeMain.dependsOn(commonMain)
        androidMain.dependsOn(commonMain)
        jsMain.dependsOn(commonMain)
        iosMain.dependsOn(nativeMain)
        iosX64Main.dependsOn(iosMain)
        iosArm64Main.dependsOn(iosMain)
        iosSimulatorArm64Main.dependsOn(iosMain)
        watchosMain.dependsOn(nativeMain)
        watchosX64Main.dependsOn(watchosMain)
        watchosArm64Main.dependsOn(watchosMain)
        watchosSimulatorArm64Main.dependsOn(watchosMain)
        linuxMain.dependsOn(nativeMain)
        linuxX64Main.dependsOn(linuxMain)
        macosMain.dependsOn(nativeMain)
        macosX64Main.dependsOn(macosMain)
        macosArm64Main.dependsOn(macosMain)
        windowsMain.dependsOn(nativeMain)
        mingwX64Main.dependsOn(windowsMain)
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }
}
