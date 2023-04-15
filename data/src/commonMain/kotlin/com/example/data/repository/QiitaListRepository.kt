package com.example.data.repository

import com.example.data.datasource.QiitaListRemoteDataSource
import com.example.data.response.QiitaListResponseDataItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QiitaListRepository(
    private val remoteDataSource: QiitaListRemoteDataSource
) {

    fun fetchQiitaList(
        page: Int
    ): Flow<List<QiitaListResponseDataItem>> {
        return remoteDataSource.fetchQiitaList(
            page = page
        )
    }
}