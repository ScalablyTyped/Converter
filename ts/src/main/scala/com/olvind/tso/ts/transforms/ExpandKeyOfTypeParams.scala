package com.olvind.tso
package ts
package transforms
import com.olvind.tso.ts.TsTreeScope.LoopDetector

object ExpandKeyOfTypeParams extends TreeTransformationScopedChanges {

  case class IndexedTypeParam(cs: Comments, typeParam: TsIdent, ref: TsTypeRef)

  private object IndexedTypeParams {
    def unapply(ts: Seq[TsTypeParam]): Option[(IndexedTypeParam, Seq[TsTypeParam])] =
      ts.collectFirst {
        case TsTypeParam(cs, name, Some(TsTypeKeyOf(ref: TsTypeRef)), None) =>
          (IndexedTypeParam(cs, name, ref), ts.filterNot(_.name === name))
      }
  }

  override def enterTsDeclInterface(scope: TsTreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(members = newClassMembers(scope, x.members))

  override def enterTsDeclClass(scope: TsTreeScope)(x: TsDeclClass): TsDeclClass =
    x.copy(members = newClassMembers(scope, x.members))

  override def enterTsParsedFile(scope: TsTreeScope)(x: TsParsedFile): TsParsedFile =
    x.copy(members = newContainerMembers(scope, x.members))

  override def enterTsDeclModule(scope: TsTreeScope)(x: TsDeclModule): TsDeclModule =
    x.copy(members = newContainerMembers(scope, x.members))

  override def enterTsDeclNamespace(scope: TsTreeScope)(x: TsDeclNamespace): TsDeclNamespace =
    x.copy(members = newContainerMembers(scope, x.members))

  def newClassMembers(scope: TsTreeScope, members: Seq[TsMember]): Seq[TsMember] =
    members.flatMap {
      case m @ TsMemberFunction(_, _, name, sig @ TsFunSig(_, IndexedTypeParams(indexed, rest), _, _), _, _, _) =>
        lazy val mm = m.copy(signature = sig.copy(tparams = rest))

        val members = AllMembersFor(scope / m, LoopDetector.initial)(indexed.ref)
        val fs = members
          .collect {
            case TsMemberProperty(_, _, TsIdentSimple(n), Some(tpe), _, false, _, _) =>
              val rewrites = Map[TsType, TsType](
                TsTypeRef.of(indexed.typeParam) -> TsTypeLiteral(TsLiteralString(n)),
                TsTypeLookup(indexed.ref, TsTypeLiteral(TsLiteralString(n))) -> tpe
              )

              val mmm = new TypeRewriter(mm).visitTsMemberFunction(rewrites)(mm)
              mmm
          }

        fs match {
          case Nil => Seq(m)
          case nonEmpty =>
            scope.logger.info(s"Expanding ${nonEmpty.size} members for $name")
            nonEmpty
        }
      case other => Seq(other)
    }

  def newContainerMembers(scope: TsTreeScope, members: Seq[TsContainerOrDecl]): Seq[TsContainerOrDecl] =
    members flatMap {
      case m @ TsDeclFunction(_, _, name, sig @ TsFunSig(_, IndexedTypeParams(indexed, rest), _, _), _, _) =>
        lazy val mm = m.copy(signature = sig.copy(tparams = rest))

        val fs = AllMembersFor(scope / m, new LoopDetector())(indexed.ref).collect {
          case TsMemberProperty(_, Default, TsIdentSimple(n), Some(tpe), _, false, false, false) =>
            val rewrites = Map[TsType, TsType](
              TsTypeRef.of(indexed.typeParam) -> TsTypeLiteral(TsLiteralString(n)),
              TsTypeLookup(indexed.ref, TsTypeRef.of(indexed.typeParam)) -> tpe
            )

            new TypeRewriter(mm).visitTsDeclFunction(rewrites)(mm)
        }

        fs match {
          case Nil => Seq(m)
          case nonEmpty =>
            scope.logger.info(s"Expanding ${nonEmpty.size} members for $name")
            nonEmpty
        }
      case other => Seq(other)
    }
}
