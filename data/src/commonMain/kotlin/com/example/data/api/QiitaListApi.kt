package com.example.data.api

import com.example.data.response.QiitaListResponseDataItem
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query

interface QiitaListApi {

    @GET("items")
    suspend fun fetchQiitaList(
        @Query("page") page: Int,
        @Query("par_page") parPage: Int,
    ): List<QiitaListResponseDataItem>

}