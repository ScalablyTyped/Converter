package com.olvind.tso
package importer

import com.olvind.tso.scalajs._
import com.olvind.tso.seqs.TraversableOps
import com.olvind.tso.ts._

object TsImporterTypes {
  def orAny(wildcards: Wildcards, scope: TreeScope)(ott: Option[TsType]): TypeRef =
    ott map apply(wildcards, scope) getOrElse TypeRef.Any

  def apply(wildcards: Wildcards, scope: TreeScope)(t1: TsType): TypeRef =
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
            TypeRef(AsName(other), targs map apply(wildcards.maybeAllow, scope), NoComments)
        }

      case TsTypeObject(Nil) =>
        TypeRef(QualifiedName.Object, Nil, NoComments)

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
        TypeRef.Function(newSig.params map funParam(wildcards, scope),
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

  private def funParam(wildcards: Wildcards, scope: TreeScope)(param: TsFunParam): TypeRef =
    orAny(wildcards, scope)(param.tpe) withOptional param.isOptional withComments Comments(
      s"/* ${param.name.value} */ "
    )
}
