package typings.unionToInheritance

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object unionToInheritanceStrings {
  
  @js.native
  sealed trait a1
    extends StObject
       with _A
  @scala.inline
  def a1: a1 = "a1".asInstanceOf[a1]
  
  @js.native
  sealed trait a2
    extends StObject
       with _A
  @scala.inline
  def a2: a2 = "a2".asInstanceOf[a2]
  
  @js.native
  sealed trait b1
    extends StObject
       with _B
  @scala.inline
  def b1: b1 = "b1".asInstanceOf[b1]
  
  @js.native
  sealed trait b2
    extends StObject
       with _B
  @scala.inline
  def b2: b2 = "b2".asInstanceOf[b2]
  
  @js.native
  sealed trait bar
    extends StObject
       with Legal1[js.Any]
       with Legal2[js.Any, js.Any]
       with Legal3[js.Any, js.Any, js.Any]
       with _Illegal1
       with _Illegal2
       with _Illegal3[js.Any]
       with _Test[js.Any, js.Any, js.Any]
  @scala.inline
  def bar: bar = "bar".asInstanceOf[bar]
  
  @js.native
  sealed trait foo
    extends StObject
       with Legal1[js.Any]
       with Legal2[js.Any, js.Any]
       with Legal3[js.Any, js.Any, js.Any]
       with _Illegal1
       with _Illegal2
       with _Illegal3[js.Any]
       with _Test[js.Any, js.Any, js.Any]
  @scala.inline
  def foo: foo = "foo".asInstanceOf[foo]
}
