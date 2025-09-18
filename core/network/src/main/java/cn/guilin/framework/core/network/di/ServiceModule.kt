package cn.guilin.framework.core.network.di

import cn.guilin.framework.core.network.service.BannerService
import cn.guilin.framework.core.network.service.GoodsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    //当需要 GoodsService 实例时，Hilt 会自动调用此方法
    fun provideGoodsService(retrofit: Retrofit): GoodsService {
        return retrofit.create(GoodsService::class.java)
    }

    @Provides
    @Singleton
    fun provideBannerService(retrofit: Retrofit): BannerService {
        return retrofit.create(BannerService::class.java)
    }
}