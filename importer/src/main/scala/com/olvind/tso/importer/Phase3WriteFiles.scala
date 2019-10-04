package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.importer.Phase2Res.LibScalaJs
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs._

import scala.collection.immutable.SortedSet

/**
  * This phase writes scala AST to file system
  */
class Phase3WriteFiles(targetFolder: os.Path, softWrites: Boolean) extends Phase[Source, Phase2Res, os.Path] {

  override def apply(
      source:  Source,
      _lib:    Phase2Res,
      getDeps: GetDeps[Source, os.Path],
      v4:      IsCircular,
      logger:  Logger[Unit],
  ): PhaseRes[Source, os.Path] =
    _lib match {
      case lib: LibScalaJs =>
        getDeps(lib.dependencies.keys.map(x => x: Source).to[SortedSet]) flatMap { _ =>
          val scope = new TreeScope.Root(
            libName       = lib.scalaName,
            _dependencies = lib.dependencies.map { case (_, lib) => lib.scalaName -> lib.packageTree },
            logger        = logger,
            pedantic      = false,
          )

          val outputPath = targetFolder / lib.libName
          logger warn s"Writing ${lib.libName} to $outputPath..."
          files.sync(
            fs             = Printer(scope, lib.packageTree),
            folder         = outputPath,
            deleteUnknowns = true,
            soft           = softWrites,
          )
          PhaseRes.Ok(outputPath)
        }
    }
}
