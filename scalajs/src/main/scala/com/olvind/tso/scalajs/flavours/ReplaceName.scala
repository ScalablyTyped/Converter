package com.olvind.tso.scalajs
package flavours

class ReplaceName(from: Name, to: Name) extends TreeTransformation {

  def replace(qualifiedName: QualifiedName): QualifiedName =
    qualifiedName.parts match {
      case `from` :: rest => QualifiedName(to :: rest)
      case _              => qualifiedName
    }

  def replace(name: Name): Name =
    name match {
      case `from` => to
      case _      => name
    }

  override def leaveClassTree(scope: TreeScope)(s: ClassTree): ClassTree =
    s.copy(name = replace(s.name), codePath = replace(s.codePath))
  override def leaveFieldTree(scope: TreeScope)(s: FieldTree): FieldTree =
    s.copy(name = replace(s.name), codePath = replace(s.codePath))
  override def leaveMethodTree(scope: TreeScope)(s: MethodTree): MethodTree =
    s.copy(name = replace(s.name), codePath = replace(s.codePath))
  override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    s.copy(name = replace(s.name), codePath = replace(s.codePath))
  override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
    s.copy(name = replace(s.name), codePath = replace(s.codePath))
  override def leaveTypeAliasTree(scope: TreeScope)(s: TypeAliasTree): TypeAliasTree =
    s.copy(name = replace(s.name), codePath = replace(s.codePath))
  override def leaveTypeRef(scope: TreeScope)(s: TypeRef): TypeRef =
    s.copy(typeName = replace(s.typeName))

}
