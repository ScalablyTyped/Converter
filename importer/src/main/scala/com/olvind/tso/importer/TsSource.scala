package com.olvind.tso.importer

import ammonite.ops.Path
import com.olvind.logging.Formatter
import com.olvind.tso.importer.TsSource.TsLibSource
import com.olvind.tso.ts.{TsIdentLibrary, TsIdentModule}
import com.olvind.tso.{InFile, InFolder, Key}

sealed abstract class TsSource(val folder: InFolder) {
  final def path: Path =
    this match {
      case TsSource.StdLibSource(InFile(path), _)  => path
      case TsSource.FromFolder(InFolder(path), _)  => path
      case TsSource.HelperFile(InFile(path), _, _) => path
    }

  final def inLibrary: TsSource.TsLibSource =
    this match {
      case x: TsLibSource => x
      case TsSource.HelperFile(_, x, _) => x
    }

  private lazy val key: String = path.toString
}

object TsSource {
  sealed trait TsLibSource extends TsSource {
    val libName: TsIdentLibrary
  }

  case class StdLibSource(file: InFile, libName: TsIdentLibrary) extends TsSource(file.folder) with TsLibSource

  case class FromFolder(override val folder: InFolder, libName: TsIdentLibrary)
      extends TsSource(folder)
      with TsLibSource

  case class HelperFile(file: InFile, inLib: TsLibSource, moduleName: TsIdentModule) extends TsSource(file.folder)

  implicit val TsSourceKey:       Key[TsSource]       = Key.of[TsSource, String](_.key)
  implicit val TsSourceOrdering:  Ordering[TsSource]  = Ordering.by[TsSource, String](_.path.toString())
  implicit val TsSourceFormatter: Formatter[TsSource] = _.inLibrary.libName.value
}
