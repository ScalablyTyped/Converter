package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.importer.Phase1Res.{LibTs, LibraryPart}
import com.olvind.tso.importer.Phase2Res.LibScalaJs
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs.flavours.{Flavour, GenCompanions, Params}
import com.olvind.tso.scalajs.transforms.{Adapter, CleanIllegalNames}
import com.olvind.tso.scalajs.{PackageTree, QualifiedName, TreeScope, transforms => S}
import com.olvind.tso.ts.{TsIdentLibrary, TsTreeTraverse}

import scala.collection.immutable.SortedSet

/**
  * This phase starts by going from the typescript AST to the scala AST.
  * Then the phase itself implements a bunch of scala.js limitations, like ensuring no methods erase to the same signature
  */
class Phase2ToScalaJs(pedantic: Boolean, flavour: Flavour) extends Phase[Source, Phase1Res, Phase2Res] {

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
        val knownLibs  = garbageCollectLibs(lib)
        val outputPkg  = flavour.outputPkg
        val importName = new ImportName(outputPkg, knownLibs.map(_.libName) + lib.name)

        getDeps(knownLibs) map {
          case Phase2Res.Unpack(scalaDeps, facades) =>
            val scalaName = importName(lib.name)

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
              S.RemoveDuplicateInheritance >>
                S.CleanupTypeAliases >>
                cleanIllegalNames >>
                S.InlineNestedIdentityAlias >>
                S.Deduplicator visitPackageTree scope,
              Adapter(scope)((tree, s) => S.FakeLiterals(outputPkg, s)(tree)),
              Adapter(scope)((tree, s) => S.UnionToInheritance(s, tree, scalaName)), // after FakeLiterals
              S.LimitUnionLength visitPackageTree scope, // after UnionToInheritance
              S.RemoveMultipleInheritance visitPackageTree scope,
              S.CombineOverloads visitPackageTree scope, //must have stable types, so FakeLiterals run before
              S.FilterMemberOverrides visitPackageTree scope, //
              S.InferMemberOverrides visitPackageTree scope, //runs in phase after FilterMemberOverrides
              S.CompleteClass >> //after FilterMemberOverrides
                S.Sorter visitPackageTree scope,
              /* this last transformation "breaks" the tree, in that we can no longer resolve all `TypeRef`s */
              tree => {
                val params = new Params(cleanIllegalNames)
                val withCompanions =
                  flavour.memberToParamOpt.fold(tree)(m2p => {
                    val gen = new GenCompanions(m2p, params)
                    gen.visitPackageTree(scope)(tree)
                  })
                flavour.rewrittenTree(scope, withCompanions)
              },
            )
            val importTree    = new ImportTree(importName, new ImportType(new QualifiedName.StdNames(outputPkg)))
            val rewrittenTree = ScalaTransforms.foldLeft(importTree(lib, logger)) { case (acc, f) => f(acc) }

            LibScalaJs(lib.source)(
              libName      = lib.name.`__value`.replaceAll("\\.", "_dot_"),
              scalaName    = scalaName,
              libVersion   = lib.version,
              packageTree  = rewrittenTree,
              dependencies = scalaDeps,
              isStdLib     = lib.parsed.isStdLib,
              facades      = lib.facades ++ facades,
            )
        }
    }

  private def garbageCollectLibs(lib: LibTs): SortedSet[Source] = {
    val all: SortedSet[Source] =
      lib.dependencies.keys.map(x => x: Source).to[SortedSet]

    val referenced: Set[TsIdentLibrary] = TsTreeTraverse
      .collect(lib.parsed) {
        case x: ts.TsIdentLibrary => x
      }
      .toSet

    all.filter(x => referenced(x.libName))
  }
}
