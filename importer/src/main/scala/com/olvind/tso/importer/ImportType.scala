package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts._

object ImportType {
  def orAny(wildcards: Wildcards, scope: TreeScope)(ott: Option[TsType]): TypeRef =
    ott map apply(wildcards, scope) getOrElse TypeRef.Any

  def orLitOrAny(wildcards: Wildcards, scope: TreeScope)(ott: Option[TsType], ol: Option[TsLiteral]): TypeRef =
    (ott, ol) match {
      case (Some(x), _) => apply(wildcards, scope)(x)
      case (None, Some(lit)) =>
        val (c, tpe) = TsLiteral.typeOf(lit)
        apply(wildcards, scope)(tpe).withComments(Comments(c))
      case _ => TypeRef.Any
    }

  sealed trait Mapping
  case class Ref(isInheritance:      TypeRef, normal:       TypeRef) extends Mapping
  case class OnlyName(isInheritance: QualifiedName, normal: QualifiedName) extends Mapping

  /**
    * The point here? Dont inherit from sealed classes in scala.js, but otherwise
    * prefer types from there. Handle resolved and unresolved qidents
    */
  private val Mappings = {
    val ArrayM = OnlyName(QualifiedName.Std.Array, QualifiedName.Array)
    val BooleanM = Ref(TypeRef(QualifiedName.Std.Boolean), TypeRef.Boolean)
    val FunctionM = Ref(TypeRef.FunctionBase, TypeRef.FunctionBase)
    val ObjectM = Ref(TypeRef(QualifiedName.Std.Object), TypeRef.Object)
    val StringM = Ref(TypeRef(QualifiedName.Std.String), TypeRef.String)

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
  )}

  def isInheritance(tpe: TsQIdent, scope: TreeScope): Boolean =
    scope.stack match {
      case _ :: (owner: TsDeclInterface) :: _ =>
        owner.inheritance.exists(_.name eq tpe)
      case _ :: (owner: TsDeclClass) :: _ =>
        owner.implements.exists(_.name eq tpe) || owner.parent.exists(_.name eq tpe)
      case _ => false
    }

  def apply(wildcards: Wildcards, _scope: TreeScope)(t1: TsType): TypeRef = {
    val scope = _scope / t1
    t1 match {
      case TsTypeRef(base: TsQIdent, targs: Seq[TsType]) =>
        base match {
          case TsQIdent.any => if (wildcards.allowed) TypeRef.Wildcard else TypeRef.Any

          case other =>
            lazy val parent = isInheritance(other, scope)
            lazy val targs2 = targs map apply(wildcards.maybeAllow, scope)

            Mappings.get(other) match {
              case Some(Ref(tr, _)) if parent         => tr
              case Some(Ref(_, tr))                   => tr
              case Some(OnlyName(qname, _)) if parent => TypeRef(qname, targs2, NoComments)
              case Some(OnlyName(_, qname))           => TypeRef(qname, targs2, NoComments)
              case None                               => TypeRef(ImportName(other), targs2, NoComments)
            }
        }

      case TsTypeObject(Nil) =>
        TypeRef(QualifiedName.Object, Nil, NoComments)

      /* Proper handling (of static) cases will be done in `ApplyTypeMapping`.
       * This piece of code just ignores the effect of the type mapping.
       *
       * It is crucial that this "logic" live here in the importer, since it needs to be exported
       *  in it's original form to dependencies
       */
      case TsTypeObject(Seq(TsMemberTypeMapped(_, _, _, _, _, _, to))) =>
        val lookups: Seq[TsTypeRef] =
          TreeTraverse.collect(to) { case TsTypeLookup(from: TsTypeRef, _) => from }

        val base = lookups.headOption match {
          case None      => TypeRef.Any
          case Some(one) => apply(wildcards, scope)(one)
        }

        scope.stack collectFirst {
          case x: TsDeclTypeAlias if x.name === TsIdent.Record =>
            TypeRef.StringDictionary(TypeRef(ImportName(x.tparams.head.name)), NoComments)
          case x: TsNamedDecl => TypeRef.Intersection(Seq(TypeRef.Literal(stringUtils.quote(x.name.value)), base))
        } getOrElse base

      case TsTypeObject(Seq(TsMemberIndex(cs, _, _, IndexingDict(_, TsTypeRef.string), isOptional, valueType))) =>
        TypeRef.StringDictionary(apply(wildcards, scope)(valueType).withOptional(isOptional), cs)

      case TsTypeObject(Seq(TsMemberIndex(cs, _, _, IndexingDict(_, TsTypeRef.number), isOptional, valueType))) =>
        TypeRef.NumberDictionary(apply(wildcards, scope)(valueType).withOptional(isOptional), cs)

      case TsTypeFunction(sig) =>
        if (sig.tparams.size > 22) TypeRef.FunctionBase
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
                (Some(funParam(wildcards, scope)(first)), tail)
              case all =>
                (None, all)
            }

          TypeRef.Function(thisType,
                           restParams map funParam(wildcards, scope),
                           orAny(wildcards.maybeAllow, scope)(newSig.resultType),
                           newSig.comments)
        }
      case TsTypeUnion(types) =>
        types.partitionCollect { case TsTypeRef.undefined => } match {
          case (Nil, ts)     => TypeRef.Union(ts map apply(wildcards, scope))
          case (_, Seq(one)) => TypeRef.UndefOr(apply(wildcards.maybeAllow, scope)(one))
          case (_, ts)       => TypeRef.UndefOr(TypeRef.Union(ts map apply(wildcards, scope)))
        }

      case TsTypeIntersect(types) =>
        TypeRef.Intersection(types map apply(Wildcards.No, scope))

      case TsTypeConstructor(TsTypeFunction(sig)) =>
        signature(scope, sig, NoComments)

      case TsTypeKeyOf(_) =>
        TypeRef.String

      case TsTypeTuple(targs) =>
        TypeRef.Tuple(targs map apply(wildcards.maybeAllow, scope))

      case TsTypeRepeated(underlying) =>
        TypeRef.Repeated(apply(wildcards, scope)(underlying), NoComments)

      case TsTypeIs(_, tpe) =>
        tpe match {
          case ref: TsTypeRef =>
            TypeRef.Boolean.withComments(Comments(s"/* is ${ref.name.parts.last.value} */"))
          case _ =>
            TypeRef.Boolean
        }

      case TsTypeLiteral(lit) =>
        TypeRef.Literal(lit.literal)

      case TsTypeThis() =>
        TypeRef.ThisType(NoComments)

      case other =>
        val msg =
          s"Failed type conversion: ${other.toString.replaceAll("Vector\\(", "List(")}"
        scope.logger.info(msg)
        TypeRef(QualifiedName.Any, Nil, Comments(Comment.warning(msg)))
    }
  }

  def signature(scope: TreeScope.Scoped, _sig: TsFunSig, comments: Comments): TypeRef = {
    /* get rid of type parameters and fill them with bound / object */
    val targs = _sig.tparams.map(p => p.upperBound getOrElse TsTypeRef.`object`)
    val sig   = ts.FillInTParams(_sig, targs)

    val params: Seq[TypeRef] =
      sig.params.map { param =>
        val (baseType, isRepeated) = param.tpe match {
          case Some(TsTypeRepeated(repeated)) => (Some(repeated), true)
          case other                          => (other, false)
        }

        val comment = Comment(s"/* ${param.name.value}${if (isRepeated) " (repeated)" else ""} */ ")

        ImportType
          .orAny(Wildcards.Prohibit, scope)(baseType)
          .withComments(Comments(comment))
          .withOptional(param.isOptional)
      }

    val ret: TypeRef =
      ImportType.orAny(Wildcards.Prohibit, scope)(sig.resultType)

    TypeRef(
      QualifiedName.Instantiable(sig.params.length),
      params :+ ret,
      comments
    )
  }

  private def funParam(wildcards: Wildcards, scope: TreeScope)(param: TsFunParam): TypeRef =
    orAny(wildcards, scope / param)(param.tpe) withOptional param.isOptional withComments Comments(
      s"/* ${param.name.value} */ "
    )
}
