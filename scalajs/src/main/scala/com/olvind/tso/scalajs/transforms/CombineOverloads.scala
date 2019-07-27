package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso.seqs.TraversableOps

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
object CombineOverloads extends TreeTransformation {

  override def enterClassTree(scope: TreeScope)(s: ClassTree): ClassTree = {
    val (methods, fields, Nil) = s.members.partitionCollect2(
      { case x: MethodTree => x },
      { case x: FieldTree  => x },
    )

    s.copy(
      ctors   = ctorHack(scope, s.ctors),
      members = combineOverloads(scope, methods) ++ unifyFields(fields),
    )
  }

  override def enterModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree = {
    val (methods, fields, rest) = s.members.partitionCollect2(
      { case x: MethodTree => x },
      { case x: FieldTree  => x },
    )

    s.copy(members = rest ++ unifyFields(fields) ++ combineOverloads(scope, methods))
  }

  override def enterPackageTree(scope: TreeScope)(s: PackageTree): PackageTree = {
    val (methods, fields, rest) = s.members.partitionCollect2(
      { case x: MethodTree => x },
      { case x: FieldTree  => x },
    )
    s.copy(members = rest ++ unifyFields(fields) ++ combineOverloads(scope, methods))
  }

  private def combineSameErasureSameTypeParams(methods: Seq[MethodTree], renameSuffix: Option[Suffix]): MethodTree = {
    if (methods.map(_.params.map(_.size)).toSet.size =/= 1) {
      sys.error("Methods do not have same shape: " + methods)
    }

    val newParamss: Seq[Seq[ParamTree]] =
      methods.head.params.zipWithIndex map {
        case (params, i) =>
          params.zipWithIndex map {
            case (param, j) =>
              param.copy(tpe = asUnionType(methods.map(_.params(i)(j).tpe)))
          }
      }

    val combined = methods.head.copy(
      params   = newParamss,
      comments = Comments.flatten(methods)(_.comments),
    )

    renameSuffix.foldLeft(combined) {
      case (ret, suffix) => ret withSuffix suffix
    }
  }

  private def combineSameErasure(_methods: Seq[MethodTree], scope: TreeScope): Seq[MethodTree] = {
    val grouped: Seq[((Seq[TypeParamTree], QualifiedName), Seq[MethodTree])] =
      _methods.groupBy(m => (m.tparams, m.resultType.typeName)).to[Seq].sortBy(_._1._1.size)

    val default: MethodTree =
      combineSameErasureSameTypeParams(grouped.head._2, None)

    val suffixed: Seq[MethodTree] =
      grouped drop 1 flatMap {
        case (_, methods) if methods.head.name === Name.APPLY =>
          scope.logger.info(
            s"Dropping ${methods.length} incompatible `apply` overloads (have no way to express this) at $scope",
          )
          Nil
        case ((tparams: Seq[TypeParamTree], retType), methods) =>
          val returnTypeSuffix: Option[Suffix] =
            if (retType === default.resultType.typeName) None else Some(ToSuffix(retType))

          Some(combineSameErasureSameTypeParams(methods, Some(ToSuffix(tparams) +? returnTypeSuffix)))
      }

    default +: suffixed
  }

  def asUnionType(_types: Seq[TypeRef]): TypeRef =
    _types match {
      case head +: Nil =>
        head

      case sameTypeName if sameTypeName.map(_.typeName).distinct.size === 1 =>
        val typeName = sameTypeName.head.typeName

        if (typeName === QualifiedName.UNION)
          TypeRef.Union(sameTypeName.flatMap(_.targs), sort = true)
        else {
          val combinedTArgs: Seq[TypeRef] = sameTypeName.map(_.targs).transpose.map(asUnionType)
          TypeRef(typeName, combinedTArgs, Comments.flatten(sameTypeName)(_.comments))
        }

      case types =>
        TypeRef.Union(types.groupBy(_.typeName).values.toList.map(asUnionType), sort = true)
    }

  def combineOverloads(scope: TreeScope, methods: Seq[MethodTree]): Seq[MethodTree] = {

    val methodsByBase = methods.groupBy(Erasure.base(scope))

    val newMethods: Seq[MethodTree] =
      methodsByBase.flatMap {
        case (_, Seq(one))    => Seq(one)
        case (_, sameErasure) => combineSameErasure(sameErasure, scope)
      }(collection.breakOut)

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
    if (newMethods.size =/= methods.size) combineOverloads(scope, newMethods) else newMethods
  }

  /**
    * Ctors are methods...ish. This was easier than refactoring
    */
  def ctorHack(scope: TreeScope, members: Seq[CtorTree]): Seq[CtorTree] = {
    val asMethods: Seq[MethodTree] =
      members.map(
        ctor =>
          MethodTree(
            Nil,
            ctor.level,
            ctor.name,
            Nil,
            Seq(ctor.params),
            MemberImpl.Native,
            TypeRef.Nothing,
            false,
            ctor.comments,
            QualifiedName(Nil),
          ),
      )
    val ret = combineOverloads(scope, asMethods)
    ret.map {
      case MethodTree(_, level, _, _, params, _, _, _, comments, _) =>
        CtorTree(level, params.head, comments)
    }
  }

  def unifyFields(fields: Seq[FieldTree]): Iterable[FieldTree] =
    fields.groupBy(_.name).map {
      case (_, Seq(one)) => one
      case (_, sameName) => sameName.head.copy(tpe = asUnionType(sameName.map(_.tpe)))
    }
}
