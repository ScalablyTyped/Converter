package com.olvind.tso
package ts

import com.olvind.tso.ts.TsTreeScope.LoopDetector

object AllMembersFor {
  def forType(scope: TsTreeScope, loopDetector: LoopDetector)(tpe: TsType): Seq[TsMember] =
    tpe match {
      case x: TsTypeRef => apply(scope, loopDetector)(x)
      case x: TsTypeIntersect =>
        x.types.flatMap(forType(scope, loopDetector))
      case _: TsTypeUnion =>
        Nil
      case x: TsTypeObject =>
        x.members match {
//          case Seq(TsMemberTypeMapped(cs, level, isReadOnly, key, TsTypeKeyOf(from: TsTypeRef), opt, to)) =>
//            AllMembersFor(scope, loopDetector)(from)
//              .map {
//                case TsMemberProperty(cs0, level0, name0, Some(tpe0), lit, isStatic, isReadOnly0, wasOptional) =>
//                  TsMemberProperty(
//                    cs ++ cs0,
//                    if (level =/= Default) level else level0,
//                    name0,
//                    Some(
//                      new TypeRewriter(to)
//                        .visitTsType(Map(TsTypeLookup(from, TsTypeRef.of(key)) -> tpe0))(to)
//                    ),
//                    lit,
//                    isStatic,
//                    isReadOnly || isReadOnly0,
//                    opt(wasOptional)
//                  )
//
//                case other => scope.logger.fatal(s"Unexpected non member property: $other")
//              }
          case other => other
        }

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
