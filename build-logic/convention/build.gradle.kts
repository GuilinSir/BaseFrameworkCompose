plugins {
    `kotlin-dsl`
}

group = "cn.guilin.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "cn.guilin.framework.convention.android.application"
            implementationClass = "cn.guilin.framework.convention.AndroidApplication"
        }
        register("androidLibrary") {
            id = "cn.guilin.framework.convention.android.library"
            implementationClass = "cn.guilin.framework.convention.AndroidLibrary"
        }
        register("androidCompose") {
            id = "cn.guilin.framework.convention.android.compose"
            implementationClass = "cn.guilin.framework.convention.AndroidCompose"
        }
        register("androidFeature") {
            id = "cn.guilin.framework.convention.android.feature"
            implementationClass = "cn.guilin.framework.convention.AndroidFeature"
        }
        register("androidTest") {
            id = "cn.guilin.framework.convention.android.test"
            implementationClass = "cn.guilin.framework.convention.AndroidTest"
        }
    }
}