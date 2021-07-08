package org.scalablytyped.converter.internal
package ts

import org.scalablytyped.converter.internal.ts.CodePath.NoPath

/**
  * @deprecated this presumes that parents can always be `IArray[InterfaceOrClass]`.
  *
  * Once we factor in type aliases with arbitrary type manipulations that is hardly true,
  *  so we'll need a much better approach here
  */
object ParentsResolver {
  type InterfaceOrClass = TsTree with HasClassMembers

  case class WithParents[X <: InterfaceOrClass](value: X, parents: IArray[InterfaceOrClass], unresolved: IArray[TsType])

  def apply[X <: InterfaceOrClass](_scope: TsTreeScope, tree: X): WithParents[X] = {

    val seen: IArray.Builder[TsTree] =
      IArray.Builder.empty

    val allParents: IArray.Builder[InterfaceOrClass] =
      IArray.Builder.empty

    val unresolved: IArray.Builder[TsType] =
      IArray.Builder.empty

    def innerRecurse(scope: TsTreeScope, qualifiedName: TsQIdent, currentTParams: IArray[TsType]): Unit = {
      val found = scope.lookupTypeIncludeScope(qualifiedName)
      if (found.isEmpty) unresolved += TsTypeRef(qualifiedName)

      found.foreach {
        case (cls: TsDeclClass, foundInScope) =>
          if (seen.forall(_ ne cls)) {
            seen += cls
            val rewritten = FillInTParams(cls, currentTParams)
            allParents += rewritten
            outerRecurse(foundInScope, rewritten)
          }

        case (int: TsDeclInterface, foundInScope) =>
          if (seen.forall(_ ne int)) {
            seen += int
            val rewritten = FillInTParams(int, currentTParams)
            allParents += rewritten
            outerRecurse(foundInScope, rewritten)
          }

        case (ta: TsDeclTypeAlias, foundInScope) =>
          if (seen.forall(_ ne ta)) {
            seen += ta
            FillInTParams(ta, currentTParams).alias match {
              case x: TsTypeRef => innerRecurse(foundInScope, x.name, x.tparams)
              case x: TsTypeObject =>
                allParents += TsDeclInterface(
                  NoComments,
                  declared = false,
                  TsIdent.dummy,
                  Empty,
                  Empty,
                  x.members,
                  NoPath,
                )
              case TsTypeUnion(types) =>
                types.foreach {
                  case TsTypeRef(_, tpe, targs) => innerRecurse(scope, tpe, targs)
                  case _                        => ()
                }
              case TsTypeIntersect(types) =>
                types.foreach {
                  case TsTypeRef(_, tpe, targs) => innerRecurse(scope, tpe, targs)
                  case _                        => ()
                }
              case other =>
                unresolved += other
            }
          }

        case _ => unresolved += TsTypeRef(qualifiedName)
      }
    }

    def outerRecurse(scope: TsTreeScope, tree: TsTree): Unit = {
      val parentRefs: IArray[TsTypeRef] =
        tree match {
          case x: TsDeclInterface => x.inheritance
          case x: TsDeclClass     => IArray.fromOption(x.parent) ++ x.implements
          case _ => Empty
        }

      parentRefs.foreach {
        case TsTypeRef(_, tpe, targs) => innerRecurse(scope, tpe, targs)
      }
    }

    outerRecurse(_scope, tree)

    WithParents(tree, allParents.result(), unresolved.result())
  }
}
