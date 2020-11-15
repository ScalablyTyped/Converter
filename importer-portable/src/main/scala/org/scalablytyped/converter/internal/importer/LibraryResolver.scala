package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.importer.Bootstrap.Unresolved
import org.scalablytyped.converter.internal.importer.LibraryResolver._
import org.scalablytyped.converter.internal.importer.Source.{StdLibSource, TsLibSource, TsSource}
import org.scalablytyped.converter.internal.seqs._
import org.scalablytyped.converter.internal.ts._
import os./

import scala.collection.immutable.SortedSet

class LibraryResolver(
    val stdLib: StdLibSource,
    allSources: IArray[Source.FromFolder],
    ignored:    Set[TsIdentLibrary],
) {

  private val byName: Map[TsIdentLibrary, TsLibSource] =
    allSources.groupBy(_.libName).mapValues(_.head).updated(TsIdent.std, stdLib)

  def module(current: TsSource, value: String): Option[(TsSource, TsIdentModule)] =
    value match {
      case LocalPath(localPath) =>
        file(current.folder, localPath).map { value =>
          val h = Source.helperFile(current.inLibrary)(value)
          (h, h.moduleNames.head)
        }
      case globalRef =>
        val modName = ModuleNameParser(globalRef.split("/").to[List], keepIndexFragment = true)
        library(modName.inLibrary) match {
          case Found(source)   => Some((source, modName))
          case Ignored(_)      => None
          case NotAvailable(_) => None
        }
    }

  def library(name: TsIdentLibrary): Res[TsLibSource] =
    if (ignored(name)) Ignored(name)
    else
      byName.get(name) match {
        case Some(source) => Found(source)
        case None         => NotAvailable(name)
      }

  def resolveAll(libs: SortedSet[TsIdentLibrary]): Either[Unresolved, Vector[TsLibSource]] =
    libs.toVector
      .map(library)
      .partitionCollect2(
        { case LibraryResolver.Found(x) => x },
        { case LibraryResolver.NotAvailable(name) => name },
      ) match {
      case (allFound, Seq(), _) => Right(allFound)
      case (_, notAvailable, _) => Left(Unresolved(notAvailable))
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
  case class Found[T](source: T) extends Res[T]
  case class Ignored(name: TsIdentLibrary) extends Res[Nothing]
  case class NotAvailable(name: TsIdentLibrary) extends Res[Nothing]

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
    resolve(folder.path, fragment, fragment + ".ts", fragment + ".d.ts", fragment + "/index.d.ts").collectFirst {
      case file if os.isFile(file) => InFile(file)
    }

  private def resolve(path: os.Path, frags: String*): IArray[os.Path] =
    IArray(frags: _*).mapNotNone(frag => Option(path / os.RelPath(frag.dropWhile(_ === '/'))).filter(files.exists))

  private object LocalPath {
    def unapply(s: String): Option[String] = if (s.startsWith(".")) Some(s) else None
  }
}
