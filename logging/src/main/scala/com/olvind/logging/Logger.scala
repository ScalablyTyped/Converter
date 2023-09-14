package com.olvind.logging

import java.io.Writer
import java.time.Instant

import fansi.Str
import sourcecode.{Enclosing, File, Line, Text}

trait Logger[U] { self =>
  def underlying: U

  def withContext[T: Formatter](key: String, value: T): Logger[U]

  final def withContext[T: Formatter](value: Text[T]): Logger[U] =
    self.withContext(value.source, value.value)

  def log[T: Formatter](text: => Text[T], throwable: Option[Throwable], metadata: Metadata): Unit
}

object Logger {
  case class Stored(message: Str, throwable: Option[Throwable], metadata: Metadata, ctx: Ctx)

  private[logging] class Store() {
    private var reversed: List[Stored] = Nil

    def store(s: Stored): Unit =
      reversed = s :: reversed

    def normal: Array[Stored] =
      reversed.to(Array).reverse
  }

  private[logging] final class StoringLogger(store: Store, val ctx: Ctx) extends Logger[Array[Stored]] {
    override def log[T: Formatter](t: => Text[T], throwable: Option[Throwable], metadata: Metadata): Unit =
      store.store(Stored(Formatter(t.value), throwable, metadata, ctx))

    override def withContext[T: Formatter](key: String, value: T): StoringLogger =
      new StoringLogger(store, ctx + (Str(key) -> Formatter(value)))

    override def underlying: Array[Stored] =
      store.normal
  }

  private[logging] final class AppendableLogger[A <: Appendable](val underlying: A, pattern: Pattern, val context: Ctx)
      extends Logger[A] {

    override def log[T: Formatter](t: => Text[T], throwable: Option[Throwable], metadata: Metadata): Unit = {
      val formatted = pattern(t, throwable, metadata, context)
      underlying.append(formatted.render + "\n")
      ()
    }

    override def withContext[T: Formatter](key: String, value: T): AppendableLogger[A] =
      new AppendableLogger(underlying, pattern, context + (Str(key) -> Formatter(value)))
  }

  private[logging] final class WriterLogger[W <: Writer](appendable: AppendableLogger[W]) extends Logger[W] {
    override def underlying: W = appendable.underlying

    override def log[T: Formatter](t: => Text[T], throwable: Option[Throwable], metadata: Metadata): Unit = {
      appendable.log(t, throwable, metadata)
      appendable.underlying.flush()
    }

    override def withContext[T: Formatter](key: String, value: T): WriterLogger[W] =
      new WriterLogger[W](appendable.withContext(key, value))

  }

  private[logging] final class Zipped[T1, T2](one: Logger[T1], two: Logger[T2]) extends Logger[(T1, T2)] {
    override def underlying: (T1, T2) =
      (one.underlying, two.underlying)

    override def log[T: Formatter](t: => Text[T], throwable: Option[Throwable], metadata: Metadata): Unit = {
      one.log(t, throwable, metadata)
      two.log(t, throwable, metadata)
    }

    override def withContext[T: Formatter](key: String, value: T): Zipped[T1, T2] =
      new Zipped(one.withContext(key, value), two.withContext(key, value))
  }

  private[logging] final class WithFilter[U](wrapped: Logger[U], minLogLevel: LogLevel) extends Logger[U] {
    override def underlying: U = wrapped.underlying

    override def log[T: Formatter](t: => Text[T], throwable: Option[Throwable], m: Metadata): Unit =
      if (m.logLevel.level >= minLogLevel.level) {
        wrapped.log(t, throwable, m)
      }

    override def withContext[T: Formatter](key: String, value: T) =
      new WithFilter(wrapped.withContext(key, value), minLogLevel)
  }

  private[logging] final class Mapped[U, UU](wrapped: Logger[U], f: U => UU) extends Logger[UU] {
    override def underlying: UU = f(wrapped.underlying)

    override def log[T: Formatter](t: => Text[T], throwable: Option[Throwable], m: Metadata): Unit =
      wrapped.log(t, throwable, m)

    override def withContext[T: Formatter](key: String, value: T) =
      new Mapped(wrapped.withContext(key, value), f)
  }

