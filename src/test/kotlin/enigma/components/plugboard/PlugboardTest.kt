package enigma.components.plugboard

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PlugboardTest {

    @Test
    fun constructor_validates_permutation() {

        // more than 10 swaps
        assertThrows(IllegalArgumentException::class.java) {  Plugboard("BADCFEHGJILKNMPORQTSVWUXYZ") }

        // o(pi) > 2
        assertThrows(IllegalArgumentException::class.java) {  Plugboard("BCDAFEHGJILKNMPORQTSVWUXYZ") }

    }

    @Test
    fun permutation_of_permutation_should_be_id() {

        //given
        val plugboard: Plugboard

        //when
        plugboard = Plugboard("BACDEFGHIJKLMNOPQRSTUVWXYZ")

        //then
        assertEquals('B', plugboard.permute('A'))
        assertEquals('A', plugboard.permute('B'))
        assertEquals('C', plugboard.permute('C'))

    }
}