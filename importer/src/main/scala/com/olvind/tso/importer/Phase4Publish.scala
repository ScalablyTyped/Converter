package com.olvind.tso
package importer

import ammonite.ops._
import com.olvind.logging.Logger
import com.olvind.tso.importer.build._
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

case class Phase4Publish(publisher: BinTrayPublisher) extends Phase[Source, PublishedSbtProject, PublishedSbtProject] {

  override def apply(source:  Source,
                     lib:     PublishedSbtProject,
                     getDeps: GetDeps[Source, PublishedSbtProject],
                     v4:      IsCircular,
                     logger:  Logger[Unit]): PhaseRes[Source, PublishedSbtProject] =
    getDeps(lib.project.deps.keys.to[Set]) flatMap { deps: Map[Source, PublishedSbtProject] =>
      /** This is somewhat annoying. The bintry thing we deploy with insists on
        *  receiving already written files. We just wrote them locally for ivy, so... */
      val alreadyWrittenMavenFiles: MavenLayout[RelPath, Path] =
        MavenLayout(lib.project,
                    lib.localIvyFiles.jarFile._1,
                    lib.localIvyFiles.sourceFile._1,
                    lib.localIvyFiles.pomFile._1,
        )

      val published: Iterable[Boolean] =
        Await.result(publisher.publish(lib.project, alreadyWrittenMavenFiles), Duration.Inf)
      val count = published.count(x => x)
      if (count > 0) logger.warn(s"Published $count files")
      PhaseRes.Ok(PublishedSbtProject(lib.project)(lib.localIvyFiles, Some(published)))
    }
}
