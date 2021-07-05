package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.ExprTree._

class JapgollyMemberToProp(reactNames: ReactNamesProxy, rewrites: IArray[CastConversion]) extends MemberToProp {
  val default = new MemberToProp.Default(rewrites)

  override def apply(scope: TreeScope, x: MemberTree, isInherited: Boolean): Option[Prop] =
    default(scope, x, isInherited).map {
      case prop: Prop.Normal => prop.rewrite(toScalaJsReact(scope))
      case other => other
    }

  val Callback = TypeRef(JapgollyNames.Callback)

  /**
    *- If the method return value is Unit, then convert it to Callback
    *- If the method return value is TYPE, then convert it to Callback[Type]
    */
  def CallbackTo(ref: TypeRef): TypeRef =
    ref match {
      case TypeRef.Unit => Callback
      case other        => TypeRef(JapgollyNames.CallbackTo, IArray(other), NoComments)
    }

  def toScalaJsReact(scope: TreeScope)(variant: Prop.Variant): Prop.Variant = {
    object StripWildcards {
      def unapply(tr: TypeRef): Some[TypeRef] =
        Some(Wildcards.Remove.visitTypeRef(scope)(tr))

      def unapply(trs: IArray[TypeRef]): Some[IArray[TypeRef]] =
        Some(trs.map(Wildcards.Remove.visitTypeRef(scope)))
    }

    variant.tpe match {
      case TypeRef.ScalaFunction(Empty, StripWildcards(retType)) =>
        Prop.Variant(CallbackTo(retType), ref => Select(ref, Name("toJsFn")), isRewritten = true, extendsAnyVal = true)

      case TypeRef.ScalaFunction(StripWildcards(paramTypes), StripWildcards(TypeRef.Unit)) =>
        def fn(ref: ExprTree): ExprTree = {
          val params = paramTypes.zipWithIndex.map {
            case (tpe, i) =>
              ParamTree(Name(s"t$i"), isImplicit = false, isVal = false, tpe, NotImplemented, NoComments)
          }
          val body =
            Call(Select(Call(ref, IArray(params.map(p => Ref(p.name)))), Name("runNow")), IArray(IArray()))

          Call(Ref(QualifiedName.JsAny + Name(s"fromFunction${params.length}")), IArray(IArray(Lambda(params, body))))
        }

        val newRetType = TypeRef.ScalaFunction(paramTypes, Callback, NoComments)

        Prop.Variant(
          tpe = newRetType,
          fn,
          isRewritten   = true,
          extendsAnyVal = false,
        )
      case TypeRef(tpe, _, _) if reactNames.isElement(tpe) =>
        Prop.Variant(
          TypeRef(JapgollyNames.vdom.ReactElement),
          ref => Cast(Select(ref, Name("rawElement")), TypeRef.JsAny),
          isRewritten   = true,
          extendsAnyVal = false,
        )
      case TypeRef(tpe, _, _) if reactNames.isNode(tpe) =>
        Prop.Variant(
          TypeRef(JapgollyNames.vdom.VdomNode),
          ref => Cast(Select(ref, Name("rawNode")), TypeRef.JsAny),
          isRewritten   = true,
          extendsAnyVal = false,
        )
      case _ => variant
    }
  }
}
