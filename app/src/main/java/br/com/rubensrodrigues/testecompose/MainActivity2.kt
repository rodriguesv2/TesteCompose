package br.com.rubensrodrigues.testecompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rubensrodrigues.testecompose.ui.theme.TesteComposeTheme

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TesteComposeTheme {
                Bar()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PhotographerCardPreview() {
    TesteComposeTheme {
        PhotographerCard()
    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable {
                //ignorando, só para ter o efeitinho!
            }
            .padding(16.dp)

    ) {
        Surface(
            modifier = modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            //Imagem vai aqui, tio
        }
        Column(
            modifier = modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = "Beltrano da Silva",
                fontWeight = FontWeight.Bold
            )
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = "3 minutos atrás",
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview
@Composable
fun Bar() {
    TopAppBar(
        navigationIcon = {
            ToolbarIcon(
                clickText = "Menu",
                iconRes = R.drawable.ic_menu
            )
        },
        title = {
            Text(text = "Teste Compose")
        },
        actions = {
            Row {
                ToolbarIcon(
                    clickText = "Favorite",
                    iconRes = R.drawable.ic_heart
                )
                ToolbarIcon(
                    clickText = "Cast",
                    iconRes = R.drawable.ic_cast
                )
                ToolbarIcon(
                    clickText = "Options",
                    iconRes = R.drawable.ic_dots
                )
            }
        }
    )
}

@Composable
private fun ToolbarIcon(
    clickText: String,
    @DrawableRes iconRes: Int
) {
    val context = LocalContext.current
    IconButton(
        onClick = {
            Toast.makeText(
                context,
                clickText,
                Toast.LENGTH_SHORT
            ).show()
        }
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = ""
        )
    }
}