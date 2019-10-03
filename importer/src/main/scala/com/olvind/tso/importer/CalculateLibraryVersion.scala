package com.olvind.tso
package importer

import java.net.URI
import java.time.{Instant, ZonedDateTime}

import ammonite.ops.%%
import com.olvind.tso.ts.PackageJsonDeps

import scala.util.{Success, Try}

class CalculateLibraryVersion(lastChangedIndex: RepoLastChangedIndex, localCommit: String) {

  def apply(
      sourceFolder:   InFolder,
      isStdLib:       Boolean,
      sourceFiles:    Seq[InFile],
      packageJsonOpt: Option[PackageJsonDeps],
      comments:       Comments,
  ): LibraryVersion = {

    implicit val wd = sourceFolder.path

    def ignoreStdLibMinorVersion(v: String): String =
      if (isStdLib) v.substring(0, v.lastIndexOf(".")) else v

    val libraryVersion = packageJsonOpt.flatMap(_.version) map ignoreStdLibMinorVersion orElse
      DefinitelyTypedVersion.from(comments)

    val inGit: Option[InGit] =
      Try(new URI((%% git ('remote, "get-url", 'origin)).out.string.trim)) match {
        case Success(uri) =>
          val lastModified = ZonedDateTime.ofInstant(
            Instant.ofEpochSecond(lastChangedIndex.values(sourceFolder.path)),
            constants.TimeZone,
          )

          Some(InGit(uri, uri === constants.DefinitelyTypedRepo, lastModified))
        case _ => None
      }

    LibraryVersion(libraryVersion, inGit, localCommit)
  }

  /**
    * Version is normally specified in DefinitelyTyped like this
    */
  private object DefinitelyTypedVersion {
    private val Version = "^\\/\\/ Type definitions for .+ ([a-zA-Z\\d][a-zA-Z\\d.\\-]*)$".r

    def from(comments: Comments): Option[String] = {
      val lines = comments.rawCs.flatMap(_.split("\n"))
      lines.collectFirst {
        case Version(v) if v.exists(_.isDigit) => v
      }
    }
  }
}
