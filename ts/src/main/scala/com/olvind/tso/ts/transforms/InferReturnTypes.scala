package com.olvind.tso
package ts
package transforms

import com.olvind.tso.ts.ParentsResolver.InterfaceOrClass
import seqs.TraversableOps

object InferReturnTypes extends TreeVisitorScopedChanges {
  override def enterTsMemberFunction(scope: TreeScope)(x: TsMemberFunction): TsMemberFunction = {
    val ownerOpt: Option[InterfaceOrClass] =
      scope.stack collectFirst { case ioc: InterfaceOrClass => ioc }

    (x.name, x.signature, ownerOpt) match {
      case (TsIdent.constructor, _, _) => x
      case (_, TsFunSig(_, _, params, None), Some(owner)) =>
        val rewrittenOpt: Option[TsMemberFunction] =
          ParentsResolver(scope, owner).parents firstDefined { descendant =>
            descendant.membersByName get x.name flatMap { sameNames =>
              sameNames collectFirst {
                case TsMemberFunction(_, _, _, TsFunSig(_, _, thoseParams, Some(resultType)), _, _, _)
                    if thoseParams.length === params.length =>
                  x.copy(signature = x.signature.copy(resultType = Some(resultType)))
              }
            }
          }

        rewrittenOpt match {
          case Some(rewritten) =>
            scope.logger debug s"Inferred return type"
            rewritten
          case None =>
            scope.logger info s"Could not infer return type"
            x
        }
      case _ => x
    }
  }
}
