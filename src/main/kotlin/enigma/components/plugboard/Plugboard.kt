package enigma.components.plugboard

import enigma.components.Permutation

class Plugboard(permutationString: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ") : Permutation(permutationString) {
    init {
        require(permutationString.valid(ALPHABET)) {
            "At most 10 permutations, each permutation must be a pair such that  π(π(x))==x"
        }
    }
}

private fun String.valid(ALPHABET: String): Boolean {

    if (this.length != ALPHABET.length) {
        return false
    }

    var swaps = 0

    this.forEachIndexed { i, letter ->
        if (ALPHABET[i] != letter) {
            swaps++
            // make sure that each permutation is a pair so if alpha maps to beta then beta maps to alpha for all alpha and beta
            if (this[this.indexOf(ALPHABET[i])] != ALPHABET[i]) {
                return false
            }
        }

        // Enigma only allowed at most ten character swaps on the plugboard
        if (swaps > 10) {
            return false
        }
    }

    return true
}
