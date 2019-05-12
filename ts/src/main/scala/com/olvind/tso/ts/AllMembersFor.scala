package com.olvind.tso
package ts

import com.olvind.tso.ts.TsTreeScope.LoopDetector
import seqs.TraversableOps

object AllMembersFor {
  def forType(scope: TsTreeScope, loopDetector: LoopDetector)(tpe: TsType): Seq[TsMember] =
    tpe match {
      case x: TsTypeRef         => apply(scope, loopDetector)(x)
      case x: TsTypeIntersect   => x.types.flatMap(forType(scope, loopDetector))
      case x: TsTypeUnion       => x.types.flatMap(forType(scope, loopDetector)).map(TsMember.optional(true))
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

  /* would want to do this for methods too, and in a more principled way. */
  def handleOverridingFields(fromThis: Seq[TsMember], fromParents: Seq[TsMember]): Seq[TsMember] = {
    val thisFieldOverrides           = fromThis.collect { case x: TsMemberProperty => x.name }.toSet
    val (parentsFields, parentsRest) = fromParents.partitionCollect { case x: TsMemberProperty => x }

    fromThis ++ parentsFields.filterNot(x => thisFieldOverrides(x.name)) ++ parentsRest
  }

  def apply(scope: TsTreeScope, _loopDetector: LoopDetector)(typeRef: TsTypeRef): Seq[TsMember] =
    _loopDetector.including(typeRef.name.parts, scope) match {
      case Left(()) => Nil
      case Right(newLoopDetector) =>
        scope.lookupInternal(Picker.Types, typeRef.name.parts, LoopDetector.initial) flatMap {
          case (x: TsDeclInterface, newScope) =>
            forInterface(newLoopDetector, x, newScope, typeRef.tparams)

          case (x: TsDeclClass, newScope) =>
            FillInTParams(x, typeRef.tparams) match {
              case TsDeclClass(_, _, _, _, _, parent, implements, members, _, _) =>
                handleOverridingFields(members, implements ++ parent flatMap apply(newScope, newLoopDetector))
            }

          case (x: TsDeclTypeAlias, newScope) =>
            forType(newScope, newLoopDetector)(FillInTParams(x, typeRef.tparams).alias)

          case _ => Nil
        }
    }

  def forInterface(
      loopDetector: TsTreeScope.LoopDetector,
      x:            TsDeclInterface,
      newScope:     TsTreeScope,
      tparams:      Seq[TsType],
  ): Seq[TsMember] =
    FillInTParams(x, tparams) match {
      case TsDeclInterface(_, _, _, _, inheritance, members, _) =>
        handleOverridingFields(members, inheritance flatMap AllMembersFor(newScope, loopDetector))
    }
}
