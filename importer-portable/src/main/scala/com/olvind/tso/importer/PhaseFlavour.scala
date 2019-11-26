package com.olvind.tso.importer

import com.olvind.logging.Logger
import com.olvind.tso.PrettyString
import com.olvind.tso.importer.Phase2Res.LibScalaJs
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs.{Name, TreeScope}
import com.olvind.tso.scalajs.flavours.{Flavour, ReplaceName}

import scala.collection.immutable.SortedSet

class PhaseFlavour(flavour: Flavour, prettyString: PrettyString) extends Phase[Source, Phase2Res, Phase2Res] {

  override def apply(
      source:     Source,
      current:    Phase2Res,
      getDeps:    GetDeps[Source, Phase2Res],
      isCircular: IsCircular,
      _logger:    Logger[Unit],
  ): PhaseRes[Source, Phase2Res] = {
    val logger = _logger.withContext("flavour", flavour.toString)

    current match {
      case Phase2Res.Facade => PhaseRes.Ok(Phase2Res.Facade)

      case lib: LibScalaJs =>
        getDeps((lib.dependencies.keys: Iterable[Source]).to[SortedSet]).map {
          case Phase2Res.Unpack(deps, _) =>
            val scope = new TreeScope.Root(
              libName       = lib.scalaName,
              _dependencies = deps.map { case (_, lib) => lib.scalaName -> lib.packageTree },
              logger        = logger,
              pedantic      = false,
              outputPkg     = flavour.outputPkg,
            )

            val correctedPackage =
              new ReplaceName(Name.typings, flavour.outputPkg).visitPackageTree(scope)(lib.packageTree)
            val tree = flavour.rewrittenTree(scope, correctedPackage, prettyString)

            LibScalaJs(lib.source)(
              lib.libName,
              lib.scalaName,
              lib.libVersion,
              tree,
              deps,
              lib.isStdLib,
              lib.facades,
            )
        }
    }
  }
}
