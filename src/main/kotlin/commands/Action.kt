package commands

import entity.Result

interface Action {

    companion object{
        val ENCODE: String = "encode"
        val DECODE: String = "decode"
        val BRUTEFORCE: String = "bruteforce"
        val ANALYZE: String = "analyze"
        val EXIT: String = "exit"
    }

    fun execute(parameters: Array<String>): Result

}