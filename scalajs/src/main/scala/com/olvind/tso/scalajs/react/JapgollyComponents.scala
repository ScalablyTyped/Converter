package com.olvind.tso
package scalajs
package react

import com.olvind.tso.scalajs.ConstructObjectOfType.Param
import com.olvind.tso.scalajs.react.CastConversion.TypeRewriterCast
import com.olvind.tso.scalajs.transforms.Companions
import com.olvind.tso.seqs._

/**
  * Generate a package with japgolly's scalajs-react compatible react components
  */
object JapgollyComponents {
  private object names {
    val Japgolly     = Name("japgolly")
    val children     = Name("children")
    val ref          = Name("ref")
    val key          = Name("key")
    val component    = Name("__component")
    val ComponentRef = Name("ComponentRef")

    //Add here anything else that you want ignored
    private val ignoredNames = Set(key, children)

    def shouldIgnore(paramTree: ParamTree) = ignoredNames(paramTree.name)

  }

  private object japgolly {
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
    val rawReactDOMElement:              QualifiedName = rawReact + Name("DOMElement")
    val rawReactElement:                 QualifiedName = rawReact + Name("Element")
    val rawReactElementType:             QualifiedName = rawReact + Name("ElementType")
    val rawReactNode:                    QualifiedName = rawReact + Name("Node")
    val rawReactRef:                     QualifiedName = rawReact + Name("Ref")
    val reactKey:                        QualifiedName = react + Name("Key")

    val scalaJsDomRaw = QualifiedName("org.scalajs.dom.raw")

    val conversions: Seq[CastConversion] = {
      import CastConversion.TParam._
      val _1Element = _1.among(CastConversion.AllElements, QualifiedName("org.scalajs.dom.raw.Element"))
      val _2Element = _2.among(CastConversion.AllElements, QualifiedName("org.scalajs.dom.raw.Element"))
      val _1Object  = _1.among(Set.empty, QualifiedName.Object)

      CastConversion.All ++ Seq(
        CastConversion(QualifiedName.ScalaAny, QualifiedName.Any), // todo: is this needed?
        CastConversion(QualifiedName.WILDCARD, QualifiedName.Any), // todo: this should not leak out here
        CastConversion(QualifiedName.React.ComponentState, QualifiedName.Object),
        CastConversion(QualifiedName.React.ReactDOM, QualifiedName.Any),
        CastConversion(QualifiedName.React.ReactNode, rawReactNode),
        CastConversion(QualifiedName.React.Ref, rawReactRef),
        CastConversion(QualifiedName.React.Component, rawReactComponent, _1, TypeRef.Object),
        CastConversion(QualifiedName.React.ComponentClass, rawReactComponentClassP, _1Object),
        CastConversion(QualifiedName.React.ReactElement, rawReactElement),
        CastConversion(QualifiedName.React.DOMElement, rawReactDOMElement),
        CastConversion(QualifiedName.React.ElementType, rawReactElementType),
        CastConversion(QualifiedName.React.BaseSyntheticEvent, reactReactEventFrom, _2Element),
        CastConversion(QualifiedName.React.ChangeEvent, reactReactEventFrom, _1Element),
        CastConversion(QualifiedName.React.FormEvent, reactReactEventFrom, _1Element),
        CastConversion(QualifiedName.React.InvalidEvent, reactReactEventFrom, _1Element),
        CastConversion(QualifiedName.React.SyntheticEvent, reactReactEventFrom, _1Element),
        CastConversion(QualifiedName.React.AnimationEvent, react + Name("ReactAnimationEventFrom"), _1Element),
        CastConversion(QualifiedName.React.ClipboardEvent, react + Name("ReactClipboardEventFrom"), _1Element),
        CastConversion(QualifiedName.React.CompositionEvent, react + Name("ReactCompositionEventFrom"), _1Element),
        CastConversion(QualifiedName.React.DragEvent, react + Name("ReactDragEventFrom"), _1Element),
        CastConversion(QualifiedName.React.FocusEvent, react + Name("ReactFocusEventFrom"), _1Element),
        CastConversion(QualifiedName.React.KeyboardEvent, react + Name("ReactKeyboardEventFrom"), _1Element),
        CastConversion(QualifiedName.React.MouseEvent, react + Name("ReactMouseEventFrom"), _1Element),
        CastConversion(QualifiedName.React.PointerEvent, react + Name("ReactPointerEventFrom"), _1Element),
        CastConversion(QualifiedName.React.TouchEvent, react + Name("ReactTouchEventFrom"), _1Element),
        CastConversion(QualifiedName.React.TransitionEvent, react + Name("ReactTransitionEventFrom"), _1Element),
        CastConversion(QualifiedName.React.UIEvent, react + Name("ReactUIEventFrom"), _1Element),
        CastConversion(QualifiedName.React.WheelEvent, react + Name("ReactWheelEventFrom"), _1Element),
      )
    }
  }

