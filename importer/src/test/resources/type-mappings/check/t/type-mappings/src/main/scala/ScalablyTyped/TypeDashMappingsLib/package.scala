package ScalablyTyped

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object TypeDashMappingsLib {
  type AgePerson = StdLib.Exclude[Person, NamePerson]
  type AgePerson2 = StdLib.Extract[Person, AgePerson]
  type IPersonRecord = PersonRecord
  type IProxiedPerson = Proxify[Person]
  type NamePerson = StdLib.Pick[Person, TypeDashMappingsLib.TypeDashMappingsLibStrings.name]
  type NewedPerson = StdLib.InstanceType[ScalablyTyped.runtime.Instantiable0[Person]]
  type NonNullablePerson = StdLib.NonNullable[Person]
  type PartialPerson = StdLib.Partial[Person]
  type PersonRecord = StdLib.Record[
    TypeDashMappingsLib.TypeDashMappingsLibStrings.name | TypeDashMappingsLib.TypeDashMappingsLibStrings.age, 
    java.lang.String
  ]
  type ProxiedPerson = Proxify[Person]
  type Proxify[T] = TypeDashMappingsLib.TypeDashMappingsLibStrings.Proxify with T
  type ReadonlyPerson = StdLib.Readonly[Person]
  type RequiredPerson = StdLib.Required[Person]
  type ReturnedPerson = StdLib.ReturnType[js.Function0[Person]]
  type T = StdLib.Pick[
    Anon_Name | Anon_Age, 
    TypeDashMappingsLib.TypeDashMappingsLibStrings.name with TypeDashMappingsLib.TypeDashMappingsLibStrings.age
  ]
  type TypographyStyle = (StdLib.Required[
    StdLib.Pick[
      CSSProperties, 
      TypeDashMappingsLib.TypeDashMappingsLibStrings.fontFamily | TypeDashMappingsLib.TypeDashMappingsLibStrings.fontSize | TypeDashMappingsLib.TypeDashMappingsLibStrings.fontWeight | TypeDashMappingsLib.TypeDashMappingsLibStrings.color
    ]
  ]) with (StdLib.Partial[
    StdLib.Pick[
      CSSProperties, 
      TypeDashMappingsLib.TypeDashMappingsLibStrings.letterSpacing | TypeDashMappingsLib.TypeDashMappingsLibStrings.lineHeight | TypeDashMappingsLib.TypeDashMappingsLibStrings.textTransform
    ]
  ])
  type TypographyStyleOptions = /* InlineNestedIdentityAlias: StdLib.Partial*/ TypographyStyle
  type U = StdLib.Pick[
    Anon_Name with Anon_Age, 
    TypeDashMappingsLib.TypeDashMappingsLibStrings.name | TypeDashMappingsLib.TypeDashMappingsLibStrings.age
  ]
}
