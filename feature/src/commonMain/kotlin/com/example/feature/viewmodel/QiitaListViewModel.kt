package com.example.feature.viewmodel

import com.example.domain.usecase.GetQiitaListUseCase
import com.example.feature.state.QiitaListUiState
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class QiitaListViewModel(
    private val getQiitaListUseCase: GetQiitaListUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(QiitaListUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchQiitaList()
    }

    private fun fetchQiitaList() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }
            getQiitaListUseCase(page = 1).collect { result ->
                println("getQiitaListUseCase result = ${result.size}")
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        isSuccess = true,
                        qiitaList = result
                    )
                }
            }
        }
    }

}