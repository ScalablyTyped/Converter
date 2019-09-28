package typings.unionDashToDashInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`

object unionDashToDashInheritanceStrings {
  @js.native
  sealed trait a1 extends _A
  
  @js.native
  sealed trait a2 extends _A
  
  @js.native
  sealed trait b1 extends _B
  
  @js.native
  sealed trait b2 extends _B
  
  @js.native
  sealed trait bar
    extends Legal1[js.Any]
       with Legal2[js.Any, js.Any]
       with Legal3[js.Any, js.Any, js.Any]
       with _Illegal1
       with _Illegal2
       with _Illegal3[js.Any]
       with _Test[js.Any, js.Any, js.Any]
  
  @js.native
  sealed trait foo
    extends Legal1[js.Any]
       with Legal2[js.Any, js.Any]
       with Legal3[js.Any, js.Any, js.Any]
       with _Illegal1
       with _Illegal2
       with _Illegal3[js.Any]
       with _Test[js.Any, js.Any, js.Any]
  
  @inline
  def a1: a1 = "a1".asInstanceOf[a1]
  @inline
  def a2: a2 = "a2".asInstanceOf[a2]
  @inline
  def b1: b1 = "b1".asInstanceOf[b1]
  @inline
  def b2: b2 = "b2".asInstanceOf[b2]
  @inline
  def bar: bar = "bar".asInstanceOf[bar]
  @inline
  def foo: foo = "foo".asInstanceOf[foo]
}

