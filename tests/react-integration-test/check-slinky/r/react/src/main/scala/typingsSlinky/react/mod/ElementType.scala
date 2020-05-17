package typingsSlinky.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

//
// React Elements
// ----------------------------------------------------------------------
/* Rewritten from type alias, can be one of: 
  - / * import warning: importer.ImportType#apply Failed type conversion: {[ K in 'a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view' ]: P extends react.react.<global>.JSX.IntrinsicElements[K]? K : never}['a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view'] * / js.Any
  - typingsSlinky.react.mod.ComponentType[P]
*/
trait ElementType[P] extends js.Object

object ElementType {
  @scala.inline
  implicit def apply[P](
    value: /* import warning: importer.ImportType#apply Failed type conversion: {[ K in 'a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view' ]: P extends react.react.<global>.JSX.IntrinsicElements[K]? K : never}['a' | 'abbr' | 'address' | 'area' | 'article' | 'aside' | 'audio' | 'b' | 'base' | 'bdi' | 'bdo' | 'big' | 'view'] */ js.Any
  ): slinky.core.facade.ReactElement = value.asInstanceOf[slinky.core.facade.ReactElement]
  @scala.inline
  implicit def apply[P](value: ComponentClass[P, js.Object]): slinky.core.facade.ReactElement = value.asInstanceOf[slinky.core.facade.ReactElement]
  @scala.inline
  implicit def apply[P](value: FunctionComponent[P]): slinky.core.facade.ReactElement = value.asInstanceOf[slinky.core.facade.ReactElement]
}

