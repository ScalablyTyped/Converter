package com.olvind.tso
package scalajs.transforms

import com.olvind.tso.scalajs._

/**
  * With @ScalaJSDefined traits we don't implement members.
  * Scalac complains about that for classes, so we provide implementations.
  *
  * We lookup all parents until we reach a class, because at that point
  *  we know everything will be implemented.
  *
  * We also forward constructors from parent class, as in typescript
  *  it seems you can instantiate a class with a parents constructor,
  *  weirdly enough.
  *
  */
object CompleteClass extends TreeTransformation {

  override def leaveModuleTree(scope: TreeScope)(mod: ModuleTree): ModuleTree =
    mod.copy(
      members = mod.members ++ implementations(scope, mod, ParentsResolver(scope, mod)),
    )

  override def leaveClassTree(scope: TreeScope)(cls: ClassTree): ClassTree = {
    val parents = ParentsResolver(scope, cls)

    val newImplementations: Iterable[MemberTree] =
      if (cls.classType === ClassType.Trait) Nil else implementations(scope, cls, parents)

    cls.copy(members = cls.members ++ newImplementations)
  }

  def isAlreadyImplemented(scope: TreeScope, potential: MethodTree, existing: Option[Seq[Tree]]): Boolean = {
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

  private def implementations(
      scope:   TreeScope,
      c:       InheritanceTree,
      parents: ParentsResolver.Parents,
  ): Seq[MemberTree] = {

    val ret = parents.pruneClasses.transitiveParents
      .flatMap(_._2.members)
      .collect {
        case x: FieldTree if x.impl === MemberImpl.NotImplemented && !c.index.contains(x.name) =>
          x.copy(isOverride = true, impl = MemberImpl.Native, comments = x.comments + Comment("/* CompleteClass */\n"))
        case x: MethodTree
            if x.impl === MemberImpl.NotImplemented && !isAlreadyImplemented(scope, x, c.index.get(x.name)) =>
          x.copy(isOverride = true, impl = MemberImpl.Native, comments = x.comments + Comment("/* CompleteClass */\n"))
      }
      .to[Seq]
      .distinct

    if (ret.nonEmpty)
      scope.logger.info(s"Completed implementations ${ret.map(_.name.value)}")

    ret
  }
}
