package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.importer.ImportType.{IsInheritance, Mapping, NameMapping, RefMapping}
import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector
import org.scalablytyped.converter.internal.ts._
import org.scalablytyped.converter.internal.ts.transforms.ExtractInterfaces

class ImportType(stdNames: QualifiedName.StdNames) {

  def orAny(scope: TsTreeScope, importName: AdaptiveNamingImport)(ott: Option[TsType]): TypeRef =
    ott.map(apply(scope, importName)).getOrElse(TypeRef.JsAny)

  def orExprOrAny(scope: TsTreeScope, importName: AdaptiveNamingImport)(ott: Option[TsType]): TypeRef =
    ott match {
      case None    => TypeRef.JsAny
      case Some(x) => apply(scope, importName)(x)
    }

  /**
    * The point here? Dont inherit from sealed classes in scala.js, but otherwise
    * prefer types from there. Handle resolved and unresolved qidents
    */
  private val Mappings = {
    val ArrayM    = NameMapping(stdNames.Array, stdNames.Array, QualifiedName.JsArray)
    val BooleanM  = RefMapping(TypeRef(stdNames.Boolean), TypeRef(stdNames.Boolean), TypeRef.Boolean)
    val FunctionM = RefMapping(TypeRef.JsFunctionBase, TypeRef.JsFunctionBase, TypeRef.JsFunctionBase)
    val ObjectM   = RefMapping(TypeRef(stdNames.Object), TypeRef(stdNames.Object), TypeRef.JsObject)
    val StringM   = RefMapping(TypeRef(stdNames.String), TypeRef(stdNames.String), TypeRef.String)
    val BigIntM   = RefMapping(TypeRef(stdNames.BigInt), TypeRef(stdNames.BigInt), TypeRef.JsBigInt)

    Map[TsQIdent, Mapping[_]](
      TsQIdent.Array -> ArrayM,
      TsQIdent.bigint -> BigIntM,
      TsQIdent.BigInt -> BigIntM,
      TsQIdent.boolean -> BooleanM,
      TsQIdent.Boolean -> BooleanM,
      TsQIdent.Function -> FunctionM,
      TsQIdent.never -> RefMapping(TypeRef.JsAny, TypeRef.JsAny, TypeRef.Nothing),
      TsQIdent.`null` -> RefMapping(TypeRef.JsAny, TypeRef.JsAny, TypeRef.Null),
      TsQIdent.number -> RefMapping(TypeRef(stdNames.Number), TypeRef(stdNames.Number), TypeRef.Double),
      TsQIdent.`object` -> ObjectM,
      TsQIdent.Object -> ObjectM,
      TsQIdent.Std.Array -> ArrayM,
      TsQIdent.Std.Boolean -> BooleanM,
      TsQIdent.Std.BigInt -> BigIntM,
      TsQIdent.Std.ConcatArray -> NameMapping(stdNames.ConcatArray, stdNames.ConcatArray, QualifiedName.JsArray),
      TsQIdent.Std.Function -> FunctionM,
      TsQIdent.Std.Object -> ObjectM,
      TsQIdent.Std.PromiseLike -> NameMapping(stdNames.PromiseLike, stdNames.PromiseLike, QualifiedName.JsThenable),
      TsQIdent.Std.Promise -> NameMapping(QualifiedName.JsPromise, stdNames.Promise, QualifiedName.JsPromise),
      TsQIdent.Std.ReadonlyArray -> NameMapping(stdNames.ReadonlyArray, stdNames.ReadonlyArray, QualifiedName.JsArray),
      TsQIdent.Std.String -> StringM,
      TsQIdent.string -> StringM,
      TsQIdent.String -> StringM,
      TsQIdent.symbol -> RefMapping(TypeRef(stdNames.Symbol), TypeRef(stdNames.Symbol), TypeRef.JsSymbol),
      TsQIdent.undefined -> RefMapping(TypeRef.JsAny, TypeRef.JsAny, TypeRef.Unit),
      TsQIdent.void -> RefMapping(TypeRef.JsAny, TypeRef.JsAny, TypeRef.Unit),
    )
  }

