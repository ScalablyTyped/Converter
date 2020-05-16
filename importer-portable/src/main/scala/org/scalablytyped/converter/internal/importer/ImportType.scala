package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector
import org.scalablytyped.converter.internal.ts._
import org.scalablytyped.converter.internal.ts.transforms.ExtractInterfaces

class ImportType(stdNames: QualifiedName.StdNames) {

  def orAny(wildcards: Wildcards, scope: TsTreeScope, importName: AdaptiveNamingImport)(ott: Option[TsType]): TypeRef =
    ott map apply(wildcards, scope, importName) getOrElse TypeRef.Any

  def orExprOrAny(wildcards: Wildcards, scope: TsTreeScope, importName: AdaptiveNamingImport)(
      ott:                   Option[TsType],
  ): TypeRef =
    ott match {
      case None    => TypeRef.Any
      case Some(x) => apply(wildcards, scope, importName)(x)
    }

  sealed trait Mapping
  case class Ref(isInheritance:      TypeRef, normal:       TypeRef) extends Mapping
  case class OnlyName(isInheritance: QualifiedName, normal: QualifiedName) extends Mapping

  /**
    * The point here? Dont inherit from sealed classes in scala.js, but otherwise
    * prefer types from there. Handle resolved and unresolved qidents
    */
  private val Mappings = {
    val ArrayM    = OnlyName(stdNames.Array, QualifiedName.Array)
    val BooleanM  = Ref(TypeRef(stdNames.Boolean), TypeRef.Boolean)
    val FunctionM = Ref(TypeRef.FunctionBase, TypeRef.FunctionBase)
    val ObjectM   = Ref(TypeRef(stdNames.Object), TypeRef.Object)
    val StringM   = Ref(TypeRef(stdNames.String), TypeRef.String)

    Map[TsQIdent, Mapping](
      TsQIdent.Array -> ArrayM,
      TsQIdent.bigint -> Ref(TypeRef(stdNames.BigInt), TypeRef(stdNames.BigInt)),
      TsQIdent.boolean -> BooleanM,
      TsQIdent.Boolean -> BooleanM,
      TsQIdent.Function -> FunctionM,
      TsQIdent.never -> Ref(TypeRef.Any, TypeRef.Nothing),
      TsQIdent.`null` -> Ref(TypeRef.Any, TypeRef.Null),
      TsQIdent.number -> Ref(TypeRef(stdNames.Number), TypeRef.Double),
      TsQIdent.`object` -> ObjectM,
      TsQIdent.Object -> ObjectM,
      TsQIdent.Std.Array -> ArrayM,
      TsQIdent.Std.Boolean -> BooleanM,
      TsQIdent.Std.ConcatArray -> OnlyName(stdNames.ConcatArray, QualifiedName.Array),
      TsQIdent.Std.Function -> FunctionM,
      TsQIdent.Std.Object -> ObjectM,
      TsQIdent.Std.PromiseLike -> OnlyName(stdNames.PromiseLike, QualifiedName.Thenable),
      TsQIdent.Std.Promise -> OnlyName(stdNames.Promise, QualifiedName.Promise),
      TsQIdent.Std.ReadonlyArray -> OnlyName(stdNames.ReadonlyArray, QualifiedName.Array),
      TsQIdent.Std.String -> StringM,
      TsQIdent.string -> StringM,
      TsQIdent.String -> StringM,
      TsQIdent.symbol -> Ref(TypeRef(stdNames.Symbol), TypeRef.Symbol),
      TsQIdent.undefined -> Ref(TypeRef.Any, TypeRef.UndefOr(TypeRef.Nothing)),
      TsQIdent.void -> Ref(TypeRef.Any, TypeRef.Unit),
    )
  }

  def isInheritance(tpe: TsQIdent, scope: TsTreeScope): Boolean =
    scope.stack match {
      case _ :: (owner: TsDeclInterface) :: _ =>
        owner.inheritance.exists(_.name eq tpe)
      case _ :: (owner: TsDeclClass) :: _ =>
        owner.implements.exists(_.name eq tpe) || owner.parent.exists(_.name eq tpe)
      case _ => false
    }

