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
object NormalizeFunctions extends TreeVisitorScopedChanges {

  override def enterTsDeclClass(t: TreeScope)(x: TsDeclClass): TsDeclClass =
    x.copy(members = newMembers(x.members))

  override def enterTsDeclInterface(t: TreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(members = newMembers(x.members))

  private def newMembers(members: Seq[TsMember]) =
    members.map {
      case m @ TsMemberFunction(comments, level, name, signature, isStatic, _, true) =>
        TsMemberProperty(comments, level, name, Some(TsTypeFunction(signature)), isStatic, m.isReadOnly, m.isOptional)
      case m @ TsMemberProperty(cs, level, name, Some(TsTypeFunction(sig)), isStatic, _, isOptional) =>
        TsMemberFunction(cs, level, name, sig, isStatic, m.isReadOnly, m.isOptional)
      case other => other
    }
}
