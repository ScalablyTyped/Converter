package org.scalablytyped.converter.internal
package scalajs
package transforms

// https://github.com/scala-js/scala-js/issues/2806
object AvoidMacroParadiseBug extends TreeTransformation {
  override def leaveModuleTree(scope: TreeScope)(mod: ModuleTree): ModuleTree = {
    val newMembers: IArray[Tree] =
      mod.members.map {
        case f: FieldTree if mod.index(f.name).exists(sameName => sameName.isInstanceOf[ClassTree]) =>
          f.impl match {
            case MemberImpl.Native =>
              ModuleTree(
                annotations = IArray(Annotation.JsNative),
                name        = f.name,
                parents     = IArray(TypeRef.TopLevel(f.tpe)),
                members     = Empty,
                comments    = f.comments,
                codePath    = f.codePath,
                isOverride  = f.isOverride,
              )
            case _ => f.withSuffix("").copy(isOverride = false)
          }

        case other => other
      }

    mod.copy(members = newMembers)
  }
}
