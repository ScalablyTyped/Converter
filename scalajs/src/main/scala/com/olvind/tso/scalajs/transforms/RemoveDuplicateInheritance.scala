package com.olvind.tso
package scalajs.transforms

import com.olvind.tso.scalajs._

/**
  * Scala is again more strict with inheritance with differing type parameters,
  *  and we only augment the problem by freely tagging things as instantiatable and
  *  dictionaries in the import.
  *
  *  todo: merge with `RemoveMultipleInheritance`?
  */
object RemoveDuplicateInheritance extends TreeTransformation {
  override def enterClassTree(scope: TreeScope)(_s: ClassTree): ClassTree = {
    val s = dropInheritedConflicts(scope, _s)
    conflicts(s.parents).fold(s)(conflicts => s.copy(parents = resolved(s.parents, conflicts)))
  }

  override def enterModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    conflicts(s.parents).fold(s)(conflicts => s.copy(parents = resolved(s.parents, conflicts)))

  def conflicts(parents: Seq[TypeRef]): Option[Map[QualifiedName, Seq[TypeRef]]] =
    Option(parents groupBy (_.typeName) filter (_._2.lengthCompare(1) > 0)) filter (_.nonEmpty)

  def resolved(parents: Seq[TypeRef], conflicts: Map[QualifiedName, Seq[TypeRef]]): Seq[TypeRef] = {
    val resolved: Iterable[TypeRef] =
      conflicts map {
        case (name, sameParentRef: Seq[TypeRef]) =>
          TypeRef(
            name,
            sameParentRef.map(_.targs).transpose.map(ts => TypeRef.Union(ts, true)),
            Comments.flatten(sameParentRef)(_.comments),
          )
      }

    parents.filterNot(p => conflicts.contains(p.typeName)) ++ resolved
  }

  /**
    *
    * Say we get `FooBar` here. Given a conflict like this:
    * ```typescript
    *   interface Foo extends I<number> {}
    *   interface FooBar extends Foo, I<string>
    * ```
    * we have no choice other than to drop the second dependency upon `I` entirely.
    *
    * Note that:
    * 1) we depend upon parent references to be fully qualified for now
    * 2) type params of the conflicts might be compatible, but we remove anyway
    */
  def dropInheritedConflicts(scope: TreeScope, cls: ClassTree): ClassTree = {
    val allParentRefs: Set[TypeRef] =
      ParentsResolver(scope, cls).transitiveParents
        .foldLeft(Set.empty[TypeRef])(
          _ ++ _._2.parents.map(_.copy(targs = Nil)),
        )

    cls.parents.partition(p => allParentRefs(p.copy(targs = Nil))) match {
      case (Nil, _) => cls
      case (dropped, keep) =>
        scope.logger.info(
          s"Dropped parents ${dropped map (_.typeName) mkString ","} at $scope because allParentRefs = $allParentRefs",
        )
        cls.copy(parents = keep)
    }
  }
}
