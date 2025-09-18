pluginManagement {
    repositories {
        // 添加阿里云镜像
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url = uri("https://maven.aliyun.com/repository/central") }

        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
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

rootProject.name = "BaseFrameworkCompose"

include(":app")
// core 模块
include(":core:ui")
include(":core:model")
include(":core:network")
include(":core:designsystem")
include(":core:data")
include(":core:common")
// feature 模块
// 首页
include(":feature:mian")
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
