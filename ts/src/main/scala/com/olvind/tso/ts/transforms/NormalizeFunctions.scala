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
object NormalizeFunctions extends TreeTransformationScopedChanges {

  override def enterTsDeclClass(scope: TsTreeScope)(x: TsDeclClass): TsDeclClass =
    x.copy(members = newMembers(x.members))

  override def enterTsDeclInterface(scope: TsTreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(members = newMembers(x.members))

  private def newMembers(members: Seq[TsMember]): Seq[TsMember] =
    members.map {
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

  override def enterTsParsedFile(scope: TsTreeScope)(x: TsParsedFile): TsParsedFile =
    x.copy(members = newContainerMembers(x.members))
  override def enterTsDeclModule(scope: TsTreeScope)(x: TsDeclModule): TsDeclModule =
    x.copy(members = newContainerMembers(x.members))
  override def enterTsDeclNamespace(scope: TsTreeScope)(x: TsDeclNamespace): TsDeclNamespace =
    x.copy(members = newContainerMembers(x.members))
  override def enterTsAugmentedModule(scope: TsTreeScope)(x: TsAugmentedModule): TsAugmentedModule =
    x.copy(members = newContainerMembers(x.members))
  override def enterTsDeclGlobal(scope: TsTreeScope)(x: TsGlobal): TsGlobal =
    x.copy(members = newContainerMembers(x.members))

  override def enterTsExporteeTree(t: TsTreeScope)(x: TsExporteeTree): TsExporteeTree =
    x.copy(decl = rewriteDecl(x.decl))

  private def newContainerMembers(members: Seq[TsContainerOrDecl]): Seq[TsContainerOrDecl] = members map {
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
