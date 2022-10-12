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
      case QualifiedName.AnyVal                        => QualifiedName.Any
      case QualifiedName.AnyRef                        => QualifiedName.Any
      case QualifiedName.UNDEFINED if scalaVersion.is3 => QualifiedName.Unit
      case QualifiedName.UNDEFINED                     => QualifiedName.`|`
      case QualifiedName.WILDCARD                      => QualifiedName.Any
      case QualifiedName.JsUndefOr if scalaVersion.is3 =>
        simplify(scope, TypeRef.Union(tpe.targs :+ TypeRef.Unit, NoComments, sort = false))
      case QualifiedName.JsUndefOr                 => QualifiedName.`|`
      case QualifiedName.UNION if scalaVersion.is3 =>
        // `Null` seems to be disregarded when in a union type
        val targs = if (tpe.targs.length > 1) tpe.targs.filterNot(_ === TypeRef.Null) else tpe.targs

        // we don't really use scala arrays, so let's just go with a too broad erasure for that
        if (targs.exists(_.typeName === QualifiedName.Array)) QualifiedName.Any
        else {
          val erasedParentLattices: IArray[IArray[QualifiedName]] =
            targs.map(t => typeLattice(scope, t))

          erasedParentLattices
            .reduce(_.intersect(_))
            .lastOption
            .getOrElse(QualifiedName.Any)
        }

      case QualifiedName.UNION => QualifiedName.`|`
      case QualifiedName.THIS =>
        scope.stack.collectFirst { case x: ClassTree => x.codePath }.getOrElse(QualifiedName.THIS)

      case QualifiedName.REPEATED => QualifiedName.Array
      // the way we fake literal means these are true enough
      case QualifiedName.STRING_LITERAL  => tpe.targs.head.typeName
      case QualifiedName.DOUBLE_LITERAL  => tpe.targs.head.typeName
      case QualifiedName.INT_LITERAL     => tpe.targs.head.typeName
      case QualifiedName.BOOLEAN_LITERAL => tpe.targs.head.typeName

      case QualifiedName.INTERSECTION if scalaVersion.is3 =>
        // this is not in the spec, but for instance `foo(String & Double)` clashes with `foo(Double)` regardless of order, etc
        def fromPrimitive = tpe.targs.collectFirst {
          case tr if TypeRef.Primitive(tr) => tr.typeName
        }

        def fromClass: Option[QualifiedName] =
          tpe.targs.firstDefined { t =>
            scope.lookup(simplify(scope, t)).collectFirst {
              case (ClassTree(_, _, _, _, _, _, _, _, ClassType.Class, _, _, codePath), _) => codePath
            }
          }

        def fromAlphabetic: QualifiedName =
          tpe.targs.map(targ => simplify(scope, targ)).min(ByName)

        fromPrimitive.orElse(fromClass).getOrElse(fromAlphabetic)

      /* approximate intersections. scalac seems to use the first type, unless that is a supertype of a later mentioned type */
      case QualifiedName.INTERSECTION =>
        val isPrimitive = tpe.targs.collectFirst {
          case tr @ (TypeRef.String | TypeRef.Boolean | TypeRef.Double) => tr.typeName
        }

        isPrimitive
          .getOrElse {
            val erasedParentLattices: IArray[IArray[QualifiedName]] =
              tpe.targs.map(t => typeLattice(scope, t))

            erasedParentLattices
              .foldLeft(Empty: IArray[QualifiedName]) {
                case (nonEmpty, lattice) =>
                  val latticeSet = lattice.toSet
                  nonEmpty.filterNot(latticeSet) match {
                    case Empty => lattice
                    case other => other
                  }
              }
              .headOption
              .getOrElse(QualifiedName.Any)
          }

      // if this is a type parameter
      case QualifiedName(IArray.exactlyOne(head)) if scope.tparams.contains(head) =>
        QualifiedName.Any

      // if run after FakeSingletons
      case name @ QualifiedName(parts) if parts.length > 2 && (tpe.comments.has[Marker.WasLiteral]) => name

      case other =>
        scope
          .lookup(other)
          .collectFirst {
            case (x: TypeAliasTree, _) =>
              if (x.alias.typeName === other) QualifiedName.Any
              else {
                val newTa = FillInTParams(x, scope, tpe.targs, Empty)
                simplify(scope / newTa, newTa.alias)
              }
            case (x: ClassTree, _) => x.codePath
          }
          .getOrElse(other)
    }

  // The erased type for A | B is the erased least upper bound of the erased types of A and B. Quoting from the documentation of TypeErasure#erasedLub
  private def typeLattice(scope: TreeScope, current: TypeRef): IArray[QualifiedName] =
    scope
      .lookup(simplify(scope, current))
      .collectFirst {
        // this is an ST specific hack. the printer still adds `StObject` parent for native parents :/
        case (x: ClassTree, _) if x.parents.isEmpty && x.isNative =>
          typeLattice(scope, TypeRef(QualifiedName.StObject)) :+ x.codePath
        case (x: ClassTree, newScope) =>
          x.parents.flatMap(p => typeLattice(newScope, p)) :+ x.codePath
      }
      .getOrElse(Empty)
}

final case class MethodErasure(name: Name, params: IArray[QualifiedName], ret: QualifiedName)
final case class MethodBase(name:    Name, params: IArray[QualifiedName])
