package com.olvind.tso.ts
package parser

import ammonite.ops._
import com.olvind.logging
import com.olvind.tso.importer.PersistingFunction.nameAndMtimeUnder
import com.olvind.tso.importer.{Cmd, Config, PersistingFunction, UpToDateDefinitelyTyped}
import com.olvind.tso.{InFile, InFolder, constants}

object SuchTestMuchFail extends App {
  val logger = logging.stdout

  val Config(config)  = args
  val parseTempFolder = config.cacheFolder / 'parseTemp
  mkdir(parseTempFolder)
  mkdir(config.cacheFolder)

  val dtFolder: InFolder =
    UpToDateDefinitelyTyped(new Cmd(logger, None), config.offline, config.cacheFolder, constants.DefinitelyTypedRepo)

  val criterion: Double =
    99.5

  def banner(): Unit =
    println(s"\n${"*" * 80}\n")

  def bannerMsg(s: String): Unit = {
    banner()
    println(s)
    banner()
  }

  val allFiles: Seq[Path] =
    ls.rec(skip = _.name == ".git")
      .recursiveListFiles(dtFolder.path)
      .filter(_.isFile)
      .filter(_.toString.endsWith(".d.ts"))
      .toSeq

  val parser = PersistingFunction(nameAndMtimeUnder(parseTempFolder), logger.void)(parseFile)

  val parsed: Seq[(Path, Either[String, TsParsedFile])] =
    allFiles.par.map { path: Path =>
      val t0 = System.currentTimeMillis
      val res = try parser(InFile(path))
      catch {
        case x: StackOverflowError => Left(x.getMessage)
      }
      println(s"$path in ${System.currentTimeMillis() - t0} ms")
      (path, res)
    }.seq

  val successes: Seq[Path] =
    parsed collect {
      case (path, Right(_)) => path
    } sortBy (_.toString)

  val failures: Seq[(Path, String)] =
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
