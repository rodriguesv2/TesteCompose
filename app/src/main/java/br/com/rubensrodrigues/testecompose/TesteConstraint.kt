package br.com.rubensrodrigues.testecompose

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showSystemUi = true)
@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        val (button, text) = createRefs()

        Button(
            onClick = {},
            modifier = Modifier.constrainAs(button) {
                top.linkTo(
                    anchor = parent.top,
                    margin = 16.dp
                )

                centerHorizontallyTo(parent)
            }
        ) {
            Text(text = "Button")
        }

        Text(
            text = "Text",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(
                    anchor = button.bottom,
                    margin = 16.dp
                )

                centerHorizontallyTo(button)
            }
        )
    }
}