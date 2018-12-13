package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso.seqs.TraversableOps

/**
  * We filter away unneeded overrides, since they add nothing, and
  * wreck havoc with IDE performance.
  *
  * For fields with name clashes and different types, we rename them.
  * For methods with similar / clashing signatures, we also rename.
  *
  * Note that no subtype calculation is done for now.
  */
object FilterMemberOverrides extends TreeTransformation {

  override def enterClassTree(scope: TreeScope)(s: ClassTree): ClassTree =
    s.copy(members = newMembers(scope, s, s.members))

  override def enterModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    s.copy(members = newMembers(scope, s, s.members))

  override def enterPackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
    s.copy(members = newMembers(scope, s, s.members))

  private def newMembers[S >: MemberTree <: Tree](scope: TreeScope, owner: ContainerTree, members: Seq[S]): Seq[S] = {
    val (methods, fields, other) = members.partitionCollect2(
      { case x: MethodTree => x },
      { case x: FieldTree  => x }
    )
    val methodsByName: Map[Name, Seq[MethodTree]] =
      methods groupBy (_.name)

    val fieldsByName: Map[Name, Seq[FieldTree]] =
      fields.groupBy(_.name)

    val parents: Map[TypeRef, ClassTree] =
      ParentsResolver(scope, owner).transitiveParents

    val (inheritedMethods, inheritedFields, _) =
      (ObjectMembers.members ++ parents.flatMap(_._2.members)).partitionCollect2(
        { case x: MethodTree => x },
        { case x: FieldTree  => x }
      )

    val inheritedFieldsByName: Map[Name, Seq[FieldTree]] =
      inheritedFields groupBy (_.name)

    val inheritedMethodsByBase: Map[MethodBase, Seq[MethodTree]] =
      inheritedMethods groupBy Erasure.base(scope)

    val inheritedMethodsByName: Map[Name, Seq[MethodTree]] =
      inheritedMethods groupBy (_.name)

    val allMethods = inheritedMethodsByName ++ methodsByName
    val allFields  = inheritedFieldsByName ++ fieldsByName

    val newFields: Seq[FieldTree] = fields.flatMap { f =>
      allMethods.get(f.name) match {
        case Some(ms) if ms.exists(_.params.flatten.length === 0) || ObjectMembers.members.exists(_.name === f.name) =>
          Seq(f withSuffix "_F" + owner.name.value)
        case _ =>
          inheritedFieldsByName.get(f.name) match {
            case Some(conflicting: Seq[FieldTree]) =>
              /* but to retain a field with a different type, we rename it */
              val withSuffix = f withSuffix "_" withSuffix owner.name

              if (f.tpe === TypeRef.Any || f.tpe === TypeRef.Nothing || (conflicting exists (_.tpe === f.tpe)))
                /* there is no point in emitting duplicate fields */
                Nil
              else if (allFields.contains(withSuffix.name)) Nil
              else Seq(withSuffix)

            case None =>
              Seq(f)
          }
      }
    }

    val newMethods: Seq[MethodTree] = methods.flatMap { m =>
//        val mErasure = Erasure.erasure(scope)(m)

      if (inheritedFieldsByName.contains(m.name)) Seq(m withSuffix "_M" + owner.name.value)
      else {
        val mBase = Erasure.base(scope)(m)

        inheritedMethodsByBase get mBase match {
          case Some(conflicting @ _) =>
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
    }

    newFields ++ newMethods ++ other
  }
}
