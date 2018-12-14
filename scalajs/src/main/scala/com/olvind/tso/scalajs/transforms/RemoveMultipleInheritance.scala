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

  final case class Dropped(typeRef: TypeRef, because: String)

  override def enterClassTree(scope: TreeScope)(cls: ClassTree): ClassTree = {
    val (newComments, newParents) = findNewParents(scope, cls)
    cls.copy(comments = newComments, parents = newParents)
  }

  override def enterModuleTree(scope: TreeScope)(mod: ModuleTree): ModuleTree = {
    val (newComments, newParents) = findNewParents(scope, mod)

    mod.copy(comments = newComments, parents = newParents)
  }

  def findNewParents(scope: TreeScope, cls: ContainerTree): (Comments, List[TypeRef]) = {
    val allParents = ParentsResolver(scope, cls)

    val first     = firstReferringToClass(allParents) orElse longestInheritance(allParents)
    val remaining = first ++ (allParents.directParents filterNot first.contains)

    val (changes, ps) = step(included = Nil, newParents = Nil, dropped = Nil, remaining = remaining.to[List])

    val newComments: Comments =
      if (changes.nonEmpty) {
        val msg = s"Dropped parents ${changes.map(x => formatQN(Nil, x.typeRef.typeName) + " because " + x.because)}"
        scope.logger.info(msg)
        cls.comments + Comment("/* RemoveMultipleInheritance: " + msg + "*/\n")
      } else cls.comments

    (newComments, ps.reverse ::: allParents.unresolved.to[List])
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
              Dropped(h.refs.last, "Inheritance from two classes")
          }

        def alreadyInherits: Option[Dropped] =
          included firstDefined
            (_.transitiveParents.keys.firstDefined(
              i =>
                if (h.refs.exists(_.typeName === i.typeName))
                  Some(Dropped(h.refs.last, "Already inherited"))
                else None
            ))

        def alreadyInheritsUnresolved: Option[Dropped] =
          included firstDefined (_.transitiveUnresolved.firstDefined { u =>
            h.transitiveUnresolved.filter(_.typeName === u.typeName) match {
              case Nil => None
              case some =>
                val someString = some.map(Printer.formatTypeRef(Nil, 0)).mkString(", ")
                Some(Dropped(h.refs.last, s"Already inherited $someString"))
            }
          })

        def inheritsConflictingVars: Option[Dropped] = {
          val includedMutables: Seq[Name] =
            included.flatMap(_.mutableFields).map(_.name)

          val nextMutables: Seq[Name] =
            h.mutableFields.map(_.name)

          includedMutables intersect nextMutables match {
            case Nil => None
            case conflict =>
              val conflictString = conflict.distinct.map(Printer.formatName)
              Some(Dropped(h.refs.last, s"Would inherit conflicting mutable fields $conflictString"))
          }
        }

        inheritsClass orElse
          alreadyInherits orElse
          alreadyInheritsUnresolved orElse
          inheritsConflictingVars match {
          case None =>
            //todo: drop conflicts here

            step(h :: included, h.refs.last :: newParents, dropped, rest)
          case Some(d) => step(included, newParents, d :: dropped, rest)
        }
    }
}
