package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.scalajs.ExprTree._
import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res
import org.scalablytyped.converter.internal.scalajs.flavours.GenBuilderClass.AvailableName
import org.scalablytyped.converter.internal.scalajs.transforms.Mangler

object JapgollyGenComponents {

  final case class SplitProps(refTypes: IArray[TypeRef], propsInApply: IArray[Prop], propsInBuilder: IArray[Prop]) {
    val hasRequiredProps = propsInApply.exists(_.isRequired) || propsInBuilder.exists(_.isRequired)
  }

  def SplitProps(reactNames: ReactNames, scope: TreeScope, enableLongApplyMethod: Boolean)(
      allProps:              IArray[Prop],
  ): SplitProps = {
    object Ref {
      def unapply(maybeRef: TypeRef): Option[TypeRef] =
        if (reactNames.isRef(maybeRef.typeName)) Some(maybeRef.targs.head)
        else
          scope.lookup(maybeRef.typeName).firstDefined {
            case (ta: TypeAliasTree, nextScope) => unapply(FillInTParams(ta, nextScope, maybeRef.targs, Empty).alias)
            case _ => None
          }
    }

    val isVdomNode = Set(
      reactNames.ReactNode,
      reactNames.ReactElement,
      JapgollyNames.vdom.VdomNode,
      JapgollyNames.vdom.ReactElement,
      JapgollyNames.vdom.Array,
      JapgollyNames.vdom.TagOf,
    )

    def shouldIgnoreProp(name: Name, tpe: TypeRef): Boolean =
      (name, tpe) match {
        /* we always add our own override string dictionary to all components */
        case (_, TypeRef(QualifiedName.StringDictionary, _, _)) => true
        /* we have special syntax already for `withKey` */
        case (names.key, _) => true
        /* we have special syntax for passing children already, as long as they are react nodes */
        case (names.children, TypeRef(qname, _, _)) => isVdomNode(qname)
        case _                                      => false
      }

    val (refTypes: IArray[TypeRef], _, filteredProps: IArray[Prop]) = allProps.partitionCollect2(
      //refTypes
      { case Prop.Normal(Prop.Variant(Ref(ref), _, _, _), _, _, _, FieldTree(_, names.ref, _, _, _, _, _, _)) => ref },
      // ignored
      {
        case n: Prop.Normal if shouldIgnoreProp(n.name, n.main.tpe)    => null
        case n: Prop.CompressedProp if shouldIgnoreProp(n.name, n.tpe) => null
      },
    )
    val MaxParamsInJavascript = 254

    val (propsInApply, propsInBuilder) =
      if (enableLongApplyMethod) (filteredProps.take(MaxParamsInJavascript), filteredProps.drop(MaxParamsInJavascript))
      else filteredProps.partition(_.isRequired)

    SplitProps(refTypes, propsInApply, propsInBuilder)
  }

  final case class PropsDom(propsRef: PropsRef, splitProps: Res[IArray[String], SplitProps])

  object names {
    val components   = Name("components")
    val component    = Name("component")
    val ComponentRef = Name("ComponentRef")
    val key          = Name("key")
    val children     = Name("children")
    val ref          = Name("ref")
  }

  /** An indirection to let us talk about builders at the component group level ([[ComponentGroupKey]]) */
  trait GenBuilder {
    def apply(ownerCp: QualifiedName, component: Component): Builder
  }

  /**
    * The resulting builder for a component can be one of two:
    * - [[Builder.External]] either the default builder in `StBuildingComponent`, or a shared builder
    * - [[Builder.Include]] a builder specific only to the component at hand
    */
  sealed trait Builder {
    val ref: TypeRef =
      this match {
        case Builder.External(ref) => ref
        case Builder.Include(cls)  => TypeRef(cls.codePath, TypeParamTree.asTypeArgs(cls.tparams), NoComments)
      }

    def include: Option[ClassTree] =
      this match {
        case Builder.External(_)  => None
        case Builder.Include(cls) => Some(cls)
      }
  }

  object Builder {
    case class External(typeRef: TypeRef) extends Builder
    case class Include(cls:      ClassTree) extends Builder
  }

  case class SharedBuilder(cls: ClassTree, needRef: Boolean)

