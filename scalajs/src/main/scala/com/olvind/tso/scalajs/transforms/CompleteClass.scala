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
object CompleteClass extends SymbolVisitor {
  override def enterModuleSymbol(scope: SymbolScope)(mod: ModuleSymbol): ModuleSymbol =
    mod.copy(
      members = mod.members ++ implementations(scope, mod, ParentsResolver(scope, mod))
    )

  override def enterClassSymbol(scope: SymbolScope)(cls: ClassSymbol): ClassSymbol = {
    val parents = ParentsResolver(scope, cls)

    val newImplementations: Iterable[MemberSymbol] =
      if (cls.classType === ClassType.Trait) Nil else implementations(scope, cls, parents)

    cls.copy(members = cls.members ++ newImplementations)
  }

  def isAlreadyImplemented(x: MethodSymbol, existing: Option[Seq[Symbol]]): Boolean =
    existing match {
      case None => false
      case Some(existings) =>
        existings.exists {
          case xx: MethodSymbol =>
            xx.params.flatten.map(_.tpe) === x.params.flatten.map(_.tpe) && xx.tparams === x.tparams
          case _ => false
        }
    }

  private def implementations(scope:   SymbolScope,
                              c:       ContainerSymbol,
                              parents: ParentsResolver.Parents): Seq[MemberSymbol] = {

    val ret = parents.pruneClasses.transitiveParents
      .flatMap(_._2.members)
      .collect {
        case x: FieldSymbol if x.impl === MemberImplNotImplemented && !c.index.contains(x.name) =>
          x.copy(isOverride = true, impl = MemberImplNative, comments = x.comments + Comment("/* CompleteClass */\n"))
        case x: MethodSymbol if x.impl === MemberImplNotImplemented && !isAlreadyImplemented(x, c.index.get(x.name)) =>
          x.copy(isOverride = true, impl = MemberImplNative, comments = x.comments + Comment("/* CompleteClass */\n"))
      }
      .to[Seq]
      .distinct

    if (ret.nonEmpty)
      scope.logger.info(s"Completed implementations ${ret.map(_.name.value)}")

    ret
  }
}
