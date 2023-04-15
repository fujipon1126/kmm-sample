package com.example.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.feature.viewmodel.QiitaListViewModel

@Composable
fun QiitaListScreen(
    viewModel: QiitaListViewModel
) {
    val uiState = viewModel.uiState.collectAsState()

    Column {
        Text(text = if (uiState.value.isLoading) "Loading..." else "LoadFinish")
        if (uiState.value.isLoading) {
            CircularProgressIndicator()
        }
        if (!uiState.value.isLoading && !uiState.value.isError) {
            Text(text = uiState.value.qiitaList.size.toString())
        }
    }
}