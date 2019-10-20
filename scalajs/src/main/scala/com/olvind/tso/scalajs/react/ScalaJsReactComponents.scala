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
object ScalaJsReactComponents {
  private object names {
    val ScalaJsReact = Name("ScalaJsReact")
    val children     = Name("children")
    val ref          = Name("ref")
    val key          = Name("key")

    val Ignored = Set(key, children)
  }

  private object scalaJsReact {
    val react:                           QualifiedName = QualifiedName("japgolly.scalajs.react")
    val reactCallback:                   QualifiedName = react + Name("Callback")
    val reactChildren:                   QualifiedName = react + Name("Children")
    val reactChildrenNone:               QualifiedName = reactChildren + Name("None")
    val reactChildrenVarargs:            QualifiedName = reactChildren + Name("Varargs")
    val reactJsComponent:                QualifiedName = react + Name("JsComponent")
    val reactJsForwardRefComponent:      QualifiedName = react + Name("JsForwardRefComponent")
    val reactJsForwardRefComponentForce: QualifiedName = reactJsForwardRefComponent + Name("force")
    val reactChildArg:                   QualifiedName = react + Name("CtorType") + Name("ChildArg")
    val component:                       QualifiedName = react + Name("component")
    val componentUnmountedWithRoot:      QualifiedName = component + Name("JsForwardRef") + Name("UnmountedWithRoot")
    val componentJs:                     QualifiedName = component + Name("Js")
    val componentJsUnmountedSimple:      QualifiedName = componentJs + Name("UnmountedSimple")
    val componentJsMountedWithRawType:   QualifiedName = componentJs + Name("MountedWithRawType")
    val componentJsRawMounted:           QualifiedName = componentJs + Name("RawMounted")
    val vdom:                            QualifiedName = react + Name("vdom")
    val vdomTagMod:                      QualifiedName = vdom + Name("TagMod")
    val VdomAttr:                        QualifiedName = vdom + Name("VdomAttr")
    val vdomReactElement:                QualifiedName = vdom + Name("VdomElement")
    val VdomArray:                       QualifiedName = vdom + Name("VdomArray")
    val vdomVdomNode:                    QualifiedName = vdom + Name("VdomNode")
    val vdomVdomNodeCast:                QualifiedName = vdomVdomNode + Name("cast")
    val raw:                             QualifiedName = react + Name("raw")
    val rawReact:                        QualifiedName = raw + Name("React")
    val rawReactChildren:                QualifiedName = rawReact + Name("Children")
    val rawReactComponent:               QualifiedName = rawReact + Name("Component")
    val rawReactComponentClassP:         QualifiedName = rawReact + Name("ComponentClassP")
    val rawReactNode:                    QualifiedName = rawReact + Name("Node")

    val scalaJsDomRaw = QualifiedName("org.scalajs.dom.raw")

    val conversions: Seq[CastConversion] =
      CastConversion.All ++ Seq(
        CastConversion(QualifiedName.ScalaAny, QualifiedName.Any, 0),
        CastConversion(QualifiedName.React.ComponentState, QualifiedName.Object, 0),
        CastConversion(QualifiedName.React.ReactDOM, QualifiedName.Any, 0),
        CastConversion(QualifiedName.React.ReactNode, rawReactNode, 0),
        CastConversion(QualifiedName.React.Component, scalaJsReact.rawReactComponent, 0),
        CastConversion(QualifiedName.React.ComponentClass, scalaJsReact.rawReactComponentClassP, 1),
        CastConversion(QualifiedName.React.BaseSyntheticEvent, react + Name("ReactEventFrom"), 1),
        CastConversion(QualifiedName.React.ChangeEvent, react + Name("ReactEventFrom"), 1),
        CastConversion(QualifiedName.React.InvalidEvent, react + Name("ReactEventFrom"), 1),
        CastConversion(QualifiedName.React.SyntheticEvent, react + Name("ReactEventFrom"), 1),
        CastConversion(QualifiedName.React.AnimationEvent, react + Name("ReactAnimationEventFrom"), 1),
        CastConversion(QualifiedName.React.ClipboardEvent, react + Name("ReactClipboardEventFrom"), 1),
        CastConversion(QualifiedName.React.CompositionEvent, react + Name("ReactCompositionEventFrom"), 1),
        CastConversion(QualifiedName.React.DragEvent, react + Name("ReactDragEventFrom"), 1),
        CastConversion(QualifiedName.React.FocusEvent, react + Name("ReactFocusEventFrom"), 1),
        CastConversion(QualifiedName.React.KeyboardEvent, react + Name("ReactKeyboardEventFrom"), 1),
        CastConversion(QualifiedName.React.MouseEvent, react + Name("ReactMouseEventFrom"), 1),
        CastConversion(QualifiedName.React.PointerEvent, react + Name("ReactPointerEventFrom"), 1),
        CastConversion(QualifiedName.React.TouchEvent, react + Name("ReactTouchEventFrom"), 1),
        CastConversion(QualifiedName.React.TransitionEvent, react + Name("ReactTransitionEventFrom"), 1),
        CastConversion(QualifiedName.React.UIEvent, react + Name("ReactUIEventFrom"), 1),
        CastConversion(QualifiedName.React.WheelEvent, react + Name("ReactWheelEventFrom"), 1),
        CastConversion(QualifiedName.React.NativeAnimationEvent, scalaJsDomRaw + Name("AnimationEvent"), 0),
        CastConversion(QualifiedName.React.NativeClipboardEvent, scalaJsDomRaw + Name("ClipboardEvent"), 0),
        CastConversion(QualifiedName.React.NativeCompositionEvent, scalaJsDomRaw + Name("CompositionEvent"), 0),
        CastConversion(QualifiedName.React.NativeDragEvent, scalaJsDomRaw + Name("DragEvent"), 0),
        CastConversion(QualifiedName.React.NativeFocusEvent, scalaJsDomRaw + Name("FocusEvent"), 0),
        CastConversion(QualifiedName.React.NativeKeyboardEvent, scalaJsDomRaw + Name("KeyboardEvent"), 0),
        CastConversion(QualifiedName.React.NativeMouseEvent, scalaJsDomRaw + Name("MouseEvent"), 0),
        CastConversion(QualifiedName.React.NativePointerEvent, scalaJsDomRaw + Name("PointerEvent"), 0),
        CastConversion(QualifiedName.React.NativeTouchEvent, scalaJsDomRaw + Name("TouchEvent"), 0),
        CastConversion(QualifiedName.React.NativeTransitionEvent, scalaJsDomRaw + Name(""), 0),
        CastConversion(QualifiedName.React.NativeUIEvent, scalaJsDomRaw + Name("TransitionEvent"), 0),
        CastConversion(QualifiedName.React.NativeWheelEvent, scalaJsDomRaw + Name("WheelEvent"), 0),
      )
  }

