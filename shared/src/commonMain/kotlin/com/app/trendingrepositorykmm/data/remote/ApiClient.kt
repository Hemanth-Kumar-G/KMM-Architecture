package com.app.trendingrepositorykmm.data.remote

import com.app.trendingrepositorykmm.httpClient
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object ApiClient {

    private val httpApiClient: HttpClient = httpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    suspend fun getVyaparEmployee(): HttpResponse {
       return httpApiClient.get("https://firebasestorage.googleapis.com/v0/b/spotify-71dd7.appspot.com/o/vyaparEmployee.json?alt=media&token=4a7cc237-8e90-496a-8ce0-70406fc14c12")
    }
}