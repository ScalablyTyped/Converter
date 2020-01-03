package org.scalablytyped.converter.internal
package importer
import java.io.File

import com.olvind.logging.Pattern.{formatThrowable, prefixFor}
import com.olvind.logging.{Ctx, Formatter, Metadata, Pattern}
import fansi.Str
import sourcecode.Text

object LogPatternLibrary extends Pattern {
  override def apply[T: Formatter](t: => Text[T], throwable: Option[Throwable], m: Metadata, ctx: Ctx): Str = {
    val prefix       = prefixFor(m.logLevel)
    val file         = Formatter(new File(m.file.value)).plainText
    val line         = Formatter(m.line.value).plainText
    val th           = throwable.fold("")(x => formatThrowable(x))
    val value        = Formatter(t.value).plainText
    val ctxFormatted = Formatter(ctx - "thread").plainText
    s"$prefix $file:$line $value $ctxFormatted $th"
  }
}
