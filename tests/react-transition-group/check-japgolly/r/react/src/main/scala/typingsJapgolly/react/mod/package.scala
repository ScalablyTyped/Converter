package typingsJapgolly.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object mod {
  type ComponentState = js.Object
  type ComponentType[P] = (japgolly.scalajs.react.raw.React.ComponentClassP[P with js.Object]) | typingsJapgolly.react.mod.StatelessComponent[P]
  type DetailedHTMLProps[E /* <: typingsJapgolly.react.mod.HTMLAttributes[T] */, T] = typingsJapgolly.react.mod.ClassAttributes[T] with E
  type Key = java.lang.String | scala.Double
  type NativeAnimationEvent = org.scalajs.dom.raw.AnimationEvent
  type ReactNode = js.UndefOr[java.lang.String | scala.Double | scala.Boolean]
  type ReactType[P] = java.lang.String | typingsJapgolly.react.mod.ComponentType[P]
  type Ref[T] = java.lang.String | (js.Function1[/* instance */ T | scala.Null, js.Any])
  type SFC[P] = typingsJapgolly.react.mod.StatelessComponent[P]
  type SVGAttributes[T] = typingsJapgolly.react.mod.DOMAttributes[T]
  type SVGProps[T] = typingsJapgolly.react.mod.ClassAttributes[T]
}
