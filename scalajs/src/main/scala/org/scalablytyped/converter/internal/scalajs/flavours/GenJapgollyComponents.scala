package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.flavours.FindProps.Res

/**
  * Generate a package with japgolly's scalajs-react compatible react components
  */
object GenJapgollyComponents {

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

  /**
    *- If the method return value is Unit, then convert it to Callback
    *- If the method return value is TYPE, then convert it to Callback[Type]
    */
  def CallbackTo(ref: TypeRef): TypeRef =
    ref match {
      case TypeRef.Unit => TypeRef(japgolly.reactCallback)
      case other        => TypeRef(japgolly.reactCallbackTo, IArray(other), NoComments)
    }
}

final class GenJapgollyComponents(reactNames: ReactNames, scalaJsDomNames: ScalaJsDomNames, findProps: FindProps) {
  import GenJapgollyComponents._

  val conversions: IArray[CastConversion] = {
    import CastConversion.TParam._
    import japgolly._

    val _1Element = _1.among(scalaJsDomNames.AllElements, QualifiedName("org.scalajs.dom.raw.Element"))
    val _2Element = _2.among(scalaJsDomNames.AllElements, QualifiedName("org.scalajs.dom.raw.Element"))
    val _1Object  = _1.among(Set.empty, QualifiedName.Object)

    scalaJsDomNames.AllExceptDeprecated ++ IArray(
      CastConversion(QualifiedName.ScalaAny, QualifiedName.Any), // todo: is this needed?
      CastConversion(reactNames.ComponentState, QualifiedName.Object),
      CastConversion(reactNames.ReactDOM, QualifiedName.Any),
      CastConversion(reactNames.ReactNode, rawReactNode),
      CastConversion(reactNames.Ref, rawReactRef),
      CastConversion(reactNames.RefObject, rawReactRefHandle, _1),
      CastConversion(reactNames.Component, rawReactComponent, _1Object, TypeRef.Object),
      CastConversion(reactNames.ComponentClass, rawReactComponentClassP, _1Object),
      CastConversion(reactNames.ReactElement, rawReactElement),
      CastConversion(reactNames.DOMElement, rawReactDOMElement),
      CastConversion(reactNames.ElementType, rawReactElementType),
      CastConversion(reactNames.BaseSyntheticEvent, reactReactEventFrom, _2Element),
      CastConversion(reactNames.ChangeEvent, reactReactEventFrom, _1Element),
      CastConversion(reactNames.FormEvent, reactReactEventFrom, _1Element),
      CastConversion(reactNames.InvalidEvent, reactReactEventFrom, _1Element),
      CastConversion(reactNames.SyntheticEvent, reactReactEventFrom, _1Element),
      CastConversion(reactNames.AnimationEvent, react + Name("ReactAnimationEventFrom"), _1Element),
      CastConversion(reactNames.ClipboardEvent, react + Name("ReactClipboardEventFrom"), _1Element),
      CastConversion(reactNames.CompositionEvent, react + Name("ReactCompositionEventFrom"), _1Element),
      CastConversion(reactNames.DragEvent, react + Name("ReactDragEventFrom"), _1Element),
      CastConversion(reactNames.FocusEvent, react + Name("ReactFocusEventFrom"), _1Element),
      CastConversion(reactNames.KeyboardEvent, react + Name("ReactKeyboardEventFrom"), _1Element),
      CastConversion(reactNames.MouseEvent, react + Name("ReactMouseEventFrom"), _1Element),
      CastConversion(reactNames.PointerEvent, react + Name("ReactPointerEventFrom"), _1Element),
      CastConversion(reactNames.TouchEvent, react + Name("ReactTouchEventFrom"), _1Element),
      CastConversion(reactNames.TransitionEvent, react + Name("ReactTransitionEventFrom"), _1Element),
      CastConversion(reactNames.UIEvent, react + Name("ReactUIEventFrom"), _1Element),
      CastConversion(reactNames.WheelEvent, react + Name("ReactWheelEventFrom"), _1Element),
    )
  }

  val ToJapgollyTypes = TypeRewriterCast(conversions)

  val additionalOptionalProps: IArray[(ParamTree, String => String)] = {
    val keyUpdate: String => String = obj => s"""key.foreach(k => $obj.updateDynamic("key")(k.asInstanceOf[js.Any]))"""
    val keyParam = ParamTree(
      name       = Name("key"),
      isImplicit = false,
      tpe        = TypeRef.UndefOr(TypeRef(japgolly.reactKey)),
      default    = Some(TypeRef.undefined),
      comments   = NoComments,
    )

    val overridesUpdate: String => String = obj =>
      s"if (_overrides != null) js.Dynamic.global.Object.assign($obj, _overrides)"
    val overridesParam = ParamTree(
      name       = Name("_overrides"),
      isImplicit = false,
      tpe        = TypeRef.StringDictionary(TypeRef.Any, NoComments),
      default    = Some(TypeRef.`null`),
      comments   = NoComments,
    )
    IArray(keyParam -> keyUpdate, overridesParam -> overridesUpdate)
  }

