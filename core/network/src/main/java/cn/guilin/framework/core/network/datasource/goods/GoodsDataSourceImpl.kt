package cn.guilin.framework.core.network.datasource.goods

import cn.guilin.framework.core.model.Goods
import cn.guilin.framework.core.model.response.BasePageData
import cn.guilin.framework.core.model.response.BaseResponse
import cn.guilin.framework.core.network.base.NetworkDataSource
import cn.guilin.framework.core.network.service.GoodsService
import javax.inject.Inject

class GoodsDataSourceImpl @Inject constructor(
    private val goodsService: GoodsService
) : NetworkDataSource(), GoodsDataSource {

    override suspend fun getGoods(page: Int, size: Int): BaseResponse<BasePageData<Goods>> {
        return goodsService.getGoods(page, size)
    }

    override suspend fun saveGoods(goods: Goods): BaseResponse<Goods> {
        return goodsService.saveGoods(goods)
    }

}