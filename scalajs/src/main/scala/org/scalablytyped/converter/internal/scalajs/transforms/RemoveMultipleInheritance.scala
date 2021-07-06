package org.scalablytyped.converter.internal
package scalajs
package transforms

import org.scalablytyped.converter.internal.scalajs.ParentsResolver.{Parent, Parents}
import org.scalablytyped.converter.internal.seqs._

/**
  * Sort parents to ensure that if we inherit from a class it
  * goes first, and traits are mixins
  */
class RemoveMultipleInheritance(parentsResolver: ParentsResolver) extends TreeTransformation {

  case class Dropped(typeRef: TypeRef, because: String, members: IArray[Tree])

  override def leaveClassTree(scope: TreeScope)(cls: ClassTree): ClassTree =
    if (cls.isNative) {
      val (newComments, newParents, newMembers) = findNewParents(scope, cls)
      val patchedNewMembers =
        if (cls.annotations.contains(Annotation.JsNative)) newMembers.map {
          case x: MethodTree => x.copy(impl = ExprTree.native, isOverride = false)
          case x: FieldTree  => x.copy(impl = ExprTree.native, isOverride = false)
          case other => other
        }
        else newMembers

      cls.copy(comments = newComments, parents = newParents, members = cls.members ++ patchedNewMembers)

    } else cls

  override def leaveModuleTree(scope: TreeScope)(mod: ModuleTree): ModuleTree =
    if (mod.isNative) {
      val (newComments, newParents, newMembers) = findNewParents(scope, mod)
      mod.copy(comments = newComments, parents = newParents, members = mod.members ++ newMembers)
    } else mod

  def findNewParents(scope: TreeScope, c: InheritanceTree): (Comments, IArray[TypeRef], IArray[Tree]) = {
    val allParents = parentsResolver(scope, c)

    // determine which parent goes first, it needs to be one with a class
    // if no parent inherits a class other than `Any` or `js.Object` and there are more than two parents,
    // add `js.Object` explicitly first to work around https://github.com/lampepfl/dotty/issues/12722
    val foundClassParent = parentWithInheritedClass(allParents).orElse {
      if (allParents.directParents.exists(_.parents.length > 1))
        Some(parentsResolver(scope, IArray(TypeRef.JsObject)).directParents.head)
      else None
    }

    val remaining = IArray.fromOption(foundClassParent) ++ allParents.directParents.filterNot(foundClassParent.contains)

    val (changes, ps) =
      step(
        included         = Empty,
        newParents       = Empty,
        dropped          = IArray.Empty,
        remainingParents = remaining,
      )

    val classParentAnnotation = foundClassParent.map(_ => Marker.HasClassParent)

    val newComments: Comments =
      if (changes.nonEmpty) {
        val formattedChanges = changes
          .map(x => s"- ${Printer.formatQN(x.typeRef.typeName)} because ${x.because}")
          .mkString("\n", "\n", "")
        val msg = s"Dropped parents $formattedChanges"
        scope.logger.info(msg)
        c.comments + Comment.warning(msg) +? classParentAnnotation
      } else c.comments +? classParentAnnotation

    (newComments, ps.reverse ++ allParents.unresolved, changes.flatMap(_.members))
  }

  def parentWithInheritedClass(parents: Parents): Option[Parent] = {
    def go(p: Parent): Option[Parent] =
      if (p.classTree.classType =/= ClassType.Trait &&
          p.classTree.codePath =/= QualifiedName.Any &&
          p.classTree.codePath =/= QualifiedName.JsObject) Some(p)
      else p.parents.firstDefined(go)

    parents.directParents.find(p => go(p).isDefined)
  }

  def step(
      included:         IArray[Parent],
      newParents:       IArray[TypeRef],
      dropped:          IArray[Dropped],
      remainingParents: IArray[Parent],
  ): (IArray[Dropped], IArray[TypeRef]) =
    remainingParents match {
      case IArray.Empty =>
        (dropped, newParents)
      case IArray.headTail(currentParent, rest) =>
        def inheritsClass: Option[Dropped] =
          currentParent.transitiveParents.collectFirst {
            case (_, c)
                if included.nonEmpty &&
                  c.classType =/= ClassType.Trait &&
                  !included.exists(_.transitiveParents.exists(_._2 === c)) =>
              val includedFields: IArray[Name] =
                (/* baseMembers ++ */ dropped.flatMap(_.members) ++ included.flatMap(_.fields)).map(_.name)

              val inlined = currentParent.classTree.members.filterNot(m => includedFields.contains(m.name))

              Dropped(
                currentParent.refs.last,
                s"Inheritance from two classes. Inlined ${inlined.map(_.name.value).mkString(", ")}",
                inlined,
              )
          }

        def alreadyInherits: Option[Dropped] =
          included.firstDefined(
            _.transitiveParents.keys.firstDefined(i =>
              if (currentParent.refs.exists(_.typeName === i.typeName))
                Some(Dropped(currentParent.refs.last, "Already inherited", Empty))
              else None,
            ),
          )

        def alreadyInheritsUnresolved: Option[Dropped] =
          included.firstDefined(_.transitiveUnresolved.firstDefined { u =>
            currentParent.transitiveUnresolved.filter(_.typeName === u.typeName) match {
              case Empty => None
              case some =>
                val someString = some.map(Printer.formatTypeRef(0)).mkString(", ")
                Some(Dropped(currentParent.refs.last, s"Already inherited $someString", Empty))
            }
          })

        def inheritsConflictingVars: Option[Dropped] = {
          val includedMembersByName: Map[Name, Tree] =
            (dropped.flatMap(_.members) ++ included.flatMap(_.members)).map(x => x.name -> x).toMap

          val conflictingFields: IArray[FieldTree] = currentParent.fields.flatMap {
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
              val inlined = currentParent.classTree.members.filterNot(m => includedMembersByName.contains(m.name))
              Some(
                Dropped(
                  currentParent.refs.last,
                  s"var conflicts: $conflictString. Inlined ${inlined.map(_.name.value).mkString(", ")}",
                  inlined,
                ),
              )
          }
        }

        inheritsClass.orElse(alreadyInherits).orElse(alreadyInheritsUnresolved).orElse(inheritsConflictingVars) match {
          case None => step(currentParent +: included, currentParent.refs.last +: newParents, dropped, rest)
          case Some(d) =>
            val newRemaining = currentParent.parents.filterNot(included.contains).filterNot(rest.contains)
            step(included, newParents, d +: dropped, rest ++ newRemaining)
        }
    }
}
