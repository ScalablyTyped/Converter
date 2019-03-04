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
    x.copy(members = newMembers(t, x))

  override def enterTsDeclGlobal(t: TsTreeScope)(x: TsGlobal): TsGlobal =
    x.copy(members = newMembers(t, x))

  override def enterTsDeclNamespace(t: TsTreeScope)(x: TsDeclNamespace): TsDeclNamespace =
    x.copy(members = newMembers(t, x))

  override def enterTsDeclModule(t: TsTreeScope)(x: TsDeclModule): TsDeclModule =
    x.copy(members = newMembers(t, x))

  override def enterTsAugmentedModule(t: TsTreeScope)(x: TsAugmentedModule): TsAugmentedModule =
    x.copy(members = newMembers(t, x))

  def newMembers(scope: TsTreeScope, x: TsContainer): Seq[TsContainerOrDecl]
}

trait TransformClassMembers extends TreeTransformationScopedChanges {
  override def enterTsDeclClass(t: TsTreeScope)(x: TsDeclClass): TsDeclClass =
    x.copy(members = newClassMembers(t, x))

  override def enterTsDeclInterface(t: TsTreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(members = newClassMembers(t, x))

  override def enterTsTypeObject(t: TsTreeScope)(x: TsTypeObject): TsTypeObject =
    x.copy(members = newClassMembers(t, x))

  def newClassMembers(scope: TsTreeScope, x: HasClassMembers): Seq[TsMember]
}
