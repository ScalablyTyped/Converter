package org.scalablytyped.converter.internal
package ts

package object parser {
  def parseFile(inFile: InFile): Either[String, TsParsedFile] = parseFileContent(inFile, os.read.bytes(inFile.path))

  def parseFileContent(inFile: InFile, bytes: Array[Byte]): Either[String, TsParsedFile] = {
    val BOM = "\uFEFF"
    val s1  = new String(bytes, constants.Utf8)
    val s2  = if (s1.startsWith(BOM)) s1.replace(BOM, "") else s1
    val s3  = Patches(inFile, s2)
    val p   = new TsParser(Some((inFile.path, s3.length)))

    p(s3) match {
      case p.Success(t, _) =>
        Right(t)

      case p.NoSuccess(msg, next) =>
        Left(s"Parse error at ${next.pos} $msg")
    }
  }
}
