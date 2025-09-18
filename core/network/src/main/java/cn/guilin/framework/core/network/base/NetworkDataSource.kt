package cn.guilin.framework.core.network.base

import retrofit2.Retrofit

/**
 * 网络数据源基类
 * 提供所有网络数据源实现的通用功能
 */
abstract class NetworkDataSource {

    protected inline fun <reified T> Retrofit.createService(): T {
        return this.create(T::class.java)
    }
}