package com.olvind.tso.importer

import java.net.URI

import com.olvind.tso.InFolder

import scala.util.Try

object UpToDateDefinitelyTyped {
  def apply(cmd: Cmd, offline: Boolean, cacheFolder: os.Path, repo: URI): InFolder = {
    val clonedDir: os.Path = cacheFolder / 'DefinitelyTyped
    Try(
      if (os.exists(clonedDir)) {
        if (!offline) {
          implicit val wd = clonedDir
          cmd.runVerbose git 'fetch
          cmd.runVerbose git ("clean", "-fdX") // remove ignored files/folders
          cmd.runVerbose git ("clean", "-fd")
          cmd.runVerbose git ('reset, "--hard", "origin/master")
          cmd.runVerbose rm ("-f", ".git/gc.log")
          cmd.runVerbose git 'prune
          // use first party definitions instead. model better if there are more cases like this
          cmd.runVerbose rm ("-f", "types/highcharts")
        }
      } else
        cmd.runVerbose("git", "clone", repo.toString)(cacheFolder),
    )

    InFolder(clonedDir / 'types)
  }
}
