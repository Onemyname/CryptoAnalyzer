package commands

import data.Constants
import entity.Result
import entity.ResultCode

class EXIT : Action {
    override fun execute(parameters: Array<String>): Result {
        return Result(ResultCode.OK, Constants.APPLICATION_CLOSED.name)
    }
}