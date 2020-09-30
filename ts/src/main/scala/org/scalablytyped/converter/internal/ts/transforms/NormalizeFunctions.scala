package org.scalablytyped.converter.internal
package ts
package transforms

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
    def unapply(tpe: TsType): Option[IArray[TsFunSig]] =
      tpe match {
        case TsTypeObject(_, members) if members.nonEmpty =>
          members.partitionCollect { case x: TsMemberCall => x.signature } match {
            case (calls, Empty) => Some(calls)
            case _              => None
          }
        case TsTypeFunction(sig) => Some(IArray(sig))
        case _                   => None
      }
  }

  override def newClassMembers(scope: TsTreeScope, x: HasClassMembers): IArray[TsMember] =
    x.members.flatMap {
      case TsMemberProperty(cs, level, name, Some(ToRewrite(sigs)), None, isStatic, isReadOnly) =>
        sigs.map(sig => TsMemberFunction(cs, level, name, MethodType.Normal, sig, isStatic, isReadOnly))
      case other => IArray(other)
    }

  override def enterTsExporteeTree(t: TsTreeScope)(x: TsExporteeTree): TsExporteeTree =
    rewriteDecl(x.decl) match {
      case IArray.exactlyOne(one) => x.copy(decl = one)
      case _                      => x
    }

  def newMembers(scope: TsTreeScope, x: TsContainer): IArray[TsContainerOrDecl] =
    x.members.flatMap {
      case decl: TsDecl => rewriteDecl(decl)
      case other => IArray(other)
    }

  override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case TsTypeObject(_, IArray.exactlyOne(TsMemberCall(_, _, sig))) => TsTypeFunction(sig)
      case other                                                       => other
    }

  private def rewriteDecl(d: TsDecl): IArray[TsDecl] =
    d match {
      case TsDeclVar(cs, declared, true, name, Some(ToRewrite(sigs)), None, jsLocation, codePath) =>
        sigs.map(sig => TsDeclFunction(cs, declared, name, sig, jsLocation, codePath))
      case other => IArray(other)
    }
}
