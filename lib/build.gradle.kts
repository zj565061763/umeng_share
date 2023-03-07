plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    `maven-publish`
}

val libGroupId = "com.sd.lib.umeng"
val libArtifactId = "umeng_share"
val libVersionName = "7.2.0-v04"

android {
    namespace = "com.sd.lib.umeng.share"
    compileSdk = libs.versions.androidCompileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.androidMinSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
        kotlinOptions.freeCompilerArgs += "-module-name=$libGroupId.$libArtifactId"
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {
    api(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(libs.androidx.core)

    api(libs.umsdk.shareCore)
    api(libs.umsdk.shareBoard)

    api(libs.umsdk.shareWx)
    api(libs.tencent.wechat)

    api(libs.umsdk.shareQq)
    api(libs.umsdk.shareSina)
    api(libs.sina.weibo)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = libGroupId
                artifactId = libArtifactId
                version = libVersionName
            }
        }
    }
}