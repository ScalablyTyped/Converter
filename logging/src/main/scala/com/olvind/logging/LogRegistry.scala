package com.olvind.logging

import scala.collection.mutable

class LogRegistry[K, KK, U](outer: Logger[Unit], grouper: K => KK, subLogger: KK => Logger[U]) {
  val logs = mutable.Map.empty[KK, Logger[U]]

  def get(key: K): Logger[Unit] =
    synchronized {
      val kk = grouper(key)
      val l = logs.get(kk) match {
        case None =>
          val forLib = subLogger(kk)
          logs(kk) = forLib
          forLib
        case Some(found) => found
      }

      outer.zipWith(l).void
    }
}
