package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.importer.build.{Layout, SbtProject}
import org.scalablytyped.converter.internal.scalajs.Dep

import scala.concurrent.Future

/* A way to publish which both can be done both with this code and later through sbt */
trait Publisher {
  val sbtPlugin:    Dep
  val sbtResolver:  String
  val sbtPublishTo: String

  /* The actual publishing might be enabled or disabled */
  val enabled: Option[Publisher.Enabled]
}

object Publisher {
  trait Enabled {
    def publish(p: SbtProject, layout: Layout[os.RelPath, os.Path]): Future[Unit]
  }
}
