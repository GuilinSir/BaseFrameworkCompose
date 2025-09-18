package cn.guilin.framework.core.data.repository

import cn.guilin.framework.core.model.Goods
import cn.guilin.framework.core.model.response.BasePageData
import cn.guilin.framework.core.model.response.BaseResponse
import cn.guilin.framework.core.network.datasource.goods.GoodsDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 商品仓库
 */
@Singleton
class GoodsRepository @Inject constructor(
    private var goodsDataSource: GoodsDataSource
) {
    /**
     * 获取商品列表
     */
    fun getGoods(page: Int = 1, size: Int = 10): Flow<BaseResponse<BasePageData<Goods>>> = flow {
        emit(goodsDataSource.getGoods(page, size))
    }.flowOn(Dispatchers.IO)
    
    /**
     * 添加/更新商品
     */
    fun saveGoods(goods: Goods): Flow<BaseResponse<Goods>> = flow {
        emit(goodsDataSource.saveGoods(goods))
    }.flowOn(Dispatchers.IO)
} 