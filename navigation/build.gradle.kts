plugins {
    id("cn.guilin.framework.convention.android.library")
    //依赖注入
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}


dependencies {

    // 导航
    // https://mvnrepository.com/artifact/androidx.navigation/navigation-compose
    implementation(libs.navigation.compose)

    //region 依赖注入
    //https://developer.android.google.cn/training/dependency-injection/hilt-android?hl=zh-cn
    ksp(libs.hilt.android.compiler)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
}