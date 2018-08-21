package com.olvind.tso
package scalajs

/**
  * Maps the in-memory `Symbol` structure to a file structure
  */
sealed trait ScalaOutput

object ScalaOutput {
  case object PackageObject extends ScalaOutput
  case object StaticsObject extends ScalaOutput

  final case class File(name: Name) extends ScalaOutput {
    // account for case insensitive file systems
    override def equals(obj: scala.Any): Boolean = obj match {
      case other: File => name.value.toLowerCase === other.name.value.toLowerCase
      case _ => false
    }
    override def hashCode(): Int = name.value.toLowerCase.hashCode
  }
  final case class Package(name: Name) extends ScalaOutput

  def outputAs(s: Symbol): ScalaOutput =
    s match {
      case s: PackageSymbol   => Package(s.name)
      case s: ContainerSymbol => File(s.name)
      case _: MemberSymbol    => StaticsObject
      case _ => PackageObject
    }

}
