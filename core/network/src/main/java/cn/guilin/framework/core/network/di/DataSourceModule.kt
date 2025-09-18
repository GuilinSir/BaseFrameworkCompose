package cn.guilin.framework.core.network.di

import cn.guilin.framework.core.network.datasource.banner.BannerDataSource
import cn.guilin.framework.core.network.datasource.banner.BannerDataSourceImpl
import cn.guilin.framework.core.network.datasource.goods.GoodsDataSource
import cn.guilin.framework.core.network.datasource.goods.GoodsDataSourceImpl
import cn.guilin.framework.core.network.service.BannerService
import cn.guilin.framework.core.network.service.GoodsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    //定义一个抽象函数，用于绑定数据源接口和实现类
    fun provideGoodsDataSource(goodsService: GoodsService): GoodsDataSource {
        return GoodsDataSourceImpl(goodsService)
    }

    @Provides
    @Singleton
    fun provideBannerDataSource(bannerService: BannerService): BannerDataSource {
        return BannerDataSourceImpl(bannerService)
    }
}