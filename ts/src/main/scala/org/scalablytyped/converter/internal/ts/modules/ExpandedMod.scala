package org.scalablytyped.converter.internal
package ts
package modules

sealed trait ExpandedMod {
  def nonEmpty: Boolean
}

object ExpandedMod {
  final case class Whole(
      defaults:   IArray[TsNamedDecl],
      namespaced: IArray[TsNamedDecl],
      rest:       IArray[TsNamedDecl],
      scope:      TsTreeScope,
  ) extends ExpandedMod {
    override def nonEmpty: Boolean = defaults.nonEmpty || namespaced.nonEmpty || rest.nonEmpty
  }

  final case class Picked(things: IArray[(TsNamedDecl, TsTreeScope)]) extends ExpandedMod {
    override def nonEmpty: Boolean = things.nonEmpty
  }
}
