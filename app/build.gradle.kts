

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.mtc"
    compileSdkVersion
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.mtc"
        minSdk = 26
        //noinspection EditedTargetSdkVersion
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
    buildToolsVersion = "35.0.0"
}

dependencies {


    implementation("me.relex:circleindicator:2.1.6")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.codesgood:justifiedtextview:1.1.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")
    implementation("androidx.cardview:cardview:1.0.0")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.annotation)
    implementation(libs.firebase.firestore)
    implementation(libs.appcompat.v7)
    implementation(libs.firebase.auth)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //Add libs

    implementation ("com.hbb20:ccp:2.5.4")
    implementation("com.googlecode.libphonenumber:libphonenumber:8.12.48")


}