  val rewriter = TypeRewriterCast(scalaJsReact.conversions)

  private def memberParameter(scope: TreeScope, tree: MemberTree): Option[Param] =
    Companions
      .memberParameter(scope, tree)
      .map(
        p => p.copy(parameter = p.parameter.copy(tpe = rewriter.visitTypeRef(scope)(p.parameter.tpe))),
      ) map {
      case p @ Param(pt @ ParamTree(name, TypeRef.ScalaFunction(paramTypes, _), _, _), _, _) =>
        // rewrite functions returning a Callback so that javascript land can call them
        def fn(obj: String) = {
          val params =
            paramTypes.zipWithIndex
              .map { case (tpe, idx) => s"t$idx: ${Printer.formatTypeRef(0)(tpe)}" }
              .mkString(", ")
          val paramRefs = paramTypes.zipWithIndex.map { case (_, idx) => s"t$idx" }.mkString(", ")
          val rewrittenFn =
            s"js.Any.fromFunction${paramTypes.length}((($params) => ${name.value}($paramRefs).runNow()))"
          s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")($rewrittenFn)"""
        }

        p.copy(
          parameter = pt.copy(tpe = TypeRef.ScalaFunction(paramTypes, TypeRef(scalaJsReact.reactCallback), NoComments)),
          asString  = Right(fn),
        )

      case p @ Param(pt @ ParamTree(name, TypeRef(QualifiedName.React.ReactElement, _, _), _, _), _, _) =>
        def fn(obj: String) =
          s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")(${name.value}.rawElement.asInstanceOf[js.Any])"""
        p.copy(
          parameter = pt.copy(tpe = TypeRef(scalaJsReact.vdomReactElement)),
          asString  = Right(fn),
        )

      case p @ Param(pt @ ParamTree(name, TypeRef(scalaJsReact.rawReactNode, _, _), _, _), _, _) =>
        def fn(obj: String) =
          s"""if (${name.value} != null) $obj.updateDynamic("${name.unescaped}")(${name.value}.rawNode.asInstanceOf[js.Any])"""
        p.copy(
          parameter = pt.copy(tpe = TypeRef(scalaJsReact.vdomVdomNode)),
          asString  = Right(fn),
        )
      // In addition Consider replacing:
      // Scala collections
      // javascript collections. Only need to rewrite if type parameter is <:< TOJS
      // Other scalajs-react things we need to rewrite
      //  TagOf -> $target.render.rawElement.asInstanceOf[js.Any]
      // Other values. Keep AnyVal below at least CallbackTo
      case dontChange => dontChange
    }

