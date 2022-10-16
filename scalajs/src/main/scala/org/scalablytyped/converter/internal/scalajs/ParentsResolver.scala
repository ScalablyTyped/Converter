package org.scalablytyped.converter.internal
package scalajs

import org.scalablytyped.converter.internal.scalajs.ParentsResolver.{
  findParentRefs,
  recurse,
  typeParams,
  Parents,
  Resolved,
  Unresolved,
}

import scala.collection.mutable

/**
  * @deprecated This doesn't handle any of `Name.Internal`.
  *
  * Ideally we'll handle all of that on the typescript side, but we don't yet
  */
object ParentsResolver {

  sealed trait ParentTree {
    lazy val transitiveParents: Map[TypeRef, ClassTree] =
      this match {
        case Parents(ps, _) => maps.smash(ps.map(_.transitiveParents))
        case x: Parent => x.refs.map(_ -> x.classTree).toMap ++ maps.smash(x.parents.map(_.transitiveParents))
      }

    lazy val transitiveUnresolved: IArray[TypeRef] =
      this match {
        case Parents(ps, us) => us ++ ps.flatMap(_.transitiveUnresolved)
        case x: Parent => x.unresolved ++ x.parents.flatMap(_.transitiveUnresolved)
      }
  }

  case class Parent(refs: IArray[TypeRef])(
      val classTree:      ClassTree,
      val foundIn:        TreeScope,
      val parents:        IArray[Parent],
      val unresolved:     IArray[TypeRef],
  ) extends ParentTree {

    lazy val members: IArray[Tree] =
      parents.flatMap(_.members) ++ classTree.members

    lazy val fields: IArray[FieldTree] =
      members.collect {
        case x: FieldTree => x
      }
  }

  case class Parents(directParents: IArray[Parent], unresolved: IArray[TypeRef]) extends ParentTree {
    def pruneClasses: Parents = {
      def go(it: Parent): Option[Parent] =
        it.classTree match {
          case ClassTree(_, _, _, _, _, _, _, _, ClassType.Class, _, _, _) =>
            None
          case _ =>
            Some(Parent(it.refs)(it.classTree, it.foundIn, it.parents.mapNotNone(go), it.unresolved))
        }
      copy(directParents = directParents.mapNotNone(go))
    }
  }

  private def findParentRefs(tree: InheritanceTree): IArray[TypeRef] =
    tree match {
      case x: ClassTree  => x.parents
      case x: ModuleTree => x.parents
    }

  private def typeParams(tree: InheritanceTree): IArray[TypeParamTree] =
    tree match {
      case x: ClassTree  => x.tparams
      case _: ModuleTree => Empty
    }

  sealed trait Res

  /**
    * Result of conversion error.
    * We handle it since it's not necessary to fail a whole library if one exists
    */
  case object Circular extends Res
  case class Resolved(nr: Parent) extends Res
  /* A primitive doesn't resolve to a `ClassTree`, for instance */
  case class Unresolved(tr: IArray[TypeRef]) extends Res

  private def recurse(
      scope:      TreeScope,
      typeRefs:   List[TypeRef],
      ld:         LoopDetector,
      newTParams: IArray[TypeParamTree],
  ): Res =
    ld.including(typeRefs.head.typeName.parts, scope) match {
      case Left(()) =>
        Circular
      case Right(newLd) =>
        scope
          .lookup(typeRefs.head.typeName)
          .collectFirst {
            case (cls: ClassTree, foundInScope) =>
              val rewritten = FillInTParams(cls, scope, typeRefs.head.targs, newTParams)
              val (parents, unresolved, circular) =
                findParentRefs(rewritten)
                  .map(tr => recurse(foundInScope, tr :: Nil, newLd, newTParams))
                  .partitionCollect2({ case x: Resolved => x }, { case u: Unresolved => u })

              if (circular.nonEmpty) Circular
              else
                Resolved(
                  Parent(IArray.fromTraversable(typeRefs))(
                    rewritten,
                    foundInScope,
                    parents.map(_.nr),
                    unresolved.flatMap(_.tr),
                  ),
                )

            case (ta: TypeAliasTree, foundInScope) =>
              val rewritten = FillInTParams(ta, scope, typeRefs.head.targs, newTParams)

              recurse(foundInScope, rewritten.alias :: typeRefs, newLd, newTParams) match {
                case Unresolved(_) => Unresolved(IArray.fromTraversable(typeRefs))
                case other         => other
              }
          }
          .getOrElse(Unresolved(IArray.fromTraversable(typeRefs)))
    }
}

class ParentsResolver {
  private val cache = mutable.HashMap.empty[IArray[TypeRef], Parents]

  def apply(scope: TreeScope, tree: InheritanceTree): Parents =
    apply(scope, findParentRefs(tree), typeParams(tree))

  @deprecated("", "")
  def apply(scope: TreeScope, parentRefs: IArray[TypeRef]): Parents =
    apply(scope, parentRefs, Empty)

  def apply(scope: TreeScope, parentRefs: IArray[TypeRef], tparams: IArray[TypeParamTree]): Parents = {
    val ld = new LoopDetector

    cache.get(parentRefs) match {
      case Some(cached) => cached
      case None =>
        val (roots, unresolved, _) =
          parentRefs
            .map(tr => recurse(scope, tr :: Nil, ld, tparams))
            .partitionCollect2({ case x: Resolved => x }, { case u: Unresolved => u })

        val ret = Parents(roots.map(_.nr), unresolved.flatMap(_.tr))
        cache(parentRefs) = ret
        ret
    }
  }
}
