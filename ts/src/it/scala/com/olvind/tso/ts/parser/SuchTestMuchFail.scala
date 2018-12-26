package com.olvind.tso.ts
package parser

import java.net.URI

import ammonite.ops._
import com.olvind.tso.InFolder
import org.scalatest._

import scala.util.parsing.combinator.Parsers

final class SuchTestMuchFail extends FunSuite {
  val cacheFolder: Path = home / 'tmp / "tso-cache"

  mkdir(cacheFolder)
  val dtFolder: InFolder =
    UpToDateDefinitelyTyped(
      offline = false,
      cacheFolder,
      new URI("https://github.com/DefinitelyTyped/DefinitelyTyped.git")
    )

  val criterion: Double =
    99.5

  def banner(): Unit =
    println(s"\n${"*" * 80}\n")

  def bannerMsg(s: String): Unit = {
    banner()
    println(s)
    banner()
  }

  test("all!") {
    val allFiles: Seq[Path] =
      ls.rec(skip = _.name == ".git")
        .recursiveListFiles(dtFolder.path)
        .filter(_.isFile)
        .filter(_.toString.endsWith(".d.ts"))
        .take(4000)
        .toSeq

    val parsed: Seq[(Path, Parsers#ParseResult[TsParsedFile])] =
      allFiles.par.map { path: Path =>
        val t0       = System.currentTimeMillis
        val contents = read(path)
        val p        = new TsParser(Some((path, contents.length)))
        import p.FromString

        val res = try p.parsedTsFile(read(path))
        catch {
          case x: StackOverflowError => TsParser.Failure(x.getMessage, new TsParser.lexical.Scanner(""))
        }
        println(s"$path in ${System.currentTimeMillis() - t0} ms")
        (path, res)
      }.seq

    val successes: Seq[Path] =
      parsed collect {
        case (path, res) if res.successful => path
      } sortBy (_.toString)

    val failures: Seq[(Path, Parsers#ParseResult[TsParsedFile])] =
      parsed collect {
        case a @ (_, res) if !res.successful => a
      } sortBy (_._1.toString)

    val percentageSuccess: Double =
      100.0 * successes.size / allFiles.size

    banner()
    failures foreach println
    bannerMsg(s"Success: $percentageSuccess")
    assert(percentageSuccess >= criterion)
  }
}