  def apply(_scope: TsTreeScope, importName: AdaptiveNamingImport)(t1: TsType): TypeRef = {
    val scope = _scope / t1
    t1 match {
      case TsTypeRef(cs, TsQIdent.Std.Readonly, IArray.exactlyOne(one)) =>
        val withComments = one match {
          case ref: TsTypeRef => ref.copy(comments = cs ++ ref.comments)
          case other => other
        }

        apply(scope, importName)(withComments)

      case TsTypeRef(cs, base: TsQIdent, targs: IArray[TsType]) =>
        base match {
          case TsQIdent.any | TsQIdent.unknown =>
            TypeRef.JsAny.withComments(cs)

          case other =>
            lazy val isInheritance = IsInheritance(other, scope)
            lazy val targs2        = targs.map(apply(scope, importName))

            Mappings.get(other) match {
              case Some(m: RefMapping)  => m.pick(isInheritance).withComments(cs)
              case Some(m: NameMapping) => TypeRef(m.pick(isInheritance), targs2, cs)
              case None =>
                try TypeRef(importName(other), targs2, cs)
                catch {
                  case x: NoSuchElementException =>
                    TypeRef.JsAny.withComments(Comments(s"/* Couldn't translate: '${x.getMessage}' */"))
                }
            }
        }

      case TsTypeObject(_, Empty) =>
        TypeRef(QualifiedName.JsObject, Empty, NoComments)

      /* Proper handling (of static) cases will be done in `ApplyTypeMapping`.
       * This piece of code just ignores the effect of the type mapping.
       *
       * It is crucial that this "logic" live here in the importer, since it needs to be exported
       *  in it's original form to dependencies
       */
      case tpe @ TsTypeObject(_, IArray.exactlyOne(TsMemberTypeMapped(_, _, _, key, _, _, to))) =>
        // this forms the bases of a speculative, somewhat nicer output. it might be wrong, but does positive things for react
        val lookups: IArray[TsTypeRef] =
          TsTreeTraverse.collect(to) {
            case TsTypeLookup(from: TsTypeRef, _)
                // avoid referring to the key of the type mapping
                if TsTreeTraverse
                  .collect(from) { case TsTypeRef(_, TsQIdent(IArray.exactlyOne(`key`)), _) => null }
                  .isEmpty =>
              from
          }

        val base = lookups match {
          case IArray.exactlyOne(one) => apply(scope, importName)(one)
          case _                      => TypeRef.JsAny
        }

        def c = Comments(Comment.warning(s"Unsupported type mapping: \n${TsTypeFormatter(tpe)}\n"))

        scope.stack
          .collectFirst {
            case x: TsDeclTypeAlias if x.codePath.forceHasPath.codePath === TsQIdent.Std.Record =>
              TypeRef.StringDictionary(TypeRef(ImportName(x.tparams(1).name)), NoComments)
            case x: TsNamedDecl =>
              TypeRef.Intersection(IArray(TypeRef.StringLiteral(x.name.value), TypeRef.TopLevel(base)), c)
          }
          .getOrElse(base.withComments(c))

      case TsTypeObject(_, ms) if ExtractInterfaces.isDictionary(ms) =>
        val (numbers, strings, Empty) = ms.partitionCollect2(
          { case x @ TsMemberIndex(_, _, _, Indexing.Dict(_, TsTypeRef.number), _) => x },
          { case x @ TsMemberIndex(_, _, _, Indexing.Dict(_, _), _)                => x },
        )

        val translatedStrings = strings.collect {
          case TsMemberIndex(cs, _, _, Indexing.Dict(_, _), valueType) =>
            (cs, orAny(scope, importName)(valueType))
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
          case TsMemberIndex(cs, _, _, Indexing.Dict(_, TsTypeRef.number), valueType) =>
            (cs, orAny(scope, importName)(valueType))
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
        if (sig.params.length > 22) TypeRef.JsFunctionBase
        else {
          val newSig = ts.FillInTParams.inlineTParams(sig)

          val (thisType, restParams) =
            newSig.params match {
              case IArray.headTail(first, tail) if first.name === TsIdent.`this` =>
                (Some(funParam(scope, importName)(first)), tail)
              case all =>
                (None, all)
            }

          TypeRef.JsFunction(
            thisType,
            restParams.map(funParam(scope, importName)),
            orAny(scope, importName)(newSig.resultType),
            newSig.comments,
          )
        }
      case TsTypeUnion(types) =>
        val patched =
          if (!types.contains(TsTypeRef.boolean)) types
          else {
            types.partitionCollect {
              case TsTypeLiteral(TsLiteral.Str("true" | "false")) => null
              case TsTypeLiteral(TsLiteral.Bool(true | false))    => null
            } match {
              case (_, rest) => rest
            }
          }

        val imported = patched.map {
          case TsTypeRef.undefined => TypeRef.undefined
          case other               => apply(scope, importName)(other)
        }

        TypeRef.Union(imported, NoComments, sort = false)

      case TsTypeIntersect(types) =>
        TypeRef.Intersection(types.map(apply(scope, importName)), NoComments)

      case TsTypeConstructor(_, TsTypeFunction(sig)) =>
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
        def labelComment(elem: TsTupleElement): Comments =
          elem.label match {
            case Some(value) => Comments(s"/* ${value.value} */")
            case None        => NoComments
          }

        targs match {
          case IArray.initLast(init, elem @ TsTupleElement(_, TsTypeRepeated(repeated))) =>
            ts.FollowAliases(scope)(repeated) match {
              case TsTypeRef(
                  _,
                  TsQIdent.Std.Array | TsQIdent.Std.ReadonlyArray | TsQIdent.Array | TsQIdent.ReadonlyArray,
                  IArray.exactlyOne(tpe),
                  ) =>
                TypeRef(
                  importName(TsQIdent.Array),
                  IArray(apply(scope, importName)(TsTypeUnion(init.map(_.tpe) :+ tpe))).distinct,
                  labelComment(elem),
                )
              case other =>
                val c = Comment.warning(s"repeated non-array type: ${TsTypeFormatter(other)}")
                apply(scope, importName)(TsTypeRef(Comments(c) ++ labelComment(elem), TsQIdent.Array, IArray(other)))
            }
          case nonRepeating =>
            TypeRef.JsTuple(nonRepeating.map { elem =>
              apply(scope, importName)(elem.tpe)
                .withComments(labelComment(elem))
            })
        }

      case TsTypeRepeated(underlying) =>
        TypeRef.Repeated(apply(scope, importName)(underlying), NoComments)

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
          case TsLiteral.Num(value)  => TypeRef.NumberLiteral(value)
          case TsLiteral.Str(value)  => TypeRef.StringLiteral(value)
          case TsLiteral.Bool(value) => TypeRef.BooleanLiteral(value.toString)
        }

      case TsTypeThis() =>
        TypeRef.ThisType(NoComments)

      case x: TsTypeConditional =>
        apply(scope, importName)(unify(IArray(x.ifFalse, x.ifTrue)))

      case other =>
        val msg = s"Failed type conversion: ${TsTypeFormatter(other)}"
        scope.logger.info(msg)
        TypeRef(QualifiedName.JsAny, Empty, Comments(Comment.warning(msg)))
    }
  }

