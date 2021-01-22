package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector
import org.scalablytyped.converter.internal.ts.modules.{DeriveCopy, ReplaceExports}

import scala.collection.mutable

object ResolveTypeQueries extends TransformMembers with TransformLeaveClassMembers {
  val GlobalThis = TsQIdent.of("globalThis")

  override def newClassMembersLeaving(scope: TsTreeScope, tree: HasClassMembers): IArray[TsMember] =
    tree.members.flatMap {
      case target @ TsMemberProperty(
            cs,
            level,
            name,
            Some(tpe @ TsTypeQuery(wanted)),
            None,
            isStatic,
            isReadOnly,
          ) if !TsQIdent.Primitive(wanted) =>
        val note = Comment(s"/* was `${TsTypeFormatter(tpe)}` */\n")

        val founds = lookup(scope, Picker.NamedValues, wanted)
          .map {
            case (found: TsDeclVar, _) =>
              target.copy(comments = cs ++ found.comments + note, tpe = found.tpe)
            case (found: TsDeclFunction, _) =>
              TsMemberFunction(
                cs ++ found.comments + note,
                level,
                name,
                MethodType.Normal,
                found.signature,
                isStatic,
                isReadOnly,
              )
            case (found, newScope) =>
              target.copy(tpe = typeOf(found, newScope, LoopDetector.initial), comments = target.comments + note)
          }

        founds match {
          case Empty =>
            val msg = s"Couldn't resolve ${TsTypeFormatter(tpe)}"
            scope.logger.warn(msg)
            IArray(target.copy(tpe = Some(TsTypeRef.any.copy(comments = Comments(Comment.warning(msg))))))
          case nonEmpty => nonEmpty
        }
      case other => IArray(other)
    }

