@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.app)
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.serialization)
//    alias(libs.plugins.sqldelight)
}

kotlin {
    jvm("desktop")
    android()
    js(IR) { browser(); binaries.executable() }
    macosX64().binaries.executable {
        entryPoint = "main"
        freeCompilerArgs += listOf("-linker-option", "-framework", "-linker-option", "Metal")
    }
    macosArm64().binaries.executable {
        entryPoint = "main"
        freeCompilerArgs += listOf("-linker-option", "-framework", "-linker-option", "Metal")
    }
    iosX64("uikitX64").binaries.executable {
        entryPoint = "main"
        freeCompilerArgs += listOf(
            "-linker-option", "-framework", "-linker-option", "Metal",
            "-linker-option", "-framework", "-linker-option", "CoreText",
            "-linker-option", "-framework", "-linker-option", "CoreGraphics"
        )
    }
    iosArm64("uikitArm64").binaries.executable {
        entryPoint = "main"
        freeCompilerArgs += listOf(
            "-linker-option", "-framework", "-linker-option", "Metal",
            "-linker-option", "-framework", "-linker-option", "CoreText",
            "-linker-option", "-framework", "-linker-option", "CoreGraphics"
        )
        freeCompilerArgs += "-Xdisable-phases=VerifyBitcode" // TODO: the current compose binary surprises LLVM, so disable checks for now.
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines)
                implementation(libs.datetime)
                implementation(libs.logger)
                implementation(libs.serialization)
                implementation(libs.sqldelight.extensions)
                implementation(libs.ktor.core)

                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
            }
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(libs.ktor.desktop)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("androidx.appcompat:appcompat:1.5.0")
                implementation("androidx.activity:activity-compose:1.5.1")
                implementation(libs.ktor.android)
//                implementation(libs.sqldelight.android)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(libs.ktor.js)
//                implementation(libs.sqldelight.js)
            }
        }


        val iosMain by creating {
            dependsOn(commonMain)
            dependencies { implementation(libs.ktor.darwin) }
        }

        val macosMain by creating { dependsOn(iosMain) }
        val macosX64Main by getting { dependsOn(macosMain) }
        val macosArm64Main by getting { dependsOn(macosMain) }
        val uikitMain by creating { dependsOn(iosMain) }
        val uikitX64Main by getting { dependsOn(uikitMain) }
        val uikitArm64Main by getting { dependsOn(uikitMain) }
    }
}

android {
    namespace = "dev.voitenko.galleryspace"
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = "dev.voitenko.galleryspace"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
}

compose.desktop {
    application {
        mainClass = "Main_desktopKt"
        nativeDistributions {
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
            )
            packageName = "GallerySpace"
            packageVersion = "1.0.0"

            windows {
                menuGroup = "Compose Examples"
                upgradeUuid =
                    "18159995-d967-4CD2-8885-77BFA97CFA9F" // see https://wixtoolset.org/documentation/manual/v3/howtos/general/generate_guids.html
            }
        }
    }
}

compose.experimental {
    web.application {}
    uikit.application {
        bundleIdPrefix = "dev.voitenko.galleryspace"
        projectName = "GallerySpace"
        deployConfigurations {
            simulator("IPhone13") {
                //Usage: ./gradlew iosDeployIPhone13Debug
                device = org.jetbrains.compose.experimental.dsl.IOSDevices.IPHONE_13_PRO
            }
            simulator("IPadUI") {
                //Usage: ./gradlew iosDeployIPadUIDebug
                device = org.jetbrains.compose.experimental.dsl.IOSDevices.IPAD_MINI_6th_Gen
            }
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> { kotlinOptions.jvmTarget = "11" }

kotlin {
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        // TODO: the current compose binary surprises LLVM, so disable checks for now.
        binaries.all { freeCompilerArgs += "-Xdisable-phases=VerifyBitcode" }
    }
}

compose.desktop.nativeApplication {
    targets(kotlin.targets.getByName("macosX64"))
    distributions {
        targetFormats(org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg)
        packageName = "GallerySpace"
        packageVersion = "1.0.0"
    }
}

// a temporary workaround for a bug in jsRun invocation - see https://youtrack.jetbrains.com/issue/KT-48273
afterEvaluate {
    rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
        versions.webpackDevServer.version = "4.0.0"
        versions.webpackCli.version = "4.10.0"
        nodeVersion = "16.0.0"
    }
}

// TODO: remove when https://youtrack.jetbrains.com/issue/KT-50778 fixed
project.tasks.withType(org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile::class.java).configureEach {
    kotlinOptions.freeCompilerArgs += listOf("-Xir-dce-runtime-diagnostic=log")
}