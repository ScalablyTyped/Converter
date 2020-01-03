package org.scalablytyped.converter.internal.ts
package parser

import com.olvind.logging
import org.scalablytyped.converter.internal.importer.PersistingFunction.nameAndMtimeUnder
import org.scalablytyped.converter.internal.importer.{Cmd, Config, PersistingFunction, DTUpToDate}
import org.scalablytyped.converter.internal.{InFile, InFolder, constants}

object SuchTestMuchFail extends App {
  val logger = logging.stdout

  val Config(config)  = args
  val parseTempFolder = config.cacheFolder / 'parseTemp
  os.makeDir.all(parseTempFolder)
  os.makeDir.all(config.cacheFolder)

  val dtFolder: InFolder =
    DTUpToDate(new Cmd(logger, None), config.offline, config.cacheFolder, constants.DefinitelyTypedRepo)

  val criterion: Double =
    99.5

  def banner(): Unit =
    println(s"\n${"*" * 80}\n")

  def bannerMsg(s: String): Unit = {
    banner()
    println(s)
    banner()
  }

  val allFiles: Seq[os.Path] =
    os.walk.stream(dtFolder.path, _.last == ".git")
      .filter(os.isFile)
      .filter(_.toString.endsWith(".d.ts"))
      .toSeq

  val parser = PersistingFunction(nameAndMtimeUnder(parseTempFolder), logger.void)(parseFile)

  val parsed: Seq[(os.Path, Either[String, TsParsedFile])] =
    allFiles.par.map { path: os.Path =>
      val t0 = System.currentTimeMillis
      val res = try parser(InFile(path))
      catch {
        case x: StackOverflowError => Left(x.getMessage)
      }
      println(s"$path in ${System.currentTimeMillis() - t0} ms")
      (path, res)
    }.seq

  val successes: Seq[os.Path] =
    parsed collect {
      case (path, Right(_)) => path
    } sortBy (_.toString)

  val failures: Seq[(os.Path, String)] =
    parsed collect {
      case (path, Left(error)) => path -> error
    } sortBy (_._1.toString)

  val percentageSuccess: Double =
    100.0 * successes.size / allFiles.size

  banner()
  failures foreach println
  bannerMsg(s"Success: $percentageSuccess")
  assert(percentageSuccess >= criterion)
}
