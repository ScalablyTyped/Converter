package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res
import org.scalablytyped.converter.internal.scalajs.transforms.{CleanIllegalNames, UnionToInheritance}

import scala.collection.immutable.SortedMap

object FindProps {
  /* javascript limitation */
  val MaxParamsForMethod = 254

  sealed trait Res[T] {
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

    def map[U](f: T => U): Res[U] = this match {
      case Res.Error(msg)       => Res.Error(msg)
      case Res.One(name, value) => Res.One(name, f(value))
      case Res.Many(values)     => Res.Many(values.mapValues(f))
    }
  }

  object Res {
    sealed trait Success[T] extends Res[T]
    object Success {
      def unapply[T](arg: Res[T]): Option[Success[T]] = arg match {
        case success: Success[T] => Some(success)
        case Error(_) => None
      }
    }
    case class Error[T](msg:   String) extends Res[T]
    case class One[T](name:    TypeRef, value: T) extends Success[T]
    case class Many[T](values: Map[TypeRef, T]) extends Success[T]

    def combine[T](ress: IArray[Res[T]]): Res[T] =
      ress.partitionCollect3(
        { case Error(msg)       => msg },
        { case One(name, value) => name -> value },
        { case Many(values)     => values },
      ) match {
        case (IArray.Empty, IArray.exactlyOne((name, one)), IArray.Empty, _) => One(name, one)
        case (IArray.Empty, ones, manies, _)                                 => Many(ones.toMap ++ maps.smash(manies))
        case (errors, _, _, _)                                               => Error(errors.mkString(", "))
      }
  }

  def parentParameter(name: Name, ref: TypeRef, isRequired: Boolean): (Name, Left[Prop, Nothing]) =
    name -> Left(
      Prop(
        ParamTree(name, isImplicit = false, ref, if (isRequired) None else Some(TypeRef.`null`), NoComments),
        Right(obj =>
          if (!isRequired) s"if (${name.value} != null) js.Dynamic.global.Object.assign($obj, ${name.value})"
          else s"js.Dynamic.global.Object.assign($obj, ${name.value})",
        ),
        Left(ref),
      ),
    )
}

final class FindProps(cleanIllegalNames: CleanIllegalNames) {

  def forType(
      typeRef:            TypeRef,
      tparams:            IArray[TypeParamTree],
      scope:              TreeScope,
      memberToProp:       MemberToProp,
      maxNum:             Int,
      acceptNativeTraits: Boolean,
  ): Res[IArray[Prop]] =
    FollowAliases(scope)(typeRef) match {
      case TypeRef.Intersection(types) =>
        val results: IArray[Res[IArray[Prop]]] =
          types.map(tpe => forType(tpe, tparams, scope, memberToProp, maxNum, acceptNativeTraits))

        results.partitionCollect3({ case x @ Res.Error(_) => x }, { case x @ Res.Many(_) => x }, {
          case x @ Res.One(_, _)                          => x
        }) match {
          case (Empty, Empty, ones, _) =>
            Res.One(typeRef, ones.map(_.value).flatten.sorted.distinctBy(_.parameter.name))
          case (Empty, _, _, _) =>
            Res.Error("Support for combinations of intersection and union types not implemented")
          case (errors, _, _, _) =>
            Res.Error(s"Couldn't find props for $typeRef because: ${errors.map(_.msg).mkString(", ")}")
        }
      case TypeRef.Union(types) =>
        Res.combine(types.map(tpe => forType(tpe, tparams, scope, memberToProp, maxNum, acceptNativeTraits)))

      case other =>
        val retOpt = scope lookup other.typeName collectFirst {
          case (_cls: ClassTree, newScope) =>
            val cls = FillInTParams(_cls, newScope, other.targs, tparams)
            forClassTree(
              cls,
              scope / cls,
              memberToProp,
              maxNum             = maxNum,
              acceptNativeTraits = acceptNativeTraits,
            )
        }

        retOpt.getOrElse(Res.Error(s"Could't extract props from $other because couldn't resolve ClassTree."))
    }

