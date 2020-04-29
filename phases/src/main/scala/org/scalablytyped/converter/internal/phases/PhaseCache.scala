package org.scalablytyped.converter.internal.phases

import java.nio.channels.{ClosedByInterruptException, FileLockInterruptionException}
import java.util

import org.scalablytyped.converter.internal.phases.PhaseCache.Ref

import scala.concurrent.{ExecutionException, Future, Promise}
import scala.util.control.NonFatal

class PhaseCache[Id, U](initialCapacity: Int = 1000) {
  private val m: util.Map[Ref[(Id, IsCircular)], Ref[Future[PhaseRes[Id, U]]]] =
    new util.HashMap(initialCapacity)

  def getOrElse(key: (Id, IsCircular))(compute: Promise[PhaseRes[Id, U]] => Unit): Future[PhaseRes[Id, U]] = {
    val keyRef = new Ref(key)
    var op: Option[Promise[PhaseRes[Id, U]]] = None

    val ret = synchronized {
      val existingFuture: Option[Future[PhaseRes[Id, U]]] =
        m.get(keyRef) match {
          case null => None
          case uRef =>
            uRef.get match {
              case null => None
              case u    => Some(u)
            }
        }

      existingFuture match {
        case None =>
          val p      = Promise[PhaseRes[Id, U]]()
          val future = p.future
          m.put(keyRef, new Ref(future))
          op = Some(p)
          future
        case Some(found) => found
      }
    }

    op.foreach { p =>
      try compute(p)
      catch {
        case x: FileLockInterruptionException            => throw x
        case x: InterruptedException                     => throw x
        case x: ClosedByInterruptException               => throw x
        case x: ExecutionException if x.getCause != null => p.failure(x.getCause)
        case NonFatal(th) => p.failure(th)
      }
    }

    ret
  }
}

object PhaseCache {
  private final class Ref[T](t: T) extends java.lang.ref.SoftReference[T](t) {
    override def equals(obj: Any): Boolean =
      obj match {
        case that: Ref[_] => that.get == get
        case _ => false
      }

    override def hashCode: Int = get.##
  }
}
