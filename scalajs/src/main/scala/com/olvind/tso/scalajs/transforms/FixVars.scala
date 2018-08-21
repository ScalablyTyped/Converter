package com.olvind.tso.scalajs.transforms

import com.olvind.tso.scalajs._

/**
  * We have to fix this situation:
  *
  * trait A {
  *  var foo: Any
  * }
  * trait B {
  *   var foo: Any
  * }
  * trait C extends A with B
  *
  * The scala compiler refuses to accept it, so we just rewrite all 'var' in traits to `val` for now.
  *
  * We should fix this on a case by case basis where it's actually necessary, but the problem is
  *  that `A` for instance can live in a dependency. This implies that we have to do it globally,
  *  with the implication that a library might produce different output depending on which
  *  dependees it was converted at the same time as. I... don't want that.
  */
object FixVars extends SymbolVisitor {

  override def enterClassSymbol(scope: SymbolScope)(s: ClassSymbol): ClassSymbol =
    if (s.classType === ClassType.Class) s
    else
      s.copy(members = s.members.map {
        case x: FieldSymbol if !x.isReadOnly => x.copy(isReadOnly = true)
        case other => other
      })
}
