package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.importer.Phase1Res.{LibTs, LibraryPart}
import com.olvind.tso.importer.Phase2Res.LibScalaJs
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs.{ContainerTree, Name, TreeScope, transforms => S}

import scala.collection.immutable.SortedSet

class Phase2ToScalaJs(pedantic: Boolean, OutputPkg: Name) extends Phase[Source, Phase1Res, Phase2Res] {

  override def apply(source:     Source,
                     current:    Phase1Res,
                     getDeps:    GetDeps[Source, Phase2Res],
                     isCircular: IsCircular,
                     logger:     Logger[Unit]): PhaseRes[Source, Phase2Res] =
    current match {
      case Phase1Res.Contrib => PhaseRes.Ok(Phase2Res.Contrib)

      case _: LibraryPart =>
        PhaseRes.Ignore()

      case lib: LibTs =>
        val knownLibs: SortedSet[Source] =
          lib.dependencies.keys.map(x => x: Source).to[SortedSet]

        val importName = new ImportName(knownLibs.map(_.libName) + lib.name)
        getDeps(knownLibs) map {
          case Phase2Res.Unpack(scalaDeps, contribs) =>
            val libName = importName(lib.name)
            val scope = new TreeScope.Root(
              libName       = libName,
              _dependencies = scalaDeps.map { case (_, l) => l.packageTree.name -> l.packageTree },
              logger        = logger,
              pedantic      = pedantic
            )

            logger.warn(s"Processing ${lib.name.value}")

            val ScalaTransforms = List[ContainerTree => ContainerTree](
              S.RemoveDuplicateInheritance >>
                S.CleanupTypeAliases >>
                S.CleanIllegalNames(OutputPkg) >>
                S.InlineNestedIdentityAlias >>
                S.Deduplicator visitContainerTree scope,
              S.FakeLiterals(scope),
              S.UnionToInheritance(scope, _, libName), // after FakeLiterals
              S.LimitUnionLength visitContainerTree scope, // after UnionToInheritance
              S.RemoveMultipleInheritance visitContainerTree scope,
              S.CombineOverloads visitContainerTree scope, //must have stable types, so FakeLiterals run before
              S.FilterMemberOverrides visitContainerTree scope, //
              S.InferMemberOverrides visitContainerTree scope, //runs in phase after FilterMemberOverrides
              S.CompleteClass >> //after FilterMemberOverrides
                S.Sorter visitContainerTree scope
            )

            val rewrittenTree = ScalaTransforms.foldLeft(ImportTree(lib, logger, importName)) {
              case (acc, f) => f(acc)
            }

            LibScalaJs(lib.source)(
              libName      = lib.name.`__value`.replaceAll("\\.", "_dot_"),
              libVersion   = lib.version,
              packageTree  = rewrittenTree,
              dependencies = scalaDeps,
              isStdLib     = lib.parsed.isStdLib,
              contribs     = lib.contribs ++ contribs
            )
        }
    }
}
