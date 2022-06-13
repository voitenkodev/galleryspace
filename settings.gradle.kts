pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { // kotlin-parcelize
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Gallery Space"

include(
    ":app",
    ":designsystem"
)

enableFeaturePreview("VERSION_CATALOGS")
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    versionCatalogs { create("libs") { from(files("gradle/wrapper/libs.versions.toml")) } }
}
