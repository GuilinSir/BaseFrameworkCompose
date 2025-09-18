package cn.guilin.framework.core.network.service

import cn.guilin.framework.core.model.Banner
import cn.guilin.framework.core.model.response.BasePageData
import cn.guilin.framework.core.model.response.BaseResponse
import retrofit2.http.POST

interface BannerService {
    /**
     * 获取轮播图列表
     */
    @POST("/info/banner/list")
    suspend fun getBannerList(): BaseResponse<BasePageData<Banner>>
}