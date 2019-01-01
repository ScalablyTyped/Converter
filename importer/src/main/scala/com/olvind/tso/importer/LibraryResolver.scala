package com.olvind.tso
package importer

import ammonite.ops.{exists, Path, RelPath}
import com.olvind.tso.importer.Source.{TsLibSource, TsSource}
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts.{ModuleNameParser, TsIdent, TsIdentLibrary, TsIdentModule}

class LibraryResolver(stdLib: Source, sourceFolders: Seq[InFolder], contribFolder: Option[InFolder]) {
  def inferredModule(path: Path, inLib: TsLibSource): TsIdentModule =
    ModuleNameParser(inLib.libName.`__value` +: path.relativeTo(inLib.folder.path).segments.to[List])

  def lookup(current: TsSource, value: String): Option[(Source, TsIdentModule)] =
    value match {
      case LocalPath(localPath) =>
        file(current.folder, localPath).map { file =>
          val modName = inferredModule(file.path, current.inLibrary)
          (Source.TsHelperFile(file, current.inLibrary, modName), modName)
        }

      case globalRef =>
        val modName = ModuleNameParser(globalRef.split("/").to[List])
        global(modName.inLibrary).map(source => (source, modName))
    }

  private val StableStd = TsIdent.std.value
  def global(libName: TsIdentLibrary): Option[Source] =
    (libName.value, contribFolder) match {
      case (StableStd, _) => Some(stdLib)
      case (ContribPath(contribPath), Some(folder)) =>
        resolve(folder.path, contribPath).headOption map { found =>
          Source.ContribSource(InFolder(found))
        }
      case _ =>
        sourceFolders.firstDefined(
          source =>
            (folder(source, libName.value) orElse
              folder(source, libName.`__value`)).map(folder => Source.FromFolder(folder, libName)) orElse
              file(source, libName.value).map(file          => Source.StdLibSource(file, libName))
        )
    }

  def file(folder: InFolder, fragment: String): Option[InFile] =
    resolve(folder.path, fragment, fragment + ".ts", fragment + ".d.ts", fragment + "/index.d.ts") find (_.isFile) map InFile.apply

  def folder(folder: InFolder, fragment: String): Option[InFolder] =
    resolve(folder.path, fragment) find (_.isDir) map InFolder.apply

  private def resolve(path: Path, frags: String*): Seq[Path] =
    frags.to[Seq].flatMap(frag => Option(path / RelPath(frag)) filter exists)

  private object LocalPath {
    def unapply(s: String): Option[String] = if (s.startsWith(".")) Some(s) else None
  }
  private object ContribPath {
    private val Suffix = "-contrib"
    def unapply(s: String): Option[String] =
      if (s.endsWith(Suffix)) Some(s.dropRight(Suffix.length))
      else None
  }
}
