package com.olvind.tso.importer.build
import ammonite.ops.RelPath
import com.olvind.tso.Seq

trait Layout[F, V] {
  def all: Map[F, V]
}

final case class SbtProjectLayout[F, V](
    buildSbt:        (F, V),
    buildProperties: (F, V),
    pluginsSbt:      (F, V),
    readmeMd:        (F, V),
    sourcesDir:      Map[F, V]
) extends Layout[F, V] {
  def all: Map[F, V] = Seq(buildSbt, buildProperties, pluginsSbt, readmeMd).toMap ++ sourcesDir
}

final case class IvyLayout[F, V](jarFile: (F, V), sourceFile: (F, V), ivyFile: (F, V), pomFile: (F, V))
    extends Layout[F, V] {
  def all: Map[F, V] = Seq(jarFile, sourceFile, ivyFile, pomFile).toMap

  def mapIvy[VV](jarFile: V => VV, sourceFile: V => VV, ivyFile: V => VV, pomFile: V => VV): IvyLayout[F, VV] =
    this match {
      case IvyLayout((_1k, _1v), (_2k, _2v), (_3k, _3v), (_4k, _4v)) =>
        IvyLayout(_1k -> jarFile(_1v), _2k -> sourceFile(_2v), _3k -> ivyFile(_3v), _4k -> pomFile(_4v))
    }

  def mapFiles[FF](f: F => FF): IvyLayout[FF, V] =
    this match {
      case IvyLayout((_1k, _1v), (_2k, _2v), (_3k, _3v), (_4k, _4v)) =>
        IvyLayout(f(_1k) -> _1v, f(_2k) -> _2v, f(_3k) -> _3v, f(_4k) -> _4v)
    }

  def mapValues[VV](f: (F, V) => VV): IvyLayout[F, VV] =
    this match {
      case IvyLayout((_1k, _1v), (_2k, _2v), (_3k, _3v), (_4k, _4v)) =>
        IvyLayout(_1k -> f(_1k, _1v), _2k -> f(_2k, _2v), _3k -> f(_3k, _3v), _4k -> f(_4k, _4v))
    }
}

object IvyLayout {
  val Unit = ()

  def apply(p: SbtProject): IvyLayout[RelPath, Unit] = {
    val libraryPath = RelPath(p.organization) / p.artifactId / p.version
    IvyLayout(
      jarFile    = libraryPath / 'jars / s"${p.artifactId}.jar" -> Unit,
      sourceFile = libraryPath / 'srcs / s"${p.artifactId}-sources.jar" -> Unit,
      ivyFile    = libraryPath / 'ivys / "ivy.xml" -> Unit,
      pomFile    = libraryPath / 'poms / s"${p.artifactId}.pom" -> Unit
    )
  }
}

final case class MavenLayout[F, V](jarFile: (F, V), sourceFile: (F, V), pomFile: (F, V)) extends Layout[F, V] {
  def all: Map[F, V] = Seq(jarFile, sourceFile, pomFile).toMap

  def mapMaven[VV](jarFile: V => VV, sourceFile: V => VV, pomFile: V => VV): MavenLayout[F, VV] =
    this match {
      case MavenLayout((_1k, _1v), (_2k, _2v), (_3k, _3v)) =>
        MavenLayout(_1k -> jarFile(_1v), _2k -> sourceFile(_2v), _3k -> pomFile(_3v))
    }
}

object MavenLayout {
  def apply[T](p: SbtProject, jarFile: T, sourceFile: T, pomFile: T): MavenLayout[RelPath, T] = {
    val org: RelPath =
      p.organization.split("\\.").foldLeft(RelPath(""))(_ / _)

    def baseFile(ext: String): RelPath =
      org / p.artifactId / p.version / s"${p.artifactId}-${p.version}$ext"

    MavenLayout(
      jarFile    = baseFile(".jar") -> jarFile,
      sourceFile = baseFile("-sources.jar") -> sourceFile,
      pomFile    = baseFile(".pom") -> pomFile
    )
  }
}
