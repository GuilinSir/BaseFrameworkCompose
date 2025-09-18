package cn.guilin.framework.core.network.datasource.banner

import cn.guilin.framework.core.model.Banner
import cn.guilin.framework.core.model.response.BasePageData
import cn.guilin.framework.core.model.response.BaseResponse
import cn.guilin.framework.core.network.datasource.base.BaseDataSource

interface BannerDataSource : BaseDataSource {
    suspend fun getBannerList(): BaseResponse<BasePageData<Banner>>
}