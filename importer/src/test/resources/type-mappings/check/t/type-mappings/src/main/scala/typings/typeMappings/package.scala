package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object typeMappings {
  type Excluded = typings.typeMappings.Omit[typings.typeMappings.CSSProperties, typings.typeMappings.typeMappingsStrings.color]
  type IPersonRecord = typings.typeMappings.PersonRecord
  type IProxiedPerson = typings.typeMappings.Proxify[typings.typeMappings.Person]
  type NamePerson = typings.std.Pick[typings.typeMappings.Person, typings.typeMappings.typeMappingsStrings.name]
  type NewedPerson = typings.std.InstanceType[org.scalablytyped.runtime.Instantiable0[typings.typeMappings.Person]]
  type NonNullablePerson = typings.std.NonNullable[typings.typeMappings.Person]
  type Omit[T, K /* <: java.lang.String */] = typings.std.Pick[T, typings.std.Exclude[java.lang.String, K]]
  type PartialPerson = typings.std.Partial[typings.typeMappings.Person]
  type PersonRecord = typings.std.Record[
    typings.typeMappings.typeMappingsStrings.name | typings.typeMappings.typeMappingsStrings.age, 
    java.lang.String
  ]
  type ProxiedPerson = typings.typeMappings.Proxify[typings.typeMappings.Person]
  type Proxify[T] = /* import warning: importer.ImportType#apply c Unsupported type mapping: 
  {[ P in keyof T ]: {get (): T[P], set (v : T[P]): void}}
    */ typings.typeMappings.typeMappingsStrings.Proxify with js.Any
  type ReadonlyPerson = typings.typeMappings.Person
  type RequiredPerson = typings.std.Required[typings.typeMappings.Person]
  type ReturnedPerson = typings.std.ReturnType[js.Function0[typings.typeMappings.Person]]
  type T = typings.std.Pick[
    typings.typeMappings.AnonName | typings.typeMappings.AnonAge, 
    typings.typeMappings.typeMappingsStrings.name with typings.typeMappings.typeMappingsStrings.age
  ]
  type TypographyStyle = (typings.std.Required[
    typings.std.Pick[
      typings.typeMappings.CSSProperties, 
      typings.typeMappings.typeMappingsStrings.fontFamily | typings.typeMappings.typeMappingsStrings.fontSize | typings.typeMappings.typeMappingsStrings.fontWeight | typings.typeMappings.typeMappingsStrings.color
    ]
  ]) with (typings.std.Partial[
    typings.std.Pick[
      typings.typeMappings.CSSProperties, 
      typings.typeMappings.typeMappingsStrings.letterSpacing | typings.typeMappings.typeMappingsStrings.lineHeight | typings.typeMappings.typeMappingsStrings.textTransform
    ]
  ])
  type TypographyStyleOptions = /* InlineNestedIdentityAlias: typings.std.Partial*/ typings.typeMappings.TypographyStyle
  type U = typings.std.Pick[
    typings.typeMappings.AnonAgeName, 
    typings.typeMappings.typeMappingsStrings.name | typings.typeMappings.typeMappingsStrings.age
  ]
  type V = typings.std.Pick[typings.typeMappings.AnonAgeName, typings.typeMappings.typeMappingsStrings.age]
}
