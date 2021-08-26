package typings.unionToInheritance

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}


type A = "a1" | "a2" | java.lang.String

type B = "b1" | "b2" | scala.Double | typings.unionToInheritance.A

type C = 1 | 2 | typings.std.HTMLInputElement | js.Array[typings.unionToInheritance.B] | typings.unionToInheritance.B

type Illegal1 = "foo" | "bar" | typings.unionToInheritance.Foo[java.lang.String]

type Illegal2 = "foo" | "bar" | typings.unionToInheritance.Foo[typings.unionToInheritance.A]

type Illegal3[T] = "foo" | "bar" | (typings.unionToInheritance.Foo2[T, T])

type Legal1[T] = "foo" | "bar" | typings.unionToInheritance.Foo[T]

type Legal2[P, T] = "foo" | "bar" | typings.unionToInheritance.Foo[P] | (typings.unionToInheritance.Foo2[T, P])

type Legal3[T1, T2, T3] = "foo" | "bar" | typings.unionToInheritance.Foo[T3] | (typings.unionToInheritance.Either[T2, T3]) | (typings.unionToInheritance.Foo2[T1, T3])

type Test[T1, T2, T3] = "foo" | "bar" | (typings.std.TwoFoo[T3, T1]) | (typings.unionToInheritance.Either[T2, T3]) | (typings.unionToInheritance.Foo2[T1, T3])

type Test2[O1, O2] = (typings.unionToInheritance.Test[O1, O1, O2]) | (typings.unionToInheritance.Either[O2, O1]) | typings.unionToInheritance.Legal1[O2]
