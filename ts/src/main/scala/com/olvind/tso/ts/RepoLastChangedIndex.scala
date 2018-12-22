package com.olvind.tso.ts

import ammonite.ops._

import scala.collection.mutable

final case class RepoLastChangedIndex private (values: Map[Path, Long])

/**
  * It's pretty ridiculous that this is needed, but here we are...
  *
  * We version artifacts from DefinitelyTyped with the date of the last change.
  * Surprisingly enough, there isn't a way to ask git when that was.
  * You also cannot look at files directly, because you they will have a timestamp
  * from when you cloned the repo if they haven't changed since.
  *
  * Most answers online recommend doing `git log -1 <directory>` and extract the timestamp.
  * This works, but takes a solid second in such a big repo. And we do it several thousand times.
  *
  * For that reason we pre-compute it here.
  */
object RepoLastChangedIndex {
  private object ExtractLong {
    def unapply(s: String): Option[Long] =
      if (s.nonEmpty && s.forall(_.isDigit)) Some(s.toLong) else None
  }

  private def withParentParts(relPath: RelPath): Seq[RelPath] =
    0 to relPath.segments.length map { n =>
      RelPath(relPath.segments.take(n), 0)
    }

  def apply(repo: Path): RepoLastChangedIndex = {
    implicit val wd = repo

    val res         = %% git ('log, "--raw", "--pretty=format:%ct")
    var changedTime = System.currentTimeMillis() / 1000L
    val lastChanged = mutable.Map.empty[RelPath, Long]

    res.out.lines.map(_.split(" ")).foreach {
      // empty
      case Array("") =>
        ()

      //determined by `--pretty:format` in the git command. This is just a unix timestamp
      case Array(ExtractLong(date)) =>
        changedTime = date

      //:000000 100644 0000000000 2a575c9267 A  types/filenamify-url/filenamify-url-tests.ts
      case Array(_, _, _, _, filenamesString) =>
        /** First fragment after split will be the column with `A` above.
          * There might be more than one tab-separated file name, in that case it's a rename `from to`.
          *
          * In any case it should be alright to always take the last filename
          */
        val filename = filenamesString.split("\\t").last

        withParentParts(RelPath(filename)).foreach { path =>
          if (!lastChanged.contains(path)) {
            lastChanged(path) = changedTime
          }
        }
      case _ =>
    }

    new RepoLastChangedIndex(lastChanged.map { case (relPath, long) => repo / relPath -> long }(collection.breakOut))
  }
}
