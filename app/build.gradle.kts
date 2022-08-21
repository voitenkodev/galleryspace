@Suppress("UnstableApiUsage", "DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.app)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.serialization)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.compose)
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
    composeOptions.kotlinCompilerExtensionVersion = "1.2.0"
}

dependencies {
    implementation(project(":designsystem"))

    implementation(compose.ui)
    implementation(compose.uiTooling)
    implementation(compose.material)
    implementation(compose.preview)
    implementation(compose.foundation)

    implementation(libs.compose.accompansit.navigation)
    implementation(libs.compose.accompansit.systemcontroller)

    implementation(libs.coroutines)
    implementation(libs.datetime)
    implementation(libs.kotlinx.runtime)
    implementation(libs.serialization)
    implementation(libs.coil.core)

    implementation(libs.sqldelight.common)
    implementation(libs.sqldelight.android)
    implementation(libs.sqldelight.extensions)

    implementation("io.insert-koin:koin-core:3.2.0")
    implementation("io.insert-koin:koin-androidx-compose:3.2.0")
    implementation("io.insert-koin:koin-android:3.2.0")
}

sqldelight {
    this.database("AppDataBase") {
        packageName = "com.voitenko.dev.galleryspace.db"
        sourceFolders = listOf("java")
        linkSqlite = true
    }
}