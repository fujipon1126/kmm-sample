plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
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
                implementation("dev.icerock.moko:mvvm-core:0.16.0")
                implementation("dev.icerock.moko:mvvm-flow:0.16.0")
                implementation("dev.icerock.moko:mvvm-state:0.16.0")
                implementation("dev.icerock.moko:mvvm-flow-resources:0.16.0")
                implementation("dev.icerock.moko:mvvm-flow-compose:0.16.0")
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
    namespace = "com.example.feature"
    compileSdk = 33
    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }
}