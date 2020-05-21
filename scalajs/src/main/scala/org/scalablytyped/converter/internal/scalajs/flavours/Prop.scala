package org.scalablytyped.converter.internal
package scalajs
package flavours

final case class Prop(
    main:        Prop.Variant,
    isInherited: Boolean,
    variants:    IArray[Prop.VariantLike],
    original:    Either[TypeRef, MemberTree],
) {
  def rewrite(f: Prop.Variant => Prop.Variant): Prop =
    copy(main = f(main), variants = variants.map(_.rewrite(f)))

  def isOptional: Boolean = main.tree.default =/= NotImplemented
}

object Prop {

  sealed trait VariantLike {
    def rewrite(f: Variant => Variant): VariantLike = this match {
      case v: Variant => f(v)
      case Undefined => Undefined
    }
  }
  case class Variant(tree: ParamTree, asExpr: Either[ExprTree.Arg.Named, Name => ExprTree], isRewritten: Boolean)
      extends VariantLike
  case object Undefined extends VariantLike

  implicit val PropOrdering: Ordering[Prop] =
    Ordering.by((p: Prop) => (p.isOptional, p.main.tree.name))
}
