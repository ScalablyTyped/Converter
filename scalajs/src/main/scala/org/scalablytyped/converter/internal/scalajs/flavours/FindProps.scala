package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res
import org.scalablytyped.converter.internal.scalajs.transforms.{CleanIllegalNames, UnionToInheritance}

object FindProps {
  /* javascript limitation */
  val MaxParamsForMethod = 254

  sealed trait Res[+E, +T] {
    def headOption: Option[T] = this match {
      case Res.One(_, value) => Some(value)
      case Res.Many(values)  => Some(values.head._2)
      case Res.Error(_)      => None
    }

    def asMap: Map[TypeRef, T] = this match {
      case Res.One(name, value) => Map(name -> value)
      case Res.Many(values)     => values
      case Res.Error(_)         => Map.empty
    }

    def map[U](f: T => U): Res[E, U] = this match {
      case Res.Error(msg)       => Res.Error(msg)
      case Res.One(name, value) => Res.One(name, f(value))
      case Res.Many(values)     => Res.Many(values.mapValues(f))
    }

    def mapError[EE](f: E => EE): Res[EE, T] = this match {
      case Res.Error(e)         => Res.Error(f(e))
      case Res.One(name, value) => Res.One(name, value)
      case Res.Many(values)     => Res.Many(values)
    }
  }

  object Res {
    sealed trait Success[+T] extends Res[Nothing, T]
    object Success {
      def unapply[E, T](arg: Res[E, T]): Option[Success[T]] = arg match {
        case success: Success[T] => Some(success)
        case Error(_) => None
      }
    }
    case class Error[E](msg:   E) extends Res[E, Nothing]
    case class One[T](name:    TypeRef, value: T) extends Success[T]
    case class Many[T](values: Map[TypeRef, T]) extends Success[T]

    def combine[E <: AnyRef, T](ress: IArray[Res[IArray[E], T]]): Res[IArray[E], T] =
      ress.partitionCollect3(
        { case Error(es)        => es },
        { case One(name, value) => name -> value },
        { case Many(values)     => values },
      ) match {
        case (IArray.Empty, IArray.exactlyOne((name, one)), IArray.Empty, _) => One(name, one)
        case (IArray.Empty, ones, manies, _) =>
          val all = ones.toMap ++ maps.smash(manies)
          val distinctByName =
            all.map { case (tr, t) => Name(nameFor(tr)) -> ((tr, t)) }.map { case (_, (tr, t)) => tr -> t }

          if (distinctByName.size === 1) {
            val (name, value) = distinctByName.head
            One(name, value)
          } else Many(distinctByName)
        case (errors, _, _, _) => Error(errors.flatten)
      }
  }

  def parentParameter(name: Name, typeRef: TypeRef, isRequired: Boolean): (Name, Prop) = {
    import ExprTree._
    name -> Prop.CompressedProp(
      name,
      typeRef,
      ref => Call(Ref(QualifiedName.DynamicGlobalObjectAssign), IArray(IArray(ref, Ref(name)))),
      isRequired,
    )
  }
}

