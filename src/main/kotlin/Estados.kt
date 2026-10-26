package adalan


sealed class Estados {
    object Idle : Estados(){
        fun onEnter(){
            println("Entrado al estado Idle")
            Thread.sleep(2000)
            estado_acual = Estados.MovingUP

        }

    }



    object MovingUP : Estados(){
        fun onEnter(){
            println("Entrando a moving up")
            Thread.sleep(2000)

            val botonera = nivel_actual
            if (botonera == 2) {
                print("Mecanismo en movimiento")
            }else if (botonera == 0) {
                botonera +2
                print("subiendo a Plaza de Compostela")
                estado_acual = Estados.MovingDOWN
            } else{
                print("valor no valido")
                estado_acual = Estados.Error
            }
            botonera -1
        }


    }
    object MovingDOWN : Estados(){
        fun onEnter(){
            println("Entrando a moving down")
            Thread.sleep(2000)

            val botonera = nivel_actual

            if (botonera == 2) {
                print("Mecanismo en movimiento")
            }else if (botonera == 1) {
                botonera +1
                print("bajando a Avenida G. Barbón")
                estado_acual = Estados.Idle
            } else{
                print("valor no valido")
                estado_acual = Estados.Error
            }
            botonera -2
        }


    }
    object Error : Estados(){
        fun onEnter() {
            println("Entrando al estado Error")
            Thread.sleep(2000)
            println("Error: entrada de valor no valido ")
            estado_acual = Estados.Idle
        }



    }
}