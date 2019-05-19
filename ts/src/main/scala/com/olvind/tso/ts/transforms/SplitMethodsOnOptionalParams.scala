package com.olvind.tso
package ts
package transforms

import scala.collection.mutable.ListBuffer

object SplitMethodsOnOptionalParams extends TransformMembers with TransformClassMembers {
  override def newClassMembers(scope: TsTreeScope, x: HasClassMembers): Seq[TsMember] =
    x.members flatMap {
      case x: TsMemberCtor =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case x: TsMemberFunction if !x.isOptional =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case x: TsMemberCall =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case other => List(other)
    }

  override def newMembers(scope: TsTreeScope, x: TsContainer): Seq[TsContainerOrDecl] =
    x.members flatMap {
      case x: TsDeclFunction =>
        RemoveComment.keepFirstOnly(split(x.signature).map(sig => x.copy(signature = sig)))
      case other => List(other)
    }

  def isRepeated(x: TsType): Boolean =
    x match {
      case _: TsTypeRepeated => true
      case _ => false
    }

  def collectRightWhile[T, U](ts: Seq[T])(pf: PartialFunction[T, U]): (Seq[T], Seq[U]) = {
    var idx = ts.length - 1
    val b   = new ListBuffer[U]

    while (idx >= 0) {
      val t = ts(idx)
      if (pf.isDefinedAt(t)) {
        b += pf(t)
      } else {
        idx = 0
      }
      idx -= 1
    }

    (ts.dropRight(b.size), b.reverse.to[Seq])
  }

  private def split(origin: TsFunSig): Seq[TsFunSig] = {
    val (repParamOpt, paramsNoRep) =
      origin.params.lastOption match {
        case Some(rep @ TsFunParam(_, _, Some(_: TsTypeRepeated), _)) => (Some(rep), origin.params.dropRight(1))
        case _ =>
          (None, origin.params)
      }

    val (requiredParams: Seq[TsFunParam], optionalParams: Seq[TsFunParam]) =
      collectRightWhile(paramsNoRep) {
        case x @ TsFunParam(_, _, Some(OptionalType(simplified)), _) =>
          x.copy(tpe = Some(simplified), isOptional = false)
        case x if x.isOptional => x.copy(isOptional = false)
      }

    if (optionalParams.length > 5) Seq(origin)
    else {
      val ret = (0 to optionalParams.length).map { n =>
        val newParams              = requiredParams ++ optionalParams.take(n)
        val dropTrailingUndefineds = newParams.reverse.dropWhile(_.tpe.exists(OptionalType.undefineds)).reverse

        origin.copy(params = dropTrailingUndefineds)
      }

      val lastIdx = ret.size - 1
      val last    = ret(lastIdx)
      ret.updated(lastIdx, last.copy(params = last.params ++ repParamOpt))
    }
  }
}
