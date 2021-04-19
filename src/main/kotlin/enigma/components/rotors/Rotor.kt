package enigma.components.rotors

import enigma.components.Permutation
import enigma.components.rotors.enums.RotorName

class Rotor(permutationString: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ", startPosition: Int = 0, notch: Int = 0) : Permutation(permutationString) {
    constructor(rotorName: RotorName, startPosition: Int = 0, notch: Int = 5) : this(rotorName.permutation, startPosition, notch)

    val permutationString = permutationString

    var notch: Int = notch

    var position: Int = startPosition

    override fun permute(letter: Char): Char {
        return super.permute(ALPHABET[Math.floorMod(ALPHABET.indexOf(letter)+position, ALPHABET.length)])
    }

    fun reversePermute(letter: Char): Char {
        return ALPHABET[Math.floorMod(ALPHABET.indexOf(ALPHABET[permutationString.indexOf(letter)]) - position, ALPHABET.length)]
    }

    fun rotate() {
        position = (position + 1) % ALPHABET.length
    }

    fun shouldRotateNext(): Boolean {
        return notch==position
    }

}