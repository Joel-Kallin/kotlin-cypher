package encryption.model

interface Encryptor {
    fun encrypt(plaintText: String): String
}