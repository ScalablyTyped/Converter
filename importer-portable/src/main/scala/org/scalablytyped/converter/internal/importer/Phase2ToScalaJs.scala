package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.importer.Phase1Res.{LibTs, LibraryPart}
import org.scalablytyped.converter.internal.importer.Phase2Res.LibScalaJs
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import org.scalablytyped.converter.internal.scalajs.transforms.{Adapter, CleanIllegalNames}
import org.scalablytyped.converter.internal.scalajs.{Name, PackageTree, ParentsResolver, TreeScope, transforms => S}
import org.scalablytyped.converter.internal.ts.{TsIdentLibrary, TsTreeTraverse}
import org.scalablytyped.converter.{internal, Selection}

import scala.collection.immutable.SortedSet

/**
  * This phase starts by going from the typescript AST to the scala AST.
  * Then the phase itself implements a bunch of scala.js limitations, like ensuring no methods erase to the same signature
  */
class Phase2ToScalaJs(pedantic: Boolean, enableScalaJsDefined: Selection[TsIdentLibrary], outputPkg: Name)
    extends Phase[Source, Phase1Res, Phase2Res] {

  override def apply(
      source:     Source,
      current:    Phase1Res,
      getDeps:    GetDeps[Source, Phase2Res],
      isCircular: IsCircular,
      logger:     Logger[Unit],
  ): PhaseRes[Source, Phase2Res] =
    current match {
      case Phase1Res.Facade => PhaseRes.Ok(Phase2Res.Facade)

      case _: LibraryPart =>
        PhaseRes.Ignore()

      case lib: LibTs =>
        val knownLibs = garbageCollectLibs(lib)

        getDeps(knownLibs) map {
          case Phase2Res.Unpack(scalaDeps, facades) =>
            val scalaName = ImportName(lib.name)

            val scope = new TreeScope.Root(
              libName       = scalaName,
              _dependencies = scalaDeps.map { case (_, l) => l.scalaName -> l.packageTree },
              logger        = logger,
              pedantic      = pedantic,
              outputPkg     = outputPkg,
            )

            logger.warn(s"Processing ${lib.name.value}")

            val cleanIllegalNames = new CleanIllegalNames(outputPkg)

            val ScalaTransforms = List[PackageTree => PackageTree](
              S.ContainerPolicy visitPackageTree scope,
              new S.RemoveDuplicateInheritance(new ParentsResolver) >>
                S.CleanupTypeAliases >>
                cleanIllegalNames >>
                S.Deduplicator visitPackageTree scope,
              Adapter(scope)((tree, s) => S.FakeLiterals(outputPkg, s, cleanIllegalNames)(tree)),
              Adapter(scope)((tree, s) => S.UnionToInheritance(s, tree, scalaName)), // after FakeLiterals
              S.LimitUnionLength visitPackageTree scope, // after UnionToInheritance
              (S.AvoidMacroParadiseBug >> new S.RemoveMultipleInheritance(new ParentsResolver)) visitPackageTree scope,
              S.CombineOverloads visitPackageTree scope, //must have stable types, so FakeLiterals run before
              new S.FilterMemberOverrides(new ParentsResolver) visitPackageTree scope, //
              new S.InferMemberOverrides(new ParentsResolver) visitPackageTree scope, //runs in phase after FilterMemberOverrides
              new S.CompleteClass(new ParentsResolver) >> //after FilterMemberOverrides
                S.Sorter visitPackageTree scope,
            )

            val importName = AdaptiveNamingImport(
              outputPkg,
              lib.parsed,
              scalaDeps.mapToIArray { case (_, v) => v.names },
              cleanIllegalNames,
            )

            val importType = new ImportType(new internal.scalajs.QualifiedName.StdNames(outputPkg))
            val importTree = new ImportTree(
              outputPkg,
              importName,
              importType,
              cleanIllegalNames,
              new ImportExpr(importType, importName),
              enableScalaJsDefined(lib.name),
            )
            val rewrittenTree = ScalaTransforms.foldLeft(importTree(lib, logger)) { case (acc, f) => f(acc) }

            LibScalaJs(lib.source)(
              libName      = lib.name.`__value`.replaceAll("\\.", "_dot_"),
              scalaName    = scalaName,
              libVersion   = lib.version,
              packageTree  = rewrittenTree,
              dependencies = scalaDeps,
              isStdLib     = lib.parsed.isStdLib,
              facades      = lib.facades ++ facades,
              names        = importName,
            )
        }
    }

  private def garbageCollectLibs(lib: LibTs): SortedSet[Source] = {
    val all: SortedSet[Source] =
      lib.dependencies.keys.map(x => x: Source).to[SortedSet]

    val referenced: Set[TsIdentLibrary] =
      TsTreeTraverse.collect(lib.parsed) { case x: ts.TsIdentLibrary => x }.toSet

    all.filter(x => referenced(x.libName))
  }
}
