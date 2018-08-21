package com.olvind.tso
package ts
package transforms

/**
  * Remove bounds that do not work in scala, for instance:
  * ```typescript
  * interface A<T extends (number | string)>{}
  * interface B extends A<number>
  * ```
  * This subtyping relationship holds in typescript but not in scala, so we have to remove it.
  *
  * We also remove type objects for now. Those are practical in typescript where things
  *  are checked for conformance, but you can't normally conform in scala with types
  *  you don't control.
  */
object BoundsRemoveAtDefinition extends TreeVisitorScopedChanges {
  def describe(tsType: TsType): String = tsType match {
    case TsTypeRef(_name, tparams) =>
      val name = _name.parts.map(_.value).mkString(".")
      if (tparams.nonEmpty)
        name + "[" + (tparams map describe mkString ",") + "]"
      else name

    case TsTypeUnion(types) =>
      types map describe mkString " | "

    case other => other.toString
  }

  def notRepresentableInScala(scope: TreeScope, x: TsType): Boolean =
    x match {
      case _:  TsTypeObject => true
      case _:  TsTypeUnion => true
      case _:  TsTypeLookup => true
      case tr: TsTypeRef =>
        scope.lookupTypeIncludeScope(tr.name).headOption.fold(false) {
          case (xx: TsDeclTypeAlias, newScope) if xx.alias =/= x => notRepresentableInScala(newScope, xx.alias)
          case _ => false
        }
      case _ => false
    }

  override def enterTsTypeParam(t: TreeScope)(x: TsTypeParam): TsTypeParam =
    x.upperBound match {
      case Some(upperBound) if notRepresentableInScala(t, upperBound) =>
        val description = describe(upperBound)
        t.logger.info(s"Removing union bound $description from tparam ${x.name} at $t")
        x.copy(comments = x.comments + Comment(s"/* <: $description */"), upperBound = None)
      case _ => x
    }
}
