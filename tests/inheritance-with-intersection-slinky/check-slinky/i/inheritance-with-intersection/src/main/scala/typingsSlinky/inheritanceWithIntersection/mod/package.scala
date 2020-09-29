package typingsSlinky.inheritanceWithIntersection

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object mod {
  type BaseProps[M /* <: typingsSlinky.inheritanceWithIntersection.mod.OverridableTypeMap */] = js.Any with typingsSlinky.inheritanceWithIntersection.mod.BProps
  type ButtonTypeMap[P, D /* <: slinky.core.facade.ReactElement */] = typingsSlinky.inheritanceWithIntersection.mod.ExtendButtonBaseTypeMap[typingsSlinky.inheritanceWithIntersection.anon.Props[P]]
  type ExtendBase[M /* <: typingsSlinky.inheritanceWithIntersection.mod.OverridableTypeMap */] = (js.Function1[
    /* props */ typingsSlinky.inheritanceWithIntersection.anon.Href with (typingsSlinky.inheritanceWithIntersection.mod.OverrideProps[
      typingsSlinky.inheritanceWithIntersection.mod.ExtendButtonBaseTypeMap[M], 
      typingsSlinky.inheritanceWithIntersection.inheritanceWithIntersectionStrings.a
    ]), 
    slinky.core.facade.ReactElement
  ]) with typingsSlinky.inheritanceWithIntersection.mod.OverridableComponent
  type OverrideProps[M /* <: typingsSlinky.inheritanceWithIntersection.mod.OverridableTypeMap */, C /* <: slinky.core.facade.ReactElement */] = typingsSlinky.inheritanceWithIntersection.mod.BaseProps[M] with typingsSlinky.inheritanceWithIntersection.mod.AProps
}
