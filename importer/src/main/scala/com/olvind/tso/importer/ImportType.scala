package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts._

object ImportType {
  def orAny(wildcards: Wildcards, scope: TreeScope)(ott: Option[TsType]): TypeRef =
    ott map apply(wildcards, scope) getOrElse TypeRef.Any

  def apply(wildcards: Wildcards, _scope: TreeScope)(t1: TsType): TypeRef = {
    val scope = _scope / t1
    t1 match {
      case TsTypeRef(base: TsQIdent, targs: Seq[TsType]) =>
        base match {
          case TsQIdent.any       => if (wildcards.allowed) TypeRef.Ignored else TypeRef.Any
          case TsQIdent.void      => TypeRef.Unit
          case TsQIdent.number    => TypeRef.Double
          case TsQIdent.bool      => TypeRef.Boolean
          case TsQIdent.boolean   => TypeRef.Boolean
          case TsQIdent.Boolean   => TypeRef.Boolean
          case TsQIdent.string    => TypeRef.String
          case TsQIdent.String    => TypeRef.String
          case TsQIdent.symbol    => TypeRef.Symbol
          case TsQIdent.`null`    => TypeRef.Null
          case TsQIdent.never     => TypeRef.Nothing
          case TsQIdent.`object`  => TypeRef.Object
          case TsQIdent.Object    => TypeRef.Object
          case TsQIdent.undefined => TypeRef.UndefOr(TypeRef.Nothing)
          case TsQIdent.Array =>
            TypeRef(QualifiedName.Array, targs map apply(wildcards.maybeAllow, scope), NoComments)
          case TsQIdent.Function =>
            TypeRef(QualifiedName.Function, targs map apply(wildcards.maybeAllow, scope), NoComments)
          case other =>
            TypeRef(ImportName(other), targs map apply(wildcards.maybeAllow, scope), NoComments)
        }

      case TsTypeObject(Nil) =>
        TypeRef(QualifiedName.Object, Nil, NoComments)

      /* Proper handling (of static) cases will be done in `ApplyTypeMapping`.
       * This piece of code just ignores the effect of the type mapping.
       *
       * It is crucial that it belong here in the importer, since it needs to be exported
       *  in it's original form to dependant libraries
       */
      case TsTypeObject(Seq(TsMemberTypeMapped(_, _, _, _, _, _, to))) =>
        val lookups: Seq[TsTypeRef] =
          TreeTraverse.collect(to) { case TsTypeLookup(from: TsTypeRef, _) => from }

        val base = lookups.headOption match {
          case None      => TypeRef.Any
          case Some(one) => apply(wildcards, scope)(one)
        }

        scope.stack collectFirst {
          case x: TsNamedDecl => TypeRef.Intersection(Seq(TypeRef.Literal(stringUtils.quote(x.name.value)), base))
        } getOrElse base

      case TsTypeObject(Seq(TsMemberIndex(cs, _, _, IndexingDict(_, TsTypeRef.string), isOptional, valueType))) =>
        TypeRef.StringDictionary(apply(wildcards, scope)(valueType).withOptional(isOptional), cs)

      case TsTypeObject(Seq(TsMemberIndex(cs, _, _, IndexingDict(_, TsTypeRef.number), isOptional, valueType))) =>
        TypeRef.NumberDictionary(apply(wildcards, scope)(valueType).withOptional(isOptional), cs)

      case TsTypeFunction(sig) =>
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
            case first :: tail if first.name === TsIdent.`this` => (Some(funParam(wildcards, scope)(first)), tail)
            case all                                            =>
//              val inferredThis = scope.stack match {
//                case _ :: (_: TsMemberProperty | _: TsMemberCall) :: (_: TsDeclClass | _: TsDeclInterface) :: _ => true
//                case _ => false
//              }
//              if (inferredThis) (Some(TypeRef.ThisType(NoComments)), all) else
              (None, all)
          }

        TypeRef.Function(thisType,
                         restParams map funParam(wildcards, scope),
                         orAny(wildcards.maybeAllow, scope)(newSig.resultType),
                         newSig.comments)

      case TsTypeUnion(types) =>
        types.partitionCollect { case TsTypeRef.undefined => } match {
          case (Nil, ts)     => TypeRef.Union(ts map apply(wildcards, scope))
          case (_, Seq(one)) => TypeRef.UndefOr(apply(wildcards.maybeAllow, scope)(one))
          case (_, ts)       => TypeRef.UndefOr(TypeRef.Union(ts map apply(wildcards, scope)))
        }

      case TsTypeIntersect(types) =>
        TypeRef.Intersection(types map apply(Wildcards.No, scope))

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

  private def funParam(wildcards: Wildcards, scope: TreeScope)(param: TsFunParam): TypeRef =
    orAny(wildcards, scope / param)(param.tpe) withOptional param.isOptional withComments Comments(
      s"/* ${param.name.value} */ "
    )
}
