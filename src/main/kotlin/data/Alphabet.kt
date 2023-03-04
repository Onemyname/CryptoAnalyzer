package data

import java.util.*
import java.util.stream.Stream
import kotlin.streams.toList

var ENGLISH_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
var ALL_ALPHABET = ENGLISH_LETTERS.lowercase(Locale.getDefault())
var CRYPT_ALPHABET_ARRAY = ALL_ALPHABET.toCharArray()
var alphabetList = ENGLISH_LETTERS.lowercase(Locale.getDefault()).chars().mapToObj { c: Int -> c.toChar() }

fun getAlphabetList(): List<Char> {
    return alphabetList.toList()
}
fun getAlphabet(): CharArray {
    return CRYPT_ALPHABET_ARRAY
}
fun getAlphabetLength(): Int {
    return CRYPT_ALPHABET_ARRAY.size
}