  def forClassTree(
      cls:                ClassTree,
      scope:              TreeScope,
      memberToProp:       MemberToProp,
      maxNum:             Int,
      acceptNativeTraits: Boolean,
  ): Res[IArray[Prop]] =
    cls.comments.extract { case UnionToInheritance.WasUnion(subclassRefs) => subclassRefs } match {
      case Some((subclassRefs, _)) =>
        Res.combine(subclassRefs.map { subClsRef =>
          scope
            .lookup(subClsRef.typeName)
            .collectFirst {
              case (subCls: ClassTree, _) =>
                forClassTree(
                  FillInTParams(subCls, scope, subClsRef.targs, cls.tparams),
                  scope,
                  memberToProp,
                  maxNum,
                  acceptNativeTraits,
                )
            }
            .getOrElse(Res.Error(s"Could not find ${subClsRef.typeName}"))
        })

      case None =>
        if (cls.classType =/= ClassType.Trait) Res.Error("Not a trait")
        else if (!acceptNativeTraits && !cls.receivesCompanion) Res.Error("Not a @ScalaJSDefined trait")
        else {
          val parents = ParentsResolver(scope, cls)

          /* treat dictionaries specially, as they have no declared members */
          val (treatAsUnresolved, keptDirectParents) =
            parents.directParents.partitionCollect {
              case ParentsResolver.Parent(IArray.first(ref))
                  if ref.typeName === QualifiedName.StringDictionary || ref.typeName === QualifiedName.NumberDictionary =>
                ref
            }

          val RemoveThis = TypeRewriter(
            Map(
              TypeRef.ThisType(NoComments) -> TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments),
            ),
          )

          /* extract one per name, while undoing some renaming damage that we have done */
          def membersFrom(cls: ClassTree): Map[Name, Either[Prop, MemberTree]] =
            RemoveThis
              .visitClassTree(scope)(cls)
              .members
              .collect { case (x: MemberTree) => x }
              .groupBy(x => realNameFrom(x.annotations, x.name))
              .collect {
                case (name, ms) if name =/= Name.APPLY && name =/= Name.namespaced =>
                  name -> Right(combine(ms).renamed(name))
              }

          def go(p: ParentsResolver.Parent): Map[Name, Either[Prop, MemberTree]] =
            maps.smash(p.parents.map(go)) ++ membersFrom(p.classTree)

          val builder =
            Builder(
              keptDirectParents.map(p => p -> go(p)).toMap,
              parents.unresolved ++ treatAsUnresolved,
              membersFrom(cls).toSorted,
            )

          Res.One(
            TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments),
            IArray
              .fromTraversable(
                builder
                  .skipParentInlineIfMoreMembersThan(maxNum) { parent =>
                    val isRequired = parent.classTree.members.exists {
                      case _: MethodTree => true
                      case FieldTree(_, _, Optional(_), _, _, _, _, _) => false
                      case _: FieldTree => true
                      case _ => false
                    }
                    FindProps.parentParameter(parent.refs.head.name, parent.refs.head, isRequired)
                  }
                  .allParamsUnique
                  .values,
              )
              .mapNotNone {
                case Left(prop)    => Some(prop)
                case Right(member) => memberToProp(scope, member)
              }
              .sorted,
          )
        }
    }

  def combine(ms: IArray[MemberTree]): MemberTree =
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
            param.copy(tpe = TypeRef.Union(forIdx, sort = true))
        }
        val resultType = TypeRef.Union(methods.map(_.resultType), sort = true)
        methods.head.copy(tparams = tparams, params = IArray(params), resultType = resultType)
      case (IArray.exactlyOne(field), _, IArray.Empty) => field
      case (fields, _, IArray.Empty) if fields.nonEmpty =>
        fields.head.copy(tpe = TypeRef.Union(fields.map(_.tpe), sort = true))

      case other => sys.error(s"Unexpected: ${other}")
    }
  private case class Builder(
      directParents: Map[ParentsResolver.Parent, Map[Name, Either[Prop, MemberTree]]],
      unresolved:    IArray[TypeRef],
      own:           SortedMap[Name, Either[Prop, MemberTree]],
  ) {

    def skipParentInlineIfMoreMembersThan(
        maxNum: Int,
    )(f:        ParentsResolver.Parent => (Name, Either[Prop, MemberTree])): Builder = {
      val numParentMembers = directParents.foldLeft(0)((acc, p) => acc + p._2.size)
      if (own.size + numParentMembers + unresolved.length > maxNum) {

        val shortened  = own.take(maxNum - directParents.size - unresolved.length)
        val compressed = directParents.map { case (k, _) => f(k) }
        Builder(Map.empty, unresolved, shortened ++ compressed)
      } else this
    }

    /** It's not *the* most precise way of going about this (will lose useful overloads),
      *  but has the nice property that it keeps the closest/most specific definition of a member
      * */
    def allParamsUnique: Map[Name, Either[Prop, MemberTree]] = {
      val fromParents = directParents.foldLeft(Map.empty[Name, Either[Prop, MemberTree]])(_ ++ _._2)
      val fromUnresolved =
        unresolved.map(typeRef => FindProps.parentParameter(typeRef.name, typeRef, isRequired = false)).toMap
      fromParents ++ fromUnresolved ++ own
    }
  }

  def realNameFrom(anns: IArray[Annotation], fallback: Name): Name =
    anns
      .collectFirst {
        case Annotation.JsName(name)                       => name
        case Annotation.JsImport(_, Imported.Named(names)) => names.last
        case Annotation.JsGlobal(qname)                    => qname.parts.last
      }
      .filterNot(cleanIllegalNames.Illegal)
      .map(Name.necessaryRewrite)
      .getOrElse(fallback)
}
