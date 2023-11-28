plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.9.20"

}

android {
    namespace = "kr.co.eclipse4j"
    compileSdk = 33
    compileSdkPreview = "UpsideDownCake"

    defaultConfig {
        applicationId = "kr.co.eclipse4j"
        minSdk = 29
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
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx")
    implementation("androidx.activity:activity-compose")
    implementation("androidx.compose.material:material-icons-extended")
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    implementation("io.ktor:ktor-client-cio:2.3.6")
    implementation("io.ktor:ktor-client-core:2.3.6")
    implementation("io.ktor:ktor-client-okhttp:2.3.6")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.6")
    implementation("io.ktor:ktor-client-serialization:2.3.6")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.6")
    implementation("io.ktor:ktor-client-json:2.3.6")
    implementation("io.ktor:ktor-client-encoding:2.3.6")

    //implementation("io.ktor:ktor-serialization-gson:2.3.6")
    implementation("io.ktor:ktor-serialization:2.3.6")
    //implementation("io.ktor:ktor-jackson:2.3.6")
    implementation("io.ktor:ktor-serialization-jackson:2.3.6")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.6")



    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}