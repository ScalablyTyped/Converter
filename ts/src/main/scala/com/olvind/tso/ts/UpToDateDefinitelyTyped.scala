package com.olvind.tso.ts

import java.net.URI

import ammonite.ops.{%, exists, Path}
import com.olvind.tso.{constants, InFolder}

import scala.util.Try

object UpToDateDefinitelyTyped {
  def apply(cacheFolder: Path, repo: URI): InFolder = {
    val dtBase:  Path = cacheFolder / 'DefinitelyTyped
    val dtTypes: Path = dtBase / 'types

    if (!constants.offline)
      Try(
        if (exists(dtTypes)) {
          %("git", "pull")(dtBase)
        } else
          %("git", "clone", repo.toString)(cacheFolder)
      )
    InFolder(dtTypes)
  }
}
