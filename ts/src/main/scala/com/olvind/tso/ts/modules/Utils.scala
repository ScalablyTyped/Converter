package com.olvind.tso
package ts
package modules

import com.olvind.tso.ts.TreeScope.LoopDetector
import com.olvind.tso.ts.transforms.SetJsLocation

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
  def searchAmong[T <: TsNamedDecl](scope:        TreeScope.Scoped,
                                    Pick:         Picker[T],
                                    wanted:       List[TsIdent],
                                    expandeds:    Seq[TsNamedDecl],
                                    loopDetector: LoopDetector): Seq[(T, TreeScope)] = {
    wanted match {
      case first :: Nil =>
        return expandeds.collect {
          case Pick(t) if t.name === first => t -> scope
        }
      case _ =>
    }

    val Dummy    = TsIdentNamespace(TsIdent.dummy.value)
    val ns       = TsDeclNamespace(NoComments, declared = false, Dummy, expandeds, CodePath.NoPath, JsLocation.Zero)
    val newScope = scope / ns

    newScope.lookupInternal(Picker.All, wanted, loopDetector).flatMap {
      case (TsDeclNamespace(_, _, Dummy, ms, _, _), newNewScope) =>
        ms.collect {
          case Pick(t) => t -> newNewScope
        }
      case (Pick(other), newNewScope) => Seq(other -> newNewScope)
      case _                          => Nil
    }
  }

}
