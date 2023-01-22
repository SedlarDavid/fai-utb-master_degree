package cz.sedlardavid.eventorr.components.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import cz.sedlardavid.eventorr.components.eventDetail.EventLink
import cz.sedlardavid.eventorr.entities.Event
import cz.sedlardavid.eventorr.tools.DateTools
import cz.sedlardavid.eventorr.viewModels.EventsViewModel

@Composable
fun EventDetailPage(
    event: Event,
    navController: NavHostController,
) {
    val viewModel: EventsViewModel = hiltViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = rememberAsyncImagePainter(event.performers.first().image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(text = event.type.replaceFirstChar { c -> c.uppercase() }.replace('_', ' '), color = Color.White, fontSize = 25.sp)
            Text(text = event.title, color = Color.White)
            Text(text = "Date", color = Color.White, modifier = Modifier.padding(top = 10.dp), fontSize = 25.sp)
            Text(text = DateTools.getEventDate(event.datetime_local), color = Color.White)
            Text(text = "Performers", color = Color.White, modifier = Modifier.padding(top = 10.dp), fontSize = 25.sp)

            for (performer in event.performers) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 5.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(performer.image),
                        contentDescription = null,
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color.White, CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Text(text = performer.name ?: "", color = Color.White, modifier = Modifier.padding(start = 10.dp))
                }
            }


            Text(text = "More details", color = Color.White, modifier = Modifier.padding(top = 10.dp), fontSize = 25.sp)
            EventLink(event = event)
        }
    }
}