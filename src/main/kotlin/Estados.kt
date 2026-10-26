package adalan


sealed class Estados {
    object Idle : Estados(){
        fun onEnter(){
            println("Entrado al estado Idle")
            Thread.sleep(1000)
            estado_acual = Estados.MovingUP

        }
        override fun toString(): String {
            return "Idle"
        }
    }



    object MovingUP : Estados(){
        fun onEnter(){
            println("Entrando a moving up")
            Thread.sleep(1000)

            val botonera = nivel_actual

            if (botonera == 0) {
                botonera +1
                print("subiendo a Plaza de Compostela")
            }

        }
        override fun toString(): String {
            return "MovingUP"
        }

    }
    object MovingDOWN : Estados(){


    }
    object Error : Estados(){


    }
}