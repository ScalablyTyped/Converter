package org.scalablytyped.converter.internal
package scalajs

/**
  * Maps the in-memory `Tree` structure to a file structure
  */
sealed trait ScalaOutput

object ScalaOutput {
  case object PackageObject extends ScalaOutput

  final case class File(name: Name) extends ScalaOutput {
    // account for case insensitive file systems
    override def equals(obj: Any): Boolean =
      obj match {
        case other: File => name.value.toLowerCase === other.name.value.toLowerCase
        case _ => false
      }
    override lazy val hashCode: Int =
      name.value.toLowerCase.hashCode
  }

  final case class Package(name: Name) extends ScalaOutput

  def outputAs(s: Tree): ScalaOutput =
    s match {
      case s: PackageTree => Package(s.name)
      case s: ModuleTree  => File(s.name)
      case s: ClassTree   => File(s.name)
      case _ => PackageObject
    }
}
