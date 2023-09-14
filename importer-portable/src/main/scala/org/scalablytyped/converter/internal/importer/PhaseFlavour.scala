package org.scalablytyped.converter.internal.importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl
import org.scalablytyped.converter.internal.scalajs.{Name, TreeScope}
import org.scalablytyped.converter.internal.scalajs.transforms.{Mangler, SetPrivateWithin, Sorter}

import scala.collection.immutable.SortedSet

class PhaseFlavour(flavour: FlavourImpl, maybePrivateWithin: Option[Name])
    extends Phase[LibTsSource, LibScalaJs, LibScalaJs] {

  override def apply(
      source:     LibTsSource,
      lib:        LibScalaJs,
      getDeps:    GetDeps[LibTsSource, LibScalaJs],
      isCircular: IsCircular,
      _logger:    Logger[Unit],
  ): PhaseRes[LibTsSource, LibScalaJs] = {
    val logger = _logger.withContext("flavour", flavour.toString)

    getDeps((lib.dependencies.keys: Iterable[LibTsSource]).to(SortedSet)).map { deps =>
      val originalScope = new TreeScope.Root(
        libName       = lib.scalaName,
        _dependencies = lib.dependencies.map { case (_, lib) => lib.scalaName -> lib.packageTree },
        logger        = logger,
        pedantic      = false,
        outputPkg     = flavour.outputPkg,
      )

      val tree0 = lib.packageTree
      val tree1 = flavour.rewrittenTree(originalScope, tree0)
      val tree2 = Mangler.visitPackageTree(originalScope)(tree1)
      val tree3 = maybePrivateWithin.foldLeft(tree2) {
        case (tree, privateWithin) => new SetPrivateWithin(privateWithin).visitPackageTree(originalScope)(tree)
      }
      val tree4 = Sorter.visitPackageTree(originalScope)(tree3)

      LibScalaJs(lib.source)(
        libName      = lib.libName,
        scalaName    = lib.scalaName,
        libVersion   = lib.libVersion,
        packageTree  = tree4,
        dependencies = deps,
        isStdLib     = lib.isStdLib,
        names        = lib.names,
      )
    }
  }
}
