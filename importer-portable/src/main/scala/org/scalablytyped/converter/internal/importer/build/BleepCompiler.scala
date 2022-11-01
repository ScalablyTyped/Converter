package org.scalablytyped.converter.internal
package importer
package build

import bleep.{model, BleepException, FetchBleepRelease}
import com.olvind.logging.{Formatter, Logger}
import coursier.cache.CacheLogger

import java.nio.file.Path
import scala.concurrent.{ExecutionContext, Future}

object BleepCompiler {
  implicit val PathFormatter: Formatter[os.Path] = x => x.toString()

  def apply(
      logger:    Logger[Unit],
  )(implicit ec: ExecutionContext): Future[BleepCompiler] =
    Future[Either[BleepException, Path]] {
      object cacheLogger extends CacheLogger {
        override def downloadingArtifact(url: String): Unit = logger.withContext(url).info("downloading")
      }
      FetchBleepRelease(model.BleepVersion.current, cacheLogger, ec)
    }.flatMap {
      case Left(bleepException) =>
        Future.failed(bleepException)
      case Right(bleep) =>
        Future.successful(BleepCompiler(bleep))
    }
}

case class BleepCompiler(path: Path)
