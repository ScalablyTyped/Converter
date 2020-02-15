package org.scalablytyped.converter.internal
package importer

import java.io._
import java.nio.ByteBuffer
import java.nio.channels.{FileChannel, OverlappingFileLockException}
import java.nio.file.{Files, Path, StandardOpenOption}

import com.olvind.logging.Logger

import scala.util.{Failure, Success, Try}

object PersistingFunction {

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
          Class.forName(desc.getName, false, PersistingFunction.getClass.getClassLoader)
      }
      val obj = objIn.readObject().asInstanceOf[T]

      byteIn.close()
      objIn.close()
      obj
    }
  }

  def apply[K, V <: Serializable](cachedFileFor: K => Path, logger: Logger[Unit])(f: K => V): K => V = { key: K =>
    val path = cachedFileFor(key)

    var continue = true
    var ret: V = null.asInstanceOf[V]

    Files.createDirectories(path.getParent)

    while (continue) {
      try {
        val channel =
          FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.READ)
        val lock = channel.lock()
        val size = channel.size
        if (size > 0) {
          val contents = ByteBuffer.allocate(size.toInt)
          channel.read(contents)
          Serializer.deserialize[V](contents.array) match {
            case Failure(error) =>
              logger.warn(s"Couldn't decode cached file $path: $error")
              ret = f(key)
              channel.write(ByteBuffer.wrap(Serializer.serialize(ret)))
            case Success(value) =>
              ret = value
          }
        } else {
          ret = f(key)
          channel.write(ByteBuffer.wrap(Serializer.serialize(ret)))
        }

        lock.release()
        channel.close()
        continue = false
      } catch {
        case _: OverlappingFileLockException => Try(Thread.sleep(10))
      }
    }

    ret
  }

  def nameAndMtimeUnder(path: Path): InFile => Path =
    (file: InFile) =>
      path
        .resolve(file.path.toString().replaceAll("/", "_"))
        .resolve(os.mtime(file.path).toString)
}