package com.example.feature

import com.example.feature.viewmodel.QiitaListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    viewModel { QiitaListViewModel(get()) }
}