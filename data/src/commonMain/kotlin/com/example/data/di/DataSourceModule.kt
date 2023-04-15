package com.example.data.di

import com.example.data.datasource.QiitaListRemoteDataSource
import com.example.data.repository.QiitaListRepository
import org.koin.dsl.module

val dataSourceModule = module {
    single { QiitaListRemoteDataSource(get()) }
}