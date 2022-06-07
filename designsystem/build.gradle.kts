@Suppress("UnstableApiUsage", "DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.voitenko.dev.designsystem"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = "1.2.0-alpha05"
}

dependencies {
    implementation(libs.compose.ui)
    implementation(libs.compose.tooling)
    implementation(libs.compose.preview)
    implementation(libs.compose.material)
    implementation(libs.compose.activity)
    implementation(libs.coil.core)
}