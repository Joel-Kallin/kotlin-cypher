package enigma.components.rotors

import enigma.components.Permutation
import enigma.components.rotors.enums.ReflectorName

class Reflector(permutationString: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ") : Permutation(permutationString) {
    constructor(reflectorName: ReflectorName) : this(reflectorName.permutation)
}