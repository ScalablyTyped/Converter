package org.scalablytyped.converter.internal

import java.net.URI
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

/**
  * Listed in decreasing importance
  *
  * @param libraryVersion declared either in package.json or in comments for DefinitelyTyped
  * @param inGit we include git information if the definition files were defined in one. This to signal that they are not "official"
  */
case class LibraryVersion(isStdLib: Boolean, libraryVersion: Option[String], inGit: Option[InGit]) {
  def ignoreStdLibMinorVersion(v: String): String =
    if (isStdLib) v.substring(0, v.lastIndexOf(".")) else v

  def libraryVersionOrDefault = libraryVersion.map(ignoreStdLibMinorVersion).getOrElse("0.0-unknown")

  def version(digest: Digest): String =
    IArray
      .fromOptions(
        Some(libraryVersionOrDefault),
        inGit.map(_.format),
        Some(digest.hexString.take(6)),
      )
      .mkString("-")
}

/**
  * @param repo Maybe we'll create some clickable links later
  * @param isDefinitelyTyped stop complaining, linter
  * @param lastModified This is a compromise. We want traceable builds and would ideally
  *                     include the sha from the remote repo if any. However, computing it
  *                     from a big repo is very expensive, so we settle on the last changed
  *                     timestamp, which is easier to sort/read anyway
  */
case class InGit(repo: URI, isDefinitelyTyped: Boolean, lastModified: ZonedDateTime) {
  def format: String =
    s"${if (isDefinitelyTyped) "dt" else repo.getPath}-${lastModified.format(DateTimeFormatter.BASIC_ISO_DATE)}"
}
