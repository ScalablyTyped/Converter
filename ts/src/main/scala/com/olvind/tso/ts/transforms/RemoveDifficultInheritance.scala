package com.olvind.tso
package ts
package transforms
import com.olvind.tso.maps.EmptyMap

/**
  * In typescript we can inherit from type references pointing to a pretty much arbitrary shape.
  *
  * Scala naturally is much more constrained here, so we... drop all the difficult things.
  * Some information (like from intersections of type objects, for instance) is retrieved
  * ("lifted", in this code)
  *
  * We'll do better eventually, this is the fallback to make things compile
  */
object RemoveDifficultInheritance extends TreeVisitorScopedChanges {
  final case class Res(keep: List[TsTypeRef], drop: List[TsType], lift: Map[TsTypeRef, Seq[TsMember]])

  object Res {
    val Empty = Res(Nil, Nil, Map.empty)

    def combine(rs: Seq[Res]): Res =
      rs.foldLeft(Empty) {
        case (Res(keep1, drop1, lift1), Res(keep2, drop2, lift2)) =>
          Res(keep1 ++ keep2, drop1 ++ drop2, lift1 ++ lift2)
      }
  }

  private def cleanParentRef(scope: TreeScope)(tpe: TsTypeRef): Res =
    tpe match {
      /* We could solve this by using the types in the generated stdlib instead of scala.js types, but we don't for now */
      case drop @ (TsTypeRef.string | TsTypeRef.String | TsTypeRef.number | TsTypeRef.boolean | TsTypeRef.Boolean |
          TsTypeRef.Symbol) =>
        Res(Nil, drop :: Nil, Map.empty)

      /* this causes issues since they are classes in scala */
      case drop @ (TsTypeRef.`object` | TsTypeRef.Object | TsTypeRef.any) => Res(Nil, drop :: Nil, Map.empty)

      /* inline type aliases just to make things simpler */
      case tr: TsTypeRef =>
        scope.lookupTypeIncludeScope(tr.name).collectFirst {
          case (found: TsDeclTypeAlias, newScope) =>
            val rewritten = FillInTParams(found, tr.tparams)

            rewritten.alias match {
              case next: TsTypeRef => cleanParentRef(newScope)(next)
              /* Flatten intersection types references by type alias, since it's not possible to extend them in scala */
              case TsTypeIntersect(types) =>
                Res.combine(types map {
                  case next: TsTypeRef => cleanParentRef(newScope)(next)
                  case TsTypeObject(members) => Res(Nil, Nil, Map(tr -> members))
                  case other                 => Res(Nil, other :: Nil, Map.empty)
                })
              case x: TsTypeUnion    => Res(Nil, x :: Nil, Map.empty)
              case _: TsTypeFunction => Res(tr :: Nil, Nil, Map.empty)
              case TsTypeObject(members) => Res(Nil, Nil, Map(tr -> members))
              case dropUnknown           => Res(Nil, dropUnknown :: Nil, Map.empty)
            }
        } getOrElse Res(tr :: Nil, Nil, Map.empty)
    }

  def format(tpe: TsType): String =
    tpe match {
      case ref: TsTypeRef => ref.name.parts.map(_.value).mkString(".")
      case TsTypeUnion(types)     => types map format mkString " | "
      case TsTypeIntersect(types) => types map format mkString " with "
      case other                  => other.asString
    }

  override def enterTsDeclClass(scope: TreeScope)(s: TsDeclClass): TsDeclClass =
    Res.combine(s.parent.to[Seq] ++ s.implements map cleanParentRef(scope)) match {
      case Res(_, Nil, EmptyMap()) => s
      case Res(keep, drop, lifted) =>
        s.copy(
          parent     = keep.headOption,
          implements = keep.drop(1),
          comments   = s.comments +? summarizeChanges(drop, lifted),
          members    = FlattenTrees.newClassMembers(s.members, lifted.flatMap(_._2).to[Seq])
        )
    }

  override def enterTsDeclInterface(scope: TreeScope)(s: TsDeclInterface): TsDeclInterface =
    Res.combine(s.inheritance map cleanParentRef(scope)) match {
      case Res(keep, _, _) if s.inheritance === keep => s
      case Res(keep, drop, lifted) =>
        s.copy(inheritance = keep,
               comments    = s.comments +? summarizeChanges(drop, lifted),
               members     = FlattenTrees.newClassMembers(s.members, lifted.flatMap(_._2).to[Seq]))
    }

  private def summarizeChanges(drop: List[TsType], lifted: Map[TsTypeRef, Seq[TsMember]]): Option[Comment] = {
    val droppedMessages: Seq[String] =
      drop map (d => s"- Dropped ${format(d)}")

    val liftedMessage: Option[String] =
      if (lifted.isEmpty) None
      else Some(s"- Lifted ${lifted.foldLeft(0)(_ + _._2.length)} members from ${lifted.keys.map(format)}")

    droppedMessages ++ liftedMessage match {
      case Nil      => None
      case messages => Some(Comment(s"/* RemoveDifficultInheritance: ${messages.mkString("\n", "\n", "")} */ "))
    }
  }
}
