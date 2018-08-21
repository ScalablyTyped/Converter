package com.olvind.tso
package scalajs
package transforms

/**
  * We sometimes end up with duplicate members from the type definitions. We just combine them
  */
object Deduplicator extends SymbolVisitor {
  // todo: this is remnant of when we also merged trees on the scala.js side. research why it's still needed
  override def enterClassSymbol(scope: SymbolScope)(s: ClassSymbol): ClassSymbol =
    s.copy(members = s.members.distinct, ctors = s.ctors.distinct)
}
