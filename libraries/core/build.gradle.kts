plugins {
    id("com.android.library")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.core"
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
        buildConfig = true
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

    implementation(libs.bundles.common)
    kapt(libs.hiltSupport)

    //navigation
    implementation(libs.bundles.navigation)

    //network
    implementation(libs.bundles.network)

    kapt(libs.liveData)

    implementation(libs.glide)
    kapt(libs.glideCompiler)


}
