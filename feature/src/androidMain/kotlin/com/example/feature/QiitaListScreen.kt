package com.example.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.feature.viewmodel.QiitaListViewModel

@Composable
fun QiitaListScreen(
    viewModel: QiitaListViewModel
) {
    val uiState = viewModel.uiState.collectAsState()

    if (uiState.value.isSuccess) {
        val qiitaList = uiState.value.qiitaList
        Surface(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(qiitaList.size) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Start,
                        text = (it + 1).toString() + "件目:" + qiitaList[it].title
                    )
                }
            }
        }
    } else {
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
}