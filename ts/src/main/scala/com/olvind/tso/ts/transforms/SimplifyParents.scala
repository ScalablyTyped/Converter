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
object SimplifyParents extends TreeVisitorScopedChanges {
  override def enterTsDeclClass(t: TreeScope)(x: TsDeclClass): TsDeclClass =
    x.copy(parent = newParents(x.parent.to[Seq], t).headOption, implements = newParents(x.implements, t))

  override def enterTsDeclInterface(t: TreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(inheritance = newParents(x.inheritance, t))

  private def newParents(parents: Seq[TsTypeRef], scope: TreeScope): Seq[TsTypeRef] =
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

  private def lift(scope: TreeScope, ref: TsTypeRef, tpe: TsType): Seq[TsTypeRef] =
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
      case other =>
        scope.logger.info(s"Dropping complicated parent ${other.asString}")
        Nil
    }
}
