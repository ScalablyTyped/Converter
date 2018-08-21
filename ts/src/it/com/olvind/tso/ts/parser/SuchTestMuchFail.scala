package com.olvind.tso.ts
package parser

import ammonite.ops._

final class SuchTestMuchFail extends FunSuite with ParserHarness {
  val definitelyTypedFolder: Path =
    home / 'pr / "DefinitelyTyped"

  val criterion: Double =
    99.2

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
        .recursiveListFiles(definitelyTypedFolder)
        .filter(_.toString.endsWith(".d.ts"))
        .take(1000)
        .toSeq

    val parsed: Seq[(Path, TsParser.ParseResult[TsParsedFile])] =
      allFiles.par.map { (path: Path) =>
        val t0  = System.currentTimeMillis
        val res = parseAs(read(path), TsParser.parsedTsFile)
        println(s"$path in ${System.currentTimeMillis() - t0} ms")
        (path, res)
      }.seq

    val successes: Seq[Path] =
      parsed collect {
        case (path, TsParser.Success(res, _)) => path
      } sortBy (_.toString)

    val failures: Seq[(Path, TsParser.ParseResult[TsParsedFile])] =
      parsed collect {
        case a @ (path, TsParser.Failure(msg, pos)) => a
      } sortBy (_._1.toString)

    val percentageSuccess: Double =
      100.0 * successes.size / allFiles.size

    banner()
    failures foreach println
    bannerMsg(s"Success: $percentageSuccess")
    assert(percentageSuccess >= criterion)
  }
}
