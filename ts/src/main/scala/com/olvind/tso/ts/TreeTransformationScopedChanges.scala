package com.olvind.tso.ts

abstract class TreeTransformationScopedChanges extends TreeTransformation[TreeScope] {
  override final def withTree(t: TreeScope, tree: TsTree): TreeScope =
    t / tree
}

abstract class TreeTransformationUnit extends TreeTransformation[Unit] {
  override final def withTree(t: Unit, tree: TsTree): Unit = ()
}
