package com.example.notasbienvenida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var pantallaActual by remember { mutableStateOf("login") }

            when (pantallaActual) {

                "login" -> LoginScreen(
                    onLoginClick = { email, password ->
                        pantallaActual = "notas"
                    }
                )

                "notas" -> PantallaNotas(
                    onVolver = {
                        pantallaActual = "login"
                    }
                )
            }
        }
    }
}