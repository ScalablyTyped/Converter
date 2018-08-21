package com.olvind.tso

object FirstNonEmpty {
  def ofLists[T, U](ts: List[T])(f: T => Seq[U]): Option[Seq[U]] = {
    var idx = 0
    while (idx < ts.length) {
      val t   = ts(idx)
      val res = f(t)
      if (res.nonEmpty) {
        return Some(res)
      }
      idx += 1
    }
    None
  }

  def apply[T, C[t] <: Traversable[t]](providers: (() => C[T])*): Option[C[T]] = {
    var idx = 0
    while (idx < providers.length) {
      val res = providers(idx)()
      if (res.nonEmpty) {
        return Some(res)
      }
      idx += 1
    }
    None
  }
}
