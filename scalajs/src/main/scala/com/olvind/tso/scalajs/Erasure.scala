package com.olvind.tso
package scalajs

import com.olvind.tso.scalajs.transforms.FakeLiterals

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

  private def simplify(scope: TreeScope, tpe: TypeRef): QualifiedName =
    tpe.typeName match {
      case QualifiedName.UndefOr   => QualifiedName.`|`
      case QualifiedName.WILDCARD  => QualifiedName.JObject
      case QualifiedName.THIS_TYPE => QualifiedName.THIS_TYPE
      case QualifiedName.UNION     => QualifiedName.`|`
      case QualifiedName.REPEATED  => QualifiedName.JArray
      case QualifiedName.LITERAL =>
        tpe.targs.head.typeName // the way we fake literal means this is true enough
      case QualifiedName.INTERSECTION =>
        val primitive = tpe.targs.collectFirst {
          case tr @ (TypeRef.String | TypeRef.Boolean | TypeRef.Double) => tr.typeName
        }
        primitive.getOrElse(
          simplify(scope, tpe.targs.filterNot(_.typeName === QualifiedName.Object).head),
        )

      // if this is a type parameter
      case QualifiedName(head :: _) if scope.tparams.contains(head) => QualifiedName.JObject

      // if run after FakeSingletons
      case name @ QualifiedName(_ :: _ :: _) if tpe.comments eq FakeLiterals.LiteralTokenComment => name
      case other =>
        scope
          .lookup(other)
          .collectFirst {
            case (x: TypeAliasTree, s) =>
              if (x.alias.typeName === other) QualifiedName.JObject
              else simplify(s, x.alias)
            case (x: ClassTree, _) => x.codePath
          }
          .getOrElse(other)
    }
}

final case class MethodErasure(name: Name, params: Seq[QualifiedName], ret: QualifiedName)
final case class MethodBase(name:    Name, params: Seq[QualifiedName])
