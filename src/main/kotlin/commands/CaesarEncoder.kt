package commands
import entity.Result

class CaesarEncoder : CaesarAction {
    override fun execute(parameters: Array<String>) : Result{
        val mainText = parameters[0]
        val encryptedText = parameters[1]
        val key = parameters[2].toInt()

        return applyCipherKey(mainText,encryptedText,key)
    }
}