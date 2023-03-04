package exception

class AppException : RuntimeException {
    private val reason: String
    constructor(reason: String){
       this.reason = reason
    }

    constructor(reason: String,  cause: Throwable){
        this.reason = reason
        // TODO:     super(cause)
    }


    fun getReason(): String{
        return  this.reason
    }
}