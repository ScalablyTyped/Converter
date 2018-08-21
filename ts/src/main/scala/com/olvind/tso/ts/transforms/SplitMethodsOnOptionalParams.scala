package com.olvind.tso
package ts
package transforms

import scala.collection.mutable.ListBuffer

object SplitMethodsOnOptionalParams extends TreeVisitorScopedChanges {
  override def enterTsParsedFile(t: TreeScope)(x: TsParsedFile): TsParsedFile =
    x.copy(members = newMembers(x))

  override def enterTsDeclGlobal(t: TreeScope)(x: TsGlobal): TsGlobal =
    x.copy(members = newMembers(x))

  override def enterTsDeclNamespace(t: TreeScope)(x: TsDeclNamespace): TsDeclNamespace =
    x.copy(members = newMembers(x))

  override def enterTsDeclModule(t: TreeScope)(x: TsDeclModule): TsDeclModule =
    x.copy(members = newMembers(x))

  override def enterTsAugmentedModule(t: TreeScope)(x: TsAugmentedModule): TsAugmentedModule =
    x.copy(members = newMembers(x))

  override def enterTsDeclClass(t: TreeScope)(x: TsDeclClass): TsDeclClass =
    x.copy(members = newClassMembers(x))

  override def enterTsDeclInterface(t: TreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(members = newClassMembers(x))

  override def enterTsTypeObject(t: TreeScope)(x: TsTypeObject): TsTypeObject =
    x.copy(members = newClassMembers(x))

  private def newClassMembers(x: HasClassMembers) = {
    val newMembers: Iterable[TsMember] =
      x.membersByName flatMap {
        case (_, members: Seq[TsMember]) =>
          members flatMap {
            case x: TsMemberCtor =>
              split(x.signature).map(sig => x.copy(signature = sig))
            case x: TsMemberFunction if !x.isOptional =>
              split(x.signature).map(sig => x.copy(signature = sig))
            case x: TsMemberCall =>
              split(x.signature).map(sig => x.copy(signature = sig))
            case other => Seq(other)
          }
      }

    x.unnamed ++ newMembers.to[Seq]
  }

  private def newMembers(x: TsContainer): Seq[TsContainerOrDecl] = {
    val newMembers: Iterable[TsNamedDecl] =
      x.membersByName flatMap {
        case (name, members: Seq[TsNamedDecl]) =>
          members flatMap {
            case x: TsDeclFunction =>
              split(x.signature).map(sig => x.copy(signature = sig))
            case other => Seq(other)
          }
      }

    x.unnamed ++ x.imports ++ newMembers.to[Seq]
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

  object OptionalType {
    val undefineds = Set[TsType](TsTypeRef.undefined, TsTypeRef.`null`)

    def unapply(tpe: Option[TsType]): Option[TsType] =
      tpe match {
        case Some(TsTypeUnion(types)) =>
          types partition undefineds match {
            case (Nil, _)       => None
            case (_, remaining) => Some(TsTypeUnion.simplified(remaining))
          }
        case _ => None
      }
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
        case x @ TsFunParam(_, _, OptionalType(simplified), _) => x.copy(tpe        = Some(simplified), isOptional = false)
        case x if x.isOptional                                 => x.copy(isOptional = false)
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
