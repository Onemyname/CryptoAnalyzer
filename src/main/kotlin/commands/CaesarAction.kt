package commands

import entity.Result
import entity.ResultCode

interface CaesarAction : Action{

fun applyCipherKey(mainText: String, resultText: String, key: Int) : Result{
    TODO("Not yet implemented")
}
}