package org.scalablytyped.converter.internal
package ts
package transforms
import scala.collection.mutable

/**
  * Typescript supports defaulted type arguments.
  * This adds them back.
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
object DefaultedTypeArguments extends TreeTransformationScopedChanges {
  override def enterTsTypeRef(scope: TsTreeScope)(typeRef: TsTypeRef): TsTypeRef = {
    val providedTypeArgs = typeRef.tparams

    scope
      .lookupType(typeRef.name)
      .collectFirst {
        case HasTParams(expectedTparams) if expectedTparams.length =/= providedTypeArgs.length =>
          val instantiated = mutable.Map.empty[TsType, TsType]

          val newTParams: IArray[TsType] =
            expectedTparams.zipWithIndex.map {
              case (current, idx) if idx < providedTypeArgs.length =>
                val provided = providedTypeArgs(idx)
                instantiated(TsTypeRef(current.name)) = provided
                provided

              case (current, _) =>
                val next = current.default.getOrElse {
                  val msg = s"no default parameter for ${TsTypeFormatter.tparam(current)}"
                  scope.logger.warn(msg)
                  current.upperBound.getOrElse(TsTypeRef.any.copy(comments = Comments(Comment.warning(msg))))
                }

                /* a defaulted tparam may refer to earlier tparams by name, so handle that here */
                val nextRewritten = new TypeRewriter(next).visitTsType(instantiated)(next)
                instantiated(TsTypeRef(current.name)) = nextRewritten
                nextRewritten
            }

          typeRef.copy(tparams = newTParams)

      }
      .getOrElse(typeRef)
  }
}
