package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object typeMappings {
  import org.scalablytyped.runtime.Instantiable0
  import typings.std.Exclude
  import typings.std.InstanceType
  import typings.std.NonNullable
  import typings.std.Partial
  import typings.std.Pick
  import typings.std.Record
  import typings.std.Required
  import typings.std.ReturnType
  import typings.typeMappings.typeMappingsStrings.age
  import typings.typeMappings.typeMappingsStrings.color
  import typings.typeMappings.typeMappingsStrings.fontFamily
  import typings.typeMappings.typeMappingsStrings.fontSize
  import typings.typeMappings.typeMappingsStrings.fontWeight
  import typings.typeMappings.typeMappingsStrings.letterSpacing
  import typings.typeMappings.typeMappingsStrings.lineHeight
  import typings.typeMappings.typeMappingsStrings.name
  import typings.typeMappings.typeMappingsStrings.textTransform

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
    */ typings.typeMappings.typeMappingsStrings.Proxify with js.Any
  type ReadonlyPerson = Person
  type RequiredPerson = Required[Person]
  type ReturnedPerson = ReturnType[js.Function0[Person]]
  type T = Pick[Anon_Name | Anon_Age, name with age]
  type TypographyStyle = (Required[Pick[CSSProperties, fontFamily | fontSize | fontWeight | color]]) with (Partial[Pick[CSSProperties, letterSpacing | lineHeight | textTransform]])
  type TypographyStyleOptions = /* InlineNestedIdentityAlias: typings.std.Partial*/ TypographyStyle
  type U = Pick[Anon_AgeName, name | age]
  type V = Pick[Anon_AgeName, age]
}
