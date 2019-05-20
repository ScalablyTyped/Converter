package com.olvind.tso.importer

import java.net.URI

import ammonite.ops.{exists, Path}
import com.olvind.tso.InFolder

import scala.util.Try

object UpToDateDefinitelyTyped {
  def apply(cmd: Cmd, offline: Boolean, cacheFolder: Path, repo: URI): InFolder = {
    val clonedDir: Path = cacheFolder / 'DefinitelyTyped
    Try(
      if (exists(clonedDir)) {
        if (!offline) {
          implicit val wd = clonedDir
          cmd.runVerbose git 'fetch
          cmd.runVerbose git ("clean", "-fdX") // remove ignored files/folders
          cmd.runVerbose git ("clean", "-fd")
          cmd.runVerbose git ('reset, "--hard", "origin/master")
          cmd.runVerbose rm ("-f", ".git/gc.log")
          cmd.runVerbose git 'prune
        }
      } else
        cmd.runVerbose("git", "clone", repo.toString)(cacheFolder),
    )

    InFolder(clonedDir / 'types)
  }
}
