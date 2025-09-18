package cn.guilin.framework.core.network.di

import cn.guilin.framework.BuildConfig
import cn.guilin.core.network.interceptor.AuthInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private val BASE_URL = BuildConfig.BASE_URL

    // 配置Json序列化
    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        //忽略 JSON 中存在但数据类中不存在的字段
        //防止因服务器返回额外字段而导致解析失败
        ignoreUnknownKeys = true
        //对于类型不匹配的情况进行强制转换
        //例如：将字符串数字 "123" 转换为 Int 类型 123
        coerceInputValues = true
        //允许更宽松的 JSON 解析
        //支持一些非标准但常见的 JSON 格式
        isLenient = true
    }

    // 提供OkHttpClient
    @Provides
    @Singleton
    fun provideOkhttpClient(
        authInterceptor: AuthInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS) // 连接超时时间
            .writeTimeout(10, TimeUnit.SECONDS) // 写超时时间
            .readTimeout(10, TimeUnit.SECONDS) // 读超时时间
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, json: Json): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor():HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}