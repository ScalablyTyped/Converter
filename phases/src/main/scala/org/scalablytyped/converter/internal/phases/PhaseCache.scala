package org.scalablytyped.converter.internal.phases

import java.util

import org.scalablytyped.converter.internal.phases.PhaseCache.Ref

class PhaseCache[Id, U](initialCapacity: Int = 1000) {
  private val m: util.Map[Ref[(Id, IsCircular)], Ref[PhaseRes[Id, U]]] =
    new util.HashMap(initialCapacity)

  def getOrElse(key: (Id, IsCircular))(compute: () => PhaseRes[Id, U]): PhaseRes[Id, U] = {
    val keyRef = new Ref(key)

    val existing: Option[PhaseRes[Id, U]] =
      m.get(keyRef) match {
        case null => None
        case uRef =>
          uRef.get match {
            case null => None
            case u    => Some(u)
          }
      }

    existing match {
      case None =>
        val ret = compute()
        m.put(keyRef, new Ref(ret))
        ret
      case Some(found) =>
        found
    }
  }
}

object PhaseCache {
  private final class Ref[T](t: T) extends java.lang.ref.SoftReference[T](t) {
    override def equals(obj: Any): Boolean =
      obj match {
        case that: Ref[_] => that.get == get
        case _ => false
      }

    override lazy val hashCode: Int = get.##
  }
}
