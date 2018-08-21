package com.olvind.tso.phases
import fansi.Str

trait PhaseListener[Id] {
  def on(phaseName: String, id: Id, event: PhaseListener.Event): Unit
}

object PhaseListener {
  sealed trait Event
  case class Started(phase: String) extends Event
  case class Blocked(phase: String, on: Set[Str]) extends Event
  case class Success(phase: String) extends Event
  case class Failure(phase: String) extends Event
  case object Ignored extends Event
}
