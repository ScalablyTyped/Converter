package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object typeDashMappings {
  import org.scalablytyped.runtime.Instantiable0
  import typings.std.Exclude
  import typings.std.InstanceType
  import typings.std.NonNullable
  import typings.std.Partial
  import typings.std.Pick
  import typings.std.Record
  import typings.std.Required
  import typings.std.ReturnType
  import typings.typeDashMappings.typeDashMappingsStrings.age
  import typings.typeDashMappings.typeDashMappingsStrings.color
  import typings.typeDashMappings.typeDashMappingsStrings.fontFamily
  import typings.typeDashMappings.typeDashMappingsStrings.fontSize
  import typings.typeDashMappings.typeDashMappingsStrings.fontWeight
  import typings.typeDashMappings.typeDashMappingsStrings.letterSpacing
  import typings.typeDashMappings.typeDashMappingsStrings.lineHeight
  import typings.typeDashMappings.typeDashMappingsStrings.name
  import typings.typeDashMappings.typeDashMappingsStrings.textTransform

  type Excluded = Omit[CSSProperties, color]
  type IPersonRecord = PersonRecord
  type IProxiedPerson = Proxify[Person]
  type NamePerson = Pick[Person, name]
  type NewedPerson = InstanceType[Instantiable0[Person]]
  type NonNullablePerson = NonNullable[Person]
  type Omit[T, K /* <: String */] = Pick[T, Exclude[String, K]]
  type PartialPerson = Partial[Person]
  type PersonRecord = Record[name | age, String]
  type ProxiedPerson = Proxify[Person]
  type Proxify[T] = /* import warning: ImportType.apply c Unsupported type mapping: 
  {[ P in keyof T ]: {get (): T[P], set (v : T[P]): void}}
    */ typings.typeDashMappings.typeDashMappingsStrings.Proxify with js.Any
  type ReadonlyPerson = Person
  type RequiredPerson = Required[Person]
  type ReturnedPerson = ReturnType[js.Function0[Person]]
  type T = Pick[Anon_Name | Anon_Age, name with age]
  type TypographyStyle = (Required[Pick[CSSProperties, fontFamily | fontSize | fontWeight | color]]) with (Partial[Pick[CSSProperties, letterSpacing | lineHeight | textTransform]])
  type TypographyStyleOptions = /* InlineNestedIdentityAlias: typings.std.Partial*/ TypographyStyle
  type U = Pick[Anon_AgeName, name | age]
  type V = Pick[Anon_AgeName, age]
}
