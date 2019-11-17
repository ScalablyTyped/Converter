package com.olvind.tso.importer

import com.olvind.logging.Logger
import com.olvind.tso.importer.Phase2Res.LibScalaJs
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs.TreeScope
import com.olvind.tso.scalajs.flavours.Flavour

class PhaseFlavour(flavour: Flavour) extends Phase[Source, Phase2Res, Phase2Res] {

  override def apply(
      source:     Source,
      current:    Phase2Res,
      getDeps:    GetDeps[Source, Phase2Res],
      isCircular: IsCircular,
      logger:     Logger[Unit],
  ): PhaseRes[Source, Phase2Res] =
    current match {
      case Phase2Res.Facade => PhaseRes.Ok(Phase2Res.Facade)

      case lib: LibScalaJs =>
        val scope = new TreeScope.Root(
          libName       = lib.scalaName,
          _dependencies = lib.dependencies.map { case (_, lib) => lib.scalaName -> lib.packageTree },
          logger        = logger,
          pedantic      = false,
          outputPkg     = flavour.outputPkg,
        )

        val tree = flavour.rewrittenTree(scope, lib.packageTree)

        PhaseRes.Ok(
          LibScalaJs(lib.source)(
            lib.libName,
            lib.scalaName,
            lib.libVersion,
            tree,
            lib.dependencies,
            lib.isStdLib,
            lib.facades,
          ),
        )
    }
}
