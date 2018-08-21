package ScalablyTyped
package ReactLib
package ReactModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object ReactNamespace {
  type ComponentType[P] = ReactLib.ReactModule.ReactNamespace.ComponentClass[P] | ReactLib.ReactModule.ReactNamespace.StatelessComponent[P]
  type DetailedHTMLProps[E /* <: ReactLib.ReactModule.ReactNamespace.HTMLAttributes[T] */, T] = E with ReactLib.ReactModule.ReactNamespace.ClassAttributes[T]
  type HTMLProps[T] = ReactLib.ReactModule.ReactNamespace.AllHTMLAttributes[T] with ReactLib.ReactModule.ReactNamespace.ClassAttributes[T]
  type Key = java.lang.String | scala.Double
  type ReactNode = js.UndefOr[java.lang.String | scala.Double | scala.Boolean | scala.Null]
  type ReactType[P] = java.lang.String | ReactLib.ReactModule.ReactNamespace.ComponentType[P]
  type Ref[T] = java.lang.String | (js.Function1[/* instance */ T | scala.Null, js.Any])
  type SFC[P] = ReactLib.ReactModule.ReactNamespace.StatelessComponent[P]
  type SVGProps[T] = ReactLib.ReactModule.ReactNamespace.ClassAttributes[T]
}
