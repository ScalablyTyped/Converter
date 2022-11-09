package typings.typeMappings

import org.scalablytyped.runtime.Instantiable0
import typings.std.Exclude
import typings.std.InstanceType
import typings.std.NonNullable
import typings.std.Partial
import typings.std.Pick
import typings.std.ReturnType
import typings.typeMappings.anon.Age
import typings.typeMappings.anon.Name
import typings.typeMappings.typeMappingsStrings.age
import typings.typeMappings.typeMappingsStrings.name
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}


type Double[T] = Partial[Partial[T]]

type IPersonRecord = PersonRecord

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
