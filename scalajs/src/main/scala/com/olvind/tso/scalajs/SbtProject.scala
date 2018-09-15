package com.olvind.tso
package scalajs

import ammonite.ops.Path

import scala.collection.mutable

case class SbtProject(name: String, organization: String, artifactId: String, version: String)(
    val written:            Map[Path, Synced],
    val deps:               Seq[PublishedSbtProject]
)

case class PublishedSbtProject(project: SbtProject)(val written: Map[Path, Synced])

object PublishedSbtProject {
  def all(p: PublishedSbtProject): Seq[PublishedSbtProject] = {
    val ret = new mutable.ArrayBuffer[PublishedSbtProject]()
    def go(p: PublishedSbtProject): Unit = {
      ret += p
      p.project.deps foreach go
    }
    go(p)
    ret.to[Seq]
  }
}
