package cn.guilin.framework.core.network.datasource.goods

import cn.guilin.framework.core.model.Goods
import cn.guilin.framework.core.model.response.NetworkPageData
import cn.guilin.framework.core.model.response.NetworkResponse
import cn.guilin.framework.core.network.datasource.base.NetworkDataSource


/**
 *商品网络数据源接口
 */
interface GoodsNetworkDataSource : NetworkDataSource {

    /**
     * 获取商品列表
     */
    suspend fun getGoods(page: Int, size: Int): NetworkResponse<NetworkPageData<Goods>>

    /**
     * 添加/更新商品
     */
    suspend fun saveGoods(goods: Goods): NetworkResponse<Goods>
}