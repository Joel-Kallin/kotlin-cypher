package rsa

import encryption.model.Decryptor
import encryption.model.Encryptor

class Rsa: Encryptor, Decryptor {
    override fun decrypt(cipherText: String): String {
        return cipherText
    }

    override fun encrypt(plainText: String): String {
        return plainText
    }
}