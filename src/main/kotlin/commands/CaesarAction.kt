package commands

import data.Constants
import data.getAlphabet
import data.getAlphabetLength
import entity.Result
import entity.ResultCode
import exception.AppException
import util.PathBuilder
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

interface CaesarAction : Action{

fun applyCipherKey(mainText: String, resultText: String, key: Int) : Result{
    val caesarCipherMap: HashMap<Char,Char> = createCharPairs(key)
    doCaesarCiphering(mainText,resultText,caesarCipherMap)

    return Result(ResultCode.OK,resultText)
}

    private fun createCharPairs(key: Int) : HashMap<Char, Char> {
        val map : HashMap<Char, Char> = HashMap(getAlphabetLength())
        val alphabet: CharArray = getAlphabet()
        var cryptValue: Char

        for(i in 0..alphabet.size) {
            cryptValue = if(key>=0) if(i+key <= alphabet.size-1) alphabet[i+key] else alphabet[(key-(alphabet.size-i))]
            else if(i-key <0) alphabet[alphabet.size-(key-i)] else alphabet[i-key]
            map[alphabet[i]] = cryptValue
        }

     return map
    }

    private fun doCaesarCiphering(mainText: String, resultText: String, cryptMap: HashMap<Char,Char>){
        val source: Path = PathBuilder.getPath(mainText)
        val target: Path = PathBuilder.getPath(resultText)
        try {
            val reader: BufferedReader = Files.newBufferedReader(source)
            val writer: BufferedWriter = Files.newBufferedWriter((target))
            var currentLine: String? = reader.readLine().lowercase()

            while (currentLine != null) {
                val cryptoLine = cipherLine(currentLine, cryptMap)
                writer.write(cryptoLine)
                currentLine = reader.readLine()
                val lowerCaseLine: String? = currentLine?.lowercase()
                if (lowerCaseLine != null) {
                    writer.append('\n')
                }
            }
        }
        catch (e:NullPointerException){
            throw AppException(Constants.EMPTY_FILE.name+e.message,e)
        }
        catch (e: IOException){
            throw AppException(Constants.EMPTY_FILE.name + e.message, e)
            }
        }

    private fun cipherLine(line: String, cryptMap: HashMap<Char,Char>): String{
        var newSymbol: Char
        val newLine: StringBuilder = java.lang.StringBuilder()

        for(i in 0..line.length){
            val lowerCaseSymbol = Character.toLowerCase(line[i])
            val isLowerCase = line[i] == lowerCaseSymbol
            newSymbol = cryptMap.getOrDefault(lowerCaseSymbol,lowerCaseSymbol)
            newLine.append( if (isLowerCase) newSymbol else Character.toUpperCase(newSymbol))
        }

        return newLine.toString()
    }

}