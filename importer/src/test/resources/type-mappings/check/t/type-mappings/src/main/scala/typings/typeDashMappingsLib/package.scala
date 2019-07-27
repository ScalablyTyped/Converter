package typings

import org.scalablytyped.runtime.Instantiable0
import stdLib.Exclude
import stdLib.InstanceType
import stdLib.NonNullable
import stdLib.Partial
import stdLib.Pick
import stdLib.Record
import stdLib.Required
import stdLib.ReturnType
import typeDashMappingsLib.typeDashMappingsLibStrings.age
import typeDashMappingsLib.typeDashMappingsLibStrings.color
import typeDashMappingsLib.typeDashMappingsLibStrings.fontFamily
import typeDashMappingsLib.typeDashMappingsLibStrings.fontSize
import typeDashMappingsLib.typeDashMappingsLibStrings.fontWeight
import typeDashMappingsLib.typeDashMappingsLibStrings.letterSpacing
import typeDashMappingsLib.typeDashMappingsLibStrings.lineHeight
import typeDashMappingsLib.typeDashMappingsLibStrings.name
import typeDashMappingsLib.typeDashMappingsLibStrings.textTransform
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
    */ typeDashMappingsLib.typeDashMappingsLibStrings.Proxify with js.Any
  type ReadonlyPerson = Person
  type RequiredPerson = Required[Person]
  type ReturnedPerson = ReturnType[js.Function0[Person]]
  type T = Pick[Anon_Name | Anon_Age, name with age]
  type TypographyStyle = (Required[Pick[CSSProperties, fontFamily | fontSize | fontWeight | color]]) with (Partial[Pick[CSSProperties, letterSpacing | lineHeight | textTransform]])
  type TypographyStyleOptions = /* InlineNestedIdentityAlias: stdLib.Partial*/ TypographyStyle
  type U = Pick[Anon_AgeName, name | age]
  type V = Pick[Anon_AgeName, age]
}
