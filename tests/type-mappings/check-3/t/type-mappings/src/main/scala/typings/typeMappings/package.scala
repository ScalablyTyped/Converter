package typings.typeMappings

import org.scalablytyped.runtime.Instantiable0
import org.scalablytyped.runtime.TopLevel
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

type Omit[T, K /* <: /* keyof any */ String */] = Pick[T, Exclude[/* keyof T */ String, K]]

type Proxify[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
{[ P in keyof T ]: {get (): T[P], set (v : T[P]): void}}
  */ typings.typeMappings.typeMappingsStrings.Proxify & TopLevel[Any]

type ReturnedPerson = ReturnType[js.Function0[Person]]

type T = Pick[Name | Age, name & age]
