package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.transforms.UnionToInheritance

class ReplaceName(from: Name, to: Name) extends TreeTransformation {

  def replace(qualifiedName: QualifiedName): QualifiedName =
    qualifiedName.parts match {
      case `from` :: rest => QualifiedName(to :: rest)
      case _              => qualifiedName
    }

  def replace(comments: Comments): Comments =
    Comments(comments.cs map {
      case CommentData(data) =>
        CommentData(data match {
          case KeepOnlyReferenced.Keep(related)     => KeepOnlyReferenced.Keep(related map replaceTypeRef)
          case KeepOnlyReferenced.Related(related)  => KeepOnlyReferenced.Related(related map replaceTypeRef)
          case UnionToInheritance.WasUnion(related) => UnionToInheritance.WasUnion(related map replaceTypeRef)
          case other                                => other
        })
      case other => other
    })

  def replaceTypeRef(tr: TypeRef): TypeRef =
    tr.copy(typeName = replace(tr.typeName), comments = replace(tr.comments))

  def replace(name: Name): Name =
    name match {
      case `from` => to
      case _      => name
    }

  override def leaveClassTree(scope: TreeScope)(s: ClassTree): ClassTree =
    s.copy(comments = replace(s.comments), name = replace(s.name), codePath = replace(s.codePath))
  override def leaveFieldTree(scope: TreeScope)(s: FieldTree): FieldTree =
    s.copy(comments = replace(s.comments), name = replace(s.name), codePath = replace(s.codePath))
  override def leaveMethodTree(scope: TreeScope)(s: MethodTree): MethodTree =
    s.copy(comments = replace(s.comments), name = replace(s.name), codePath = replace(s.codePath))
  override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    s.copy(comments = replace(s.comments), name = replace(s.name), codePath = replace(s.codePath))
  override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
    s.copy(comments = replace(s.comments), name = replace(s.name), codePath = replace(s.codePath))
  override def leaveTypeAliasTree(scope: TreeScope)(s: TypeAliasTree): TypeAliasTree =
    s.copy(comments = replace(s.comments), name = replace(s.name), codePath = replace(s.codePath))
  override def leaveTypeRef(scope: TreeScope)(s: TypeRef): TypeRef =
    replaceTypeRef(s)
}
