package org.scalablytyped.converter.internal
package ts
package transforms

import scala.annotation.tailrec

object SplitMethodsOnUnionTypes extends TransformMembers with TransformClassMembers {

  override def newClassMembers(scope: TsTreeScope, x: HasClassMembers): IArray[TsMember] =
    x.members flatMap {
      case x: TsMemberFunction if !x.isOptional && x.name =/= TsIdent.Apply =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case x: TsMemberCall =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case x: TsMemberCtor =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case other => IArray(other)
    }

  override def newMembers(scope: TsTreeScope, x: TsContainer): IArray[TsContainerOrDecl] =
    x.members flatMap {
      case x: TsDeclFunction =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case other => IArray(other)
    }

  private def split(origin: TsFunSig): IArray[TsFunSig] = {
    if (!origin.params.exists(_.tpe.fold(false)(_.isInstanceOf[TsTypeUnion]))) //optimization
      return IArray(origin)

    val parameterPossibilitiesPerIndex: IArray[IArray[TsFunParam]] =
      origin.params.foldLeft(Empty: IArray[IArray[TsFunParam]]) {
        case (params, fp @ TsFunParam(_, _, Some(TsTypeUnion(types)), _)) if types.length < 10 =>
          params :+ (types map (tpe => fp.copy(tpe = Some(tpe))))
        case (params, normalParam) => params :+ IArray(normalParam)
      }

    val count = parameterPossibilitiesPerIndex.foldLeft(1)(_ * _.length)

    if (count > 20) IArray(origin)
    else generateNewSignatures(origin, IArray(Empty), parameterPossibilitiesPerIndex)
  }

  @tailrec
  private def generateNewSignatures(
      origin:     TsFunSig,
      newParamss: IArray[IArray[TsFunParam]],
      remaining:  IArray[IArray[TsFunParam]],
  ): IArray[TsFunSig] =
    remaining match {
      case Empty => newParamss.map(currents => origin.copy(params = currents))
      case IArray.headTail(heads, tail) =>
        generateNewSignatures(
          origin,
          heads.flatMap(head => newParamss.map(_ :+ head)),
          tail,
        )
    }
}