  def apply(_scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
    components flatMap generateComponent(tree.codePath + names.ScalaJsReact, _scope / tree) match {
      case Nil => tree
      case nonEmpty =>
        val newPackage = PackageTree(Nil, names.ScalaJsReact, nonEmpty, NoComments, tree.codePath + names.ScalaJsReact)
        tree.withMembers(tree.members :+ newPackage)
    }

  def generateComponent(pkgCodePath: QualifiedName, scope: TreeScope)(c: Component): Option[ModuleTree] = {
    // accept components with no props, but not those with too complicated props (type aliases that ExpandTypeMappings doesnt expand yet)
    val propsParamsOpt: Option[(TypeRef, Seq[Param])] =
      c.props match {
        case Some(props) =>
          val paramsOpt: Option[Seq[Param]] =
            scope lookup FollowAliases(scope)(props).typeName collectFirst {
              case (cls: ClassTree, _) if cls.classType === ClassType.Trait =>
                ConstructObjectOfType(cls, scope)(memberParameter)
            }
          paramsOpt.map(ps => props -> ps)
        case None =>
          Some(TypeRef.Object -> Nil)
      }

    propsParamsOpt map {
      case (props, params) =>
        val componentCp = pkgCodePath + c.fullName

        val (refTypes, declaredChildren, _, optionals, inLiterals, Nil) =
          params.partitionCollect5(
            { case Param(ParamTree(names.ref, tpe, _, _), _, _) => tpe },
            // take note of declared children, but saying `ReactNode` should be a noop
            { case Param(ParamTree(names.children, t, _, _), _, _) if t.typeName =/= scalaJsReact.vdomVdomNode => t },
            { case Param(ParamTree(propName, _, _, _), _, _) if names.Ignored(propName)                        => () },
            { case Param(p, _, Right(f))                                                                       => p -> f },
            { case Param(p, _, Left(str))                                                                      => p -> str },
          )

        val childrenParam: ParamTree =
          declaredChildren.headOption match {
            case Some(param) => ParamTree(name = names.children, tpe = param, default = None, comments = param.comments)
            case _ =>
              ParamTree(
                name     = names.children,
                tpe      = TypeRef.Repeated(TypeRef(scalaJsReact.reactChildArg), NoComments),
                default  = None,
                comments = NoComments,
              )
          }

        val applyMethod = {
          val (createWrapper, resultType) = c.knownRef orElse refTypes.headOption match {
            case Some(refType) =>
              val c =
                TypeRef(
                  scalaJsReact.reactJsForwardRefComponentForce,
                  List(props, TypeRef(scalaJsReact.reactChildrenVarargs), refType),
                  NoComments,
                )
              val r =
                TypeRef(
                  scalaJsReact.componentUnmountedWithRoot,
                  List(props, refType, TypeRef.Unit, props),
                  NoComments,
                )
              (c, r)
            case None =>
              val c = TypeRef(
                scalaJsReact.reactJsComponent,
                List(props, TypeRef(scalaJsReact.reactChildrenVarargs), TypeRef.Object),
                NoComments,
              )
              val r = TypeRef(
                scalaJsReact.componentJsUnmountedSimple,
                List(
                  props,
                  TypeRef(
                    scalaJsReact.componentJsMountedWithRawType,
                    List(
                      props,
                      TypeRef.Object,
                      TypeRef(scalaJsReact.componentJsRawMounted, List(props, TypeRef.Object), NoComments),
                    ),
                    NoComments,
                  ),
                ),
                NoComments,
              )
              (c, r)
          }

          MethodTree(
            annotations = Nil,
            level       = ProtectionLevel.Default,
            name        = Name.APPLY,
            tparams     = c.tparams,
            params      = List(inLiterals.map(_._1) ++ optionals.map(_._1)) ++ List(List(childrenParam)),
            impl = {
              val formattedProps         = Printer.formatTypeRef(0)(props)
              val formattedComponent     = Component.formatReferenceTo(c.ref, c.componentType)
              val formattedCreateWrapper = Printer.formatTypeRef(0)(createWrapper)
              val formattedChildren = declaredChildren.headOption match {
                case Some(_) => Printer.formatQN(scalaJsReact.vdomVdomNodeCast) + "(children)"
                case None    => "children: _*"
              }

              MemberImpl.Custom(
                s"""{
               |  val __obj = js.Dynamic.literal(${inLiterals.map(_._2).mkString(", ")})
               |
               |  ${optionals.map { case (_, f) => "  " + f("__obj") }.mkString("\n")}
               |
               |  val f = $formattedCreateWrapper($formattedComponent)
               |  f(__obj.asInstanceOf[$formattedProps])($formattedChildren)
               |}""".stripMargin,
              )
            },
            resultType = resultType,
            isOverride = false,
            comments   = NoComments,
            codePath   = componentCp + Name.APPLY,
          )
        }

        ModuleTree(
          annotations = Nil,
          name        = c.fullName,
          parents     = Nil,
          members     = List(applyMethod),
          comments    = Comments(CommentData(Markers.VIP)),
          codePath    = componentCp,
        )
    }
  }
}
