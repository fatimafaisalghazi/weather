plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"
}

android {
    namespace = "com.example.weatherapplication"
    compileSdk = 35
    packaging {
        resources {
            excludes.add("/META-INF/INDEX.LIST")
        }
    }
    defaultConfig {
        applicationId = "com.example.weatherapplication"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // AndroidX Libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Jetpack Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Google Play Services - Location
    implementation(libs.play.services.location)

    // Koin for DI
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    // Logging
//    implementation("ch.qos.logback:logback-classic:1.4.11")

    // Ktor HTTP Client
    implementation("io.ktor:ktor-client-android:2.3.5")
    implementation("io.ktor:ktor-client-json:2.3.5")
    implementation("io.ktor:ktor-client-serialization:2.3.5")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.5")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.5")

// https://mvnrepository.com/artifact/io.ktor/ktor-client-core
    // KotlinX Coroutines + Play Services (بدون kotlinx-coroutines-play-services)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.10.2")
    // implementation ("com.google.android.play:core-ktx:1.10.3" )// ← بدل await()

    // Kotlin Serialization
    implementation(libs.kotlinx.serialization.json)

    // Activity KTX
    implementation("androidx.activity:activity-ktx:1.8.2")

//    implementation ("group: 'com.fasterxml.jackson.module', name: 'jackson-module-kotlin', version: '2.13.0'")
    //implementation("com.fasterxml.jackson.core:jackson-databind:2.19.0")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.3")
    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
