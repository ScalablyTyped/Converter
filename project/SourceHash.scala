import java.io.File
import java.nio.file.{Files, Path}
import java.util.Arrays

import scala.io.Codec

object SourceHash {
  def apply(directory: File): Int =
    directory.list match {
      case null => throw new RuntimeException(s"Expected source files under $directory")
      case files =>
        Arrays.hashCode(
          files.map(file => stripWhitespace(readPath(new File(directory, file).toPath)).hashCode)
        )
    }

  private def readPath(path: Path) =
    new String(Files readAllBytes path, Codec.UTF8.charSet)

  private def stripWhitespace(contents: String) =
    contents.replaceAll("\\s", "")
}
