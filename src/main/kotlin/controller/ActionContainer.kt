package controller

import commands.Action
import commands.*
import data.*
import exception.AppException

enum class ActionContainer(action: Action) {
    ENCODE(CaesarEncoder()),
    DECODE(CaesarDecoder()),
    BRUTEFORCE(BruteForceDecoder()),
    ANALYZE(StatAnalyzeDecoder()),
    EXIT(EXIT());

    private val ACTION: Action = action

    companion object{
        @JvmStatic fun getAction(actionName: String): Action {
            try{
                val value = ActionContainer.valueOf(actionName.uppercase())
                return value.ACTION
            }
            catch (e: IllegalArgumentException){
            val message: String = String.format(Constants.NOT_FOUND_ACTION_FORMAT.name, actionName)
                throw AppException(message,e)
            }
        }
    }
}