  val rewriter = TypeRewriterCast(japgolly.conversions)

  val additionalOptionalParams: Seq[(ParamTree, String => String)] = {
    val keyUpdate: String => String = obj => s"""key.foreach(k => $obj.updateDynamic("key")(k.asInstanceOf[js.Any]))"""
    val keyParam = ParamTree(
      name     = Name("key"),
      tpe      = TypeRef.UndefOr(TypeRef(japgolly.reactKey)),
      default  = Some(TypeRef.undefined),
      comments = NoComments,
    )
    Seq(keyParam -> keyUpdate)
  }

  private def memberParameter(scope: TreeScope, tree: MemberTree): Option[Param] =
    Companions
      .memberParameter(scope, tree)
      .map(
        /* rewrite types after `memberParameter`, as it's resolving aliases, referencing superclasses and so on */
        p => p.copy(parameter = p.parameter.copy(tpe = rewriter.visitTypeRef(scope)(p.parameter.tpe))),
      ) map {
      case p @ Param(pt @ ParamTree(name, TypeRef.ScalaFunction(paramTypes, _), _, _), _, _) =>
        // rewrite functions returning a Callback so that javascript land can call them
        // this is more complicated than you think:
        // - There's no point in wrapping into () => Callback, just wrap into Callback (same with CallbackTo)
        // - If the member is optional, you have to wrap it into a js.UndefOr, Callback is AnyVal, so it's not nullable
        // - If the method return value is Unit, then convert it to Callback
        // - If the method return value is TYPE, then convert it to Callback[Type]

        def fn(obj: String) = {
          val params =
            paramTypes.zipWithIndex
              .map { case (tpe, idx) => s"t$idx: ${Printer.formatTypeRef(0)(tpe)}" }
              .mkString(", ")
          val paramRefs = paramTypes.zipWithIndex.map { case (_, idx) => s"t$idx" }.mkString(", ")

          pt.default.fold(
            s"""$obj.updateDynamic("${name.unescaped}")(js.Any.fromFunction${paramTypes.length}((($params) => ${name.unescaped}${if (paramRefs.isEmpty)
              ""
            else s"($paramRefs)"}.runNow())))""",
          )(
            _ =>
              s"""${name.value}.foreach(p => $obj.updateDynamic("${name.unescaped}")(js.Any.fromFunction${paramTypes.length}((($params) => p${if (paramRefs.isEmpty)
                ""
              else s"($paramRefs)"}.runNow()))))""",
          )
        }

        val retType = pt.tpe.targs.lastOption match {
          case Some(x) if x.name.unescaped.equals("Unit") => TypeRef(japgolly.reactCallback)
          case Some(x)                                    => TypeRef(japgolly.reactCallbackTo, List(x), NoComments)
          case None                                       => TypeRef(japgolly.reactCallback)
        }

        val newParam = paramTypes match {
          case Nil =>
            pt.default.fold(pt.copy(tpe = retType))(
              _ => pt.copy(tpe = TypeRef.UndefOr(retType), default = Some(TypeRef.undefined)),
            )
          case _ =>
            pt.default.fold(pt.copy(tpe = TypeRef.ScalaFunction(paramTypes, retType, NoComments)))(
              _ =>
                pt.copy(
                  tpe     = TypeRef.UndefOr(TypeRef.ScalaFunction(paramTypes, retType, NoComments)),
                  default = Some(TypeRef.undefined),
                ),
            )
        }

        p.copy(
          parameter = newParam,
          asString  = Right(fn),
        )

      case p @ Param(pt @ ParamTree(name, TypeRef(japgolly.rawReactElement, _, _), _, _), _, _) =>
        def fn(obj: String) =
          s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")(${name.value}.rawElement.asInstanceOf[js.Any])"""
        p.copy(
          parameter = pt.copy(tpe = TypeRef(japgolly.vdomReactElement)),
          asString  = Right(fn),
        )

      case p @ Param(pt @ ParamTree(name, TypeRef(japgolly.rawReactNode, _, _), _, _), _, _) =>
        def fn(obj: String) =
          s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")(${name.value}.rawNode.asInstanceOf[js.Any])"""
        p.copy(
          parameter = pt.copy(tpe = TypeRef(japgolly.vdomVdomNode)),
          asString  = Right(fn),
        )

      case dontChange => dontChange
    }

