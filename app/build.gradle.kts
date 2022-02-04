plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSDK
        targetSdk = Config.targetSDK
        versionCode = Config.versionCode
        versionName = Config.versionName

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
        jvmTarget = JavaVersion.VERSION_1_8.toString()
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
        Dependencies.Kotlin.stdlib,
        Dependencies.Kotlin.extensions,
    )

    implementation(
        Dependencies.Android.appCompat,
        Dependencies.Android.coreKtx,
        Dependencies.Android.material,
    )

    implementation(
        Dependencies.Compose.ui,
        Dependencies.Compose.material,
        Dependencies.Compose.livedata,
        Dependencies.Compose.tooling,
    )

    implementation(
        Dependencies.Accompanist.insets,
        Dependencies.Accompanist.systemuicontroller,
        Dependencies.Accompanist.flowlayouts,
    )

    implementation(
        Dependencies.Lifecycle.activityCompose,
        Dependencies.Lifecycle.viewModelCompose,
        Dependencies.Lifecycle.lifecycleKtx,
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
