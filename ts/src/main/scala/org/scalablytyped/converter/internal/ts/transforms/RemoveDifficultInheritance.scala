package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.maps._

/**
  * In typescript we can inherit from type references pointing to a pretty much arbitrary shape.
  *
  * Scala naturally is much more constrained here, so we... drop all the difficult things.
  * Some information (like from intersections of type objects, for instance) is retrieved
  * ("lifted", in this code)
  *
  * We also inline all type aliases in parents.
  *
  * We'll do better eventually, this is the fallback to make things compile
  */
object RemoveDifficultInheritance extends TreeTransformationScopedChanges {
  override def enterTsDeclClass(scope: TsTreeScope)(s: TsDeclClass): TsDeclClass = {
    val cleaned = (IArray.fromOption(s.parent) ++ s.implements).map(cleanParentRef(scope))
    Res.combine(cleaned) match {
      case Res(keep, drop, lifted) =>
        s.copy(
          parent     = keep.headOption,
          implements = keep.drop(1),
          comments   = s.comments +? summarizeChanges(drop, lifted),
          members    = FlattenTrees.newClassMembers(s.members, lifted.flatMapToIArray { case (_, v) => v }),
        )
    }
  }

  override def enterTsDeclInterface(scope: TsTreeScope)(s: TsDeclInterface): TsDeclInterface =
    Res.combine(s.inheritance.map(cleanParentRef(scope))) match {
      case Res(keep, drop, lifted) =>
        s.copy(
          inheritance = keep,
          comments    = s.comments +? summarizeChanges(drop, lifted),
          members     = FlattenTrees.newClassMembers(s.members, lifted.flatMapToIArray { case (_, v) => v }),
        )
    }

  final case class Res(keep: IArray[TsTypeRef], drop: IArray[TsType], lift: Map[TsTypeRef, IArray[TsMember]])

  object Res {
    val EmptyRes = Res(Empty, Empty, Map.empty)

    def combine(rs: IArray[Res]): Res =
      rs.foldLeft(EmptyRes) {
        case (Res(keep1, drop1, lift1), Res(keep2, drop2, lift2)) =>
          Res(keep1 ++ keep2, drop1 ++ drop2, lift1 ++ lift2)
      }
  }

  private def cleanParentRef(scope: TsTreeScope)(tpe: TsTypeRef): Res =
    tpe match {
      /* this causes issues since they are classes in scala */
      case drop @ (TsTypeRef.`object` | TsTypeRef.Object | TsTypeRef.any) => Res(Empty, drop +: Empty, Map.empty)

      /* inline type aliases just to make things simpler */
      case tr: TsTypeRef =>
        scope
          .lookupTypeIncludeScope(tr.name)
          .collectFirst {
            /* see through thin interfaces which might be translated into type aliases */
            case (i @ TsDeclInterface(_, _, _, _, IArray.exactlyOne(_), Empty, _), newScope) =>
              cleanParentRef(newScope)(FillInTParams(i, tr.tparams).inheritance.head)

            case (found: TsDeclTypeAlias, newScope) =>
              val rewritten = FillInTParams(found, tr.tparams)

              rewritten.alias match {
                case next: TsTypeRef => cleanParentRef(newScope)(next)
                /* Flatten intersection types references by type alias, since it's not possible to extend them in scala */
                case TsTypeIntersect(types) =>
                  Res.combine(types.map {
                    case next: TsTypeRef => cleanParentRef(newScope)(next)
                    case TsTypeObject(_, members) if !ExtractInterfaces.isTypeMapping(members) =>
                      Res(Empty, Empty, Map(tr -> members))
                    case other => Res(Empty, other +: Empty, Map.empty)
                  })
                case x: TsTypeUnion    => Res(Empty, x +: Empty, Map.empty)
                case _: TsTypeFunction => Res(tr +: Empty, Empty, Map.empty)
                case TsTypeObject(_, members) if ExtractInterfaces.isDictionary(members) =>
                  Res(IArray(tr), Empty, Map.empty)
                case TsTypeObject(_, members) if !ExtractInterfaces.isTypeMapping(members) =>
                  Res(Empty, Empty, Map(tr -> members))
                case dropUnknown => Res(Empty, dropUnknown +: Empty, Map.empty)
              }
          }
          .getOrElse(Res(tr +: Empty, Empty, Map.empty))
    }

  private def summarizeChanges(drop: IArray[TsType], lifted: Map[TsTypeRef, IArray[TsMember]]): Option[Comment] = {
    val droppedMessages: IArray[String] =
      drop.map(d => s"- Dropped ${TsTypeFormatter(d)}")

    val liftedMessage: Option[String] =
      if (lifted.isEmpty) None
      else
        Some(s"- Lifted ${lifted.foldLeft(0)(_ + _._2.length)} members from ${lifted.keys.map(TsTypeFormatter.apply)}")

    droppedMessages ++ IArray.fromOption(liftedMessage) match {
      case Empty    => None
      case messages => Some(Comment.warning(messages.mkString("\n", "\n", "")))
    }
  }
}
