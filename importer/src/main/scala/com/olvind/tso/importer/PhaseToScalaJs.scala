package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs.transforms.FakeLiterals
import com.olvind.tso.scalajs.{ContainerSymbol, LibScalaJs, Name, SymbolScope, transforms => S}
import com.olvind.tso.ts._

object PhaseToScalaJs extends Phase[TsSource, Either[LibraryPart, LibTs], LibScalaJs[TsSource]] {

  val PhaseOne =
    S.RemoveDuplicateInheritance >>
      S.CleanIllegalNames >>
      S.FixVars >>
      S.LimitUnionLength >>
      S.Deduplicator

  val PhaseTwo =
    S.RemoveMultipleInheritance >>
      S.CombineOverloads >> //must have stable types, so FakeLiterals run before
      S.FilterMemberOverrides

  val PhaseThree =
    S.InferMemberOverrides

  val PhaseFour =
    S.CompleteClass >> //after FilterMemberOverrides
      S.Sorter

  override def apply(source:     TsSource,
                     current:    Either[LibraryPart, LibTs],
                     getDeps:    GetDeps[TsSource, LibScalaJs[TsSource]],
                     isCircular: IsCircular,
                     logger:     Logger[Unit]): PhaseRes[TsSource, LibScalaJs[TsSource]] =
    current match {
      case Left(_) =>
        PhaseRes.Ignore()

      case Right(lib: LibTs) =>
        getDeps(lib.dependencies.keys.to[Set]).map { scalaDeps =>
          val scope = new SymbolScope.Root(AsName(lib.name), scalaDeps.values.to[Set], logger)

          val ScalaTransforms = (Pipe[ContainerSymbol]
            >> PhaseOne.visitContainerSymbol(scope)
            >> FakeLiterals(scope)
            >> PhaseTwo.visitContainerSymbol(scope)   //
            >> PhaseThree.visitContainerSymbol(scope) //runs in phase after FilterMemberOverrides
            >> PhaseFour.visitContainerSymbol(scope)  //
          )

          val rewrittenTree = ScalaTransforms.run(TsImporterDecl(lib, logger))

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
