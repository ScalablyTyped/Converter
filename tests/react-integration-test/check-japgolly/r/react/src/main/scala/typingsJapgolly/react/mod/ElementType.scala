package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.ComponentClassP
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

//
// React Elements
// ----------------------------------------------------------------------
/* Rewritten from type alias, can be one of: 
  - / * import warning: importer.ImportType#apply Failed type conversion: {[ K in 'a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view' ]: P extends react.react.<global>.JSX.IntrinsicElements[K]? K : never}['a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view'] * / js.Any
  - typingsJapgolly.react.mod.ComponentType[P]
*/
trait ElementType[P] extends js.Object

object ElementType {
  @scala.inline
  implicit def apply[P](
    value: /* import warning: importer.ImportType#apply Failed type conversion: {[ K in 'a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view' ]: P extends react.react.<global>.JSX.IntrinsicElements[K]? K : never}['a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view'] */ js.Any
  ): japgolly.scalajs.react.raw.React.ElementType = value.asInstanceOf[japgolly.scalajs.react.raw.React.ElementType]
  @scala.inline
  implicit def apply[P](value: ComponentClassP[P with js.Object]): japgolly.scalajs.react.raw.React.ElementType = value.asInstanceOf[japgolly.scalajs.react.raw.React.ElementType]
  @scala.inline
  implicit def apply[P](value: FunctionComponent[P]): japgolly.scalajs.react.raw.React.ElementType = value.asInstanceOf[japgolly.scalajs.react.raw.React.ElementType]
}

