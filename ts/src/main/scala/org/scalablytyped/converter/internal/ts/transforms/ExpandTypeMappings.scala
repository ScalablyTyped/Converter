package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector

object ExpandTypeMappings extends TreeTransformationScopedChanges {
  private object Unqualify extends TreeTransformationUnit {
    override def enterTsQIdent(t: Unit)(x: TsQIdent): TsQIdent =
      x.copy(parts = IArray(x.parts.last))
    override def enterTsTypeObject(t: Unit)(x: TsTypeObject): TsTypeObject =
      x.copy(members = Empty)

    override def enterTsTypeTuple(t: Unit)(x: TsTypeTuple): TsTypeTuple =
      x.copy(elems = Empty)
  }

  /**
    * Inlines at the call site any of the support type mappings.
    *
    * @param typeStack avoid circular
    * @param beforeTransformation not thread safe. we store original types before rewrite for naming purposes
    */
  class After(typeStack: List[TsType] = Nil, private var beforeTransformation: List[TsType] = Nil)
      extends TreeTransformationScopedChanges {
    override def enterTsType(t: TsTreeScope)(x: TsType): TsType = {
      beforeTransformation = x :: beforeTransformation
      x
    }

    override def leaveTsType(scope: TsTreeScope)(x: TsType): TsType =
      try {
        val before = beforeTransformation.head
        beforeTransformation = beforeTransformation.tail

        lazy val nameHint =
          TsTypeFormatter.dropComments.useNameHint.apply(Unqualify.visitTsType(())(before))

        // optimization. it speeds things up a lot, but it's not really precise enough.
        def refersAbstract: Boolean =
          TsTreeTraverse
            .collect(x) {
              case TsTypeRef(_, name @ TsQIdent(IArray.exactlyOne(_)), Empty) if scope.isAbstract(name) => name
            }
            .nonEmpty

        if (refersAbstract || typeStack.contains(x)) return x

        AllMembersFor.forType(scope, LoopDetector.initial)(x) match {
          case Problems(_) =>
            x

          case Ok(newMembers, true) =>
            val notices = Comments(
              List(
                Comment("/* Inlined " + TsTypeFormatter.dropComments.useNameHint.apply(x) + " */\n"),
                Marker.NameHint(nameHint),
              ),
            )
            lazy val newAfter = new After(x :: typeStack, beforeTransformation)

            val recurseIntoMembers =
              newMembers.map(newAfter.visitTsMember(scope))

            TsTypeObject(notices, recurseIntoMembers)

          // this is here to support things like material-ui
          case Ok(allMembers, false) if typeStack.isEmpty =>
            lazy val newAfter = new After(x :: typeStack, beforeTransformation)

            val maybeFunction = allMembers.firstDefined {
              case TsMemberCall(_, _, sig) =>
                val newSig = newAfter.visitTsFunSig(scope)(sig)
                if (newSig == sig) None else Some(TsTypeFunction(newSig))
              case _ => None
            }

            maybeFunction.getOrElse(x)
          case _ => x
        }
      } catch {
        case _: StackOverflowError =>
          scope.logger.warn(s"SOE while expanding ${TsTypeFormatter(x)}")
          x // todo: all of `ExpandTypeMappings` should be much improvd
      }
  }