  /**
    * Components can be nested. This defines two operations to work with that
    */
  final implicit class ComponentsOps(private val cs: IArray[Component]) extends AnyVal {
    def deepMap(f: Component => Component): IArray[Component] =
      cs.map { c =>
        val cc = f(c)
        cc.withNested(cc.nested.deepMap(f))
      }

    def unnest: IArray[Component] = {
      val ret = IArray.Builder.empty[Component](cs.length)
      def go(c: Component): Unit = {
        ret += c
        c.nested.foreach(go)
      }
      cs.foreach(go)
      ret.result()
    }
  }

  case class ComponentGroupKey(
      propsRef:        PropsRef,
      canBeReferenced: Boolean,
      tparams:         IArray[TypeParamTree],
  )

  def groupKey(c: Component): ComponentGroupKey =
    ComponentGroupKey(c.propsRef, c.referenceTo.isDefined, c.tparams)

  /**
    * I know.
    *
    * A set of components with similar enough interface (same [[ComponentGroupKey]]) will share builders. This is absolutely necessary to compile
    *  some libraries, and help with compile performance in any case.
    *
    *  Such a component interface might be in one of three states (corresponding to [[FindProps.Res]]):
    *   - [[Res.Error]]: props couldn't be resolved or was too complex
    *   - [[Res.One]]: props was resolved
    *   - [[Res.Many]]: props was resolved to several different types (typically a union type)
    *
    *  So a group of components might share more than one builder, that's why the type is so long
    */
  type BuildersByGroup = Map[ComponentGroupKey, Res[(IArray[String], GenBuilder), (SplitProps, GenBuilder)]]

}

/**
  * Generate a package with Slinky compatible react components
  */
