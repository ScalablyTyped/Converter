package org.scalablytyped.converter.internal
package ts.modules

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.ts._

object InferredDefaultModule {
  def onlyAugments(in: TsParsedFile): Boolean =
    in.members.forall {
      case _: TsImport          => true
      case _: TsAugmentedModule => true
      case _: TsDeclModule      => true
      case _: TsDeclTypeAlias   => true
      case _: TsDeclInterface   => true
      case _ => false
    }

  private def alreadyExists(file: TsParsedFile, moduleName: TsIdentModule) =
    file.members.exists {
      case x: TsDeclModule if x.name === moduleName => true
      case _ => false
    }

  def apply(in: TsParsedFile, moduleName: TsIdentModule, logger: Logger[Unit]): TsParsedFile =
    in match {
      case file if file.isModule && !onlyAugments(in) && !alreadyExists(file, moduleName) =>
        val module = TsDeclModule(
          comments   = NoComments,
          declared   = true,
          name       = moduleName,
          members    = file.members,
          codePath   = CodePath.NoPath,
          jsLocation = JsLocation.Module(moduleName, ModuleSpec.Defaulted),
        )

        logger.info(s"Inferred module $moduleName")
        file.copy(members = IArray(module))

      case other => other
    }

}