  override def enterTsDecl(scope: TsTreeScope)(x: TsDecl): TsDecl =
    try {
      x match {
        case i: TsDeclInterface =>
          AllMembersFor.forInterface(scope, LoopDetector.initial)(i) match {
            case Problems(_) =>
              i
            case Ok(newMembers, true) =>
              val notices = Comments(
                i.inheritance.map(i => Comment("/* Inlined parent " + TsTypeFormatter(i) + " */\n")).toList,
              )
              i.copy(
                comments    = i.comments ++ notices,
                members     = newMembers,
                inheritance = Empty,
              )
            case _ => x
          }

        case ta @ TsDeclTypeAlias(comments, declared, name, tparams, alias, codePath)
            if !comments.has[Marker.IsTrivial.type] && !pointsToConcreteType(scope, alias) =>
          AllMembersFor.forType(scope, LoopDetector.initial)(alias) match {
            case Problems(_) =>
              evaluateKeys(scope, LoopDetector.initial)(alias) match {
                case Ok(value, true) =>
                  val notice = Comment("/* Inlined " + TsTypeFormatter(alias) + " */\n")
                  ta.copy(
                    comments = comments + notice,
                    alias    = TsTypeUnion.simplified(IArray.fromTraversable(value).map(x => TsTypeLiteral(x.lit))),
                  )
                case Ok(_, false) =>
                  ta
                case Problems(_) =>
                  ta
              }
            case Ok(newMembers, true) =>
              val notice = Comment("/* Inlined " + TsTypeFormatter(alias) + " */\n")
              TsDeclInterface(comments + notice, declared, name, tparams, Empty, newMembers, codePath)
            case _ => x
          }

        case _ => x
      }
    } catch {
      case _: StackOverflowError =>
        scope.logger.warn(s"SOE while expanding ")
        x // todo: all of `ExpandTypeMappings` should be much improvd
    }

  val EmptySet = Set.empty[String]

  sealed trait Res[+T] {
    def isSuccess: Boolean =
      this match {
        case Ok(_, _)    => true
        case Problems(_) => false
      }

    def withIsRewritten(wasRewritten: Boolean): Res[T] =
      this match {
        case Ok(value, _) => Ok(value, wasRewritten)
        case p: Problems => p
      }

    def withIsRewritten: Res[T] =
      withIsRewritten(wasRewritten = true)

    def validated[U](pred: T => Either[Problem, U]): Res[U] =
      this match {
        case Ok(value, wasRewritten) =>
          pred(value) match {
            case Left(problem)   => Problems(IArray(problem))
            case Right(newValue) => Ok(newValue, wasRewritten)
          }
        case p: Problems => p
      }

    def map[U](f: T => U): Res[U] =
      this match {
        case Ok(value, wasRewritten) => Ok(f(value), wasRewritten)
        case x: Problems => x
      }

    def flatMap[U](f: T => Res[U]): Res[U] =
      this match {
        case Ok(value, wasRewritten) =>
          f(value) match {
            case Ok(newValue, newWasRewritten) => Ok(newValue, wasRewritten || newWasRewritten)
            case p: Problems => p
          }
        case x: Problems => x
      }
  }

  case class Ok[T](value:       T, wasRewritten: Boolean) extends Res[T]
  case class Problems(problems: IArray[Problem]) extends Res[Nothing]

  object Res {
    def ofOpt[T](ot: Option[T], wasRewritten: Boolean, p: Problem): Res[T] =
      ot match {
        case Some(t) => Ok(t, wasRewritten)
        case None =>
          Problems(IArray(p))
      }

    def sequence[T <: AnyRef](rs: IArray[Res[T]]): Res[IArray[T]] =
      rs.foldLeft[Res[IArray[T]]](Ok(Empty, wasRewritten = false)) {
        case (Ok(values, wasRewritten1), Ok(value, wasRewritten2)) =>
          Ok(values :+ value, wasRewritten1 || wasRewritten2)
        case (p: Problems, Ok(_, _)) =>
          p
        case (Ok(_, _), p: Problems) =>
          p
        case (Problems(one), Problems(two)) =>
          Problems(one ++ two)
      }
  }

  sealed trait Problem

  case class NotStatic(scope: TsTreeScope, ref: TsTypeRef) extends Problem

  case class InvalidType(scope: TsTreeScope, tpe: TsType) extends Problem

  case class PropsFailed(scope: TsTreeScope, tpe: TsType) extends Problem {}

  case class Loop(scope: TsTreeScope) extends Problem

  case class TypeNotFound(scope: TsTreeScope, ref: TsTypeRef) extends Problem

  case class NotKeysFromTarget(scope: TsTreeScope, ref: TsType) extends Problem

  case class NoMembers(scope: TsTreeScope, tm: TsMemberTypeMapped) extends Problem

