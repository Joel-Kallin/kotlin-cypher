package encryption.model

interface CypherStrategy {
    fun cipher(text: String): String

}