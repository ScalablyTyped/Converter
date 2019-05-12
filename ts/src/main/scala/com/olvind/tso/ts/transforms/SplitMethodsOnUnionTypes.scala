package com.olvind.tso
package ts
package transforms

import scala.annotation.tailrec

object SplitMethodsOnUnionTypes extends TransformMembers with TransformClassMembers {

  override def newClassMembers(scope: TsTreeScope, x: HasClassMembers): Seq[TsMember] =
    x.members flatMap {
      case x: TsMemberFunction if !x.isOptional && x.name =/= TsIdent.Apply =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case x: TsMemberCall =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case x: TsMemberCtor =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case other => Seq(other)
    }

  override def newMembers(scope: TsTreeScope, x: TsContainer): Seq[TsContainerOrDecl] =
    x.members flatMap {
      case x: TsDeclFunction if x.name =/= TsIdent.namespaced =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case other => Seq(other)
    }

  private def split(origin: TsFunSig): Seq[TsFunSig] = {
    if (!origin.params.exists(_.tpe.fold(false)(_.isInstanceOf[TsTypeUnion]))) //optimization
      return Seq(origin)

    val parameterPossibilitiesPerIndex: Seq[Seq[TsFunParam]] =
      origin.params.foldLeft(Seq.empty[Seq[TsFunParam]]) {
        case (params, fp @ TsFunParam(_, _, Some(TsTypeUnion(types)), _)) if types.length < 10 =>
          params :+ (types map (tpe => fp.copy(tpe = Some(tpe))))
        case (params, normalParam) => params :+ Seq(normalParam)
      }

    val count = parameterPossibilitiesPerIndex.foldLeft(1)(_ * _.size)

    if (count > 20) Seq(origin)
    else generateNewSignatures(origin, Seq(Seq.empty), parameterPossibilitiesPerIndex)
  }

  @tailrec
  private def generateNewSignatures(
      origin:     TsFunSig,
      newParamss: Seq[Seq[TsFunParam]],
      remaining:  Seq[Seq[TsFunParam]],
  ): Seq[TsFunSig] =
    remaining match {
      case Nil => newParamss.map(currents => origin.copy(params = currents))
      case heads :: tail =>
        generateNewSignatures(
          origin,
          heads.flatMap(head => newParamss.map(_ :+ head)),
          tail,
        )
    }
}
