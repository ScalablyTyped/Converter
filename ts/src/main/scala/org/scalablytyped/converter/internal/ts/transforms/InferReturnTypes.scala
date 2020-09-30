package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.ts.ParentsResolver.InterfaceOrClass

object InferReturnTypes extends TreeTransformationScopedChanges {
  override def enterTsMemberFunction(scope: TsTreeScope)(x: TsMemberFunction): TsMemberFunction = {
    val ownerOpt: Option[InterfaceOrClass] =
      scope.stack.collectFirst { case ioc: InterfaceOrClass => ioc }

    (x.name, x.signature, ownerOpt) match {
      case (TsIdent.constructor, _, _) => x
      case (_, TsFunSig(_, _, params, None), Some(owner)) =>
        val rewrittenOpt: Option[TsMemberFunction] =
          ParentsResolver(scope, owner).parents.firstDefined { descendant =>
            descendant.membersByName.get(x.name).flatMap { sameNames =>
              sameNames.collectFirst {
                case TsMemberFunction(
                    _,
                    _,
                    _,
                    MethodType.Normal,
                    TsFunSig(_, _, thoseParams, Some(resultType)),
                    _,
                    _,
                    ) if thoseParams.length === params.length =>
                  x.copy(signature = x.signature.copy(resultType = Some(resultType)))
              }
            }
          }

        rewrittenOpt match {
          case Some(rewritten) =>
            scope.logger.debug(s"Inferred return type")
            rewritten
          case None =>
            scope.logger.info(s"Could not infer return type")
            x
        }
      case _ => x
    }
  }
}
