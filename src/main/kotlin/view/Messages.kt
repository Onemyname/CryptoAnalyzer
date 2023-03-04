package view

import commands.Action

var QUESTIONS = arrayOf(
    arrayOf(
        arrayOf(Action.ENCODE),
        arrayOf("Enter source (full path OR only filename OR Enter for hobbit.txt) :", "hobbit.txt"),
        arrayOf("Enter destination (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"),
        arrayOf("Enter key (int number OR Enter for key = 1) :", "1")
    ),
    arrayOf(
        arrayOf(Action.DECODE),
        arrayOf("Enter source (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"),
        arrayOf("Enter destination (full path OR only filename OR Enter for decrypted.txt) :", "decrypted.txt"),
        arrayOf("Enter key (int number OR Enter for key = 1) :", "1")
    ),
    arrayOf(
        arrayOf(Action.BRUTEFORCE),
        arrayOf("Enter source (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"),
        arrayOf("Enter destination (full path OR only filename OR Enter for bruteforce.txt) :", "bruteforce.txt"),
        arrayOf("Enter vocabulary (full path OR only filename OR Enter for vocabulary.txt) :", "vocabulary.txt")
    ),
    arrayOf(
        arrayOf(Action.ANALYZE),
        arrayOf("Enter source (full path OR only filename OR Enter for encrypted.txt) :", "encrypted.txt"),
        arrayOf("Enter work by the same author  (full path OR only filename OR Enter for dictionary.txt) :", "lordrings.txt"),
        arrayOf("Enter destination (full path OR only filename OR Enter for analyzed.txt) :", "analyzed.txt")
    ),
    arrayOf(arrayOf(Action.EXIT))
)



val INCORRECT_SELECTION_MODE: String
    get() = "Incorrect selection!"

val LINE: String
    get() = "-".repeat(20)
val ANSI_RESET: String
    get() = "\u001B[0m"
val ANSI_BLUE: String
    get() = "\u001B[34m"
val ANSI_CYAN: String
    get() = "\u001B[36m"
val ANSI_PURPLE: String
    get() = "\u001B[35m"
val ANSI_GREEN: String
    get() = "\u001B[32m"

val OK_FORMAT: String
    get() = ANSI_GREEN + """
                Operation complete
                Result: %s
                """ + ANSI_RESET

val ERROR_FORMAT: String
    get() = ANSI_PURPLE + """
                Operation not completed. Error.
                Message: %s
                """ + ANSI_RESET


val MESSAGE_SELECT_MODE: String
    get() = LINE +
            ANSI_BLUE + "\nPlease select mode:\n" + ANSI_CYAN + """
                1. Encrypt
                2. Decrypt
                3. Brute force
                4. Analyze
                5. Exit
                """ + ANSI_RESET + LINE