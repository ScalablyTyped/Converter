package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.ts._

object ImportContainer {
  def apply(
      importName: ImportName,
      scope:      TsTreeScope,
      cs:         Comments,
      name:       TsIdent,
      jsLocation: JsLocation,
      tsMembers:  Seq[TsContainerOrDecl],
      codePath:   CodePath,
  ): ModuleTree =
    RewriteNamespaceMembers(tsMembers flatMap ImportTree.decl(scope, importName)) match {
      case (inheritance, memberTrees, restTrees) =>
        val importedCp = importName(codePath)

        setCodePath(
          importedCp,
          ModuleTree(
            annotations = ImportJsLocation(jsLocation),
            name        = importName(name),
            parents     = inheritance,
            members     = memberTrees ++ restTrees,
            comments    = cs,
            codePath    = importedCp,
          ),
        )
    }
}
