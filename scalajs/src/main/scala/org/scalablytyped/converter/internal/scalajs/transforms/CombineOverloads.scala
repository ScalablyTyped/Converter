package org.scalablytyped.converter.internal
package scalajs
package transforms

import org.scalablytyped.converter.internal.maps._

/**
  * The scala compiler inherits erasure by the JVM, which is not a problem in javascript.
  * All the overloads we present in typed languages are all backed by one implementation anyway.
  *
  * What we do here is we group methods by what is considered equal types after erasure, and
  *  combine the parameters with union types.
  *
  * We also detect conflicts (same method with different type parameter sets, non-compatible return types),
  *  and rename methods when needed.
  */
class CombineOverloads(erasure: Erasure) extends TreeTransformation {

  override def leaveClassTree(scope: TreeScope)(s: ClassTree): ClassTree = {
    val (methods, fields, Empty) = s.members.partitionCollect2(
      { case x: MethodTree => x },
      { case x: FieldTree  => x },
    )

    s.copy(
      ctors   = ctorHack(scope, s.ctors),
      members = combineOverloads(scope, methods) ++ unifyFields(fields),
    )
  }

  override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree = {
    val (methods, fields, rest) = s.members.partitionCollect2(
      { case x: MethodTree => x },
      { case x: FieldTree  => x },
    )

    s.copy(members = rest ++ unifyFields(fields) ++ combineOverloads(scope, methods))
  }

  override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree = {
    val (methods, fields, rest) = s.members.partitionCollect2(
      { case x: MethodTree => x },
      { case x: FieldTree  => x },
    )
    s.copy(members = rest ++ unifyFields(fields) ++ combineOverloads(scope, methods))
  }

  private def combineSameErasureSameTypeParams(
      methods:      IArray[MethodTree],
      renameSuffix: Option[Suffix],
  ): MethodTree = {
    if (methods.map(_.params.map(_.length: Integer)).toSet.size =/= 1) {
      sys.error("Methods do not have same shape: " + methods)
    }

    val newParamss: IArray[IArray[ParamTree]] =
      methods.head.params.zipWithIndex.map {
        case (params, i) =>
          params.zipWithIndex.map {
            case (param, j) =>
              param.copy(tpe = asUnionType(methods.map(_.params(i)(j).tpe)))
          }
      }

    val combined = methods.head.copy(
      params   = newParamss,
      comments = Comments.flatten(methods)(_.comments),
    )

    renameSuffix.foldLeft(combined) {
      case (ret, suffix) => ret.withSuffix(suffix)
    }
  }

  private def combineSameErasure(_methods: IArray[MethodTree], scope: TreeScope): IArray[MethodTree] = {
    val grouped: IArray[((IArray[Name], QualifiedName), IArray[MethodTree])] =
      _methods
        .groupBy(m => (m.tparams.map(_.name), m.resultType.typeName))
        .toIArray
        .sortBy(_._1._1.length)

    val default: MethodTree =
      combineSameErasureSameTypeParams(grouped.head._2, None)

    val suffixed: IArray[MethodTree] =
      grouped
        .drop(1)
        .mapNotNone {
          case (_, methods) if methods.head.name === Name.APPLY || methods.head.name === Name.namespaced =>
            scope.logger.info(
              s"Dropping ${methods.length} incompatible `apply` overloads (have no way to express this) at $scope",
            )
            None
          case ((tparamNames, retType), methods) =>
            val returnTypeSuffix: Option[Suffix] =
              if (retType === default.resultType.typeName) None else Some(ToSuffix(retType))

            Some(combineSameErasureSameTypeParams(methods, Some(ToSuffix(tparamNames) +? returnTypeSuffix)))
        }

    default +: suffixed
  }

  def asUnionType(_types: IArray[TypeRef]): TypeRef =
    _types match {
      case IArray.exactlyOne(head) =>
        head

      case sameTypeName if sameTypeName.map(_.typeName).distinct.length === 1 =>
        val typeName = sameTypeName.head.typeName

        if (typeName === QualifiedName.UNION)
          TypeRef.Union(sameTypeName.flatMap(_.targs), NoComments, sort = true)
        else if (typeName === QualifiedName.INTERSECTION)
          TypeRef.Intersection(sameTypeName.flatMap(_.targs), NoComments)
        else if (TypeRef.Literal(typeName))
          TypeRef.Union(sameTypeName.distinct, NoComments, sort = true)
        else {
          val combinedTArgs: IArray[TypeRef] = sameTypeName.map(_.targs).transpose.map(asUnionType)
          TypeRef(typeName, combinedTArgs, Comments.flatten(sameTypeName)(_.comments))
        }

      case types =>
        TypeRef.Union(
          types.groupBy(_.typeName).mapToIArray { case (_, v) => asUnionType(v) },
          NoComments,
          sort = true,
        )
    }

  def combineOverloads(scope: TreeScope, methods: IArray[MethodTree]): IArray[MethodTree] = {

    val methodsByBase = methods.groupBy(erasure.base(scope))

    val newMethods: IArray[MethodTree] =
      methodsByBase.flatMapToIArray {
        case (_, IArray.exactlyOne(one)) => IArray(one)
        case (_, sameErasure)            => combineSameErasure(sameErasure, scope)
      }

    /* This is being a lazy coder:
     * Given:
     * type A = string
     * type B = string
     * def foo(a: A)
     * def foo(b: B)
     * def foo(c: Double | Int)
     *
     * The first rewrite will be to:
     * def foo(a: A | B)
     * def foo(c: Double | Int)
     *
     * Those will still have the same erasure, so we run it again to produce
     * def foo(a: A | B | Double | Int)
     *
     * Yey
     * */
    if (newMethods.length =/= methods.length) combineOverloads(scope, newMethods) else newMethods
  }

  /**
    * Ctors are methods...ish. This was easier than refactoring
    */
  def ctorHack(scope: TreeScope, members: IArray[CtorTree]): IArray[CtorTree] = {
    val asMethods: IArray[MethodTree] =
      members.map(ctor =>
        MethodTree(
          Empty,
          ctor.level,
          ctor.name,
          Empty,
          IArray(ctor.params),
          ExprTree.native,
          TypeRef.Nothing,
          isOverride = false,
          ctor.comments,
          QualifiedName(IArray.Empty),
          isImplicit = false,
        ),
      )
    val ret = combineOverloads(scope, asMethods)
    ret.map {
      case MethodTree(_, level, _, _, params, _, _, _, comments, _, _) =>
        CtorTree(level, params.head, comments)
    }
  }

  def unifyFields(fields: IArray[FieldTree]): IArray[FieldTree] =
    fields.groupBy(_.name).mapToIArray {
      case (_, IArray.exactlyOne(one)) => one
      case (_, sameName)               => sameName.head.copy(tpe = asUnionType(sameName.map(_.tpe)))
    }
}
