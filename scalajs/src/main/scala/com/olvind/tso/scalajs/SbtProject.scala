package com.olvind.tso
package scalajs

import ammonite.ops.Path

case class SbtProject(name: String, organization: String, artifactId: String, version: String)(
    val written:            Map[Path, Synced],
    val deps:               Seq[PublishedSbtProject]
)

case class PublishedSbtProject(project: SbtProject)(val written: Map[Path, Synced])