  val memberToProp: MemberToProp = (scope, x) => {

    object StripWildcards {
      def unapply(tr: TypeRef): Some[TypeRef] =
        Some(Wildcards.Remove.visitTypeRef(scope)(tr))

      def unapply(trs: IArray[TypeRef]): Some[IArray[TypeRef]] =
        Some(trs.map(Wildcards.Remove.visitTypeRef(scope)))
    }

    MemberToProp
      .Default(scope, x)
      .map(p => p.copy(parameter = ToJapgollyTypes.visitParamTree(scope)(p.parameter)))
      .map {
        /* rewrite functions returning a Callback so that javascript land can call them */
        case p @ Prop(
              pt @ ParamTree(name, _, TypeRef.ScalaFunction(Empty, StripWildcards(retType)), Some(_), _),
              _,
              _,
            ) =>
          /* wrap optional `Callback` in `js.UndefOr` because it's an `AnyVal` */
          p.copy(
            parameter = pt.copy(tpe = TypeRef.UndefOr(CallbackTo(retType)), default = Some(TypeRef.undefined)),
            asString = Right { obj =>
              s"""${name.value}.foreach(p => $obj.updateDynamic("${name.unescaped}")(p.toJsFn))"""
            },
          )

        case p @ Prop(pt @ ParamTree(name, _, TypeRef.ScalaFunction(Empty, StripWildcards(retType)), None, _), _, _) =>
          p.copy(
            parameter = pt.copy(tpe = CallbackTo(retType)),
            asString  = Right(obj => s"""$obj.updateDynamic("${name.unescaped}")(${name.value}.toJsFn)"""),
          )

        case p @ Prop(
              pt @ ParamTree(
                name,
                _,
                TypeRef.ScalaFunction(StripWildcards(paramTypes), StripWildcards(retType)),
                defaultValue,
                _,
              ),
              _,
              _,
            ) =>
          def fn(obj: String) = {
            val params =
              paramTypes.zipWithIndex
                .map { case (tpe, idx) => s"t$idx: ${Printer.formatTypeRef(0)(tpe)}" }
                .mkString(", ")
            val paramRefs = paramTypes.zipWithIndex.map { case (_, idx) => s"t$idx" }.mkString(", ")
            val rewrittenFn =
              s"js.Any.fromFunction${paramTypes.length}(($params) => ${name.value}($paramRefs).runNow())"

            defaultValue match {
              case Some(_) => s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")($rewrittenFn)"""
              case None    => s"""$obj.updateDynamic("${name.unescaped}")($rewrittenFn)"""
            }
          }

          val newRetType = TypeRef.ScalaFunction(paramTypes, CallbackTo(retType), NoComments)

          p.copy(
            parameter = pt.copy(tpe = newRetType, default = defaultValue.map(_ => TypeRef.`null`)),
            asString  = Right(fn),
          )

        case p @ Prop(pt @ ParamTree(name, _, TypeRef(japgolly.rawReactElement, _, _), _, _), _, _) =>
          def fn(obj: String) =
            s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")(${name.value}.rawElement.asInstanceOf[js.Any])"""
          p.copy(
            parameter = pt.copy(tpe = TypeRef(japgolly.vdomReactElement)),
            asString  = Right(fn),
          )

        case p @ Prop(pt @ ParamTree(name, _, TypeRef(japgolly.rawReactNode, _, _), _, _), _, _) =>
          def fn(obj: String) =
            s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")(${name.value}.rawNode.asInstanceOf[js.Any])"""
          p.copy(
            parameter = pt.copy(tpe = TypeRef(japgolly.vdomVdomNode)),
            asString  = Right(fn),
          )

        case dontChange => dontChange
      }
  }

