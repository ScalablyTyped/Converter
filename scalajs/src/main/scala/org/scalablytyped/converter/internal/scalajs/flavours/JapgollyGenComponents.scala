package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res

/**
  * Generate a package with japgolly's scalajs-react compatible react components
  */
final class JapgollyGenComponents(reactNames: ReactNames, findProps: FindProps) {
  import JapgollyGenComponents._

  def apply(scope: TreeScope, tree: ContainerTree, components: IArray[Component]): ContainerTree = {
    val pkgCp = tree.codePath + names.components

    val generatedCode: IArray[Tree] =
      IArray
        .fromTraversable(components.groupBy(c => (c.props, c.knownRef.isDefined, c.tparams)))
        .flatMap {
          case ((propsRefOpt, hasKnownRef, tparams), components) =>
            val (propsRef, resProps): (TypeRef, Res[IArray[Prop]]) =
              propsRefOpt match {
                case Some(propsRef) =>
                  val resProps: Res[FindProps.Filtered[Unit]] =
                    findProps.forType(
                      propsRef,
                      tparams,
                      scope,
                      maxNum             = FindProps.MaxParamsForMethod - additionalOptionalProps.length - /* children*/ 1,
                      acceptNativeTraits = true,
                      keep               = FindProps.keepAll,
                    )

                  propsRef -> resProps.map(_.yes)

                case None =>
                  TypeRef.Object -> Res.One(TypeRef.Object, Empty)
              }

            resProps match {
              case Res.Success(props) =>
                components match {
                  case IArray.exactlyOne(one) =>
                    IArray(genComponent(pkgCp, props, one.knownRef, tparams, one))
                  case many =>
                    /** We share `apply` methods for each props type in abstract classes to limit compilation time.
                      *  References causes some trouble, so if the component knows it we thread it through a type param.
                      */
                    val knownRefRewritten = if (hasKnownRef) Some(TypeRef(names.ComponentRef)) else None
                    val propsCls          = genSharedPropsClass(pkgCp, propsRef, props, knownRefRewritten, tparams)
                    IArray(propsCls) ++ many.map(genComponentForSharedProps(pkgCp, propsCls))
                }
              case Res.Error(_) =>
                components.map { c =>
                  val propsWithObject = TypeRef.Intersection(IArray(propsRef, TypeRef.Object), NoComments)
                  val (_, prop)       = FindProps.parentParameter(Name("props"), propsWithObject, isRequired = true)
                  val mod =
                    genComponent(pkgCp, Res.One(propsWithObject, IArray(prop)), c.knownRef, tparams, c)
                  val comment = Comment(
                    s"/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. */\n",
                  )
                  mod.copy(comments = mod.comments + comment)
                }
            }
        }

    generatedCode match {
      case IArray.Empty => tree
      case nonEmpty =>
        val newPackage = setCodePath(pkgCp, PackageTree(Empty, names.components, nonEmpty, NoComments, pkgCp))
        tree.withMembers(members = tree.members :+ newPackage)
    }
  }

  def genComponent(
      pkgCodePath:       QualifiedName,
      resProps:          Res.Success[IArray[Prop]],
      knownRefRewritten: Option[TypeRef],
      tparams:           IArray[TypeParamTree],
      c:                 Component,
  ): ModuleTree = {
    val componentCp = pkgCodePath + c.fullName

    val methods: IArray[MemberTree] =
      resProps match {
        case Res.One(propsRef, props) =>
          IArray(genCreator(Name.APPLY, propsRef, props, knownRefRewritten, tparams, componentCp))
        case Res.Many(propss) =>
          IArray.fromTraversable(propss.map {
            case (propsRef, props) =>
              genCreator(propsRef.name, propsRef, props, knownRefRewritten, tparams, componentCp)
          })
      }

    val componentRef = ModuleTree(
      annotations = IArray(Annotation.JsNative, c.location),
      name        = names.componentImport,
      parents     = Empty,
      members     = Empty,
      comments    = NoComments,
      codePath    = componentCp + names.componentImport,
      isOverride  = false,
    )

    ModuleTree(
      annotations = Empty,
      name        = c.fullName,
      parents     = Empty,
      members     = methods :+ componentRef,
      comments    = Comments(CommentData(Minimization.Keep(Empty))),
      codePath    = componentCp,
      isOverride  = false,
    )
  }

