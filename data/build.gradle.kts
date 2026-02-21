plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.toure.mehedi.style_generator_ai.data"
    compileSdk = 36

    defaultConfig {
        minSdk = 27

        fun buildStringConfig(name: String, property: String) {
            buildConfigField(
                "String",
                name,
                providers.gradleProperty(property)
                    .map { "\"$it\"" }
                    .orElse("\"\"")
                    .get()
            )
        }

        buildStringConfig("SUPABASE_URL", "supabase.url")
        buildStringConfig("SUPABASE_ANON_KEY", "supabase.anon_key")
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.javax.inject)

    implementation(platform(libs.bom))
    implementation(libs.postgrest.kt)
    implementation(libs.auth.kt)
    implementation(libs.realtime.kt)
    implementation(libs.storage.kt)
    implementation(libs.ktor.client.android)

}