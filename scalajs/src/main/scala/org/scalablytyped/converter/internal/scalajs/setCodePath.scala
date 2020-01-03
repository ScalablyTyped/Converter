package org.scalablytyped.converter.internal
package scalajs

object setCodePath {
  def apply[T <: Tree](base: QualifiedName, t: T): T =
    t match {
      case x: ModuleTree =>
        x.copy(members = x.members.map(m => setCodePath(base + m.name, m)), codePath = base).asInstanceOf[T]
      case x: PackageTree =>
        x.copy(members = x.members.map(m => setCodePath(base + m.name, m)), codePath = base).asInstanceOf[T]
      case x: ClassTree =>
        x.copy(members = x.members.map(m => setCodePath(base + m.name, m)), codePath = base).asInstanceOf[T]
      case x: TypeAliasTree => x.copy(codePath = base).asInstanceOf[T]
      case x: FieldTree     => x.copy(codePath = base).asInstanceOf[T]
      case x: MethodTree    => x.copy(codePath = base).asInstanceOf[T]
      case x => x
    }

}
