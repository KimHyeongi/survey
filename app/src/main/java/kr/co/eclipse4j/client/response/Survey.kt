package kr.co.eclipse4j.client.response

import kotlinx.serialization.Serializable
import java.time.ZonedDateTime

@Serializable
data class SurveyList (
    val content: List<Survey> = listOf(),
    val page: Page
)

@Serializable
data class Survey (
    val id: Long,
    val title: String,
    val description: String,
    val representativeImageUrl: String,
    val dpStartedAt: String,
    val dpEndedAt: String
)

@Serializable
data class Page (
    val page: Long,
    val size: Long,
)
