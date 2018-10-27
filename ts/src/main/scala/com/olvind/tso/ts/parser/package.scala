package com.olvind.tso
package ts

package object parser {
  def parseFile(inFile: InFile): Either[String, TsParsedFile] = {
    val content   = files content inFile
    val rewritten = Patches(inFile, content)

    TsParser(rewritten) match {
      case TsParser.Success(t, _) =>
        Right(t)

      case TsParser.NoSuccess(msg, next) =>
        val errorMsg = s"$inFile: Parse error at ${next.pos} $msg"
        Left(errorMsg)
    }
  }
}
