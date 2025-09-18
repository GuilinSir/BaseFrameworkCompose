// Gradle插件管理配置
pluginManagement {
    // 包含build-logic目录作为构建逻辑模块
    includeBuild("build-logic")
    // Google的Maven仓库，用于Android相关依赖
    repositories {
        // 添加阿里云镜像
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url = uri("https://maven.aliyun.com/repository/central") }

        google {
            content {
                // 通过正则表达式指定允许从Google仓库下载的包
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral() // Maven中央仓库
        gradlePluginPortal() // Gradle插件门户
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // 添加阿里云镜像
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://maven.aliyun.com/repository/central") }

        google()
        mavenCentral()
    }
}
// 设置根项目名称
rootProject.name = "BaseFrameworkCompose"
// 包含主应用模块
include(":app")
// 核心模块
include(":core:ui")
include(":core:model")
include(":core:network")
include(":core:designsystem")
include(":core:data")
include(":core:common")
// feature 模块
// 首页
include(":feature:main")
// 用户认证
include(":feature:auth")
// 公共
include(":feature:common")
// 商品
include(":feature:goods")
// 启动流程
include(":feature:launch")
// 营销
include(":feature:market")
// 订单
include(":feature:order")
// 用户
include(":feature:user")
// 导航模块
include(":navigation")
