package encryption

interface Decryptor {
    fun decrypt(cipherText: String): String
}