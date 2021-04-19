package enigma

import enigma.components.plugboard.Plugboard
import enigma.components.rotors.Reflector
import enigma.components.rotors.Rotor
import enigma.components.rotors.enums.ReflectorName
import enigma.components.rotors.enums.RotorName

class EnigmaFactory {
    fun get(
        rotors: Map<Int, Rotor> = mapOf(0 to Rotor(RotorName.I.permutation), 1 to Rotor(RotorName.II.permutation), 2 to Rotor(
        RotorName.III.permutation)),
        reflector: Reflector = Reflector(ReflectorName.B.permutation),
        plugboard: Plugboard = Plugboard()): Enigma {
        return Enigma(rotors, reflector, plugboard)
    }
}