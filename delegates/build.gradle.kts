plugins {
    id(Plugins.library)
    id(Plugins.android)
}


android {
    namespace = "com.vsv.delegates"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
    }

    compileOptions {
        targetCompatibility = Config.javaVersion
        sourceCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.jmvTarget
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.paging:paging-runtime-ktx:3.2.0")
    implementation(Dependencies.Core.coreKtx)
}