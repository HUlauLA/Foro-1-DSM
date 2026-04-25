package com.example.notasbienvenida

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaNotas(
    onVolver: () -> Unit,
    onCalcularPromedio: (Double) -> Unit
) {

    var nota1 by remember { mutableStateOf("") }
    var nota2 by remember { mutableStateOf("") }
    var nota3 by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text("Ingreso de Notas", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(nota1, { nota1 = it }, label = { Text("Nota 1") })
        OutlinedTextField(nota2, { nota2 = it }, label = { Text("Nota 2") })
        OutlinedTextField(nota3, { nota3 = it }, label = { Text("Nota 3") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {

            val n1 = nota1.toDoubleOrNull()
            val n2 = nota2.toDoubleOrNull()
            val n3 = nota3.toDoubleOrNull()

            if (n1 != null && n2 != null && n3 != null) {
                val promedio = (n1 + n2 + n3) / 3
                onCalcularPromedio(promedio)
            } else {
                error = "Ingrese valores válidos"
            }

        }) {
            Text("Calcular")
        }

        if (error.isNotEmpty()) {
            Text(error, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onVolver) {
            Text("Volver")
        }
    }
}
