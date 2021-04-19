package encryption

import enigma.EnigmaFactory
import rsa.RsaFactory

class EncryptionStrategy(strategyName: String) : CypherStrategy {

    private val encryptor: Encryptor;

    init {
        when (strategyName) {
            StrategyName.RSA.strategyName -> encryptor = RsaFactory().get()
            else -> encryptor = EnigmaFactory().get()
        }
    }

    override fun cipher(text: String): String {
        return this.encryptor.encrypt(text)
    }

}