package com.example.data.di

import com.example.data.repository.QiitaListRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { QiitaListRepository(get()) }
}