package com.olvind.tso.ts

import java.net.URI

import ammonite.ops.{%, exists, Path}
import com.olvind.tso.InFolder

import scala.util.Try

object UpToDateDefinitelyTyped {
  def apply(offline: Boolean, cacheFolder: Path, repo: URI): InFolder = {
    val dtBase:  Path = cacheFolder / 'DefinitelyTyped
    val dtTypes: Path = dtBase / 'types

    if (!offline)
      Try(
        if (exists(dtTypes)) {
          implicit val wd = dtBase
          % git 'fetch
          % git ("clean", "-fdX") // remove ignored files/folders
          % git ("clean", "-fd")
          % git ('reset, "--hard", "origin/master")
          % rm ("-f", ".git/gc.log")
          % git 'prune

        } else
          %("git", "clone", repo.toString)(cacheFolder),
      )
    InFolder(dtTypes)
  }
}
