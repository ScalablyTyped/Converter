package com.olvind.tso
package ts

import com.olvind.tso.ts.TsTreeScope.LoopDetector

object AllMembersFor {
  def forType(scope: TsTreeScope, loopDetector: LoopDetector)(tpe: TsType): Seq[TsMember] =
    tpe match {
      case x: TsTypeRef         => apply(scope, loopDetector)(x)
      case x: TsTypeIntersect   => x.types.flatMap(forType(scope, loopDetector))
      case x: TsTypeUnion       => x.types.flatMap(forType(scope, loopDetector)).map(TsMember.optional)
      case x: TsTypeObject      => x.members
      case _: TsTypeLiteral     => Nil
      case _: TsTypeFunction    => Nil
      case _: TsTypeConstructor => Nil
      case _: TsTypeIs          => Nil
      case _: TsTypeTuple       => Nil
      case _: TsTypeQuery       => Nil
      case _: TsTypeRepeated    => Nil
      case _: TsTypeKeyOf       => Nil
      case _: TsTypeLookup      => Nil
      case _: TsTypeThis        => Nil
      case _: TsTypePredicate   => Nil
    }

  def apply(scope: TsTreeScope, loopDetector: LoopDetector)(typeRef: TsTypeRef): Seq[TsMember] =
    scope lookupInternal (Picker.Types, typeRef.name.parts, loopDetector) flatMap {
      case (x: TsDeclInterface, newScope) =>
        forInterface(loopDetector, x, newScope, typeRef.tparams)

      case (x: TsDeclClass, newScope) =>
        FillInTParams(x, typeRef.tparams) match {
          case TsDeclClass(_, _, _, _, _, parent, implements, members, _, _) =>
            members ++ (implements ++ parent flatMap apply(newScope, loopDetector))
        }

      case (x: TsDeclTypeAlias, newScope) =>
        forType(newScope, loopDetector)(FillInTParams(x, typeRef.tparams).alias)

      case _ => Nil
    }

  def forInterface(loopDetector: TsTreeScope.LoopDetector,
                   x:            TsDeclInterface,
                   newScope:     TsTreeScope,
                   tparams:      Seq[TsType]): Seq[TsMember] =
    FillInTParams(x, tparams) match {
      case TsDeclInterface(_, _, _, _, inheritance, members, _) =>
        members ++ (inheritance flatMap AllMembersFor(newScope, loopDetector))
    }
}
