package org.scalablytyped.converter.internal
package importer

import java.io._
import java.nio.ByteBuffer
import java.nio.channels.{FileChannel, OverlappingFileLockException}
import java.nio.file.{FileAlreadyExistsException, Files, Path, StandardOpenOption}

import com.olvind.logging.Logger

import scala.util.{Failure, Success, Try}

object FileLocking {

  object Serializer {
    def serialize[T <: Serializable](obj: T): Array[Byte] = {
      val byteOut = new ByteArrayOutputStream()
      val objOut  = new ObjectOutputStream(byteOut)
      objOut.writeObject(obj)
      objOut.close()
      byteOut.close()
      byteOut.toByteArray
    }

    def deserialize[T <: Serializable](bytes: Array[Byte]): Try[T] = Try {
      val byteIn = new ByteArrayInputStream(bytes)
      val objIn = new ObjectInputStream(byteIn) { // https://github.com/scala/bug/issues/9777
        override def resolveClass(desc: ObjectStreamClass): Class[_] =
          Class.forName(desc.getName, false, FileLocking.getClass.getClassLoader)
      }
      val obj = objIn.readObject().asInstanceOf[T]

      byteIn.close()
      objIn.close()
      obj
    }
  }

  def persistingFunction[K, V <: Serializable](cachedFileFor: K => Path, logger: Logger[Unit])(f: K => V): K => V =
    (key: K) => cachedValue[V](cachedFileFor(key), logger)(f(key))

  def cachedValue[V <: Serializable](path: Path, logger: Logger[Unit])(value: => V): V = {
    def onExists(channel: FileChannel, contents: () => ByteBuffer): V =
      Serializer.deserialize[V](contents().array) match {
        case Failure(error) =>
          logger.warn(s"Couldn't decode cached file $path: $error")
          val ret = value
          channel.truncate(0L)
          channel.write(ByteBuffer.wrap(Serializer.serialize(ret)))
          ret
        case Success(value) =>
          value
      }
    def onNotExists(channel: FileChannel): V = {
      val ret = value
      channel.write(ByteBuffer.wrap(Serializer.serialize(ret)))
      ret
    }

    tryWrite[V](path, onExists = onExists, onNotExists = onNotExists)
  }

  def tryWrite[T](path: Path, onExists: (FileChannel, () => ByteBuffer) => T, onNotExists: FileChannel => T): T =
    withLock(path) { channel =>
      val size = channel.size
      if (size > 0) {
        onExists(channel, () => {
          val contents = ByteBuffer.allocate(size.toInt)
          channel.read(contents)
          contents
        })
      } else {
        onNotExists(channel)
      }
    }

  def withLock[T](path: Path)(f: FileChannel => T): T = {
    var continue = true
    var ret      = null.asInstanceOf[T]
    Files.createDirectories(path.getParent)

    while (continue) {
      try {
        /* You would think this would be equal to just adding `CREATE`, but it isn't for zip fs */
        val flags: Array[StandardOpenOption] =
          if (Files.exists(path)) Array(StandardOpenOption.WRITE, StandardOpenOption.READ)
          else Array(StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE, StandardOpenOption.READ)

        val channel = FileChannel.open(path, flags: _*)
        try {
          val lock = channel.lock()
          try {
            ret = f(channel)
          } finally lock.release()
        } finally channel.close()
        continue = false
      } catch {
        case _: OverlappingFileLockException => Try(Thread.sleep(10))
        case _: FileAlreadyExistsException   => Try(Thread.sleep(10))
      }
    }

    ret
  }
}
