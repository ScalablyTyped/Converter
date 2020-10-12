package org.scalablytyped.converter.internal
package scalajs
package transforms

import maps._

object ModulesCombine extends TreeTransformation {
  override def leaveContainerTree(scope: TreeScope)(c: ContainerTree): ContainerTree =
    combineModules(c)

  def combineModules[C <: ContainerTree](c: C): C = {
    val withCombinedModules: IArray[Tree] =
      c.index.flatMapToIArray {
        case (_, ts) =>
          val (mods, rest) = ts.partitionCollect { case x: ModuleTree => x }
          val combinedModules: Option[ModuleTree] =
            mods.reduceOption { (mod1, mod2) =>
              ModuleTree(
                annotations = mod1.annotations,
                name        = mod1.name,
                parents     = (mod1.parents ++ mod2.parents).distinct,
                members     = (mod1.members ++ mod2.members).distinct,
                comments    = mod1.comments ++ mod2.comments,
                codePath    = mod1.codePath,
                isOverride  = false,
              )
            }

          rest ++ IArray.fromOption(combinedModules)
      }

    c.withMembers(withCombinedModules).asInstanceOf[C]
  }
}