  def apply(wildcards: Wildcards, _scope: TsTreeScope, importName: AdaptiveNamingImport)(t1: TsType): TypeRef = {
    val scope = _scope / t1
    t1 match {
      case TsTypeRef(cs, TsQIdent.Std.Readonly, IArray.exactlyOne(one)) =>
        val withComments = one match {
          case ref: TsTypeRef => ref.copy(comments = cs ++ ref.comments)
          case other => other
        }

        apply(wildcards, scope, importName)(withComments)

      case TsTypeRef(cs, base: TsQIdent, targs: IArray[TsType]) =>
        base match {
          case TsQIdent.any | TsQIdent.unknown =>
            (if (wildcards.allowed) TypeRef.Wildcard else TypeRef.Any).withComments(cs)

          case other =>
            lazy val parent = isInheritance(other, scope)
            lazy val targs2 = targs map apply(wildcards.maybeAllow, scope, importName)

            Mappings.get(other) match {
              case Some(Ref(tr, _)) if parent         => tr.withComments(cs)
              case Some(Ref(_, tr))                   => tr.withComments(cs)
              case Some(OnlyName(qname, _)) if parent => TypeRef(qname, targs2, cs)
              case Some(OnlyName(_, qname))           => TypeRef(qname, targs2, cs)
              case None                               => TypeRef(importName(other), targs2, cs)
            }
        }

      case TsTypeObject(_, Empty) =>
        TypeRef(QualifiedName.Object, Empty, NoComments)

      /* Proper handling (of static) cases will be done in `ApplyTypeMapping`.
       * This piece of code just ignores the effect of the type mapping.
       *
       * It is crucial that this "logic" live here in the importer, since it needs to be exported
       *  in it's original form to dependencies
       */
      case tpe @ TsTypeObject(_, IArray.exactlyOne(TsMemberTypeMapped(_, _, _, _, _, _, to))) =>
        val lookups: IArray[TsTypeRef] =
          TsTreeTraverse.collect(to) { case TsTypeLookup(from: TsTypeRef, _) => from }

        val base = lookups match {
          case IArray.exactlyOne(one) => apply(wildcards, scope, importName)(one)
          case _                      => TypeRef.Any
        }

        def c = Comments(Comment.warning(s"Unsupported type mapping: \n${TsTypeFormatter(tpe)}\n"))

        scope.stack collectFirst {
          case x: TsDeclTypeAlias if x.codePath.forceHasPath.codePath === TsQIdent.Std.Record =>
            TypeRef.StringDictionary(TypeRef(ImportName(x.tparams(1).name)), NoComments)
          case x: TsNamedDecl =>
            TypeRef.Intersection(IArray(TypeRef.StringLiteral(x.name.value), TypeRef.TopLevel(base)), c)
        } getOrElse base.withComments(c)

      case TsTypeObject(_, ms) if ExtractInterfaces.isDictionary(ms) =>
        val (numbers, strings, Empty) = ms.partitionCollect2(
          { case x @ TsMemberIndex(_, _, _, IndexingDict(_, TsTypeRef.number), _, _) => x },
          { case x @ TsMemberIndex(_, _, _, IndexingDict(_, _), _, _)                => x },
        )

        val translatedStrings = strings.collect {
          case TsMemberIndex(cs, _, _, IndexingDict(_, _), isOptional, valueType) =>
            (cs, orAny(wildcards, scope, importName)(valueType).withOptional(isOptional))
        }
        val stringDict = translatedStrings match {
          case Empty => None
          case some =>
            Some(
              TypeRef
                .StringDictionary(
                  TypeRef.Intersection(some.map(_._2), NoComments),
                  Comments.flatten(some.map(_._1))(identity),
                ),
            )
        }
        val translatedNumbers = numbers.collect {
          case TsMemberIndex(cs, _, _, IndexingDict(_, TsTypeRef.number), isOptional, valueType) =>
            (cs, orAny(wildcards, scope, importName)(valueType).withOptional(isOptional))
        }
        val numberDict = translatedNumbers match {
          case Empty => None
          case some =>
            Some(
              TypeRef
                .NumberDictionary(
                  TypeRef.Intersection(some.map(_._2), NoComments),
                  Comments.flatten(some.map(_._1))(identity),
                ),
            )
        }
        TypeRef.Intersection(IArray.fromOptions(stringDict, numberDict), NoComments)

      case TsTypeFunction(sig) =>
        if (sig.params.length > 22) TypeRef.FunctionBase
        else {
          val newSig = ts.FillInTParams.inlineTParams(sig)

          val (thisType, restParams) =
            newSig.params match {
              case IArray.headTail(first, tail) if first.name === TsIdent.`this` =>
                (Some(funParam(wildcards, scope, importName)(first)), tail)
              case all =>
                (None, all)
            }

          TypeRef.Function(
            thisType,
            restParams map funParam(wildcards, scope, importName),
            orAny(wildcards.maybeAllow, scope, importName)(newSig.resultType),
            newSig.comments,
          )
        }
      case TsTypeUnion(types) =>
        val patched =
          if (!types.contains(TsTypeRef.boolean)) types
          else {
            types.partitionCollect {
              case TsTypeLiteral(TsLiteralString("true" | "false")) => null
              case TsTypeLiteral(TsLiteralBoolean(true | false))    => null
            } match {
              case (_, rest) => rest
            }
          }

        val rewritten = patched map {
          case TsTypeRef.undefined => TypeRef.undefined
          case other               => apply(wildcards, scope, importName)(other)
        }
        TypeRef.Union(rewritten, NoComments, sort = false)

      case TsTypeIntersect(types) =>
        TypeRef.Intersection(types map apply(Wildcards.No, scope, importName), NoComments)

      case TsTypeConstructor(TsTypeFunction(sig)) =>
        newableFunction(scope, importName, sig, NoComments)

      case keyof @ TsTypeKeyOf(of) =>
        val ret = AllMembersFor.forType(scope, LoopDetector.initial)(of).collect {
          case x: TsMemberFunction => x.name
          case x: TsMemberProperty => x.name
        } match {
          case Empty => TypeRef.String
          case names => TypeRef.Union(names.map(n => TypeRef.StringLiteral(n.value)), NoComments, sort = true)
        }

        ret.withComments(Comments(Comment(s"/* ${TsTypeFormatter(keyof)} */")))

      case TsTypeTuple(targs) =>
        targs match {
          case IArray.initLast(init, TsTypeRepeated(repeated)) =>
            ts.FollowAliases(scope)(repeated) match {
              case TsTypeRef(
                  _,
                  TsQIdent.Std.Array | TsQIdent.Std.ReadonlyArray | TsQIdent.Array | TsQIdent.ReadonlyArray,
                  IArray.exactlyOne(elem),
                  ) =>
                TypeRef(
                  importName(TsQIdent.Array),
                  IArray(apply(wildcards, scope, importName)(TsTypeUnion(init :+ elem))).distinct,
                  NoComments,
                )
              case other =>
                val c = Comment.warning(s"repeated non-array type: ${TsTypeFormatter(other)}")
                TypeRef(importName(TsQIdent.Array), Empty, Comments(c))
            }
          case nonRepeating =>
            TypeRef.Tuple(nonRepeating map apply(wildcards.maybeAllow, scope, importName))
        }

      case TsTypeRepeated(underlying) =>
        TypeRef.Repeated(apply(wildcards, scope, importName)(underlying), NoComments)

      case TsTypeIs(_, tpe) =>
        tpe match {
          case ref: TsTypeRef =>
            TypeRef.Boolean.withComments(Comments(s"/* is ${TsTypeFormatter(ref)} */"))
          case _ =>
            TypeRef.Boolean
        }

      case TsTypeAsserts(ident, isOpt) =>
        TypeRef.Boolean.withComments(Comments(s"/* asserts ${ident.value} ${isOpt.fold("")("is " + _)}*/"))

      case TsTypeLiteral(lit) =>
        lit match {
          case TsLiteralNumber(value)  => TypeRef.NumberLiteral(value)
          case TsLiteralString(value)  => TypeRef.StringLiteral(value)
          case TsLiteralBoolean(value) => TypeRef.BooleanLiteral(value.toString)
        }

      case TsTypeThis() =>
        TypeRef.ThisType(NoComments)

      case x: TsTypeConditional =>
        apply(wildcards, _scope, importName)(unify(IArray(x.ifFalse, x.ifTrue)))

      case other =>
        val msg = s"Failed type conversion: ${TsTypeFormatter(other)}"
        scope.logger.info(msg)
        TypeRef(QualifiedName.Any, Empty, Comments(Comment.warning(msg)))
    }
  }

