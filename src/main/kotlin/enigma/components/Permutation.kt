package enigma.components

open class Permutation(
    permutationString: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
) {
    val permutation: Map<Int, Int>

    val ALPHABET: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    init {
        permutation = permutationString.toList().associate { permutationString.indexOf(it) to ALPHABET.indexOf(it) }
    }

    open fun permute(letter: Char) :Char {
        if(letter == Character.MIN_VALUE) {
            throw IllegalArgumentException()
        }

        val letterIndexInAlphabet = ALPHABET.indexOf(letter)
        // If no permutation is defined it is the identity
        val indexOfPermutation = permutation[letterIndexInAlphabet] ?: letterIndexInAlphabet
        return ALPHABET[indexOfPermutation]
    }
}