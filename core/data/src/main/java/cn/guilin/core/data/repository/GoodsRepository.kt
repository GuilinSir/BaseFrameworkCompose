package cn.guilin.core.data.repository

import cn.guilin.baseframeworkcompose.core.model.Goods
import cn.guilin.baseframeworkcompose.core.model.response.NetworkPageData
import cn.guilin.baseframeworkcompose.core.model.response.NetworkResponse
import cn.guilin.baseframeworkcompose.core.network.datasource.goods.GoodsNetworkDataSource
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
    private var goodsNetworkDataSource: GoodsNetworkDataSource
) {
    /**
     * 获取商品列表
     */
    fun getGoods(page: Int = 1, size: Int = 10): Flow<NetworkResponse<NetworkPageData<Goods>>> = flow {
        emit(goodsNetworkDataSource.getGoods(page, size))
    }.flowOn(Dispatchers.IO)
    
    /**
     * 添加/更新商品
     */
    fun saveGoods(goods: Goods): Flow<NetworkResponse<Goods>> = flow {
        emit(goodsNetworkDataSource.saveGoods(goods))
    }.flowOn(Dispatchers.IO)
} 