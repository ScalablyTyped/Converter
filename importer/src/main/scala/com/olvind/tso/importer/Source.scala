package com.olvind.tso.importer

import com.olvind.logging.Formatter
import com.olvind.tso.ts._
import com.olvind.tso.{InFile, InFolder, Key}

sealed trait Source {
  final def path: os.Path =
    this match {
      case Source.StdLibSource(InFile(path), _)    => path
      case Source.FromFolder(InFolder(path), _)    => path
      case Source.TsHelperFile(InFile(path), _, _) => path
      case Source.FacadeSource(InFolder(path))     => path
    }

  def folder:  InFolder
  def libName: TsIdentLibrary

  private lazy val key: String = path.toString
}

object Source {
  sealed trait TsSource extends Source {
    final def inLibrary: Source.TsLibSource =
      this match {
        case x: TsLibSource => x
        case Source.TsHelperFile(_, x, _) => x
      }
  }

  sealed trait TsLibSource extends TsSource with TsTreeScope.TsLib {
    import jsonCodecs._

    override lazy val packageJsonOpt: Option[PackageJsonDeps] =
      Json.opt[PackageJsonDeps](folder.path / "package.json", println(_)) orElse
        /* discover stdlib package.json as well */
        Json.opt[PackageJsonDeps](folder.path / os.up / "package.json", println(_))

    override lazy val tsConfig: Option[TsConfig] =
      Json.opt[TsConfig](folder.path / "tsconfig.json", println(_))

    override lazy val impliedPath: Option[os.RelPath] = {
      packageJsonOpt.flatMap(_.types) orElse packageJsonOpt.flatMap(_.typings) flatMap { value =>
        val typingsFolder = folder.path / os.RelPath(value) / os.up
        typingsFolder relativeTo folder.path match {
          case empty if empty.segments.isEmpty => None
          case other                           => Some(other)
        }
      }
    }
  }

  final case class StdLibSource(file: InFile, libName: TsIdentLibrary) extends TsLibSource {
    override def folder: InFolder = file.folder
  }

  final case class FromFolder(folder: InFolder, libName: TsIdentLibrary) extends TsLibSource

  final case class TsHelperFile(file: InFile, inLib: TsLibSource, moduleName: TsIdentModule) extends TsSource {
    override def libName: TsIdentLibrary = inLib.libName
    override def folder:  InFolder       = file.folder
  }

  final case class FacadeSource(folder: InFolder) extends Source {
    override val libName = TsIdentLibrarySimple(folder.path.last + "-" + "facade")
  }

  implicit val SourceKey:                   Key[Source]       = Key.of[Source, String](_.key)
  implicit def SourceOrdering[S <: Source]: Ordering[S]       = Ordering.by[S, String](_.key)
  implicit val SourceFormatter:             Formatter[Source] = _.libName.value
}
