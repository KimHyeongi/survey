package kr.co.eclipse4j.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kr.co.eclipse4j.client.response.KtorClientAPIUrlProperty

class KtorClient {
    companion object {
        private val baseUrl: String = KtorClientAPIUrlProperty.base_url
        fun client(): HttpClient {
            return HttpClient(CIO) {
                expectSuccess = true
                engine {
                }
                defaultRequest {
                    url(baseUrl)
                }
                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    })
                }
            }
        }
    }
}