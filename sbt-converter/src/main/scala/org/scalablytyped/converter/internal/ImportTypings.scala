package org.scalablytyped.converter
package internal

import java.nio.file.Path

import com.olvind.logging.Logger
import io.circe013.{Decoder, Encoder}
import org.scalablytyped.converter.internal.importer._
import org.scalablytyped.converter.internal.ImportTypingsUtil.{Failures, Results, Successes}
import org.scalablytyped.converter.internal.importer.build.{Compiler, IvyLayout, PublishedSbtProject}
import org.scalablytyped.converter.internal.importer.documentation.Npmjs
import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.phases.{PhaseListener, PhaseRes, PhaseRunner, RecPhase}
import org.scalablytyped.converter.internal.scalajs.Dep
import org.scalablytyped.converter.internal.ts._
import os.RelPath
import sbt.librarymanagement.ModuleID

import scala.collection.immutable.SortedMap

object ImportTypings {
  type Input = ImportTypingsUtil.Input
  type InOut = (Input, Output)

  case class Output(externalDeps: Set[Dep.Concrete], allProjects: IArray[Dep.Concrete]) {
    val allRelPaths: IArray[RelPath] =
      allProjects.flatMap(p => IvyLayout.unit(p).all.map { case (k, _) => k })

    def moduleIds: Set[ModuleID] =
      (externalDeps ++ allProjects.toSet).map(Utils.asModuleID)
  }

  object Output {
    implicit val encodes: Encoder[Output] = io.circe013.generic.semiauto.deriveEncoder
    implicit val decodes: Decoder[Output] = io.circe013.generic.semiauto.deriveDecoder
  }

  def apply(
      input:              Input,
      logger:             Logger[Unit],
      parseCacheDirOpt:   Option[Path],
      publishLocalFolder: os.Path,
      fromFolder:         InFolder,
      targetFolder:       os.Path,
      compiler:           Compiler,
  ): Either[Failures, Output] = {

    val (_, successes, failures) =
      ImportTypingsUtil.get(input, logger, parseCacheDirOpt, publishLocalFolder, fromFolder, targetFolder, compiler)

    if (failures.nonEmpty) Left(failures)
    else
      Right(
        Output(
          input.conversion.flavourImpl.dependencies.map(_.concrete(input.conversion.versions)),
          IArray.fromTraversable(successes.values.map(_.project.reference)),
        ),
      )
  }
}
