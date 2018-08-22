package com.olvind.tso
package ts
package modules

sealed trait ExpandedMod {
  def nonEmpty: Boolean
}

object ExpandedMod {
  final case class Whole(defaults:   Seq[TsNamedDecl],
                         namespaced: Seq[TsNamedDecl],
                         rest:       Seq[TsContainerOrDecl],
                         scope:      TreeScope)
      extends ExpandedMod {
    override def nonEmpty: Boolean = defaults.nonEmpty || namespaced.nonEmpty || rest.nonEmpty
  }

  final case class Picked(things: Seq[(TsNamedDecl, TreeScope)]) extends ExpandedMod {
    override def nonEmpty: Boolean = things.nonEmpty
  }
}
