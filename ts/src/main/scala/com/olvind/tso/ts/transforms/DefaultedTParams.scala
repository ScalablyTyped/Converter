package com.olvind.tso
package ts
package transforms

/**
  * Typescript added support for defaulted type parameters.
  * This adds them back
  *
  * ```typescript
  * interface Component<P = {}, S = {}> extends ComponentLifecycle<P, S> { }
  * type ReactInstance = Component<any> | Element;
  * ```
  *
  * Rewritten into
  * ```typescript
  * type ReactInstance = Component<any, {}> | Element;
  * ```
  */
object DefaultedTParams extends TreeVisitorScopedChanges {
  override def leaveTsTypeRef(scope: TreeScope)(x: TsTypeRef): TsTypeRef =
    x match {
      case TsTypeRef(target: TsQIdent, providedTparams: Seq[TsType])
          if !TsQIdent.Primitive(target) && !TsQIdent.BuiltIn(target) =>
        scope lookupBase (Picker.Types, target) collectFirst {
          case (HasTParams(expectedTparams), newScope) if expectedTparams.size =/= providedTparams.size =>
            val newTparams: Seq[TsType] =
              expectedTparams.zipWithIndex.map {
                case (TsTypeParam(_, tparamName, _, Some(defaulted)), idx) if idx >= providedTparams.length =>
                  scope.logger.debug(s"Defaulting type parameter $tparamName at $scope")
                  /* notice that we need to recurse here, the default for a type parameter might well omit a default value itself */
                  visitTsType(newScope)(defaulted)

                case (_, idx) if idx < providedTparams.length => providedTparams(idx)
                case _                                        => TsTypeRef(TsQIdent.`object`, Nil)
              }

            /* one defaulted tparam might reference other earlier tparams */
            val replacements: Seq[(TsType, TsType)] =
              expectedTparams zip newTparams map {
                case (TsTypeParam(_, tparamName, _, _), actual) =>
                  TsTypeRef(TsQIdent(List(tparamName)), Nil) -> actual
              }

            x.copy(tparams = newTparams.map(tp => new TypeRewriter(tp).visitTsType(replacements.toMap)(tp)))
        } getOrElse x
      case _ => x
    }
}
