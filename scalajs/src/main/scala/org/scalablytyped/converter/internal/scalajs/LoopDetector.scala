package org.scalablytyped.converter.internal
package scalajs

class LoopDetector private (val stack: List[(IArray[Name], TreeScope)]) {
  def this() = this(Nil)

  def including(wanted: IArray[Name], scope: TreeScope): Either[Unit, LoopDetector] = {
    val tuple = (wanted, scope)
    if (stack.contains(tuple)) Left(())
    else Right(new LoopDetector(tuple :: stack))
  }
}
