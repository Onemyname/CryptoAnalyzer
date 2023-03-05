package view

import java.util.*

class Menu(private val scanner: Scanner) {

    fun getArgs(): Array<String> {
        val modeId : Int = getMode(scanner)
        val mode : Array<Array<String>> = QUESTIONS[modeId]
        val nullArgs: Array<String?> = arrayOfNulls(mode.size)
        val args: Array<String> =nullArgs.map { it-> ""}.toTypedArray()

        val actionType = mode[0][0]
        args[0] = actionType

        for (i in 1 until args.size) {
            val question = mode[i][0]
            val defaultAnswer = mode[i][1]
            println(question)
            val userAnswer: String = scanner.nextLine()
            val isEmptyAnswer : Boolean = (userAnswer == "")
            args[i] = if (isEmptyAnswer) defaultAnswer else userAnswer
        }

        return args
    }

    private fun getMode(scanner: Scanner) : Int{
        var mode: Int

        do{
            println(MESSAGE_SELECT_MODE)
            val input: String? = scanner.nextLine()
            mode = when(input){
                "1" -> 0;
                "2" -> 1;
                "3" -> 2;
                "4" -> 3;
                "5" -> 4;
                else -> {
                    println(INCORRECT_SELECTION_MODE)
                    -1
                }
            }
        }
            while(mode<0)
        return mode
    }

}