  def genSharedPropsClass(
      pkgCodePath:       QualifiedName,
      propsRef:          TypeRef,
      resProps:          Res.Success[IArray[Prop]],
      knownRefRewritten: Option[TypeRef],
      tparams:           IArray[TypeParamTree],
  ): ClassTree = {
    // todo: improve on this, but ensure unique
    val name = Name(
      s"SharedApply_${propsRef.name.unescaped}${(propsRef, knownRefRewritten, tparams).hashCode}"
        .replaceAllLiterally("-", "_"),
    )
    val classCp = pkgCodePath + name

    val componentRef = FieldTree(
      annotations = Empty,
      name        = names.componentImport,
      tpe         = TypeRef.Any,
      impl        = NotImplemented,
      isReadOnly  = true,
      isOverride  = false,
      comments    = NoComments,
      codePath    = classCp + names.componentImport,
    )

    val methods: IArray[MemberTree] =
      resProps match {
        case Res.One(propsRef, props) =>
          IArray(genCreator(Name.APPLY, propsRef, props, knownRefRewritten, tparams, classCp))
        case Res.Many(propss) =>
          IArray.fromTraversable(propss.map {
            case (propsRef, props) => genCreator(propsRef.name, propsRef, props, knownRefRewritten, tparams, classCp)
          })
      }

    val refInTParams =
      IArray.fromOption(knownRefRewritten.map(_ => TypeParamTree(names.ComponentRef, Empty, None, NoComments)))

    ClassTree(
      isImplicit  = false,
      annotations = Empty,
      name        = classCp.parts.last,
      tparams     = refInTParams,
      parents     = Empty,
      ctors       = Empty,
      members     = IArray(componentRef) ++ methods,
      classType   = ClassType.AbstractClass,
      isSealed    = false,
      comments    = NoComments,
      codePath    = classCp,
    )
  }

  def genComponentForSharedProps(pkgCodePath: QualifiedName, propsClass: ClassTree)(c: Component): ModuleTree = {
    val componentCp = pkgCodePath + c.fullName

    val componentRef = ModuleTree(
      annotations = IArray(Annotation.JsNative, c.location),
      name        = names.componentImport,
      parents     = Empty,
      members     = Empty,
      comments    = NoComments,
      codePath    = componentCp + names.componentImport,
      isOverride  = true,
    )

    ModuleTree(
      annotations = Empty,
      name        = c.fullName,
      parents     = IArray(TypeRef(propsClass.codePath, IArray.fromOption(c.knownRef.map(TypeRef.stripTargs)), NoComments)),
      members     = IArray(componentRef),
      comments    = Comments(CommentData(Minimization.Keep(Empty))),
      codePath    = componentCp,
      isOverride  = false,
    )
  }

  val isVdomNode = Set(
    reactNames.ReactNode,
    reactNames.ReactElement,
    japgolly.vdomVdomNode,
    japgolly.vdomReactElement,
    japgolly.vdomArray,
    japgolly.vdomTagOf,
  )

