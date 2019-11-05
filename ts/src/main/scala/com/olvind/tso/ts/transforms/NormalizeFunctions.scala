package com.olvind.tso
package ts
package transforms

import seqs._

/**
  * To give the scala compiler a fighting chance, we will have to rewrite things like this:
  * ```typescript
  * class Foo {
  *   bar: () => string
  * }
  * ```
  * into things like
  * ```typescript
  * class Foo {
  *   bar(): string
  * }
  * ```
  *
  * The reason is that Typescript allows overriding things in this manner, while the scala compiler obviously doesnt.
  *
  *
  * Also rewrite optional methods to properties, since scala has no such concept
  *
  */
object NormalizeFunctions extends TransformMembers with TransformClassMembers {
  object ToRewrite {
    def unapply(tpe: TsType): Option[Seq[TsFunSig]] =
      tpe match {
        case TsTypeObject(_, members) if members.nonEmpty =>
          members.partitionCollect { case x: TsMemberCall => x.signature } match {
            case (calls, Nil) => Some(calls)
            case _            => None
          }
        case TsTypeFunction(sig) => Some(List(sig))
        case _                   => None
      }
  }

  override def newClassMembers(scope: TsTreeScope, x: HasClassMembers): Seq[TsMember] =
    x.members.flatMap {
      case m @ TsMemberFunction(comments, level, name, signature, isStatic, _, true) =>
        List(
          TsMemberProperty(
            comments,
            level,
            name,
            Some(TsTypeFunction(signature)),
            None,
            isStatic,
            m.isReadOnly,
            m.isOptional,
          ),
        )
      case TsMemberProperty(cs, level, name, Some(ToRewrite(sigs)), None, isStatic, isReadOnly, isOptional) =>
        sigs.map(sig => TsMemberFunction(cs, level, name, sig, isStatic, isReadOnly, isOptional))
      case other => List(other)
    }

  override def enterTsExporteeTree(t: TsTreeScope)(x: TsExporteeTree): TsExporteeTree =
    rewriteDecl(x.decl) match {
      case Seq(one) => x.copy(decl = one)
      case _        => x
    }

  def newMembers(scope: TsTreeScope, x: TsContainer): Seq[TsContainerOrDecl] =
    x.members flatMap {
      case decl: TsDecl => rewriteDecl(decl)
      case other => List(other)
    }

  override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case TsTypeObject(_, Seq(TsMemberCall(_, _, sig))) => TsTypeFunction(sig)
      case other                                         => other
    }

  private def rewriteDecl(d: TsDecl): Seq[TsDecl] =
    d match {
      case TsDeclVar(cs, declared, true, name, Some(ToRewrite(sigs)), None, jsLocation, codePath, _) =>
        sigs.map(sig => TsDeclFunction(cs, declared, name, sig, jsLocation, codePath))
      case other => List(other)
    }
}
