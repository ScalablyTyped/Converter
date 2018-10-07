package com.olvind.logging

sealed abstract class LogLevel(val level: Int)(implicit val name: sourcecode.Name)

object LogLevel {
  case object trace extends LogLevel(1)
  case object debug extends LogLevel(2)
  case object info extends LogLevel(3)
  case object warn extends LogLevel(4)
  case object error extends LogLevel(5)

  implicit val LogLevelOrdering: Ordering[LogLevel] = (one, two) => one.level.compareTo(two.level)
}
