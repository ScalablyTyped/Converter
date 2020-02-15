package org.scalablytyped.converter.internal.importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.importer.Phase2Res.LibScalaJs
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import org.scalablytyped.converter.internal.scalajs.TreeScope
import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl

import scala.collection.immutable.SortedSet

class PhaseFlavour(flavour: FlavourImpl) extends Phase[Source, Phase2Res, Phase2Res] {

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

            val tree = flavour.rewrittenTree(scope, lib.packageTree)

            LibScalaJs(lib.source)(
              lib.libName,
              lib.scalaName,
              lib.libVersion,
              tree,
              deps,
              lib.isStdLib,
              lib.facades,
              lib.names,
            )
        }
    }
  }
}
