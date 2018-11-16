package com.olvind.tso.ts

import java.net.URI

import ammonite.ops.{%, Path, exists}
import com.olvind.tso.InFolder

import scala.util.Try

object UpToDateDefinitelyTyped {
  def apply(offline: Boolean, cacheFolder: Path, repo: URI): InFolder = {
    val dtBase:  Path = cacheFolder / 'DefinitelyTyped
    val dtTypes: Path = dtBase / 'types

    if (!offline)
      Try(
        if (exists(dtTypes)) {
          %("git", "pull")(dtBase)
        } else
          %("git", "clone", repo.toString)(cacheFolder)
      )
    InFolder(dtTypes)
  }
}
