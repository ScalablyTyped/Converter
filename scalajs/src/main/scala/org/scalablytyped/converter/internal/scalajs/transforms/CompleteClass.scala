package org.scalablytyped.converter.internal
package scalajs
package transforms

import org.scalablytyped.converter.internal.maps._
import CompleteClass._

/**
  * With @ScalaJSDefined traits we don't implement members.
  * Scalac complains about that for classes, so we provide implementations.
  *
  * We lookup all parents until we reach a class, because at that point
  * we know everything will be implemented.
  *
  * We also forward constructors from parent class, as in typescript
  * it seems you can instantiate a class with a parents constructor,
  * weirdly enough.
  *
  */
class CompleteClass(parentsResolver: ParentsResolver) extends TreeTransformation {

  override def leaveClassTree(scope: TreeScope)(cls: ClassTree): ClassTree = {
    val parents = parentsResolver(scope, cls)

    val newImplementations: IArray[MemberTree] =
      if (cls.classType === ClassType.Trait) Empty else implementations(scope, cls, parents)

    cls.copy(members = cls.members ++ newImplementations)
  }

  private def implementations(
      scope:   TreeScope,
      c:       InheritanceTree,
      parents: ParentsResolver.Parents,
  ): IArray[MemberTree] = {

    val ret = parents.pruneClasses.transitiveParents
      .flatMapToIArray { case (_, v) => v.members }
      .collect {
        case x: FieldTree if x.impl === NotImplemented && !c.index.contains(x.name) =>
          x.copy(isOverride = true, impl = ExprTree.native, comments = x.comments + Comment("/* CompleteClass */\n"))
        case x: MethodTree if x.impl === NotImplemented && !isAlreadyImplemented(scope, x, c.index.get(x.name)) =>
          x.copy(isOverride = true, impl = ExprTree.native, comments = x.comments + Comment("/* CompleteClass */\n"))
      }
      .carefulDistinct

    if (ret.nonEmpty)
      scope.logger.info(s"Completed implementations ${ret.map(_.name.value)}")

    ret
  }
}

object CompleteClass {
  def isAlreadyImplemented(scope: TreeScope, potential: MethodTree, existing: Option[IArray[Tree]]): Boolean = {
    lazy val currentErasure = Erasure.base(scope)(potential)
    existing match {
      case None => false
      case Some(existings) =>
        existings.exists {
          case xx: MethodTree if Erasure.base(scope)(xx) === currentErasure => true
          case _ => false
        }
    }
  }

  implicit class Ops(private val ms: IArray[MemberTree]) extends AnyVal {
    def carefulDistinct: IArray[MemberTree] = {
      val ret = IArray.Builder.empty[MemberTree]

      ms.groupBy(_.name)
        .foreach {
          case (_, IArray.exactlyOne(one)) => ret += one
          case (_, sameName)               => ret ++= sameName.distinctBy(_.withCodePath(QualifiedName.Any))
        }

      ret.result()
    }
  }

}
