package com.example.notasbienvenida

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultScreen(
    promedio: Double,
    onReiniciar: () -> Unit,
    onSalir: () -> Unit
) {
    val aprobado = promedio >= 6.0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Resultado Final",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Promedio obtenido: %.2f".format(promedio),
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = if (aprobado) "El estudiante aprobó" else "El estudiante reprobó",
            style = MaterialTheme.typography.titleMedium,
            color = if (aprobado) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.error
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onReiniciar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Ingresar otras notas")
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = onSalir,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Cerrar sesión")
        }
    }
}