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
  def folder: InFolder =
    InFolder(path / up)
}

object InFile {
  implicit object InFileKey extends IsKey[InFile]
}

final case class InFolder(path: Path) {
  def name: String = path.last
}

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

  def sync(fs: Map[RelPath, Array[Byte]], folder: Path, deleteUnknowns: Boolean, soft: Boolean): Unit = {

    val absolutePathFiles: Map[Path, Array[Byte]] = fs.map {
      case (relPath, content) => folder / relPath -> content
    }

    if (soft && deleteUnknowns)
      folder match {
        case Exists(f) =>
          ls.rec(IgnoreProjectFiles)(f).foreach {
            case files.IsNormalFile(p) if !absolutePathFiles.contains(p) => rm(p)
            case _                                                       => ()
          }
        case _ => ()
      }

    absolutePathFiles.foreach {
      case (file, content) =>
        if (soft) softWriteBytes(file, content) else writeBytes(file, content)
    }
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
      case None => writeBytes(path, newContent)
      case Some(existingContent) if !util.Arrays.equals(existingContent, newContent) =>
        Files.write(path.toNIO, newContent, TRUNCATE_EXISTING)
        Synced.Changed
      case _ =>
        Synced.Unchanged
    }

  def writeBytes[T](path: Path, newContent: Array[Byte]): Synced = {
    mkdir(path / up)
    Files.write(path.toNIO, newContent, CREATE)
    Synced.New
  }

  object Exists {
    def unapply(path: Path): Option[Path] =
      Some(path) filter exists
  }

  object IsNormalFile {
    def apply(path: Path): Boolean =
      Files.isRegularFile(path.toNIO)

    def unapply(path: Path): Option[Path] =
      if (IsNormalFile(path)) Some(path) else None
  }

  object IsDirectory {
    def apply(path: Path): Boolean =
      Files.isDirectory(path.toNIO)
    def unapply(path: Path): Option[Path] =
      if (IsDirectory(path)) Some(path) else None
  }
}
