package com.example.domain

import com.example.domain.usecase.GetQiitaListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetQiitaListUseCase(get()) }
}