package br.com.rubensrodrigues.testecompose.flow

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Tela01(
    onButtonClick: ()->Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Essa é a tela 01")
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onButtonClick,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            Text(text = "Ir para tela02")
        }
    }
}

@Composable
fun Tela02() {
    Text(text = "Ess é a tela 02")
}

@Preview(showSystemUi = true)
@Composable
fun PreviewTela01() {
    Tela01 {}
}

@Preview(showSystemUi = true)
@Composable
fun PreviewTela02() {
    Tela02()
}