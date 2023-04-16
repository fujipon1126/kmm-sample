package com.example.kmm_sample

import com.example.kmm_sample.di.module
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(module)
    }
}