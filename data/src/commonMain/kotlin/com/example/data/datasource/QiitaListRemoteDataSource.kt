package com.example.data.datasource

import com.example.data.api.QiitaListApi
import com.example.data.response.QiitaListResponseDataItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class QiitaListRemoteDataSource(
    private val qiitaListApi: QiitaListApi
) {
    fun fetchQiitaList(
        page: Int,
    ): Flow<List<QiitaListResponseDataItem>> {
        return flow {
            val response = qiitaListApi.fetchQiitaList(
                page = page,
                parPage = 20,
            )
            emit(response)
        }
    }

}