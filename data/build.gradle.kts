plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.google.devtools.ksp") version "1.8.0-1.0.8"
    id("de.jensklingenberg.ktorfit") version "1.0.0"
    kotlin("plugin.serialization") version "1.8.0"
    kotlin("native.cocoapods")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "data"
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "repository"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("de.jensklingenberg.ktorfit:ktorfit-lib:1.0.1")
                implementation("io.insert-koin:koin-core:3.4.0")
                implementation("io.ktor:ktor-client-content-negotiation:2.1.3")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.1.3")
                implementation("io.ktor:ktor-client-logging:2.1.3")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.example.repository"
    compileSdk = 33
    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }
}

dependencies {
    add("kspCommonMainMetadata", "de.jensklingenberg.ktorfit:ktorfit-ksp:1.0.1")
    add("kspAndroid", "de.jensklingenberg.ktorfit:ktorfit-ksp:1.0.1")
    add("kspIosX64", "de.jensklingenberg.ktorfit:ktorfit-ksp:1.0.1")
    add("kspIosArm64", "de.jensklingenberg.ktorfit:ktorfit-ksp:1.0.1")
    add("kspIosSimulatorArm64", "de.jensklingenberg.ktorfit:ktorfit-ksp:1.0.1")
}