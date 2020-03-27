package typings.vueResource

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object vuejs {
  type resource = js.Function4[
    /* url */ java.lang.String, 
    /* params */ js.UndefOr[js.Object], 
    /* actions */ js.UndefOr[js.Any], 
    /* options */ js.UndefOr[typings.vueResource.vuejs.HttpOptions], 
    typings.vueResource.vuejs.ResourceMethods
  ]
}
