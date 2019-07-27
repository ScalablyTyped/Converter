package typings

import org.scalablytyped.runtime.Instantiable0
import typings.stdLib.Exclude
import typings.stdLib.InstanceType
import typings.stdLib.NonNullable
import typings.stdLib.Partial
import typings.stdLib.Pick
import typings.stdLib.Record
import typings.stdLib.Required
import typings.stdLib.ReturnType
import typings.typeDashMappingsLib.typeDashMappingsLibStrings.age
import typings.typeDashMappingsLib.typeDashMappingsLibStrings.color
import typings.typeDashMappingsLib.typeDashMappingsLibStrings.fontFamily
import typings.typeDashMappingsLib.typeDashMappingsLibStrings.fontSize
import typings.typeDashMappingsLib.typeDashMappingsLibStrings.fontWeight
import typings.typeDashMappingsLib.typeDashMappingsLibStrings.letterSpacing
import typings.typeDashMappingsLib.typeDashMappingsLibStrings.lineHeight
import typings.typeDashMappingsLib.typeDashMappingsLibStrings.name
import typings.typeDashMappingsLib.typeDashMappingsLibStrings.textTransform
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object typeDashMappingsLib {
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
    */ typings.typeDashMappingsLib.typeDashMappingsLibStrings.Proxify with js.Any
  type ReadonlyPerson = Person
  type RequiredPerson = Required[Person]
  type ReturnedPerson = ReturnType[js.Function0[Person]]
  type T = Pick[Anon_Name | Anon_Age, name with age]
  type TypographyStyle = (Required[Pick[CSSProperties, fontFamily | fontSize | fontWeight | color]]) with (Partial[Pick[CSSProperties, letterSpacing | lineHeight | textTransform]])
  type TypographyStyleOptions = /* InlineNestedIdentityAlias: typings.stdLib.Partial*/ TypographyStyle
  type U = Pick[Anon_AgeName, name | age]
  type V = Pick[Anon_AgeName, age]
}
