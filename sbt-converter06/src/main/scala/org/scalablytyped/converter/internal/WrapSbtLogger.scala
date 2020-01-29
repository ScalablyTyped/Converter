package org.scalablytyped.converter
package internal

import java.time.Instant

import com.olvind.logging._
import fansi.{Color, EscapeAttr, Str}
import sbt.internal.util.ManagedLogger
import sourcecode.Text

class WrapSbtLogger(val underlying: ManagedLogger, ctx: Ctx, pattern: Pattern) extends Logger[ManagedLogger] {
  override def withContext[T: Formatter](key: String, value: T): Logger[ManagedLogger] =
    new WrapSbtLogger(underlying, ctx.updated(Str(key), Formatter[T](value)), pattern)

  override def log[T: Formatter](t: => Text[T], throwable: Option[Throwable], metadata: Metadata): Unit = {
    val level = metadata.logLevel match {
      case LogLevel.trace => sbt.Level.Debug
      case LogLevel.debug => sbt.Level.Debug
      case LogLevel.info  => sbt.Level.Info
      case LogLevel.warn  => sbt.Level.Warn
      case LogLevel.error => sbt.Level.Error
    }
    underlying.log(level, pattern(t, throwable, metadata, ctx).render + "\n")
    ()
  }
}

object WrapSbtLogger {
  def apply(x: ManagedLogger, started: Instant) = new WrapSbtLogger(x, Map.empty, new WrapPattern(started))

  class WrapPattern(started: Instant) extends Pattern {
    @inline def colorFor(l: LogLevel): EscapeAttr =
      l.level match {
        case LogLevel.trace.level => Color.Reset
        case LogLevel.debug.level => Color.LightGreen
        case LogLevel.info.level  => Color.LightYellow
        case LogLevel.warn.level  => Color.LightBlue
        case LogLevel.error.level => Color.LightRed
      }

    @inline def subtleColorFor(l: LogLevel): EscapeAttr =
      l.level match {
        case LogLevel.trace.level => Color.Reset
        case LogLevel.debug.level => Color.Green
        case LogLevel.info.level  => Color.Yellow
        case LogLevel.warn.level  => Color.Blue
        case LogLevel.error.level => Color.Red
      }

    override def apply[T: Formatter](t: => Text[T], throwable: Option[Throwable], m: Metadata, ctx: Ctx): Str = {
      val color  = colorFor(m.logLevel)
      val subtle = subtleColorFor(m.logLevel)

      Str.join(
        subtle(Str.join(Formatter(new sbt.File(m.file.value)), ":", Formatter(m.line.value))),
        " ",
        color(Formatter(t.value)),
        " ",
        subtle(Formatter(ctx.updated("ms", Formatter(java.time.Duration.between(started, m.instant).toMillis)))),
        throwable match {
          case None     => ""
          case Some(th) => subtle(Pattern.formatThrowable(th))
        },
      )
    }
  }
}
