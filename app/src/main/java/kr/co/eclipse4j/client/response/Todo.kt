package kr.co.eclipse4j.client.response

/**
 * {
 *     "userId": 1,
 *     "id": 1,
 *     "title": "delectus aut autem",
 *     "completed": false
 *   }
 */
data class Todo (
    val userId: Long,
    val id: Long,
    val title: String,
    val completed: Boolean
)
