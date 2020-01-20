package org.scalablytyped.converter.internal
package ts
package transforms

/**
  * Some libraries add their own of version of interfaces declared in std.
  *
  * This is for two reasons:
  *  1) define an empty type so you can compile and use the lib without say the DOM definitions
  *  2) extend the definitions because the library has monkey patched global functionality
  *
  * This takes care of 1) by removing them (will be fine with and without DOM definitions)
  * 2) is mostly a stupid idea anyway.
  */
object RemoveStubs extends TreeTransformationScopedChanges {
  override def enterTsParsedFile(scope: TsTreeScope)(x: TsParsedFile): TsParsedFile =
    x.copy(members = clean(scope, x.members))

  override def enterTsGlobal(scope: TsTreeScope)(x: TsGlobal): TsGlobal =
    x.copy(members = clean(scope, x.members))

  def clean(scope: TsTreeScope, members: IArray[TsContainerOrDecl]): IArray[TsContainerOrDecl] =
    members.filter {
      case i: TsDeclInterface if i.members.isEmpty =>
        scope.root.lookupType(TsQIdent(IArray(TsIdent.std, i.name)), skipValidation    = true).isEmpty &&
          scope.root.lookupType(TsQIdent(IArray(TsIdent.node, i.name)), skipValidation = true).isEmpty
      case _ => true
    }
}
