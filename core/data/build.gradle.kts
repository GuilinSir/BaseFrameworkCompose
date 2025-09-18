plugins {
    id("cn.guilin.framework.convention.android.library")
    //依赖注入
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}
android {
    //Android Gradle插件会自动生成 BuildConfig 类
    //该类包含构建时的配置信息，如版本号、调试状态等
    buildFeatures {
        buildConfig = true
    }
}
dependencies {

    // 引入 model 模块
    implementation(project(":core:model"))
    // 引入网络模块
    implementation(project(":core:network"))

    //hilt
    ksp(libs.hilt.android.compiler)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
}