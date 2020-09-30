package org.scalablytyped.converter.internal

import java.io._
import java.nio.file.StandardOpenOption.{CREATE, TRUNCATE_EXISTING}
import java.nio.file.{Files, Path}
import java.util

import ammonite.ops.%
import org.scalablytyped.converter.internal.environment.OpSystem

import scala.util.Try

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
  // os.exists is too slow because it throws exceptions behind the scenes
  def exists(path: os.Path): Boolean = path.toIO.exists()

  def content(file: InFile): String =
    new String(os.read.bytes(file.path), constants.Utf8)

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
        case f if files.exists(f) =>
          os.walk(f, IgnoreProjectFiles).foreach {
            case p if os.isFile(p) && !absolutePathFiles.contains(p) => deleteAll(p)
            case _                                                   => ()
          }
        case _ => ()
      }

    absolutePathFiles.foreach {
      case (file, content) =>
        if (soft) softWriteBytes(file.toNIO, content) else writeBytes(file.toNIO, content)
    }
  }

  def sync(fs: Map[os.RelPath, Array[Byte]], folder: os.Path, deleteUnknowns: Boolean, soft: Boolean): Unit =
    syncAbs(fs.map { case (relPath, content) => folder / relPath -> content }, folder, deleteUnknowns, soft)

  def softWrite[T](path: os.Path)(f: PrintWriter => T): Synced =
    softWrite(path.toNIO)(f)

  def softWrite[T](path: Path)(f: PrintWriter => T): Synced = {
    val baos: ByteArrayOutputStream =
      new ByteArrayOutputStream(1024 * 1024)

    val writer = new PrintWriter(new OutputStreamWriter(baos, constants.Utf8))

    try f(writer)
    finally writer.close()

    softWriteBytes(path, baos.toByteArray)
  }
  def softWriteBytes(path: os.Path, newContent: Array[Byte]): Synced = softWriteBytes(path.toNIO, newContent)

  def softWriteBytes(path: Path, newContent: Array[Byte]): Synced =
    (if (Files.exists(path)) Some(Files.readAllBytes(path)) else None) match {
      case None => writeBytes(path, newContent)
      case Some(existingContent) if !util.Arrays.equals(existingContent, newContent) =>
        Files.write(path, newContent, TRUNCATE_EXISTING)
        Synced.Changed
      case _ =>
        Synced.Unchanged
    }

  def writeBytes[T](path: Path, newContent: Array[Byte]): Synced = {
    Files.createDirectories(path.getParent)
    Files.write(path, newContent, CREATE, TRUNCATE_EXISTING)
    Synced.New
  }

  def existing(p: os.Path): os.Path = {
    os.makeDir.all(p)
    p
  }

  def existing(p: Path): Path = {
    Files.createDirectories(p)
    p
  }

  def existingEmpty(p: os.Path): os.Path = {
    Try(deleteAll(p))
    existing(p)
  }

  def deleteAll(p: os.Path): Unit =
    environment.OS match {
      case OpSystem.WINDOWS => os.remove.all(p)
      case _ => {
        implicit val wd = os.home
        %.rm("-Rf", p)
      }
    }
}
