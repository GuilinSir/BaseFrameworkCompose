package cn.guilin.framework.core.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Banner(
    val id: Long,
    val createTime: String,
    val updateTime: String,
    val description: JsonElement? = null,
    val path: JsonElement? = null,
    val pic: String,
    val sortNum: Long,
    val status: Long
)