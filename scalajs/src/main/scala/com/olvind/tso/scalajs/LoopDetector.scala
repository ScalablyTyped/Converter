package com.olvind.tso.scalajs

class LoopDetector private (val stack: List[(List[Name], String)]) {
  def this() = this(Nil)

  def including(wanted: List[Name], scope: TreeScope): Either[Unit, LoopDetector] = {
    val tuple = (wanted, scope.toString)
    if (stack.contains(tuple)) Left(())
    else Right(new LoopDetector(tuple :: stack))
  }
}
