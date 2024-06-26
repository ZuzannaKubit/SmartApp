plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    //firebase
    id("com.google.gms.google-services")
}

android {
    namespace = "com.zuzob00l.smartapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.zuzob00l.smartapp"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("com.google.firebase:firebase-firestore:24.9.1")
    val room_version = "2.5.2"
    val coil_version = "1.1.0"
    val nav_version = "2.6.0"

    implementation("androidx.work:work-runtime-ktx:2.8.1")

    //material:
    implementation("androidx.compose.material:material-android:1.5.4")
    //icons
    implementation("androidx.compose.material:material-icons-core-android:1.5.4")
    //Firebase dependencies
    implementation(platform("com.google.firebase:firebase-bom:32.2.3"))
    implementation("com.google.firebase:firebase-storage")
    implementation("com.google.firebase:firebase-auth-ktx")

    //Hilt:
    implementation ("androidx.hilt:hilt-navigation-fragment:1.0.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.1.0-rc01")
    implementation ("androidx.hilt:hilt-work:1.0.0")
    implementation ("com.google.dagger:hilt-android:2.44")

    //coil:
    implementation("io.coil-kt:coil-compose:2.5.0")

    kapt("com.google.dagger:hilt-android-compiler:2.44")
    //room:
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    //navigation
    implementation("androidx.navigation:navigation-compose:$nav_version")
    //Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}