package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.scalajs.TypeParamTree.asTypeArgs
import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res
import org.scalablytyped.converter.internal.scalajs.flavours.GenImplicitOpsClass.AvailableName
import org.scalablytyped.converter.internal.scalajs.transforms.{CombineOverloads, FakeLiterals}
import org.scalablytyped.converter.internal.scalajs.transforms.UnionToInheritance.RewrittenTypeUnion

/**
  * Add a companion object to `@ScalaJSDefined` traits for creating instances with method syntax
  */
final class GenCompanions(findProps: FindProps) extends TreeTransformation {
  override def leaveContainerTree(scope: TreeScope)(container: ContainerTree): ContainerTree =
    // Native JS objects cannot contain inner Scala traits, classes or objects (i.e., not extending js.Any)
    if (scope.stack.exists { case mod: ModuleTree => mod.isNative; case _ => false })
      container
    else {
      def nameConflict(name: Name): Boolean =
        container.index.getOrElse(name, Empty) exists {
          case _: ContainerTree => true
          case _ => false
        }

      container.withMembers(container.members.flatMap {
        case ta@RewrittenTypeUnion(rewritten) if !nameConflict(ta.name) =>
          val generated = genMethodsFromTypeUnion(scope, rewritten)
          generated match {
            case Empty => IArray(ta)
            case some =>
              val dontMinimize = Comments(CommentData(Minimization.Related(some.collect {
                case m: HasCodePath => TypeRef(m.codePath)
              })))
              val mod = ModuleTree(Empty, ta.name, Empty, some, dontMinimize, ta.asInstanceOf[HasCodePath].codePath, isOverride = false)
              IArray(ta, mod)
          }

        case cls: ClassTree if !nameConflict(cls.name) =>
          val unboundedTParams = stripBounds(cls.tparams)

          val clsRef = TypeRef(cls.codePath, asTypeArgs(unboundedTParams), NoComments)

          val geneatedImplicitOps: Option[ClassTree] =
            findProps.forClassTree(
              cls                = cls,
              scope              = scope / cls,
              maxNum             = Int.MaxValue,
              acceptNativeTraits = false,
              selfRef            = clsRef,
            ) match {
              case Res.One(_, props) if props.nonEmpty => GenImplicitOpsClass(cls, props, cls.codePath, scope)
              case _                                   => None
            }

          val generatedCreators: IArray[Tree] =
            findProps.forClassTree(
              cls                = cls,
              scope              = scope / cls,
              maxNum             = FindProps.MaxParamsForMethod,
              acceptNativeTraits = false,
              selfRef            = clsRef,
            ) match {
              case Res.Error(_) =>
                Empty

              case Res.One(_, props) if props.isEmpty => Empty
              case Res.One(_, props) =>
                val requiredProps = props.filter(_.optionality === Optionality.No)

                IArray.fromOptions(
                  Some(generateCreator(Name.APPLY, requiredProps, cls.codePath, unboundedTParams))
                    .filter(_.params.nonEmpty)
                    .filter(ensureNotTooManyStrings(scope)),
                )

              case Res.Many(propsMap) =>
                propsMap.toIArray.mapNotNone {
                  case (_, props) if props.isEmpty => None
                  case (propsRef, props) =>
                    val requiredProps = props.filter(_.optionality === Optionality.No)

                    Some(generateCreator(propsRef.name, requiredProps, cls.codePath, unboundedTParams))
                      .filter(_.params.nonEmpty)
                      .filter(ensureNotTooManyStrings(scope))
                }
            }

          generatedCreators ++ IArray.fromOption(geneatedImplicitOps) match {
            case Empty => IArray(cls)
            case some =>
              val dontMinimize = Comments(CommentData(Minimization.Related(some.collect {
                case m: HasCodePath => TypeRef(m.codePath)
              })))
              val mod = ModuleTree(Empty, cls.name, Empty, some, dontMinimize, cls.codePath, isOverride = false)
              IArray(cls, mod)
          }

        case other => IArray(other)
      })
    }