  case class UnsupportedTM(scope:    TsTreeScope, tm: TsMemberTypeMapped) extends Problem
  case class CouldNotPickKeys(scope: TsTreeScope, keys: Set[String]) extends Problem
  case class UnsupportedPredicate(e: TsType) extends Problem

  final case class Replace(key: TsType, name: TsLiteral, ld: LoopDetector) extends TreeTransformationScopedChanges {
    override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
      x match {
        case `key` => TsTypeLiteral(name)
        case TsTypeLookup(from, `key`) =>
          val foundType: Option[TsType] =
            AllMembersFor.forType(scope / from, ld)(from) match {
              case Ok(members, _) =>
                members.collectFirst {
                  case TsMemberProperty(_, _, TsIdent(name.literal), tpeOpt, _, false, _) =>
                    tpeOpt.fold[TsType](TsTypeRef.any)(visitTsType(scope))
                  case TsMemberFunction(_, _, TsIdent(name.literal), _, signature, false, _) =>
                    visitTsType(scope)(TsTypeFunction(signature))
                }
              case Problems(ps) =>
                ps.foreach(p => scope.logger.info(s"Could not replace key $key = $name: $p"))
                None
            }

          foundType.getOrElse {
            scope.logger.info(s"Could not replace key $key = $name")
            OptionalType(TsTypeRef.any)
          }
        case other => other
      }
  }

  /* Typescript tracks optionality a bit behind the scenes, so this emulates the behaviour */
  case class TaggedLiteral(lit: TsLiteral)(val isOptional: Boolean)

  def evaluateKeys(scope: TsTreeScope, ld: LoopDetector)(keys: TsType): Res[Set[TaggedLiteral]] = {
    def keysFor(members: IArray[TsMember]): IArray[TaggedLiteral] =
      members.collect {
        case TsMemberProperty(_, _, name, Some(OptionalType(_)), _, _, _) =>
          TaggedLiteral(TsLiteral.Str(name.value))(isOptional = true)
        case x: TsMemberProperty => TaggedLiteral(TsLiteral.Str(x.name.value))(isOptional = false)
        case x: TsMemberFunction => TaggedLiteral(TsLiteral.Str(x.name.value))(isOptional = false)
      }

    val res: Res[Set[TaggedLiteral]] = FollowAliases(scope)(keys) match {
      case tr: TsTypeRef if scope.isAbstract(tr.name) => Problems(IArray(NotStatic(scope, tr)))
      case tr: TsTypeRef =>
        val res: Option[Res[Set[TaggedLiteral]]] =
          scope.lookupInternal(Picker.Types, tr.name.parts, LoopDetector.initial).collectFirst {
            case (x: TsDeclTypeAlias, _) =>
              evaluateKeys(scope, ld)(FillInTParams(x, tr.tparams).alias)
            case (x: TsDeclInterface, _) =>
              Ok(keysFor(FillInTParams(x, tr.tparams).members).toSet, wasRewritten = false)
            case (x: TsDeclEnum, _) if x.isConst =>
              val names = x.members.collect {
                case TsEnumMember(_, _, Some(TsExpr.Literal(lit))) => TaggedLiteral(lit)(isOptional = false)
              }
              Ok(names.toSet, wasRewritten = false)
          }

        res.getOrElse(Problems(IArray(TypeNotFound(scope, tr))))

      case TsTypeLiteral(literal) => Ok(Set(TaggedLiteral(literal)(isOptional = false)), wasRewritten = false)
      case TsTypeKeyOf(key) =>
        AllMembersFor.forType(scope, ld)(key).map(ms => keysFor(ms).toSet)
      case TsTypeObject(_, members) => Ok(keysFor(members).toSet, wasRewritten = false)
      case TsTypeUnion(types) =>
        Res
          .sequence(types.filterNot(_ === TsTypeRef.never).map(evaluateKeys(scope, ld)))
          .map(_.toSet.flatten)

      // Exclude
      case TsTypeConditional(TsTypeExtends(t, u), TsTypeRef.never, t2) if t === t2 =>
        val ret = for {
          kt <- evaluateKeys(scope, ld)(t)
          ku <- evaluateKeys(scope, ld)(u)
        } yield kt -- ku

        ret.withIsRewritten

      // Extract
      case TsTypeConditional(TsTypeExtends(t, u), t2, TsTypeRef.never) if t === t2 =>
        val ret = for {
          kt <- evaluateKeys(scope, ld)(t)
          ku <- evaluateKeys(scope, ld)(u)
        } yield kt.intersect(ku)

        ret.withIsRewritten

      case cond: TsTypeConditional =>
        evaluatePredicate(cond.pred).flatMap {
          case true  => evaluateKeys(scope, ld)(cond.ifTrue)
          case false => evaluateKeys(scope, ld)(cond.ifFalse)
        }

      case lookup: TsTypeLookup =>
        ResolveTypeLookups.expandLookupType(scope, lookup) match {
          case Some(keyType) => evaluateKeys(scope, ld)(keyType).withIsRewritten
          case None          => Problems(IArray(NotKeysFromTarget(scope, lookup)))
        }

      case x => Problems(IArray(NotKeysFromTarget(scope, x)))
    }
    res
  }

