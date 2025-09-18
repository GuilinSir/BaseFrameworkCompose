package cn.guilin.framework.core.network.service

import cn.guilin.framework.core.model.Goods
import cn.guilin.framework.core.model.response.BasePageData
import cn.guilin.framework.core.model.response.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface GoodsService {

    /**
     * 获取商品列表
     */
    @POST("goods/info/page")
    suspend fun getGoods(
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 10
    ): BaseResponse<BasePageData<Goods>>

    /**
     * 添加/更新商品
     */
    @POST("goods")
    suspend fun saveGoods(@Body goods: Goods): BaseResponse<Goods>
}