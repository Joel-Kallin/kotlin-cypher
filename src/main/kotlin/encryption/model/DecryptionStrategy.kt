package encryption.model

import enigma.EnigmaFactory
import rsa.RsaFactory

class DecryptionStrategy(strategyName: String) : CypherStrategy {

    private val decryptor: Decryptor

    init {
        when (strategyName) {
            StrategyName.RSA.strategyName -> decryptor = RsaFactory().get()
            else -> decryptor = EnigmaFactory().get()
        }
    }

    override fun cipher(text: String): String {
        return decryptor.decrypt(text)
    }
}