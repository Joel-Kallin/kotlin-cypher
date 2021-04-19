package encryption

interface CypherStrategy {
    fun cipher(text: String): String

}