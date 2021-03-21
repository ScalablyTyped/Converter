package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector
import org.scalablytyped.converter.internal.ts.transforms.ExpandTypeMappings.TaggedLiteral

object ResolveTypeLookups extends TreeTransformationScopedChanges {
  override def leaveTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case TsTypeLookup(TsTypeTuple(elems), TsTypeRef.number) => TsTypeUnion(elems.map(_.tpe))
      case lookup: TsTypeLookup =>
        expandLookupType(scope, lookup).getOrElse(x)

      case other => other
    }

  private val toIgnore = Set[TsType](TsTypeRef.never, TsTypeRef.any, TsTypeRef.`object`)

  def expandLookupType(scope: TsTreeScope, lookup: TsTypeLookup): Option[TsType] =
    ExpandTypeMappings.evaluateKeys(scope, LoopDetector.initial)(lookup.key) match {
      case ExpandTypeMappings.Ok(keys, _) =>
        def go(tpe: TsType): Option[TsType] =
          FollowAliases(scope)(tpe) match {
            case TsTypeRef(_, name, _) if scope.isAbstract(name) => None
            case fromTypeRef: TsTypeRef =>
              val members = AllMembersFor(scope, LoopDetector.initial)(fromTypeRef)
              pick(members, keys)

            case TsTypeObject(_, members) => pick(members, keys)
            case TsTypeUnion(types) =>
              types.map(go).partitionCollect2({ case None => null }, { case Some(tpe) => tpe }) match {
                case (Empty, ok, Empty) => Some(TsTypeUnion(ok))
                case _                  => None
              }
            case _ => None
          }
        go(lookup.from)
      case _ => None
    }

  val NonStatic = false

  def pick(members: IArray[TsMember], strings: Set[TaggedLiteral]): Option[TsType] =
    if (strings.isEmpty) {
      members.collectFirst {
        case TsMemberIndex(_, _, _, _, valueType) => valueType.getOrElse(TsTypeRef.any)
      }
    } else
      TsTypeUnion.simplified(IArray.fromTraversable(strings.map(x => pick(members, x.lit))).filterNot(toIgnore)) match {
        case TsTypeRef.never => None
        case other           => Some(other)
      }

  def pick(members: IArray[TsMember], wanted: TsLiteral): TsType = {
    val (functions, fields, _) = members.partitionCollect2(
      { case TsMemberFunction(_, _, TsIdent(wanted.literal), MethodType.Normal, sig, NonStatic, _) => sig }, {
        case TsMemberProperty(_, _, TsIdent(wanted.literal), tpeOpt, _, NonStatic, _)              => tpeOpt.getOrElse(TsTypeRef.any)
      },
    )
    val combinedFunctions: Option[TsType] = functions.distinct match {
      case IArray.Empty           => None
      case IArray.exactlyOne(one) => Some(TsTypeFunction(one))
      case more =>
        Some(TsTypeObject(NoComments, more.map(sig => TsMemberCall(NoComments, ProtectionLevel.Default, sig))))
    }

    TsTypeIntersect.simplified(combinedFunctions.foldLeft(fields)(_ :+ _).filterNot(toIgnore))
  }
}
