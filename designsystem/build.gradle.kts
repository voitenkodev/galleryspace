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
    implementation(compose.ui)
    implementation(compose.material)
    implementation(compose.preview)
    implementation(compose.materialIconsExtended)
    implementation(compose.uiTooling)

    implementation(libs.compose.activity)
    implementation(libs.coil.core)
}