plugins {
    id("cn.guilin.framework.convention.android.library")
    id("cn.guilin.framework.convention.android.compose")
}

android {
    //Android Gradle插件会自动生成 BuildConfig 类
    //该类包含构建时的配置信息，如版本号、调试状态等
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    
}