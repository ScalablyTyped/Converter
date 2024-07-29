package org.scalablytyped.converter.internal.importer

import geny.Generator
import org.scalablytyped.converter.internal.IArray

import java.nio.file.FileSystems
import scala.util.Try

object GlobWalker {

  /**
    * Traverses the base directory and returns all files that match a given glob.
    *
    * Only returns files, not directories. If a directory matches a glob then all its descendents are included.
    *
    * @see the glob syntax in [[java.nio.file.FileSystem#getPathMatcher]]
    */
  def walkFiles(baseDirectory: os.Path, globs: IArray[String]): IndexedSeq[os.Path] = {
    val pathOrMatchers = globs.map { glob =>
      Try(FileSystems.getDefault.getPathMatcher(s"glob:$glob")).toOption.toRight(baseDirectory / glob)
    }

    def matches(path: os.Path) = {
      val relativePath = path.relativeTo(baseDirectory)
      pathOrMatchers.exists {
        case Left(invalidGlob) => invalidGlob.toString == relativePath.toString
        case Right(matcher)    => matcher.matches(relativePath.toNIO)
      }
    }

    val builder = IndexedSeq.newBuilder[os.Path]

    def processDirectoryAndSkip(dir: os.Path): Boolean =
      if (matches(dir)) {
        os.walk.stream(dir).generate { path =>
          if (path.toIO.isFile) builder += path
          Generator.Continue
        }
        true
      } else false

    os.walk.stream(baseDirectory, processDirectoryAndSkip).generate { path =>
      if (path.toIO.isFile && matches(path)) builder += path
      Generator.Continue
    }

    builder.result()
  }
}
