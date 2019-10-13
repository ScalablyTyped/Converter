package com.olvind.tso
package ts
package transforms

import com.olvind.tso.ts.TsTreeScope.LoopDetector
import com.olvind.tso.ts.modules.{DeriveCopy, ReplaceExports}
import com.olvind.tso.seqs._

object ResolveTypeQueries extends TransformLeaveMembers with TransformLeaveClassMembers {
  def newClassMembersLeaving(scope: TsTreeScope, tree: HasClassMembers): Seq[TsMember] =
    tree.members.flatMap {
      case target @ TsMemberProperty(
            cs,
            level,
            name,
            Some(tpe @ TsTypeQuery(wanted)),
            None,
            isStatic,
            isReadOnly,
            isOptional,
          ) if !TsQIdent.Primitive(wanted) =>
        val founds = scope
          .lookupBase(Picker.NamedValues, wanted)
          .map {
            case (found: TsDeclVar, _) =>
              target.copy(comments = cs ++ found.comments, tpe = found.tpe)
            case (found: TsDeclFunction, _) =>
              TsMemberFunction(cs ++ found.comments, level, name, found.signature, isStatic, isReadOnly, isOptional)
            case (found, newScope) =>
              target.copy(tpe = typeOf(found, newScope, LoopDetector.initial))
          }

        founds match {
          case Nil =>
            val msg = s"Couldn't resolve ${TsTypeFormatter(tpe)}"
            scope.logger.warn(msg)
            List(target.copy(tpe = Some(TsTypeRef.any.copy(comments = Comments(Comment.warning(msg))))))
          case more =>
            scope.logger.info(s"Resolved $target")
            more
        }
      case other => List(other)
    }

  def newMembers(scope: TsTreeScope, tree: TsContainer): Seq[TsContainerOrDecl] =
    tree.members.flatMap {
      case target @ TsDeclVar(_, _, _, name, Some(tpe @ TsTypeQuery(expr)), None, _, _, false)
          if !TsQIdent.Primitive(expr) =>
        lazy val ownerLoc = tree match {
          case x: HasJsLocation => x.jsLocation
          case _ => JsLocation.Zero
        }

        val founds = scope
          .lookupBase(Picker.NamedValues, expr)
          .flatMap {
            case (found, _) =>
              DeriveCopy(found, tree.codePath, Some(name)).map { SetJsLocation.visitTsNamedDecl(ownerLoc) }
          }

        founds match {
          case Nil =>
            val msg = s"Couldn't resolve ${TsTypeFormatter(tpe)}"
            scope.logger.warn(msg)
            List(target.copy(tpe = Some(TsTypeRef.any.copy(comments = Comments(Comment.warning(msg))))))
          case more =>
            scope.logger.info(s"Resolved $target")
            more
        }

      case other => List(other)
    }

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
                TsTypeParam.asTypeArgs(cls.tparams),
              ),
            ),
          ),
        ),
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
                    .copy(comments = Comments(Comment.warning(s"was tparam ${tp.name.value}"))),
              )
              .toMap,
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
            case Nil => Some((cls, ctor))
            case some =>
              val nameHint = Comments(CommentData(Markers.NameHint(s"TypeofClass${cls.name.value}")))
              Some(
                (
                  cls,
                  TsTypeObject(
                    nameHint,
                    some :+ TsMemberCtor(NoComments, ProtectionLevel.Default, ctor.signature.signature),
                  ),
                ),
              )
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
        nonEmptyTypeObject(newNs)
      case mod: TsDeclModule =>
        val newMod = new ReplaceExports(LoopDetector.initial).visitTsDeclModule(scope.`..`)(mod)
        nonEmptyTypeObject(newMod)

      case TsDeclVar(_, _, _, _, tpe, _, _, _, _) =>
        tpe map {
          case nested: TsTypeQuery =>
            resolve(scope, nested, loopDetector)
          case other =>
            other
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
                    val overloads =
                      TsTypeObject(
                        NoComments,
                        fns.map(fn => TsMemberCall(NoComments, ProtectionLevel.Default, fn.signature)),
                      )
                    overloads +: rest
                }
                scope.logger.info(s"Resolved $target")
                TsTypeIntersect.simplified(rewritten)
            }
        }

    }

  private def nonEmptyTypeObject(from: TsDeclNamespaceOrModule): Option[TsTypeObject] = {
    val rewritten = from.members collect {
      case ns: TsDeclNamespace =>
        TsMemberProperty(
          ns.comments,
          ProtectionLevel.Default,
          ns.name,
          nonEmptyTypeObject(ns),
          None,
          isStatic   = false,
          isReadOnly = true,
          isOptional = false,
        )
      case TsDeclFunction(cs, _, name, sig, _, _) =>
        TsMemberFunction(
          cs,
          ProtectionLevel.Default,
          name,
          sig,
          isStatic   = false,
          isReadOnly = true,
          isOptional = false,
        )
      case TsDeclVar(cs, _, isReadOnly, name, tpe, lit, _, _, isOptional) =>
        TsMemberProperty(
          cs,
          ProtectionLevel.Default,
          name,
          tpe,
          lit,
          isStatic   = false,
          isReadOnly = isReadOnly,
          isOptional = isOptional,
        )
      case RewrittenClass((cls, tpe)) =>
        TsMemberProperty(
          cls.comments,
          ProtectionLevel.Default,
          cls.name,
          Some(tpe),
          None,
          isStatic   = false,
          isReadOnly = false,
          isOptional = false,
        )
    }
    if (rewritten.isEmpty) None
    else {
      val namehint = from match {
        case TsDeclNamespace(_, _, name, _, _, _) => s"Typeof${name.value}"
        case TsDeclModule(_, _, name, _, _, _)    => s"Typeof${name.value}"
        case TsAugmentedModule(name, _, _, _)     => s"Typeof${name.value}"
      }
      Some(TsTypeObject(Comments(CommentData(Markers.NameHint(namehint))), rewritten))
    }
  }
}