  /**
    * Avoid errors like this
    * [E] [E-1] Error while emitting typingsJapgolly/csstype/csstypeMod/StandardLonghandPropertiesHyphenFallback$
    * [E]       UTF8 string too large
    */
  def ensureNotTooManyStrings(scope: TreeScope)(mod: MethodTree): Boolean = {
    val MaxWeight = 32768 // an estimate. If you see the error again, decrease this

    object Dealias extends TreeTransformation {
      override def leaveTypeRef(scope: TreeScope)(s: TypeRef): TypeRef = FollowAliases(scope)(s)

      // ignore implementations
      override def leaveExprTree(scope:    TreeScope)(s: ExprTree):     ExprTree     = ExprTree.Null
      override def leaveExprRefTree(scope: TreeScope)(s: ExprTree.Ref): ExprTree.Ref = ExprTree.native
    }

    var stringLength = 0

    TreeTraverse.foreach(Dealias.visitTree(scope)(mod)) {
      case name: QualifiedName =>
        name.parts.foreach(p => stringLength += p.unescaped.length)
      case _ => ()
    }

    stringLength < MaxWeight
  }

  def generateCreator(
      name:        Name,
      props:       IArray[Prop],
      typeCp:      QualifiedName,
      typeTparams: IArray[TypeParamTree],
  ): MethodTree = {
    val interpretedProps = props.map(defaultInterpretation.apply)

    val (mutators, initializers, Empty) = interpretedProps.partitionCollect2(
      { case (x: Mutator, _)     => x },
      { case (x: Initializer, _) => x },
    )
    val typeName = typeCp.parts.last

    val ret = TypeRef(QualifiedName(IArray(typeName)), asTypeArgs(typeTparams), NoComments)

    val impl: ExprTree = {
      import ExprTree._
      val objName = Name("__obj")
      Block.flatten(
        IArray(Val(objName, Call(Ref(QualifiedName.DynamicLiteral), IArray(initializers.map(_.value))))),
        mutators.map(f => f.value(Ref(objName))),
        IArray(Cast(Ref(QualifiedName(IArray(objName))), ret)),
      )
    }

    MethodTree(
      annotations = IArray(Annotation.Inline),
      level       = ProtectionLevel.Default,
      name        = name,
      tparams     = typeTparams,
      params      = IArray(interpretedProps.map(_._2)),
      impl        = impl,
      resultType  = ret,
      isOverride  = false,
      comments    = NoComments,
      codePath    = typeCp + name,
      isImplicit  = false,
    )
  }

