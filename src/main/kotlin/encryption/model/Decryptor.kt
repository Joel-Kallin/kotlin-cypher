package encryption.model

interface Decryptor {
    fun decrypt(cipherText: String): String
}