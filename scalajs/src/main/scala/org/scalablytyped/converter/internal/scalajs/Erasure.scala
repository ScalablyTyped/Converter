package org.scalablytyped.converter.internal
package scalajs

/**
  * Note, this requires that the method tree has already filled in type params for containing context!
  */
class Erasure(scalaVersion: Versions.Scala) {
  val ByName: Ordering[QualifiedName] = {
    Ordering[IArray[Name]].on[QualifiedName](_.parts)
  }

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
      case QualifiedName.UNDEFINED if scalaVersion.is3 => QualifiedName.Unit
      case QualifiedName.UNDEFINED                     => QualifiedName.`|`
      case QualifiedName.WILDCARD                      => QualifiedName.Any
      case QualifiedName.JsUndefOr if scalaVersion.is3 =>
        simplify(scope, TypeRef.Union(tpe.targs :+ TypeRef.Unit, NoComments, sort = false))
      case QualifiedName.JsUndefOr                 => QualifiedName.`|`
      case QualifiedName.UNION if scalaVersion.is3 =>
        // we don't really use scala arrays, so let's just go with a too broad erasure for that
        if (tpe.targs.exists(_.typeName === QualifiedName.Array)) QualifiedName.Any
        else {
          // The erased type for A | B is the erased least upper bound of the erased types of A and B. Quoting from the documentation of TypeErasure#erasedLub
          def go(scope: TreeScope, current: TypeRef): IArray[QualifiedName] =
            scope
              .lookup(simplify(scope, current))
              .collectFirst {
                // this is an ST specific hack. the printer still adds `StObject` parent for native parents :/
                case (x: ClassTree, _) if x.parents.isEmpty && x.isNative =>
                  go(scope, TypeRef(QualifiedName.StObject)) :+ x.codePath
                case (x: ClassTree, newScope) =>
                  x.parents.flatMap(p => go(newScope, p)) :+ x.codePath
              }
              .getOrElse(Empty)

          val erasedParentLattices: IArray[IArray[QualifiedName]] =
            tpe.targs.map(t => go(scope, t))

          erasedParentLattices.reduce(_.intersect(_)).lastOption.getOrElse(QualifiedName.Any)
        }

      case QualifiedName.UNION    => QualifiedName.`|`
      case QualifiedName.THIS     => QualifiedName.THIS
      case QualifiedName.REPEATED => QualifiedName.Array
      // the way we fake literal means these are true enough
      case QualifiedName.STRING_LITERAL  => tpe.targs.head.typeName
      case QualifiedName.NUMBER_LITERAL  => tpe.targs.head.typeName
      case QualifiedName.BOOLEAN_LITERAL => tpe.targs.head.typeName

      case QualifiedName.INTERSECTION if scalaVersion.is3 =>
        val fromClass: Option[QualifiedName] =
          tpe.targs.firstDefined { t =>
            scope.lookup(simplify(scope, t)).collectFirst {
              case (ClassTree(_, _, _, _, _, _, _, ClassType.Class, _, _, codePath), _) => codePath
            }
          }

        def fromAlphabetic: QualifiedName =
          tpe.targs.map(targ => simplify(scope, targ)).min(ByName)

        fromClass.getOrElse(fromAlphabetic)

      /* approximate intersections. scalac seems to use the first type, unless that is a supertype of a later mentioned type */
      case QualifiedName.INTERSECTION =>
        val isPrimitive = tpe.targs.collectFirst {
          case tr @ (TypeRef.String | TypeRef.Boolean | TypeRef.Double) => tr.typeName
        }

        val isAbstract = tpe.targs.collectFirst {
          case tpe if scope.isAbstract(tpe) => QualifiedName.Any
        }

        isPrimitive.orElse(isAbstract).getOrElse {
          simplify(scope, tpe.targs.head) match {
            case QualifiedName.JsAny if tpe.targs.length > 1 =>
              simplify(scope, tpe.targs(1)) match {
                case QualifiedName.Any => QualifiedName.JsAny
                case other             => other
              }
            case QualifiedName.JsObject if tpe.targs.length > 1 =>
              simplify(scope, tpe.targs(1)) match {
                case QualifiedName.Any => QualifiedName.JsObject
                case other             => other
              }
            case other => other
          }
        }

      // if this is a type parameter
      case QualifiedName(IArray.exactlyOne(head)) if scope.tparams.contains(head) => QualifiedName.Any

      // if run after FakeSingletons
      case name @ QualifiedName(parts) if parts.length > 2 && (tpe.comments.has[Marker.WasLiteral]) => name

      case other =>
        scope
          .lookup(other)
          .collectFirst {
            case (x: TypeAliasTree, s) =>
              if (x.alias.typeName === other) QualifiedName.Any
              else simplify(s, FillInTParams(x, s, tpe.targs, Empty).alias)
            case (x: ClassTree, _) => x.codePath
          }
          .getOrElse(other)
    }
}

final case class MethodErasure(name: Name, params: IArray[QualifiedName], ret: QualifiedName)
final case class MethodBase(name:    Name, params: IArray[QualifiedName])
