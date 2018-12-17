package com.olvind.tso
package ts

import java.net.URI
import java.time.{Instant, ZonedDateTime}

import ammonite.ops.%%

import scala.util.{Success, Try}

object CalculateLibraryVersion {

  def apply(sourceFolder:     InFolder,
            sourceFiles:      Seq[InFile],
            lastChangedIndex: RepoLastChangedIndex,
            packageJsonOpt:   Option[PackageJsonDeps],
            comments:         Comments): LibraryVersion = {
    implicit val wd = sourceFolder.path

    val libraryVersion = packageJsonOpt.flatMap(_.version) orElse
      DefinitelyTypedVersion.from(comments) getOrElse
      "0.0-unknown"

    val localCommit: String = BuildInfo.gitSha

    val inGit: Option[InGit] =
      Try(new URI((%% git ('remote, "get-url", 'origin)).out.string.trim)) match {
        case Success(uri) =>
          val lastModified = ZonedDateTime.ofInstant(
            Instant.ofEpochSecond(lastChangedIndex.values(sourceFolder.path)),
            constants.TimeZone
          )

          Some(InGit(uri, uri === constants.DefinitelyTypedRepo, lastModified))
        case _ => None
      }

    new LibraryVersion(libraryVersion, inGit, localCommit)
  }

  /**
    * Version is normally specified in DefinitelyTyped like this
    */
  private object DefinitelyTypedVersion {
    private val Version = "^\\/\\/ Type definitions for .+ ([a-zA-Z\\d][a-zA-Z\\d.\\-]*)$".r

    def from(comments: Comments): Option[String] = {
      val lines = comments.cs.flatMap(_.raw.split("\n"))
      lines.collectFirst {
        case Version(v) if v.exists(_.isDigit) => v
      }
    }
  }
}
