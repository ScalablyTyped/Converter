package org.scalablytyped.converter.internal.importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import org.scalablytyped.converter.internal.scalajs.TreeScope
import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl

import scala.collection.immutable.SortedSet

class PhaseFlavour(flavour: FlavourImpl) extends Phase[Source, LibScalaJs, LibScalaJs] {

  override def apply(
      source:     Source,
      lib:        LibScalaJs,
      getDeps:    GetDeps[Source, LibScalaJs],
      isCircular: IsCircular,
      _logger:    Logger[Unit],
  ): PhaseRes[Source, LibScalaJs] = {
    val logger = _logger.withContext("flavour", flavour.toString)

    getDeps((lib.dependencies.keys: Iterable[Source]).to[SortedSet]).map {
      case LibScalaJs.Unpack(deps) =>
        logger.warn(s"Applying flavour")

        val originalScope = new TreeScope.Root(
          libName       = lib.scalaName,
          _dependencies = lib.dependencies.map { case (_, lib) => lib.scalaName -> lib.packageTree },
          logger        = logger,
          pedantic      = false,
          outputPkg     = flavour.outputPkg,
        )

        val tree = flavour.rewrittenTree(originalScope, lib.packageTree)

        LibScalaJs(lib.source)(
          lib.libName,
          lib.scalaName,
          lib.libVersion,
          tree,
          deps,
          lib.isStdLib,
          lib.names,
        )
    }
  }
}
