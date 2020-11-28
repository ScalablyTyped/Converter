package org.scalablytyped.converter.internal.phases

trait PhaseListener[Id] {
  def on(phaseName: String, id: Id, event: PhaseListener.Event[Id]): Unit
}

object PhaseListener {
  def NoListener[Id]: PhaseListener[Id] = (_, _, _) => ()

  sealed trait Event[Id]
  case class Started[Id](phase: String) extends Event[Id]
  case class Blocked[Id](phase: String, on: Set[Id]) extends Event[Id]
  case class Success[Id](phase: String) extends Event[Id]
  case class Failure[Id](phase: String, errors: Map[Id, Either[Throwable, String]]) extends Event[Id]
  case class Ignored[Id]() extends Event[Id]
}
