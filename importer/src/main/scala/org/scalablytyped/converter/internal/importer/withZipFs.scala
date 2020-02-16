package org.scalablytyped.converter.internal.importer

import java.net.URI
import java.nio.file.Path

object withZipFs {
  import java.nio.file.FileSystems

  def maybe[T](path: os.Path, enable: Boolean)(f: Option[Path] => T): T =
    if (enable) apply(path)(path => f(Some(path)))
    else f(None)

  def apply[T](path: os.Path)(f: Path => T): T = {
    val uri = URI.create(s"jar:file:${path}")
    val env = new java.util.HashMap[String, String]()
    env.put("create", "true")
    val zipfs = FileSystems.newFileSystem(uri, env)
    val root  = zipfs.getPath("/")
    try f(root)
    finally zipfs.close()
  }
}
