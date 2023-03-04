package view

import java.util.*

class Menu(private val scanner: Scanner) {

    fun getArgs(): Array<String?> {
        val mode = getMode(scanner)
        val args = arrayOfNulls<String>(QUESTIONS[mode].size)
        args[0] = QUESTIONS[mode][0][0]
        for (i in 1 until args.size) {
            val quest = QUESTIONS[mode][i][0]
            println(quest)
            val answer: String = scanner.nextLine()
            args[i] = if ("" == answer.trim { it <= ' ' }) QUESTIONS[mode][i][1] else answer
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