package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.seqs.TraversableOps
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
    if (isOptional) TsTypeUnion.simplified(tpe :: TsTypeRef.undefined :: Nil)
    else tpe

  def expandLookupType(scope: TsTreeScope, lookup: TsTypeLookup): Option[TsType] =
    ExpandTypeMappings.evaluateKeys(scope)(lookup.key) match {
      case ExpandTypeMappings.Ok(strings, _) =>
        FollowAliases(scope)(lookup.from) match {
          case TsTypeRef(_, name, _) if scope isAbstract name => None
          case fromTypeRef: TsTypeRef =>
            val members = AllMembersFor(scope, LoopDetector.initial)(fromTypeRef)
            pick(members, strings)

          case TsTypeObject(_, members) => pick(members, strings)
          case _                        => None
        }
      case _ => None
    }

  val NonStatic = false

  def pick(members: Seq[TsMember], strings: Set[String]): Option[TsType] =
    if (strings.isEmpty) {
      members.collectFirst {
        case TsMemberIndex(_, _, _, _, isOptional, valueType) =>
          optional(valueType.getOrElse(TsTypeRef.any), isOptional)
      }
    } else
      TsTypeUnion.simplified(strings.toList.map(x => pick(members, x)) filterNot toIgnore) match {
        case TsTypeRef.never => None
        case other           => Some(other)
      }

  def pick(members: Seq[TsMember], Wanted: String): TsType = {
    val (functions, fields, _) = members.partitionCollect2(
      { case TsMemberFunction(_, _, TsIdent(Wanted), sig, NonStatic, _, false) => sig }, {
        case TsMemberProperty(_, _, TsIdent(Wanted), tpeOpt, _, NonStatic, _, isOptional) =>
          optional(tpeOpt getOrElse TsTypeRef.any, isOptional)
        case TsMemberFunction(_, _, TsIdent(Wanted), sig, NonStatic, _, _) => TsTypeFunction(sig)
      },
    )
    val combinedFunctions: Option[TsType] = functions.distinct match {
      case Nil      => None
      case Seq(one) => Some(TsTypeFunction(one))
      case more =>
        Some(TsTypeObject(NoComments, more.map(sig => TsMemberCall(NoComments, ProtectionLevel.Default, sig))))
    }

    TsTypeIntersect.simplified(combinedFunctions.foldLeft(fields)(_ :+ _) filterNot toIgnore)
  }
}
