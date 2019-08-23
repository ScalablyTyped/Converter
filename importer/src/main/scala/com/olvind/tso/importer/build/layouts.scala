package com.olvind.tso.importer.build

import com.olvind.tso.Seq

trait Layout[F, V] {
  type Self[f, v] <: Layout[f, v]

  def all: Map[F, V]

  def map[FF, VV](f: (F, V) => (FF, VV)): Self[FF, VV]

  final def mapFiles[FF](f: F => FF): Self[FF, V] =
    map { case (k, v) => f(k) -> v }

  final def mapValues[VV](f: (F, V) => VV): Self[F, VV] =
    map { case (k, v) => k -> f(k, v) }
}

final case class SbtProjectLayout[F, V](
    buildSbt:        (F, V),
    buildProperties: (F, V),
    pluginsSbt:      (F, V),
    readmeMd:        (F, V),
    sourcesDir:      Map[F, V],
    resourcesDir:    Map[F, V],
) extends Layout[F, V] {
  override type Self[f, v] = SbtProjectLayout[f, v]
  override def all: Map[F, V] =
    (Seq(buildSbt, buildProperties, pluginsSbt, readmeMd)).toMap ++ sourcesDir ++ resourcesDir

  override def map[FF, VV](f: (F, V) => (FF, VV)): SbtProjectLayout[FF, VV] =
    this match {
      case SbtProjectLayout((_1k, _1v), (_2k, _2v), (_3k, _3v), (_4k, _4v), sources, resources) =>
        SbtProjectLayout(
          f(_1k, _1v),
          f(_2k, _2v),
          f(_3k, _3v),
          f(_4k, _4v),
          sources map { case (k, v)   => f(k, v) },
          resources map { case (k, v) => f(k, v) },
        )
    }
}

final case class IvyLayout[F, V](jarFile: (F, V), sourceFile: (F, V), ivyFile: (F, V), pomFile: (F, V))
    extends Layout[F, V] {
  override type Self[f, v] = IvyLayout[f, v]
  override def all: Map[F, V] = Seq(jarFile, sourceFile, ivyFile, pomFile).toMap
  override def map[FF, VV](f: (F, V) => (FF, VV)): IvyLayout[FF, VV] =
    this match {
      case IvyLayout((_1k, _1v), (_2k, _2v), (_3k, _3v), (_4k, _4v)) =>
        IvyLayout(f(_1k, _1v), f(_2k, _2v), f(_3k, _3v), f(_4k, _4v))
    }
}

object IvyLayout {
  def apply[T](p: SbtProject, jarFile: T, sourceFile: T, ivyFile: T, pomFile: T): IvyLayout[os.RelPath, T] = {
    val libraryPath = os.RelPath(p.organization) / p.artifactId / p.version
    IvyLayout(
      jarFile    = libraryPath / 'jars / s"${p.artifactId}.jar" -> jarFile,
      sourceFile = libraryPath / 'srcs / s"${p.artifactId}-sources.jar" -> sourceFile,
      ivyFile    = libraryPath / 'ivys / "ivy.xml" -> ivyFile,
      pomFile    = libraryPath / 'poms / s"${p.artifactId}.pom" -> pomFile,
    )
  }
}

final case class MavenLayout[F, V](jarFile: (F, V), sourceFile: (F, V), pomFile: (F, V)) extends Layout[F, V] {
  override def all: Map[F, V] = Seq(jarFile, sourceFile, pomFile).toMap
  override type Self[f, v] = MavenLayout[f, v]
  override def map[FF, VV](f: (F, V) => (FF, VV)): MavenLayout[FF, VV] =
    this match {
      case MavenLayout((_1k, _1v), (_2k, _2v), (_3k, _3v)) => MavenLayout(f(_1k, _1v), f(_2k, _2v), f(_3k, _3v))
    }
}

object MavenLayout {
  def apply[T](p: SbtProject, jarFile: T, sourceFile: T, pomFile: T): MavenLayout[os.RelPath, T] = {
    val org: os.RelPath =
      p.organization.split("\\.").foldLeft(os.RelPath(""))(_ / _)

    def baseFile(ext: String): os.RelPath =
      org / p.artifactId / p.version / s"${p.artifactId}-${p.version}$ext"

    MavenLayout(
      jarFile    = baseFile(".jar") -> jarFile,
      sourceFile = baseFile("-sources.jar") -> sourceFile,
      pomFile    = baseFile(".pom") -> pomFile,
    )
  }
}
