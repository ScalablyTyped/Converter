package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object typeMappings {
  type IPersonRecord = typings.typeMappings.PersonRecord
  type NewedPerson = typings.std.InstanceType[org.scalablytyped.runtime.Instantiable0[typings.typeMappings.Person]]
  type NonNullablePerson = typings.std.NonNullable[typings.typeMappings.Person]
  type Omit[T, K /* <: java.lang.String */] = typings.std.Pick[T, typings.std.Exclude[java.lang.String, K]]
  type Proxify[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in keyof T ]: {get (): T[P], set (v : T[P]): void}}
    */ typings.typeMappings.typeMappingsStrings.Proxify with js.Any
  type ReturnedPerson = typings.std.ReturnType[js.Function0[typings.typeMappings.Person]]
  type T = typings.std.Pick[
    typings.typeMappings.AnonName | typings.typeMappings.AnonAge, 
    typings.typeMappings.typeMappingsStrings.name with typings.typeMappings.typeMappingsStrings.age
  ]
}
