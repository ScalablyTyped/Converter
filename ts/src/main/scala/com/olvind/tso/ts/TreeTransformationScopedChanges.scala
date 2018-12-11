package com.olvind.tso.ts

abstract class TreeTransformationScopedChanges extends TreeTransformation[TsTreeScope] {
  override final def withTree(t: TsTreeScope, tree: TsTree): TsTreeScope =
    t / tree
}

abstract class TreeTransformationUnit extends TreeTransformation[Unit] {
  override final def withTree(t: Unit, tree: TsTree): Unit = ()
}