class JapgollyGenComponents(
    findProps:             FindProps,
    genStBuilder:          JapgollyGenStBuildingComponent,
    reactNames:            ReactNames,
    enableLongApplyMethod: Boolean,
) {
  import JapgollyGenComponents._

  def apply(
      scope:      TreeScope,
      tree:       ContainerTree,
      components: IArray[Component],
  ): ContainerTree = {
    /* Every tree knows it's own location (called `CodePath`).
             It's used for a lot of things, so it's important to get right */
    val pkgCp = tree.codePath + JapgollyGenComponents.names.components

    /* We group components on what essentially means they have the same interface.
     * When there is more than one they'll share some of the generated code */
    val allComponentsGrouped: Map[ComponentGroupKey, IArray[Component]] =
      components.unnest.groupBy(groupKey)

    /* this is mostly here as an optimization */
    val allResolvedProps: Map[ComponentGroupKey, PropsDom] =
      allComponentsGrouped.map {
        case (group, _) =>
          val resProps: Res[IArray[String], IArray[Prop]] =
            findProps.forType(
              typeRef            = group.propsRef.ref,
              tparams            = group.tparams,
              scope              = scope,
              maxNum             = Int.MaxValue,
              acceptNativeTraits = true,
            )
          group -> PropsDom(group.propsRef, resProps.map(SplitProps(reactNames, scope, enableLongApplyMethod)))
      }

    /* A component might have one or more builders shared with other components */
    val allSharedBuilders: Map[PropsRef, SharedBuilder] =
      if (enableLongApplyMethod) Map.empty
      else {
        val b = Map.newBuilder[PropsRef, SharedBuilder]
        allComponentsGrouped.foreach {
          case (_, components) if components.length < 2 => ()
          case (group, _) =>
            genSharedBuilders(pkgCp, group, allResolvedProps(group)).asMap.foreach {
              case (ref, Some(sb)) => b += ((PropsRef(ref), sb))
              case _               => ()
            }
        }
        b.result()
      }

    val allBuilders: BuildersByGroup =
      allResolvedProps.map {
        case (group, PropsDom(propsRef, resProps)) =>
          val withErrorBuilders: Res[(IArray[String], GenBuilder), SplitProps] =
            resProps
              .mapError { errors =>
                val genBuilder: GenBuilder =
                  (ownerCp: QualifiedName, c: Component) => {
                    val typeArgs     = IArray(effectiveRef(scope, resProps, c.referenceTo))
                    val stBuilderRef = TypeRef(genStBuilder.builderCp, typeArgs, NoComments)

                    genBuilderClass(ownerCp, Name("Builder"), group.tparams, stBuilderRef, Empty) match {
                      case Some(b) => Builder.Include(b)
                      case None    => Builder.External(TypeRef(genStBuilder.Default.codePath, typeArgs, NoComments))
                    }
                  }

                errors -> genBuilder
              }

          val resPropsAndBuilders: Res[(IArray[String], GenBuilder), (SplitProps, GenBuilder)] =
            withErrorBuilders.map { splitProps =>
              val genBuilder: GenBuilder =
                (ownerCp: QualifiedName, c: Component) =>
                  allSharedBuilders.get(propsRef) match {
                    case Some(SharedBuilder(cls, needsRef)) =>
                      val targs: IArray[TypeRef] =
                        (needsRef, TypeParamTree.asTypeArgs(c.tparams)) match {
                          case (true, rest) => effectiveRef(scope, resProps, c.referenceTo) +: rest
                          case (false, all) => all
                        }

                      Builder.External(TypeRef(cls.codePath, targs, NoComments))
                    case None =>
                      val typeArgs     = IArray(effectiveRef(scope, resProps, c.referenceTo))
                      val stBuilderRef = TypeRef(genStBuilder.builderCp, typeArgs, NoComments)

                      genBuilderClass(ownerCp, Name("Builder"), group.tparams, stBuilderRef, splitProps.propsInBuilder) match {
                        case Some(b) => Builder.Include(b)
                        case None =>
                          Builder.External(TypeRef(genStBuilder.Default.codePath, typeArgs, NoComments))
                      }
                  }

              splitProps -> genBuilder
            }

          group -> resPropsAndBuilders
      }

    val generatedComponents: IArray[ModuleTree] =
      components.map(genComponent(pkgCp, allBuilders))

    val allSharedBuilderClasses: IArray[ClassTree] =
      allSharedBuilders.mapToIArray { case (_, SharedBuilder(cls, _)) => cls }.distinctBy(_.name)

    /* Only generate the package if we have mapped any components */
    (generatedComponents ++ allSharedBuilderClasses) match {
      case IArray.Empty => tree
      case nonEmpty =>
        val newPackage = setCodePath(
          pkgCp,
          PackageTree(Empty, names.components, nonEmpty, Comments(Marker.ManglerLeaveAlone), pkgCp),
        )
        tree.withMembers(tree.members :+ newPackage)
    }
  }

  def genSharedBuilders(
      pkgCp:    QualifiedName,
      group:    ComponentGroupKey,
      propsDom: PropsDom,
  ): Res[IArray[String], Option[SharedBuilder]] = {
    val PropsDom(propsRef, resProps) = propsDom

    resProps.map { splitProps =>
      val name = Name(
        s"SharedBuilder_${nameFor(propsRef.ref)}${(propsRef, group.canBeReferenced, group.tparams).hashCode}"
          .replaceAllLiterally("-", "_"),
      )
      val hasRef = group.canBeReferenced || refFromProps(resProps).isDefined
      if (hasRef) {
        val RR           = genStBuilder.R.copy(name = AvailableName(group.tparams.map(_.name))(genStBuilder.R.name))
        val typeArgs     = IArray(TypeRef(RR.name))
        val stBuilderRef = TypeRef(genStBuilder.builderCp, typeArgs, NoComments)
        genBuilderClass(pkgCp, name, RR +: group.tparams, stBuilderRef, splitProps.propsInBuilder).map(cls =>
          SharedBuilder(cls, needRef = true),
        )

      } else {
        val typeArgs     = IArray(TypeRef.Nothing)
        val stBuilderRef = TypeRef(genStBuilder.builderCp, typeArgs, NoComments)
        genBuilderClass(pkgCp, name, group.tparams, stBuilderRef, splitProps.propsInBuilder).map(cls =>
          SharedBuilder(cls, needRef = false),
        )
      }
    }
  }

  def refFromProps[E](resProps: Res[E, SplitProps]): Option[TypeRef] =
    resProps.asMap.flatMapToIArray { case (_, v) => v.refTypes }.headOption

  def effectiveRef(
      scope:             TreeScope,
      resProps:          Res[IArray[String], SplitProps],
      classComponentRef: Option[TypeRef],
  ): TypeRef =
    classComponentRef.orElse(refFromProps(resProps)) match {
      case Some(x @ TypeRef(QualifiedName(IArray.exactlyOne(names.ComponentRef)), _, _)) => x
      /* Observe type bound of :< js.Object */
      case Some(value) =>
        scope
          .lookup(value.typeName)
          .collectFirst { case (_: ClassTree, _) => value }
          .getOrElse(TypeRef.Intersection(IArray(value, TypeRef.Object), NoComments))
      case None => TypeRef.Object
    }

  def genComponent(pkgCp: QualifiedName, builderLookup: BuildersByGroup)(c: Component): ModuleTree = {
    val componentCp = pkgCp + c.fullName
    val resProps    = builderLookup(groupKey(c))
    resProps match {
      case Res.Error((errors, genBuilder)) =>
        errorModule(c.propsRef, c, componentCp, errors, genBuilder)

      case Res.One(propsRef, (splitProps, genBuilder)) =>
        componentModule(c.fullName, c, componentCp, PropsRef(propsRef), splitProps, genBuilder, builderLookup)

      case Res.Many(values) =>
        val members = values.mapToIArray {
          case (propsRef, (splitProps, genBuilder: GenBuilder)) =>
            val name = Name(nameFor(propsRef))
            componentModule(name, c, componentCp + name, PropsRef(propsRef), splitProps, genBuilder, builderLookup)
        }

        ModuleTree(
          annotations = Empty,
          name        = c.fullName,
          parents     = Empty,
          members     = members,
          comments    = Minimization.KeepMarker,
          codePath    = componentCp,
          isOverride  = false,
        )
    }
  }

  def errorModule(
      propsRef:    PropsRef,
      c:           flavours.Component,
      componentCp: QualifiedName,
      errors:      IArray[String],
      genBuilder:  GenBuilder,
  ): ModuleTree = {
    val builder = genBuilder(componentCp, c)
    val members = IArray.fromOptions(
      builder.include,
      Some(genPropsMethod(Name.APPLY, componentCp, propsRef, c.tparams, builder.ref)),
      genImplicitConversionOpt(
        Name("make"),
        componentCp,
        c.tparams,
        props = SplitProps(Empty, Empty, Empty),
        builder.ref,
      ),
    )

    val errorComment =
      Comment(
        s"/* The props of this component has an unsupported shape. You can use `set` manually to use it, but with no compiler support :/ . ${errors
          .mkString(", ")} */\n",
      )

    ModuleTree(
      annotations = Empty,
      name        = c.fullName,
      parents     = Empty,
      members     = IArray(genImportModule(c, componentCp)) ++ members,
      comments    = Minimization.KeepMarker ++ Comments(errorComment),
      codePath    = componentCp,
      isOverride  = false,
    )
  }

  def componentModule(
      name:          Name,
      c:             Component,
      componentCp:   QualifiedName,
      propsRef:      PropsRef,
      splitProps:    SplitProps,
      genBuilder:    GenBuilder,
      builderLookup: BuildersByGroup,
  ): ModuleTree = {
    val builder = genBuilder(componentCp, c)

    val members = IArray.fromOptions(
      Some(genImportModule(c, componentCp)),
      builder.include,
      Some(genPropsMethod(Name("withProps"), componentCp, propsRef, c.tparams, builder.ref)),
      genApplyMethodOpt(Name.APPLY, componentCp, propsRef, splitProps, c.tparams, builder.ref),
      genImplicitConversionOpt(Name("make"), componentCp, c.tparams, splitProps, builder.ref),
    )

    val nested = c.nested.map(genComponent(componentCp, builderLookup))

    ModuleTree(
      annotations = Empty,
      name        = name,
      parents     = Empty,
      members     = members ++ nested,
      comments    = Minimization.KeepMarker,
      codePath    = componentCp,
      isOverride  = false,
    )
  }

  /* only necessary if there are required props */
  def genApplyMethodOpt(
      name:       Name,
      ownerCp:    QualifiedName,
      propsRef:   PropsRef,
      splitProps: SplitProps,
      tparams:    IArray[TypeParamTree],
      builderRef: TypeRef,
  ): Option[MethodTree] =
    if (splitProps.propsInApply.isEmpty && tparams.isEmpty) None
    else {
      val cm = CreatorMethod(splitProps.propsInApply, longApplyMethod = enableLongApplyMethod)

      val impl: ExprTree = {
        val objName = Name("__props")

        val newed = New(
          builderRef,
          IArray(
            Call(
              Ref(QualifiedName.Array),
              IArray(
                IArray(
                  Ref(QualifiedName(IArray(Name.THIS, names.component))),
                  Cast(Ref(QualifiedName(IArray(objName))), propsRef.ref),
                ),
              ),
            ),
          ),
        )

        Block.flatten(
          IArray(Val(objName, Call(Ref(QualifiedName.DynamicLiteral), IArray(cm.initializers.map(_.value))))),
          cm.mutators.map(f => f.value(Ref(objName))),
          IArray(newed),
        )
      }

      Some(
        MethodTree(
          annotations = IArray(Annotation.Inline),
          level       = ProtectionLevel.Default,
          name        = name,
          tparams     = tparams,
          params      = IArray(cm.params),
          impl        = impl,
          resultType  = builderRef,
          isOverride  = false,
          comments    = NoComments,
          codePath    = ownerCp + name,
          isImplicit  = false,
        ),
      )
    }

  /* support directly using the companion as a builder if no required props */
  def genImplicitConversionOpt(
      conversionName: Name,
      ownerCp:        QualifiedName,
      tparams:        IArray[TypeParamTree],
      props:          SplitProps,
      builderRef:     TypeRef,
  ): Option[MethodTree] =
    if (props.hasRequiredProps) None
    else {
      val implicitConversion = {
        val param =
          ParamTree(
            Name("companion"),
            isImplicit = false,
            isVal      = false,
            TypeRef.Singleton(TypeRef(ownerCp.parts.last)),
            NotImplemented,
            NoComments,
          )

        val impl = {
          val newed = New(
            builderRef,
            IArray(
              Call(
                Ref(QualifiedName.Array),
                IArray(
                  IArray(Ref(QualifiedName(IArray(Name.THIS, names.component))), Ref(QualifiedName.DictionaryEmpty)),
                ),
              ),
            ),
          )
          Call(newed, IArray(IArray()))
        }

        MethodTree(
          annotations = Empty,
          level       = ProtectionLevel.Default,
          name        = conversionName,
          tparams     = tparams,
          params      = IArray(IArray(param)),
          impl        = impl,
          resultType  = builderRef,
          isOverride  = false,
          comments    = NoComments,
          codePath    = ownerCp + conversionName,
          isImplicit  = true,
        )

      }

      Some(implicitConversion)
    }

  def genPropsMethod(
      name:       Name,
      ownerCp:    QualifiedName,
      propsRef:   PropsRef,
      tparams:    IArray[TypeParamTree],
      builderRef: TypeRef,
  ): MethodTree = {
    val param = ParamTree(
      name       = Name("p"),
      isImplicit = false,
      isVal      = false,
      tpe        = propsRef.ref,
      default    = NotImplemented,
      comments   = NoComments,
    )
    val impl = {
      New(
        builderRef,
        IArray(
          Call(
            Ref(QualifiedName.Array),
            IArray(IArray(Ref(QualifiedName(IArray(Name.THIS, names.component))), Cast(Ref(param.name), TypeRef.Any))),
          ),
        ),
      )
    }
    MethodTree(
      annotations = Empty,
      level       = ProtectionLevel.Default,
      name        = name,
      tparams     = tparams,
      params      = IArray(IArray(param)),
      impl        = impl,
      resultType  = builderRef,
      isOverride  = false,
      comments    = NoComments,
      codePath    = ownerCp + name,
      isImplicit  = false,
    )
  }

  def genImportModule(c: Component, componentCp: QualifiedName): Tree =
    c.location match {
      case Left(intrinsic) =>
        FieldTree(
          annotations = Empty,
          name        = names.component,
          tpe         = TypeRef.String,
          impl        = intrinsic,
          isReadOnly  = true,
          isOverride  = false,
          comments    = NoComments,
          codePath    = componentCp + names.component,
        )
      case Right(location) =>
        FieldTree(
          annotations = IArray(Annotation.JsNative, location),
          name        = names.component,
          tpe         = TypeRef.Object,
          impl        = ExprTree.native,
          isReadOnly  = true,
          isOverride  = false,
          comments    = NoComments,
          codePath    = componentCp + names.component,
        )
    }

  def genBuilderClass(
      owner:                QualifiedName,
      name:                 Name,
      tparams:              IArray[TypeParamTree],
      buildingComponentRef: TypeRef,
      props:                IArray[Prop],
  ): Option[ClassTree] = {
    val clsCodePath = owner + name

    val members: IArray[MethodTree] =
      props.flatMap {
        case Prop.CompressedProp(name, tpe, asExpr, isRequired) =>
          val args1 = Call(Ref(genStBuilder.args.name), IArray(IArray(NumberLit("1"))))

          val (default, update) =
            if (isRequired) (NotImplemented, asExpr(args1))
            else (Null, If(BinaryOp(Ref(name), "!=", Null), asExpr(args1), None))

          val impl = Block(update, Ref(QualifiedName.THIS))

          val param = ParamTree(name, isImplicit = false, isVal = false, tpe, default, NoComments)

          IArray(
            MethodTree(
              annotations = IArray(Annotation.Inline),
              level       = ProtectionLevel.Default,
              name        = name,
              tparams     = Empty,
              params      = IArray(IArray(param)),
              impl        = impl,
              resultType  = TypeRef.ThisType(NoComments),
              isOverride  = false,
              comments    = NoComments,
              codePath    = clsCodePath + name,
              isImplicit  = false,
            ),
          )

        case prop: Prop.Normal =>
          val variantsForProp: Map[Name, Prop.Variant] = {
            val fromVariants: Map[Name, Prop.Variant] =
              prop.variants.filter(_.isRewritten).groupBy(param => nameFor(param.tpe)).map {
                case (alternativeName, IArray.first(one)) =>
                  Name(s"${prop.name.unescaped}${alternativeName.capitalize}") -> one
              }

            fromVariants.updated(prop.name, prop.main)
          }

          val variantsMethods: IArray[MethodTree] = variantsForProp.mapToIArray {
            case (methodName, Prop.Variant(tpe, asExpr, _, _)) =>
              val param = ParamTree(Name("value"), isImplicit = false, isVal = false, tpe, NotImplemented, NoComments)
              val impl = Call(
                Ref(genStBuilder.set.name),
                IArray(IArray(StringLit(prop.originalName.unescaped), asExpr(Ref(param.name)))),
              )
              MethodTree(
                annotations = IArray(Annotation.Inline),
                level       = ProtectionLevel.Default,
                name        = methodName,
                tparams     = Empty,
                params      = IArray(IArray(param)),
                impl        = impl,
                resultType  = TypeRef.ThisType(NoComments),
                isOverride  = false,
                comments    = NoComments,
                codePath    = clsCodePath + methodName,
                isImplicit  = false,
              )
          }

          val nullCaseOpt: Option[MethodTree] = prop.optionality match {
            case Optionality.Null | Optionality.NullOrUndef =>
              val impl = Call(
                Ref(genStBuilder.set.name),
                IArray(IArray(StringLit(prop.originalName.unescaped), Null)),
              )

              val name = Name(s"${prop.name.unescaped}Null")
              Some(
                MethodTree(
                  annotations = IArray(Annotation.Inline),
                  level       = ProtectionLevel.Default,
                  name        = name,
                  tparams     = Empty,
                  params      = Empty,
                  impl        = impl,
                  resultType  = TypeRef.ThisType(NoComments),
                  isOverride  = false,
                  comments    = NoComments,
                  codePath    = clsCodePath + name,
                  isImplicit  = false,
                ),
              )

            case _ => None
          }

          variantsMethods ++ IArray.fromOptions(nullCaseOpt)
        case _ => Empty
      }

    def ctor = CtorTree(
      ProtectionLevel.Default,
      IArray(
        ParamTree(
          Name("args"),
          isImplicit = false,
          isVal      = true,
          TypeRef(QualifiedName.Array, IArray(TypeRef.Any), NoComments),
          NotImplemented,
          NoComments,
        ),
      ),
      NoComments,
    )

    if (members.isEmpty && tparams.isEmpty) None
    else {
      Some(
        ClassTree(
          isImplicit  = false,
          annotations = IArray(Annotation.Inline),
          name        = name,
          tparams     = tparams,
          parents     = IArray.fromOption(genStBuilder.enableAnyVal) ++ IArray(buildingComponentRef),
          ctors       = IArray(ctor),
          members     = members.distinctBy(_.name.unescaped.toLowerCase),
          classType   = ClassType.Class,
          isSealed    = false,
          comments    = NoComments,
          codePath    = clsCodePath,
        ),
      )
    },
  }
}
