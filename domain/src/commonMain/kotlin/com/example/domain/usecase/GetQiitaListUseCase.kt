package com.example.domain.usecase

import com.example.data.repository.QiitaListRepository
import com.example.domain.QiitaListDomainData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetQiitaListUseCase(
    private val repository: QiitaListRepository
) {

    operator fun invoke(
        page: Int
    ): Flow<List<QiitaListDomainData>> {
        return repository.fetchQiitaList(page = page).map { response ->
            response.map {
                QiitaListDomainData(
                    title = it.title
                )
            }
        }
    }
}