  private val toIgnore = Set[TsType](TsTypeRef.never, TsTypeRef.any, TsTypeRef.`object`)

  /**
    * TsTypeUnion.simplified simplifies a set of types into a union types, a normal type, or `never`.
    *    The latter is the least useful, so let's rewrite it to any
    */
  def unify(types: IArray[TsType]): TsType =
    TsTypeUnion.simplified(types filterNot toIgnore) match {
      case TsTypeRef.never => TsTypeRef.any
      case other           => other
    }

  def newableFunction(
      scope:      TsTreeScope.Scoped,
      importName: AdaptiveNamingImport,
      _sig:       TsFunSig,
      comments:   Comments,
  ): TypeRef = {
    /* get rid of type parameters and fill them with bound / object */
    val targs = _sig.tparams.map(p => p.upperBound getOrElse TsTypeRef.`object`)
    val sig   = ts.FillInTParams(_sig, targs)

    val params: IArray[TypeRef] =
      sig.params.map { param =>
        val (baseType, isRepeated) = param.tpe match {
          case Some(TsTypeRepeated(repeated)) => (Some(repeated), true)
          case other                          => (other, false)
        }

        val comment = Comment(s"/* ${param.name.value}${if (isRepeated) " (repeated)" else ""} */")

        orAny(Wildcards.Prohibit, scope, importName)(baseType)
          .withComments(Comments(comment))
          .withOptional(param.isOptional)
      }

    val ret: TypeRef =
      orAny(Wildcards.Prohibit, scope, importName)(sig.resultType)

    TypeRef(
      QualifiedName.Instantiable(sig.params.length),
      params :+ ret,
      comments,
    )
  }

  private def funParam(wildcards: Wildcards, scope: TsTreeScope, importName: AdaptiveNamingImport)(
      param:                      TsFunParam,
  ): TypeRef =
    orAny(wildcards, scope / param, importName)(param.tpe) withOptional param.isOptional withComments Comments(
      s"/* ${param.name.value} */",
    )
}
