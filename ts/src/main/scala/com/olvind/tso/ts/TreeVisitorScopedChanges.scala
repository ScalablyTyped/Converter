package com.olvind.tso.ts

abstract class TreeVisitorScopedChanges extends TreeVisitor[TreeScope] {
  override final def withTree(t: TreeScope, tree: TsTree): TreeScope =
    t / tree
}

abstract class TreeVisitorUnit extends TreeVisitor[Unit] {
  override final def withTree(t: Unit, tree: TsTree): Unit = ()
}
