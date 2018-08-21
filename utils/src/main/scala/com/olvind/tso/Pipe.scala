package com.olvind.tso

class Pipe[T, U] private (val run: T => U) extends AnyVal {
  def >>[V](f: U => V): Pipe[T, V] = new Pipe(run andThen f)
}

object Pipe {
  def apply[T]: Pipe[T, T] = new Pipe(identity)
}
