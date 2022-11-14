package org.scalablytyped.converter.internal

import java.security.MessageDigest

final class Digest private (bytes: Array[Byte]) {
  lazy val hexString: String = Digest.asString(bytes)
}

object Digest {
  private def asString(buf: Array[Byte]): String = buf.map("%02x".format(_)).mkString

  trait Digestable[T] {
    def bytesFrom(t: T): Array[Byte]
  }

  object Digestable {
    def apply[T: Digestable]: Digestable[T] = implicitly

    implicit val StringDigestable: Digestable[String] =
      (t: String) => t.filterNot(_.isWhitespace).getBytes(constants.Utf8)
    implicit val ByteArrayDigestable: Digestable[Array[Byte]] =
      (bs: Array[Byte]) => bs
  }

  def of[T <: AnyRef: Digestable](ts: IArray[T]): Digest = {
    val md5 = MessageDigest.getInstance("MD5")
    ts.foreach { t =>
      md5.update(Digestable[T].bytesFrom(t))
    }
    new Digest(md5.digest())
  }
}
