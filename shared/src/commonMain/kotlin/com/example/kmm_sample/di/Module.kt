package com.example.kmm_sample.di

import com.example.data.di.dataSourceModule
import com.example.data.di.qiitaListApi
import com.example.data.di.repositoryModule
import com.example.domain.useCaseModule
import org.koin.dsl.module
import com.example.feature.platformModule

val module = module {
    single { qiitaListApi }
} + dataSourceModule + repositoryModule + useCaseModule + platformModule()