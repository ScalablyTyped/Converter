package com.olvind.tso
package importer

import ammonite.ops._
import com.olvind.logging.Logger
import com.olvind.tso.importer.build._
import com.olvind.tso.phases.{GetDeps, IsCircular, Phase, PhaseRes}
import com.olvind.tso.ts._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

case class Phase4Publish(publisher: BinTrayPublisher)
    extends Phase[TsSource, PublishedSbtProject, PublishedSbtProject] {

  override def apply(source:  TsSource,
                     lib:     PublishedSbtProject,
                     getDeps: GetDeps[TsSource, PublishedSbtProject],
                     v4:      IsCircular,
                     logger:  Logger[Unit]): PhaseRes[TsSource, PublishedSbtProject] =
    getDeps(lib.project.deps.keys.to[Set]) flatMap { deps: Map[TsSource, PublishedSbtProject] =>
      /** This is somewhat annoying. The bintry thing we deploy with insists on
        *  receiving already written files. We just wrote them locally for ivy, so... */
      val alreadyWrittenMavenFiles: MavenLayout[RelPath, Path] =
        MavenLayout(lib.project,
                    lib.localIvyFiles.jarFile._1,
                    lib.localIvyFiles.sourceFile._1,
                    lib.localIvyFiles.pomFile._1,
        )

      val published: Iterable[(Int, String)] =
        Await.result(publisher.publish(lib.project, alreadyWrittenMavenFiles), Duration.Inf)

      println(published)
      PhaseRes.Ok(PublishedSbtProject(lib.project)(lib.localIvyFiles, Some(published)))
    }
}
