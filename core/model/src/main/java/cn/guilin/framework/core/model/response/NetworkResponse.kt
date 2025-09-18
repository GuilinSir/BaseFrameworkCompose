package cn.guilin.framework.core.model.response

import kotlinx.serialization.Serializable

@Serializable
data class NetworkResponse<T>(
    /**
     * 真实数据
     * 类型是泛型
     */
    val data: T? = null,
    /**
     * 状态码
     * 等于100表示成功
     */
    val code: Int = 1000,
    /**
     * 出错的提示信息
     * 发生了错误不一定有
     */
    val message: String? = null

) {
    val isSucceeded: Boolean
        get() = code == 1000
}
