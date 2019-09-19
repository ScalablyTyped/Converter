package com.olvind.tso
package importer

import com.olvind.logging.Logger
import com.olvind.tso.importer.Phase2Res.LibScalaJs
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.scalajs._
import os.Path

import scala.collection.immutable.{SortedMap, SortedSet}

/**
  * This phase writes scala AST to file system
  */
class Phase3WriteFiles(targetFolder: os.Path, softWrites: Boolean) extends Phase[Source, Phase2Res, Map[Source, Seq[os.Path]]] {

  override def apply(
      source:  Source,
      _lib:    Phase2Res, //These are the results of Phase2, basically, the full scala js tree, ready to write out.
      getDeps: GetDeps[Source, Map[Source, Seq[os.Path]]],
      v4:      IsCircular,
      logger:  Logger[Unit],
  ): PhaseRes[Source, Map[Source, Seq[os.Path]]] =
    _lib match {
      case lib: LibScalaJs =>
        getDeps(lib.dependencies.keys.map(x => x: Source).to[SortedSet]) flatMap { depsWritten: SortedMap[Source, Map[Source, Seq[Path]]] =>
          val scope = new TreeScope.Root(
            libName       = lib.scalaName,
            _dependencies = lib.dependencies.map { case (_, lib) => lib.scalaName -> lib.packageTree },
            logger        = logger,
            pedantic      = false,
          )

          val outputPath = targetFolder / os.RelPath(lib.libName)

          val outFiles: Map[os.Path, Array[Byte]] =
            Printer(scope, lib.packageTree) map { case (relPath, content) => outputPath / relPath -> content }

          logger warn s"Writing ${lib.libName} (${outFiles.size} files) to $outputPath..."

          files.syncAbs(outFiles, folder = outputPath, deleteUnknowns = true, soft = softWrites)

          PhaseRes.Ok(maps.smash(depsWritten.values).updated(source, outFiles.keys.to[Seq]))
        }
    }
}
