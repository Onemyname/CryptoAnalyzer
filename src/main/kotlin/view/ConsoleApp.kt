package view

import controller.MainController
import entity.Result
import java.util.*

class ConsoleApp(private val mainController: MainController, private val menu: Menu) {

fun run(args: Array<String>){
    // TODO: not implemented yet
}

    private fun getResult(args: Array<String>): Result {
        val action : String = args[0]
        val parameters : Array<String> = Arrays.copyOfRange(args, 1, args.size)
        return action.let { mainController.doAction(it,parameters) }!!
    }

}