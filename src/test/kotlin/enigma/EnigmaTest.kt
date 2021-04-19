package enigma

import enigma.components.plugboard.Plugboard
import enigma.components.rotors.Reflector
import enigma.components.rotors.Rotor
import enigma.components.rotors.enums.ReflectorName
import enigma.components.rotors.enums.RotorName
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class EnigmaTest {

    @Test
    fun decrypt_encrypted_message_with_same_key_should_succeed() {
        // given
        val secret = "LOREMIPSUMNSAKJFBDJAHBDJHVFJHAVDJAHBDVHASVDASHDGVAS"
        val sender = EnigmaFactory().get()
        val receiver = EnigmaFactory().get()

        // when
        val cipher = sender.encrypt(secret)
        val plaintext = receiver.decrypt(cipher)

        // then
        assertEquals(secret, plaintext)
    }

    @Test
    fun rotors_should_turn() {
        // given
        val secret = "LOREMIPSUMNSAKJFBDJAHBDJHVFJHAVDJAHBDVHASVDASHDGVAS"
        val senderRotor1 = Rotor(RotorName.I)
        val senderRotor2 = Rotor(RotorName.II)
        val senderRotor3 = Rotor(RotorName.III)
        val sender = Enigma(mapOf(0 to senderRotor1, 1 to senderRotor2, 2 to senderRotor3),
            Reflector(ReflectorName.B), Plugboard("BACDEFGHIJKLMNOPQRSTUVWXYZ"))
        val receiverRotor1 = Rotor(RotorName.I)
        val receiverRotor2 = Rotor(RotorName.II)
        val receiverRotor3 = Rotor(RotorName.III)
        val receiver = Enigma(mapOf(0 to receiverRotor1, 1 to receiverRotor2, 2 to receiverRotor3),
            Reflector(ReflectorName.B), Plugboard("BACDEFGHIJKLMNOPQRSTUVWXYZ"))

        // when
        val cipher = sender.encrypt(secret)
        receiver.decrypt(cipher)

        // 52 mod 26
        assertEquals(25, senderRotor1.position)
        assertEquals(25, receiverRotor1.position)
        // notch is 0, every time the first rotor goes from 0 -> 1 the second rotor should turn.
        assertEquals(2, senderRotor2.position)
        assertEquals(2, receiverRotor2.position)

    }

    @Test
    fun cypher_is_same_length() {
        // given
        val secret = "LOREMIPSUMNSAKJFBDJAHBDJHVFJHAVDJAHBDVHASVDASHDGVAS"
        val sender = EnigmaFactory().get()
        val receiver = EnigmaFactory().get()

        // when
        val cipher = sender.encrypt(secret)
        receiver.decrypt(cipher)

        // then
        assertTrue(cipher.length==secret.length) // the enigma cipher is always the same length

    }

    @Test
    fun a_letter_never_maps_to_itself() {
        // given
        val secret = "LOREMIPSUMNSAKJFBDJAHBDJHVFJHAVDJAHBDVHASVDASHDGVAS"
        val enigma = EnigmaFactory().get()

        // when
        val cipher = enigma.encrypt(secret)

        // then
        cipher.forEachIndexed { index, it -> assertTrue(!it.equals(secret[index])) } // a flaw in engima is that a letter can never be permuted onto itself

    }
}