  /**
    * This is obviously not much of an implementation
    */
  def evaluatePredicate(x: TsType): Res[Boolean] =
    x match {
      case TsTypeExtends(_, TsTypeRef.any) =>
        Ok(true, wasRewritten = false)
      case TsTypeExtends(left: TsTypeLiteral, right: TsTypeLiteral) =>
        Ok(left == right, wasRewritten = false)
      case TsTypeExtends(left: TsTypeUnion, right: TsType) =>
        Ok(left.types.contains(right), wasRewritten = false)
      case other =>
        Problems(IArray(UnsupportedPredicate(other)))
    }

  object AllMembersFor {
    val reactMod                 = TsQIdent(IArray(TsIdentLibrary("react"), TsIdentModule(None, List("react"))))
    val ComponentProps           = reactMod + TsIdent("ComponentProps")
    val ComponentPropsWithRef    = reactMod + TsIdent("ComponentPropsWithRef")
    val ComponentPropsWithoutRef = reactMod + TsIdent("ComponentPropsWithoutRef")
    val intrinsicElement         = reactMod + TsIdent.Global + TsIdent("JSX") + TsIdent("IntrinsicElements")
    val NullUndefined            = TsTypeUnion(IArray(TsTypeRef.`null`, TsTypeRef.undefined))

