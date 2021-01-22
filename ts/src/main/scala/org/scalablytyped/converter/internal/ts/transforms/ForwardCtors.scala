package org.scalablytyped.converter.internal
package ts
package transforms

object ForwardCtors extends TreeTransformationScopedChanges {

  def parentWithCtor(scope: TsTreeScope)(parentRef: TsTypeRef): Option[IArray[TsMember]] =
    scope.lookupBase(Picker.HasClassMemberss, parentRef.name).firstDefined {
      case (parent: TsDeclClass, newScope) =>
        val parentRewritten = FillInTParams(parent, parentRef.tparams)

        parentRewritten.membersByName
          .get(TsIdent.constructor)
          .orElse(parentRewritten.parent.flatMap(parentWithCtor(newScope)))

      case _ => None
    }

  override def enterTsDeclClass(scope: TsTreeScope)(x: TsDeclClass): TsDeclClass =
    if (x.membersByName.contains(TsIdent.constructor)) x
    else
      x.parent.flatMap(parentWithCtor(scope)) match {
        case Some(ctors) => x.copy(members = x.members ++ ctors)
        case None        => x
      }
}
