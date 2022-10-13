package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.importer.LibraryResolver._
import org.scalablytyped.converter.internal.ts._
import os./

class LibraryResolver(
    val stdLib: LibTsSource.StdLibSource,
    allSources: IArray[LibTsSource.FromFolder],
    ignored:    Set[TsIdentLibrary],
) {
  private val byName: Map[TsIdentLibrary, LibTsSource] =
    allSources.groupBy(_.libName).mapValues(_.head).updated(TsIdent.std, stdLib)

  def module(source: LibTsSource, folder: InFolder, value: String): Option[ResolvedModule] =
    value match {
      case LocalPath(localPath) =>
        file(folder, localPath).map { inFile =>
          ResolvedModule.Local(inFile, LibraryResolver.moduleNameFor(source, inFile))
        }
      case globalRef =>
        val modName = ModuleNameParser(globalRef.split("/").to[List], keepIndexFragment = true)
        library(modName.inLibrary) match {
          case Found(source)   => Some(ResolvedModule.NotLocal(source, modName))
          case Ignored(_)      => None
          case NotAvailable(_) => None
        }
    }

  def library(name: TsIdentLibrary): Res[LibTsSource] =
    if (ignored(name)) Ignored(name)
    else
      byName.get(name) match {
        case Some(source) => Found(source)
        case None         => NotAvailable(name)
      }
}

object LibraryResolver {
  sealed trait Res[+T] {
    def toOption: Option[T] =
      this match {
        case Found(source)   => Some(source)
        case Ignored(_)      => None
        case NotAvailable(_) => None
      }
    def map[U](f: T => U): Res[U] =
      this match {
        case Found(source) => Found(f(source))
        case x: Ignored      => x
        case x: NotAvailable => x
      }
  }
  case class Found[T](source:   T) extends Res[T]
  case class Ignored(name:      TsIdentLibrary) extends Res[Nothing]
  case class NotAvailable(name: TsIdentLibrary) extends Res[Nothing]

  def moduleNameFor(source: LibTsSource, file: InFile): TsIdentModule = {
    val keepIndexPath = file.path match {
      case base / segment / "index.d.ts" => files.exists(base / segment.concat(".d.ts"))
      case _                             => false
    }

    ModuleNameParser(
      source.libName.`__value` +: file.path.relativeTo(source.folder.path).segments.to[List],
      keepIndexPath,
    )
  }

  def file(within: InFolder, fragment: String): Option[InFile] =
    resolve(within.path, fragment, fragment + ".ts", fragment + ".d.ts", fragment + "/index.d.ts").collectFirst {
      case file if os.isFile(file) => InFile(file)
    }

  private def resolve(within: os.Path, frags: String*): IArray[os.Path] =
    IArray(frags: _*).mapNotNone(frag => Option(within / os.RelPath(frag.dropWhile(_ === '/'))).filter(files.exists))

  private object LocalPath {
    def unapply(s: String): Option[String] = if (s.startsWith(".")) Some(s) else None
  }
}
