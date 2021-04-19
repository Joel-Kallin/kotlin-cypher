import encryption.CypherStrategy
import encryption.DecryptionStrategy
import encryption.EncryptionStrategy
import java.io.File

fun main(args: Array<String>) {

    val map = args.fold(Pair(emptyMap<String, List<String>>(), "")) { (map, lastKey), elem ->
        if (elem.startsWith("-"))  Pair(map + (elem to emptyList()), elem)
        else Pair(map + (lastKey to map.getOrDefault(lastKey, emptyList()) + elem), lastKey)
    }.first

    val strategy: CypherStrategy = when {
        map.containsKey("-d") -> DecryptionStrategy(map.get("-s")?.first() ?: "enigma")
        else -> EncryptionStrategy(map.get("-s")?.first() ?: "enigma")
    }

    if((!map.containsKey("-t") && !map.containsKey("-f")) || (map["-t"].isNullOrEmpty() && map["-f"].isNullOrEmpty()) ) {
        println(helpMsg())
        return
    }

    val text = map["-t"]?.first() ?: readFileDirectlyAsText(map["-f"]!!.first())

    println(text + " -> " + strategy.cipher(text))
}

fun readFileDirectlyAsText(fileName: String): String
        = File(fileName).readText(Charsets.UTF_8)

fun helpMsg(): String {
    return "Usage: -t text or -f text.txt"
}
