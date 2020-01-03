package org.scalablytyped.converter.internal
package scalajs
package flavours

/**
  * A mapping from one javascript type to another.
  *
  * @param from typically from ScalablyTyped
  * @param to typically from the library you want to convert into
  * @param tparams Since the set of type parameters might differ you can pick among the provided type arguments in the `from` type
  */
case class CastConversion(from: QualifiedName, to: QualifiedName, tparams: CastConversion.TParam*)

object CastConversion {
  sealed trait TParam {
    def eval(provided: IArray[TypeRef]): TypeRef =
      this match {
        case TParam._1           => provided(0)
        case TParam._2           => provided(1)
        case TParam._3           => provided(2)
        case TParam.Ref(typeRef) => typeRef
        case TParam.Constrained(outer, among, default) =>
          outer.eval(provided) match {
            case tr @ TypeRef(x, _, _) if among(x) => tr
            case tr                                => TypeRef.Intersection(IArray(tr, TypeRef(default, Empty, UndoDamage.comment(among))))
          }
      }
    def among(among: Set[QualifiedName], default: QualifiedName): TParam =
      TParam.Constrained(this, among, default)
  }

  object TParam {
    implicit def asRef(typeRef: TypeRef): Ref = Ref(typeRef)
    /* pick the first type argument */
    case object _1 extends TParam
    /* pick the second type argument */
    case object _2 extends TParam
    /* I'm sure you get the point */
    case object _3 extends TParam
    /* default to a given type */
    case class Ref(typeRef: TypeRef) extends TParam
    /* If we need to adhere to a type bound which isn't (directly) in Typescript */
    case class Constrained(outer: TParam, among: Set[QualifiedName], default: QualifiedName) extends TParam
  }

  case class TypeRewriterCast(conversions: IArray[CastConversion]) extends TreeTransformation {
    val map = conversions.map(x => x.from -> x).toMap

    def mapped(x: TypeRef, scope: TreeScope): Option[TypeRef] =
      map.get(x.typeName).map { conv =>
        val targs = IArray.apply(conv.tparams.map(tp => visitTypeRef(scope)(tp.eval(x.targs))): _*)
        x.copy(typeName = conv.to, targs = targs)
      }

    object Scoped {
      def unapply(ts: TreeScope): Option[(TreeScope, Tree)] =
        ts match {
          case x: TreeScope.Scoped => Some((x.outer, x.current))
          case _ => None
        }
    }

    def isRisky(scope: TreeScope): Boolean =
      scope match {
        case _: TreeScope.Root[_] => false
        case Scoped(outer, current) =>
          current match {
            /* changing inheritance to classes we haven't had the chance to inspect will often fail */
            case _: InheritanceTree => true
            case p: ParamTree =>
              outer match {
                case Scoped(mouter, m: MethodTree) =>
                  /* if this is an overloaded method we might break compilation if we translate both to the same type */
                  mouter match {
                    case Scoped(_, owner: InheritanceTree) =>
                      owner.index.get(m.name) match {
                        case Some(membersSameName) if membersSameName.length > 1 =>
                          val paramIdx = m.params.flatten.indexOf(p)
                          /* but not if all overloads have the same type (or none) for the same parameter number */
                          val sameInAllOverloads = membersSameName.forall {
                            case mm: MethodTree =>
                              val mmParams = mm.params.flatten
                              if (mmParams.length < paramIdx + 1) true
                              else mmParams(paramIdx).tpe === p.tpe
                            case _ => false
                          }
                          !sameInAllOverloads
                        case _ => false
                      }
                    case _ => false
                  }
                case _ => false
              }
            case _: TypeRef => isRisky(outer)
            case _ => false
          }
      }

    override def leaveTypeRef(scope: TreeScope)(original: TypeRef): TypeRef = UndoDamage(
      if (isRisky(scope)) original
      else
        mapped(original, scope).orElse(mapped(FollowAliases(scope)(original), scope)) match {
          case Some(TypeRef.Intersection(types)) => TypeRef.Intersection(types)
          case Some(TypeRef.Union(types))        => TypeRef.Union(types, sort = false)
          case Some(rewritten)                   => rewritten
          case None                              => original
        },
    )
  }

  /**
    * Fix needless intersection type arising from using a constrained type in a type alias,
    *  then replacing the type parameter with something that actually comforms.
    */
  object UndoDamage {
    case class WasDefaulted(among: Set[QualifiedName]) extends Comment.Data

    def comment(among: Set[QualifiedName]) =
      Comments(CommentData(WasDefaulted(among)))

    def apply(x: TypeRef): TypeRef = x match {
      case TypeRef.Intersection(IArray.exactlyTwo(original, TypeRef(bound @ _, Empty, comments))) =>
        comments.extract { case WasDefaulted(among) => among } match {
          case Some((among, _)) if among.contains(original.typeName) => original
          case _                                                     => x
        }
      case _ => x
    }
  }
}
