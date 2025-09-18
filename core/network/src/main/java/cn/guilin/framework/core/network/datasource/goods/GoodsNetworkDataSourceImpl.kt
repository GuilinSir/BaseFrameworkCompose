package cn.guilin.framework.core.network.datasource.goods

import cn.guilin.core.network.base.BaseNetworkDataSource
import cn.guilin.core.network.service.GoodsService
import javax.inject.Inject

class GoodsNetworkDataSourceImpl @Inject constructor(
    private val goodsService: GoodsService
) : BaseNetworkDataSource(), GoodsNetworkDataSource {

    override suspend fun getGoods(page: Int, size: Int): cn.guilin.core.model.response.NetworkResponse<cn.guilin.core.model.response.NetworkPageData<cn.guilin.core.model.Goods>> {
        return goodsService.getGoods(page, size)
    }

    override suspend fun saveGoods(goods: cn.guilin.core.model.Goods): cn.guilin.core.model.response.NetworkResponse<cn.guilin.core.model.Goods> {
        return goodsService.saveGoods(goods)
    }

}