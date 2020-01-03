package org.scalablytyped.converter.internal
package scalajs
package transforms

/**
  * We sometimes end up with duplicate members from the type definitions. We just combine them
  */
object Deduplicator extends TreeTransformation {
  // todo: this is remnant of when we also merged trees on the scala.js side. research why it's still needed
  override def leaveClassTree(scope: TreeScope)(s: ClassTree): ClassTree =
    s.copy(members = s.members.distinct, ctors = s.ctors.distinct)
}
