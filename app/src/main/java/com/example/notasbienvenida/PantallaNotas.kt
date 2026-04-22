package com.example.notasbienvenida

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaNotas(onVolver: () -> Unit) {

    var nota1 by remember { mutableStateOf("") }
    var nota2 by remember { mutableStateOf("") }
    var nota3 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text("Ingreso de Notas", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nota1,
            onValueChange = { nota1 = it },
            label = { Text("Nota 1") }
        )

        OutlinedTextField(
            value = nota2,
            onValueChange = { nota2 = it },
            label = { Text("Nota 2") }
        )

        OutlinedTextField(
            value = nota3,
            onValueChange = { nota3 = it },
            label = { Text("Nota 3") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val n1 = nota1.toDoubleOrNull()
            val n2 = nota2.toDoubleOrNull()
            val n3 = nota3.toDoubleOrNull()

            if (n1 != null && n2 != null && n3 != null) {
                val promedio = (n1 + n2 + n3) / 3
                resultado = if (promedio >= 6) {
                    "Promedio: %.2f - Aprobó".format(promedio)
                } else {
                    "Promedio: %.2f - Reprobó".format(promedio)
                }
            } else {
                resultado = "Ingrese valores válidos"
            }
        }) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(16.dp))

        //Text(resultado)
        val colorResultado = when {
            resultado.contains("Aprobó") -> androidx.compose.ui.graphics.Color(0xFF4CAF50)
            resultado.contains("Reprobó") -> androidx.compose.ui.graphics.Color.Red
            else -> androidx.compose.ui.graphics.Color.Black
        }

        Text(
            text=resultado,
            fontSize = 20.sp,
            color = colorResultado
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {onVolver()}) {
            Text("Volver")
        }
    }
}