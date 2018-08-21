package com.olvind.tso
package ts
package transforms

/**
  * trait A
  * trait B1 extends A
  * trait B2 extends A
  *
  * trait F[T <: A]
  * type T = F[B1 | B2]
  *
  * Scala.js' userland union type cannot understand that `B1 | B2` fulfills the type bound.
  *
  * We translate `T` to `type T = F[A with (B1 | B2)]` to give the scala compiler a clue
  */
object BoundsAddAtUseSite extends TreeVisitorScopedChanges {
  def notRepresentableInScala(providedTparams: Seq[TsType], t: TreeScope): Boolean =
    providedTparams.exists {
      case x: TsTypeRef =>
        t.lookupTypeIncludeScope(x.name).exists {
          case (xx: TsDeclTypeAlias, tt) if xx.alias =/= x =>
            notRepresentableInScala(Seq(xx.alias), tt)
          case _ => false
        }
      case _: TsTypeUnion  => true
      case _: TsTypeObject => true
      case _: TsTypeLookup => true
      case _ => false
    }

  override def enterTsTypeRef(t: TreeScope)(x: TsTypeRef): TsTypeRef =
    x match {
      case TsTypeRef(target, providedTparams: Seq[TsType]) if notRepresentableInScala(providedTparams, t) =>
        val expectedTparamsOpt: Option[Seq[TsTypeParam]] =
          t lookup target collectFirst {
            case HasTParams(tparams) => tparams
          }

        expectedTparamsOpt match {
          case Some(expectedTparams) =>
            if (expectedTparams.forall(_.upperBound.isEmpty)) {
              x
            } else {
              val tuples: Seq[(TsTypeParam, TsType)] =
                expectedTparams zip providedTparams

              val rewrites: Map[TsType, TsType] = tuples.map {
                case (TsTypeParam(_, name, _, _), applied) => TsTypeRef(TsQIdent(List(name)), Nil) -> applied
              }.toMap

              val newTparams: Seq[TsType] =
                tuples map {
                  case (TsTypeParam(_, _, Some(bound: TsTypeRef), _), provided: TsType) if provided =/= bound =>
                    TsTypeIntersect.simplified(Seq(new TypeRewriter(bound).visitTsType(rewrites)(bound), provided))
                  case (_, other) => other
                }

              t.logger.info(s"Adding type bound for ${target.parts.map(_.value).mkString(".")} at $t")

              x.copy(tparams = newTparams)
            }

          case None =>
            t.logger.fatalMaybe(s"Did not find type $target in $t", constants.Pedantic)
            x
        }
      case other => other
    }
}