    def forType(scope: TsTreeScope, ld: LoopDetector)(tpe: TsType): Res[IArray[TsMember]] =
      tpe match {
        case TsTypeRef(_, ComponentProps, IArray.first(ctor)) =>
          def resolveIntrinsic(literal: TsLiteral): Option[TsType] =
            scope.lookupInternal(Picker.All, intrinsicElement.parts, ld).firstDefined {
              case (i: TsDeclInterface, _) =>
                i.membersByName.get(TsIdentSimple(literal.literal)).flatMap { member =>
                  member.firstDefined {
                    case p: TsMemberProperty => p.tpe
                    case _ => None
                  }
                }
              case _ => None
            }

          def resolve(tpe: TsType): Res[TsType] =
            FollowAliases(scope)(tpe) match {
              case abs: TsTypeRef if scope.isAbstract(abs.name) =>
                Problems(IArray(NotStatic(scope, abs)))
              case tpe @ TsTypeLiteral(literal) =>
                resolveIntrinsic(literal) match {
                  case Some(found) => Ok(found, wasRewritten = false)
                  case None        => Problems(IArray(PropsFailed(scope, tpe)))
                }
              case TsTypeFunction(TsFunSig(_, _, IArray.first(TsFunParam(_, _, Some(propsType))), _)) =>
                Ok(propsType, wasRewritten = false)
              case TsTypeConstructor(
                  _,
                  TsTypeFunction(TsFunSig(_, _, IArray.first(TsFunParam(_, _, Some(propsType))), _)),
                  ) =>
                Ok(propsType, wasRewritten = false)
              case x: TsTypeLookup =>
                ResolveTypeLookups.expandLookupType(scope, x) match {
                  case Some(found) => resolve(found)
                  case None        => Problems(IArray(PropsFailed(scope, x)))
                }
              case cond: TsTypeConditional =>
                evaluatePredicate(cond.pred).flatMap {
                  case true  => resolve(cond.ifTrue)
                  case false => resolve(cond.ifFalse)
                }
              case other =>
                Problems(IArray(PropsFailed(scope, other)))
            }

          val propsRefOpt: Res[TsType] = resolve(ctor)

          propsRefOpt.flatMap(forType(scope, ld))

        case tr @ TsTypeRef(_, ComponentPropsWithRef, _) =>
          forType(scope, ld)(tr.copy(name = ComponentProps))
        case tr @ TsTypeRef(_, ComponentPropsWithoutRef, _) =>
          forType(scope, ld)(tr.copy(name = ComponentProps))

//        case TsTypeRef(_, TsQIdent.Std.Record, IArray.exactlyTwo(key, value)) =>
//          if (value == TsTypeRef.never) Ok(Empty, wasRewritten = true)
//          else
//            evaluateKeys(scope, ld)(key).map { keys =>
//              IArray.fromTraversable(keys).sortBy(_.lit.literal).map { lit =>
//                TsMemberProperty(
//                  NoComments,
//                  TsProtectionLevel.Default,
//                  TsIdentSimple(lit.lit.literal),
//                  Some(value),
//                  None,
//                  isStatic   = false,
//                  isReadOnly = false,
//                )
//              }
//            }.withIsRewritten
        case x: TsTypeRef => apply(scope, ld)(x)
        case x: TsTypeIntersect =>
          val base = Res.sequence(x.types.map(forType(scope, ld))).map(_.flatten)

          if (x.types.exists(_.isInstanceOf[TsTypeObject])) base.withIsRewritten
          else base
        case IsTypeMapping(TsMemberTypeMapped(_, _, _, _, from: TsTypeRef, _, _, _)) if scope.isAbstract(from.name) =>
          Problems(IArray(NotStatic(scope, from)))

        case IsTypeMapping(TsMemberTypeMapped(_, level, readOnly, keyRef, from, as, optionalize, to)) =>
          // todo: implement `as`
          evaluateKeys(scope, ld)(from).map { keys =>
            val all = IArray.fromTraversable(keys).map { key =>
              val to_        = if (key.isOptional) OptionalType(to) else to
              val replaced   = Replace(TsTypeRef(keyRef), key.lit, ld).visitTsType(scope)(to_)
              val memberType = ResolveTypeLookups.visitTsType(scope)(replaced)
              TsMemberProperty(
                comments   = NoComments,
                level      = level,
                name       = TsIdent(key.lit.literal),
                tpe        = Some(optionalize(memberType)),
                expr       = None,
                isStatic   = false,
                isReadOnly = readOnly(false), //todo!
              )
            }

            all.filter(
              _.tpe match {
                case Some(TsTypeRef.never)  => false
                case Some(TsTypeUnion(tps)) => !tps.contains(TsTypeRef.never)
                case _                      => true
              },
            )
          }.withIsRewritten
        case x: TsTypeObject => Ok(x.members, wasRewritten = false)

        case TsTypeConditional(pred, ifTrue, ifFalse) =>
          for {
            conforms <- evaluatePredicate(pred)
            ret <- forType(scope, ld)(if (conforms) ifTrue else ifFalse)
          } yield ret

        case x: TsTypeLookup =>
          ResolveTypeLookups.expandLookupType(scope, x) match {
            case Some(newType) => forType(scope, ld)(newType)
            case None          => Problems(IArray(InvalidType(scope, x)))
          }

        case x: TsTypeFunction =>
          Ok(IArray(TsMemberCall(NoComments, TsProtectionLevel.Default, x.signature)), wasRewritten = false)

        case x: TsTypeExtends     => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeInfer       => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeLiteral     => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeConstructor => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeIs          => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeTuple       => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeQuery       => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeRepeated    => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeKeyOf       => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeThis        => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeUnion       => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeAsserts     => Problems(IArray(InvalidType(scope, x)))
      }

