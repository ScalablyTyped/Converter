package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.flavours.JapgollyGenComponents.japgolly

class JapgollyMemberToProp(reactNames: ReactNames, typeRewriter: TypeRewriterCast)
    extends MemberToProp.Default(Some(typeRewriter)) {

  override def apply(scope: TreeScope, x: MemberTree, isInherited: Boolean): Option[Prop] =
    super.apply(scope, x, isInherited).map(_.rewrite(toScalaJsReact(scope)))

  /**
    *- If the method return value is Unit, then convert it to Callback
    *- If the method return value is TYPE, then convert it to Callback[Type]
    */
  def CallbackTo(ref: TypeRef): TypeRef =
    ref match {
      case TypeRef.Unit => TypeRef(japgolly.reactCallback)
      case other        => TypeRef(japgolly.reactCallbackTo, IArray(other), NoComments)
    }

  def toScalaJsReact(scope: TreeScope)(param: Prop.Variant): Prop.Variant = {
    object StripWildcards {
      def unapply(tr: TypeRef): Some[TypeRef] =
        Some(Wildcards.Remove.visitTypeRef(scope)(tr))

      def unapply(trs: IArray[TypeRef]): Some[IArray[TypeRef]] =
        Some(trs.map(Wildcards.Remove.visitTypeRef(scope)))
    }

    param.tree match {
      /* rewrite functions returning a Callback so that javascript land can call them */
      case pt @ ParamTree(name, _, _, TypeRef.ScalaFunction(Empty, StripWildcards(retType)), default, _)
          if default =/= NotImplemented =>
        /* wrap optional `Callback` in `js.UndefOr` because it's an `AnyVal` */
        def fn(obj: Name): ExprTree =
          ExprTree.Custom(
            s"""${name.value}.foreach(p => ${obj.value}.updateDynamic("${name.unescaped}")(p.toJsFn))""",
          )
        Prop.Variant(
          tree        = pt.copy(tpe = TypeRef.UndefOr(CallbackTo(retType)), default = ExprTree.undefined),
          asExpr      = Right(fn),
          isRewritten = true,
        )

      case pt @ ParamTree(name, _, _, TypeRef.ScalaFunction(Empty, StripWildcards(retType)), NotImplemented, _) =>
        def fn(obj: Name): ExprTree =
          ExprTree.Custom(s"""${obj.value}.updateDynamic("${name.unescaped}")(${name.value}.toJsFn)""")

        Prop.Variant(tree = pt.copy(tpe = CallbackTo(retType)), asExpr = Right(fn), isRewritten = true)

      case pt @ ParamTree(
            name,
            _,
            _,
            TypeRef.ScalaFunction(StripWildcards(paramTypes), StripWildcards(retType)),
            defaultValue,
            _,
          ) =>
        def fn(obj: Name): ExprTree = {
          import ExprTree._
          val params = paramTypes.zipWithIndex.map {
            case (tpe, i) =>
              ParamTree(Name(s"t$i"), isImplicit = false, isVal = false, tpe, NotImplemented, NoComments)
          }
          val body =
            Call(Select(Call(Ref(name), IArray(params.map(p => Ref(p.name)))), Name("runNow")), IArray(IArray()))
          val asJsFunction =
            Call(Ref(QualifiedName.Any + Name(s"fromFunction${params.length}")), IArray(IArray(Lambda(params, body))))
          val mutateObject = Call(
            Select(Ref(obj), Name("updateDynamic")),
            IArray(IArray(StringLit(name.unescaped)), IArray(asJsFunction)),
          )

          defaultValue match {
            case NotImplemented => mutateObject
            case _              => If(BinaryOp(Ref(name), "!=", Null), mutateObject, None)
          }
        }

        val newRetType = TypeRef.ScalaFunction(paramTypes, CallbackTo(retType), NoComments)

        Prop.Variant(
          tree =
            pt.copy(tpe = newRetType, default = if (defaultValue === NotImplemented) NotImplemented else ExprTree.Null),
          asExpr      = Right(fn),
          isRewritten = true,
        )

      case pt @ ParamTree(name, _, _, TypeRef(reactNames.ReactElement, _, _), _, _) =>
        def fn(obj: Name): ExprTree =
          ExprTree.Custom(
            s"""if (${name.value} != null) ${obj.unescaped}.updateDynamic("${name.unescaped}")(${name.value}.rawElement.asInstanceOf[js.Any])""",
          )
        Prop.Variant(
          tree        = pt.copy(tpe = TypeRef(japgolly.vdomReactElement)),
          asExpr      = Right(fn),
          isRewritten = true,
        )

      case pt @ ParamTree(name, _, _, TypeRef(reactNames.ReactNode, _, _), _, _) =>
        def fn(obj: Name) =
          ExprTree.Custom(
            s"""if (${name.value} != null) ${obj.unescaped}.updateDynamic("${name.unescaped}")(${name.value}.rawNode.asInstanceOf[js.Any])""",
          )
        Prop.Variant(
          tree        = pt.copy(tpe = TypeRef(japgolly.vdomVdomNode)),
          asExpr      = Right(fn),
          isRewritten = true,
        )

      case _ => param
    }
  }
}
