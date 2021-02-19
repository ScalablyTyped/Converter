package org.scalablytyped.converter.internal
package scalajs
package transforms

import maps._

object ModulesCombine extends TreeTransformation {
  override def leaveContainerTree(scope: TreeScope)(c: ContainerTree): ContainerTree =
    combineModules(c)

  def combineModules[C <: ContainerTree](c: C): C = {
    val combinedMembers = c.index.flatMapToIArray {
      case (name, sameName) =>
        sameName.partitionCollect3({ case x: ModuleTree => x }, { case x: FieldTree => x }, { case x: MethodTree => x }) match {
          case (IArray.headTail(baseModule, restModules), fields, methods, rest)
              if fields.nonEmpty || methods.nonEmpty || restModules.nonEmpty =>
            val asHats: IArray[FieldTree] =
              fields.map(f =>
                f.copy(
                  name       = Name.namespaced,
                  codePath   = baseModule.codePath + Name.namespaced,
                  isReadOnly = true,
                ),
              )

            val asApplies: IArray[MethodTree] =
              methods.map(m => m.copy(name = Name.APPLY, codePath = baseModule.codePath + Name.APPLY))

            val mergedCompanion: ModuleTree =
              restModules.foldLeft(baseModule.copy(members = baseModule.members ++ asHats ++ asApplies)) {
                case (acc, mod) =>
                  ModuleTree(
                    annotations = acc.annotations,
                    name        = acc.name,
                    parents     = (acc.parents ++ mod.parents).distinct,
                    members     = (acc.members ++ mod.members).distinct,
                    comments    = acc.comments ++ mod.comments,
                    codePath    = acc.codePath,
                    isOverride  = false,
                  )
              }

            mergedCompanion +: rest

          case (
              IArray.exactlyOne(
                ModuleTree(annotations @ Legal(), name, Empty, AllCalls(applies), comments, codePath, isOverride),
              ),
              Empty,
              Empty,
              rest,
              ) =>
            rest ++ applies.map(a =>
              a.copy(
                annotations = annotations,
                name        = name,
                codePath    = codePath,
                isOverride  = isOverride,
                comments    = a.comments ++ comments,
              ),
            )

          case (
              IArray.exactlyOne(
                ModuleTree(annotations @ Legal(), name, parents, Empty, comments, codePath, isOverride),
              ),
              Empty,
              Empty,
              rest,
              ) if parents.nonEmpty =>
            val asField = FieldTree(
              annotations,
              name,
              tpe        = TypeRef.Intersection(parents, NoComments),
              impl       = ExprTree.native,
              isReadOnly = true,
              isOverride = isOverride,
              comments   = comments,
              codePath   = codePath,
            )

            rest :+ asField

          case (Empty, Empty, methods, rest) if methods.nonEmpty && rest.exists(_.isInstanceOf[ClassTree]) =>
            val asApplies: IArray[MethodTree] =
              methods.map(m => m.copy(name = Name.APPLY, codePath = m.codePath + Name.APPLY))

            val asMod = ModuleTree(
              annotations = Empty,
              name        = name,
              parents     = Empty,
              members     = asApplies,
              comments    = NoComments,
              codePath    = methods.head.codePath,
              isOverride  = false,
            )

            asMod +: rest

          case _ => sameName
        }
    }

    c.withMembers(combinedMembers).asInstanceOf[C]
  }

  object Legal {
    def unapply(annotations: IArray[Annotation]): Boolean =
      annotations.nonEmpty && annotations.forall {
        case Annotation.JsImport(_, imported, _) =>
          imported match {
            case Imported.Namespace => false
            case Imported.Default   => false
            case Imported.Named(_)  => true
          }
        case _ => true
      }
  }

  object AllCalls {
    def unapply(members: IArray[Tree]): Option[IArray[MethodTree]] =
      members.partitionCollect { case x: MethodTree if x.name === Name.APPLY => x } match {
        case (applies, Empty) if applies.nonEmpty => Some(applies)
        case _                                    => None
      }
  }

}
