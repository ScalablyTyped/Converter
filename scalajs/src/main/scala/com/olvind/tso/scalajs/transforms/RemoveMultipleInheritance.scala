package com.olvind.tso
package scalajs
package transforms

import scala.collection.mutable

/**
  * Sort parents to ensure that if we inherit from a class it
  *  goes first, and traits are mixins
  */
object RemoveMultipleInheritance extends SymbolVisitor {
  private val Empty: Set[TypeRef] = Set.empty

  override def enterClassSymbol(scope: SymbolScope)(cls: ClassSymbol): ClassSymbol = {
    val parents = ParentsResolver(scope, cls)

    val parentsByTransitiveClassesReferenced: Map[Set[TypeRef], Seq[ParentsResolver.NotRoot]] =
      parents.directParents
        .groupBy { p: ParentsResolver.NotRoot =>
          p.transitiveParents
            .collect { case (ref, cs) if cs.classType === ClassType.Class => ref }
            .to[Set]
        }

    val classParentRefs = mutable.ArrayBuffer.empty[TypeRef]
    val ignoredRefs     = mutable.ArrayBuffer.empty[TypeRef]

    parentsByTransitiveClassesReferenced.to[Seq].sortBy(_._2.length).foreach {
      case (Empty, _) =>
      case (_, ps) =>
        ignoredRefs ++= classParentRefs
        classParentRefs.clear()
        classParentRefs ++= ps.map(_.ref)
    }

    val interfaceParentRefs = cls.parents.filterNot(pr => classParentRefs.contains(pr) || ignoredRefs.contains(pr))

    val msg = s"Dropped parents $ignoredRefs"

    if (ignoredRefs.nonEmpty) {
      scope.logger.info(msg)
    }

    cls.copy(
      comments =
        if (ignoredRefs.isEmpty) cls.comments
        else cls.comments + Comment("/* RemoveMultipleInheritance: " + msg + "*/\n"),
      parents = Seq.empty ++ classParentRefs ++ interfaceParentRefs
    )
  }
}
