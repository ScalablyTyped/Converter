package org.scalablytyped.converter.internal
package ts
package transforms

import scala.annotation.tailrec

object SplitMethods extends TransformMembers with TransformClassMembers {
  val MaxNum = 50

  override def newClassMembers(scope: TsTreeScope, x: HasClassMembers): IArray[TsMember] =
    x.members.flatMap {
      case x @ TsMemberCtor(_, _, sig @ TsFunSig(_, _, params, _)) if hasUnionType(params) =>
        RemoveComment.keepFirstOnly(split(sig).map(sig => x.copy(signature = sig)))
      case x @ TsMemberFunction(_, _, _, MethodType.Normal, sig @ TsFunSig(_, _, ps, _), _, _) if hasUnionType(ps) =>
        RemoveComment.keepFirstOnly(split(sig).map(sig => x.copy(signature = sig)))
      case x @ TsMemberCall(_, _, sig @ TsFunSig(_, _, params, _)) if hasUnionType(params) =>
        RemoveComment.keepFirstOnly(split(sig).map(sig => x.copy(signature = sig)))
      case other => IArray(other)
    }

  override def newMembers(scope: TsTreeScope, x: TsContainer): IArray[TsContainerOrDecl] =
    x.members.flatMap {
      case x @ TsDeclFunction(_, _, _, sig @ TsFunSig(_, _, params, _), _, _) if hasUnionType(params) =>
        RemoveComment.keepFirstOnly(split(sig).map(sig => x.copy(signature = sig)))
      case other => IArray(other)
    }

  private def split(origin: TsFunSig): IArray[TsFunSig] =
    if (origin.params.length > 20) IArray(origin)
    else {
      val (repParamOpt: Option[TsFunParam], paramsNoRep: IArray[TsFunParam]) =
        origin.params.lastOption match {
          case Some(rep @ TsFunParam(_, _, Some(_: TsTypeRepeated))) => (Some(rep), origin.params.dropRight(1))
          case _ =>
            (None, origin.params)
        }

      val parameterPossibilitiesPerIndex: IArray[IArray[TsFunParam]] =
        paramsNoRep.foldLeft(Empty: IArray[IArray[TsFunParam]]) {
          case (params, fp @ TsFunParam(_, _, Some(TsTypeUnion(types)))) if types.length < MaxNum =>
            params :+ types.map(tpe => fp.copy(tpe = Some(tpe)))
          case (params, normalParam) => params :+ IArray(normalParam)
        }

      val parameterPossibilitiesPerIndexWithRep = repParamOpt match {
        case Some(repParam) => parameterPossibilitiesPerIndex :+ IArray(repParam)
        case None           => parameterPossibilitiesPerIndex
      }

      val count = parameterPossibilitiesPerIndexWithRep.foldLeft(1)(_ * _.length)

      if (count > MaxNum || count < 0 /* it might actually overflow!*/ ) IArray(origin)
      else {
        val ret = generateNewSignatures(origin, IArray(Empty), parameterPossibilitiesPerIndexWithRep)
        ret
          .map { sig =>
            val dropTrailingUndefineds = sig.params.reverse.dropWhile(_.tpe.exists(OptionalType.undefineds)).reverse
            sig.copy(params = dropTrailingUndefineds)
          }
          .sortBy(_.params.length)
      }
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

  def hasUnionType(params: IArray[TsFunParam]): Boolean =
    params.exists(_.tpe.exists(_.isInstanceOf[TsTypeUnion]))

  def isRepeated(x: TsType): Boolean =
    x match {
      case _: TsTypeRepeated => true
      case _ => false
    }

  def collectRightWhile[T <: AnyRef, U <: AnyRef](ts: IArray[T])(pf: PartialFunction[T, U]): (IArray[T], IArray[U]) = {
    var idx = ts.length - 1
    val b   = IArray.Builder.empty[U]

    while (idx >= 0) {
      val t = ts(idx)
      if (pf.isDefinedAt(t)) {
        b += pf(t)
      } else {
        idx = 0
      }
      idx -= 1
    }

    val res = b.result()
    (ts.dropRight(res.length), res.reverse)
  }
}