  def genCreator(
      name:              Name,
      propsRef:          TypeRef,
      props:             IArray[Prop],
      knownRefRewritten: Option[TypeRef],
      tparams:           IArray[TypeParamTree],
      ownerCp:           QualifiedName,
  ): MethodTree = {

    val (refTypes, declaredChildren, _, _optionals, requireds, Empty) = {
      props.partitionCollect5(
        { case Prop(Prop.Variant(ParamTree(names.ref, _, _, tpe, _, _), _, _), _, _, _) => tpe }, //refTypes
        // take note of declared children, but saying `ReactNode` should be a noop
        {
          case p @ Prop(Prop.Variant(ParamTree(names.children, _, _, tpe, _, _), _, _), _, _, _)
              if !isVdomNode(tpe.typeName) =>
            p
        }, //declaredChildren
        { case Prop(Prop.Variant(paramTree, _, _), _, _, _) if shouldIgnore(paramTree) => null },
        { case Prop(Prop.Variant(p, Right(f), _), _, _, _)                             => p -> f }, //optionals
        { case Prop(Prop.Variant(p, Left(expr), _), _, _, _)                           => p -> expr }, //requireds
      )
    }

    val optionals = _optionals ++ additionalOptionalProps

    /** Specified children different from react node? - Use `Children.None` and thread the value through the normal props.
      * The reason is that not all values are react nodes, and the API is limiting
      */
    val reactChildren = TypeRef(
      if (declaredChildren.isEmpty) japgolly.reactChildrenVarargs else japgolly.reactChildrenNone,
    )

    val (createWrapper, resultType) = knownRefRewritten orElse refTypes.headOption match {
      case Some(refType) =>
        val c = ExprTree.TApply(
          ExprTree.Ref(japgolly.reactJsForwardRefComponentForce),
          IArray(propsRef, reactChildren, refType),
        )
        val r =
          TypeRef(japgolly.componentUnmountedWithRoot, IArray(propsRef, refType, TypeRef.Unit, propsRef), NoComments)
        (c, r)
      case None =>
        val c =
          ExprTree.TApply(ExprTree.Ref(japgolly.reactJsComponent), IArray(propsRef, reactChildren, TypeRef.Object))
        val r = TypeRef(
          japgolly.componentJsUnmountedSimple,
          IArray(
            propsRef,
            TypeRef(
              japgolly.componentJsMountedWithRawType,
              IArray(
                propsRef,
                TypeRef.Object,
                TypeRef(japgolly.componentJsRawMounted, IArray(propsRef, TypeRef.Object), NoComments),
              ),
              NoComments,
            ),
          ),
          NoComments,
        )
        (c, r)
    }

    val firstParameterList: IArray[ParamTree] =
      requireds.map(_._1) ++ optionals.map(_._1) filterNot (_.name === names.children)

    val secondParameterList: IArray[ParamTree] = {
      IArray(
        declaredChildren.headOption match {
          case Some(param) => param.main.tree
          case None =>
            ParamTree(
              name       = names.children,
              isImplicit = false,
              isVal      = false,
              tpe        = TypeRef.Repeated(TypeRef(japgolly.reactChildArg), NoComments),
              default    = NotImplemented,
              comments   = NoComments,
            )
        },
      )
    }

    val impl = {
      import ExprTree._
      /* The children value can go in one of three places, depending... */
      val (requireds2, optionals2, varargsChildren: Option[IArray[Arg]]) =
        declaredChildren.headOption match {
          case Some(Prop(Prop.Variant(p, Left(expr), _), _, _, _)) => ((p -> expr) +: requireds, optionals, None)
          case Some(Prop(Prop.Variant(p, Right(f), _), _, _, _))   => (requireds, (p -> f) +: optionals, None)
          case None                                                => (requireds, optionals, Some(IArray(Arg.Variable(Ref(Name("children"))))))
        }

      val objName = Name("__obj")
      val f       = Name("f")

      Block.flatten(
        IArray(Val(objName, Call(Ref(QualifiedName.DynamicLiteral), IArray(requireds2.map(_._2))))),
        optionals2.map { case (_, f) => f(objName) },
        IArray(
          Val(
            f,
            Call(createWrapper, IArray(IArray(Ref(QualifiedName(IArray(Name.THIS, names.componentImport)))))),
          ),
          Call(Ref(f), IArray.fromOptions(Some(IArray(Cast(Ref(objName), propsRef))), varargsChildren)),
        ),
      )
    }

    MethodTree(
      annotations = Empty,
      level       = ProtectionLevel.Default,
      name        = name,
      tparams     = tparams,
      params      = IArray(firstParameterList, secondParameterList),
      impl        = impl,
      resultType  = resultType,
      isOverride  = false,
      comments    = NoComments,
      codePath    = ownerCp + name,
    )
  }
}

object JapgollyGenComponents {

  object names {
    val japgolly        = Name("japgolly")
    val components      = Name("components")
    val children        = Name("children")
    val ref             = Name("ref")
    val key             = Name("key")
    val componentImport = Name("componentImport")
    val ComponentRef    = Name("ComponentRef")

    val ignoredNames = Set(key, children)
  }

  def shouldIgnore(paramTree: ParamTree): Boolean =
    names.ignoredNames(paramTree.name)