    def extract(members: IArray[TsMember], wanted: Set[String]): Option[IArray[TsMember]] =
      members.collect {
        case x: TsMemberFunction if wanted(x.name.value) => x
        case x: TsMemberProperty if wanted(x.name.value) => x
      }.nonEmptyOpt

    def limitInlining[T <: AnyRef](scope: TsTreeScope, parent: TsTypeRef, res: Res[IArray[T]]): Res[IArray[T]] =
      res match {
        case res @ Ok(value, true) =>
          val allAbstract = parent.tparams.forall {
            case TsTypeRef(_, name, Empty) if scope.isAbstract(name) => true
            case _                                                   => false
          }
          if (allAbstract) Ok(value, wasRewritten = false) else res
        case res => res
      }

    def forInterface(newScope: TsTreeScope, ld: LoopDetector)(i: TsDeclInterface): Res[IArray[TsMember]] =
      Res
        .sequence(i.inheritance.map(p => limitInlining(newScope, p, AllMembersFor(newScope, ld)(p))))
        .map(fromParents => handleOverridingFields(i.members, fromParents))

    /* would want to do this for methods too, and in a more principled way. */
    def handleOverridingFields(fromThis: IArray[TsMember], fromParents: IArray[IArray[TsMember]]): IArray[TsMember] = {
      val thisFieldOverrides           = fromThis.collect { case x: TsMemberProperty => x.name }.toSet
      val (parentsFields, parentsRest) = fromParents.flatten.partitionCollect { case x: TsMemberProperty => x }

      fromThis ++ parentsFields.filterNot(x => thisFieldOverrides(x.name)) ++ parentsRest
    }

    def apply(scope: TsTreeScope, _ld: LoopDetector)(typeRef: TsTypeRef): Res[IArray[TsMember]] =
      _ld.including(typeRef, scope.root) match {
        case Left(()) =>
          Problems(IArray(Loop(scope)))
        case Right(ld) =>
          val enableCache = scope.root.cache.isDefined
          if (enableCache) {
            if (scope.root.cache.get.typeMappings.contains(typeRef)) {
              return scope.root.cache.get.typeMappings(typeRef)
            }
          }

          val res: Option[Res[IArray[TsMember]]] = {
            if (typeRef === TsTypeRef.`object`) Some(Ok(Empty, wasRewritten = false))
            // todo: need an ErrorType construct
            else if (typeRef === TsTypeRef.any && typeRef.comments.cs.isEmpty) Some(Ok(Empty, wasRewritten = false))
            else
              scope.lookupInternal(Picker.Types, typeRef.name.parts, ld).collectFirst {
                case (x: TsDeclInterface, newScope) =>
                  FillInTParams(x, typeRef.tparams) match {
                    case i: TsDeclInterface => forInterface(newScope, ld)(i)
                  }

                case (x: TsDeclClass, newScope) =>
                  FillInTParams(x, typeRef.tparams) match {
                    case TsDeclClass(_, _, _, _, _, parent, implements, members, _, _) =>
                      Res
                        .sequence((implements ++ IArray.fromOption(parent)).map(AllMembersFor(newScope, ld)))
                        .map(fromParents => handleOverridingFields(members, fromParents))
                  }

                case (x: TsDeclTypeAlias, _) =>
                  forType(scope, ld)(FillInTParams(x, typeRef.tparams).alias)
              }
          }

          val ret = res.getOrElse(Problems(IArray(TypeNotFound(scope, typeRef))))

          if (enableCache) {
            scope.root.cache.get.typeMappings.put(typeRef, ret)
          }

          ret
      }
  }

  def pointsToConcreteType(scope: TsTreeScope, alias: TsType): Boolean =
    alias match {
      case x: TsTypeRef =>
        scope.lookupType(x.name).exists {
          case _: TsDeclClass     => true
          case _: TsDeclInterface => true
          case _ => false
        }
      case _ => false
    }

  object IsTypeMapping {
    def unapply(tpe: TsType): Option[TsMemberTypeMapped] =
      tpe match {
        case TsTypeObject(_, IArray.exactlyOne(x: TsMemberTypeMapped)) => Some(x)
        case _ => None
      }
  }
}
