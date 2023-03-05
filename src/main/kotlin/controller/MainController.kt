package controller

import entity.ResultCode
import entity.Result
import exception.AppException

class MainController {
    fun doAction(actionName: String, parameters: Array<String>) : Result {
        val action = ActionContainer.getAction(actionName)

        try{
            return action.execute(parameters)
        }
        catch (e: AppException){
            return Result(ResultCode.ERROR, e.getMessaage())
        }
    }
}