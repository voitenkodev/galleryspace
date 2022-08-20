pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}

enableFeaturePreview("VERSION_CATALOGS")
@Suppress("UnstableApiUsage") dependencyResolutionManagement {
    versionCatalogs { create("libs") { from(files("gradle/wrapper/libs.versions.toml")) } }
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
rootProject.name = "Gallery Space"

include(":app", ":designsystem")