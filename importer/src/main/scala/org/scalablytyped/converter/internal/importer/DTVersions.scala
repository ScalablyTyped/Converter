package org.scalablytyped.converter.internal
package importer

import java.net.URI
import java.time.{Instant, ZonedDateTime}

import ammonite.ops.%%
import org.scalablytyped.converter.internal.ts.{CalculateLibraryVersion, PackageJson}

import scala.util.matching.Regex
import scala.util.{Success, Try}

class DTVersions(lastChangedIndex: DTLastChangedIndex, includeGitPart: Boolean) extends CalculateLibraryVersion {
  val GitAtGithubDotCom: Regex = s"git@github.com:(.*)".r

  def uri(uriString: String): URI =
    uriString match {
      case GitAtGithubDotCom(path) => new URI(s"https://github.com/$path")
      case other                   => new URI(other)
    }

  override def apply(
      sourceFolder:   InFolder,
      isStdLib:       Boolean,
      packageJsonOpt: Option[PackageJson],
      comments:       Comments,
  ): LibraryVersion = {

    implicit val wd = sourceFolder.path

    val libraryVersion = packageJsonOpt.flatMap(_.version).orElse(DefinitelyTypedVersion.from(comments))

    val inGit: Option[InGit] = {
      if (!includeGitPart) None
      else
        Try(uri(%%.git('remote, "get-url", 'origin).out.string.trim)) match {
          case Success(uri) =>
            val lastModified = ZonedDateTime.ofInstant(
              Instant.ofEpochSecond(lastChangedIndex(sourceFolder.path.toIO)),
              constants.TimeZone,
            )
            Some(InGit(uri, uri === constants.DefinitelyTypedRepo, lastModified))
          case _ => None
        }
    }

    LibraryVersion(isStdLib, libraryVersion, inGit)
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
