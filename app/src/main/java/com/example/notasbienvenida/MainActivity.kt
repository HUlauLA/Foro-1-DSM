package com.example.notasbienvenida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var pantallaActual by remember { mutableStateOf("bienvenida") }
            var promedioFinal by remember { mutableStateOf(0.0) }

            when (pantallaActual) {

                "bienvenida" -> PantallaBienvenida(
                    nombreUsuario = "Usuario",
                    onContinuar = {
                        pantallaActual = "notas"
                    }
                )

                "notas" -> PantallaNotas(
                    onVolver = {
                        pantallaActual = "bienvenida"
                    },
                    onCalcularPromedio = { promedio ->
                        promedioFinal = promedio
                        pantallaActual = "resultado"
                    }
                )

                "resultado" -> ResultScreen(
                    promedio = promedioFinal,
                    onReiniciar = {
                        pantallaActual = "notas"
                    },
                    onSalir = {
                        promedioFinal = 0.0
                        pantallaActual = "bienvenida"
                    }
                )
            }
        }
    }
}