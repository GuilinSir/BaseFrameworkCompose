package cn.guilin.baseframeworkcompose.core.model

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
