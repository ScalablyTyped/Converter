package org.scalablytyped.converter.internal
package ts
package modules

object RewriteExportStarAs extends TransformMembers {
  override def newMembers(scope: TsTreeScope, x: TsContainer): IArray[TsContainerOrDecl] =
    x.members.flatMap {
      case TsExport(comments, typeOnly, tpe, TsExporteeStar(Some(as), from)) =>
        val newImport = TsImport(typeOnly, IArray(TsImportedStar(Some(as))), TsImporteeFrom(from))
        val newExport = TsExport(comments, typeOnly, tpe, TsExporteeNames(IArray(TsQIdent(IArray(as)) -> None), None))

        IArray(newImport, newExport)
      case other => IArray(other)
    }
}
