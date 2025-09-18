plugins {
    id("cn.guilin.framework.convention.android.library")
    alias(libs.plugins.kotlin.serialization)
}
android {
    //Android Gradle插件会自动生成 BuildConfig 类
    //该类包含构建时的配置信息，如版本号、调试状态等
    buildFeatures {
        buildConfig = true
    }
}
dependencies {
    // kotlin序列化
    // https://kotlinlang.org/docs/serialization.html
    implementation(libs.kotlinx.serialization.json)
}