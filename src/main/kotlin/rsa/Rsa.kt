package rsa

import encryption.Decryptor
import encryption.Encryptor

class Rsa: Encryptor, Decryptor {
    override fun decrypt(cipherText: String): String {
        return cipherText
    }

    override fun encrypt(plainText: String): String {
        return plainText
    }
}