final class FindProps(
    cleanIllegalNames: CleanIllegalNames,
    memberToProp:      MemberToProp,
    parentsResolver:   ParentsResolver,
) {

  def forType(
      typeRef:            TypeRef,
      tparams:            IArray[TypeParamTree],
      scope:              TreeScope,
      maxNum:             Int,
      acceptNativeTraits: Boolean,
  ): Res[IArray[String], IArray[Prop]] =
    FollowAliases(scope)(typeRef) match {
      case TypeRef.Intersection(types, _) =>
        val results: IArray[Res[IArray[String], IArray[Prop]]] =
          types.map(tpe => forType(tpe, tparams, scope, maxNum, acceptNativeTraits))

        results.partitionCollect3({ case x @ Res.Error(_) => x }, { case x @ Res.Many(_) => x }, {
          case x @ Res.One(_, _)                          => x
        }) match {
          case (Empty, Empty, ones, _) =>
            Res.One(typeRef, ones.flatMap(_.value).sorted.distinctBy(_.name))
          case (Empty, _, _, _) =>
            Res.Error(IArray("Support for combinations of intersection and union types not implemented"))
          case (errors, _, _, _) =>
            Res.Error(
              IArray(
                s"Couldn't find props for ${Printer.formatTypeRef(0)(typeRef)} because: ${errors.map(_.msg).mkString(", ")}",
              ),
            )
        }

      case TypeRef.Union(types, _) =>
        Res.combine(types.map(tpe => forType(tpe, tparams, scope, maxNum, acceptNativeTraits)))

      case other =>
        val retOpt = scope lookup other.typeName collectFirst {
          case (_cls: ClassTree, newScope) =>
            val cls = FillInTParams(_cls, newScope, other.targs, tparams)
            forClassTree(
              cls,
              scope / cls,
              maxNum             = maxNum,
              acceptNativeTraits = acceptNativeTraits,
              selfRef            = other,
            )
        }

        retOpt.getOrElse {
          val msg = s"Could't extract props from ${Printer.formatTypeRef(0)(other)} because couldn't resolve ClassTree."
          Res.Error(IArray(msg))
        },
    }

  def forClassTree(
      cls:                ClassTree,
      scope:              TreeScope,
      maxNum:             Int,
      acceptNativeTraits: Boolean,
      selfRef:            TypeRef,
  ): Res[IArray[String], IArray[Prop]] =
    cls.comments.extract { case UnionToInheritance.WasUnion(x, y) => x ++ y } match {
      case Some((subclassRefs, _)) =>
        Res.combine(subclassRefs.map { subClsRef =>
          scope
            .lookup(subClsRef.typeName)
            .collectFirst {
              case (subCls: ClassTree, _) =>
                val subCls_ = FillInTParams(subCls, scope, subClsRef.targs, cls.tparams)
                forClassTree(subCls_, scope, maxNum, acceptNativeTraits, subClsRef)
            }
            .getOrElse {
              val msg = s"Could not find ${Printer.formatTypeRef(0)(subClsRef)}"
              Res.Error(IArray(msg))
            }
        })

      case None =>
        if (cls.classType =/= ClassType.Trait) Res.Error(IArray("Not a trait"))
        else if (!acceptNativeTraits && !cls.receivesCompanion) Res.Error(IArray("Not a @ScalaJSDefined trait"))
        else {
          val parents = parentsResolver(scope, cls)

          /* treat dictionaries specially, as they have no declared members */
          val (treatAsUnresolved, keptDirectParents) =
            parents.directParents.partitionCollect {
              case ParentsResolver.Parent(IArray.first(ref))
                  if ref.typeName === QualifiedName.StringDictionary || ref.typeName === QualifiedName.NumberDictionary =>
                ref
            }

          val RemoveThis = TypeRewriter(Map(TypeRef.ThisType(NoComments) -> selfRef))

          val unresolvedProps: Map[Name, Prop] =
            (parents.unresolved ++ treatAsUnresolved)
              .map(typeRef => FindProps.parentParameter(typeRef.name, typeRef, isRequired = false))
              .toMap

          /* extract one per name, while undoing some renaming damage that we have done */
          def membersFrom(cls: ClassTree): Map[Name, MemberTree] =
            RemoveThis
              .visitClassTree(scope)(cls)
              .members
              .collect { case x: MemberTree => x }
              /* worthless and for instance `(???: js.UndefOr[Nothing]).get` doesn't compile */
              .filter {
                case FieldTree(_, _, Optionality(_, TypeRef.Nothing), _, _, _, _, _) => false
                case _                                                               => true
              }
              .groupBy(x => realNameFrom(x.annotations, x.name))
              .collect {
                case (name, ms) if name =/= Name.APPLY && name =/= Name.namespaced => name -> combine(ms).renamed(name)
              }

          val ownProps: Map[Name, Prop] =
            membersFrom(cls).mapNotNone(member => memberToProp(scope, member, isInherited = false))

          /** The total number of props might be too large, so we gradually try to limit it by "compressing" props,
            *   and taking the best option (or truncating variant with the fewest props)
            *
            * Compressing in this context means to take a whole object which corresponds to a parent type
            */
          val propsStream: Stream[IArray[Prop]] =
            Stream.range(0, keptDirectParents.length + 1).reverse.map { n =>
              val inlineParents     = keptDirectParents.take(n)
              val compressedParents = keptDirectParents.drop(n)

              val inlinedPropsFromParent: Map[Name, Prop] = {
                def go(p: ParentsResolver.Parent): Map[Name, MemberTree] =
                  maps.smash(p.parents.map(go)) ++ membersFrom(p.classTree)

                maps.smash(inlineParents.map(go)).mapNotNone(member => memberToProp(scope, member, isInherited = true))
              }

              val compressedProps: Map[Name, Prop] =
                compressedParents.map { parent =>
                  val isRequired = parent.classTree.members.exists {
                    case _: MethodTree => true
                    case FieldTree(_, _, Optional(_), _, _, _, _, _) => false
                    case _: FieldTree => true
                    case _ => false
                  }
                  FindProps.parentParameter(parent.refs.head.name, parent.refs.head, isRequired)
                }.toMap

              /** It's not *the* most precise way of going about this (will lose useful overloads),
                *  but has the nice property that it keeps the closest/most specific definition of a member
                * */
              val all = inlinedPropsFromParent ++ unresolvedProps ++ compressedProps ++ ownProps

              all.toIArrayValues.sorted
            }

          val valid: Option[IArray[Prop]] =
            propsStream.find(_.length <= maxNum) orElse
              propsStream.lastOption.map(filtered => filtered.take(maxNum))

          valid match {
            case Some(props) => Res.One(selfRef, props)
            case None        => sys.error(s"Empty stream for class ${cls.codePath.parts.mkString(".")}")
          }
        }
    }

  private def combine(ms: IArray[MemberTree]): MemberTree =
    ms.partitionCollect2({ case x: FieldTree => x }, { case x: MethodTree => x }) match {
      case (_, IArray.exactlyOne(method), IArray.Empty) => method
      case (_, methods, IArray.Empty) if methods.nonEmpty =>
        val tparams          = methods.maxBy(_.tparams.length).tparams
        val paramsForMethods = methods.map(_.params.flatten)
        val longestParams    = paramsForMethods.maxBy(_.length)
        val params = longestParams.zipWithIndex.map {
          case (param, idx) =>
            val forIdx: IArray[TypeRef] =
              paramsForMethods.map(paramsForMethod =>
                if (paramsForMethod.isDefinedAt(idx)) paramsForMethod(idx).tpe else TypeRef.undefined,
              )
            param.copy(tpe = TypeRef.Union(forIdx, NoComments, sort = true))
        }
        val resultType = TypeRef.Union(methods.map(_.resultType), NoComments, sort = true)
        methods.head.copy(tparams = tparams, params = IArray(params), resultType = resultType)
      case (IArray.exactlyOne(field), _, IArray.Empty) => field
      case (fields, _, IArray.Empty) if fields.nonEmpty =>
        fields.head.copy(tpe = TypeRef.Union(fields.map(_.tpe), NoComments, sort = true))

      case other => sys.error(s"Unexpected: ${other}")
    }

  private def realNameFrom(anns: IArray[Annotation], fallback: Name): Name =
    anns
      .collectFirst {
        case Annotation.JsName(name)                          => name
        case Annotation.JsImport(_, Imported.Named(names), _) => names.last
        case Annotation.JsGlobal(qname)                       => qname.parts.last
      }
      .filterNot(cleanIllegalNames.Illegal)
      .map(Name.necessaryRewrite)
      .getOrElse(fallback)
}
