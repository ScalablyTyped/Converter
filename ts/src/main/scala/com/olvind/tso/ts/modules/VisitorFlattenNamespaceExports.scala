package com.olvind.tso.ts.modules

import com.olvind.tso.ts._

//todo: generalize module import stuff to handle namespace imports/exports
object VisitorFlattenNamespaceExports extends TreeVisitorUnit {
  override def enterTsDeclNamespace(t: Unit)(x: TsDeclNamespace): TsDeclNamespace =
    x.withMembers(x.members map {
      case TsExport(_, _, TsExporteeTree(decl: TsNamedDecl)) => decl
      case other => other
    })

  override def enterTsParsedFile(t: Unit)(x: TsParsedFile): TsParsedFile =
    x.withMembers(x.members map {
      case TsExport(_, _, TsExporteeTree(xx: TsDeclInterface)) => xx
      case TsExport(_, _, TsExporteeTree(xx: TsDeclTypeAlias)) => xx
      case other => other
    })
}