  private val toIgnore = Set[TsType](TsTypeRef.never, TsTypeRef.any, TsTypeRef.`object`)

  /**
    * TsTypeUnion.simplified simplifies a set of types into a union types, a normal type, or `never`.
    *    The latter is the least useful, so let's rewrite it to any
    */
  def unify(types: IArray[TsType]): TsType =
    TsTypeUnion.simplified(types.filterNot(toIgnore)) match {
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
    val targs = _sig.tparams.map(p => p.upperBound.getOrElse(TsTypeRef.`object`))
    val sig   = ts.FillInTParams(_sig, targs)

    val params: IArray[TypeRef] =
      sig.params.map { param =>
        val (baseType, isRepeated) = param.tpe match {
          case Some(TsTypeRepeated(repeated)) => (Some(repeated), true)
          case other                          => (other, false)
        }

        val comment = Comment(s"/* ${param.name.value}${if (isRepeated) " (repeated)" else ""} */")

        orAny(scope, importName)(baseType).withComments(Comments(comment))
      }

    val ret: TypeRef =
      orAny(scope, importName)(sig.resultType)

    TypeRef(
      QualifiedName.Instantiable(sig.params.length),
      params :+ ret,
      comments,
    )
  }

  private def funParam(scope: TsTreeScope, importName: AdaptiveNamingImport)(param: TsFunParam): TypeRef =
    orAny(scope / param, importName)(param.tpe).withComments(Comments(s"/* ${param.name.value} */"))
}

object ImportType {
  sealed trait Mapping[T] {
    val inTraitInheritance: T
    val inClassInheritance: T
    val normal:             T
    def pick(isInheritance: IsInheritance): T =
      isInheritance match {
        case IsInheritance.InClass => inClassInheritance
        case IsInheritance.InTrait => inTraitInheritance
        case IsInheritance.Not     => normal
      }
  }
  case class RefMapping(inTraitInheritance: TypeRef, inClassInheritance: TypeRef, normal: TypeRef)
      extends Mapping[TypeRef]
  case class NameMapping(inTraitInheritance: QualifiedName, inClassInheritance: QualifiedName, normal: QualifiedName)
      extends Mapping[QualifiedName]

  sealed trait IsInheritance
  object IsInheritance {
    case object InClass extends IsInheritance
    case object InTrait extends IsInheritance
    case object Not extends IsInheritance

    def apply(tpe: TsQIdent, scope: TsTreeScope): IsInheritance =
      scope.stack match {
        case _ :: (owner: TsDeclInterface) :: _ =>
          if (owner.inheritance.exists(_.name eq tpe)) InTrait else Not
        case _ :: (owner: TsDeclClass) :: _ =>
          if (owner.implements.exists(_.name eq tpe) || owner.parent.exists(_.name eq tpe)) InClass else Not
        case _ => Not
      }
  }
}