  def apply(_scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree = {
    val scope = _scope / tree
    val pkgCp = tree.codePath + names.Japgolly

    val generatedCode: Seq[Tree] =
      components
        .groupBy(c => (c.props, c.knownRef.isDefined, c.tparams))
        .to[Seq]
        .flatMap {
          case ((props, hasKnownRef, tparams), components) =>
            // accept components with no props, but not those with too complicated props (type aliases that ExpandTypeMappings doesnt expand yet)
            val propsParamsOpt: Option[(TypeRef, Seq[Param])] =
              props match {
                case Some(props) =>
                  val dealiased = FollowAliases(scope)(props)

                  val paramsOpt: Option[Seq[Param]] =
                    scope lookup dealiased.typeName collectFirst {
                      case (cls: ClassTree, newScope) if cls.classType === ClassType.Trait =>
                        ConstructObjectOfType(FillInTParams(cls, newScope, dealiased.targs, tparams), scope)(
                          memberParameter,
                        )
                    }

                  paramsOpt.map(params => props -> params)

                case None =>
                  Some(TypeRef.Object -> Nil)
              }

            propsParamsOpt.to[List].flatMap {
              case (props, params) =>
                components match {
                  case Seq(one) =>
                    List(genComponent(pkgCp, props, params, one.knownRef, tparams, one))
                  case many =>
                    /** We share `apply` methods for each props type in abstract classes to limit compilation time.
                      *  References causes some trouble, so if the component knows it we thread it through a type param.
                      */
                    val knownRefRewritten = if (hasKnownRef) Some(TypeRef(names.ComponentRef)) else None
                    val propsCls          = genSharedPropsClass(pkgCp, props, params, knownRefRewritten, tparams)
                    List(propsCls) ++ many.map(genComponentForSharedProps(pkgCp, propsCls))
                }
            }
        }

    generatedCode match {
      case Seq() => tree
      case nonEmpty =>
        val newPackage = PackageTree(Nil, names.Japgolly, nonEmpty, NoComments, pkgCp)
        tree.withMembers(tree.members :+ newPackage)
    }
  }

  def genComponent(
      pkgCodePath:       QualifiedName,
      props:             TypeRef,
      params:            Seq[Param],
      knownRefRewritten: Option[TypeRef],
      tparams:           Seq[TypeParamTree],
      c:                 Component,
  ): ModuleTree = {
    val componentCp  = pkgCodePath + c.fullName
    val componentRef = Component.formatReferenceTo(c.ref, c.componentType)
    val applyMethod  = genApply(props, params, knownRefRewritten, tparams, componentRef, componentCp)

    ModuleTree(
      annotations = Nil,
      name        = c.fullName,
      parents     = Nil,
      members     = List(applyMethod),
      comments    = Comments(CommentData(KeepOnlyReferenced.Keep(List(c.ref)))),
      codePath    = componentCp,
    )
  }

  def genSharedPropsClass(
      pkgCodePath:       QualifiedName,
      props:             TypeRef,
      params:            Seq[Param],
      knownRefRewritten: Option[TypeRef],
      tparams:           Seq[TypeParamTree],
  ): ClassTree = {
    // todo: improve on this, but ensure unique
    val name = Name(
      s"SharedApply_${props.name.unescaped}${(props, knownRefRewritten, tparams).hashCode}"
        .replaceAllLiterally("-", "_"),
    )
    val classCp = pkgCodePath + name

    val componentRef = MethodTree(
      annotations = Nil,
      level       = ProtectionLevel.Default,
      name        = names.component,
      tparams     = Nil,
      params      = Nil,
      impl        = MemberImpl.NotImplemented,
      resultType  = TypeRef.Any,
      isOverride  = false,
      comments    = NoComments,
      codePath    = classCp + names.component,
    )

    val applyMethod  = genApply(props, params, knownRefRewritten, tparams, names.component.unescaped, classCp)
    val refInTParams = knownRefRewritten.map(_ => TypeParamTree(names.ComponentRef, None, NoComments)).to[List]

    ClassTree(
      annotations = Nil,
      name        = classCp.parts.last,
      tparams     = refInTParams,
      parents     = Nil,
      ctors       = Nil,
      members     = List(componentRef, applyMethod),
      classType   = ClassType.AbstractClass,
      isSealed    = false,
      comments    = NoComments,
      codePath    = classCp,
    )
  }

  def genComponentForSharedProps(pkgCodePath: QualifiedName, propsClass: ClassTree)(c: Component): ModuleTree = {
    val componentCp = pkgCodePath + c.fullName

    val componentRef = FieldTree(
      annotations = Nil,
      name        = names.component,
      tpe         = TypeRef.Any,
      impl        = MemberImpl.Custom(Component.formatReferenceTo(SlinkyComponents.stripTargs(c.ref), c.componentType)),
      isReadOnly  = true,
      isOverride  = true,
      comments    = NoComments,
      codePath    = componentCp + names.component,
    )

    ModuleTree(
      annotations = Nil,
      name        = c.fullName,
      parents     = List(TypeRef(propsClass.codePath, c.knownRef.map(SlinkyComponents.stripTargs).to[List], NoComments)),
      members     = List(componentRef),
      comments    = Comments(CommentData(KeepOnlyReferenced.Keep(List(c.ref)))),
      codePath    = componentCp,
    )
  }

  def isVdomNode(tpe: TypeRef) =
    tpe.typeName == japgolly.vdomVdomNode || tpe.typeName == japgolly.vdomReactElement ||
      tpe.typeName == japgolly.vdomArray || tpe.typeName == japgolly.vdomTagOf

  def genApply(
      props:             TypeRef,
      params:            Seq[Param],
      knownRefRewritten: Option[TypeRef],
      tparams:           Seq[TypeParamTree],
      componentRef:      String,
      ownerCp:           QualifiedName,
  ): MethodTree = {

    val (refTypes, declaredChildren, _, _optionals, requireds, Nil) = {
      params.partitionCollect5(
        { case Param(ParamTree(names.ref, tpe, _, _), _, _) => tpe }, //refTypes
        // take note of declared children, but saying `ReactNode` should be a noop
        { case p @ Param(ParamTree(names.children, tpe, _, _), _, _) if !isVdomNode(tpe) => p }, //declaredChildren
        { case Param(paramTree, _, _) if names.shouldIgnore(paramTree)                   => () },
        { case Param(p, _, Right(f))                                                     => p -> f }, //optionals
        { case Param(p, _, Left(str))                                                    => p -> str }, //requireds
      )
    }

    val optionals = _optionals ++ additionalOptionalParams

    /** Specified children different from react node? - Use `Children.None` and thread the value through the normal props.
      * The reason is that not all values are react nodes, and the API is limiting
      */
    val reactChildren = TypeRef(
      if (declaredChildren.isEmpty) japgolly.reactChildrenVarargs else japgolly.reactChildrenNone,
    )

    val (createWrapper, resultType) = knownRefRewritten orElse refTypes.headOption match {
      case Some(refType) =>
        val c = TypeRef(japgolly.reactJsForwardRefComponentForce, List(props, reactChildren, refType), NoComments)
        val r = TypeRef(japgolly.componentUnmountedWithRoot, List(props, refType, TypeRef.Unit, props), NoComments)
        (c, r)
      case None =>
        val c = TypeRef(japgolly.reactJsComponent, List(props, reactChildren, TypeRef.Object), NoComments)
        val r = TypeRef(
          japgolly.componentJsUnmountedSimple,
          List(
            props,
            TypeRef(
              japgolly.componentJsMountedWithRawType,
              List(
                props,
                TypeRef.Object,
                TypeRef(japgolly.componentJsRawMounted, List(props, TypeRef.Object), NoComments),
              ),
              NoComments,
            ),
          ),
          NoComments,
        )
        (c, r)
    }

    val firstParameterList: Seq[ParamTree] =
      requireds.map(_._1) ++ optionals.map(_._1) filterNot (_.name === names.children)

    val secondParameterList = {
      List(
        declaredChildren.headOption match {
          case Some(param) => param.parameter
          case None =>
            ParamTree(
              name     = names.children,
              tpe      = TypeRef.Repeated(TypeRef(japgolly.reactChildArg), NoComments),
              default  = None,
              comments = NoComments,
            )
        },
      )
    }

    val impl = {
      val formattedProps         = Printer.formatTypeRef(0)(props)
      val formattedCreateWrapper = Printer.formatTypeRef(0)(createWrapper)

      /* The children value can go in one of three places, depending... */
      val (requireds2, optionals2, formattedVarargsChildren) =
        declaredChildren.headOption match {
          case Some(Param(p, _, Left(str))) => ((p -> str) +: requireds, optionals, "")
          case Some(Param(p, _, Right(f)))  => (requireds, (p -> f) +: optionals, "")
          case None                         => (requireds, optionals, "(children: _*)")
        }

      MemberImpl.Custom(
        s"""{
           |  val __obj = js.Dynamic.literal(${requireds2.map(_._2).mkString(", ")})
           |
           |  ${optionals2.map { case (_, f) => "  " + f("__obj") }.mkString("\n")}
           |
           |  val f = $formattedCreateWrapper($componentRef)
           |  f(__obj.asInstanceOf[$formattedProps])$formattedVarargsChildren
           |}""".stripMargin,
      )
    }

    MethodTree(
      annotations = Nil,
      level       = ProtectionLevel.Default,
      name        = Name.APPLY,
      tparams     = tparams,
      params      = List(firstParameterList, secondParameterList),
      impl        = impl,
      resultType  = resultType,
      isOverride  = false,
      comments    = NoComments,
      codePath    = ownerCp + Name.APPLY,
    )
  }
}
