package br.com.rubensrodrigues.testecompose.flow

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import br.com.rubensrodrigues.testecompose.databinding.LayoutTestBinding
import br.com.rubensrodrigues.testecompose.ui.theme.TesteComposeTheme

class NavigationActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TesteComposeTheme {
                Graph()
            }
        }
    }
}