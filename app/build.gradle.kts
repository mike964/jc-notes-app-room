plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt") // For Room and Hilt annotation processing
    //    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.philippnoteapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.philippnoteapp"
        minSdk = 28
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
//    implementation ("com.google.android.material:material:1.4.0")
//    implementation ("androidx.compose.ui:ui:$compose_version")
//    implementation( "androidx.compose.material:material:$compose_version")
    // # icons extended
//    implementation(libs.androidx.compose.material.icons.extended)
//    implementation(libs.androidx.compose.material.icons.core)
    implementation("androidx.compose.material:material-icons-extended:1.7.8")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // # Room DB
    val room_version = "2.6.1" // Use latest stable version
    val hilt_version = "2.51.1" // Use latest stable version
    implementation("androidx.room:room-runtime:${room_version}")
    implementation("androidx.room:room-ktx:${room_version}")  // Kotlin extensions and Coroutines support
    kapt("androidx.room:room-compiler:${room_version}")

    // # Hilt
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-android-compiler:$hilt_version")
    // Hilt for Jetpack (ViewModel integration)
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0") // For Hilt with Compose Navigation
}
