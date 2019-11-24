package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.seqs._

/**
  * Account for an... interesting case of piece of modelling. We'll fix it some day, but for now I doubled down on it.
  * There are reasons for this, most notably in the implementation of the module system.
  *
  * On the typescript side we merge different syntactical entities by using the `namespaced` name.
  * `{function a(): void; namespace a {const b: number}` =>
  * `{namespace a {function ^(): void, const b: number}`.
  *
  * This undoes the damage.
  */
object RewriteNamespaceMembers {
  def apply(original: Seq[Tree]): (Seq[TypeRef], Seq[MemberTree], Seq[Tree]) =
    original.partitionCollect4(
      { case x: FieldTree if x.name === Name.namespaced     => x },
      { case x: MethodTree if x.name === Name.namespaced    => x },
      { case x: ContainerTree if x.name === Name.namespaced => x },
      { case x: MemberTree                                  => x },
    ) match {
      case (namespacedFields, namespacedMethods, namespacedContainers, memberTrees, remaining) =>
        val inheritance: Seq[TypeRef] = {
          val fromFields = namespacedFields.map(x => x.tpe)
          val fromContainers = namespacedContainers.flatMap {
            case _: PackageTree => Nil
            case ModuleTree(_, _, parents, _, _, _, _) =>
              parents map {
                case TypeRef(QualifiedName.TopLevel, Seq(parent), _) => parent
                case parent                                          => parent
              }
          }
          (fromFields ++ fromContainers).toList.distinct match {
            case Nil => Nil
            /* This is a shortcut so we don't have to implement the members */
            case more => Seq(TypeRef.TopLevel(TypeRef.Intersection(more)))
          }
        }

        val (membersFromContainers, restFromContainers) =
          namespacedContainers.flatMap(_.members).partitionCollect { case x: MemberTree => x }

        val newMemberTrees = {
          val rewrittenMethods = namespacedMethods.map(_.copy(name = Name.APPLY))

          memberTrees ++ rewrittenMethods ++ membersFromContainers
        }

        (inheritance, newMemberTrees, remaining ++ restFromContainers)
    }

}
