package adalan


// nivel en el que se encuentra el ascensor
var nivel_actual: Int = 0
// estado actual del ascensor
var estado_acual: Estados = Estados.Idle

/**
 * Gestiona el cambio de estados
 */
fun gestor(): Int {
    println("Estado actual: ${estado_acual.toString()}")
    when (estado_acual) {
        is Estados.Idle -> {
            nivel_actual = 0
            (estado_acual as Estados.Idle).onEnter()
            return nivel_actual
        }
        is Estados.MovingUP -> {
            nivel_actual = 2
            (estado_acual as Estados.MovingUP).onEnter()
            return nivel_actual
        }
        is Estados.MovingDOWN -> {
            nivel_actual = 2
            (estado_acual as Estados.MovingDOWN).onEnter()
            return nivel_actual
        }
        is Estados.Error -> {
            nivel_actual = -1
            (estado_acual as Estados.Error).onEnter()
            return nivel_actual
        }
    }
}