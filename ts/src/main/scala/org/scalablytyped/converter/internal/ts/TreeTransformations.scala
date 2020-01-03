package org.scalablytyped.converter.internal
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

  override def enterTsGlobal(t: TsTreeScope)(x: TsGlobal): TsGlobal =
    x.copy(members = newMembers(t, x))

  override def enterTsDeclNamespace(t: TsTreeScope)(x: TsDeclNamespace): TsDeclNamespace =
    x.copy(members = newMembers(t, x))

  override def enterTsDeclModule(t: TsTreeScope)(x: TsDeclModule): TsDeclModule =
    x.copy(members = newMembers(t, x))

  override def enterTsAugmentedModule(t: TsTreeScope)(x: TsAugmentedModule): TsAugmentedModule =
    x.copy(members = newMembers(t, x))

  def newMembers(scope: TsTreeScope, x: TsContainer): IArray[TsContainerOrDecl]
}

trait TransformLeaveMembers extends TreeTransformationScopedChanges {
  override def leaveTsParsedFile(t: TsTreeScope)(x: TsParsedFile): TsParsedFile =
    x.copy(members = newMembers(t, x))

  override def leaveTsGlobal(t: TsTreeScope)(x: TsGlobal): TsGlobal =
    x.copy(members = newMembers(t, x))

  override def leaveTsDeclNamespace(t: TsTreeScope)(x: TsDeclNamespace): TsDeclNamespace =
    x.copy(members = newMembers(t, x))

  override def leaveTsDeclModule(t: TsTreeScope)(x: TsDeclModule): TsDeclModule =
    x.copy(members = newMembers(t, x))

  override def leaveTsAugmentedModule(t: TsTreeScope)(x: TsAugmentedModule): TsAugmentedModule =
    x.copy(members = newMembers(t, x))

  def newMembers(scope: TsTreeScope, x: TsContainer): IArray[TsContainerOrDecl]
}

trait TransformClassMembers extends TreeTransformationScopedChanges {
  override def enterTsDeclClass(t: TsTreeScope)(x: TsDeclClass): TsDeclClass =
    x.copy(members = newClassMembers(t, x))

  override def enterTsDeclInterface(t: TsTreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(members = newClassMembers(t, x))

  override def enterTsTypeObject(t: TsTreeScope)(x: TsTypeObject): TsTypeObject =
    x.copy(members = newClassMembers(t, x))

  def newClassMembers(scope: TsTreeScope, x: HasClassMembers): IArray[TsMember]
}

trait TransformLeaveClassMembers extends TreeTransformationScopedChanges {
  override def leaveTsDeclClass(t: TsTreeScope)(x: TsDeclClass): TsDeclClass =
    x.copy(members = newClassMembersLeaving(t, x))

  override def leaveTsDeclInterface(t: TsTreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(members = newClassMembersLeaving(t, x))

  override def leaveTsTypeObject(t: TsTreeScope)(x: TsTypeObject): TsTypeObject =
    x.copy(members = newClassMembersLeaving(t, x))

  def newClassMembersLeaving(scope: TsTreeScope, x: HasClassMembers): IArray[TsMember]
}
