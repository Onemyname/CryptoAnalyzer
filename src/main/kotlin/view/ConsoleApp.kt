package view

import controller.MainController
import entity.Result
import entity.ResultCode
import java.util.*

@Suppress("NAME_SHADOWING")
class ConsoleApp(private val mainController: MainController, private val menu: Menu) {

fun run(args: Array<String>){
    var result: Result
    var args = args

    do{
        if(args.isEmpty()){
            args = menu.getArgs()
        }
        result =getResult(args)
        print(result)
    }
        while(result.RESULT_CODE == ResultCode.ERROR)

}

    private fun getResult(args: Array<String>): Result {
        val action : String = args[0]
        val parameters : Array<String> = args.copyOfRange(1, args.size)

        return action.let { mainController.doAction(it,parameters) }
    }

}