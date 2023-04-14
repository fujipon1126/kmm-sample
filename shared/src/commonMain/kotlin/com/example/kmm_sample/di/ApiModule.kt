package com.example.kmm_sample.di

import de.jensklingenberg.ktorfit.Ktorfit

class ApiModule {

    fun provideRetrofit(): Ktorfit {
        return Ktorfit.Builder().baseUrl("https://qiita.com/api/v2/").build()
    }
}