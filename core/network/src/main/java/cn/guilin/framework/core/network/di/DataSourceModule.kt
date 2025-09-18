package cn.guilin.framework.core.network.di

import cn.guilin.framework.core.network.datasource.banner.BannerDataSource
import cn.guilin.framework.core.network.datasource.banner.BannerDataSourceImpl
import cn.guilin.framework.core.network.datasource.goods.GoodsDataSource
import cn.guilin.framework.core.network.datasource.goods.GoodsDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    /**
     * 将 GoodsDataSource 接口与其具体实现类 GoodsDataSourceImpl 进行绑定，
     * 使得当需要 GoodsDataSource 实例时，
     * Hilt会自动提供 GoodsDataSourceImpl 的单例实例。
     */
    @Binds//表示这是一个绑定函数，用于将实现类绑定到接口
    @Singleton
    //定义一个抽象函数，用于绑定数据源接口和实现类
    abstract fun bindGoodsDataSource(
        impl: GoodsDataSourceImpl

    ): GoodsDataSource

    @Binds
    @Singleton
    abstract fun bindBannerDataSource(
        impl: BannerDataSourceImpl
    ): BannerDataSource
}