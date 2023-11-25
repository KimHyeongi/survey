package kr.co.eclipse4j.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.gson.gson

class KtorClient {
    companion object {
        private val baseUrl: String = "https://jsonplaceholder.typicode.com/"
        fun clinet(): HttpClient {
            return HttpClient(CIO) {
                expectSuccess = true
                engine {
                }
                defaultRequest {
                    url(baseUrl)
                }
                install(ContentNegotiation) {
                    gson()
                }
            }
        }
    }
}