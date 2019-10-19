package com.olvind.tso
package importer

import com.olvind.tso.scalajs.Name
import com.olvind.tso.ts._
import org.scalatest.FunSuite

class NamingTests extends FunSuite {

  test("foo") {
    val all: Array[TsQIdent] =
      Json[Array[TsQIdent]](os.pwd / "cache.json")

    val known: Set[TsIdentLibrary] = all.collect {
      case TsQIdent((lib: TsIdentLibrary) :: _) => lib
    }.to[Set]

    val duplicates = all.groupBy(new ImportName(Name.typings, Set.empty).apply).collect {
      case (duplicate, originals) if originals.length =/= 1 =>
        duplicate.asDotString + originals.map(_.asDotString.padTo(40, ' ')).mkString("\n\t", "\n\t", "\n")
    }.to[Seq]
    println(duplicates.length)
    duplicates.sorted.foreach(println)
  }
}
