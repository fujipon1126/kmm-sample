package com.example.data.di

import com.example.data.api.QiitaListApi
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.builtin.FlowResponseConverter
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val ktorfitBuilder = Ktorfit
    .Builder()
    .httpClient(
        HttpClient {
            install(ContentNegotiation) {
                json(Json { isLenient = true; ignoreUnknownKeys = true })
                install(Logging)
            }
        }
    )
    .responseConverter(FlowResponseConverter())

val qiitaListKtorfit = ktorfitBuilder.baseUrl("https://qiita.com/api/v2/").build()
val qiitaListApi = qiitaListKtorfit.create<QiitaListApi>()