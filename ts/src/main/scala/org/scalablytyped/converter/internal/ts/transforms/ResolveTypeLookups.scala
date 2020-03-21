package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector

object ResolveTypeLookups extends TreeTransformationScopedChanges {
  override def leaveTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case TsTypeLookup(TsTypeTuple(tparams), TsTypeRef.number) => TsTypeUnion(tparams)
      case lookup: TsTypeLookup =>
        expandLookupType(scope, lookup) getOrElse x

      case other => other
    }

  private val toIgnore = Set[TsType](TsTypeRef.never, TsTypeRef.any, TsTypeRef.`object`)

  def optional(tpe: TsType, isOptional: Boolean): TsType =
    if (isOptional) TsTypeUnion.simplified(IArray(tpe, TsTypeRef.undefined))
    else tpe

  def expandLookupType(scope: TsTreeScope, lookup: TsTypeLookup): Option[TsType] =
    ExpandTypeMappings.evaluateKeys(scope, LoopDetector.initial)(lookup.key) match {
      case ExpandTypeMappings.Ok(keys, _) =>
        FollowAliases(scope)(lookup.from) match {
          case TsTypeRef(_, name, _) if scope isAbstract name => None
          case fromTypeRef: TsTypeRef =>
            val members = AllMembersFor(scope, LoopDetector.initial)(fromTypeRef)
            pick(members, keys)

          case TsTypeObject(_, members) => pick(members, keys)
          case _                        => None
        }
      case _ => None
    }

  val NonStatic = false

  def pick(members: IArray[TsMember], strings: Set[TsLiteral]): Option[TsType] =
    if (strings.isEmpty) {
      members.collectFirst {
        case TsMemberIndex(_, _, _, _, isOptional, valueType) =>
          optional(valueType.getOrElse(TsTypeRef.any), isOptional)
      }
    } else
      TsTypeUnion.simplified(IArray.fromTraversable(strings.map(x => pick(members, x))) filterNot toIgnore) match {
        case TsTypeRef.never => None
        case other           => Some(other)
      }

  def pick(members: IArray[TsMember], wanted: TsLiteral): TsType = {
    val (functions, fields, _) = members.partitionCollect2(
      { case TsMemberFunction(_, _, TsIdent(wanted.literal), sig, NonStatic, _, false) => sig }, {
        case TsMemberProperty(_, _, TsIdent(wanted.literal), tpeOpt, _, NonStatic, _, isOptional) =>
          optional(tpeOpt getOrElse TsTypeRef.any, isOptional)
        case TsMemberFunction(_, _, TsIdent(wanted.literal), sig, NonStatic, _, _) => TsTypeFunction(sig)
      },
    )
    val combinedFunctions: Option[TsType] = functions.distinct match {
      case IArray.Empty           => None
      case IArray.exactlyOne(one) => Some(TsTypeFunction(one))
      case more =>
        Some(TsTypeObject(NoComments, more.map(sig => TsMemberCall(NoComments, ProtectionLevel.Default, sig))))
    }

    TsTypeIntersect.simplified(combinedFunctions.foldLeft(fields)(_ :+ _) filterNot toIgnore)
  }
}
