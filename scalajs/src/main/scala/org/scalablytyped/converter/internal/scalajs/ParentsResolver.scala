package org.scalablytyped.converter.internal
package scalajs

import org.scalablytyped.converter.internal.seqs._

/**
  * @deprecated This doesn't handle any of `Name.Internal`.
  *
  * Ideally we'll handle all of that on the typescript side, but we don't yet
  */
object ParentsResolver {

  sealed trait ParentTree {
    lazy val transitiveParents: Map[TypeRef, ClassTree] =
      this match {
        case Parents(ps, _) => ps.flatMap(_.transitiveParents).toMap
        case x: Parent => Map(x.refs.map(_ -> x.classTree): _*) ++ x.parents.flatMap(_.transitiveParents)
      }

    lazy val transitiveUnresolved: Seq[TypeRef] =
      this match {
        case Parents(ps, us) => us ++ ps.flatMap(_.transitiveUnresolved)
        case x: Parent => x.unresolved ++ x.parents.flatMap(_.transitiveUnresolved)
      }
  }

  case class Parent(refs: Seq[TypeRef])(
      val classTree:      ClassTree,
      val foundIn:        TreeScope,
      val parents:        Seq[Parent],
      val unresolved:     Seq[TypeRef],
  ) extends ParentTree {

    lazy val members: Seq[Tree] =
      parents.flatMap(_.members) ++ classTree.members

    lazy val fields: Seq[FieldTree] =
      members.collect {
        case x: FieldTree => x
      }
  }

  case class Parents(directParents: Seq[Parent], unresolved: Seq[TypeRef]) extends ParentTree {
    def pruneClasses: Parents = {
      def go(it: Parent): Option[Parent] =
        it.classTree match {
          case ClassTree(_, _, _, _, _, _, ClassType.Class | ClassType.AbstractClass, _, _, _) =>
            None
          case _ =>
            Some(Parent(it.refs)(it.classTree, it.foundIn, it.parents.flatMap(go), it.unresolved))
        }
      copy(directParents = directParents.flatMap(go))
    }
  }

  def apply(scope: TreeScope, tree: InheritanceTree): Parents = {
    val ld = new LoopDetector
    val (roots, unresolved, _) =
      parentRefs(tree)
        .map(tr => recurse(scope, tr :: Nil, ld, typeParams(tree)))
        .partitionCollect2({ case x: Resolved => x }, { case u: Unresolved => u })

    Parents(roots.map(_.nr), unresolved.flatMap(_.tr))
  }

  private def parentRefs(tree: InheritanceTree): Seq[TypeRef] =
    tree match {
      case x: ClassTree  => x.parents
      case x: ModuleTree => x.parents
    }

  private def typeParams(tree: InheritanceTree): Seq[TypeParamTree] =
    tree match {
      case x: ClassTree  => x.tparams
      case _: ModuleTree => Nil
    }

  sealed trait Res

  /**
    * Result of conversion error.
    * We handle it since it's not necessary to fail a whole library if one exists
    */
  case object Circular extends Res
  case class Resolved(nr: Parent) extends Res
  /* A primitive doesn't resolve to a `ClassTree`, for instance */
  case class Unresolved(tr: Seq[TypeRef]) extends Res

  private def recurse(
      scope:      TreeScope,
      typeRefs:   List[TypeRef],
      ld:         LoopDetector,
      newTParams: Seq[TypeParamTree],
  ): Res =
    ld.including(typeRefs.head.typeName.parts, scope) match {
      case Left(()) =>
        Circular
      case Right(newLd) =>
        (scope lookup typeRefs.head.typeName).collectFirst {
          case (cls: ClassTree, foundInScope) =>
            val rewritten = FillInTParams(cls, scope, typeRefs.head.targs, newTParams)
            val (parents, unresolved, circular) =
              parentRefs(rewritten)
                .map(tr => recurse(foundInScope, tr :: Nil, newLd, newTParams))
                .partitionCollect2({ case x: Resolved => x }, { case u: Unresolved => u })

            if (circular.nonEmpty) Circular
            else
              Resolved(
                Parent(typeRefs)(
                  rewritten,
                  foundInScope,
                  parents.map(_.nr),
                  unresolved.flatMap(_.tr),
                ),
              )

          case (ta: TypeAliasTree, foundInScope) =>
            val rewritten = FillInTParams(ta, scope, typeRefs.head.targs, newTParams)
            recurse(foundInScope, rewritten.alias :: typeRefs, newLd, newTParams)
        } getOrElse Unresolved(typeRefs)
    }
}
