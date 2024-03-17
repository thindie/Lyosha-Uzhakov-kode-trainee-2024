plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
}

android {
    namespace = "com.thindie.database"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        jvmTarget = Config.jvmTarget
    }
    kotlin {
        jvmToolchain(Config.toolChain)
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }

    configurations.implementation {
        exclude(group = "org.jetbrains", module = "annotations")
    }
}

dependencies {


    implementation(Dependencies.Room.roomRuntime)
    annotationProcessor(Dependencies.Room.roomCompiler)
    implementation(Dependencies.Room.roomCoroutines)

    kapt(Dependencies.Room.roomCompiler)


    // Dagger
    implementation(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.annotationProcessorCompiler)

    testImplementation(Dependencies.Testing.junit)
}