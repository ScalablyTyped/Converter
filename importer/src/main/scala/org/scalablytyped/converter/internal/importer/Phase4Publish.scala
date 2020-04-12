package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Logger
import org.scalablytyped.converter.internal.importer.build._
import org.scalablytyped.converter.internal.phases.{GetDeps, IsCircular, Phase, PhaseRes}

import scala.collection.immutable.SortedSet
import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * This phase publishes all of the projects to bintray
  *
  * @param publisher
  */
case class Phase4Publish(publisher: Publisher.Enabled) extends Phase[Source, PublishedSbtProject, PublishedSbtProject] {
  override def apply(
      source:  Source,
      lib:     PublishedSbtProject,
      getDeps: GetDeps[Source, PublishedSbtProject],
      v4:      IsCircular,
      logger:  Logger[Unit],
  ): PhaseRes[Source, PublishedSbtProject] =
    getDeps(lib.project.deps.keys.to[SortedSet]) flatMap { deps: Map[Source, PublishedSbtProject] =>
      /** This is somewhat annoying. The bintry thing we deploy with insists on
        *  receiving already written files. We just wrote them locally for ivy, so... */
      val alreadyWrittenMavenFiles: MavenLayout[os.RelPath, os.Path] =
        MavenLayout(
          lib.project,
          lib.localIvyFiles.jarFile._1,
          lib.localIvyFiles.sourceFile._1,
          lib.localIvyFiles.pomFile._1,
        )

      val published: Unit =
        Await.result(publisher.publish(lib.project, alreadyWrittenMavenFiles), Duration.Inf)
      PhaseRes.Ok(PublishedSbtProject(lib.project)(lib.classfileDir, lib.localIvyFiles, Some(published)))
    }
}
