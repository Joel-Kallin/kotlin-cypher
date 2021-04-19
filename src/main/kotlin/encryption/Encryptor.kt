package encryption

interface Encryptor {
    fun encrypt(plaintText: String): String
}