  override def newMembers(scope: TsTreeScope, tree: TsContainer): IArray[TsContainerOrDecl] = {
    lazy val avoidCircular: Set[CodePath] =
      scope.stack.collect { case x: HasCodePath => x.codePath }.toSet

    val addedClasses = mutable.Set.empty[TsIdentSimple]

    val rewritten = tree.members.flatMap {
      case target @ TsDeclVar(_, _, _, name, Some(tpe @ TsTypeQuery(expr)), None, _, _) if !TsQIdent.Primitive(expr) =>
        val note = Comment(s"/* was `${TsTypeFormatter(tpe)}` */\n")

        lazy val ownerLoc = tree match {
          case x: HasJsLocation => x.jsLocation
          case _ => JsLocation.Zero
        }

        val founds = lookup(scope, Picker.NamedValues, expr).flatMap {
          case (circular, _) if avoidCircular(circular.codePath) => Empty
          case (found, _) =>
            DeriveCopy(found.addComment(note), tree.codePath, Some(name)).map {
              SetJsLocation.visitTsNamedDecl(ownerLoc)
            }
        }

        founds.foreach {
          case x: TsDeclClass =>
            addedClasses += x.name
          case _ => ()
        }

        founds match {
          case Empty =>
            val msg = s"Couldn't resolve ${TsTypeFormatter(tpe)}"
            scope.logger.warn(msg)
            IArray(target.copy(tpe = Some(TsTypeRef.any.copy(comments = Comments(Comment.warning(msg))))))
          case nonEmpty => nonEmpty
        }

      case other => IArray(other)
    }
    /* Account for this pattern
    ```typescript
    type A = Foo
    var A: typeof Foo
    ```
     */
    if (addedClasses.isEmpty) rewritten
    else {
      rewritten.filter {
        case x: TsDeclTypeAlias => !addedClasses(x.name)
        case _ => true
      }
    }
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
    def asTypeCtor(cls: TsDeclClass, cs: Comments, params: IArray[TsFunParam]) =
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
        case _cls: TsDeclClass if !_cls.comments.has[Markers.ExpandedClass.type] =>
          val cls = new TypeRewriter(_cls).visitTsDeclClass(
            _cls.tparams
              .map(tp =>
                TsTypeRef(tp.name) -> TsTypeRef.any
                  .copy(comments = Comments(Comment.warning(s"was tparam ${tp.name.value}"))),
              )
              .toMap,
          )(_cls)

          val existingCtorOpt: Option[TsTypeConstructor] =
            cls.members.collectFirst {
              case TsMemberCtor(cs, _, sig) => asTypeCtor(cls, sig.comments ++ cs, sig.params)
              case TsMemberFunction(cs, _, TsIdent.constructor, MethodType.Normal, sig, _, _) =>
                asTypeCtor(cls, sig.comments ++ cs, sig.params)
            }

          val ctor: TsTypeConstructor =
            existingCtorOpt.getOrElse(asTypeCtor(cls, NoComments, Empty))

          val statics = cls.members.collect {
            case x: TsMemberProperty if x.isStatic => x.copy(isStatic = false)
            case x: TsMemberFunction if x.isStatic => x.copy(isStatic = false)
          }

          statics match {
            case Empty => Some((cls, ctor))
            case some =>
              val nameHint = Comments(CommentData(Markers.NameHint(s"Typeof${cls.name.value}")))
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

      case TsDeclVar(_, _, _, _, tpe, _, _, _) =>
        tpe.map {
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
          case GlobalThis =>
            TsTypeRef.any.copy(comments = Comments(Comment("/* globalThis */ ")))

          case wanted if TsQIdent.Primitive(wanted) => TsTypeRef(NoComments, wanted, Empty)
          case wanted =>
            val found = lookup(scope, P(target), wanted).mapNotNone {
              case (x, newScope) => typeOf(x, newScope, loopDetector)
            }

            found match {
              case Empty =>
                lookup(scope, P(target), wanted)
                val msg = s"Couldn't resolve ${TsTypeFormatter(target)}"
                scope.logger.warn(msg)
                TsTypeRef.any.copy(comments = Comments(Comment.warning(msg)))
              case more =>
                val rewritten = more.partitionCollect[TsTypeFunction] { case x: TsTypeFunction => x } match {
                  case (Empty, all) =>
                    all
                  case (IArray.exactlyOne(one), rest) if one.signature.tparams.isEmpty && rest.length <= 1 =>
                    one +: rest
                  case (fns, rest) =>
                    val overloads =
                      TsTypeObject(
                        NoComments,
                        fns.map(fn => TsMemberCall(NoComments, ProtectionLevel.Default, fn.signature)),
                      )
                    overloads +: rest
                }
                TsTypeIntersect.simplified(rewritten)
            }
        }

    }

  private def nonEmptyTypeObject(from: TsDeclNamespaceOrModule): Option[TsTypeObject] = {
    val rewritten = from.members.collect {
      case ns: TsDeclNamespace =>
        TsMemberProperty(
          ns.comments,
          ProtectionLevel.Default,
          ns.name,
          nonEmptyTypeObject(ns),
          None,
          isStatic   = false,
          isReadOnly = true,
        )
      case TsDeclFunction(cs, _, name, sig, _, _) =>
        TsMemberFunction(
          cs,
          ProtectionLevel.Default,
          name,
          MethodType.Normal,
          sig,
          isStatic   = false,
          isReadOnly = true,
        )
      case TsDeclVar(cs, _, isReadOnly, name, tpe, lit, _, _) =>
        TsMemberProperty(
          cs,
          ProtectionLevel.Default,
          name,
          tpe,
          lit,
          isStatic   = false,
          isReadOnly = isReadOnly,
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
        )
    }
    if (rewritten.isEmpty) None
    else {
      val namehint = from match {
        case TsDeclNamespace(_, _, name, _, _, _) => s"Typeof${name.value}"
        case TsDeclModule(_, _, name, _, _, _)    => s"Typeof${name.value}"
        case TsAugmentedModule(_, name, _, _, _)  => s"Typeof${name.value}"
      }
      Some(TsTypeObject(Comments(CommentData(Markers.NameHint(namehint))), rewritten))
    }
  }

  /* handle that the value we're looking for might have been moved into the `global` object */
  def lookup[T <: TsNamedDecl](scope: TsTreeScope, picker: Picker[T], wanted: TsQIdent): IArray[(T, TsTreeScope)] = {
    val all = scope.lookupInternal(picker, wanted.parts, LoopDetector.initial) match {
      case Empty =>
        val patchedWanted = wanted.parts match {
          case IArray.headTail(lib: TsIdentLibrary, rest) => IArray(lib, TsIdent.Global) ++ rest
          case unqualified => TsIdent.Global +: unqualified
        }

        scope.lookupInternal(picker, patchedWanted, LoopDetector.initial)
      case ok => ok
    }

    all.partitionCollect2(
      { case x @ (_: TsDeclVar, _)      => x },
      { case x @ (_: TsDeclFunction, _) => x },
    ) match {
      case (vs, _, _) if vs.nonEmpty => vs
      case (_, fs, _) if fs.nonEmpty => fs
      case (_, _, rest)              => rest
    }
  }
}
