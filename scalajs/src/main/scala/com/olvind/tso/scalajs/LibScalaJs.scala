package com.olvind.tso
package scalajs

case class LibScalaJs[Source](
    source:        Source,
    libName:       Name,
    libVersion:    LibraryVersion,
    packageSymbol: ContainerSymbol,
    dependencies:  Set[LibScalaJs[Source]],
    isStdLib:      Boolean,
) {
  override def equals(obj: Any): Boolean =
    obj match {
      case that: LibScalaJs[Source] => that.hashCode === hashCode && that.source === source
      case _ => false
    }

  override lazy val hashCode: Int =
    source.hashCode
}
