package com.olvind.tso
package ts

abstract class TreeTransformationScopedChanges extends TreeTransformation[TsTreeScope] {
  override final def withTree(t: TsTreeScope, tree: TsTree): TsTreeScope =
    t / tree
}

abstract class TreeTransformationUnit extends TreeTransformation[Unit] {
  override final def withTree(t: Unit, tree: TsTree): Unit = ()
}

trait TransformMembers extends TreeTransformationScopedChanges {
  override def enterTsParsedFile(t: TsTreeScope)(x: TsParsedFile): TsParsedFile =
    x.copy(members = newMembers(t, x.members))

  override def enterTsDeclGlobal(t: TsTreeScope)(x: TsGlobal): TsGlobal =
    x.copy(members = newMembers(t, x.members))

  override def enterTsDeclNamespace(t: TsTreeScope)(x: TsDeclNamespace): TsDeclNamespace =
    x.copy(members = newMembers(t, x.members))

  override def enterTsDeclModule(t: TsTreeScope)(x: TsDeclModule): TsDeclModule =
    x.copy(members = newMembers(t, x.members))

  override def enterTsAugmentedModule(t: TsTreeScope)(x: TsAugmentedModule): TsAugmentedModule =
    x.copy(members = newMembers(t, x.members))

  def newMembers(scope: TsTreeScope, xs: Seq[TsContainerOrDecl]): Seq[TsContainerOrDecl]
}

trait TransformClassMembers extends TreeTransformationScopedChanges {
  override def enterTsDeclClass(t: TsTreeScope)(x: TsDeclClass): TsDeclClass =
    x.copy(members = newClassMembers(t, x.members))

  override def enterTsDeclInterface(t: TsTreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(members = newClassMembers(t, x.members))

  override def enterTsTypeObject(t: TsTreeScope)(x: TsTypeObject): TsTypeObject =
    x.copy(members = newClassMembers(t, x.members))

  def newClassMembers(scope: TsTreeScope, xs: Seq[TsMember]): Seq[TsMember]
}
