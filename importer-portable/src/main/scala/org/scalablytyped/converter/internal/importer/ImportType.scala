package org.scalablytyped.converter.internal
package importer

import org.scalablytyped.converter.internal.importer.ImportType.{IsInheritance, Mapping, NameMapping, RefMapping}
import org.scalablytyped.converter.internal.scalajs._
import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector
import org.scalablytyped.converter.internal.ts._
import org.scalablytyped.converter.internal.ts.transforms.ExtractInterfaces

import scala.util.{Success, Try}

class ImportType(stdNames: QualifiedName.StdNames) {

  def orAny(scope: TsTreeScope, importName: AdaptiveNamingImport)(ott: Option[TsType]): TypeRef =
    ott.map(apply(scope, importName)).getOrElse(TypeRef.Any)

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
      TsQIdent.never -> RefMapping(TypeRef.Any, TypeRef.Any, TypeRef.Nothing),
      TsQIdent.`null` -> RefMapping(TypeRef.Any, TypeRef.Any, TypeRef.Null),
      TsQIdent.number -> RefMapping(TypeRef(stdNames.Number), TypeRef(stdNames.Number), TypeRef.Double),
      TsQIdent.`object` -> ObjectM,
      TsQIdent.Object -> ObjectM,
      TsQIdent.Std.Array -> ArrayM,
      TsQIdent.Std.Boolean -> BooleanM,
      TsQIdent.Std.BigInt -> BigIntM,
      TsQIdent.Std.ConcatArray -> NameMapping(stdNames.ConcatArray, stdNames.ConcatArray, QualifiedName.JsArray),
      TsQIdent.Std.Function -> FunctionM,
      TsQIdent.Std.Object -> ObjectM,
      TsQIdent.Std.ReadonlyArray -> NameMapping(stdNames.ReadonlyArray, stdNames.ReadonlyArray, QualifiedName.JsArray),
      TsQIdent.Std.String -> StringM,
      TsQIdent.string -> StringM,
      TsQIdent.String -> StringM,
      TsQIdent.symbol -> RefMapping(TypeRef(stdNames.Symbol), TypeRef(stdNames.Symbol), TypeRef.JsSymbol),
      TsQIdent.undefined -> RefMapping(TypeRef.Any, TypeRef.Any, TypeRef.Unit),
      TsQIdent.void -> RefMapping(TypeRef.Any, TypeRef.Any, TypeRef.Unit),
    )
  }

  def apply(outerScope: TsTreeScope, importName: AdaptiveNamingImport)(t1: TsType): TypeRef = {
    val scope = outerScope / t1
    t1 match {
      case TsTypeRef(cs, TsQIdent.Std.Readonly, IArray.exactlyOne(one)) =>
        val withComments = one match {
          case ref: TsTypeRef => ref.copy(comments = cs ++ ref.comments)
          case other => other
        }

        apply(scope, importName)(withComments)

      case TsTypeRef(cs, base: TsQIdent, targs: IArray[TsType]) =>
        def willBeVal: Boolean =
          outerScope.stack.headOption match {
            case Some(_: TsDeclVar) => true
            case _ => false
          }

        base match {
          // val x: Unit = js.native is not legal.
          case TsQIdent.undefined if willBeVal =>
            TypeRef.Any.withComments(Comments("/* undefined */")).withComments(cs)

          case TsQIdent.any | TsQIdent.unknown =>
            TypeRef.Any.withComments(cs)

          case other =>
            lazy val isInheritance = IsInheritance(other, scope)
            lazy val targs2        = targs.map(apply(scope, importName))

            Mappings.get(other) match {
              case Some(m: RefMapping) if !scope.isAbstract(base)  => m.pick(isInheritance).withComments(cs)
              case Some(m: NameMapping) if !scope.isAbstract(base) => TypeRef(m.pick(isInheritance), targs2, cs)
              case _ =>
                try TypeRef(importName(other), targs2, cs)
                catch {
                  case x: NoSuchElementException =>
                    TypeRef.Any.withComments(Comments(s"/* Couldn't translate: '${x.getMessage}' */"))
                }
            }
        }

      case TsTypeObject(_, Empty) =>
        TypeRef(QualifiedName.JsObject, Empty, NoComments)

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
        val types1 = types.map(apply(scope, importName))
        val types2 = if (types1.contains(TypeRef.JsObject)) {
          types1.filterNot(_ == TypeRef.JsObject) match {
            case Empty    => types1
            case nonEmpty => nonEmpty
          }
        } else types1

        TypeRef.Intersection(types2, NoComments)

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

        targs.partitionCollect { case elem @ TsTupleElement(_, TsTypeRepeated(repeated)) => (elem, repeated) } match {
          case (IArray.first((repeatedElem, repeated)), rest) =>
            ts.FollowAliases(scope)(repeated) match {
              case TsTypeRef(
                  _,
                  TsQIdent.Std.Array | TsQIdent.Std.ReadonlyArray | TsQIdent.Array | TsQIdent.ReadonlyArray,
                  IArray.exactlyOne(tpe),
                  ) =>
                TypeRef(
                  importName(TsQIdent.Array),
                  IArray(apply(scope, importName)(TsTypeUnion(rest.map(_.tpe) :+ tpe))).distinct,
                  labelComment(repeatedElem),
                )
              case other =>
                val c = Comment.warning(s"repeated non-array type: ${TsTypeFormatter(other)}")
                apply(scope, importName)(
                  TsTypeRef(Comments(c) ++ labelComment(repeatedElem), TsQIdent.Array, IArray(other)),
                )
            }
          case (_, nonRepeating) =>
            TypeRef.JsTuple(nonRepeating.map { elem =>
              apply(scope, importName)(elem.tpe).withComments(labelComment(elem))
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
          case TsLiteral.Num(value)  => ImportType.numberToTypeRef(value)
          case TsLiteral.Str(value)  => ImportType.stringToTypeRef(value, ImportType.ShouldWiden.Some)
          case TsLiteral.Bool(value) => TypeRef.BooleanLiteral(value.toString)
        }

      case TsTypeThis() =>
        TypeRef.ThisType(NoComments)

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

    if (sig.params.length > 22)
      TypeRef.Any.withComments(
        Comments(s"/* untranslatable newable function with more than 22 parameters: ${TsTypeFormatter.sig(_sig)} */"),
      )
    else
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

  def numberToExpr(value: String): ExprTree = {
    def validInt = Try(java.lang.Long.decode(value)) match {
      case Success(int) if int < Int.MaxValue && int > Int.MinValue => Some(ExprTree.IntLit(value))
      case _                                                        => None
    }

    def validDouble = Try(java.lang.Double.parseDouble(value)) match {
      case Success(double) if !double.isInfinite && !double.isNaN => Some(ExprTree.DoubleLit(value))
      case _                                                      => None
    }

    def other =
      ExprTree.Ref(TypeRef(QualifiedName.Double).withComments(Comments(s"/* $value */ ")))

    validInt.orElse(validDouble).getOrElse(other)
  }

  def numberToTypeRef(value: String): TypeRef = {
    def validInt = Try(java.lang.Long.decode(value)) match {
      case Success(int) if int < Int.MaxValue && int > Int.MinValue => Some(TypeRef.IntLiteral(value))
      case _                                                        => None
    }

    def validDouble = Try(java.lang.Double.parseDouble(value)) match {
      case Success(double) if !double.isInfinite && !double.isNaN => Some(TypeRef.DoubleLiteral(value))
      case _                                                      => None
    }

    def notExpressible =
      TypeRef(QualifiedName.Double).withComments(Comments(s"/* $value */ "))

    validInt.orElse(validDouble).getOrElse(notExpressible)
  }

  def stringToExpr(value: String, shouldWiden: ShouldWiden): ExprTree = {
    val lit = ExprTree.StringLit(value)
    if (shouldWiden(value))
      ExprTree.Ref(TypeRef.String.withComments(Comments(List(Comment(s"/* $value */ "), Marker.WasLiteral(lit)))))
    else lit
  }

  def stringToTypeRef(value: String, shouldWiden: ShouldWiden): TypeRef = {
    val lit = ExprTree.StringLit(value)
    if (shouldWiden(value))
      TypeRef.String.withComments(Comments(List(Comment(s"/* $value */ "), Marker.WasLiteral(lit))))
    else TypeRef.StringLiteral(value)
  }

  trait ShouldWiden {
    def apply(str: String): Boolean
  }

  object ShouldWiden {
    val No:  ShouldWiden = _ => false
    val Yes: ShouldWiden = _ => true

    // it's hard to say when keeping it as a literal is beneficial.
    // we sometimes widen because we may bump into max class length for the generated literal traits
    val Some: ShouldWiden = value => {
      val hasSpecialChar = value.exists(Set('\'', '(', ')', '\\'))
      val long           = value.length > 60
      hasSpecialChar || long

    }
  }
}
