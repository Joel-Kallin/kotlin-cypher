package enigma.components.rotors

class Rotors(rotorMap: Map<Int, Rotor>, reflector: Reflector) {
    private val rotors = mutableListOf<Rotor>()
    private val reflector = reflector

    init {
        rotorMap.keys.sorted().forEach { key -> rotors.add(rotorMap[key]!!) }
    }

    fun permute(letter: Char): Char {
        rotate()
        val forwardPass = rotors.fold(letter) { acc, permutor -> permutor.permute(acc) }
        val reflect = reflector.permute(forwardPass)
        return rotors.reversed().fold(reflect) { acc, permutor -> permutor.reversePermute(acc) }
    }

    private fun rotate() {
        val rotorIterator = rotors.toSet().filterIsInstance<Rotor>()

        for (rotor in rotorIterator) {
            val shouldRotateNext = rotor.shouldRotateNext()
            rotor.rotate()
            if(!shouldRotateNext) {
                return
            }
        }
    }
}