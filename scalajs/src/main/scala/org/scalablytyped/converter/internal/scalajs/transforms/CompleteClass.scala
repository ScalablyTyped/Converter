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
class CompleteClass(erasure: Erasure, parentsResolver: ParentsResolver, scalaVersion: Versions.Scala)
    extends TreeTransformation {

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

    val allInherited: IArray[Tree] =
      parents.pruneClasses.transitiveParents.flatMapToIArray { case (_, v) => v.members }

    val completedFields: IArray[FieldTree] =
      allInherited.collect {
        case x: FieldTree if x.impl === NotImplemented && !c.index.contains(x.name) =>
          // workaround https://github.com/lampepfl/dotty/issues/13019
          val isOverride = if (scalaVersion.is3 && !x.isReadOnly) false else true

          x.copy(
            isOverride = isOverride,
            impl       = ExprTree.native,
            comments   = x.comments + Comment("/* CompleteClass */\n"),
          )
      }

    val completedMethods: IArray[MemberTree] =
      allInherited.mapNotNone {
        case x: MethodTree
            if x.impl === NotImplemented && !isAlreadyImplemented(erasure, scope, x, c.index.get(x.name)) =>
          val implementedByField: Boolean =
            x match {
              case SetterFor(name) => completedFields.exists(f => f.name === name && !f.isReadOnly)
              case _               => false
            }

          if (implementedByField) None
          else
            Some(
              x.copy(
                isOverride = true,
                impl       = ExprTree.native,
                comments   = x.comments + Comment("/* CompleteClass */\n"),
              ),
            )

        case _ => None
      }
    val ret = (completedFields ++ completedMethods).carefulDistinct

    if (ret.nonEmpty)
      scope.logger.info(s"Completed implementations ${completedMethods.map(_.name.value)}")

    ret
  }
}

object CompleteClass {
  object SetterFor {
    def unapply(m: MethodTree): Option[Name] =
      if (m.name.unescaped.endsWith("_=") &&
          m.params.foldLeft(0)(_ + _.length) === 1 &&
          m.resultType === TypeRef.Unit) {
        Some(Name(m.name.unescaped.dropRight(2)))
      } else None
  }

  def isAlreadyImplemented(
      erasure:   Erasure,
      scope:     TreeScope,
      potential: MethodTree,
      existing:  Option[IArray[Tree]],
  ): Boolean = {
    lazy val currentErasure = erasure.base(scope)(potential)
    existing match {
      case None => false
      case Some(existings) =>
        existings.exists {
          case xx: MethodTree if erasure.base(scope)(xx) === currentErasure => true
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
          case (_, sameName)               => ret ++= sameName.distinctBy(_.withCodePath(QualifiedName.JsAny))
        }

      ret.result()
    }
  }

}
