package cn.guilin.framework.core.network.datasource.banner

import cn.guilin.framework.core.model.Banner
import cn.guilin.framework.core.model.response.BasePageData
import cn.guilin.framework.core.model.response.BaseResponse
import cn.guilin.framework.core.network.base.NetworkDataSource
import cn.guilin.framework.core.network.service.BannerService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BannerDataSourceImpl @Inject constructor(
    private var bannerService: BannerService
) : NetworkDataSource(), BannerDataSource {
    override suspend fun getBannerList(): BaseResponse<BasePageData<Banner>> {
        return bannerService.getBannerList()
    }

}