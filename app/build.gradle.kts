@Suppress("UnstableApiUsage", "DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.app)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.serialization)
    alias(libs.plugins.sqldelight)
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
    composeOptions.kotlinCompilerExtensionVersion = "1.3.0"

//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
}

dependencies {
    implementation(project(":designsystem"))

    implementation(libs.coroutines)
    implementation(libs.datetime)
    implementation(libs.kotlinx.runtime)

    implementation(libs.serialization)

    implementation(libs.coil.core)

    implementation(libs.compose.ui)
    implementation(libs.compose.tooling)
    implementation(libs.compose.preview)
    implementation(libs.compose.activity)
    implementation(libs.compose.navigation)
    implementation(libs.compose.material)

    implementation(libs.compose.accompansit.navigation)
    implementation(libs.compose.accompansit.systemcontroller)

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