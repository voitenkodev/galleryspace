@Suppress("UnstableApiUsage", "DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose)
}

android {
    namespace = "com.voitenko.dev.designsystem"
    compileSdk = 32
    defaultConfig { minSdk = 21 }
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = "1.2.0"
}

dependencies {
    implementation(libs.kotlinx.gradle)
    implementation(compose.ui)
    implementation(compose.material)
    implementation(compose.preview)
    implementation(compose.materialIconsExtended)
    implementation(compose.uiTooling)
    implementation(compose.foundation)
    implementation(libs.coil.core)
}