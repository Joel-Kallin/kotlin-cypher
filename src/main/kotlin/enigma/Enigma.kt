package enigma

import encryption.Decryptor
import encryption.Encryptor
import enigma.components.plugboard.Plugboard
import enigma.components.rotors.Reflector
import enigma.components.rotors.Rotor
import enigma.components.rotors.Rotors

class Enigma(rotorMap: Map<Int, Rotor>, reflector: Reflector, plugboard: Plugboard): Encryptor, Decryptor {

    private val rotors: Rotors = Rotors(rotorMap, reflector)
    private val plugboard: Plugboard = plugboard

    override fun decrypt(cipherText: String): String {
        return permute(cleanInput(cipherText))
    }

    override fun encrypt(plainText: String): String {
        return permute(cleanInput(plainText))
    }

    private fun cleanInput(plainText: String): String {
        val re = Regex("[^A-Za-z]")
        return re.replace(plainText, "").toUpperCase()
    }

    private fun permute(text: String): String {
        return text.map { plugboard.permute(rotors.permute(plugboard.permute(it)))}.joinToString(separator = "")
    }
}