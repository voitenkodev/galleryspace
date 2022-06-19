@Suppress("UnstableApiUsage", "DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.app)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.voitenko.dev.galleryspace"
    compileSdk = 32

    defaultConfig {
        applicationId = "com.voitenko.dev.galleryspace"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = "1.2.0-alpha05"
}

dependencies {
    implementation(project(":designsystem"))

    implementation(libs.kotlinx.coroutines)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.runtime)

    implementation(libs.coil.core)

    implementation(libs.compose.ui)
    implementation(libs.compose.tooling)
    implementation(libs.compose.preview)
    implementation(libs.compose.activity)
    implementation(libs.compose.navigation)
    implementation(libs.compose.material)

    implementation(libs.compose.accompansit.navigation)
    implementation(libs.compose.accompansit.systemcontroller)

//    implementation("io.github.voitenkodev:mvi-core:1.0.6")
}