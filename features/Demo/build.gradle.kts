plugins {
    id("com.android.library")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.setting"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
    }

    buildTypes {
        release {
            isMinifyEnabled = true
//            proguardFiles getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
        }
    }

    buildFeatures {
        dataBinding = true
        // for view binding :
        // viewBinding = true
    }

    val javaVersion = rootProject.extra["versionJava"]
    java {
        sourceCompatibility = javaVersion as JavaVersion
        targetCompatibility = javaVersion
    }

    kotlinOptions {
        jvmTarget = javaVersion.toString()
    }
}

dependencies {

    implementation(project(":libraries:core"))
    implementation(project(":libraries:permission"))

    //appcompat
    implementation(libs.bundles.common)

    kapt(libs.hiltSupport)

    kapt(libs.liveData)

    //navigation
    implementation(libs.bundles.navigation)

    // Loading Image
    implementation(libs.glide)
    kapt(libs.glideCompiler)
    // Network
    implementation(libs.bundles.network)
}
