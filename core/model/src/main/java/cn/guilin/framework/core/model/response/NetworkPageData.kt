package cn.guilin.framework.core.model.response

import kotlinx.serialization.Serializable

@Serializable
data class NetworkPageData<T>(
    /**
     * 列表
     */
    val list: List<T>? = null,

    /**
     * 分页数据
     */
    val pagination: NetworkPageMeta? = null,
)
