package br.com.rubensrodrigues.testecompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SimpleList()
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SimpleList() {
    val listSize = 100

    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row(horizontalArrangement = Arrangement.Center) {
            ListButton(
                coroutineScope = coroutineScope,
                scrollState = scrollState,
                index = 0,
                text = "Scroll para o topo"
            )
            ListButton(
                coroutineScope = coroutineScope,
                scrollState = scrollState,
                index = listSize - 1,
                text = "Scroll para o final"
            )
        }
        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(it)
            }
        }
    }
}

@Composable
private fun ImageListItem(item: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://www.mobile2you.com.br/wp-content/themes/twentyfifteen/images/logo-circle.png"
            ),
            contentDescription = "M2Y Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Item #$item", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
private fun ListButton(
    coroutineScope: CoroutineScope,
    scrollState: LazyListState,
    index: Int,
    text: String
) {
    Button(
        onClick = {
            coroutineScope.launch {
                scrollState.animateScrollToItem(index)
            }
        },
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = text)
    }
}

