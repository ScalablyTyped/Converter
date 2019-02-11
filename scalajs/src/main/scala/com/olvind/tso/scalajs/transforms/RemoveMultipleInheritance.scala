package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso.scalajs.ParentsResolver.{Parent, Parents}
import com.olvind.tso.scalajs.Printer.formatQN
import com.olvind.tso.seqs._

/**
  * Sort parents to ensure that if we inherit from a class it
  *  goes first, and traits are mixins
  */
object RemoveMultipleInheritance extends TreeTransformation {

  final case class Dropped(typeRef: TypeRef, because: String, members: Seq[MemberTree])

  override def enterClassTree(scope: TreeScope)(cls: ClassTree): ClassTree = {
    val (newComments, newParents, newMembers) = findNewParents(scope, cls)
    val patchedNewMembers =
      if (cls.annotations.contains(JsNative)) newMembers.map {
        case x: MethodTree => x.copy(impl = MemberImplNative)
        case x: FieldTree  => x.copy(impl = MemberImplNative)
      } else newMembers

    cls.copy(comments = newComments, parents = newParents, members = cls.members ++ patchedNewMembers)
  }

  override def enterModuleTree(scope: TreeScope)(mod: ModuleTree): ModuleTree = {
    val (newComments, newParents, newMembers) = findNewParents(scope, mod)
    mod.copy(comments = newComments, parents = newParents, members = mod.members ++ newMembers)
  }

  def findNewParents(scope: TreeScope, c: InheritanceTree): (Comments, List[TypeRef], List[MemberTree]) = {
    val allParents    = ParentsResolver(scope, c)
    val first         = firstReferringToClass(allParents) orElse longestInheritance(allParents)
    val remaining     = first ++ (allParents.directParents filterNot first.contains)
    val (changes, ps) = step(included = Nil, newParents = Nil, dropped = Nil, remaining = remaining.to[List])

    val newComments: Comments =
      if (changes.nonEmpty) {
        val msg =
          s"Dropped parents ${changes.map(x => s"- ${formatQN(Nil, x.typeRef.typeName)} because ${x.because}").mkString("\n", "", "")}"
        scope.logger.info(msg)
        c.comments + Comment.warning(msg)
      } else c.comments

    (newComments, ps.reverse ::: allParents.unresolved.to[List], changes.flatMap(_.members))
  }

  def longestInheritance(parents: Parents): Option[Parent] =
    if (parents.directParents.nonEmpty)
      Some(parents.directParents.maxBy(_.transitiveParents.size))
    else None

  def firstReferringToClass(parents: Parents): Option[Parent] =
    parents.directParents.find(
      p =>
        p.transitiveParents.exists {
          case (_, cs) => cs.classType === ClassType.Class || cs.classType === ClassType.AbstractClass
          case _       => false
      }
    )

  def step(included:   List[Parent],
           newParents: List[TypeRef],
           dropped:    List[Dropped],
           remaining:  List[Parent]): (List[Dropped], List[TypeRef]) =
    remaining match {
      case Nil =>
        (dropped, newParents)
      case h :: rest =>
        def inheritsClass: Option[Dropped] =
          h.transitiveParents.collectFirst {
            case (_, c)
                if included.nonEmpty && c.classType =/= ClassType.Trait && !included.exists(
                  _.transitiveParents.exists(_._2 === c)
                ) =>
              val includedFields: Seq[Name] =
                (/* baseMembers ++ */ dropped.flatMap(_.members) ++ included.flatMap(_.fields)).map(_.name)

              val inlined = h.classTree.members.filterNot(m => includedFields.contains(m.name))
              Dropped(h.refs.last,
                      s"Inheritance from two classes. Inlined ${inlined.map(_.name.value).mkString(", ")}",
                      inlined)
          }

        def alreadyInherits: Option[Dropped] =
          included firstDefined
            (_.transitiveParents.keys.firstDefined(
              i =>
                if (h.refs.exists(_.typeName === i.typeName))
                  Some(Dropped(h.refs.last, "Already inherited", Nil))
                else None
            ))

        def alreadyInheritsUnresolved: Option[Dropped] =
          included firstDefined (_.transitiveUnresolved.firstDefined { u =>
            h.transitiveUnresolved.filter(_.typeName === u.typeName) match {
              case Nil => None
              case some =>
                val someString = some.map(Printer.formatTypeRef(Nil, 0)).mkString(", ")
                Some(Dropped(h.refs.last, s"Already inherited $someString", Nil))
            }
          })

        def inheritsConflictingVars: Option[Dropped] = {
          val includedFields: Seq[Name] =
            (/* baseMembers ++ */ dropped.flatMap(_.members) ++ included.flatMap(_.fields)).map(_.name)

          val nextMutables: Seq[Name] =
            h.mutableFields.map(_.name)

          includedFields intersect nextMutables match {
            case Nil => None
            case conflict =>
              val conflictString = conflict.distinct.sortBy(_.unescaped).map(Printer.formatName).mkString(", ")
              val inlined        = h.classTree.members.filterNot(m => includedFields.contains(m.name))
              Some(
                Dropped(
                  h.refs.last,
                  s"var conflicts: $conflictString. Inlined ${inlined.map(_.name.value).mkString(", ")}",
                  inlined
                )
              )
          }
        }

        inheritsClass orElse
          alreadyInherits orElse
          alreadyInheritsUnresolved orElse
          inheritsConflictingVars match {
          case None    => step(h :: included, h.refs.last :: newParents, dropped, rest)
          case Some(d) => step(included, newParents, d :: dropped, rest)
        }
    }
}
