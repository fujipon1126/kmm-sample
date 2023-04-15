package com.example.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("description")
    val description: String?,
    @SerialName("facebook_id")
    val facebook_id: String?,
    @SerialName("followees_count")
    val followees_count: Int,
    @SerialName("followers_count")
    val followers_count: Int,
    @SerialName("github_login_name")
    val github_login_name: String?,
    @SerialName("id")
    val id: String,
    @SerialName("items_count")
    val items_count: Int,
    @SerialName("linkedin_id")
    val linkedin_id: String?,
    @SerialName("location")
    val location: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("organization")
    val organization: String?,
    @SerialName("permanent_id")
    val permanent_id: Int,
    @SerialName("profile_image_url")
    val profile_image_url: String,
    @SerialName("team_only")
    val team_only: Boolean,
    @SerialName("twitter_screen_name")
    val twitter_screen_name: String?,
    @SerialName("website_url")
    val website_url: String?
)
