package com.olvind

import java.io.Writer

import com.olvind.logging.Logger.{AppendableLogger, Stored, StoringLogger, WriterLogger}
import fansi.Str

package object logging {
  type Ctx = Map[Str, Str]

  private[logging] val emptyContext: Ctx = Map.empty

  def stdout: Logger[Unit] =
    appendable(System.out).void

  def appendable[A <: Appendable](appendable: A,
                                  pattern:    Pattern = Pattern.default,
                                  ctx:        Ctx = emptyContext): Logger[A] =
    new AppendableLogger(appendable, pattern, ctx)

  def writer[W <: Writer](writer:  W = System.out,
                          pattern: Pattern = Pattern.default,
                          ctx:     Ctx = emptyContext): Logger[W] =
    new WriterLogger(new AppendableLogger(writer, pattern, ctx))

  def storing(ctx: Ctx = emptyContext): Logger[Array[Stored]] =
    new StoringLogger(new Logger.Store, ctx)
}
