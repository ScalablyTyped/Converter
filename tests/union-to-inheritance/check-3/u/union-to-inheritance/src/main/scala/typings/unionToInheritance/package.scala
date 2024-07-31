package typings.unionToInheritance

import _root_.typings.std.HTMLInputElement
import _root_.typings.std.TwoFoo
import _root_.typings.unionToInheritance.unionToInheritanceInts.`1`
import _root_.typings.unionToInheritance.unionToInheritanceInts.`2`
import _root_.typings.unionToInheritance.unionToInheritanceStrings.a1
import _root_.typings.unionToInheritance.unionToInheritanceStrings.a2
import _root_.typings.unionToInheritance.unionToInheritanceStrings.b1
import _root_.typings.unionToInheritance.unionToInheritanceStrings.b2
import _root_.typings.unionToInheritance.unionToInheritanceStrings.bar
import _root_.typings.unionToInheritance.unionToInheritanceStrings.foo
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}


type A = a1 | a2 | String

type B = b1 | b2 | Double | A

type C = `1` | `2` | HTMLInputElement | js.Array[B] | B

type Illegal1 = foo | bar | Foo[String]

type Illegal2 = foo | bar | Foo[A]

type Illegal3[T] = foo | bar | (Foo2[T, T])

type Legal1[T] = foo | bar | Foo[T]

type Legal2[P, T] = foo | bar | Foo[P] | (Foo2[T, P])

type Legal3[T1, T2, T3] = foo | bar | Foo[T3] | (Either[T2, T3]) | (Foo2[T1, T3])

type Test[T1, T2, T3] = foo | bar | (TwoFoo[T3, T1]) | (Either[T2, T3]) | (Foo2[T1, T3])

type Test2[O1, O2] = (Test[O1, O1, O2]) | (Either[O2, O1]) | Legal1[O2]
