plugins {
    id("cn.guilin.framework.convention.android.library")
}

dependencies {
    // kotlin序列化
    // https://kotlinlang.org/docs/serialization.html
    implementation(libs.kotlinx.serialization.json)
}