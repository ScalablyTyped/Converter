package com.olvind.tso
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

  override def newClassMembers(scope: TsTreeScope, x: HasClassMembers): Seq[TsMember] =
    x.members.map {
      case m @ TsMemberFunction(comments, level, name, signature, isStatic, _, true) =>
        TsMemberProperty(comments,
                         level,
                         name,
                         Some(TsTypeFunction(signature)),
                         None,
                         isStatic,
                         m.isReadOnly,
                         m.isOptional)
      case TsMemberProperty(cs, level, name, Some(TsTypeFunction(sig)), None, isStatic, isReadOnly, isOptional) =>
        TsMemberFunction(cs, level, name, sig, isStatic, isReadOnly, isOptional)
      case other => other
    }

  override def enterTsExporteeTree(t: TsTreeScope)(x: TsExporteeTree): TsExporteeTree =
    x.copy(decl = rewriteDecl(x.decl))

  def newMembers(scope: TsTreeScope, x: TsContainer): Seq[TsContainerOrDecl] =
    x.members map {
      case decl: TsDecl => rewriteDecl(decl)
      case other => other
    }

  private def rewriteDecl(d: TsDecl): TsDecl =
    d match {
      case TsDeclVar(cs, declared, true, name, Some(TsTypeFunction(sig)), None, jsLocation, codePath, false) =>
        TsDeclFunction(cs, declared, name, sig, jsLocation, codePath)
      case other => other
    }
}
