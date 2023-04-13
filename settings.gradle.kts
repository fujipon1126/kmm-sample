pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "kmm-sample"
include(":androidApp")
include(":shared")
include(":data")
include(":feature")
include(":domain")
