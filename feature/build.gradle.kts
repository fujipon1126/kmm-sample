plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.google.devtools.ksp") version "1.8.10-1.0.9"
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
            baseName = "features"
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "feature"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":domain"))
                implementation("dev.icerock.moko:mvvm-core:0.14.0")
                implementation("dev.icerock.moko:mvvm-flow:0.14.0")
                implementation("dev.icerock.moko:mvvm-state:0.14.0")
                implementation("dev.icerock.moko:mvvm-flow-resources:0.14.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
//                implementation("androidx.compose.ui:ui:1.3.1")
//                implementation("androidx.compose.ui:ui-tooling:1.3.1")
//                implementation("androidx.compose.ui:ui-tooling-preview:1.3.1")
//                implementation("androidx.compose.foundation:foundation-layout:1.3.1")
//                implementation("androidx.compose.material3:material3:1.1.0-beta02")
                implementation("io.insert-koin:koin-core:3.2.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.insert-koin:koin-android:3.2.2")
                implementation("androidx.compose.ui:ui:1.3.1")
                implementation("androidx.compose.ui:ui-tooling:1.3.1")
                implementation("androidx.compose.ui:ui-tooling-preview:1.3.1")
                implementation("androidx.compose.foundation:foundation-layout:1.3.1")
                implementation("androidx.compose.material3:material3:1.1.0-beta02")
            }
        }
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
    namespace = "com.example.feature"
    compileSdk = 33
    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
}