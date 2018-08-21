package com.olvind.tso
package ts.modules

import com.olvind.logging.Logger
import com.olvind.tso.ts._

object InferredDefaultModule {
  def onlyAugments(in: TsParsedFile): Boolean =
    in.members.forall {
      case _: TsImport          => true
      case _: TsAugmentedModule => true
      case _: TsDeclTypeAlias   => true
      case _: TsDeclInterface   => true
      case _ => false
    }

  def apply(in: TsParsedFile, moduleName: TsIdentModule, logger: Logger[Unit]): TsParsedFile =
    in match {
      case file if file.isModule && file.modules.isEmpty && !onlyAugments(in) =>
        val module = TsDeclModule(
          comments   = NoComments,
          declared   = true,
          name       = moduleName,
          members    = file.members,
          codePath   = CodePath.NoPath,
          jsLocation = JsLocation.Module(moduleName, ModuleSpec.Defaulted)
        )

        logger.info(s"Inferred module $moduleName")
        val a = file.copy(members = Seq(module))
        a
      case other => other
    }
}
