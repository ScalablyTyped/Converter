package com.olvind.tso
package importer

import com.olvind.tso.importer.Source.{StdLibSource, TsLibSource, TsSource}
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts._

class LibraryResolver(stdLib: StdLibSource, sourceFolders: Seq[InFolder], facadesFolder: Option[InFolder]) {
  import LibraryResolver._

  def module(current: TsSource, value: String): Option[(TsSource, TsIdentModule)] =
    value match {
      case LocalPath(localPath) =>
        file(current.folder, localPath).map(Source.helperFile(current.inLibrary)).map(h => (h, h.moduleNames.head))
      case globalRef =>
        val modName = ModuleNameParser(globalRef.split("/").to[List], keepIndexFragment = false)
        library(modName.inLibrary).map(source => (source, modName))
    }

  def library(libName: TsIdentLibrary): Option[TsLibSource] =
    libName.value match {
      case StableStd => Some(stdLib)
      case _ =>
        sourceFolders.firstDefined(source =>
          (folder(source, libName.value) orElse
            folder(source, libName.`__value`)).map(folder => Source.FromFolder(folder, libName)),
        )
    }

  def libraryOrFacade(libName: TsIdentLibrary): Option[Source] =
    library(libName).orElse {
      (libName.value, facadesFolder) match {
        case (FacadePath(facadePath), Some(folder)) =>
          resolve(folder.path, facadePath).headOption.map(found => Source.FacadeSource(InFolder(found)))
        case _ => None
      }
    }
}

object LibraryResolver {
  val StableStd = TsIdent.std.value

  def moduleNameFor(source: TsLibSource, file: InFile): List[TsIdentModule] = {
    val shortened: List[TsIdentModule] =
      if (source.shortenedFiles.contains(file)) {
        source.libName match {
          case TsIdentLibraryScoped(scope, name) =>
            List(TsIdentModule(Some(scope), List(name)))
          case TsIdentLibrarySimple(value) =>
            List(TsIdentModule(None, value :: Nil))
        }
      } else Nil

    val longName: TsIdentModule = {
      val keepIndexPath = file.path.segments.toList.reverse match {
        case "index.d.ts" :: path :: rest =>
          val patchedSegments = rest.reverse :+ (path + ".d.ts")
          os.exists(os.Path(patchedSegments.mkString("/", "/", "")))
        case _ => false
      }

      ModuleNameParser(
        source.libName.`__value` +: file.path.relativeTo(source.folder.path).segments.to[List],
        keepIndexPath,
      )
    }

    shortened :+ longName
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
