plugins {
    id("cn.guilin.framework.convention.android.feature")

}

android {
    //Android Gradle插件会自动生成 BuildConfig 类
    //该类包含构建时的配置信息，如版本号、调试状态等
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.coil.compose)

    // 引入数据模块
    implementation(project(":core:data"))
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    //日志框架
    //https://github.com/JakeWharton/timber
    implementation(libs.timber)
}