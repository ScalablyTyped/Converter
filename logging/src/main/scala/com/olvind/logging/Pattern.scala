package com.olvind.logging

import java.io.{File, PrintWriter, StringWriter}

import fansi.{Color, EscapeAttr, Str}
import sourcecode.Text

trait Pattern {
  def apply[T: Formatter](t: => Text[T], throwable: Option[Throwable], metadata: Metadata, ctx: Ctx): Str
}

object Pattern {
  def prefixFor(l: LogLevel): String =
    f"[${l.name.value}%-5s]"

  @inline def colorFor(l: LogLevel): EscapeAttr =
    l.level match {
      case LogLevel.trace.level => Color.Reset
      case LogLevel.debug.level => Color.Green
      case LogLevel.info.level  => Color.Blue
      case LogLevel.warn.level  => Color.Yellow
      case LogLevel.error.level => Color.Red
    }

  @inline def subtleColorFor(l: LogLevel): EscapeAttr =
    l.level match {
      case LogLevel.trace.level => Color.Reset
      case LogLevel.debug.level => Color.LightGreen
      case LogLevel.info.level  => Color.LightBlue
      case LogLevel.warn.level  => Color.LightYellow
      case LogLevel.error.level => Color.LightRed
    }

  def formatThrowable(th: Throwable): String = {
    val sw = new StringWriter()
    val pw = new PrintWriter(sw)
    th.printStackTrace(pw)
    sw.toString
  }

  object default extends Pattern {
    override def apply[T: Formatter](t: => Text[T], throwable: Option[Throwable], m: Metadata, ctx: Ctx): Str = {
      val Color  = colorFor(m.logLevel)
      val Subtle = subtleColorFor(m.logLevel)
      val source = if (t.source.startsWith("\"") || t.source.startsWith("s\"")) "" else t.source

      Str.join(
        Color(prefixFor(m.logLevel)),
        " ",
        Subtle(m.instant.toString),
        " ",
        Subtle(Formatter(new File(m.file.value))),
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
          case Some(th) => Subtle(formatThrowable(th))
        },
      )
    }
  }
}
