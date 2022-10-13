package org.scalablytyped.converter.internal
package importer

import com.olvind.logging.Formatter
import org.scalablytyped.converter.internal.ts._

sealed trait LibTsSource extends TsTreeScope.TsLib {
  final def path: os.Path = folder.path
  def folder:  InFolder
  def libName: TsIdentLibrary

  private val pathString: String = path.toString

  override lazy val packageJsonOpt: Option[PackageJson] =
    Json.opt[PackageJson](folder.path / "package.json").orElse /* discover stdlib package.json as well */ (
      Json.opt[PackageJson](folder.path / os.up / "package.json"),
    )

  lazy val tsConfig: Option[TsConfig] =
    Json.opt[TsConfig](folder.path / "tsconfig.json")
}

object LibTsSource {
  def hasTypescriptSources(folder: InFolder): Boolean =
    os.walk.stream(folder.path, skip = _.last == "node_modules").exists(_.last.endsWith(".d.ts"))

  final case class StdLibSource(folder: InFolder, files: IArray[InFile], libName: TsIdentLibrary) extends LibTsSource

  final case class FromFolder(folder: InFolder, libName: TsIdentLibrary) extends LibTsSource

  implicit def SourceOrdering[S <: LibTsSource]: Ordering[S] =
    Ordering.by[S, String](_.pathString)
  implicit val SourceFormatter: Formatter[LibTsSource] =
    _.libName.value
}
