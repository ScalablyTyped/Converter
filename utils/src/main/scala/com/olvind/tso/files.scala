package com.olvind.tso

import java.io._
import java.nio.file.Files
import java.nio.file.StandardOpenOption.{CREATE, TRUNCATE_EXISTING}
import java.util

sealed trait Synced
object Synced {
  case object New extends Synced
  case object Changed extends Synced
  case object Unchanged extends Synced
  case object Deleted extends Synced
}

final case class InFile(path: os.Path) {
  def folder: InFolder =
    InFolder(path / os.up)
}

object InFile {
  implicit object InFileKey extends IsKey[InFile]
}

final case class InFolder(path: os.Path) {
  def name: String = path.last
}

trait Layout[F, V] {
  def all: Map[F, V]
}

object files {
  val BOM = "\uFEFF"

  def content(file: InFile): String = {
    val ret = new String(os.read.bytes(file.path), constants.Utf8)
    if (ret.startsWith(BOM)) ret.replace(BOM, "") else ret
  }

  val IgnoreProjectFiles: os.Path => Boolean = p => {
    val name = p.last
    name === ".idea" || name === "target" || name === ".git"
  }

  def syncAbs(
      absolutePathFiles: Map[os.Path, Array[Byte]],
      folder:            os.Path,
      deleteUnknowns:    Boolean,
      soft:              Boolean,
  ): Unit = {

    if (deleteUnknowns)
      folder match {
        case f if os.exists(f) =>
          os.walk(f, IgnoreProjectFiles).foreach {
            case p if os.isFile(p) && !absolutePathFiles.contains(p) => os.remove.all(p)
            case _                                                   => ()
          }
        case _ => ()
      }

    absolutePathFiles.foreach {
      case (file, content) =>
        if (soft) softWriteBytes(file, content) else writeBytes(file, content)
    }
  }

  def sync(fs: Map[os.RelPath, Array[Byte]], folder: os.Path, deleteUnknowns: Boolean, soft: Boolean): Unit =
    syncAbs(fs.map {
      case (relPath, content) => folder / relPath -> content
    }, folder, deleteUnknowns, soft)

  def softWrite[T](path: os.Path)(f: PrintWriter => T): Synced = {
    val baos: ByteArrayOutputStream =
      new ByteArrayOutputStream(1024 * 1024)

    val writer = new PrintWriter(new OutputStreamWriter(baos, constants.Utf8))

    try f(writer)
    finally writer.close()

    softWriteBytes(path, baos.toByteArray)
  }

  def softWriteBytes[T](path: os.Path, newContent: Array[Byte]): Synced =
    (if (os.exists(path)) Some(os.read.bytes(path)) else None) match {
      case None => writeBytes(path, newContent)
      case Some(existingContent) if !util.Arrays.equals(existingContent, newContent) =>
        Files.write(path.toNIO, newContent, TRUNCATE_EXISTING)
        Synced.Changed
      case _ =>
        Synced.Unchanged
    }

  def writeBytes[T](path: os.Path, newContent: Array[Byte]): Synced = {
    os.makeDir.all(path / os.up)
    Files.write(path.toNIO, newContent, CREATE, TRUNCATE_EXISTING)
    Synced.New
  }
}
