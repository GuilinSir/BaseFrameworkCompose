package cn.guilin.framework.core.model.response

import kotlinx.serialization.Serializable

@Serializable
data class BasePageData<T>(
    /**
     * 列表
     */
    val list: List<T>? = null,

    /**
     * 分页数据
     */
    val pagination: BasePageMeta? = null,
)
