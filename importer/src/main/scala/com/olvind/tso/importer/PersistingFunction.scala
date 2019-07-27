package com.olvind.tso
package importer

import java.io._

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
      val objIn  = new ObjectInputStream(byteIn)
      val obj    = objIn.readObject().asInstanceOf[T]
      byteIn.close()
      objIn.close()
      obj
    }
  }

  def apply[K, V <: Serializable](cachedFileFor: K => os.Path, logger: Logger[Unit])(f: K => V): K => V = { key: K =>
    cachedFileFor(key) match {
      case cachedFile if os.exists(cachedFile) =>
        Serializer.deserialize[V](os.read.bytes(cachedFile)) match {
          case Failure(error) =>
            logger.warn(s"Couldn't decode cached file $cachedFile for $key: $error")
            val ret = f(key)
            files.softWriteBytes(cachedFile, Serializer.serialize(ret))
            ret
          case Success(file) => file
        }

      case cacheFile =>
        val ret = f(key)
        files.softWriteBytes(cacheFile, Serializer.serialize(ret))
        ret
    }
  }

  def nameAndMtimeUnder(path: os.Path): InFile => os.Path =
    (file: InFile) =>
      path /
        file.path.toString().replaceAll("/", "_") /
        os.mtime(file.path).toString

}
