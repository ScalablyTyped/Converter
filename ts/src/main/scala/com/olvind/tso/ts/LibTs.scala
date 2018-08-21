package com.olvind.tso
package ts

final case class LibTs(name:         TsIdentLibrary,
                       source:       TsSource,
                       version:      LibraryVersion,
                       tsConfig:     Option[TsConfig],
                       parsed:       TsParsedFile,
                       dependencies: Map[TsSource, LibTs]) {
  override def equals(that: Any): Boolean =
    that match {
      case x: LibTs => hashCode === x.hashCode && source === x.source
      case _ => false
    }

  override lazy val hashCode: Int = source.hashCode

  override def toString: String =
    s"TsLibBase($name, $source, $version, $tsConfig, ${parsed.members.map(_.asString)}, ${dependencies
      .map(_._2.name.value)})"

  def isStdLib: Boolean =
    parsed.isStdLib
}
