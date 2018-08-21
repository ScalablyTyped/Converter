package com.olvind.tso
package ts

import ammonite.ops.{exists, Path, RelPath}
import com.olvind.tso.seqs.TraversableOps

object libraryResolver {
  def apply(sources: Seq[InFolder], current: TsSource, value: String): Option[(TsSource, TsIdentModule)] =
    value match {
      case LocalPath(localPath) =>
        resolveFile(current.folder, localPath).map { file =>
          val modName = ModuleNameParser.inferred(file.path, current.inLibrary)
          (TsSource.HelperFile(file, current.inLibrary, modName), modName)
        }

      case globalRef =>
        val modName = ModuleNameParser(globalRef.split("/").to[List])
        resolveGlobal(sources)(modName.inLibrary).map(source => (source, modName))
    }

  def resolveGlobal(sources: Seq[InFolder])(libName: TsIdentLibrary): Option[TsSource] =
    sources.firstDefined(
      source =>
        (resolveFolder(source, libName.value) orElse
          resolveFolder(source, libName.`__value`)).map(folder => TsSource.FromFolder(folder, libName)) orElse
          resolveFile(source, libName.value).map(file => TsSource.FromFile(file, libName))
    )

  def resolveFile(folder: InFolder, fragment: String): Option[InFile] =
    resolve(folder.path, fragment, fragment + ".ts", fragment + ".d.ts", fragment + "/index.d.ts") find (_.isFile) map InFile.apply

  def resolveFolder(folder: InFolder, fragment: String): Option[InFolder] =
    resolve(folder.path, fragment) find (_.isDir) map InFolder.apply

  private def resolve(path: Path, frags: String*): Seq[Path] =
    frags.to[Seq].flatMap(frag => Option(path / RelPath(frag)) filter exists)

  private object LocalPath {
    def unapply(s: String): Option[String] = if (s.startsWith(".")) Some(s) else None
  }
}
