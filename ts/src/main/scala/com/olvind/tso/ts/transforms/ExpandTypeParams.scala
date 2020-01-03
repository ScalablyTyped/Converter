package com.olvind.tso
package ts
package transforms

import com.olvind.tso.ts.TsTreeScope.LoopDetector
import seqs._

/*
 * This implements the `keyof` and type lookup mechanisms from typescript in a limited context, and brings us a bit closer
 * to being able to enable type bounds in scala.
 *
 *
```typescript
interface C {
  c?: number
}

interface B {
  b: string;
}
interface A extends B {
  a: number;
}
interface Example {
    expandKeyOf<K extends keyof A>(key: K, foo: A[K]): number
    expandUnion<T extends C | B>(bc: T): T
}```

After conversion we'll end up with
```scala
@js.native
trait Example extends js.Object {
  @JSName("expandKeyOf")
  def expandKeyOf_a(key: expandDashTypeDashParametersLib.expandDashTypeDashParametersLibStrings.a, foo: scala.Double): scala.Double = js.native
  @JSName("expandKeyOf")
  def expandKeyOf_b(
    key: expandDashTypeDashParametersLib.expandDashTypeDashParametersLibStrings.b,
    foo: java.lang.String
  ): scala.Double = js.native
  def expandUnion(bc: B): B = js.native
  def expandUnion(bc: C): C = js.native
}
```
 */
object ExpandTypeParams extends TransformMembers with TransformClassMembers {

  override def newClassMembers(scope: TsTreeScope, x: HasClassMembers): Seq[TsMember] =
    x.members.flatMap {
      case m @ TsMemberCall(_, _, sig) =>
        expandTParams(scope / m, sig) match {
          case None => Seq(m)
          case Some(nonEmpty) =>
            scope.logger.info(s"Expanding ${nonEmpty.size} call members")
            RemoveComment.keepFirstOnly(nonEmpty.map(newSig => m.copy(signature = newSig)))
        }

      case m @ TsMemberFunction(_, _, name, sig, _, _, _) =>
        expandTParams(scope / m, sig) match {
          case None => Seq(m)
          case Some(nonEmpty) =>
            scope.logger.info(s"Expanding ${nonEmpty.size} members for $name")
            RemoveComment.keepFirstOnly(nonEmpty.map(newSig => m.copy(signature = newSig)))
        }

      case other => Seq(other)
    }

  override def newMembers(scope: TsTreeScope, x: TsContainer): Seq[TsContainerOrDecl] =
    x.members flatMap {
      case m @ TsDeclFunction(_, _, name, sig, _, _) =>
        expandTParams(scope / m, sig) match {
          case None => Seq(m)
          case Some(nonEmpty) =>
            scope.logger.info(s"Expanding ${nonEmpty.size} members for $name")
            RemoveComment.keepFirstOnly(nonEmpty.map(newSig => m.copy(signature = newSig)))
        }

      case other => Seq(other)
    }

  def expandTParams(scope: TsTreeScope, sig: TsFunSig): Option[Seq[TsFunSig]] = {
    val expandables = sig.tparams.flatMap(expandable(scope, sig))
    val expanded = expandables
      .foldLeft(List(sig)) {
        case (currentSigs, exp) => currentSigs.flatMap(expandSignature(scope, exp))
      }

    expanded.length match {
      case n if n === 0 || n > 200 => None
      case _                       => Some(expanded)
    }
  }

  def expandable(scope: TsTreeScope, sig: TsFunSig)(tp: TsTypeParam): Option[ExpandableTypeParam] = {
    def flatPick(tpe: TsType): Seq[TsType] =
      FollowAliases(scope)(tpe) match {
        case TsTypeUnion(types) => types.flatMap(flatPick)
        case other              => List(other)
      }

    lazy val isParam = sig.params.exists(p =>
      p.tpe.exists {
        case TsTypeRef(_, TsQIdent(Seq(tp.name)), _) => true
        case _                                       => false
      },
    )

    tp.upperBound flatMap { bound =>
      flatPick(bound).partitionCollect2(KeyOf, TypeRef(scope)) match {
        case (Distinct(keyOfs), Distinct(typeRefs), Distinct(keepInBounds))
            if keyOfs.nonEmpty || (typeRefs.size > 1 && isParam) =>
          Some(ExpandableTypeParam(tp.name, keepInBounds.nonEmptyOpt, keyOfs ++ typeRefs))
        case _ => None
      }
    }
  }

  object Distinct {
    def unapply[T](ts: Seq[T]): Some[Seq[T]] = Some(ts.distinct)
  }

  final case class ExpandableTypeParam(
      typeParam:      TsIdent,
      toKeepInBounds: Option[Seq[TsType]],
      toExpand:       Seq[Either[TsTypeRef, TsTypeKeyOf]],
  )

  val KeyOf: PartialFunction[TsType, Right[TsTypeRef, TsTypeKeyOf]] = {
    case x @ TsTypeKeyOf(_: TsTypeRef) => Right(x)
  }

  val isAny = Set[TsType](TsTypeRef.any, TsTypeRef.`object`)

  def TypeRef(scope: TsTreeScope): PartialFunction[TsType, Left[TsTypeRef, TsTypeKeyOf]] = {
    case tr: TsTypeRef if tr.tparams.forall(x => !isAny(x)) && !isAny(tr) && !scope.isAbstract(tr.name) => Left(tr)
  }

  def expandSignature(scope: TsTreeScope, exp: ExpandableTypeParam)(sig: TsFunSig): Seq[TsFunSig] = {

    val keptInBounds: Option[TsFunSig] =
      exp.toKeepInBounds.map { types =>
        val rewrittenTparams = sig.tparams.map {
          case tparam @ TsTypeParam(_, exp.typeParam, _, _) =>
            tparam.copy(upperBound = Some(TsTypeUnion(types)))
          case other => other
        }

        sig.copy(tparams = rewrittenTparams)
      }

    val sigCleaned = sig.copy(tparams = sig.tparams.filterNot(tp => exp.typeParam === tp.name))

    val expanded = exp.toExpand.flatMap {
      case Left(tr) =>
        val rewrites = Map[TsType, TsType](
          TsTypeRef.of(exp.typeParam) -> clearCircularRef(exp.typeParam, tr),
        )

        List(new TypeRewriter(sigCleaned).visitTsFunSig(rewrites)(sigCleaned))

      case Right(TsTypeKeyOf(ref: TsTypeRef)) =>
        val members = AllMembersFor(scope, LoopDetector.initial)(ref)

        members.collect {
          case TsMemberProperty(_, _, TsIdentSimple(n), Some(tpe), _, false, _, _) =>
            val rewrites = Map[TsType, TsType](
              TsTypeRef.of(exp.typeParam) -> TsTypeLiteral(TsLiteralString(n)),
              TsTypeLookup(ref, TsTypeLiteral(TsLiteralString(n))) -> tpe,
            )

            new TypeRewriter(sigCleaned).visitTsFunSig(rewrites)(sigCleaned)
        }

      case Right(other) =>
        /* enforced in `ExpandableTypes` but not proved */
        sys.error(s"Unexpected: $other")

    }

    expanded ++ keptInBounds
  }

  /**
    * Since we inline the `T` also erase references to it
    * ```typescript
    * <T extends (Array<T> | number)>(t: T): T`
    */
  def clearCircularRef(self: TsIdent, tr: TsTypeRef): TsTypeRef =
    new TypeRewriter(tr).visitTsTypeRef(Map(TsTypeRef.of(self) -> TsTypeRef.any))(tr)
}
