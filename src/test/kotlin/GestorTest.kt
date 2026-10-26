package adalan


import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals


class GestorTest {


    @AfterTest
    fun restaurarEstado() {
        estado_acual = Estados.Idle
        nivel_actual = 0
    }


    @Test
    fun testIdleReiniciaNivel() {
        estado_acual = Estados.Idle
        nivel_actual = 5
        assertEquals(0, gestor())
        assertEquals(0, nivel_actual)
    }


    @Test
    fun testMovingUPDesdeNivel0() {
        estado_acual = Estados.MovingUP
        nivel_actual = 0
        assertEquals(1, gestor())
        assertEquals(1, nivel_actual)
        assertEquals(Estados.Idle, estado_acual)
    }


    @Test
    fun testMovingUPEnMovimientoNivel2() {
        estado_acual = Estados.MovingUP
        nivel_actual = 2
        assertEquals(2, gestor())
        assertEquals(2, nivel_actual)
    }


    @Test
    fun testMovingUPValorInvalido() {
        estado_acual = Estados.MovingUP
        nivel_actual = 5
        assertEquals(2, gestor())
        assertEquals(Estados.Error, estado_acual)
    }


    @Test
    fun testMovingDOWNDesdeNivel1() {
        estado_acual = Estados.MovingDOWN
        nivel_actual = 1
        assertEquals(0, gestor())
        assertEquals(0, nivel_actual)
        assertEquals(Estados.Idle, estado_acual)
    }


    @Test
    fun testMovingDOWNEnMovimientoNivel2() {
        estado_acual = Estados.MovingDOWN
        nivel_actual = 2
        assertEquals(2, gestor())
        assertEquals(2, nivel_actual)
    }


    @Test
    fun testMovingDOWNValorInvalido() {
        estado_acual = Estados.MovingDOWN
        nivel_actual = 0
        assertEquals(2, gestor())
        assertEquals(Estados.Error, estado_acual)
    }


    @Test
    fun testErrorEstableceNivelMenosUno() {
        estado_acual = Estados.Error
        nivel_actual = 5
        assertEquals(-1, gestor())
        assertEquals(-1, nivel_actual)
    }



}