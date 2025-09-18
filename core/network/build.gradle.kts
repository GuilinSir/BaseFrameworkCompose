plugins {
    id("cn.guilin.framework.convention.android.library")
    //依赖注入
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

dependencies {
    // 引入 model 模块
    implementation(project(":core:model"))

    // kotlin序列化
    // https://kotlinlang.org/docs/serialization.html
    implementation(libs.kotlinx.serialization.json)

    // okhttp 网络框架
    // https://github.com/square/okhttp
    implementation(libs.okhttp)

    // 类型安全网络框架
    // https://github.com/square/retrofit
    implementation(libs.retrofit)

    // 让Retrofit支持Kotlinx Serialization
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    // 网络请求框架日志框架
    implementation(libs.logging.interceptor)

    //日志框架
    //https://github.com/JakeWharton/timber
    implementation(libs.timber)


    //region 依赖注入
    //https://developer.android.google.cn/training/dependency-injection/hilt-android?hl=zh-cn
    ksp(libs.hilt.android.compiler)
    implementation(libs.hilt.android)

}