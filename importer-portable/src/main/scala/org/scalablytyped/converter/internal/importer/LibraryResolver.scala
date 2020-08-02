package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.importer.Source.{StdLibSource, TsLibSource, TsSource}
import org.scalablytyped.converter.internal.ts._
import os./

class LibraryResolver(stdLib: StdLibSource, sourceFolders: IArray[InFolder]) {
  import LibraryResolver._

  def module(current: TsSource, value: String): Option[(TsSource, TsIdentModule)] =
    value match {
      case LocalPath(localPath) =>
        file(current.folder, localPath).map(Source.helperFile(current.inLibrary)).map(h => (h, h.moduleNames.head))
      case globalRef =>
        val modName = ModuleNameParser(globalRef.split("/").to[List], keepIndexFragment = true)
        library(modName.inLibrary).map(source => (source, modName))
    }

  def library(libName: TsIdentLibrary): Option[TsLibSource] =
    libName.value match {
      case StableStd => Some(stdLib)
      case _ =>
        sourceFolders.firstDefined(sourceFolder =>
          folder(libName, sourceFolder, libName.value) orElse folder(libName, sourceFolder, libName.`__value`),
        )
    }
}

object LibraryResolver {
  val StableStd = TsIdent.std.value

  def moduleNameFor(source: TsLibSource, file: InFile): IArray[TsIdentModule] = {
    val shortened: Option[TsIdentModule] =
      if (source.shortenedFiles.contains(file)) {
        source.libName match {
          case TsIdentLibraryScoped(scope, name) =>
            Some(TsIdentModule(Some(scope), List(name)))
          case TsIdentLibrarySimple(value) =>
            Some(TsIdentModule(None, value :: Nil))
        }
      } else None

    val longName: TsIdentModule = {
      val keepIndexPath = file.path match {
        case base / segment / "index.d.ts" => files.exists(base / segment.concat(".d.ts"))
        case _                             => false
      }

      ModuleNameParser(
        source.libName.`__value` +: file.path.relativeTo(source.folder.path).segments.to[List],
        keepIndexPath,
      )
    }

    val ret = IArray.fromOptions(shortened, Some(longName))

    /* some libraries contain multiple directory trees with type definitions, and refer to just one of them through
     * `typings` in package.json for instance.
     *
     * Remarkably it can reach into one of the other trees even if the current tree has everything needed.
     * This resolves the most common case, and fixes antd 4 in particular */
    val inParallelDirectory = ret.collect {
      case TsIdentModule(scopeOpt, fragments) if fragments.contains("lib") =>
        TsIdentModule(scopeOpt, fragments.map { case "lib" => "es"; case other => other })
      case TsIdentModule(scopeOpt, fragments) if fragments.contains("es") =>
        TsIdentModule(scopeOpt, fragments.map { case "es" => "lib"; case other => other })
    }

    ret ++ inParallelDirectory
  }

  def file(folder: InFolder, fragment: String): Option[InFile] =
    resolve(folder.path, fragment, fragment + ".ts", fragment + ".d.ts", fragment + "/index.d.ts") collectFirst {
      case file if os.isFile(file) => InFile(file)
    }

  def folder(libName: TsIdentLibrary, folder: InFolder, fragment: String): Option[Source.FromFolder] =
    resolve(folder.path, fragment) firstDefined {
      case dir if os.isDir(dir) =>
        val s = Source.FromFolder(InFolder(dir), libName)
        if (s.hasSources) Some(s) else None
      case _ => None
    }

  private def resolve(path: os.Path, frags: String*): IArray[os.Path] =
    IArray(frags: _*).mapNotNone(frag => Option(path / os.RelPath(frag.dropWhile(_ === '/'))) filter files.exists)

  private object LocalPath {
    def unapply(s: String): Option[String] = if (s.startsWith(".")) Some(s) else None
  }
}