  object japgolly {
    val react:                           QualifiedName = QualifiedName("japgolly.scalajs.react")
    val reactCallback:                   QualifiedName = react + Name("Callback")
    val reactCallbackTo:                 QualifiedName = react + Name("CallbackTo")
    val reactChildren:                   QualifiedName = react + Name("Children")
    val reactChildrenNone:               QualifiedName = reactChildren + Name("None")
    val reactChildrenVarargs:            QualifiedName = reactChildren + Name("Varargs")
    val reactJsComponent:                QualifiedName = react + Name("JsComponent")
    val reactJsForwardRefComponent:      QualifiedName = react + Name("JsForwardRefComponent")
    val reactJsForwardRefComponentForce: QualifiedName = reactJsForwardRefComponent + Name("force")
    val reactChildArg:                   QualifiedName = react + Name("CtorType") + Name("ChildArg")
    val reactReactEventFrom:             QualifiedName = react + Name("ReactEventFrom")
    val component:                       QualifiedName = react + Name("component")
    val componentUnmountedWithRoot:      QualifiedName = component + Name("JsForwardRef") + Name("UnmountedWithRoot")
    val componentJs:                     QualifiedName = component + Name("Js")
    val componentJsUnmountedSimple:      QualifiedName = componentJs + Name("UnmountedSimple")
    val componentJsMountedWithRawType:   QualifiedName = componentJs + Name("MountedWithRawType")
    val componentJsRawMounted:           QualifiedName = componentJs + Name("RawMounted")
    val vdom:                            QualifiedName = react + Name("vdom")
    val vdomTagMod:                      QualifiedName = vdom + Name("TagMod")
    val vdomTagOf:                       QualifiedName = vdom + Name("TagOf")
    val VdomAttr:                        QualifiedName = vdom + Name("VdomAttr")
    val vdomReactElement:                QualifiedName = vdom + Name("VdomElement")
    val vdomArray:                       QualifiedName = vdom + Name("VdomArray")
    val vdomVdomNode:                    QualifiedName = vdom + Name("VdomNode")
    val vdomVdomNodeCast:                QualifiedName = vdomVdomNode + Name("cast")
    val raw:                             QualifiedName = react + Name("raw")
    val rawReact:                        QualifiedName = raw + Name("React")
    val rawReactChildren:                QualifiedName = rawReact + Name("Children")
    val rawReactComponent:               QualifiedName = rawReact + Name("Component")
    val rawReactComponentClassP:         QualifiedName = rawReact + Name("ComponentClassP")
    val rawReactDOMElement:              QualifiedName = rawReact + Name("DomElement")
    val rawReactElement:                 QualifiedName = rawReact + Name("Element")
    val rawReactElementRef:              QualifiedName = rawReact + Name("ElementRef")
    val rawReactElementType:             QualifiedName = rawReact + Name("ElementType")
    val rawReactNode:                    QualifiedName = rawReact + Name("Node")
    val rawReactRef:                     QualifiedName = rawReact + Name("Ref")
    val rawReactRefHandle:               QualifiedName = rawReact + Name("RefHandle")
    val rawReactRefFn:                   QualifiedName = rawReact + Name("RefFn")
    val reactKey:                        QualifiedName = react + Name("Key")
  }

  val additionalOptionalProps: IArray[(ParamTree, Name => ExprTree)] = {
    import ExprTree._
    val keyName = Name("key")

    def keyUpdate(obj: Name) =
      Custom(
        s"""${keyName.value}.foreach(k => ${obj.value}.updateDynamic("key")(k.asInstanceOf[js.Any]))""",
      )

    val keyParam = ParamTree(
      name       = keyName,
      isImplicit = false,
      isVal      = false,
      tpe        = TypeRef.UndefOr(TypeRef(japgolly.reactKey)),
      default    = ExprTree.undefined,
      comments   = NoComments,
    )
    val _overrides = Name("_overrides")
    def overridesUpdate(obj: Name) =
      If(
        BinaryOp(Ref(_overrides), "!=", Null),
        Call(Ref(QualifiedName.DynamicGlobalObjectAssign), IArray(IArray(Ref(obj), Ref(_overrides)))),
        None,
      )

    val overridesParam = ParamTree(
      name       = _overrides,
      isImplicit = false,
      isVal      = false,
      tpe        = TypeRef.StringDictionary(TypeRef.Any, NoComments),
      default    = ExprTree.Null,
      comments   = NoComments,
    )
    IArray(keyParam -> keyUpdate, overridesParam -> overridesUpdate)
  }
}
