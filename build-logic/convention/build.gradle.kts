// 应用Kotlin DSL插件，使构建脚本能够使用Kotlin语言编写
plugins {
    `kotlin-dsl`
}

// 定义构建逻辑模块的组名
group = "cn.guilin.framework.buildlogic"

java {
    // 设置Java源代码和目标字节码的兼容性版本为Java 11
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    // 添加Android Gradle插件依赖（仅编译时需要）
    compileOnly(libs.android.gradlePlugin)
    // 添加Kotlin Gradle插件依赖（仅编译时需要）
    compileOnly(libs.kotlin.gradlePlugin)
    // 添加KSP注解处理器插件依赖（仅编译时需要）
    compileOnly(libs.ksp.gradlePlugin)
}

// 配置Gradle插件
gradlePlugin {
    plugins {
        // 注册Android应用程序插件
        register("androidApplication") {
            id = "cn.guilin.framework.convention.android.application"
            implementationClass = "cn.guilin.framework.convention.AndroidApplication"
        }
        // 注册Android依赖库插件
        register("androidLibrary") {
            id = "cn.guilin.framework.convention.android.library"
            implementationClass = "cn.guilin.framework.convention.AndroidLibrary"
        }
        // 注册Android Compose插件
        register("androidCompose") {
            id = "cn.guilin.framework.convention.android.compose"
            implementationClass = "cn.guilin.framework.convention.AndroidCompose"
        }
        // 注册Android Feature模块插件
        register("androidFeature") {
            id = "cn.guilin.framework.convention.android.feature"
            implementationClass = "cn.guilin.framework.convention.AndroidFeature"
        }
        // 注册Android测试插件
        register("androidTest") {
            id = "cn.guilin.framework.convention.android.test"
            implementationClass = "cn.guilin.framework.convention.AndroidTest"
        }
    }
}