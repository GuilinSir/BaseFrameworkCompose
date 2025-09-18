package cn.guilin.framework.core.network.datasource.goods

import cn.guilin.framework.core.model.Goods
import cn.guilin.framework.core.model.response.BasePageData
import cn.guilin.framework.core.model.response.BaseResponse
import cn.guilin.framework.core.network.datasource.base.BaseDataSource


/**
 *商品网络数据源接口
 */
interface GoodsDataSource : BaseDataSource {

    /**
     * 获取商品列表
     */
    suspend fun getGoods(page: Int, size: Int): BaseResponse<BasePageData<Goods>>

    /**
     * 添加/更新商品
     */
    suspend fun saveGoods(goods: Goods): BaseResponse<Goods>
}