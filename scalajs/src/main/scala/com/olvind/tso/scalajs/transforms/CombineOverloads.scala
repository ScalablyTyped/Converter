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
object CombineOverloads extends SymbolVisitor {

  private def combineSameErasureSameTypeParams(methods:      Seq[MethodSymbol],
                                               renameSuffix: Option[Suffix]): MethodSymbol = {
    if (methods.map(_.params.map(_.size)).toSet.size =/= 1) {
      sys.error("Methods do not have same shape: " + methods)
    }

    val newParamss: Seq[Seq[ParamSymbol]] =
      methods.head.params.zipWithIndex map {
        case (params, i) =>
          params.zipWithIndex map {
            case (param, j) =>
              param.copy(tpe = asUnionType(methods.map(_.params(i).apply(j).tpe)))
          }
      }

    val combined = methods.head.copy(
      params   = newParamss,
      comments = Comments.flatten(methods)(_.comments)
    )

    renameSuffix.foldLeft(combined) {
      case (ret, suffix) => ret withSuffix suffix
    }
  }

  private def combineSameErasure(_methods: Seq[MethodSymbol], scope: SymbolScope): Seq[MethodSymbol] = {
    val grouped: Seq[((Seq[TypeParamSymbol], QualifiedName), Seq[MethodSymbol])] =
      _methods.groupBy(m => (m.tparams, m.resultType.typeName)).to[Seq].sortBy(_._1._1.size)

    val default: MethodSymbol =
      combineSameErasureSameTypeParams(grouped.head._2, None)

    val suffixed: Seq[MethodSymbol] =
      grouped drop 1 flatMap {
        case (_, methods) if methods.head.name === Name.APPLY =>
          scope.logger.info(
            s"Dropping ${methods.length} incompatible `apply` overloads (have no way to express this) at $scope"
          )
          Nil
        case ((tparams: Seq[TypeParamSymbol], retType), methods) =>
          val returnTypeSuffix: Option[Suffix] =
            if (retType === default.resultType.typeName) None else Some(ToSuffix(retType))

          Some(combineSameErasureSameTypeParams(methods, Some(ToSuffix(tparams) +? returnTypeSuffix)))
      }

    default +: suffixed
  }

  /* recursively combine `_params` into one `TypeRef` Using union types */
  def asUnionType(_params: Seq[TypeRef]): TypeRef =
    _params match {
      case head +: Nil =>
        head

      case params if params.map(_.typeName).distinct.size === 1 =>
        val typeName = params.head.typeName
        val targs: Seq[TypeRef] =
          if (typeName === QualifiedName.UNION)
            params.flatMap(_.targs).distinct
          else params.map(_.targs).transpose.map(asUnionType)

        TypeRef(typeName, targs, Comments.flatten(params)(_.comments))

      case params =>
        TypeRef.Union(
          params
            .groupBy(_.typeName)
            .values
            .to[Seq] map asUnionType sortBy (_.typeName.toString)
        )
    }

  def combineOverloads(scope: SymbolScope, ms: Seq[MemberSymbol]): Seq[MemberSymbol] = {

    val methods: Seq[MethodSymbol] =
      ms collect {
        case c: MethodSymbol => c
      }

    val fields: Seq[MemberSymbol] =
      ms.filterNot(methods.contains)

    val methodsByBase = methods.groupBy(Erasure.base(scope))
    val newMethods: Iterable[MethodSymbol] =
      methodsByBase.flatMap {
        case (_, Seq(one))    => Seq(one)
        case (_, sameErasure) => combineSameErasure(sameErasure, scope)
      }

    val ret = fields ++ newMethods

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
    if (ret.size =/= ms.size) combineOverloads(scope, ret) else ret
  }

  /**
    * Ctors are methods...ish. This was easier than refactoring
    */
  def ctorHack(scope: SymbolScope, members: Seq[CtorSymbol]): Seq[CtorSymbol] = {
    val asMethods: Seq[MethodSymbol] =
      members.map(
        ctor =>
          MethodSymbol(Nil,
                       ctor.level,
                       ctor.name,
                       Nil,
                       Seq(ctor.params),
                       FieldTypeNative,
                       TypeRef.Nothing,
                       false,
                       ctor.comments)
      )
    val ret = combineOverloads(scope, asMethods)
    ret.map {
      case MethodSymbol(_, level, _, _, params, _, _, _, comments) =>
        CtorSymbol(level, params.head, comments)
    }
  }

  override def enterClassSymbol(scope: SymbolScope)(s: ClassSymbol): ClassSymbol =
    s.copy(
      ctors   = ctorHack(scope, s.ctors),
      members = combineOverloads(scope, s.members)
    )

  override def enterModuleSymbol(scope: SymbolScope)(s: ModuleSymbol): ModuleSymbol = {
    val (mss, ss) = s.members.partitionCollect {
      case ms: MemberSymbol => ms
    }

    s.copy(members = ss ++ combineOverloads(scope, mss))
  }

  override def enterPackageSymbol(scope: SymbolScope)(s: PackageSymbol): PackageSymbol = {
    val (mss, ss) = s.members.partitionCollect {
      case ms: MemberSymbol => ms
    }
    s.copy(members = ss ++ combineOverloads(scope, mss))
  }
}
