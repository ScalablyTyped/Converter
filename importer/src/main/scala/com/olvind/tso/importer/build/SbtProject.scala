package com.olvind.tso.importer.build
import ammonite.ops.Path
import com.olvind.tso.Synced
import com.olvind.tso.importer.TsSource

case class SbtProject(name: String, organization: String, artifactId: String, version: String)(
    val written:            Map[Path, Synced],
    val deps:               Map[TsSource, PublishedSbtProject]
)
