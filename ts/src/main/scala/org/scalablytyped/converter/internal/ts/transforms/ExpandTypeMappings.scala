package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector

object ExpandTypeMappings extends TreeTransformationScopedChanges {

  object After extends TreeTransformationScopedChanges {

    private object Unqualify extends TreeTransformationUnit {
      override def enterTsQIdent(t: Unit)(x: TsQIdent): TsQIdent =
        x.copy(parts = IArray(x.parts.last))
    }

    override def enterTsType(scope: TsTreeScope)(x: TsType): TsType = {
      lazy val nameHint = TsTypeFormatter.dropComments(Unqualify.visitTsType(())(x)).filter(_.isLetterOrDigit)

      def repeated =
        scope.stack.exists {
          case TsTypeObject(Comments(cs), _) =>
            cs.exists {
              case CommentData(Markers.NameHint(`nameHint`)) => true
              case _                                         => false
            }
          case _ => false
        }

      def refersAbstract =
        TsTreeTraverse
          .collect(x) {
            case TsTypeRef(_, name @ TsQIdent(IArray.exactlyOne(_)), Empty) if scope.isAbstract(name) => name
          }
          .nonEmpty

      def tooDeep = {
        val numTypeObjects = scope.stack.count {
          case TsTypeObject(_, _) => true;
          case _                  => false
        }
        numTypeObjects > 2
      }

      if (repeated || refersAbstract || tooDeep) return x

      AllMembersFor.forType(scope, LoopDetector.initial)(x) match {
        case Problems(_) =>
          x

        case Ok(newMembers, true) =>
          val nameHint = TsTypeFormatter.dropComments(Unqualify.visitTsType(())(x)).filter(_.isLetterOrDigit)

          val notices = Comments(
            List(
              Comment("/* Inlined " + TsTypeFormatter(x) + " */\n"),
              CommentData(Markers.NameHint(nameHint)),
            ),
          )
          TsTypeObject(notices, newMembers)
        case _ => x
      }
    }
  }

  override def enterTsDecl(scope: TsTreeScope)(x: TsDecl): TsDecl =
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
          if !comments.has[Markers.IsTrivial.type] && !pointsToConcreteType(scope, alias) =>
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
          TaggedLiteral(TsLiteralString(name.value))(isOptional = true)
        case x: TsMemberProperty => TaggedLiteral(TsLiteralString(x.name.value))(isOptional = false)
        case x: TsMemberFunction => TaggedLiteral(TsLiteralString(x.name.value))(isOptional = false)
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
    * This is obviously not much of an implementation, just enough to get @material-ui/core running
    */
  def evaluatePredicate(x: TsType): Res[Boolean] =
    x match {
      case TsTypeExtends(_, TsTypeRef.any) => Ok(true, wasRewritten = false)
      case other                           => Problems(IArray(UnsupportedPredicate(other)))
    }

  object AllMembersFor {
    def forType(scope: TsTreeScope, ld: LoopDetector)(tpe: TsType): Res[IArray[TsMember]] =
      tpe match {
        case x: TsTypeRef => apply(scope, ld)(x)
        case x: TsTypeIntersect =>
          val base = Res.sequence(x.types.map(forType(scope, ld))).map(_.flatten)

          if (x.types.exists(_.isInstanceOf[TsTypeObject])) base.withIsRewritten
          else base
        case IsTypeMapping(TsMemberTypeMapped(_, _, _, _, from: TsTypeRef, _, _)) if scope.isAbstract(from.name) =>
          Problems(IArray(NotStatic(scope, from)))

        case IsTypeMapping(TsMemberTypeMapped(_, level, readOnly, keyRef, from, optionalize, to)) =>
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
        // Exclude
//        case TsTypeConditional(TsTypeExtends(t, u), TsTypeRef.never, t2) if t === t2 =>
//          for {
//            kt <- evaluateKeys(scope, loopDetector)(t)
//            ku <- evaluateKeys(scope, loopDetector)(u)
//            keys = kt -- ku
//            tmembers <- AllMembersFor.forType(scope, loopDetector)(t)
//            picked <- Res.ofOpt(extract(tmembers, keys), wasRewritten = true, CouldNotPickKeys(scope, keys))
//          } yield picked
//        // Extract
//        case TsTypeConditional(TsTypeExtends(t, u), t2, TsTypeRef.never) if t === t2 =>
//          val foo = for {
//            kt <- evaluateKeys(scope, loopDetector)(t)
//            ku <- evaluateKeys(scope, loopDetector)(u)
//            keys = kt.intersect(ku)
//            tmembers <- AllMembersFor.forType(scope, loopDetector)(t)
//            picked <- Res.ofOpt(extract(tmembers, keys), wasRewritten = true, CouldNotPickKeys(scope, keys))
//          } yield picked
//          foo
        case TsTypeConditional(pred, ifTrue, ifFalse) =>
          for {
            conforms <- evaluatePredicate(pred)
            ret <- forType(scope, ld)(if (conforms) ifTrue else ifFalse)
          } yield ret

        case x: TsTypeExtends     => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeInfer       => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeLiteral     => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeFunction    => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeConstructor => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeIs          => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeTuple       => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeQuery       => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeRepeated    => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeKeyOf       => Problems(IArray(InvalidType(scope, x)))
        case x: TsTypeLookup      => Problems(IArray(InvalidType(scope, x)))
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

          val res = scope.lookupInternal(Picker.Types, typeRef.name.parts, ld).collectFirst {
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
