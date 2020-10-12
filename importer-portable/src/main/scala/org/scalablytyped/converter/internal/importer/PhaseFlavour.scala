package org.scalablytyped.converter.internal.importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl
import org.scalablytyped.converter.internal.scalajs.TreeScope
import org.scalablytyped.converter.internal.scalajs.transforms.{Mangler, Sorter}

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
        val originalScope = new TreeScope.Root(
          libName       = lib.scalaName,
          _dependencies = lib.dependencies.map { case (_, lib) => lib.scalaName -> lib.packageTree },
          logger        = logger,
          pedantic      = false,
          outputPkg     = flavour.outputPkg,
        )

        val tree0 = lib.packageTree
        val tree1 = Sorter.visitPackageTree(originalScope)(tree0)
        val tree2 = flavour.rewrittenTree(originalScope, tree1)
        val tree3 = Mangler.visitPackageTree(originalScope)(tree2)

        LibScalaJs(lib.source)(
          libName      = lib.libName,
          scalaName    = lib.scalaName,
          libVersion   = lib.libVersion,
          packageTree  = tree3,
          dependencies = deps,
          isStdLib     = lib.isStdLib,
          names        = lib.names,
        )
    }
  }
}