  private def genMethodsFromTypeUnion(scope: TreeScope, r: RewrittenTypeUnion) = {
    val unboundedTParams      = stripBounds(r.tparams)
    val selfRef               = TypeRef(r.codePath, asTypeArgs(unboundedTParams), NoComments)
    val mutableAvailableNames = AvailableName(ObjectMembers.ScalaObject.members.map(_.name))

    val knownValues: Map[QualifiedName, ExprTree.Lit] = {
      val cache = collection.mutable.HashMap.empty[QualifiedName, Option[ExprTree.Lit]]

      def visit(tpe: TypeRef): Unit =
        tpe match {
          case TypeRef.Union((types, _))                 => types.foreach(visit)
          case ignore if cache.contains(ignore.typeName) => ()
          case look =>
            cache.put(look.typeName, None)
            look.comments.extract {
              case FakeLiterals.WasLiteral(expr) => cache.put(look.typeName, Some(expr))
            }
            visit(FollowAliases(scope)(look))
        }

      r.asInheritance.foreach(visit)
      r.noRewrites.foreach(visit)

      cache.toMap.collect {
        case (k, Some(v)) => k -> v
      }
    }

    def methodForValue(tpe: TypeRef, knownValue: ExprTree.Lit) =
      MethodTree(
        IArray(Annotation.Inline),
        ProtectionLevel.Default,
        mutableAvailableNames(tpe.name),
        unboundedTParams,
        Empty,
        ExprTree.Cast(knownValue, tpe),
        tpe,
        isOverride = false,
        NoComments,
        r.codePath + tpe.name,
        isImplicit = false,
      )

    def methodForType(tpe: TypeRef) =
      MethodTree(
        IArray(Annotation.Inline),
        ProtectionLevel.Default,
        Name.APPLY,
        unboundedTParams,
        IArray(
          IArray(
            ParamTree(
              Name("value"),
              isImplicit = false,
              isVal      = false,
              tpe,
              NotImplemented,
              NoComments,
            ),
          ),
        ),
        ExprTree.Cast(ExprTree.Ref(Name("value")), selfRef),
        selfRef,
        isOverride = false,
        NoComments,
        r.codePath + tpe.name,
        isImplicit = true,
      )

    def genUndefConversion(undefineds: IArray[TypeRef]) =
      if (undefineds.isEmpty) Empty
      else {
        val T       = TypeParamTree(AvailableName(unboundedTParams.map(_.name))(Name("T")), Empty, None, NoComments)
        val TRef    = TypeRef(T.name)
        val tparams = unboundedTParams :+ T
        val valueParam = ParamTree(
          name       = Name("value"),
          isImplicit = false,
          isVal      = false,
          tpe        = TypeRef.UndefOr(TRef),
          default    = NotImplemented,
          comments   = NoComments,
        )
        val evParam = ParamTree(
          name       = Name("ev"),
          isImplicit = true,
          isVal      = false,
          tpe        = TypeRef.ScalaFunction(IArray(TRef), selfRef, NoComments),
          default    = NotImplemented,
          comments   = NoComments,
        )

        val impl = {
          import ExprTree._
          Cast(Call(Select(Ref(valueParam.name), Name("map")), IArray(IArray(Ref(evParam.name)))), TRef)
        }

        val retName = Name("fromUndef")

        val ret = MethodTree(
          annotations = IArray(Annotation.Inline),
          level       = ProtectionLevel.Default,
          name        = retName,
          tparams     = tparams,
          params      = IArray(IArray(valueParam), IArray(evParam)),
          impl        = impl,
          resultType  = selfRef,
          isOverride  = false,
          comments    = NoComments,
          codePath    = r.codePath + retName,
          isImplicit  = true,
        )
        IArray(ret)
      }

    def genNullConversion(nulls: IArray[TypeRef]) =
      if (nulls.isEmpty) Empty
      else {
        val T       = TypeParamTree(AvailableName(unboundedTParams.map(_.name))(Name("T")), Empty, None, NoComments)
        val TRef    = TypeRef(T.name)
        val tparams = unboundedTParams :+ T
        val valueParam = ParamTree(
          name       = Name("value"),
          isImplicit = false,
          isVal      = false,
          tpe        = TypeRef.Union(IArray(TRef, TypeRef.Null), NoComments, sort = false),
          default    = NotImplemented,
          comments   = NoComments,
        )
        val evParam = ParamTree(
          name       = Name("ev"),
          isImplicit = true,
          isVal      = false,
          tpe        = TypeRef.ScalaFunction(IArray(TRef), selfRef, NoComments),
          default    = NotImplemented,
          comments   = NoComments,
        )

        val retName = Name("fromOrNull")

        val impl = {
          import ExprTree._
          If(
            pred    = BinaryOp(Ref(valueParam.name), "!=", Null),
            ifTrue  = Call(Ref(evParam.name), IArray(IArray(Cast(Ref(valueParam.name), TRef)))),
            ifFalse = Some(Cast(Null, selfRef)),
          )
        }

        val ret = MethodTree(
          IArray(Annotation.Inline),
          ProtectionLevel.Default,
          retName,
          tparams,
          IArray(IArray(valueParam), IArray(evParam)),
          impl,
          selfRef,
          isOverride = false,
          NoComments,
          r.codePath + retName,
          isImplicit = true,
        )
        IArray(ret)
      }

    val followed: IArray[TypeRef] = {
      def go(tpe: TypeRef): IArray[TypeRef] =
        FollowAliases(scope)(tpe) match {
          case TypeRef.Union(types, _) if types.length < 20 => types.flatMap(go)
          case _                                            => IArray(tpe)
        }

      r.all.flatMap(go).distinct
    }

    followed.partitionCollect3(
      { case tpe if knownValues.contains(tpe.typeName)   => tpe -> knownValues(tpe.typeName) },
      { case tr @ TypeRef(QualifiedName.UNDEFINED, _, _) => tr },
      { case tr @ TypeRef(QualifiedName.Null, _, _)      => tr },
    ) match {
      case (values, undefineds, nulls, types) =>
        val fromValues = values.map {
          case (tpe, knownValue) => methodForValue(tpe, knownValue)
        }

        val undefConversion: IArray[MethodTree] = genUndefConversion(undefineds)
        val nullConversion:  IArray[MethodTree] = genNullConversion(nulls)

        val fromTypes = CombineOverloads
          .combineOverloads(scope, types.map(methodForType))
          .sortBy(_.params.head.head.tpe.name)

        fromValues ++ fromTypes ++ undefConversion ++ nullConversion
    }
  }

}
