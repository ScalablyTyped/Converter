package com.olvind.tso
package ts

package object parser {
  def parseFile(inFile: InFile): Either[String, TsParsedFile] = {
    val content   = files content inFile
    val rewritten = Patches(inFile, content)
    val p         = new TsParser(Some((inFile.path, rewritten.length)))

    p(rewritten) match {
      case p.Success(t, _) =>
        Right(t)

      case p.NoSuccess(msg, next) =>
        val errorMsg = s"$inFile: Parse error at ${next.pos} $msg"
        Left(errorMsg)
    }
  }
}
