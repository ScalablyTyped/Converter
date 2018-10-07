package com.olvind.tso
package scalajs
package transforms

/**
  * Scala surprisingly doesn't accept this:
  *
  * ```scala
  * type Id[T] = T
  * type Foo = Id[Id[Int]]
  * ```
  *
  * This is only really a problem since we don't properly expand type mappings for now
  */
object InlineNestedIdentityAlias extends SymbolVisitor {
  override def enterTypeRef(scope: SymbolScope)(ref: TypeRef): TypeRef =
    simplify(scope, ref) getOrElse ref

  def isIdentityFor(body: Name)(tr: TypeRef): Boolean =
    tr match {
      case TypeRef(QualifiedName(`body` :: Nil), Nil, _) => true
      case TypeRef.Intersection(types)                   => types exists isIdentityFor(body)
      case _                                             => false
    }

  private def simplify(scope: SymbolScope, ref: TypeRef): Option[TypeRef] = ref match {
    case TypeRef(maybeIdentityWrapper, Seq(realType), cs) =>
      scope.lookup(maybeIdentityWrapper) collectFirst {
        case (TypeAliasSymbol(_, Seq(TypeParamSymbol(tparam, _, _)), alias, _), _) if isIdentityFor(tparam)(alias) =>
          // at this point we know that the referenced type is identity, now consider if the only type param references the same wrapper

          val mustSimplify: Option[Boolean] =
            scope lookup realType.typeName collectFirst {
              case (TypeAliasSymbol(_, _, innerAlias, _), _) =>
                innerAlias match {
                  case TypeRef.Union(ts)        => ts.exists(_.typeName === maybeIdentityWrapper)
                  case TypeRef.Intersection(ts) => ts.exists(_.typeName === maybeIdentityWrapper)
                  case t                        => t.typeName === maybeIdentityWrapper
                }
            }

          if (mustSimplify getOrElse false)
            realType.withComments(cs + inlineComment(maybeIdentityWrapper))
          else ref
      }
    case _ => None
  }

  private def inlineComment(maybeIdentityWrapper: QualifiedName) =
    Comment(s"/* InlineNestedIdentityAlias: ${Printer.formatQN(Nil, maybeIdentityWrapper)}*/ ")
}
