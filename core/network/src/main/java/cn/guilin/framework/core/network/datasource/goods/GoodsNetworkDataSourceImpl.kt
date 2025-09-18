package cn.guilin.framework.core.network.datasource.goods

import cn.guilin.framework.core.model.Goods
import cn.guilin.framework.core.model.response.NetworkPageData
import cn.guilin.framework.core.model.response.NetworkResponse
import cn.guilin.framework.core.network.base.BaseNetworkDataSource
import cn.guilin.framework.core.network.service.GoodsService
import javax.inject.Inject

class GoodsNetworkDataSourceImpl @Inject constructor(
    private val goodsService: GoodsService
) : BaseNetworkDataSource(), GoodsNetworkDataSource {

    override suspend fun getGoods(page: Int, size: Int): NetworkResponse<NetworkPageData<Goods>> {
        return goodsService.getGoods(page, size)
    }

    override suspend fun saveGoods(goods: Goods): NetworkResponse<Goods> {
        return goodsService.saveGoods(goods)
    }

}