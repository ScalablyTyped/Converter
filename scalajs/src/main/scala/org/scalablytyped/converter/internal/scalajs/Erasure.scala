package org.scalablytyped.converter.internal
package scalajs

import org.scalablytyped.converter.internal.scalajs.transforms.FakeLiterals

/**
  * Note, this requires that the method tree has already filled in type params for containing context!
  */
object Erasure {
  def base(_scope: TreeScope)(s: MethodTree): MethodBase = {
    val newScope = _scope / s
    MethodBase(
      s.name,
      s.params.flatten.map(param => simplify(newScope, param.tpe)),
    )
  }
  def erasure(_scope: TreeScope)(s: MethodTree): MethodErasure = {
    val newScope = _scope / s
    MethodErasure(
      s.name,
      s.params.flatten.map(param => simplify(newScope, param.tpe)),
      simplify(newScope, s.resultType),
    )
  }

  def simplify(scope: TreeScope, tpe: TypeRef): QualifiedName =
    tpe.typeName match {
      case QualifiedName.UndefOr   => QualifiedName.`|`
      case QualifiedName.WILDCARD  => QualifiedName.ScalaAny
      case QualifiedName.THIS_TYPE => QualifiedName.THIS_TYPE
      case QualifiedName.UNION     => QualifiedName.`|`
      case QualifiedName.REPEATED  => QualifiedName.JArray
      // the way we fake literal means these are true enough
      case QualifiedName.STRING_LITERAL  => tpe.targs.head.typeName
      case QualifiedName.NUMBER_LITERAL  => tpe.targs.head.typeName
      case QualifiedName.BOOLEAN_LITERAL => tpe.targs.head.typeName

      case QualifiedName.INTERSECTION =>
        val primitive = tpe.targs.collectFirst {
          case tr @ (TypeRef.String | TypeRef.Boolean | TypeRef.Double) => tr.typeName
        }
        primitive.getOrElse(
          simplify(scope, tpe.targs.filterNot(_.typeName === QualifiedName.Object).head),
        )

      // if this is a type parameter
      case QualifiedName(IArray.exactlyOne(head)) if scope.tparams.contains(head) => QualifiedName.ScalaAny

      // if run after FakeSingletons
      case name @ QualifiedName(parts) if parts.length > 2 && (tpe.comments eq FakeLiterals.LiteralTokenComment) => name

      case other =>
        scope
          .lookup(other)
          .collectFirst {
            case (x: TypeAliasTree, s) =>
              if (x.alias.typeName === other) QualifiedName.ScalaAny
              else simplify(s, FillInTParams(x, s, tpe.targs, Empty).alias)
            case (x: ClassTree, _) => x.codePath
          }
          .getOrElse(other)
    }
}

final case class MethodErasure(name: Name, params: IArray[QualifiedName], ret: QualifiedName)
final case class MethodBase(name:    Name, params: IArray[QualifiedName])
