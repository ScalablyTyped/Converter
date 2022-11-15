package org.scalablytyped.converter.internal
package ts

package object parser {
  val BOM = "\uFEFF"

  def cleanedString(s1: String): String = {
    val s2 = if (s1.startsWith(BOM)) s1.replace(BOM, "") else s1
    val s3 = s2.replace("\r\n", "\n").trim
    s3
  }

  def parseFile(inFile: InFile): Either[String, TsParsedFile] = parseFileContent(inFile, os.read.bytes(inFile.path))

  def parseFileContent(inFile: InFile, bytes: Array[Byte]): Either[String, TsParsedFile] = {
    val str = cleanedString(new String(bytes, constants.Utf8))
    val p   = new TsParser(Some((inFile.path, str.length)))

    p.phrase(p.parsedTsFile)(new TsParser.lexical.Scanner(str)) match {
      case p.Success(t, _) =>
        Right(t)

      case p.NoSuccess(msg, next) =>
        Left(s"Parse error at ${next.pos} $msg")
    }
  }
}
