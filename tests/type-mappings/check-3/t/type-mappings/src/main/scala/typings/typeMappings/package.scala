package typings.typeMappings

import _root_.typings.std.Exclude
import _root_.typings.std.InstanceType
import _root_.typings.std.NonNullable
import _root_.typings.std.Partial
import _root_.typings.std.Pick
import _root_.typings.std.ReturnType
import _root_.typings.typeMappings.anon.Age
import _root_.typings.typeMappings.anon.Name
import _root_.typings.typeMappings.typeMappingsStrings.age
import _root_.typings.typeMappings.typeMappingsStrings.name
import org.scalablytyped.runtime.Instantiable0
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}


type Double[T] = Partial[Partial[T]]

type IPersonRecord = PersonRecord

type Mark = TextMark | TrailMark

type NewedPerson = InstanceType[Instantiable0[Person]]

type NonNullablePerson = NonNullable[Person]

/** NOTE: Conditional type definitions are impossible to translate to Scala.
  * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
  * This RHS of the type alias is guess work. You should cast if it's not correct in your case.
  * TS definition: {{{
  T extends any ? std.Pick<T, std.Exclude<keyof T, K>> : never
  }}}
  */
type Omit[T, K /* <: /* keyof any */ String */] = Pick[T, Exclude[/* keyof T */ String, K]]

type ReturnedPerson = ReturnType[js.Function0[Person]]

type T = Pick[Name | Age, name & age]
