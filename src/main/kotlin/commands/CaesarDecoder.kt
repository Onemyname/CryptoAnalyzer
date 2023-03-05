package commands
import entity.Result


class CaesarDecoder:  CaesarAction {
    override fun execute(parameters: Array<String>): Result {
        val encryptedText : String = parameters[0]
        val decryptedText : String = parameters[1]
        val key: Int = parameters[2].toInt()
        val invertedKey = key * (-1)

        return applyCipherKey(encryptedText,decryptedText,invertedKey)
    }
}


