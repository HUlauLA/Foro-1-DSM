setContent {

    var pantallaActual by remember { mutableStateOf("login") }
    var promedioFinal by remember { mutableStateOf(0.0) }
    var nombreUsuario by remember { mutableStateOf("") }

    when (pantallaActual) {

        "login" -> LoginScreen(
            onLoginExitoso = { nombre ->
                nombreUsuario = nombre
                pantallaActual = "bienvenida"
            }
        )

        "bienvenida" -> PantallaBienvenida(
            nombreUsuario = nombreUsuario,
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
                pantallaActual = "login"
            }
        )
    }
}
