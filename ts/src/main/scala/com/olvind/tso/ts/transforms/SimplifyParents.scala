package com.olvind.tso
package ts
package transforms

/**
  * There is this weird pattern:
  *
  * ```typescript
  *
  * type Constructor<T> = new(...args: any[]) => T;
  * declare const TextBase: Constructor&lt;NativeMethodsMixin&gt; & typeof TextComponent;
  * export class Text extends TextBase {}
  *
  * ```
  *
  * We'll deal with it more properly later if we have to, for now simplify and make stuff compile at least
  */
object SimplifyParents extends TreeTransformationScopedChanges {
  override def enterTsDeclClass(t: TsTreeScope)(x: TsDeclClass): TsDeclClass = {
    val np = newParents(x.parent.to[Seq] ++ x.implements, t)
    x.copy(parent = np.headOption, implements = np.drop(1))
  }

  override def enterTsDeclInterface(t: TsTreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(inheritance = newParents(x.inheritance, t))

  private def newParents(parents: Seq[TsTypeRef], scope: TsTreeScope): Seq[TsTypeRef] =
    parents.flatMap { parentRef =>
      scope.lookupType(parentRef.name, skipValidation = true) match {
        case Nil =>
          scope.lookupBase(Picker.Vars, parentRef.name, skipValidation = true).headOption match {
            case Some((TsDeclVar(_, _, _, _, Some(tpe), _, _, _, _), newScope)) => lift(newScope, parentRef, tpe)
            case _                                                              => Seq(parentRef)
          }
        case _ => Seq(parentRef)
      }
    }

  private def lift(scope: TsTreeScope, ref: TsTypeRef, tpe: TsType): Seq[TsTypeRef] =
    tpe match {
      case ref: TsTypeRef =>
        scope.lookup(ref.name).headOption match {
          case Some(Picker.Types(x)) =>
            scope.logger.info(s"Simplified class which extends var $ref to typeof var")
            Seq(ref.copy(name = x.codePath.forceHasPath.codePathPart))
          case _ => Seq(ref)
        }
      case TsTypeIntersect(types) =>
        types.flatMap(tpe => lift(scope, ref, tpe))
      case TsTypeQuery(expr) =>
        val wasClass: Option[TsTypeRef] =
          scope.lookupBase(Picker.NamedValues, expr, true).collectFirst {
            case (x: TsDeclClass, _) => TsTypeRef(NoComments, x.codePath.get.fold(expr)(_.codePath), Nil)
          }

        wasClass match {
          case Some(tr) => List(tr)
          case None =>
            scope.logger.info(s"Dropping complicated parent ${expr.asString}")
            Nil
        }
      case other =>
        scope.logger.info(s"Dropping complicated parent ${other.asString}")
        Nil
    }
}
