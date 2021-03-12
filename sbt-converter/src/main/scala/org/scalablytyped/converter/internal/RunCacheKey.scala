package org.scalablytyped.converter.internal

import com.olvind.logging.Formatter
import io.circe.syntax._

case class RunCacheKey private (digest: Digest) {
  def path(cacheDir: os.Path): os.Path = cacheDir / "runs" / s"${digest.hexString}.json"
}

object RunCacheKey {
  implicit val formatter: Formatter[RunCacheKey] =
    _.digest.hexString

  def apply(in: ImportTypings.Input): RunCacheKey =
    new RunCacheKey(Digest.of(List(in.asJson.noSpaces)))
}
