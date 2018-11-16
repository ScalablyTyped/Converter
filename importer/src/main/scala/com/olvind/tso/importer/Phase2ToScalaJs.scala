package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs.transforms.FakeLiterals
import com.olvind.tso.scalajs.{ContainerSymbol, LibScalaJs, Name, SymbolScope, transforms => S}

class Phase2ToScalaJs(pedantic: Boolean, OutputPkg: Name)
    extends Phase[TsSource, Either[LibraryPart, LibTs], LibScalaJs[TsSource]] {

  override def apply(source:     TsSource,
                     current:    Either[LibraryPart, LibTs],
                     getDeps:    GetDeps[TsSource, LibScalaJs[TsSource]],
                     isCircular: IsCircular,
                     logger:     Logger[Unit]): PhaseRes[TsSource, LibScalaJs[TsSource]] =
    current match {
      case Left(_) =>
        PhaseRes.Ignore()

      case Right(lib: LibTs) =>
        getDeps(lib.dependencies.keys.to[Set]) map { scalaDeps =>
          val scope = new SymbolScope.Root(
            libName       = ImportName(lib.name),
            _dependencies = scalaDeps.values.to[Set],
            logger        = logger,
            pedantic      = pedantic
          )

          logger.warn(s"Processing ${lib.name}")

          val ScalaTransforms = List[ContainerSymbol => ContainerSymbol](
            S.RemoveDuplicateInheritance >>
              S.CleanupTypeAliases >>
              S.CleanIllegalNames(OutputPkg) >>
              S.InlineNestedIdentityAlias >>
              S.LimitUnionLength >>
              S.Deduplicator visitContainerSymbol scope,
            FakeLiterals(scope),
            S.RemoveMultipleInheritance visitContainerSymbol scope,
            S.CombineOverloads >> //must have stable types, so FakeLiterals run before
              S.FilterMemberOverrides visitContainerSymbol scope, //
            S.InferMemberOverrides visitContainerSymbol scope, //runs in phase after FilterMemberOverrides
            S.CompleteClass >> //after FilterMemberOverrides
              S.Sorter visitContainerSymbol scope
          )

          val rewrittenTree = ScalaTransforms.foldLeft(ImportTree(lib, logger)) { case (acc, f) => f(acc) }

          LibScalaJs(
            source        = lib.source,
            libName       = Name(lib.name.`__value`),
            libVersion    = lib.version,
            packageSymbol = rewrittenTree,
            dependencies  = scalaDeps.values.to[Set],
            isStdLib      = lib.isStdLib
          )
        }
    }
}
