package adalan


sealed class Estados {
    object Idle : Estados() {
        fun onEnter() {
            println("Entrado al estado Idle")
        }
        override fun toString(): String {
            return "E1_Idle"
        }
    }


    object MovingUP : Estados() {
        fun onEnter() {
            println("Entrando a moving up")
            var botonera = nivel_actual
            if (botonera == 2) {
                print("Mecanismo en movimiento")
            } else if (botonera == 0) {
                print("subiendo a Plaza de Compostela")
                nivel_actual = 1
                estado_acual = Estados.Idle
            } else {
                print("valor no valido")
                estado_acual = Estados.Error
            }
        }
        override fun toString(): String {
            return "MovingUP"
        }
    }


    object MovingDOWN : Estados() {
        fun onEnter() {
            println("Entrando a moving down")
            var botonera = nivel_actual
            if (botonera == 2) {
                print("Mecanismo en movimiento")
            } else if (botonera == 1) {
                print("bajando a Avenida G. Barbón")
                nivel_actual = 0
                estado_acual = Estados.Idle
            } else {
                print("valor no valido")
                estado_acual = Estados.Error
            }
        }
        override fun toString(): String {
            return "MovingDOWN"
        }
    }


    object Error : Estados() {
        fun onEnter() {
            println("Entrando al estado Error")
            nivel_actual = -1
            estado_acual = Estados.Idle
        }
        override fun toString(): String {
            return "Error"
        }
    }
}