package adalan


sealed class Estados {
    object Idle : Estados()
    object MovingUP : Estados()
    object MovingDOWN : Estados()
    object Error : Estados()
}