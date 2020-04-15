package org.scalablytyped.converter.internal
package scalajs
package flavours

final case class Prop(
    main:        Prop.Variant,
    isInherited: Boolean,
    original:    Either[TypeRef, MemberTree],
) {
  def rewrite(f: Prop.Variant => Prop.Variant): Prop =
    copy(main = f(main))

  def isOptional: Boolean = main.tree.default =/= NotImplemented
}

object Prop {
  case class Variant(tree: ParamTree, asExpr: Either[ExprTree.Arg.Named, Name => ExprTree])

  implicit val PropOrdering: Ordering[Prop] =
    Ordering.by((p: Prop) => (p.isOptional, p.main.tree.name))
}
