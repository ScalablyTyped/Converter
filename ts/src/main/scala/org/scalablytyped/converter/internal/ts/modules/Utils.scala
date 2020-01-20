package org.scalablytyped.converter.internal
package ts
package modules

import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector
import org.scalablytyped.converter.internal.ts.transforms.SetJsLocation

object Utils {
  def withJsLocation[T <: TsTree](tree: T, jsLocation: JsLocation): T =
    tree match {
      case x: HasJsLocation =>
        x.withJsLocation(jsLocation) match {
          case xx: TsContainer =>
            xx.withMembers(xx.members.map(SetJsLocation.visitTsContainerOrDecl(jsLocation))).asInstanceOf[T]
          case other => other.asInstanceOf[T]
        }
      case _ => tree
    }

  /**
    * The `TreeScope` interface for this is somewhat awkward, so we at least contain it here
    */
  def searchAmong[T <: TsNamedDecl](
      scope:        TsTreeScope.Scoped,
      Pick:         Picker[T],
      wanted:       IArray[TsIdent],
      expandeds:    IArray[TsNamedDecl],
      loopDetector: LoopDetector,
  ): IArray[(T, TsTreeScope)] =
    if (expandeds.isEmpty) Empty // optimization
    else {
      val ns       = TsDeclNamespace(NoComments, declared = false, TsIdent.dummy, expandeds, CodePath.NoPath, JsLocation.Zero)
      val newScope = scope / ns

      newScope.lookupInternal(Picker.All, wanted, loopDetector).flatMap {
        case (TsDeclNamespace(_, _, TsIdent.dummy, ms, _, _), newNewScope) =>
          ms.collect {
            case Pick(t) => t -> newNewScope
          }
        case (Pick(other), newNewScope) => IArray(other -> newNewScope)
        case _                          => Empty
      }
    }
}
