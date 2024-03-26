plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.baseproject"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.project.demo"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    signingConfigs {
        create("release") {
            storeFile = file("../keystore/base.jks")
            storePassword = "sdfg\$#sdfgFVGVR54"
            keyAlias = "baseProject"
            keyPassword = "sdfg\$#sdfgFVGVR54"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    val javaVersion = rootProject.extra["versionJava"]
    java {
        sourceCompatibility = javaVersion as JavaVersion
        targetCompatibility = javaVersion
    }

    kotlinOptions {
        jvmTarget = javaVersion.toString()
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(":libraries:core"))
    implementation(project(":libraries:permission"))
    implementation(project(":features:Demo"))

    //appcompat
    implementation(libs.bundles.common)

    kapt(libs.hiltSupport)

    //navigation
    implementation(libs.bundles.navigation)

    //network
    implementation(libs.bundles.network)

    kapt(libs.liveData)

    // Loading Image
    implementation(libs.glide)
    kapt(libs.glideCompiler)

    debugImplementation(libs.leak)
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
}