package org.scalablytyped.converter.internal
package ts
package modules

object RewriteExportStarAs extends TransformMembers {
  override def newMembers(scope: TsTreeScope, x: TsContainer): IArray[TsContainerOrDecl] =
    x.members.flatMap {
      case TsExport(comments, typeOnly, tpe, TsExportee.Star(Some(as), from)) =>
        val newImport = TsImport(typeOnly, IArray(TsImported.Star(Some(as))), TsImportee.From(from))
        val newExport = TsExport(comments, typeOnly, tpe, TsExportee.Names(IArray(TsQIdent(IArray(as)) -> None), None))

        IArray(newImport, newExport)
      case other => IArray(other)
    }
}
