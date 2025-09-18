package cn.guilin.framework.core.data.repository

import cn.guilin.framework.core.model.Banner
import cn.guilin.framework.core.model.response.BasePageData
import cn.guilin.framework.core.model.response.BaseResponse
import cn.guilin.framework.core.network.datasource.banner.BannerDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BannerRepository @Inject constructor(
    private var bannerDataSource: BannerDataSource
) {
    fun getBannerList(): Flow<BaseResponse<BasePageData<Banner>>> = flow {
        emit(bannerDataSource.getBannerList())
    }.flowOn(Dispatchers.IO)
}