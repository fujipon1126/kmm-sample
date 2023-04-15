package com.example.feature.state

import com.example.domain.QiitaListDomainData

data class QiitaListUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isError: Boolean = false,
    val qiitaList: List<QiitaListDomainData> = emptyList()
)