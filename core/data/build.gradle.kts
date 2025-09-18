plugins {
    id("cn.guilin.framework.convention.android.library")
    //依赖注入
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
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