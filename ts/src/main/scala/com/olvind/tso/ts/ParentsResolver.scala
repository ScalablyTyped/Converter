package com.olvind.tso
package ts

import com.olvind.tso.ts.CodePath.NoPath

import scala.collection.mutable

/**
  * @deprecated this presumes that parents can always be `Seq[InterfaceOrClass]`.
  *
  * Once we factor in type aliases with arbitrary type manipulations that is hardly true,
  *  so we'll need a much better approach here
  */
object ParentsResolver {
  type InterfaceOrClass = TsTree with HasClassMembers

  case class WithParents[X <: InterfaceOrClass](value: X, parents: Seq[InterfaceOrClass])

  def apply[X <: InterfaceOrClass](_scope: TreeScope, tree: X): WithParents[X] = {

    val seen: mutable.ArrayBuffer[TsTree] =
      mutable.ArrayBuffer()

    val allParents: mutable.ArrayBuffer[InterfaceOrClass] =
      mutable.ArrayBuffer()

    def innerRecurse(scope: TreeScope, qualifiedName: TsQIdent, currentTParams: Seq[TsType]): Unit =
      scope.lookupTypeIncludeScope(qualifiedName) foreach {
        case (cls: TsDeclClass, foundInScope) =>
          if (seen forall (_ ne cls)) {
            seen += cls
            val rewritten = FillInTParams(cls, currentTParams)
            allParents += rewritten
            outerRecurse(foundInScope, rewritten)
          }

        case (int: TsDeclInterface, foundInScope) =>
          if (seen forall (_ ne int)) {
            seen += int
            val rewritten = FillInTParams(int, currentTParams)
            allParents += rewritten
            outerRecurse(foundInScope, rewritten)
          }

        case (ta: TsDeclTypeAlias, foundInScope) =>
          if (seen forall (_ ne ta)) {
            seen += ta
            FillInTParams(ta, currentTParams).alias match {
              case _: TsTypeFunction => innerRecurse(foundInScope, TsQIdent.Function, Nil)
              case x: TsTypeRef => innerRecurse(foundInScope, x.name, x.tparams)
              case x: TsTypeObject =>
                allParents += TsDeclInterface(NoComments, declared = false, TsIdent.dummy, Nil, Nil, x.members, NoPath)
              case TsTypeUnion(types) =>
                types foreach {
                  case TsTypeRef(tpe, targs) => innerRecurse(scope, tpe, targs)
                  case _                     => ()
                }
              case TsTypeIntersect(types) =>
                types foreach {
                  case TsTypeRef(tpe, targs) => innerRecurse(scope, tpe, targs)
                  case _                     => ()
                }
              case _: TsTypeConstructor => ()
              case _: TsTypeTuple       => ()
              case other => scope.logger.fatal(s"Unexpected: $other")
            }
          }

        case _ => ()
      }

    def outerRecurse(scope: TreeScope, tree: TsTree): Unit = {
      val parentRefs: Seq[TsTypeRef] =
        tree match {
          case x: TsDeclInterface => x.inheritance
          case x: TsDeclClass     => x.parent.to[Seq] ++ x.implements
          case _ => Nil
        }

      parentRefs.foreach {
        case TsTypeRef(tpe, targs) => innerRecurse(scope, tpe, targs)
      }
    }

    outerRecurse(_scope, tree)

    WithParents(tree, allParents.to[Seq])
  }
}
