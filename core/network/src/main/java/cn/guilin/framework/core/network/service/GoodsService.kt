package cn.guilin.framework.core.network.service

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
    ): cn.guilin.core.model.response.NetworkResponse<cn.guilin.core.model.response.NetworkPageData<cn.guilin.core.model.Goods>>

    /**
     * 添加/更新商品
     */
    @POST("goods")
    suspend fun saveGoods(@Body goods: cn.guilin.core.model.Goods): cn.guilin.core.model.response.NetworkResponse<cn.guilin.core.model.Goods>
}