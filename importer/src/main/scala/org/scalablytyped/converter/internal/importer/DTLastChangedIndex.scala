package org.scalablytyped.converter.internal.importer

import java.io.File

import com.olvind.logging.Logger.DevNull

import scala.collection.mutable

sealed trait DTLastChangedIndex extends Serializable {
  def apply(path: File): Long
}

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
object DTLastChangedIndex {
  private object ExtractLong {
    def unapply(s: String): Option[Long] =
      if (s.nonEmpty && s.forall(_.isDigit)) Some(s.toLong) else None
  }

  private def withParentParts(relPath: os.RelPath): Seq[os.RelPath] =
    (0 to relPath.segments.length).map { n =>
      os.RelPath(relPath.segments.take(n), 0)
    }
  final case object No extends DTLastChangedIndex {
    def apply(path: File): Long = 0L
  }

  final case class Impl(values: Map[File, Long]) extends DTLastChangedIndex {
    def apply(path: File): Long = values(path)
  }

  def apply(cmd: Cmd, repo: os.Path, cacheDir: os.Path): DTLastChangedIndex = {
    implicit val wd = repo

    val head = cmd.run.git("rev-parse", "HEAD").out.lines.head

    FileLocking.cachedValue((cacheDir / head).toNIO, DevNull) {
      val res         = cmd.run.git('log, "--raw", "--pretty=format:%ct")
      var changedTime = System.currentTimeMillis() / 1000L
      val lastChanged = mutable.Map.empty[os.RelPath, Long]

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

          withParentParts(os.RelPath(filename)).foreach { path =>
            if (!lastChanged.contains(path)) {
              lastChanged(path) = changedTime
            }
          }
        case _ =>
      }

      Impl(lastChanged.iterator.map { case (relPath, long) => (repo / relPath).toIO -> long }.toMap)
    }
  }
}
