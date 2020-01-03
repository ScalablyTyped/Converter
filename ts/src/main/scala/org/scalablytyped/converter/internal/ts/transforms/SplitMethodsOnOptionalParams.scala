package org.scalablytyped.converter.internal
package ts
package transforms

object SplitMethodsOnOptionalParams extends TransformMembers with TransformClassMembers {
  override def newClassMembers(scope: TsTreeScope, x: HasClassMembers): IArray[TsMember] =
    x.members flatMap {
      case x: TsMemberCtor =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case x: TsMemberFunction if !x.isOptional =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case x: TsMemberCall =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case other => IArray(other)
    }

  override def newMembers(scope: TsTreeScope, x: TsContainer): IArray[TsContainerOrDecl] =
    x.members flatMap {
      case x: TsDeclFunction =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case other => IArray(other)
    }

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

  private def split(origin: TsFunSig): IArray[TsFunSig] = {
    val (repParamOpt, paramsNoRep) =
      origin.params.lastOption match {
        case Some(rep @ TsFunParam(_, _, Some(_: TsTypeRepeated), _)) => (Some(rep), origin.params.dropRight(1))
        case _ =>
          (None, origin.params)
      }

    val (requiredParams: IArray[TsFunParam], optionalParams: IArray[TsFunParam]) =
      collectRightWhile(paramsNoRep) {
        case x @ TsFunParam(_, _, Some(OptionalType(simplified)), _) =>
          x.copy(tpe = Some(simplified), isOptional = false)
        case x if x.isOptional => x.copy(isOptional = false)
      }

    if (optionalParams.length > 5) IArray(origin)
    else {
      val ret = (0 to optionalParams.length).map { n =>
        val newParams              = requiredParams ++ optionalParams.take(n)
        val dropTrailingUndefineds = newParams.reverse.dropWhile(_.tpe.exists(OptionalType.undefineds)).reverse

        origin.copy(params = dropTrailingUndefineds)
      }

      val lastIdx = ret.size - 1
      val last    = ret(lastIdx)
      val newSigs = ret.updated(lastIdx, last.copy(params = last.params ++ IArray.fromOption(repParamOpt)))
      IArray.fromTraversable(newSigs)
    }
  }
}
