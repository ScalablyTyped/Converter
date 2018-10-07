package com.olvind.tso
package scalajs

import seqs._

/**
  * @deprecated This doesn't handle any of `Name.Internal`.
  *
  * Ideally we'll handle all of that on the typescript side, but we don't yet
  */
object ParentsResolver {

  sealed trait ParentTree {
    lazy val transitiveParents: Map[TypeRef, ClassSymbol] =
      this match {
        case Parents(ps, _) => ps.flatMap(_.transitiveParents).toMap
        case x: Parent => Map(x.refs.map(_ -> x.classSymbol): _*) ++ x.parents.flatMap(_.transitiveParents)
      }

    lazy val transitiveUnresolved: Seq[TypeRef] =
      this match {
        case Parents(ps, us) => us ++ ps.flatMap(_.transitiveUnresolved)
        case x: Parent => x.unresolved ++ x.parents.flatMap(_.transitiveUnresolved)
      }
  }

  case class Parent(refs:        Seq[TypeRef],
                    classSymbol: ClassSymbol,
                    foundIn:     SymbolScope,
                    parents:     Seq[Parent],
                    unresolved:  Seq[TypeRef])
      extends ParentTree {

    lazy val members: Seq[MemberSymbol] =
      parents.flatMap(_.members) ++ classSymbol.members

    val mutableFields: Seq[FieldSymbol] =
      members.collect {
        case x: FieldSymbol if !x.isReadOnly => x
      }
  }

  case class Parents(directParents: Seq[Parent], unresolved: Seq[TypeRef]) extends ParentTree {
    def pruneClasses: Parents = {
      def go(it: Parent): Option[Parent] =
        it match {
          case Parent(_, ClassSymbol(_, _, _, _, _, _, ClassType.Class | ClassType.AbstractClass, _, _), _, _, _) =>
            None
          case Parent(refs, cls, scope, ps, us) =>
            Some(Parent(refs, cls, scope, ps.flatMap(go), us))
        }
      copy(directParents = directParents.flatMap(go))
    }
  }

  def apply(scope: SymbolScope, symbol: ContainerSymbol): Parents = {
    val ld = new LoopDetector
    val (roots, unresolved, _) =
      parentRefs(symbol)
        .map(tr => recurse(scope, tr :: Nil, ld))
        .partitionCollect2({ case x: Resolved => x }, { case u: Unresolved => u })

    Parents(roots.map(_.nr), unresolved.flatMap(_.tr))
  }

  private def parentRefs(symbol: ContainerSymbol): Seq[TypeRef] =
    symbol match {
      case x: ClassSymbol  => x.parents
      case x: ModuleSymbol => x.parents
      case _ => Nil
    }

  sealed trait Res

  /**
    * Result of conversion error.
    * We handle it since it's not necessary to fail a whole library if one exists
    */
  case object Circular extends Res
  case class Resolved(nr: Parent) extends Res
  /* A primitive doesn't resolve to a `ClassSymbol`, for instance */
  case class Unresolved(tr: Seq[TypeRef]) extends Res

  private def recurse(scope: SymbolScope, typeRefs: List[TypeRef], ld: LoopDetector): Res =
    ld.including(typeRefs.head.typeName.parts, scope) match {
      case Left(()) =>
        Circular
      case Right(newLd) =>
        (scope lookup typeRefs.head.typeName).headOption match {
          case Some((cls: ClassSymbol, foundInScope)) =>
            val rewritten = FillInTParams(cls, scope, typeRefs.head.targs)
            val (parents, unresolved, circular) =
              parentRefs(rewritten)
                .map(tr => recurse(foundInScope, tr :: Nil, newLd))
                .partitionCollect2({ case x: Resolved => x }, { case u: Unresolved => u })

            if (circular.nonEmpty) Circular
            else
              Resolved(
                Parent(
                  typeRefs,
                  rewritten,
                  foundInScope,
                  parents.map(_.nr),
                  unresolved.flatMap(_.tr)
                )
              )

          case Some((ta: TypeAliasSymbol, foundInScope)) =>
            val rewritten = FillInTParams(ta, scope, typeRefs.head.targs)
            recurse(foundInScope, rewritten.alias :: typeRefs, newLd)

          case _ => Unresolved(typeRefs)
        }

    }
}
