package org.scalablytyped.converter.internal
package ts
package transforms

import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector

object ExpandTypeMappings extends TreeTransformationScopedChanges {
  val Debug = false

  object After extends TreeTransformationScopedChanges {

    def apply(inLibrary: TsIdentLibrary, scope: TsTreeScope)(file: TsParsedFile): TsParsedFile = {
      val store = new ExtractInterfaces.ConflictHandlingStore(inLibrary)
      val V     = new V(store)
      val asd   = V.visitTsParsedFile(scope)(file)

      asd.copy(members = asd.members ++ IArray.fromTraversable(store.interfaces.values))
    }

    class V(store: ExtractInterfaces.ConflictHandlingStore) extends TreeTransformationScopedChanges {

      object Unqualify extends TreeTransformationUnit {
        override def enterTsQIdent(t: Unit)(x: TsQIdent): TsQIdent =
          x.copy(parts = IArray(x.parts.last))
      }

      override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
        AllMembersFor.forType(scope)(x) match {
          case Problems(problems) =>
            if (Debug) {
              AllMembersFor.forType(scope)(x)
              problems.foreach(p => scope.logger.warn(p.toString))
            }
            x

          case Ok(newMembers, true) =>
            val nameHint = TsTypeFormatter(Unqualify.visitTsType(())(x)).filter(_.isLetterOrDigit).take(50)

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
        AllMembersFor.forInterface(scope)(i) match {
          case Problems(problems) =>
            if (Debug) {
              AllMembersFor.forInterface(scope)(i)
              problems.foreach(p => scope.logger.warn(p.toString))
            }
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

      case TsDeclTypeAlias(comments, declared, name, tparams, alias, codePath)
          if !comments.has(Markers.IsTrivial) && !pointsToConcreteType(scope, alias) =>
        AllMembersFor.forType(scope)(alias) match {
          case Problems(problems) =>
            if (Debug) {
              AllMembersFor.forType(scope)(alias)
              problems.foreach(p => scope.logger.warn(p.toString))
            }
            x
          case Ok(newMembers, true) =>
            TsDeclInterface(
              comments + Comment("/* Inlined " + TsTypeFormatter(alias) + " */\n"),
              declared,
              name,
              tparams,
              Empty,
              newMembers,
              codePath,
            )
          case _ => x
        }
      case _ => x
    }

  val EmptySet = Set.empty[String]

  sealed trait Res[+T] {
    def withIsRewritten: Res[T] = this match {
      case Ok(value, _) => Ok(value, wasRewritten = true)
      case p: Problems => p
    }

    def validated[U](pred: T => Either[Problem, U]): Res[U] = this match {
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

  case class UnsupportedTM(scope:    TsTreeScope, tm:   TsMemberTypeMapped) extends Problem
  case class CouldNotPickKeys(scope: TsTreeScope, keys: Set[String]) extends Problem

  final case class Replace(key: TsType, name: String) extends TreeTransformationScopedChanges {
    override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
      x match {
        case `key` => TsTypeLiteral(TsLiteralString(name))
        case TsTypeLookup(from, `key`) =>
          val foundType: Option[TsType] =
            AllMembersFor.forType(scope)(from) match {
              case Ok(members, _) =>
                members collectFirst {
                  case TsMemberProperty(_, _, TsIdent(`name`), tpeOpt, _, false, _, isOptional) =>
                    ResolveTypeLookups.optional(
                      tpeOpt.fold[TsType](TsTypeRef.any)(visitTsType(scope)),
                      isOptional,
                    )
                  case TsMemberFunction(_, _, TsIdent(`name`), signature, false, _, isOptional) =>
                    ResolveTypeLookups.optional(
                      visitTsType(scope)(TsTypeFunction(signature)),
                      isOptional,
                    )
                }
              case Problems(ps) =>
                ps.foreach(p => scope.logger.info(s"Could not replace key $key = $name: $p"))
                None
            }

          foundType getOrElse {
            scope.logger.info(s"Could not replace key $key = $name")
            TsTypeRef.any
          }
        case other => other
      }
  }

  def evaluateKeys(scope: TsTreeScope)(keys: TsType): Res[Set[String]] = {
    def keysFor(members: IArray[TsMember]): IArray[String] =
      members collect {
        case x: TsMemberProperty => x.name.value
        case x: TsMemberFunction => x.name.value
      }

    val res = FollowAliases(scope)(keys) match {
      case tr: TsTypeRef if scope.isAbstract(tr.name) => Problems(IArray(NotStatic(scope, tr)))
      case tr: TsTypeRef =>
        val res = scope.lookupInternal(Picker.Types, tr.name.parts, LoopDetector.initial) collectFirst {
          case (x: TsDeclTypeAlias, _) =>
            evaluateKeys(scope)(FillInTParams(x, tr.tparams).alias)
          case (x: TsDeclInterface, _) =>
            val names = FillInTParams(x, tr.tparams).members.collect {
              case TsMemberProperty(_, _, name, _, _, _, _, _) => name.value
              case TsMemberFunction(_, _, name, _, _, _, _)    => name.value
            }
            Ok(names.toSet, wasRewritten = false)
          case (x: TsDeclEnum, _) if x.isConst =>
            val names = x.members.collect {
              case TsEnumMember(_, _, Some(TsExpr.Literal(lit))) => lit.literal
            }
            Ok(names.toSet, wasRewritten = false)
        }

        res.getOrElse(Problems(IArray(TypeNotFound(scope, tr))))

      case TsTypeLiteral(literal) => Ok(Set(literal.literal), wasRewritten = false)
      case TsTypeKeyOf(key) =>
        AllMembersFor.forType(scope)(key).map(ms => keysFor(ms).toSet)
      case TsTypeObject(_, members) => Ok(keysFor(members).toSet, wasRewritten = false)
      case TsTypeUnion(types) =>
        Res
          .sequence(types.filterNot(_ === TsTypeRef.never).map(evaluateKeys(scope)))
          .map(_.toSet.flatten)

      // Exclude
      case TsTypeConditional(TsTypeExtends(t, u), TsTypeRef.never, t2) if t === t2 =>
        for {
          kt <- evaluateKeys(scope)(t)
          ku <- evaluateKeys(scope)(u)
        } yield kt -- ku

      // Extract
      case TsTypeConditional(TsTypeExtends(t, u), t2, TsTypeRef.never) if t === t2 =>
        for {
          kt <- evaluateKeys(scope)(t)
          ku <- evaluateKeys(scope)(u)
        } yield kt.intersect(ku)
      case x => Problems(IArray(NotKeysFromTarget(scope, x)))
    }
    res
  }

  /**
    * This is obviously not much of an implementation, just enough to get @material-ui/core running
    */
  def evaluatePredicate(x: TsType): Boolean =
    x match {
      case TsTypeExtends(_, extended) =>
        if (extended === TsTypeRef.any) true
        else false
      case _ => false
    }

  object AllMembersFor {
    def forType(scope: TsTreeScope)(tpe: TsType): Res[IArray[TsMember]] =
      tpe match {
        case x: TsTypeRef => apply(scope)(x)
        case x: TsTypeIntersect =>
          Res.sequence(x.types.map(forType(scope))).map(_.flatten).withIsRewritten
        case IsTypeMapping(TsMemberTypeMapped(_, _, _, _, from: TsTypeRef, _, _)) if scope.isAbstract(from.name) =>
          Problems(IArray(NotStatic(scope, from)))

        case IsTypeMapping(TsMemberTypeMapped(_, level, readOnly, keyRef, from, optionalize, to)) =>
          evaluateKeys(scope)(from).map { keys =>
            val all = IArray.fromTraversable(keys).map { key =>
              val replaced   = Replace(TsTypeRef.of(keyRef), key).visitTsType(scope)(to)
              val memberType = ResolveTypeLookups.visitTsType(scope)(replaced)
              val (base, wasOptional) = memberType match {
                case OptionalType(unwrapped) => (unwrapped, true)
                case other                   => (other, false)
              }

              TsMemberProperty(
                comments   = NoComments,
                level      = level,
                name       = TsIdent(key),
                tpe        = Some(base),
                expr       = None,
                isStatic   = false,
                isReadOnly = readOnly(false), //todo!
                isOptional = optionalize(wasOptional),
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
        case x: TsTypeObject => Ok(x.members, false)
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
          if (evaluatePredicate(pred)) forType(scope)(ifTrue)
          else forType(scope)(ifFalse)

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
      }

    def extract(members: IArray[TsMember], wanted: Set[String]): Option[IArray[TsMember]] =
      members.collect {
        case x: TsMemberFunction if wanted(x.name.value) => x
        case x: TsMemberProperty if wanted(x.name.value) => x
      }.nonEmptyOpt

    def forInterface(newScope: TsTreeScope)(i: TsDeclInterface): Res[IArray[TsMember]] =
      Res
        .sequence(i.inheritance.map(AllMembersFor(newScope)))
        .map(fromParents => handleOverridingFields(i.members, fromParents))

    /* would want to do this for methods too, and in a more principled way. */
    def handleOverridingFields(fromThis: IArray[TsMember], fromParents: IArray[IArray[TsMember]]): IArray[TsMember] = {
      val thisFieldOverrides           = fromThis.collect { case x: TsMemberProperty => x.name }.toSet
      val (parentsFields, parentsRest) = fromParents.flatten.partitionCollect { case x: TsMemberProperty => x }

      fromThis ++ parentsFields.filterNot(x => thisFieldOverrides(x.name)) ++ parentsRest
    }

    def apply(scope: TsTreeScope)(typeRef: TsTypeRef): Res[IArray[TsMember]] = {
      val enableCache = scope.root.cache.isDefined && typeRef.tparams.forall(_.isInstanceOf[TsTypeRef])
      if (enableCache) {
        if (scope.root.cache.get.typeMappings.contains(typeRef)) {
          return scope.root.cache.get.typeMappings(typeRef)
        }
      }

      val res = scope.lookupInternal(Picker.Types, typeRef.name.parts, LoopDetector.initial) collectFirst {
        case (x: TsDeclInterface, newScope) =>
          FillInTParams(x, typeRef.tparams) match {
            case i: TsDeclInterface => forInterface(newScope)(i)
          }

        case (x: TsDeclClass, newScope) =>
          FillInTParams(x, typeRef.tparams) match {
            case TsDeclClass(_, _, _, _, _, parent, implements, members, _, _) =>
              Res
                .sequence((implements ++ IArray.fromOption(parent)).map(AllMembersFor(newScope)))
                .map(fromParents => handleOverridingFields(members, fromParents))
          }

        case (x: TsDeclTypeAlias, _) =>
          forType(scope)(FillInTParams(x, typeRef.tparams).alias)
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
        scope.lookupType(x.name) exists {
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
