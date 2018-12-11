package com.olvind.tso
package ts
package transforms

import scala.annotation.tailrec

object SplitMethodsOnUnionTypes extends TreeTransformationScopedChanges {
  override def enterTsParsedFile(t: TreeScope)(x: TsParsedFile): TsParsedFile =
    x.copy(members = newMembers(x))

  override def enterTsDeclGlobal(t: TreeScope)(x: TsGlobal): TsGlobal =
    x.copy(members = newMembers(x))

  override def enterTsDeclNamespace(t: TreeScope)(x: TsDeclNamespace): TsDeclNamespace =
    x.copy(members = newMembers(x))

  override def enterTsDeclModule(t: TreeScope)(x: TsDeclModule): TsDeclModule =
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
            case x: TsMemberFunction if !x.isOptional && x.name =/= TsIdent.Apply =>
              split(x.signature).map(sig => x.copy(signature = sig))
            case x: TsMemberCall =>
              split(x.signature).map(sig => x.copy(signature = sig))
            case x: TsMemberCtor =>
              split(x.signature).map(sig => x.copy(signature = sig))
            case other => Seq(other)
          }
      }

    x.unnamed ++ newMembers.to[Seq]
  }

  private def newMembers(x: TsContainer): Seq[TsContainerOrDecl] = {
    val newMembers: Iterable[TsNamedDecl] =
      x.membersByName flatMap {
        case (_, members: Seq[TsNamedDecl]) =>
          members flatMap {
            case x: TsDeclFunction if x.name =/= TsIdent.namespaced =>
              split(x.signature).map(sig => x.copy(signature = sig))
            case other => Seq(other)
          }
      }

    x.unnamed ++ x.imports ++ newMembers.to[Seq]
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
  private def generateNewSignatures(origin:     TsFunSig,
                                    newParamss: Seq[Seq[TsFunParam]],
                                    remaining:  Seq[Seq[TsFunParam]]): Seq[TsFunSig] =
    remaining match {
      case Nil => newParamss.map(currents => origin.copy(params = currents))
      case heads :: tail =>
        generateNewSignatures(
          origin,
          heads.flatMap(head => newParamss.map(_ :+ head)),
          tail
        )
    }
}
