package com.olvind.tso
package ts
package transforms

import com.olvind.tso.ts.TsTreeScope.LoopDetector
import com.olvind.tso.ts.modules.ReplaceExports
import com.olvind.tso.seqs._

object ResolveTypeQueries extends TreeTransformationScopedChanges {
  override def leaveTsType(t: TsTreeScope)(x: TsType): TsType =
    x match {
      case xx: TsTypeQuery => resolve(t, xx, LoopDetector.initial)
      case other => other
    }

  private case class P(x: TsTypeQuery) extends Picker[TsNamedValueDecl] {
    override def unapply(t: TsNamedDecl): Option[TsNamedValueDecl] =
      t match {
        case v: TsDeclVar        => if (v.tpe.exists(_ eq x)) None else Some(v)
        case x: TsNamedValueDecl => Some(x)
        case _ => None
      }
  }

  object RewrittenClass {
    def asTypeCtor(cls: TsDeclClass, cs: Comments, params: Seq[TsFunParam]) =
      TsTypeConstructor(
        TsTypeFunction(
          TsFunSig(
            comments = cs,
            params   = params,
            tparams  = cls.tparams,
            resultType = Some(
              TsTypeRef(
                NoComments,
                cls.codePath.forceHasPath.codePath,
                TsTypeParam.asTypeArgs(cls.tparams)
              )
            )
          )
        )
      )

    def unapply(decl: TsContainerOrDecl): Option[(TsDeclClass, TsType)] =
      decl match {
        case _cls: TsDeclClass =>
          /**
            * todo: this is only necessary until we adopt answering these type queries as classes
            */
          val cls = new TypeRewriter(_cls).visitTsDeclClass(
            _cls.tparams
              .map(
                tp =>
                  TsTypeRef.of(tp.name) -> TsTypeRef.any
                    .copy(comments = Comments(Comment.warning(s"was tparam ${tp.name.value}")))
              )
              .toMap
          )(_cls)

          val existingCtorOpt: Option[TsTypeConstructor] =
            cls.members collectFirst {
              case TsMemberCtor(cs, _, sig) => asTypeCtor(cls, sig.comments ++ cs, sig.params)
              case TsMemberFunction(cs, _, TsIdent.constructor, sig, _, _, _) =>
                asTypeCtor(cls, sig.comments ++ cs, sig.params)
            }

          val ctor: TsTypeConstructor =
            existingCtorOpt getOrElse asTypeCtor(cls, NoComments, Nil)

          val statics = cls.members collect {
            case x: TsMemberProperty if x.isStatic => x.copy(isStatic = false)
            case x: TsMemberFunction if x.isStatic => x.copy(isStatic = false)
          }

          statics match {
            case Nil  => Some((cls, ctor))
            case some => Some((cls, TsTypeObject(some :+ TsMemberCtor(NoComments, Default, ctor.signature.signature))))
          }

        case _ => None
      }
  }

  def typeOf(x: TsNamedDecl, scope: TsTreeScope, loopDetector: LoopDetector): Option[TsType] =
    x match {
      case TsDeclFunction(_, _, _, sig, _, _)   => Some(TsTypeFunction(sig))
      case RewrittenClass((_, typeConstructor)) => Some(typeConstructor)
      case ns: TsDeclNamespace =>
        val newNs = new ReplaceExports(LoopDetector.initial).visitTsDeclNamespace(scope.`..`)(ns)
        nonEmptyTypeObject(newNs.members)
      case mod: TsDeclModule =>
        val newMod = new ReplaceExports(LoopDetector.initial).visitTsDeclModule(scope.`..`)(mod)
        nonEmptyTypeObject(newMod.members)

      case TsDeclVar(_, _, _, _, tpe, literal, _, _, _) =>
        tpe match {
          case Some(nested: TsTypeQuery) =>
            Some(resolve(scope, nested, loopDetector))
          case Some(other) =>
            Some(other)
          case None =>
            literal map TsTypeLiteral
        }
      case _ => None
    }

  private def resolve(scope: TsTreeScope, target: TsTypeQuery, _loopDetector: LoopDetector): TsType =
    _loopDetector.including(target.expr.parts, scope) match {
      case Left(()) =>
        val msg = s"Loop while resolving ${TsTypeFormatter(target)}"
        scope.logger.warn(msg)
        TsTypeRef.any.copy(comments = Comments(Comment.warning(msg)))

      case Right(loopDetector) =>
        target.expr match {
          case wanted if TsQIdent.Primitive(wanted) => TsTypeRef(NoComments, wanted, Nil)
          case wanted =>
            val found = scope
              .lookupBase(P(target), wanted)
              .flatMap { case (x, newScope) => typeOf(x, newScope, loopDetector) }

            found match {
              case Nil =>
                scope.lookupBase(Picker.All, wanted)
                val msg = s"Couldn't resolve ${TsTypeFormatter(target)}"
                scope.logger.warn(msg)
                TsTypeRef.any.copy(comments = Comments(Comment.warning(msg)))
              case more =>
                val rewritten = more.partitionCollect { case x: TsTypeFunction => x } match {
                  case (Nil, all) =>
                    all
                  case (Seq(one), rest) if one.signature.tparams.isEmpty && rest.size <= 1 =>
                    one +: rest
                  case (fns, rest) =>
                    val overloads = TsTypeObject(fns.map(fn => TsMemberCall(NoComments, Default, fn.signature)))
                    overloads +: rest
                }
                scope.logger.info(s"Resolved $target")
                TsTypeIntersect.simplified(rewritten)
            }
        }

    }

  private def nonEmptyTypeObject(members: Seq[TsContainerOrDecl]): Option[TsTypeObject] = {
    val rewritten = members collect {
      case ns: TsDeclNamespace =>
        TsMemberProperty(
          ns.comments,
          Default,
          ns.name,
          nonEmptyTypeObject(ns.members),
          None,
          isStatic   = false,
          isReadOnly = true,
          isOptional = false
        )
      case TsDeclFunction(cs, _, name, sig, _, _) =>
        TsMemberFunction(cs, Default, name, sig, isStatic = false, isReadOnly = true, isOptional = false)
      case TsDeclVar(cs, _, isReadOnly, name, tpe, lit, _, _, isOptional) =>
        TsMemberProperty(cs,
                         Default,
                         name,
                         tpe,
                         lit,
                         isStatic   = false,
                         isReadOnly = isReadOnly,
                         isOptional = isOptional)
      case RewrittenClass((cls, tpe)) =>
        TsMemberProperty(cls.comments,
                         Default,
                         cls.name,
                         Some(tpe),
                         None,
                         isStatic   = false,
                         isReadOnly = false,
                         isOptional = false)
    }
    if (rewritten.isEmpty) None else Some(TsTypeObject(rewritten))
  }
}
