package org.scalablytyped.converter.internal
package scalajs
package transforms

import scala.collection.mutable

/**
  * Scala is again more strict with inheritance with differing type parameters,
  * and we only augment the problem by freely tagging things as instantiatable and
  * dictionaries in the import.
  *
  * todo: merge with `RemoveMultipleInheritance`?
  */
class RemoveDuplicateInheritance(parentsResolver: ParentsResolver) extends TreeTransformation {
  override def leaveClassTree(scope: TreeScope)(_s: ClassTree): ClassTree = {
    val s = dropInheritedConflicts(scope, _s)
    conflicts(s.parents).fold(s)(conflicts => s.copy(parents = resolved(s.parents, conflicts)))
  }

  override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    conflicts(s.parents).fold(s)(conflicts => s.copy(parents = resolved(s.parents, conflicts)))

  def conflicts(parents: IArray[TypeRef]): Option[Map[QualifiedName, IArray[TypeRef]]] =
    Option(parents.groupBy(_.typeName).filter(_._2.lengthCompare(1) > 0)).filter(_.nonEmpty)

  def resolved(parents: IArray[TypeRef], conflicts: Map[QualifiedName, IArray[TypeRef]]): IArray[TypeRef] = {
    val resolved: Map[QualifiedName, TypeRef] =
      conflicts
        .map {
          case (name, sameParentRef: IArray[TypeRef]) =>
            name -> TypeRef(
              name,
              sameParentRef.map(_.targs).transpose.map(ts => TypeRef.Union(ts, NoComments, true)),
              Comments.flatten(sameParentRef)(_.comments),
            )
        }

    /* take care to keep original order in spite of using a map above */

    val mentioned = mutable.HashSet.empty[QualifiedName]
    parents.mapNotNone {
      case p if conflicts.contains(p.typeName) =>
        if (mentioned.contains(p.typeName)) None
        else {
          mentioned += p.typeName
          Some(resolved(p.typeName))
        }
      case p => Some(p)
    }
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
      parentsResolver(scope, cls).transitiveParents
        .foldLeft(Set.empty[TypeRef])(_ ++ _._2.parents.map(_.copy(targs = Empty)).toSet)

    cls.parents.partition(p => allParentRefs(p.copy(targs = Empty))) match {
      case (Empty, _) => cls
      case (dropped, keep) =>
        scope.logger.info(
          s"Dropped parents ${dropped.map(_.typeName).mkString(",")} at $scope because allParentRefs = $allParentRefs",
        )
        cls.copy(parents = keep)
    }
  }
}
