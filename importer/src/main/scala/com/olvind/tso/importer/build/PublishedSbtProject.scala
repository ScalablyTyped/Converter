package com.olvind.tso.importer.build
import ammonite.ops.Path
import com.olvind.tso.{Iterable, Synced}

case class PublishedSbtProject(project: SbtProject)(
    val localIvyFiles:                  IvyLayout[Path, Synced],
    val publishedOpt:                   Option[Iterable[(Int, String)]]
)
