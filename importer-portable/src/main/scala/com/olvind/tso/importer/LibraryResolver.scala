package com.olvind.tso
package importer

import com.olvind.tso.importer.Source.{TsLibSource, TsSource}
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts.{ModuleNameParser, TsIdent, TsIdentLibrary, TsIdentModule}

class LibraryResolver(stdLib: Source, sourceFolders: Seq[InFolder], facadesFolder: Option[InFolder]) {
  def inferredModule(path: os.Path, inLib: TsLibSource): TsIdentModule = {
    val keepIndexPath = path.segments.toList.reverse match {
      case "index.d.ts" :: path :: rest =>
        val patchedSegments = rest.reverse :+ (path + ".d.ts")
        os.exists(os.Path(patchedSegments.mkString("/", "/", "")))
      case _ => false
    }
    ModuleNameParser(inLib.libName.`__value` +: path.relativeTo(inLib.folder.path).segments.to[List], keepIndexPath)
  }

  def lookup(current: TsSource, value: String): Option[(Source, TsIdentModule)] =
    value match {
      case LocalPath(localPath) =>
        file(current.folder, localPath).map { file =>
          val modName = inferredModule(file.path, current.inLibrary)
          (Source.TsHelperFile(file, current.inLibrary, modName), modName)
        }

      case globalRef =>
        val modName = ModuleNameParser(globalRef.split("/").to[List], keepIndexFragment = false)
        global(modName.inLibrary).map(source => (source, modName))
    }

  private val StableStd = TsIdent.std.value
  def global(libName: TsIdentLibrary): Option[Source] =
    (libName.value, facadesFolder) match {
      case (StableStd, _) => Some(stdLib)
      case (FacadePath(facadePath), Some(folder)) =>
        resolve(folder.path, facadePath).headOption.map(found => Source.FacadeSource(InFolder(found)))
      case _ =>
        sourceFolders.firstDefined(
          source =>
            (folder(source, libName.value) orElse
              folder(source, libName.`__value`)).map(folder => Source.FromFolder(folder, libName)),
        )
    }

  def file(folder: InFolder, fragment: String): Option[InFile] =
    resolve(folder.path, fragment, fragment + ".ts", fragment + ".d.ts", fragment + "/index.d.ts") collectFirst {
      case file if os.isFile(file) => InFile(file)
    }

  def folder(folder: InFolder, fragment: String): Option[InFolder] =
    resolve(folder.path, fragment) collectFirst { case dir if os.isDir(dir) => InFolder(dir) }

  private def resolve(path: os.Path, frags: String*): Seq[os.Path] =
    frags.to[Seq].flatMap(frag => Option(path / os.RelPath(frag.dropWhile(_ === '/'))) filter os.exists)

  private object LocalPath {
    def unapply(s: String): Option[String] = if (s.startsWith(".")) Some(s) else None
  }
  private object FacadePath {
    private val Suffix = "-facade"
    def unapply(s: String): Option[String] =
      if (s.endsWith(Suffix)) Some(s.dropRight(Suffix.length))
      else None
  }
}
