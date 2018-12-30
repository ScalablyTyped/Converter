package com.olvind.tso
package ts
package transforms

import com.olvind.tso.ts.TsTreeScope.LoopDetector
import com.olvind.tso.seqs._

object ResolveTypeQueries extends TreeTransformationScopedChanges {
  override def leaveTsType(t: TsTreeScope)(x: TsType): TsType =
    x match {
      case xx: TsTypeQuery => resolve(t, xx, new LoopDetector())
      case other => other
    }

  object RewrittenClass {
    private def fromSignature(cls: TsDeclClass, cs: Comments, sig: TsFunSig) =
      TsTypeConstructor(
        TsTypeFunction(
          sig.copy(
            comments = sig.comments ++ cs,
            tparams  = cls.tparams ++ sig.tparams,
            resultType = Some(
              TsTypeRef(
                NoComments,
                cls.codePath.forceHasPath.codePath,
                TsTypeParam.asTypeArgs(cls.tparams ++ sig.tparams)
              )
            )
          )
        )
      )

    def unapply(decl: TsContainerOrDecl): Option[(TsDeclClass, TsTypeConstructor)] =
      decl match {
        case cls: TsDeclClass =>
          val existingCtorOpt: Option[(TsDeclClass, TsTypeConstructor)] =
            cls.members collectFirst {
              case TsMemberCtor(cs, _, sig) =>
                (cls, fromSignature(cls, cs, sig))

              case TsMemberFunction(cs, _, TsIdent.constructor, sig, _, _, _) =>
                (cls, fromSignature(cls, cs, sig))
            }

          existingCtorOpt orElse Some(
            (cls,
             TsTypeConstructor(
               TsTypeFunction(
                 TsFunSig(NoComments, Nil, Nil, Some(TsTypeRef(NoComments, cls.codePath.forceHasPath.codePath, Nil)))
               )
             ))
          )
        case _ => None
      }
  }

  def typeOf(x: TsNamedDecl, scope: TsTreeScope, loopDetector: LoopDetector): Option[TsType] =
    x match {
      case TsDeclFunction(_, _, _, sig, _, _)      => Some(TsTypeFunction(sig))
      case RewrittenClass((_, typeConstructor))    => Some(typeConstructor)
      case TsDeclNamespace(_, _, _, members, _, _) => nonEmptyTypeObject(members)
      case TsDeclModule(_, _, _, members, _, _)    => nonEmptyTypeObject(members)
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
              .lookupBase(QualifyReferences.P(target), wanted)
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
      case RewrittenClass((cls, typeConstructor)) =>
        TsMemberProperty(cls.comments,
                         Default,
                         cls.name,
                         Some(typeConstructor),
                         None,
                         isStatic   = false,
                         isReadOnly = false,
                         isOptional = false)
    }
    if (rewritten.isEmpty) None else Some(TsTypeObject(rewritten))

  }
}
