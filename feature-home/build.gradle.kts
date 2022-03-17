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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
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
        project(":data"),
        project(":common")
    )

    implementation(
        Dependencies.Android.appCompat,
        Dependencies.Android.coreKtx,
        Dependencies.Android.material
    )

    implementation(
        Dependencies.Compose.ui,
        Dependencies.Compose.material,
        Dependencies.Compose.tooling
    )

    implementation(
        Dependencies.Accompanist.pager,
        Dependencies.Accompanist.pagerIndicators
    )

    implementation(Dependencies.Navigation.navigationCompose)

    implementation(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.daggerCompiler)

    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(
        Dependencies.Test.androidJUnit,
        Dependencies.Test.espresso
    )

    androidTestImplementation(Dependencies.Compose.uiTest)
    debugImplementation(Dependencies.Compose.toolingTest)
}
