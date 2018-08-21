package com.olvind.tso
package ts

package object parser {
  def parseFile(inFile: InFile): Either[String, TsParsedFile] =
    TsParser(files content inFile) match {
      case TsParser.Success(t, _) =>
        Right(t)

      case TsParser.NoSuccess(msg, next) =>
        val errorMsg = s"$inFile: Parse error at ${next.pos} $msg"
        Left(errorMsg)
    }
}
