plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSDK
        targetSdk = Config.targetSDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Dependencies.Jvm.targetVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(
        project(":domain"),
        project(":common")
    )

    implementation(
        Dependencies.Coroutines.core,
        Dependencies.Coroutines.android
    )

    implementation(
        Dependencies.Compose.runtime
    )

    implementation(
        Dependencies.Room.ktx,
        Dependencies.Room.runtime
    )
    kapt(Dependencies.Room.compiler)

    implementation(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.daggerCompiler)

    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(
        Dependencies.Test.androidJUnit,
        Dependencies.Test.espresso
    )
}
