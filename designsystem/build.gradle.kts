@Suppress("UnstableApiUsage", "DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
//    alias(libs.plugins.compose)
}

android {
    namespace = "com.voitenko.dev.designsystem"
    compileSdk = 32
    defaultConfig { minSdk = 21 }
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = "1.3.0"
}

dependencies {
    implementation(libs.compose.ui)
    implementation(libs.compose.tooling)
    implementation(libs.compose.preview)
    implementation(libs.compose.material)
    implementation(libs.compose.activity)
    implementation(libs.coil.core)
}