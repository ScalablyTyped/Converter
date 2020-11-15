package org.scalablytyped.converter.internal
package scalajs
package transforms

import org.scalablytyped.converter.internal.scalajs.ParentsResolver.{Parent, Parents}
import org.scalablytyped.converter.internal.seqs._

/** Sort parents to ensure that if we inherit from a class it
  * goes first, and traits are mixins
  */
class RemoveMultipleInheritance(parentsResolver: ParentsResolver) extends TreeTransformation {

  case class Dropped(typeRef: TypeRef, because: String, members: IArray[Tree])

  override def leaveClassTree(scope: TreeScope)(cls: ClassTree): ClassTree = {
    val (newComments, newParents, newMembers) = findNewParents(scope, cls)
    val patchedNewMembers =
      if (cls.annotations.contains(Annotation.JsNative)) newMembers.map {
        case x: MethodTree => x.copy(impl = ExprTree.native, isOverride = false)
        case x: FieldTree  => x.copy(impl = ExprTree.native, isOverride = false)
        case other => other
      }
      else newMembers

    cls.copy(comments = newComments, parents = newParents, members = cls.members ++ patchedNewMembers)
  }

  override def leaveModuleTree(scope: TreeScope)(mod: ModuleTree): ModuleTree = {
    val (newComments, newParents, newMembers) = findNewParents(scope, mod)
    mod.copy(comments = newComments, parents = newParents, members = mod.members ++ newMembers)
  }

  def findNewParents(scope: TreeScope, c: InheritanceTree): (Comments, IArray[TypeRef], IArray[Tree]) = {
    val allParents = parentsResolver(scope, c)
    val first      = firstReferringToClass(allParents).orElse(longestInheritance(allParents))
    val remaining  = IArray.fromOption(first) ++ (allParents.directParents.filterNot(first.contains))
    val (changes, ps) =
      step(included = IArray.Empty, newParents = IArray.Empty, dropped = IArray.Empty, remaining = remaining)

    val newComments: Comments =
      if (changes.nonEmpty) {
        val msg =
          s"Dropped parents ${changes.map(x => s"- ${Printer.formatQN(x.typeRef.typeName)} because ${x.because}").mkString("\n", "\n", "")}"
        scope.logger.info(msg)
        c.comments + Comment.warning(msg)
      } else c.comments

    (newComments, ps.reverse ++ allParents.unresolved, changes.flatMap(_.members))
  }

  def longestInheritance(parents: Parents): Option[Parent] =
    if (parents.directParents.nonEmpty)
      Some(parents.directParents.maxBy(_.transitiveParents.size))
    else None

  def firstReferringToClass(parents: Parents): Option[Parent] =
    parents.directParents.find(p =>
      p.transitiveParents.exists {
        case (_, cs) => cs.classType =/= ClassType.Trait
        case _       => false
      },
    )

  def step(
      included:   IArray[Parent],
      newParents: IArray[TypeRef],
      dropped:    IArray[Dropped],
      remaining:  IArray[Parent],
  ): (IArray[Dropped], IArray[TypeRef]) =
    remaining match {
      case IArray.Empty =>
        (dropped, newParents)
      case IArray.headTail(h, rest) =>
        def inheritsClass: Option[Dropped] =
          h.transitiveParents.collectFirst {
            case (_, c)
                if included.nonEmpty && c.classType =/= ClassType.Trait && !included.exists(
                  _.transitiveParents.exists(_._2 === c),
                ) =>
              val includedFields: IArray[Name] =
                (/* baseMembers ++ */ dropped.flatMap(_.members) ++ included.flatMap(_.fields)).map(_.name)

              val inlined = h.classTree.members.filterNot(m => includedFields.contains(m.name))

              Dropped(
                h.refs.last,
                s"Inheritance from two classes. Inlined ${inlined.map(_.name.value).mkString(", ")}",
                inlined,
              )
          }

        def alreadyInherits: Option[Dropped] =
          included.firstDefined(
            _.transitiveParents.keys.firstDefined(i =>
              if (h.refs.exists(_.typeName === i.typeName))
                Some(Dropped(h.refs.last, "Already inherited", Empty))
              else None,
            ),
          )

        def alreadyInheritsUnresolved: Option[Dropped] =
          included.firstDefined(_.transitiveUnresolved.firstDefined { u =>
            h.transitiveUnresolved.filter(_.typeName === u.typeName) match {
              case Empty => None
              case some =>
                val someString = some.map(Printer.formatTypeRef(0)).mkString(", ")
                Some(Dropped(h.refs.last, s"Already inherited $someString", Empty))
            }
          })

        def inheritsConflictingVars: Option[Dropped] = {
          val includedMembersByName: Map[Name, Tree] =
            (dropped.flatMap(_.members) ++ included.flatMap(_.members)).map(x => x.name -> x).toMap

          val conflictingFields: IArray[FieldTree] = h.fields.flatMap {
            case f if !f.isReadOnly && includedMembersByName.contains(f.name) => IArray(f)
            case f =>
              includedMembersByName.get(f.name) match {
                case Some(existing) =>
                  existing match {
                    case existingField: FieldTree => if (existingField.isReadOnly) Empty else IArray(f)
                    case _ => IArray(f)
                  }
                case None => Empty
              }
          }

          conflictingFields match {
            case Empty => None
            case conflict =>
              val conflictString =
                conflict.map(_.name).distinct.sortBy(_.unescaped).map(Printer.formatName).mkString(", ")
              val inlined = h.classTree.members.filterNot(m => includedMembersByName.contains(m.name))
              Some(
                Dropped(
                  h.refs.last,
                  s"var conflicts: $conflictString. Inlined ${inlined.map(_.name.value).mkString(", ")}",
                  inlined,
                ),
              )
          }
        }

        inheritsClass.orElse(alreadyInherits).orElse(alreadyInheritsUnresolved).orElse(inheritsConflictingVars) match {
          case None => step(h +: included, h.refs.last +: newParents, dropped, rest)
          case Some(d) =>
            val newRemaining = h.parents.filterNot(included.contains).filterNot(rest.contains)
            step(included, newParents, d +: dropped, rest ++ newRemaining)
        }
    }
}
