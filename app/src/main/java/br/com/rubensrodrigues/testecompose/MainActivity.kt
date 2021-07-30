package br.com.rubensrodrigues.testecompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import br.com.rubensrodrigues.testecompose.ui.theme.TesteComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TesteComposeTheme {
                Counter()
            }
        }
    }
}

@Composable
fun NewsStory() {
    MaterialTheme {
//        Scaffold {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.header),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxHeight()
                    .clip(shape = RoundedCornerShape(4.dp))
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Um belo dia ensolarado perto do arco no centro de Osasco, lar do melhor cachorro quente do mundo",
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Osasco, SP",
                style = typography.body2
            )
            Text(
                text = "18 de janeiro",
                style = typography.body2
            )
        }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsStory()
}

@Preview(showBackground = true)
@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }

     Box {
        Button(
            onClick = { count.value++ },
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Center),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (count.value % 2 == 0) Color.Green else Color.Red
            )
        ) {
            Text(text = count.value.toString())
        }
    }
}
