package org.scalablytyped.converter
package internal
package importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import org.scalablytyped.converter.internal.scalajs.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.QualifiedName.StdNames
import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl
import org.scalablytyped.converter.internal.scalajs.transforms.{Adapter, CleanIllegalNames}
import org.scalablytyped.converter.internal.scalajs.{
  Erasure,
  Name,
  PackageTree,
  ParentsResolver,
  TreeScope,
  Versions,
  transforms => S,
}
import org.scalablytyped.converter.internal.ts.{TsIdentLibrary, TsTreeTraverse}

import scala.collection.immutable.SortedSet

/**
  * This phase starts by going from the typescript AST to the scala AST.
  * Then the phase itself implements a bunch of scala.js limitations, like ensuring no methods erase to the same signature
  */
class Phase2ToScalaJs(
    pedantic:                 Boolean,
    useDeprecatedModuleNames: Boolean,
    scalaVersion:             Versions.Scala,
    enableScalaJsDefined:     Selection[TsIdentLibrary],
    outputPkg:                Name,
    flavour:                  FlavourImpl,
) extends Phase[LibTsSource, LibTs, LibScalaJs] {

  override def apply(
      source:     LibTsSource,
      tsLibrary:  LibTs,
      getDeps:    GetDeps[LibTsSource, LibScalaJs],
      isCircular: IsCircular,
      logger:     Logger[Unit],
  ): PhaseRes[LibTsSource, LibScalaJs] = {
    val knownLibs = garbageCollectLibs(tsLibrary)

    getDeps(knownLibs).map { scalaDeps =>
      val scalaName = ImportName(tsLibrary.name)

      val scope = new TreeScope.Root(
        libName       = scalaName,
        _dependencies = scalaDeps.map { case (_, l) => l.scalaName -> l.packageTree },
        logger        = logger,
        pedantic      = pedantic,
        outputPkg     = outputPkg,
      )

      logger.warn(s"Processing ${tsLibrary.name.value}")

      val cleanIllegalNames = new CleanIllegalNames(outputPkg)

      // this has a cache inside
      def erasure()        = new Erasure(scalaVersion)
      def parentResolver() = new ParentsResolver

      val ScalaTransforms = List[PackageTree => PackageTree](
        (
          S.CleanupTrivial >> // before ModulesCombine
            S.ModulesCombine
        ).visitPackageTree(scope),
        new TypeRewriterCast(flavour.rewrites).visitPackageTree(scope),
        (new S.RemoveDuplicateInheritance(parentResolver()) >>
          cleanIllegalNames >>
          S.Deduplicator).visitPackageTree(scope),
        Adapter(scope)((tree, s) => S.FakeLiterals(outputPkg, s, cleanIllegalNames)(tree)),
        Adapter(scope)((tree, s) => S.UnionToInheritance(s, tree, scalaName)), // after FakeLiterals
        S.LimitUnionLength.visitPackageTree(scope), // after UnionToInheritance
        new S.RemoveMultipleInheritance(parentResolver()).visitPackageTree(scope),
        new S.CombineOverloads(erasure())
          .visitPackageTree(scope), //must have stable types, so FakeLiterals run before
        new S.FilterMemberOverrides(erasure(), parentResolver()).visitPackageTree(scope), //
        new S.InferMemberOverrides(erasure(), parentResolver())
          .visitPackageTree(scope), //runs in phase after FilterMemberOverrides
        new S.CompleteClass(erasure(), parentResolver(), scalaVersion)
          .visitPackageTree(scope), //after FilterMemberOverrides
      )

      val importName = AdaptiveNamingImport(
        outputPkg,
        tsLibrary.name,
        tsLibrary.parsed,
        scalaDeps.mapToIArray { case (_, v) => v.names },
        cleanIllegalNames,
        useDeprecatedModuleNames,
      )

      val importType = new ImportType(new StdNames(outputPkg))
      val importTree = new ImportTree(
        outputPkg,
        importName,
        importType,
        cleanIllegalNames,
        new ImportExpr(importType, importName),
        enableScalaJsDefined(tsLibrary.name),
        scalaVersion,
      )

      val scalaTree            = importTree(tsLibrary, logger)
      val transformedScalaTree = ScalaTransforms.foldLeft(scalaTree) { case (acc, f) => f(acc) }

      LibScalaJs(tsLibrary.source)(
        libName      = tsLibrary.name.`__value`.replaceAll("\\.", "_dot_"),
        scalaName    = scalaName,
        libVersion   = tsLibrary.version,
        packageTree  = transformedScalaTree,
        dependencies = scalaDeps,
        isStdLib     = tsLibrary.parsed.isStdLib,
        names        = importName,
      )
    }
  }

  private def garbageCollectLibs(lib: LibTs): SortedSet[LibTsSource] = {
    val all: SortedSet[LibTsSource] =
      lib.transitiveDependencies.keys.map(x => x: LibTsSource).to(SortedSet)

    val referenced: Set[TsIdentLibrary] =
      TsTreeTraverse.collect(lib.parsed) { case x: ts.TsIdentLibrary => x }.toSet

    all.filter(x => referenced(x.libName))
  }
}
