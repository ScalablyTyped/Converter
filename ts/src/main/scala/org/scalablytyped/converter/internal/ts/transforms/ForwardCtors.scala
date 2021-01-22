package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector

object ForwardCtors extends TreeTransformationScopedChanges {
  def parentWithCtor(scope: TsTreeScope, loopDetector: LoopDetector)(parentRef: TsTypeRef): Option[IArray[TsMember]] =
    loopDetector.including(parentRef, scope) match {
      case Left(()) => None
      case Right(newLd) =>
        scope.lookupBase(Picker.HasClassMemberss, parentRef.name).firstDefined {
          case (parent: TsDeclClass, newScope) =>
            val parentRewritten = FillInTParams(parent, parentRef.tparams)

            parentRewritten.membersByName
              .get(TsIdent.constructor)
              .orElse(parentRewritten.parent.flatMap(parentWithCtor(newScope, newLd)))

          case _ => None
        }

    }

  override def enterTsDeclClass(scope: TsTreeScope)(x: TsDeclClass): TsDeclClass =
    if (x.membersByName.contains(TsIdent.constructor)) x
    else
      x.parent.flatMap(parentWithCtor(scope, LoopDetector.initial)) match {
        case Some(ctors) => x.copy(members = x.members ++ ctors)
        case None        => x
      }
}
