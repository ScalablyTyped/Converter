package org.scalablytyped.converter.internal
package scalajs

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
        case TParam._1           => provided.applyOrElse(0, _ => TypeRef.Any)
        case TParam._2           => provided.applyOrElse(1, _ => TypeRef.Any)
        case TParam._3           => provided.applyOrElse(2, _ => TypeRef.Any)
        case TParam.Ref(typeRef) => typeRef
        case TParam.Constrained(outer, among, default) =>
          outer.eval(provided) match {
            case tr @ TypeRef(x, _, _) if among(x) =>
              tr
            case tr =>
              TypeRef.Intersection(IArray(tr, TypeRef(default, Empty, NoComments)), NoComments)
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

  final class TypeRewriterCast(conversions: IArray[CastConversion]) extends TreeTransformation {
    val conversionsForTypeName: Map[QualifiedName, CastConversion] =
      conversions.map(x => x.from -> x).toMap

    def maybeRewrite(original: TypeRef, scope: TreeScope): Option[TypeRef] =
      conversionsForTypeName.get(original.typeName).map {
        case CastConversion(_, to, tparams @ _*) =>
          val targs = IArray(tparams.map(tp => visitTypeRef(scope)(tp.eval(original.targs))): _*)
          original.copy(typeName = to, targs = targs)
      }

    def isInheritanceClause(scope: TreeScope): Boolean =
      scope.stack match {
        case (_: TypeRef) :: (_:   InheritanceTree) :: _ => true
        case (_: TypeRef) :: (int: TypeRef) :: (_: InheritanceTree) :: _ if Name.Internal(int.name) => true
        case _ => false
      }

    override def leaveTypeRef(scope: TreeScope)(original: TypeRef): TypeRef =
      if (isInheritanceClause(scope)) original
      else
        maybeRewrite(original, scope).orElse(maybeRewrite(FollowAliases(scope)(original), scope)) match {
          case Some(rewritten) => rewritten
          case None =>
            original match {
              case TypeRef.Intersection(types, cs) => TypeRef.Intersection(types, cs)
              case TypeRef.Union(types, cs)        => TypeRef.Union(types, cs, sort = false)
              case other                           => other
            }
        }
  }
}
