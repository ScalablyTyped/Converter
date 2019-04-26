package com.olvind.tso
package ts.modules

import com.olvind.logging.Logger
import com.olvind.tso.seqs._
import com.olvind.tso.ts._

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
        val (keepOutside, moveInside) = keepTopLevelTypeAliasesOutside(moduleName, file)

        val module = TsDeclModule(
          comments   = NoComments,
          declared   = true,
          name       = moduleName,
          members    = moveInside,
          codePath   = CodePath.NoPath,
          jsLocation = JsLocation.Module(moduleName, ModuleSpec.Defaulted)
        )

        logger.info(s"Inferred module $moduleName")
        file.copy(members = keepOutside ++ Seq(module))

      case other => other
    }

  /**
    * To support things like this:
    *
    * ```typescript
    * type Err = Error;
    *
    * declare namespace createError {
    *     interface Error<T extends Err> extends Err {
    *         new (message?: string, obj?: any): T;
    *     }
    * }
    *
    * export = createError;
    * ```
    * `Err` refers to global error, not the one defined in the namespace.
    * Note that we cannot do this in arbitrary modules, as we might leave
    *  conflicting definitions in the same scope (2x `type Props = ...` for instance)
    */
  private def keepTopLevelTypeAliasesOutside(moduleName: TsIdentModule,
                                             file:       TsParsedFile): (Seq[TsDeclTypeAlias], Seq[TsContainerOrDecl]) =
    if (moduleName.fragments.size > 1)
      (Nil, file.members)
    else
      file.members.partitionCollect {
        case x: TsDeclTypeAlias if refersToUnknown(x, file) => x
      }

  def refersToUnknown(x: TsDeclTypeAlias, file: TsParsedFile): Boolean =
    x.alias match {
      case TsTypeRef(_, TsQIdent(List(name)), _) => !file.membersByNameMeh.contains(name)
      case _                                     => false
    }
}
