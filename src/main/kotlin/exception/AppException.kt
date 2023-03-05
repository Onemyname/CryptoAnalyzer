package exception

class AppException : RuntimeException {
    constructor(message: String): super(message)
    constructor(message: String, cause: Throwable): super(message, cause)

    fun getMessaage(): String{
        return this.message ?: "Unknown reason"
    }
}