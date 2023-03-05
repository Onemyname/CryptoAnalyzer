package util

import org.jetbrains.annotations.NotNull
import java.io.File
import java.nio.file.Path

object PathBuilder {
    private val TXT_FOLDER: String = System.getProperty("user.dir")+ File.separator + "text" + File.separator

    fun getTXT_FOLDER() : String{
        return TXT_FOLDER
    }

    fun getPath(fileName: String) : Path {
        val path: Path = Path.of(fileName)
        return  if(path.isAbsolute) path else Path.of(getTXT_FOLDER()+fileName)

    }

}