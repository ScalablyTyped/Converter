package org.scalablytyped.converter.internal.importer

import java.net.URI

import org.scalablytyped.converter.internal.{files, InFolder}

import scala.util.Try

object DTUpToDate {
  def apply(cmd: Cmd, offline: Boolean, cacheFolder: os.Path, repo: URI): InFolder = {
    val clonedDir: os.Path = cacheFolder / 'DefinitelyTyped

    Try(
      if (files.exists(clonedDir)) {
        if (!offline) {
          implicit val wd = clonedDir
          cmd.runVerbose.git('fetch)
          cmd.runVerbose.git("clean", "-fdX") // remove ignored files/folders
          cmd.runVerbose.git("clean", "-fd")
          cmd.runVerbose.git('reset, "--hard", "origin/master")
          files.deleteAll(clonedDir / ".git" / "gc.log")
          cmd.runVerbose.git('prune)
        }
      } else
        cmd.runVerbose("git", "clone", repo.toString)(cacheFolder),
    )

    InFolder(clonedDir / 'types)
  }
}