  def apply(scope: TreeScope, tree: ContainerTree, components: IArray[Component]): ContainerTree = {
    val pkgCp = tree.codePath + names.components

    val generatedCode: IArray[Tree] =
      IArray
        .fromTraversable(
          components
            .map(_.rewritten(scope, ToJapgollyTypes))
            .groupBy(c => (c.props, c.knownRef.isDefined, c.tparams)),
        )
        .flatMap {
          case ((propsRefOpt, hasKnownRef, tparams), components) =>
            val (propsRef, resProps): (TypeRef, Res[IArray[Prop]]) =
              propsRefOpt match {
                case Some(propsRef) =>
                  val resProps: Res[IArray[Prop]] =
                    findProps.forType(
                      propsRef,
                      tparams,
                      scope,
                      memberToProp,
                      maxNum             = FindProps.MaxParamsForMethod - additionalOptionalProps.length - /* children*/ 1,
                      acceptNativeTraits = true,
                    )

                  propsRef -> resProps

                case None =>
                  TypeRef.Object -> Res.One(TypeRef.Object.name, Empty)
              }

            resProps match {
              case Res.Success(props) =>
                components match {
                  case IArray.exactlyOne(one) =>
                    IArray(genComponent(pkgCp, propsRef, props, one.knownRef, tparams, one))
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
                  val propsWithObject  = TypeRef.Intersection(IArray(propsRef, TypeRef.Object))
                  val (_, Left(param)) = FindProps.parentParameter(Name("props"), propsWithObject, isRequired = true)
                  val mod =
                    genComponent(pkgCp, propsWithObject, Res.One(propsRef.name, IArray(param)), c.knownRef, tparams, c)
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
      propsRef:          TypeRef,
      resProps:          Res.Success[IArray[Prop]],
      knownRefRewritten: Option[TypeRef],
      tparams:           IArray[TypeParamTree],
      c:                 Component,
  ): ModuleTree = {
    val componentCp = pkgCodePath + c.fullName

    val methods: IArray[MemberTree] =
      resProps match {
        case Res.One(_, props) =>
          IArray(genCreator(Name.APPLY, propsRef, props, knownRefRewritten, tparams, componentCp))
        case Res.Many(propss) =>
          IArray.fromTraversable(propss.map {
            case (name, props) => genCreator(name, propsRef, props, knownRefRewritten, tparams, componentCp)
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
      impl        = MemberImpl.NotImplemented,
      isReadOnly  = true,
      isOverride  = false,
      comments    = NoComments,
      codePath    = classCp + names.componentImport,
    )

    val methods: IArray[MemberTree] =
      resProps match {
        case Res.One(_, props) =>
          IArray(genCreator(Name.APPLY, propsRef, props, knownRefRewritten, tparams, classCp))
        case Res.Many(propss) =>
          IArray.fromTraversable(propss.map {
            case (name, props) => genCreator(name, propsRef, props, knownRefRewritten, tparams, classCp)
          })
      }

    val refInTParams =
      IArray.fromOption(knownRefRewritten.map(_ => TypeParamTree(names.ComponentRef, None, NoComments)))

    ClassTree(
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

  def isVdomNode(tpe: TypeRef) =
    tpe.typeName == japgolly.vdomVdomNode || tpe.typeName == japgolly.vdomReactElement ||
      tpe.typeName == japgolly.vdomArray || tpe.typeName == japgolly.vdomTagOf

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
        { case Prop(ParamTree(names.ref, _, tpe, _, _), _, _) => tpe }, //refTypes
        // take note of declared children, but saying `ReactNode` should be a noop
        { case p @ Prop(ParamTree(names.children, _, tpe, _, _), _, _) if !isVdomNode(tpe) => p }, //declaredChildren
        { case Prop(paramTree, _, _) if shouldIgnore(paramTree)                            => null },
        { case Prop(p, Right(f), _)                                                        => p -> f }, //optionals
        { case Prop(p, Left(str), _)                                                       => p -> str }, //requireds
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
        val c = TypeRef(japgolly.reactJsForwardRefComponentForce, IArray(propsRef, reactChildren, refType), NoComments)
        val r =
          TypeRef(japgolly.componentUnmountedWithRoot, IArray(propsRef, refType, TypeRef.Unit, propsRef), NoComments)
        (c, r)
      case None =>
        val c = TypeRef(japgolly.reactJsComponent, IArray(propsRef, reactChildren, TypeRef.Object), NoComments)
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

    val secondParameterList = {
      IArray(
        declaredChildren.headOption match {
          case Some(param) => param.parameter
          case None =>
            ParamTree(
              name       = names.children,
              isImplicit = false,
              tpe        = TypeRef.Repeated(TypeRef(japgolly.reactChildArg), NoComments),
              default    = None,
              comments   = NoComments,
            )
        },
      )
    }

    val impl = {
      val formattedProps         = Printer.formatTypeRef(0)(propsRef)
      val formattedCreateWrapper = Printer.formatTypeRef(0)(createWrapper)

      /* The children value can go in one of three places, depending... */
      val (requireds2, optionals2, formattedVarargsChildren) =
        declaredChildren.headOption match {
          case Some(Prop(p, Left(str), _)) => ((p -> str) +: requireds, optionals, "")
          case Some(Prop(p, Right(f), _))  => (requireds, (p -> f) +: optionals, "")
          case None                        => (requireds, optionals, "(children: _*)")
        }

      MemberImpl.Custom(
        s"""{
           |  val __obj = js.Dynamic.literal(${requireds2.map(_._2).mkString(", ")})
           |
           |  ${optionals2.map { case (_, f) => "  " + f("__obj") }.mkString("\n")}
           |
           |  val f = $formattedCreateWrapper(this.${names.componentImport.value})
           |  f(__obj.asInstanceOf[$formattedProps])$formattedVarargsChildren
           |}""".stripMargin,
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