  private[logging] final class Synchronized[U](wrapped: Logger[U]) extends Logger[U] {
    override def underlying: U = wrapped.underlying

    override def log[T: Formatter](t: => Text[T], throwable: Option[Throwable], m: Metadata): Unit =
      this.synchronized(wrapped.log(t, throwable, m))

    override def withContext[T: Formatter](key: String, value: T): Synchronized[U] =
      new Synchronized(wrapped.withContext(key, value))
  }

  object DevNull extends Logger[Unit] {
    override def underlying: Unit = ()
    override def withContext[T: Formatter](key:  String, value: T): Logger[Unit] = this
    override def log[T:         Formatter](text: => Text[T], throwable: Option[Throwable], metadata: Metadata): Unit = ()
  }

  implicit final class LoggerOps[U](private val self: Logger[U]) extends AnyVal {
    def zipWith[UU](other: Logger[UU]): Logger[(U, UU)] =
      new Zipped(self, other)

    def filter(minLogLevel: LogLevel): Logger[U] =
      new WithFilter(self, minLogLevel)

    def void: Logger[Unit] =
      new Mapped[U, Unit](self, _ => ())

    def syncAccess: Logger[U] =
      new Synchronized(self)
  }

  case class LoggedException(message: Str) extends Throwable(message.plainText)

  implicit final class LoggingOps[U](private val self: Logger[U]) extends AnyVal {
    @inline def apply[T: Formatter](
        logLevel:  LogLevel,
        t:         => Text[T],
        throwable: Option[Throwable] = None,
        instant:   Instant = Instant.now,
    )(implicit l:  Line, f: File, e: Enclosing): Unit =
      self.log(t, throwable, new Metadata(instant, logLevel, l, f, e))

    @inline def trace[T: Formatter](t: => Text[T])(implicit l: Line, f: File, e: Enclosing): Unit =
      apply(LogLevel.trace, t)

    @inline def trace[T: Formatter](t: => Text[T], th: Throwable)(implicit l: Line, f: File, e: Enclosing): Unit =
      apply(LogLevel.trace, t, Some(th))

    @inline def debug[T: Formatter](t: => Text[T])(implicit l: Line, f: File, e: Enclosing): Unit =
      apply(LogLevel.debug, t)

    @inline def debug[T: Formatter](t: => Text[T], th: Throwable)(implicit l: Line, f: File, e: Enclosing): Unit =
      apply(LogLevel.debug, t, Some(th))

    @inline def info[T: Formatter](t: => Text[T])(implicit l: Line, f: File, e: Enclosing): Unit =
      apply(LogLevel.info, t)

    @inline def info[T: Formatter](t: => Text[T], th: Throwable)(implicit l: Line, f: File, e: Enclosing): Unit =
      apply(LogLevel.info, t, Some(th))

    @inline def warn[T: Formatter](t: => Text[T])(implicit l: Line, f: File, e: Enclosing): Unit =
      apply(LogLevel.warn, t)

    @inline def warn[T: Formatter](t: => Text[T], th: Throwable)(implicit l: Line, f: File, e: Enclosing): Unit =
      apply(LogLevel.warn, t, Some(th))

    @inline def error[T: Formatter](t: => Text[T])(implicit l: Line, f: File, e: Enclosing): Unit =
      apply(LogLevel.error, t)

    @inline def error[T: Formatter](t: => Text[T], th: Throwable)(implicit l: Line, f: File, e: Enclosing): Unit =
      apply(LogLevel.error, t, Some(th))

    @inline def fatal[T: Formatter](t: Text[T])(implicit l: Line, f: File, e: Enclosing): Nothing = {
      val message = Formatter(t.value)
      val th      = LoggedException(message)
      error(message, th)
      throw th
    }

    @inline def fatalMaybe[T: Formatter](t: Text[T], maybe: Boolean)(implicit l: Line, f: File, e: Enclosing): Unit =
      if (maybe) fatal(t) else warn(t)
  }
}
