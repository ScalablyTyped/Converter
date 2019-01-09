package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object typeDashMappingsLib {
  type Excluded = Omit[CSSProperties, typeDashMappingsLib.typeDashMappingsLibStrings.color]
  type IPersonRecord = PersonRecord
  type IProxiedPerson = Proxify[Person]
  type NamePerson = stdLib.Pick[Person, typeDashMappingsLib.typeDashMappingsLibStrings.name]
  type NewedPerson = stdLib.InstanceType[org.scalablytyped.runtime.Instantiable0[Person]]
  type NonNullablePerson = stdLib.NonNullable[Person]
  type Omit[T, K /* <: java.lang.String */] = stdLib.Pick[T, stdLib.Exclude[java.lang.String, K]]
  type PartialPerson = stdLib.Partial[Person]
  type PersonRecord = stdLib.Record[
    typeDashMappingsLib.typeDashMappingsLibStrings.name | typeDashMappingsLib.typeDashMappingsLibStrings.age, 
    java.lang.String
  ]
  type ProxiedPerson = Proxify[Person]
  type Proxify[T] = /* import warning: ImportType.apply c Unsupported type mapping: 
  {[ P in keyof T ]: {get (): T[P], set (v : T[P]): void}}
    */ typeDashMappingsLib.typeDashMappingsLibStrings.Proxify with js.Any
  type ReadonlyPerson = stdLib.Readonly[Person]
  type RequiredPerson = stdLib.Required[Person]
  type ReturnedPerson = stdLib.ReturnType[js.Function0[Person]]
  type T = stdLib.Pick[
    Anon_Name | Anon_Age, 
    typeDashMappingsLib.typeDashMappingsLibStrings.name with typeDashMappingsLib.typeDashMappingsLibStrings.age
  ]
  type TypographyStyle = (stdLib.Required[
    stdLib.Pick[
      CSSProperties, 
      typeDashMappingsLib.typeDashMappingsLibStrings.fontFamily | typeDashMappingsLib.typeDashMappingsLibStrings.fontSize | typeDashMappingsLib.typeDashMappingsLibStrings.fontWeight | typeDashMappingsLib.typeDashMappingsLibStrings.color
    ]
  ]) with (stdLib.Partial[
    stdLib.Pick[
      CSSProperties, 
      typeDashMappingsLib.typeDashMappingsLibStrings.letterSpacing | typeDashMappingsLib.typeDashMappingsLibStrings.lineHeight | typeDashMappingsLib.typeDashMappingsLibStrings.textTransform
    ]
  ])
  type TypographyStyleOptions = /* InlineNestedIdentityAlias: stdLib.Partial*/ TypographyStyle
  type U = stdLib.Pick[
    Anon_AgeName, 
    typeDashMappingsLib.typeDashMappingsLibStrings.name | typeDashMappingsLib.typeDashMappingsLibStrings.age
  ]
  type V = stdLib.Pick[Anon_AgeName, typeDashMappingsLib.typeDashMappingsLibStrings.age]
}
