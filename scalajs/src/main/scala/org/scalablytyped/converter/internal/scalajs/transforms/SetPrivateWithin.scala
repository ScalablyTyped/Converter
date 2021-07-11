package org.scalablytyped.converter.internal
package scalajs
package transforms

class SetPrivateWithin(within: Name) extends TreeTransformation {
  require(
    !within.unescaped.contains("."),
    s"stPrivateWithin cannot be fully qualified: specify `${within.unescaped.split("\\.").last}` instead of `${within.unescaped}`",
  )

  val p = ProtectionLevel.Private(Some(within))

  def insideInheritanceTree(scope: TreeScope): Boolean = {
    var idx = 1 // skip current
    while (idx < scope.stack.length) {
      scope.stack(idx) match {
        case _: InheritanceTree => return true
        case _ =>
      }
      idx += 1
    }
    false
  }

  override def leaveFieldTree(scope: TreeScope)(s: FieldTree): FieldTree =
    if (insideInheritanceTree(scope)) s else s.copy(level = p)

  override def leaveMethodTree(scope: TreeScope)(s: MethodTree): MethodTree =
    if (insideInheritanceTree(scope)) s else s.copy(level = p)

  override def leaveClassTree(scope: TreeScope)(s: ClassTree): ClassTree =
    if (insideInheritanceTree(scope)) s else s.copy(level = p)

  override def leaveTypeAliasTree(scope: TreeScope)(s: TypeAliasTree): TypeAliasTree =
    if (insideInheritanceTree(scope)) s else s.copy(level = p)

  override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    if (insideInheritanceTree(scope)) s else s.copy(level = p)
}
