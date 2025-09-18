package cn.guilin.framework.core.network.datasource.goods

import cn.guilin.core.network.datasource.base.NetworkDataSource

/**
 *商品网络数据源接口
 */
interface GoodsNetworkDataSource : NetworkDataSource {

    /**
     * 获取商品列表
     */
    suspend fun getGoods(page: Int, size: Int): cn.guilin.core.model.response.NetworkResponse<cn.guilin.core.model.response.NetworkPageData<cn.guilin.core.model.Goods>>

    /**
     * 添加/更新商品
     */
    suspend fun saveGoods(goods: cn.guilin.core.model.Goods): cn.guilin.core.model.response.NetworkResponse<cn.guilin.core.model.Goods>
}