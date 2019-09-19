package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.importer.Phase1Res.{LibTs, LibraryPart}
import com.olvind.tso.importer.Phase2Res.LibScalaJs
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs.{ContainerTree, PackageTree, TreeScope, transforms => S}
import com.olvind.tso.ts.{TsIdentLibrary, TsIdentLibrarySimple}

import scala.collection.immutable.SortedSet

class Phase2ToScalaJs(pedantic: Boolean) extends Phase[Source, Phase1Res, Phase2Res] {

  override def apply(
      source:     Source,
      current:    Phase1Res,
      getDeps:    GetDeps[Source, Phase2Res],
      isCircular: IsCircular,
      logger:     Logger[Unit],
      reactBinding: ReactBinding
  ): PhaseRes[Source, Phase2Res] =
    current match {
      case Phase1Res.Facade => PhaseRes.Ok(Phase2Res.Facade)

      case _: LibraryPart =>
        PhaseRes.Ignore()

      case lib: LibTs =>
        val knownLibs  = garbageCollectLibs(lib)
        val importName = new ImportName(knownLibs.map(_.libName) + lib.name)

        getDeps(knownLibs) map {
          case Phase2Res.Unpack(scalaDeps, facades) =>
            val scalaName = importName(lib.name)

            val scope = new TreeScope.Root(
              libName       = scalaName,
              _dependencies = scalaDeps.map { case (_, l) => l.scalaName -> l.packageTree },
              logger        = logger,
              pedantic      = pedantic,
            )

            logger.warn(s"Processing ${lib.name.value}")

            /** Some of the transformations were written before we added the `typings` outermost package.
              *  This maintains that somewhat simpler world view */
            object Adapter {
              def apply(scope: TreeScope)(f: (ContainerTree, TreeScope) => ContainerTree): PackageTree => PackageTree = {
                case pkg @ PackageTree(_, _, List(one: ContainerTree), _, _) =>
                  pkg.copy(members = List(f(one, scope / pkg)))
                case other => sys.error(s"Expected top level package, got: ${other}")
              }
            }

            val involvesReact: Boolean = {
              val react = TsIdentLibrarySimple("react")
              source.libName === react || scalaDeps.exists(_._1.libName === react)
            }

            val ScalaTransforms = List[PackageTree => PackageTree](
              S.RemoveDuplicateInheritance >>
                S.CleanupTypeAliases >>
                S.CleanIllegalNames >>
                S.InlineNestedIdentityAlias >>
                S.Deduplicator visitPackageTree scope,
              Adapter(scope)((tree, s) => S.FakeLiterals(s)(tree)),
              Adapter(scope)((tree, s) => S.UnionToInheritance(s, tree, scalaName)), // after FakeLiterals
              S.LimitUnionLength visitPackageTree scope, // after UnionToInheritance
              S.Companions >>
                S.RemoveMultipleInheritance visitPackageTree scope,
              S.CombineOverloads visitPackageTree scope, //must have stable types, so FakeLiterals run before
              S.FilterMemberOverrides visitPackageTree scope, //
              S.InferMemberOverrides visitPackageTree scope, //runs in phase after FilterMemberOverrides
              S.CompleteClass >> //after FilterMemberOverrides
                S.Sorter visitPackageTree scope,
              Adapter(scope) { (tree, s) =>
                if (involvesReact) {
                  reactBinding.generateReactComponents(s, tree)
                } else tree
              },
            )

            val rewrittenTree = ScalaTransforms.foldLeft(ImportTree(lib, logger, importName)) {
              case (acc, f) => f(acc)
            }

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

    val referenced: Set[TsIdentLibrary] = ts.TreeTraverse
      .collect(lib.parsed) {
        case x: ts.TsIdentLibrary => x
      }
      .toSet

    all.filter(x => referenced(x.libName))
  }
}
