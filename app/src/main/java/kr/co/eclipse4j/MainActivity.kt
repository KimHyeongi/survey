package kr.co.eclipse4j

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.cio.Response
import kr.co.eclipse4j.client.KtorClient
import kr.co.eclipse4j.client.response.Survey
import kr.co.eclipse4j.client.response.SurveyList
import kr.co.eclipse4j.ui.theme.SurveyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurveyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SurveyListView()
                }
            }
        }
    }
}

/** List of Items */
@Composable
fun SurveyListView(
    modifier: Modifier = Modifier
) {
    var surveys by remember { mutableStateOf(emptyList<Survey>()) }
    LaunchedEffect(Unit) {
        val response = getApiData()
        surveys = response.content
    }

    LazyColumn(modifier=modifier.padding(vertical = 4.dp)){
        items(surveys) {survey ->
            SurveyList(survey = survey)
        }
    }
}

suspend fun getApiData(): SurveyList {
    return run {
        KtorClient.client().get("/api/v1/surveys").body<SurveyList>()
    }
}

/** UI for Card */
@Composable
fun SurveyList(survey: Survey) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)
    ) {
        SurveyContent(survey = survey)
    }
}

/** UI for Card Content*/
@Composable
fun SurveyContent(survey: Survey) {
    val content = survey
    var expanded by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .padding(10.dp)
            .animateContentSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
        ) {
            Text(
                text = survey.title,
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold)
                )
            if( expanded ) {
                Text(text = survey.description)
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if ( expanded ) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if ( expanded ) {
                    "show less"
                }else{
                    "show more"
                }
            )
        }
    }
}