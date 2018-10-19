package com.olvind.tso

import java.io._
import java.nio.file.Files
import java.nio.file.StandardOpenOption.{CREATE, TRUNCATE_EXISTING}
import java.util

import ammonite.ops.{exists, ls, mkdir, rm, up, Path, RelPath}

sealed trait Synced
object Synced {
  case object New extends Synced
  case object Changed extends Synced
  case object Unchanged extends Synced
  case object Deleted extends Synced
}

final case class InFile(path: Path) {
  require(path.isFile)

  def folder: InFolder =
    InFolder(path / up)
}

object InFile {
  implicit object InFileKey extends IsKey[InFile]
}

final case class InFolder(path: Path) {
  def name: String = path.last
}

final case class OutFolder(folder: Path)

trait Layout[F, V] {
  def all: Map[F, V]
}

object files {
  val BOM = "\uFEFF"

  def contentBytes(file: InFile): Array[Byte] =
    Files readAllBytes file.path.toNIO

  def content(file: InFile): String = {
    val ret = new String(contentBytes(file), constants.Utf8)
    if (ret.startsWith(BOM)) ret.replace(BOM, "") else ret
  }

  val IgnoreProjectFiles: Path => Boolean = p => {
    val name = p.segments.last
    name === ".idea" || name === "target"
  }

  def sync(fs: Map[RelPath, Array[Byte]], folder: Path): Map[Path, Synced] = {

    val absolutePathFiles: Map[Path, Array[Byte]] = fs.map {
      case (relPath, content) => folder / relPath -> content
    }

    val deleted: Map[Path, Synced] =
      folder match {
        case Exists(f) =>
          ls.rec(IgnoreProjectFiles)(f)
            .filterNot(absolutePathFiles.contains)
            .filter(_.isFile)
            .map { p: Path =>
              rm(p)
              p -> Synced.Deleted
            }
            .toMap
        case _ => Map.empty
      }

    val writtenFiles: Map[Path, Synced] =
      absolutePathFiles.map {
        case (file, content) => (file, softWriteBytes(file, content))
      }

    deleted ++ writtenFiles
  }

  def write(fs: Map[Path, Array[Byte]]): Map[Path, Synced] =
    fs.map {
      case (file, content) => (file, softWriteBytes(file, content))
    }

  def softWrite[T](path: Path)(f: PrintWriter => T): Synced = {
    val baos: ByteArrayOutputStream =
      new ByteArrayOutputStream(1024 * 1024)

    val writer = new PrintWriter(new OutputStreamWriter(baos, constants.Utf8))

    try f(writer)
    finally writer.close()

    softWriteBytes(path, baos.toByteArray)
  }

  def softWriteBytes[T](path: Path, newContent: Array[Byte]): Synced =
    (if (exists(path)) Some(contentBytes(InFile(path))) else None) match {
      case None =>
        mkdir(path / up)
        Files.write(path.toNIO, newContent, CREATE)
        Synced.New
      case Some(existingContent) if !util.Arrays.equals(existingContent, newContent) =>
        Files.write(path.toNIO, newContent, TRUNCATE_EXISTING)
        Synced.Changed
      case _ =>
        Synced.Unchanged
    }

  object Exists {
    def unapply(path: Path): Option[Path] =
      Some(path) filter exists
  }
}
