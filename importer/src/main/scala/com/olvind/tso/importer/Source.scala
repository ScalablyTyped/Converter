package com.olvind.tso.importer

import ammonite.ops.Path
import com.olvind.logging.Formatter
import com.olvind.tso.ts.{TsIdentLibrary, TsIdentLibrarySimple, TsIdentModule}
import com.olvind.tso.{InFile, InFolder, Key}

sealed trait Source {
  final def path: Path =
    this match {
      case Source.StdLibSource(InFile(path), _)    => path
      case Source.FromFolder(InFolder(path), _)    => path
      case Source.TsHelperFile(InFile(path), _, _) => path
      case Source.ContribSource(InFolder(path))    => path
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

  sealed trait TsLibSource extends TsSource

  final case class StdLibSource(file: InFile, libName: TsIdentLibrary) extends TsLibSource {
    override def folder: InFolder = file.folder
  }

  final case class FromFolder(folder: InFolder, libName: TsIdentLibrary) extends TsLibSource

  final case class TsHelperFile(file: InFile, inLib: TsLibSource, moduleName: TsIdentModule) extends TsSource {
    override def libName: TsIdentLibrary = inLib.libName
    override def folder:  InFolder       = file.folder
  }

  final case class ContribSource(folder: InFolder) extends Source {
    override val libName = TsIdentLibrarySimple(folder.path.name + "-" + "contrib")
  }

  implicit val SourceKey:                   Key[Source]       = Key.of[Source, String](_.key)
  implicit def SourceOrdering[S <: Source]: Ordering[S]       = Ordering.by[S, String](_.key)
  implicit val SourceFormatter:             Formatter[Source] = _.libName.value
}
