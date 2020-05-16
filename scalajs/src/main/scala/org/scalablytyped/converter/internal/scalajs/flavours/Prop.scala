package org.scalablytyped.converter.internal
package scalajs
package flavours

sealed trait Prop {
  val name:        Name
  val optionality: Optionality
  val isRequired:  Boolean
}

object Prop {
  final case class Normal(
      main:        Variant,
      isInherited: Boolean,
      optionality: Optionality,
      variants:    IArray[Variant],
      original:    MemberTree,
  ) extends Prop {
    lazy val name: Name = original.name

    lazy val originalName: Name = original.originalName

    lazy val canBeInitializer: Boolean = !name.isEscaped && name === originalName

    lazy val allVariants: IArray[Variant] = main +: variants

    override val isRequired: Boolean = optionality === Optionality.No

    def rewrite(f: Variant => Variant): Prop =
      copy(main = f(main), variants = variants.map(f))
  }

  /**
    * A `Prop` can have several "variants" for providing useful overloads.
    *
    * For instance given a prop `foo: js.Function1[String, String] | String`, we generate overloads for the components
    *  in the union type. The point is that we then can offer good syntax providing callbacks.
    *
    * @param asExpr takes an expression, typically the name of the parameter we generate,
    *               and rewrites it to the javascript value we want to update an object iwth
    * @param isRewritten if any useful rewrites have been done to the type or expression.
    *                    Typically we filter out variants which has not been rewritten
    * @param extendsAnyVal if `tpe` is an `AnyVal` we need to make sure it's not assigned a value of `null`
    */
  case class Variant(tpe: TypeRef, asExpr: ExprTree => ExprTree, isRewritten: Boolean, extendsAnyVal: Boolean)

  /**
    * If a type/component has too many props to fit within Javascripts 254 parameter limit, we group everything
    *  from a parent type into an object of it's own.
    */
  case class CompressedProp(
      name:       Name,
      tpe:        TypeRef,
      asExpr:     ExprTree => ExprTree,
      isRequired: Boolean,
  ) extends Prop {
    val optionality: Optionality = if (isRequired) Optionality.No else Optionality.Undef
  }

  implicit val PropOrdering: Ordering[Prop] =
    Ordering.by((p: Prop) => (p.optionality =/= Optionality.No, p.name))
}
