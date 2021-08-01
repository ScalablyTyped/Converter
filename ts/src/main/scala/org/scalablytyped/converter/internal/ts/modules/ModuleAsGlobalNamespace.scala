package org.scalablytyped.converter.internal
package ts
package modules

import org.scalablytyped.converter.internal.ts.transforms.SetJsLocation

/**
  * Implement `export namespace as ...`.
  *
  * It's implemented as reexporting the resulting top-level module to avoid split type hierarchies,
  *  the other option would be to duplicate all the contents.
  */
object ModuleAsGlobalNamespace {
  def apply(libName: TsIdentLibrary, file: TsParsedFile): TsParsedFile =
    findTopLevelModule(libName, file) match {
      case None => file
      case Some(topLevelModule) =>
        val globalCp = file.codePath.forceHasPath + TsIdent.Global

        /** It feels wrong that the `TsExportAsNamespace` may be placed within `topLevelModule`,
            but it's the result of [[InferredDefaultModule]].
          */
        val globals: IArray[TsNamedDecl] =
          (topLevelModule.members ++ file.members).flatMap {
            case TsExportAsNamespace(asGlobal) => asNamespace(globalCp, topLevelModule, asGlobal)
            case _                             => Empty
          }

        globals match {
          case Empty => file
          case some =>
            val ns = TsDeclNamespace(
              NoComments,
              declared   = false,
              name       = TsIdent.Global,
              members    = some,
              codePath   = globalCp,
              jsLocation = JsLocation.Zero,
            )
            file.copy(members = ns +: file.members)
        }
    }

  def findTopLevelModule(libName: TsIdentLibrary, x: TsParsedFile): Option[TsDeclModule] =
    x.membersByName.get(TsIdentModule.fromLibrary(libName)).flatMap {
      case IArray.first(mod: TsDeclModule) => Some(mod)
      case _ => None
    }

  def asNamespace(codePath: CodePath, mod: TsDeclModule, asGlobal: TsIdentSimple): IArray[TsNamedDecl] = {
    val jsLocation  = JsLocation.Zero
    val asNamespace = TsDeclNamespace(mod.comments, mod.declared, asGlobal, mod.members, codePath, jsLocation)
    DeriveCopy(asNamespace, codePath, None).map(SetJsLocation.visitTsNamedDecl(jsLocation))
  }
}
