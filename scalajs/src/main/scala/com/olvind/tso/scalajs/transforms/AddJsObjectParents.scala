package com.olvind.tso
package scalajs
package transforms

object AddJsObjectParents extends TreeTransformation {
  override def leaveModuleTree(scope: TreeScope)(mod: ModuleTree): ModuleTree =
    if (mod.parents.isEmpty && mod.isNative)
      mod.copy(parents = List(TypeRef.Object))
    else mod

  override def leaveClassTree(scope: TreeScope)(cls: ClassTree): ClassTree =
    if (cls.parents.isEmpty && cls.isNative)
      cls.copy(parents = List(TypeRef.Object))
    else cls

  override def leaveTypeRef(scope: TreeScope)(tr: TypeRef): TypeRef =
    tr match {
      case TypeRef.UndefOr(tpe) =>
        TypeRef(QualifiedName.UndefOr, List(tpe), tr.comments)
      case other => other
    }
}
