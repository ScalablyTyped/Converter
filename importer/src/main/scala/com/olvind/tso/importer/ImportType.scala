package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts._
import com.olvind.tso.ts.transforms.ExtractInterfaces

object ImportType {

  def orAny(wildcards: Wildcards, scope: TsTreeScope, importName: ImportName)(ott: Option[TsType]): TypeRef =
    ott map apply(wildcards, scope, importName) getOrElse TypeRef.Any

  def orExprOrAny(wildcards: Wildcards, scope: TsTreeScope, importName: ImportName)(ott: Option[TsType]): TypeRef =
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
    val ArrayM    = OnlyName(QualifiedName.Std.Array, QualifiedName.Array)
    val BooleanM  = Ref(TypeRef(QualifiedName.Std.Boolean), TypeRef.Boolean)
    val FunctionM = Ref(TypeRef.FunctionBase, TypeRef.FunctionBase)
    val ObjectM   = Ref(TypeRef(QualifiedName.Std.Object), TypeRef.Object)
    val StringM   = Ref(TypeRef(QualifiedName.Std.String), TypeRef.String)

    Map[TsQIdent, Mapping](
      TsQIdent.Array -> ArrayM,
      TsQIdent.bigint -> Ref(TypeRef(QualifiedName.Std.BigInt), TypeRef(QualifiedName.Std.BigInt)),
      TsQIdent.boolean -> BooleanM,
      TsQIdent.Boolean -> BooleanM,
      TsQIdent.Function -> FunctionM,
      TsQIdent.never -> Ref(TypeRef.Any, TypeRef.Nothing),
      TsQIdent.`null` -> Ref(TypeRef.Any, TypeRef.Null),
      TsQIdent.number -> Ref(TypeRef(QualifiedName.Std.Number), TypeRef.Double),
      TsQIdent.`object` -> ObjectM,
      TsQIdent.Object -> ObjectM,
      TsQIdent.Std.Array -> ArrayM,
      TsQIdent.Std.Boolean -> BooleanM,
      TsQIdent.Std.ConcatArray -> OnlyName(QualifiedName.Std.ConcatArray, QualifiedName.Array),
      TsQIdent.Std.Function -> FunctionM,
      TsQIdent.Std.Object -> ObjectM,
      TsQIdent.Std.PromiseLike -> OnlyName(QualifiedName.Std.PromiseLike, QualifiedName.Thenable),
      TsQIdent.Std.Promise -> OnlyName(QualifiedName.Std.Promise, QualifiedName.Promise),
      TsQIdent.Std.ReadonlyArray -> OnlyName(QualifiedName.Std.ReadonlyArray, QualifiedName.Array),
      TsQIdent.Std.String -> StringM,
      TsQIdent.string -> StringM,
      TsQIdent.String -> StringM,
      TsQIdent.symbol -> Ref(TypeRef(QualifiedName.Std.Symbol), TypeRef.Symbol),
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

  def apply(wildcards: Wildcards, _scope: TsTreeScope, importName: ImportName)(t1: TsType): TypeRef = {
    val scope = _scope / t1
    t1 match {
      case TsTypeRef(cs, base: TsQIdent, targs: Seq[TsType]) =>
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

      case TsTypeObject(_, Nil) =>
        TypeRef(QualifiedName.Object, Nil, NoComments)

      /* Proper handling (of static) cases will be done in `ApplyTypeMapping`.
       * This piece of code just ignores the effect of the type mapping.
       *
       * It is crucial that this "logic" live here in the importer, since it needs to be exported
       *  in it's original form to dependencies
       */
      case tpe @ TsTypeObject(_, Seq(TsMemberTypeMapped(_, _, _, _, _, _, to))) =>
        val lookups: Seq[TsTypeRef] =
          TreeTraverse.collect(to) { case TsTypeLookup(from: TsTypeRef, _) => from }

        val base = lookups match {
          case Seq(one) => apply(wildcards, scope, importName)(one)
          case _        => TypeRef.Any
        }

        def c = Comments(Comment.warning(s"Unsupported type mapping: \n${TsTypeFormatter(tpe)}\n"))

        scope.stack collectFirst {
          case x: TsDeclTypeAlias if x.name === TsIdent.Record =>
            TypeRef.StringDictionary(TypeRef(importName(x.tparams.head.name)), NoComments)
          case x: TsNamedDecl =>
            TypeRef.Intersection(Seq(TypeRef.Literal(stringUtils.quote(x.name.value)), base)).withComments(c)
        } getOrElse base.withComments(c)

      case TsTypeObject(_, ms) if ExtractInterfaces.isDictionary(ms) =>
        val (strings, numbers, Nil) = ms.partitionCollect2(
          { case x @ TsMemberIndex(_, _, _, IndexingDict(_, TsTypeRef.string), _, _) => x },
          { case x @ TsMemberIndex(_, _, _, IndexingDict(_, TsTypeRef.number), _, _) => x },
        )

        val translatedStrings = strings.map {
          case TsMemberIndex(cs, _, _, IndexingDict(_, TsTypeRef.string), isOptional, valueType) =>
            (cs, orAny(wildcards, scope, importName)(valueType).withOptional(isOptional))
        }
        val stringDict = translatedStrings.toList match {
          case Nil => None
          case some =>
            Some(
              TypeRef
                .StringDictionary(TypeRef.Intersection(some.map(_._2)), Comments.flatten(some.map(_._1))(identity)),
            )
        }
        val translatedNumbers = numbers.map {
          case TsMemberIndex(cs, _, _, IndexingDict(_, TsTypeRef.number), isOptional, valueType) =>
            (cs, orAny(wildcards, scope, importName)(valueType).withOptional(isOptional))
        }
        val numberDict = translatedNumbers.toList match {
          case Nil => None
          case some =>
            Some(
              TypeRef
                .NumberDictionary(TypeRef.Intersection(some.map(_._2)), Comments.flatten(some.map(_._1))(identity)),
            )
        }
        TypeRef.Intersection(stringDict.toList ++ numberDict)

      case TsTypeFunction(sig) =>
        if (sig.params.size > 22) TypeRef.FunctionBase
        else {
          def recursiveBound(name: TsIdent, b: TsType): Boolean =
            TreeTraverse.collect(b) { case `name` => name }.nonEmpty

          val defaulted = sig.tparams.map { tp =>
            tp.upperBound match {
              case Some(b) if !recursiveBound(tp.name, b) => b
              case _                                      => TsTypeRef.any
            }
          }

          val newSig = ts.FillInTParams(sig, defaulted)

          val (thisType, restParams) =
            newSig.params.to[List] match {
              case first :: tail if first.name === TsIdent.`this` =>
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
              case TsTypeLiteral(TsLiteralString("true" | "false")) => ()
              case TsTypeLiteral(TsLiteralBoolean(true | false))    => ()
            } match {
              case (_, rest) => rest
            }
          }

        TypeRef.Union(patched map apply(wildcards, scope, importName), sort = false)

      case TsTypeIntersect(types) =>
        TypeRef.Intersection(types map apply(Wildcards.No, scope, importName))

      case TsTypeConstructor(TsTypeFunction(sig)) =>
        newableFunction(scope, importName, sig, NoComments)

      case TsTypeKeyOf(_) =>
        TypeRef.String

      case TsTypeTuple(StrippedRepeat(targs)) =>
        TypeRef(
          QualifiedName.Array,
          List(TypeRef.Union(targs map apply(wildcards.maybeAllow, scope, importName), false)),
          NoComments,
        )

      case TsTypeTuple(targs) =>
        TypeRef.Tuple(targs map apply(wildcards.maybeAllow, scope, importName))

      case TsTypeRepeated(underlying) =>
        TypeRef.Repeated(apply(wildcards, scope, importName)(underlying), NoComments)

      case TsTypeIs(_, tpe) =>
        tpe match {
          case ref: TsTypeRef =>
            TypeRef.Boolean.withComments(Comments(s"/* is ${TsTypeFormatter(ref)} */"))
          case _ =>
            TypeRef.Boolean
        }

      case TsTypeLiteral(lit) =>
        TypeRef.Literal(lit.literal)

      case TsTypeThis() =>
        TypeRef.ThisType(NoComments)

      case x: TsTypeConditional =>
        apply(wildcards, _scope, importName)(unify(List(x.ifFalse, x.ifTrue)))

      case other =>
        val msg = s"Failed type conversion: ${TsTypeFormatter(other)}"
        scope.logger.info(msg)
        TypeRef(QualifiedName.Any, Nil, Comments(Comment.warning(msg)))
    }
  }

  private val toIgnore = Set[TsType](TsTypeRef.never, TsTypeRef.any, TsTypeRef.`object`)

  /**
    * TsTypeUnion.simplified simplifies a set of types into a union types, a normal type, or `never`.
    *    The latter is the least useful, so let's rewrite it to any
    */
  def unify(types: Seq[TsType]): TsType =
    TsTypeUnion.simplified(types filterNot toIgnore) match {
      case TsTypeRef.never => TsTypeRef.any
      case other           => other
    }

  def newableFunction(
      scope:      TsTreeScope.Scoped,
      importName: ImportName,
      _sig:       TsFunSig,
      comments:   Comments,
  ): TypeRef = {
    /* get rid of type parameters and fill them with bound / object */
    val targs = _sig.tparams.map(p => p.upperBound getOrElse TsTypeRef.`object`)
    val sig   = ts.FillInTParams(_sig, targs)

    val params: Seq[TypeRef] =
      sig.params.map { param =>
        val (baseType, isRepeated) = param.tpe match {
          case Some(TsTypeRepeated(repeated)) => (Some(repeated), true)
          case other                          => (other, false)
        }

        val comment = Comment(s"/* ${param.name.value}${if (isRepeated) " (repeated)" else ""} */")

        ImportType
          .orAny(Wildcards.Prohibit, scope, importName)(baseType)
          .withComments(Comments(comment))
          .withOptional(param.isOptional)
      }

    val ret: TypeRef =
      ImportType.orAny(Wildcards.Prohibit, scope, importName)(sig.resultType)

    TypeRef(
      QualifiedName.Instantiable(sig.params.length),
      params :+ ret,
      comments,
    )
  }

  private def funParam(wildcards: Wildcards, scope: TsTreeScope, importName: ImportName)(param: TsFunParam): TypeRef =
    orAny(wildcards, scope / param, importName)(param.tpe) withOptional param.isOptional withComments Comments(
      s"/* ${param.name.value} */",
    )

  private object StrippedRepeat {
    def unapply(types: Seq[TsType]): Option[Seq[TsType]] = {
      var found = false
      val ret = types.map {
        case TsTypeRepeated(x) =>
          found = true
          x
        case other => other
      }
      if (found) Some(ret) else None
    }
  }
}
