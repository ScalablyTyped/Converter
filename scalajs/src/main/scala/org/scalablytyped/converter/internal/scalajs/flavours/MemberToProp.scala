package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.ExprTree._
import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast

trait MemberToProp {
  def apply(scope: TreeScope, x: MemberTree, isInherited: Boolean): Option[Prop]
}

object MemberToProp {
  final class Default(val rewriterOpt: Option[TypeRewriterCast]) extends MemberToProp {
    override def apply(scope: TreeScope, x: MemberTree, isInherited: Boolean): Option[Prop] =
      x match {
        case f @ FieldTree(_, _, origTpe, _, _, _, _, _) =>
          Optionality(FollowAliases(scope)(origTpe)) match {

            case (optionality, TypeRef.JsFunction(paramTypes, retType)) =>
              if (paramTypes.contains(TypeRef.Nothing)) None // edge case which doesnt work
              else if (paramTypes.length > 22) None
              else {
                val main = Prop.Variant(
                  tpe           = TypeRef.ScalaFunction(paramTypes, retType, NoComments),
                  asExpr        = ref => Call(Ref(QualifiedName.AnyFromFunction(paramTypes.length)), IArray(IArray(ref))),
                  isRewritten   = true,
                  extendsAnyVal = false,
                )
                Some(Prop.Normal(main, isInherited, optionality, Empty, f))
              }

            case (optionality, dealiased) =>
              /* Undo effect of FollowAliases above */
              val tpe = Optional.unapply(origTpe).getOrElse(origTpe) match {
                case TypeRef.Wildcard => TypeRef.JsAny
                case other            => other
              }

              def willBeRewritten = rewriterOpt match {
                case Some(rewriter) =>
                  rewriter.conversionsForTypeName.contains(dealiased.typeName) ||
                    rewriter.conversionsForTypeName.contains(origTpe.typeName)
                case None => false
              }

              val variants: IArray[Prop.Variant] =
                dealiased match {
                  case TypeRef.Union(types, _) if !willBeRewritten =>
                    types
                      .mapNotNone(tpe => apply(scope, f.copy(tpe = tpe), isInherited))
                      .flatMap {
                        case x: Prop.Normal => x.allVariants
                        case _ => Empty
                      }
                  case TypeRef(QualifiedName.JsArray, IArray.exactlyOne(t), _) =>
                    IArray(
                      Prop.Variant(
                        TypeRef.Repeated(Wildcards.Remove.visitTypeRef(scope)(t), NoComments),
                        e => Call(Ref(QualifiedName.JsArray), IArray(IArray(`:_*`(e)))),
                        isRewritten   = true,
                        extendsAnyVal = false,
                      ),
                    )
                  case _ => Empty
                }

              val main = Prop.Variant(
                tpe           = tpe,
                asExpr        = ref => Cast(ref, TypeRef.JsAny),
                isRewritten   = willBeRewritten,
                extendsAnyVal = TypeRef.Primitive(TypeRef(Erasure.simplify(scope / x, dealiased))),
              )
              Some(Prop.Normal(main, isInherited, optionality, variants, f))
          }

        case _m: MethodTree =>
          val m               = FillInTParams(_m, scope, _m.tparams.map(_ => TypeRef.JsAny), Empty)
          val flattenedParams = m.params.flatten

          if (flattenedParams.exists(_.tpe === TypeRef.Nothing)) None // edge case which doesnt work
          else if (flattenedParams.length > 22) None
          else {
            val main = Prop.Variant(
              tpe           = TypeRef.ScalaFunction(flattenedParams.map(p => p.tpe), m.resultType, NoComments),
              asExpr        = ref => Call(Ref(QualifiedName.AnyFromFunction(flattenedParams.length)), IArray(IArray(ref))),
              isRewritten   = true,
              extendsAnyVal = false,
            )
            Some(Prop.Normal(main, isInherited, Optionality.No, Empty, m))
          }
      }
  }
}
