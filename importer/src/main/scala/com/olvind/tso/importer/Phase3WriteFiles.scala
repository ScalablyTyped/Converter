package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.importer.Phase2Res.LibScalaJs
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs._
import os.Path

import scala.collection.immutable.SortedSet

/**
  * This phase writes scala AST to file system
  */
class Phase3WriteFiles(targetFolder: os.Path, softWrites: Boolean) extends Phase[Source, Phase2Res, Iterable[os.Path]] {

  override def apply(
      source:  Source,
      _lib:    Phase2Res, //These are the results of Phase2, basically, the full scala js tree, ready to write out.
      getDeps: GetDeps[Source, Iterable[os.Path]],
      v4:      IsCircular,
      logger:  Logger[Unit],
  ): PhaseRes[Source, Iterable[os.Path]] =
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
          val res = files.sync(
            fs             = Printer(scope, lib.packageTree),
            folder         = outputPath,
            deleteUnknowns = true,
            soft           = softWrites,
          )
          PhaseRes.Ok(res.to[scala.collection.immutable.Iterable])
        }
    }
}
