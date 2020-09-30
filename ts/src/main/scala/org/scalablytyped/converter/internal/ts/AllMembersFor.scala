package org.scalablytyped.converter.internal
package ts

import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector

object AllMembersFor {
  def forType(scope: TsTreeScope, loopDetector: LoopDetector)(tpe: TsType): IArray[TsMember] =
    tpe match {
      case x: TsTypeRef         => apply(scope, loopDetector)(x)
      case x: TsTypeIntersect   => x.types.flatMap(forType(scope, loopDetector))
      case _: TsTypeUnion       => Empty
      case x: TsTypeObject      => x.members
      case _: TsTypeAsserts     => Empty
      case _: TsTypeLiteral     => Empty
      case _: TsTypeFunction    => Empty
      case _: TsTypeConstructor => Empty
      case _: TsTypeIs          => Empty
      case _: TsTypeTuple       => Empty
      case _: TsTypeQuery       => Empty
      case _: TsTypeRepeated    => Empty
      case _: TsTypeKeyOf       => Empty
      case _: TsTypeLookup      => Empty
      case _: TsTypeThis        => Empty
      case _: TsTypePredicate   => Empty
    }

  /* would want to do this for methods too, and in a more principled way. */
  def handleOverridingFields(fromThis: IArray[TsMember], fromParents: IArray[TsMember]): IArray[TsMember] = {
    val thisFieldOverrides           = fromThis.collect { case x: TsMemberProperty => x.name }.toSet
    val (parentsFields, parentsRest) = fromParents.partitionCollect { case x: TsMemberProperty => x }

    fromThis ++ parentsFields.filterNot(x => thisFieldOverrides(x.name)) ++ parentsRest
  }

  def apply(scope: TsTreeScope, _loopDetector: LoopDetector)(typeRef: TsTypeRef): IArray[TsMember] =
    _loopDetector.including(typeRef, scope) match {
      case Left(()) => Empty
      case Right(newLoopDetector) =>
        scope.lookupInternal(Picker.Types, typeRef.name.parts, newLoopDetector).flatMap {
          case (x: TsDeclInterface, newScope) =>
            forInterface(newLoopDetector, x, newScope, typeRef.tparams)

          case (x: TsDeclClass, newScope) =>
            FillInTParams(x, typeRef.tparams) match {
              case TsDeclClass(_, _, _, _, _, parent, implements, members, _, _) =>
                handleOverridingFields(
                  members,
                  (implements ++ IArray.fromOption(parent)).flatMap(apply(newScope, newLoopDetector)),
                )
            }

          case (x: TsDeclTypeAlias, newScope) =>
            forType(newScope, newLoopDetector)(FillInTParams(x, typeRef.tparams).alias)

          case _ => Empty
        }
    }

  def forInterface(
      loopDetector: TsTreeScope.LoopDetector,
      x:            TsDeclInterface,
      newScope:     TsTreeScope,
      tparams:      IArray[TsType],
  ): IArray[TsMember] =
    FillInTParams(x, tparams) match {
      case TsDeclInterface(_, _, _, _, inheritance, members, _) =>
        handleOverridingFields(members, inheritance.flatMap(AllMembersFor(newScope, loopDetector)))
    }
}
