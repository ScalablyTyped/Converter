package com.olvind.tso
package ts
package transforms
import scala.collection.mutable

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
object DefaultedTParams extends TreeTransformationScopedChanges {
  override def enterTsTypeRef(scope: TsTreeScope)(x: TsTypeRef): TsTypeRef =
    x match {
      case TsTypeRef(_, target, providedTparams) if !TsQIdent.Primitive(target) && !scope.isAbstract(target) =>
        scope lookupBase (Picker.Types, target) collectFirst {
          case (HasTParams(expectedTparams), _) if expectedTparams.size =/= providedTparams.size =>
            val m: mutable.Map[TsType, TsType] =
              mutable.Map.empty

            val newTParams: Seq[TsType] =
              expectedTparams.zipWithIndex.map {
                case (current, idx) if idx < providedTparams.length =>
                  val provided = providedTparams(idx)
                  m.put(TsTypeRef.of(current.name), provided)
                  provided
                case (current, _) =>
                  val next = current.default.getOrElse {
                    val msg = s"no default parameter for ${TsTypeFormatter.tparam(current)}"
                    scope.logger.warn(msg)
                    current.upperBound getOrElse TsTypeRef.any.copy(comments = Comments(Comment.warning(msg)))
                  }

                  /* a default tparam may refer to earlier tparams by name, so handle that here */
                  val nextRewritten = new TypeRewriter(next).visitTsType(m)(next)
                  m.put(TsTypeRef.of(current.name), nextRewritten)
                  nextRewritten
              }

            x.copy(tparams = newTParams)
        } getOrElse x
      case _ => x
    }
}
