package org.scalablytyped.converter.internal.importer.build

import org.scalablytyped.converter.internal.IArray
import org.scalablytyped.converter.internal.scalajs.Dep

trait Layout[F, V] {
  type Self[f, v] <: Layout[f, v]

  def all: IArray[(F, V)]

  def map[FF, VV](f: (F, V) => (FF, VV)): Self[FF, VV]

  final def mapFiles[FF](f: F => FF): Self[FF, V] =
    map { case (k, v) => f(k) -> v }

  final def mapValues[VV](f: (F, V) => VV): Self[F, VV] =
    map { case (k, v) => k -> f(k, v) }
}

final case class MapLayout[F, V](all: IArray[(F, V)]) extends Layout[F, V] {
  override type Self[f, v] = MapLayout[f, v]

  override def map[FF, VV](f: (F, V) => (FF, VV)): MapLayout[FF, VV] =
    MapLayout[FF, VV](all.map { case (k, v) => (f(k, v)) })
}

final case class SbtProjectLayout[F, V](
    buildSbt:        (F, V),
    buildProperties: (F, V),
    pluginsSbt:      (F, V),
    readmeMd:        (F, V),
    sourcesDir:      IArray[(F, V)],
    resourcesDir:    IArray[(F, V)],
) extends Layout[F, V] {
  override type Self[f, v] = SbtProjectLayout[f, v]
  override def all: IArray[(F, V)] =
    IArray(buildSbt, buildProperties, pluginsSbt, readmeMd) ++ sourcesDir ++ resourcesDir

  override def map[FF, VV](f: (F, V) => (FF, VV)): SbtProjectLayout[FF, VV] =
    this match {
      case SbtProjectLayout((_1k, _1v), (_2k, _2v), (_3k, _3v), (_4k, _4v), sources, resources) =>
        SbtProjectLayout(
          f(_1k, _1v),
          f(_2k, _2v),
          f(_3k, _3v),
          f(_4k, _4v),
          sources.map { case (k, v)   => f(k, v) },
          resources.map { case (k, v) => f(k, v) },
        )
    }
}

final case class IvyLayout[F, V](jarFile: (F, V), sourceFile: (F, V), ivyFile: (F, V), pomFile: (F, V))
    extends Layout[F, V] {
  override type Self[f, v] = IvyLayout[f, v]
  override def all: IArray[(F, V)] = IArray(jarFile, sourceFile, ivyFile, pomFile)
  override def map[FF, VV](f: (F, V) => (FF, VV)): IvyLayout[FF, VV] =
    this match {
      case IvyLayout((_1k, _1v), (_2k, _2v), (_3k, _3v), (_4k, _4v)) =>
        IvyLayout(f(_1k, _1v), f(_2k, _2v), f(_3k, _3v), f(_4k, _4v))
    }
}

object IvyLayout {
  def unit(p: Dep.Concrete): IvyLayout[os.RelPath, Unit] =
    apply(p, (), (), (), ())

  def apply[T](p: Dep.Concrete, jarFile: T, sourceFile: T, ivyFile: T, pomFile: T): IvyLayout[os.RelPath, T] = {
    val libraryPath = os.RelPath(p.org) / p.mangledArtifact / os.RelPath(p.version)
    IvyLayout(
      jarFile    = libraryPath / 'jars / s"${p.mangledArtifact}.jar" -> jarFile,
      sourceFile = libraryPath / 'srcs / s"${p.mangledArtifact}-sources.jar" -> sourceFile,
      ivyFile    = libraryPath / 'ivys / "ivy.xml" -> ivyFile,
      pomFile    = libraryPath / 'poms / s"${p.mangledArtifact}.pom" -> pomFile,
    )
  }
}

final case class MavenLayout[F, V](jarFile: (F, V), sourceFile: (F, V), pomFile: (F, V)) extends Layout[F, V] {
  override def all: IArray[(F, V)] = IArray(jarFile, sourceFile, pomFile)
  override type Self[f, v] = MavenLayout[f, v]
  override def map[FF, VV](f: (F, V) => (FF, VV)): MavenLayout[FF, VV] =
    this match {
      case MavenLayout((_1k, _1v), (_2k, _2v), (_3k, _3v)) => MavenLayout(f(_1k, _1v), f(_2k, _2v), f(_3k, _3v))
    }
}

object MavenLayout {
  def apply[T](p: Dep.Concrete, jarFile: T, sourceFile: T, pomFile: T): MavenLayout[os.RelPath, T] = {
    val org: os.RelPath =
      p.org.split("\\.").foldLeft(os.RelPath(""))(_ / _)

    def baseFile(ext: String): os.RelPath =
      org / p.mangledArtifact / p.version / s"${p.mangledArtifact}-${p.version}$ext"

    MavenLayout(
      jarFile    = baseFile(".jar") -> jarFile,
      sourceFile = baseFile("-sources.jar") -> sourceFile,
      pomFile    = baseFile(".pom") -> pomFile,
    )
  }
}
