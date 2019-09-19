package com.olvind.tso.plugin

import com.olvind.logging._
import com.olvind.tso.importer.Source
import fansi.Str
import sbt.internal.util.ManagedLogger
import sourcecode.Text

class WrapSbtLogger(val underlying: ManagedLogger, ctx: Ctx) extends Logger[ManagedLogger] {
  override def withContext[T: Formatter](key: String, value: T): Logger[ManagedLogger] =
    new WrapSbtLogger(underlying, ctx.updated(Str(key), Formatter[T](value)))

  override def log[T: Formatter](t: => Text[T], throwable: Option[Throwable], metadata: Metadata): Unit = {
    val level = metadata.logLevel match {
      case LogLevel.trace => sbt.Level.Debug
      case LogLevel.debug => sbt.Level.Debug
      case LogLevel.info  => sbt.Level.Info
      case LogLevel.warn  => sbt.Level.Warn
      case LogLevel.error => sbt.Level.Error
    }
    underlying.log(level, WrapSbtLogger.pattern(t, throwable, metadata, ctx).render + "\n")
    ()
  }
}

object WrapSbtLogger {
  def apply(x: ManagedLogger)(source: Source) = new WrapSbtLogger(x, Map.empty)

  object pattern extends Pattern {
    override def apply[T: Formatter](t: => Text[T], throwable: Option[Throwable], m: Metadata, ctx: Ctx): Str = {
      val Color  = Pattern.colorFor(m.logLevel)
      val Subtle = Pattern.subtleColorFor(m.logLevel)
      val source = if (t.source.startsWith("\"") || t.source.startsWith("s\"")) "" else t.source

      Str.join(
        Subtle(m.instant.toString),
        " ",
        Subtle(Formatter(new sbt.File(m.file.value))),
        ":",
        Subtle(Formatter(m.line.value)),
        " ",
        Color(source),
        " ",
        Color(Formatter(t.value)),
        " ",
        Subtle(Formatter(ctx)),
        throwable match {
          case None     => ""
          case Some(th) => Subtle(Pattern.formatThrowable(th))
        },
      )
    }
  }
}
