package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast

trait MemberToProp {
  def rewriterOpt: Option[TypeRewriterCast]

  def apply(scope: TreeScope, x: MemberTree, isInherited: Boolean): Option[Prop]
}

object MemberToProp {
  import ExprTree._

  /* yeah, i know. We'll refactor if we'll do many more rewrites */
  class Default(val rewriterOpt: Option[TypeRewriterCast]) extends MemberToProp {
    override def apply(scope: TreeScope, x: MemberTree, isInherited: Boolean): Option[Prop] =
      x match {
        /* fix irritating type inference issue with `js.UndefOr[Double]` where you provide an `Int` */
        case f @ FieldTree(_, name, origTpe, _, _, _, _, _) =>
          FollowAliases(scope)(origTpe) match {
            case Optional(TypeRef.Double) =>
              val defaultedTo = Null

              def fn(obj: Name) =
                If(
                  BinaryOp(Ref(name), "!=", defaultedTo),
                  Call(
                    Ref(QualifiedName(IArray(obj, Name("updateDynamic")))),
                    IArray(IArray(StringLit(f.originalName.unescaped)), IArray(ExprTree.Cast(Ref(name), TypeRef.Any))),
                  ),
                  None,
                )

              val param = ParamTree(
                name       = name,
                isImplicit = false,
                isVal      = false,
                tpe        = TypeRef.Union(IArray(TypeRef.Int, TypeRef.Double), NoComments, sort = false),
                default    = defaultedTo,
                comments   = NoComments,
              )

              Some(
                Prop(Prop.Variant(param, Right(fn), isRewritten = true), isInherited, IArray(Prop.Undefined), Right(f)),
              )

            case Optional(dealiased) if TypeRef.Primitive(TypeRef(Erasure.simplify(scope / x, dealiased))) =>
              val param = ParamTree(
                name       = name,
                isImplicit = false,
                isVal      = false,
                tpe        = TypeRef.UndefOr(dealiased),
                default    = undefined,
                comments   = NoComments,
              )

              def fn(obj: Name) =
                If(
                  pred = Unary("!", Call(Ref(QualifiedName.isUndefined), IArray(IArray(Ref(name))))),
                  ifTrue = Call(
                    Select(Ref(obj), Name("updateDynamic")),
                    IArray(IArray(StringLit(f.originalName.unescaped)), IArray(Cast(Ref(name), TypeRef.Any))),
                  ),
                  ifFalse = None,
                )

              Some(
                Prop(
                  Prop.Variant(param, Right(fn), isRewritten = false),
                  isInherited,
                  IArray(Prop.Undefined),
                  Right(f),
                ),
              )

            case Optional(TypeRef.Function(paramTypes, retType)) =>
              if (paramTypes.contains(TypeRef.Nothing)) None // edge case which doesnt work
              else {
                val defaultedTo = Null
                val param = ParamTree(
                  name       = name,
                  isImplicit = false,
                  isVal      = false,
                  tpe        = TypeRef.ScalaFunction(paramTypes, retType, NoComments),
                  default    = defaultedTo,
                  comments   = NoComments,
                )

                def setFunction(obj: Name) =
                  Call(
                    Select(Ref(obj), Name("updateDynamic")),
                    IArray(
                      IArray(StringLit(f.originalName.unescaped)),
                      IArray(Call(Ref(QualifiedName.AnyFromFunction(paramTypes.length)), IArray(IArray(Ref(name))))),
                    ),
                  )

                val main = Prop.Variant(
                  param,
                  Right(obj =>
                    If(pred = BinaryOp(Ref(name), "!=", defaultedTo), ifTrue = setFunction(obj), ifFalse = None),
                  ),
                  isRewritten = true,
                )

                Some(Prop(main, isInherited, IArray(Prop.Undefined), Right(f)))
              }

            case Optional(dealiased) =>
              /* Undo effect of FollowAliases above */
              val tpe = Optional.unapply(origTpe).getOrElse(origTpe) match {
                case TypeRef.Wildcard => TypeRef.Any
                case other            => other
              }

              val param = ParamTree(
                name       = name,
                isImplicit = false,
                isVal      = false,
                tpe        = tpe,
                default    = ExprTree.Null,
                comments   = NoComments,
              )

              def fn(obj: Name) =
                If(
                  pred = BinaryOp(Ref(name), "!=", Null),
                  ifTrue = Call(
                    Select(Ref(obj), Name("updateDynamic")),
                    IArray(
                      IArray(StringLit(f.originalName.unescaped)),
                      IArray(Cast(Ref(name), TypeRef.Any)),
                    ),
                  ),
                  ifFalse = None,
                )

              val main = Prop.Variant(param, Right(fn), isRewritten = false)

              val variants: IArray[Prop.VariantLike] =
                dealiased match {
                  case TypeRef.Union(types, _) =>
                    val nested = types
                      .mapNotNone(tpe => apply(scope, f.copy(tpe = tpe), isInherited))
                      .map(x => x.main)

                    nested :+ Prop.Undefined
                  case _ => IArray(Prop.Undefined)
                }

              Some(Prop(main, isInherited, variants, Right(f)))

            case TypeRef.Function(paramTypes, retType) =>
              if (paramTypes.contains(TypeRef.Nothing)) None
              else {
                val param = ParamTree(
                  name,
                  isImplicit = false,
                  isVal      = false,
                  TypeRef.ScalaFunction(paramTypes, retType, NoComments),
                  NotImplemented,
                  NoComments,
                )
                val convertedTarget =
                  Call(Ref(QualifiedName.AnyFromFunction(paramTypes.length)), IArray(IArray(Ref(name))))

                val expr: Either[ExprTree.Arg.Named, Name => ExprTree] =
                  if (!name.isEscaped && f.originalName === name)
                    Left(ExprTree.Arg.Named(name, convertedTarget))
                  else
                    Right(obj =>
                      Call(
                        Select(Ref(obj), Name("updateDynamic")),
                        IArray(
                          IArray(StringLit(f.originalName.unescaped)),
                          IArray(convertedTarget),
                        ),
                      ),
                    )

                val main = Prop.Variant(param, expr, isRewritten = true)
                Some(Prop(main, isInherited, Empty, Right(f)))
              }

            case dealiased =>
              val param = ParamTree(
                name       = name,
                isImplicit = false,
                isVal      = false,
                tpe        = origTpe,
                default    = NotImplemented,
                comments   = NoComments,
              )

              val asExpr: Either[Arg.Named, Name => ExprTree] =
                if (!name.isEscaped && f.originalName === name)
                  Left(Arg.Named(name, Cast(Ref(name), TypeRef.Any)))
                else
                  Right(obj =>
                    Call(
                      Select(Ref(obj), Name("updateDynamic")),
                      IArray(
                        IArray(StringLit(f.originalName.unescaped)),
                        IArray(Cast(Ref(name), TypeRef.Any)),
                      ),
                    ),
                  )

              val variants: IArray[Prop.VariantLike] =
                dealiased match {
                  case TypeRef.Union(types, _) =>
                    types
                      .mapNotNone(tpe => apply(scope, f.copy(tpe = tpe), isInherited))
                      .map(_.main)
                  case _ => Empty
                }

              Some(Prop(Prop.Variant(param, asExpr, isRewritten = false), isInherited, variants, Right(f)))
          }

        case _m: MethodTree =>
          val m               = FillInTParams(_m, scope, _m.tparams.map(_ => TypeRef.Any), Empty)
          val flattenedParams = m.params.flatten

          if (flattenedParams.exists(_.tpe === TypeRef.Nothing)) None // edge case which doesnt work
          else {
            val param = ParamTree(
              name       = m.name,
              isImplicit = false,
              isVal      = false,
              tpe        = TypeRef.ScalaFunction(flattenedParams.map(p => p.tpe), m.resultType, NoComments),
              default    = NotImplemented,
              comments   = NoComments,
            )

            val convertedTarget =
              Call(Ref(QualifiedName.AnyFromFunction(flattenedParams.length)), IArray(IArray(Ref(m.name))))

            def fn(obj: Name) =
              Call(
                Select(Ref(obj), Name("updateDynamic")),
                IArray(IArray(StringLit(m.originalName.unescaped)), IArray(convertedTarget)),
              )

            val expr: Either[Arg.Named, Name => ExprTree] =
              if (!m.name.isEscaped && m.originalName === m.name) Left(Arg.Named(m.name, convertedTarget))
              else Right(fn)

            val main = Prop.Variant(param, expr, isRewritten = true)
            Some(Prop(main, isInherited, Empty, Right(m)))
          }
      }
  }
}
