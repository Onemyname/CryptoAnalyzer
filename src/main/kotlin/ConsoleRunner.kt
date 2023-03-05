import controller.MainController
import view.ConsoleApp
import view.Menu
import java.util.Scanner

fun main(args: Array<String>) {

    val input = Scanner(System.`in`)
    val menu = Menu(input)
    val mainController = MainController()
    val consoleApp = ConsoleApp(mainController, menu)
    consoleApp.run(args)
}

