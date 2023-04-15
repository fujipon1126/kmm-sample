package com.example.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QiitaListResponseDataItem(
    @SerialName("body")
    val body: String,
    @SerialName("coediting")
    val coediting: Boolean,
    @SerialName("comments_count")
    val comments_count: Int,
    @SerialName("created_at")
    val created_at: String,
    @SerialName("group")
    val group: String?,
    @SerialName("id")
    val id: String,
    @SerialName("likes_count")
    val likes_count: Int,
    @SerialName("page_views_count")
    val page_views_count: Int?,
    @SerialName("private")
    val `private`: Boolean,
    @SerialName("reactions_count")
    val reactions_count: Int,
    @SerialName("rendered_body")
    val rendered_body: String,
    @SerialName("stocks_count")
    val stocks_count: Int,
    @SerialName("tags")
    val tags: List<Tag>,
    @SerialName("team_membership")
    val team_membership: String?,
    @SerialName("title")
    val title: String,
    @SerialName("updated_at")
    val updated_at: String,
    @SerialName("url")
    val url: String,
    @SerialName("user")
    val user: User
)
