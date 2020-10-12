package org.scalablytyped.converter.internal
package scalajs
package transforms

object ModulesSimplify extends TreeTransformation {
  override def leaveContainerTree(scope: TreeScope)(c: ContainerTree): ContainerTree =
    simplifyModules(c)

  object Legal {
    def unapply(annotations: IArray[Annotation]): Boolean =
      annotations.forall {
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

  def simplifyModules[C <: ContainerTree](c: C): C = {
    val withSimplifiedMembers: IArray[Tree] =
      c.members.flatMap {
        case ModuleTree(annotations @ Legal(), name, Empty, AllCalls(applies), comments, codePath, isOverride) =>
          applies.map(a =>
            a.copy(
              annotations = annotations,
              name        = name,
              codePath    = codePath,
              isOverride  = isOverride,
              comments    = a.comments ++ comments,
            ),
          )
        case ModuleTree(annotations @ Legal(), name, parents, Empty, comments, codePath, isOverride)
            if parents.nonEmpty =>
          IArray(
            FieldTree(
              annotations,
              name,
              tpe        = TypeRef.Intersection(parents, NoComments),
              impl       = ExprTree.native,
              isReadOnly = true,
              isOverride = isOverride,
              comments   = comments,
              codePath   = codePath,
            ),
          )
        case other => IArray(other)
      }

    c.withMembers(withSimplifiedMembers).asInstanceOf[C]
  }
}
