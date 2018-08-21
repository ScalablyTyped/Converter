package com.olvind.tso
package scalajs
package transforms

/**
  * We filter away unneeded overrides, since they add nothing, and
  * wreck havoc with IDE performance.
  *
  * For fields with name clashes and different types, we rename them.
  * For methods with similar / clashing signatures, we also rename.
  *
  * Note that no subtype calculation is done for now.
  */
object FilterMemberOverrides extends SymbolVisitor {

  override def enterClassSymbol(scope: SymbolScope)(s: ClassSymbol): ClassSymbol =
    s.copy(members = newMembers(scope, s, s.members))

  override def enterModuleSymbol(scope: SymbolScope)(s: ModuleSymbol): ModuleSymbol =
    s.copy(members = newMembers(scope, s, s.members))

  override def enterPackageSymbol(scope: SymbolScope)(s: PackageSymbol): PackageSymbol =
    s.copy(members = newMembers(scope, s, s.members))

  private def newMembers[S >: MemberSymbol <: Symbol](scope: SymbolScope, owner: ContainerSymbol, members: Seq[S]) = {
    val parents: Map[TypeRef, ClassSymbol] =
      ParentsResolver(scope, owner).transitiveParents

    val parentMembers = ObjectMembers.members ++ parents.flatMap(_._2.members)

    val inheritedFields: Map[Name, Seq[FieldSymbol]] =
      parentMembers collect { case c: FieldSymbol => c } groupBy (_.name)

    val inheritedMethods = parentMembers collect { case c: MethodSymbol => c }

    val inheritedMethodsByBase: Map[MethodBase, Seq[MethodSymbol]] =
      inheritedMethods groupBy Erasure.base(scope)

    val inheritedMethodsByName: Map[Name, Seq[MethodSymbol]] =
      inheritedMethods groupBy (_.name)

    val newMembers: Seq[S] =
      members flatMap {
        case f: FieldSymbol =>
          if (inheritedMethodsByName.contains(f.name))
            Seq(f withSuffix owner.name)
          else
            inheritedFields.get(f.name) match {
              case Some(conflicting: Seq[FieldSymbol]) =>
                if (f.tpe === TypeRef.Any || f.tpe === TypeRef.Nothing || (conflicting exists (_.tpe === f.tpe)))
                  /* there is no point in emitting duplicate fields */
                  Nil
                else
                  /* but to retain a field with a different type, we rename it */
                  Seq(f withSuffix owner.name)

              case None =>
                Seq(f)
            }

        case m: MethodSymbol =>
          val mErasure = Erasure.erasure(scope)(m)

          if (inheritedFields.contains(m.name)) Seq(m withSuffix owner.name)
          else {
            val mBase = Erasure.base(scope)(m)

            inheritedMethodsByBase get mBase match {
              case Some(conflicting) =>
//                /* there is no point in emitting duplicate methods */
//                if (conflicting exists (c => Erasure.erasure(scope)(c) === mErasure))
//                  Nil
//                /* but to retain a subtly different method, we rename it, and drop completely if it exists in super class  */
//                else {
//                  val newM = m withSuffix owner.name
//                  if (inheritedMethodsByName.contains(newM.name)) Nil
//                  else Seq(newM)
//
//                }
                Nil
              case _ => Seq(m)
            }
          }
        case other => Seq(other)
      }

    newMembers
  }
}
